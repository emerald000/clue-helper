package com.emerald000.cluehelper;

import com.emerald000.cluehelper.clues.CharlieClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.FaloClue;
import com.emerald000.cluehelper.clues.HotColdClue;
import com.emerald000.cluehelper.clues.SherlockClue;
import com.emerald000.cluehelper.clues.UnreadBeginnerClue;
import com.emerald000.cluehelper.clues.UnreadMasterClue;
import com.emerald000.cluehelper.cluesteps.BeginnerClues;
import com.emerald000.cluehelper.cluesteps.EasyClues;
import com.emerald000.cluehelper.cluesteps.HardClues;
import com.emerald000.cluehelper.cluesteps.MasterClues;
import com.emerald000.cluehelper.cluesteps.MediumClues;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.NPCLocationInterface;
import com.emerald000.cluehelper.locations.ObjectLocationInterface;
import com.emerald000.cluehelper.modules.ClueModule;
import com.emerald000.cluehelper.modules.ObjectHighlightModule;
import com.emerald000.cluehelper.modules.QuestionModule;
import com.google.common.base.MoreObjects;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Menu;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.annotations.Component;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PostMenuSort;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginMessage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Slf4j
@PluginDescriptor(
        name = "Clue Helper"
)
public class ClueHelperPlugin extends Plugin {

    @Inject
    @Getter
    private ClueHelperConfig config;

    @Inject
    @Getter
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ClueHelperWorldOverlay clueHelperWorldOverlay;

    @Inject
    private ClueHelperOverlayPanel clueHelperOverlayPanel;

    @Inject
    private ClueHelperEmoteOverlay clueHelperEmoteOverlay;

    @Inject
    private ClueHelperMusicOverlay clueHelperMusicOverlay;

    @Inject
    private WorldMapPointManager worldMapPointManager;

    @Inject
    @Getter
    private ItemManager itemManager;

    @Inject
    private EventBus eventBus;

    private final Map<ClueTier, BufferedImage> worldMapImages = new EnumMap<>(ClueTier.class);

    @Nullable
    @Getter
    private Clue activeClue;

    @Getter
    private final Set<GameObject> highlightedObjects = new HashSet<>(0);

    @Getter
    private final Set<NPC> highlightedNPCs = new HashSet<>(0);

    @Getter
    private final Set<WorldPoint> stashesUsed = new HashSet<>(0);

    @Nullable
    private WorldPoint lastStashClicked = null;

    public static final Color TEXT_COLOUR = new Color(190, 190, 190);

    private static final Pattern TRIPLE_CRYPTIC_REGEX = Pattern.compile("<br><br>");

    @Override
    protected final void startUp() {
        overlayManager.add(clueHelperWorldOverlay);
        overlayManager.add(clueHelperOverlayPanel);
        overlayManager.add(clueHelperEmoteOverlay);
        overlayManager.add(clueHelperMusicOverlay);
        log.info("Clue Helper started");
    }

    @Override
    protected final void shutDown() {
        overlayManager.remove(clueHelperWorldOverlay);
        overlayManager.remove(clueHelperOverlayPanel);
        overlayManager.remove(clueHelperEmoteOverlay);
        overlayManager.remove(clueHelperMusicOverlay);
        highlightedObjects.clear();
        highlightedNPCs.clear();
        stashesUsed.clear();
        worldMapImages.clear();
        activeClue = null;
        lastStashClicked = null;
        log.info("Clue Helper stopped");
    }

    @Provides
    static ClueHelperConfig provideConfig(final ConfigManager configManager) {
        return configManager.getConfig(ClueHelperConfig.class);
    }

    @Subscribe
    public final void onItemContainerChanged(final ItemContainerChanged event) {
        if (event.getItemContainer() == client.getItemContainer(InventoryID.INVENTORY)) {
            if (activeClue != null) {
                if (!event.getItemContainer().contains(activeClue.getClueId())) {
                    processRemoveClue();
                }
            }
            if (activeClue == null) {
                for (final Item item : event.getItemContainer().getItems()) {
                    final Clue clue = getClueFromId(item.getId());
                    if (clue != null) {
                        processNewActiveClue(clue);
                    }
                }
            }
        }
    }

    @Subscribe
    public final void onWidgetLoaded(final WidgetLoaded event) {
        // Read a beginner clue
        if (activeClue instanceof UnreadBeginnerClue) {
            // Check for text clue
            if (event.getGroupId() == InterfaceID.CLUESCROLL) {
                clientThread.invokeLater(() -> {
                    final Widget clueScrollText = client.getWidget(ComponentID.CLUESCROLL_TEXT);
                    if (clueScrollText != null) {
                        final Clue clue = BeginnerClues.getClue(clueScrollText.getText());
                        if (clue != null) {
                            processNewActiveClue(clue);
                        }
                    }
                });
            }
            // Check for map clue
            else {
                final Clue clue = BeginnerClues.getClue(event.getGroupId());
                if (clue != null) {
                    processNewActiveClue(clue);
                }
            }
        }
        // Read dialog from Charlie
        else if (activeClue instanceof CharlieClue) {
            final CharlieClue charlieClue = (CharlieClue) activeClue;
            if (!charlieClue.isItemKnown() && event.getGroupId() == InterfaceID.DIALOG_NPC) {
                clientThread.invokeLater(() -> {
                    final Widget dialogWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
                    if (dialogWidget != null) {
                        final String dialog = dialogWidget.getText();
                        // TODO: Remove
                        log.info(dialog);
                        final Clue updatedClue = CharlieClue.parseDialog(dialog);
                        if (updatedClue != null) {
                            processRemoveClue();
                            processNewActiveClue(updatedClue);
                        }
                    }
                });
            }
        }
        // Read a master clue
        else if (activeClue instanceof UnreadMasterClue) {
            // Check for text clue
            if (event.getGroupId() == InterfaceID.CLUESCROLL) {
                clientThread.invokeLater(() -> {
                    final Widget clueScrollText = client.getWidget(ComponentID.CLUESCROLL_TEXT);
                    if (clueScrollText != null) {
                        // Check for triple cryptic clue
                        // TODO: Load all three
                        final String[] splitString = TRIPLE_CRYPTIC_REGEX.split(clueScrollText.getText());
                        if (splitString.length == 3) {
                            for (final String step : splitString) {
                                final Clue clue = MasterClues.getClue(step);
                                if (clue != null) {
                                    processNewActiveClue(clue);
                                    break;
                                }
                            }
                        } else {
                            final Clue clue = MasterClues.getClue(clueScrollText.getText());
                            if (clue != null) {
                                processNewActiveClue(clue);
                            }
                        }
                    }
                });
            }
        }
        // Read dialog from Sherlock
        else if (activeClue instanceof SherlockClue) {
            final SherlockClue sherlockClue = (SherlockClue) activeClue;
            if (!sherlockClue.isChallengeKnown() && event.getGroupId() == InterfaceID.DIALOG_NPC) {
                clientThread.invokeLater(() -> {
                    final Widget dialogWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
                    if (dialogWidget != null) {
                        final String dialog = dialogWidget.getText();
                        // TODO: Remove
                        log.info(dialog);
                        if (dialog.equals("Ah, just what I was looking for. I have a challenge for<br>you. If you complete it, I'll give you something.")) {
                            processRemoveClue();
                            processNewActiveClue(MasterClues.getUnreadClue());
                        }
                    }
                });
            }
        }
        // Read dialog from Falo
        else if (activeClue instanceof FaloClue) {
            final FaloClue faloClue = (FaloClue) activeClue;
            if (!faloClue.isItemKnown() && event.getGroupId() == InterfaceID.DIALOG_NPC) {
                clientThread.invokeLater(() -> {
                    final Widget dialogWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
                    if (dialogWidget != null) {
                        final String dialog = dialogWidget.getText();
                        // TODO: Remove
                        log.info(dialog);
                        final Clue clue = FaloClue.parseDialog(dialog);
                        if (clue != null) {
                            processRemoveClue();
                            processNewActiveClue(clue);
                        }
                    }
                });
            }
        }
    }

    @Subscribe
    public void onVarClientIntChanged(final VarClientIntChanged event) {
        // Autofill answer to clue question
        if (activeClue != null
                && event.getIndex() == VarClientInt.INPUT_TYPE
                && client.getVarcIntValue(VarClientInt.INPUT_TYPE) == 7) {
            for (final ClueModule clueModule : activeClue.getClueModules()) {
                if (clueModule instanceof QuestionModule) {
                    clientThread.invokeLater(() -> {
                        client.setVarcStrValue(VarClientStr.INPUT_TEXT, Integer.toString(((QuestionModule) clueModule).getAnswer()));
                        client.runScript(ScriptID.CHAT_TEXT_INPUT_REBUILD, "");
                    });
                }
            }
        }
    }

    @Subscribe
    public void onGameTick(final GameTick event) {
        // Check for beginner and master clue completions
        if (activeClue == null) {
            return;
        }
        if (activeClue.getTier() != ClueTier.BEGINNER && activeClue.getTier() != ClueTier.MASTER) {
            return;
        }
        // Got a new clue message
        final Widget itemWidget = client.getWidget(ComponentID.DIALOG_SPRITE_SPRITE);
        if (itemWidget != null) {
            if (itemWidget.getItemId() == ItemID.CLUE_SCROLL_BEGINNER) {
                processRemoveClue();
                processNewActiveClue(BeginnerClues.getUnreadClue());
            } else if (itemWidget.getItemId() == ItemID.CLUE_SCROLL_MASTER) {
                processRemoveClue();
                processNewActiveClue(MasterClues.getUnreadClue());
            }
        }
        // Emote clues are completed on the first Uri dialog
        final Widget nameWidget = client.getWidget(ComponentID.DIALOG_NPC_NAME);
        if (nameWidget != null && nameWidget.getText().equals("Uri")) {
            final Widget textWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
            if (textWidget != null && !textWidget.getText().equals("I do not believe we have any business, Comrade.")) {
                if (activeClue.getTier() == ClueTier.BEGINNER) {
                    processRemoveClue();
                    processNewActiveClue(BeginnerClues.getUnreadClue());
                } else {
                    processRemoveClue();
                    processNewActiveClue(MasterClues.getUnreadClue());
                }
            }
        }
        // Remove Charlie clue requirement upon giving the item
        final Widget spriteTextWidget = client.getWidget(ComponentID.DIALOG_SPRITE_TEXT);
        if (spriteTextWidget != null && spriteTextWidget.getText().startsWith("You give Charlie")) {
            processRemoveClue();
            processNewActiveClue(BeginnerClues.getCharlieDone());
        }
    }


    @Subscribe
    public final void onGameStateChanged(final GameStateChanged gameStateChanged) {
        switch (gameStateChanged.getGameState()) {
            case LOADING:
                highlightedObjects.clear();
                break;
            case HOPPING:
            case LOGIN_SCREEN:
                highlightedNPCs.clear();
                break;
        }
    }

    @Subscribe
    public final void onGameObjectSpawned(final GameObjectSpawned event) {
        if (activeClue != null) {
            if (activeClue.getLocation() instanceof ObjectLocationInterface) {
                final ObjectLocationInterface location = (ObjectLocationInterface) activeClue.getLocation();
                if (event.getTile().getWorldLocation().equals(location.getWorldPoint(client))) {
                    if (location.getObjectIds().contains(event.getGameObject().getId())) {
                        highlightedObjects.add(event.getGameObject());
                    }
                }
            }
            for (final ClueModule clueModule : activeClue.getClueModules()) {
                if (clueModule instanceof ObjectHighlightModule) {
                    final ObjectHighlightModule objectHighlightModule = (ObjectHighlightModule) clueModule;
                    if (event.getTile().getWorldLocation().equals(objectHighlightModule.getLocation())) {
                        if (objectHighlightModule.getObjectId() == event.getGameObject().getId()) {
                            highlightedObjects.add(event.getGameObject());
                        }
                    }
                }
            }
        }
    }

    @Subscribe
    public final void onGameObjectDespawned(final GameObjectDespawned event) {
        highlightedObjects.remove(event.getGameObject());
    }

    @Subscribe
    final void onNpcSpawned(final NpcSpawned event) {
        if (activeClue != null && activeClue.getLocation() instanceof NPCLocationInterface) {
            final NPCLocationInterface location = (NPCLocationInterface) activeClue.getLocation();
            if (location.getNpcIds().contains(event.getNpc().getId())) {
                final WorldPoint npcLocation = event.getNpc().getWorldLocation();
                final WorldPoint clueLocation = location.getWorldPoint(client);
                if (npcLocation.getPlane() == clueLocation.getPlane()
                        && npcLocation.getX() >= clueLocation.getX() - location.getRadiusX()
                        && npcLocation.getX() <= clueLocation.getX() + location.getRadiusX()
                        && npcLocation.getY() >= clueLocation.getY() - location.getRadiusY()
                        && npcLocation.getY() <= clueLocation.getY() + location.getRadiusY()) {
                    highlightedNPCs.add(event.getNpc());
                }
            }
        }
    }

    @Subscribe
    final void onNpcDespawned(final NpcDespawned event) {
        highlightedNPCs.remove(event.getNpc());
    }

    // Prioritize "Talk-to" for highlighted NPCs.
    @Subscribe(priority = -10.0F)
    final void onPostMenuSort(final PostMenuSort event) {
        if (client.isMenuOpen()) {
            return;
        }
        if (highlightedNPCs.isEmpty() && highlightedObjects.isEmpty()) {
            return;
        }

        final Menu menu = client.getMenu();
        final MenuEntry[] menuEntries = menu.getMenuEntries();

        int i = 0;
        for (final MenuEntry entry : menuEntries) {
            if (highlightedNPCs.stream().anyMatch(npc -> npc.getIndex() == entry.getIdentifier())) {
                if (entry.getType() == MenuAction.NPC_FIRST_OPTION) {
                    for (int j = i; j < menuEntries.length - 1; j++) {
                        menuEntries[j] = menuEntries[j + 1];
                    }
                    menuEntries[menuEntries.length - 1] = entry;
                    menu.setMenuEntries(menuEntries);
                    return;
                }
            }
            if (highlightedObjects.stream().anyMatch(object -> object.getId() == entry.getIdentifier())) {
                if (entry.getOption().equals("Talk-to")) {
                    for (int j = i; j < menuEntries.length - 1; j++) {
                        menuEntries[j] = menuEntries[j + 1];
                    }
                    menuEntries[menuEntries.length - 1] = entry;
                    menu.setMenuEntries(menuEntries);
                    return;
                }
            }
            i++;
        }
    }

    @Subscribe
    public void onChatMessage(final ChatMessage event) {
        if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM) {
            return;
        }

        final String message = event.getMessage();

        // STASH used
        if (message.equals("You withdraw your items from the STASH unit.")) {
            stashesUsed.add(lastStashClicked);
        } else if (message.equals("You deposit your items into the STASH unit.")) {
            stashesUsed.remove(lastStashClicked);
        }

        // Hot-Cold update
        if (activeClue instanceof HotColdClue && message.startsWith("The device is ")) {
            final WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
            log.debug("Hot-Cold: {} ({}, {})", message, playerLocation.getX(), playerLocation.getY());
            final Clue clue = ((HotColdClue) activeClue).updateHotCold(playerLocation, message, this);
            if (clue != null) {
                // Just 1 location left, update activeClue
                processRemoveClue();
                processNewActiveClue(clue);
            }
        }

        // Sherlock challenge completion
        if (message.equals("<col=ff0000>You have completed your master level challenge!</col>")) {
            processRemoveClue();
            processNewActiveClue(MasterClues.getSherlockDone());
        }
    }

    @Subscribe
    public final void onMenuOptionClicked(final MenuOptionClicked event) {
        if (event.getMenuOption().equals("Search") && event.getMenuTarget().contains("STASH")) {
            lastStashClicked = WorldPoint.fromScene(client.getTopLevelWorldView(), event.getParam0(), event.getParam1(), client.getTopLevelWorldView().getPlane());
        }
    }

    @Nullable
    private static Clue getClueFromId(final int itemId) {
        if (itemId == ItemID.CLUE_SCROLL_BEGINNER) {
            return BeginnerClues.getUnreadClue();
        }
        if (itemId == ItemID.CLUE_SCROLL_MASTER) {
            return MasterClues.getUnreadClue();
        }

        Clue clue = EasyClues.getClue(itemId);
        if (clue != null) {
            return clue;
        }

        clue = MediumClues.getClue(itemId);
        if (clue != null) {
            return clue;
        }

        clue = HardClues.getClue(itemId);
        if (clue != null) {
            return clue;
        }
        return null;
    }

    private void processNewActiveClue(final Clue clue) {
        activeClue = clue;

        if (clue.getLocation() != null) {
            clue.getLocation().processNewActiveClue(this);

            // Set WorldMapPoint
            worldMapPointManager.add(new ClueHelperWorldMapPoint(this, clue.getLocation().getWorldPoint(client), clue.getTier()));

            // Set hint arrow
            // TODO: NPC Hint Arrows
            // TODO: Center arrow for big objects
            client.setHintArrow(clue.getLocation().getWorldPoint(client));

            // Set pathfinding
            // TODO: Handle moving locations (e.g. key clue)
            // TODO: Set alternative/extra destination tiles
            if (config.pathfinding()) {
                final Map<String, Object> data = new HashMap<>(1);
                data.put("target", clue.getLocation().getWorldPoint(client));
                eventBus.post(new PluginMessage("shortestpath", "path", data));
            }
        }

        for (final ClueModule clueModule : clue.getClueModules()) {
            clueModule.processNewActiveClue(this);
        }
    }

    private void processRemoveClue() {
        if (activeClue != null) {
            activeClue.reset();
            activeClue = null;
        }
        highlightedObjects.clear();
        highlightedNPCs.clear();
        worldMapPointManager.removeIf(ClueHelperWorldMapPoint.class::isInstance);
        client.clearHintArrow();
        if (config.pathfinding()) {
            eventBus.post(new PluginMessage("shortestpath", "clear"));
        }
    }

    final BufferedImage getWorldMapImage(final ClueTier clueTier) {
        BufferedImage image = worldMapImages.get(clueTier);
        if (image == null) {
            final BufferedImage arrowImage = ImageUtil.loadImageResource(getClass(), "/clue_arrow.png");
            image = new BufferedImage(arrowImage.getWidth(), arrowImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image.getGraphics().drawImage(arrowImage, 0, 0, null);
            image.getGraphics().drawImage(itemManager.getImage(clueTier.getItemImageId()), 0, 0, null);
            worldMapImages.put(clueTier, image);
        }
        return image;
    }

    void scrollToWidget(@Component final int list, @Component final int scrollbar, final Widget... toHighlight) {
        final Widget parent = client.getWidget(list);
        if (parent == null) {
            return;
        }
        int averageCentralY = 0;
        int nonnullCount = 0;
        for (final Widget widget : toHighlight) {
            if (widget != null) {
                averageCentralY += widget.getRelativeY() + widget.getHeight() / 2;
                nonnullCount += 1;
            }
        }
        if (nonnullCount == 0) {
            return;
        }
        averageCentralY /= nonnullCount;
        final int newScroll = Math.max(0, Math.min(parent.getScrollHeight(),
                averageCentralY - parent.getHeight() / 2));

        client.runScript(
                ScriptID.UPDATE_SCROLLBAR,
                scrollbar,
                list,
                newScroll
        );
    }

    void highlightWidget(final Graphics2D graphics, final Widget toHighlight, final Widget container, Rectangle padding, final String text) {
        padding = MoreObjects.firstNonNull(padding, new Rectangle());

        final Point canvasLocation = toHighlight.getCanvasLocation();

        if (canvasLocation == null) {
            return;
        }

        final Point windowLocation = container.getCanvasLocation();

        if (windowLocation.getY() > canvasLocation.getY() + toHighlight.getHeight()
                || windowLocation.getY() + container.getHeight() < canvasLocation.getY()) {
            return;
        }

        // Visible area of widget
        final Shape widgetArea = new Area(
                new Rectangle(
                        canvasLocation.getX() - padding.x,
                        Math.max(canvasLocation.getY(), windowLocation.getY()) - padding.y,
                        toHighlight.getWidth() + padding.x + padding.width,
                        Math.min(
                                Math.min(windowLocation.getY() + container.getHeight() - canvasLocation.getY(), toHighlight.getHeight()),
                                Math.min(canvasLocation.getY() + toHighlight.getHeight() - windowLocation.getY(), toHighlight.getHeight())) + padding.y + padding.height
                ));

        OverlayUtil.renderHoverableArea(graphics, widgetArea, client.getMouseCanvasPosition(),
                new Color(0, 255, 0, 20), Color.ORANGE, Color.ORANGE.darker());

        if (text == null) {
            return;
        }

        final FontMetrics fontMetrics = graphics.getFontMetrics();

        final TextComponent textComponent = new TextComponent();
        textComponent.setPosition(new java.awt.Point(
                canvasLocation.getX() + toHighlight.getWidth() / 2 - fontMetrics.stringWidth(text) / 2,
                canvasLocation.getY() + fontMetrics.getHeight()));
        textComponent.setText(text);
        textComponent.render(graphics);
    }
}
