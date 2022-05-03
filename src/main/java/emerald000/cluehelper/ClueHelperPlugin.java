package emerald000.cluehelper;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import joptsimple.internal.Strings;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.GroundObject;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemComposition;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.ObjectComposition;
import net.runelite.api.Point;
import net.runelite.api.Scene;
import net.runelite.api.ScriptID;
import net.runelite.api.Tile;
import net.runelite.api.TileObject;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.banktags.BankTagsPlugin;
import net.runelite.client.plugins.banktags.TagManager;
import emerald000.cluehelper.clues.AnagramClue;
import emerald000.cluehelper.clues.CipherClue;
import emerald000.cluehelper.clues.ClueScroll;
import emerald000.cluehelper.clues.CoordinateClue;
import emerald000.cluehelper.clues.CrypticClue;
import emerald000.cluehelper.clues.EmoteClue;
import emerald000.cluehelper.clues.FaloTheBardClue;
import emerald000.cluehelper.clues.HotColdClue;
import emerald000.cluehelper.clues.MapClue;
import emerald000.cluehelper.clues.MultipleLocationsClueScroll;
import emerald000.cluehelper.clues.MusicClue;
import emerald000.cluehelper.clues.SkillChallengeClue;
import emerald000.cluehelper.clues.ThreeStepCrypticClue;
import emerald000.cluehelper.clues.item.ItemRequirement;
import emerald000.cluehelper.clues.requirement.Requirement;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Slf4j
@PluginDependency(BankTagsPlugin.class)
@PluginDescriptor(
	name = "Clue Helper",
	description = "Get your clues done faster",
	tags = {"clues", "beginner", "easy", "medium", "hard", "elite", "master", "items", "emotes", "stashes"},
	conflicts = "Clue Scroll"
)
public class ClueHelperPlugin extends Plugin
{
	private static final Color HIGHLIGHT_BORDER_COLOR = Color.ORANGE;
	private static final Color HIGHLIGHT_HOVER_BORDER_COLOR = HIGHLIGHT_BORDER_COLOR.darker();
	private static final Color HIGHLIGHT_FILL_COLOR = new Color(0, 255, 0, 20);
	private static final String CLUE_TAG_NAME = "clue";

	@Getter
	private ClueScroll clue;

	@Getter
	private final List<NPC> npcsToMark = new ArrayList<>();

	@Getter
	private final List<TileObject> objectsToMark = new ArrayList<>();

	@Getter
	private final List<TileObject> namedObjectsToMark = new ArrayList<>();

	@Getter
	private Item[] equippedItems;

	@Getter
	private Item[] inventoryItems;

	@Inject
	@Getter
	private Client client;

	@Inject
	@Getter
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ClueScrollOverlay clueScrollOverlay;

	@Inject
	private ClueScrollEmoteOverlay clueScrollEmoteOverlay;

	@Inject
	private ClueScrollMusicOverlay clueScrollMusicOverlay;

	@Inject
	private ClueScrollWorldOverlay clueScrollWorldOverlay;

	@Inject
	private ClueHelperConfig config;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	@Inject
	private TagManager tagManager;

	@Inject
	@Named("developerMode")
	boolean developerMode;

	private BufferedImage emoteImage;
	private BufferedImage mapArrow;
	private Integer clueItemId;
	private boolean worldMapPointsSet = false;

	// Some objects will only update to their "active" state when changing to their plane after varbit changes,
	// which take one extra tick to fire after the plane change. These fields are used to track those changes and delay
	// scans of the current plane's tiles accordingly.
	private int currentPlane = -1;
	private boolean namedObjectCheckThisTick;

	private final TextComponent textComponent = new TextComponent();

	@Getter
	private EmoteClue activeSTASHClue;
	private EmoteClue clickedSTASHClue;

	@Provides
	ClueHelperConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ClueHelperConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(ClueScrollService.class).to(ClueScrollServiceImpl.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(clueScrollOverlay);
		overlayManager.add(clueScrollEmoteOverlay);
		overlayManager.add(clueScrollWorldOverlay);
		overlayManager.add(clueScrollMusicOverlay);
		tagManager.registerTag(CLUE_TAG_NAME, this::testClueTag);
	}

	@Override
	protected void shutDown() throws Exception
	{
		tagManager.unregisterTag(CLUE_TAG_NAME);
		overlayManager.remove(clueScrollOverlay);
		overlayManager.remove(clueScrollEmoteOverlay);
		overlayManager.remove(clueScrollWorldOverlay);
		overlayManager.remove(clueScrollMusicOverlay);
		npcsToMark.clear();
		namedObjectsToMark.clear();
		inventoryItems = null;
		equippedItems = null;
		currentPlane = -1;
		namedObjectCheckThisTick = false;
		resetClue(true);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		String message = event.getMessage();

		if (clue instanceof HotColdClue)
		{
			if (((HotColdClue) clue).update(message, this))
			{
				worldMapPointsSet = false;
			}
		}

		if (clue instanceof SkillChallengeClue)
		{
			String text = Text.removeTags(message);
			if (text.equals("Skill challenge completed.") ||
				text.equals("You have completed your master level challenge!") ||
				text.startsWith("You have completed Charlie's task,") ||
				text.equals("You have completed this challenge scroll."))
			{
				((SkillChallengeClue) clue).setChallengeCompleted(true);
			}
		}

		if (message.endsWith(" the STASH unit."))
		{
			if (clue instanceof EmoteClue && clickedSTASHClue != null && message.equals("You withdraw your items from the STASH unit."))
			{
				activeSTASHClue = clickedSTASHClue;
			}
			else if (message.equals("You deposit your items into the STASH unit."))
			{
				activeSTASHClue = null;
			}
			clickedSTASHClue = null;
		}
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals("Reset")
			&& overlayMenuClicked.getOverlay() == clueScrollOverlay)
		{
			resetClue(true);
		}
	}

	@Subscribe
	public void onMenuOptionClicked(final MenuOptionClicked event)
	{
		if (event.getMenuOption() == null)
		{
			return;
		}

		final boolean isXMarksTheSpotOrb = event.getItemId() == ItemID.MYSTERIOUS_ORB_23069;
		if (isXMarksTheSpotOrb || event.getMenuOption().equals("Read"))
		{
			final ItemComposition itemComposition = itemManager.getItemComposition(event.getItemId());

			if (isXMarksTheSpotOrb
				|| itemComposition.getName().startsWith("Clue scroll")
				|| itemComposition.getName().startsWith("Challenge scroll")
				|| itemComposition.getName().startsWith("Treasure scroll"))
			{
				clueItemId = itemComposition.getId();
				updateClue(MapClue.forItemId(clueItemId));
			}
		}
		else if (event.getMenuOption().equals("Search")	&& clue instanceof EmoteClue)
		{
			EmoteClue emoteClue = (EmoteClue) clue;
			if (emoteClue.getStashUnit() != null && emoteClue.getStashUnit().getObjectId() == event.getId())
			{
				clickedSTASHClue = emoteClue;
			}
		}
	}

	@Subscribe
	public void onItemContainerChanged(final ItemContainerChanged event)
	{
		if (event.getItemContainer() == client.getItemContainer(InventoryID.EQUIPMENT))
		{
			equippedItems = event.getItemContainer().getItems();
			return;
		}

		if (event.getItemContainer() != client.getItemContainer(InventoryID.INVENTORY))
		{
			return;
		}

		inventoryItems = event.getItemContainer().getItems();

		// Check if item was removed from inventory
		if (clue != null && clueItemId != null)
		{
			ItemContainer itemContainer = event.getItemContainer();

			// Check if clue was removed from inventory
			if (!itemContainer.contains(clueItemId))
			{
				resetClue(true);
			}
		}

		// if three step clue check for clue scroll pieces
		if (clue instanceof ThreeStepCrypticClue)
		{
			if (((ThreeStepCrypticClue) clue).update(event.getContainerId(), event.getItemContainer()))
			{
				worldMapPointsSet = false;
				npcsToMark.clear();

				if (config.displayHintArrows())
				{
					client.clearHintArrow();
				}

				checkClueNPCs(clue, client.getCachedNPCs());
			}
		}
	}

	@Subscribe
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();
		if (clue != null)
		{
			checkClueNPCs(clue, npc);
		}
	}

	@Subscribe
	public void onNpcDespawned(final NpcDespawned event)
	{
		final boolean removed = npcsToMark.remove(event.getNpc());

		if (removed)
		{
			if (npcsToMark.isEmpty())
			{
				client.clearHintArrow();
			}
			else
			{
				// Always set hint arrow to first seen NPC
				client.setHintArrow(npcsToMark.get(0));
			}
		}
	}

	@Subscribe
	public void onDecorativeObjectChanged(final DecorativeObjectChanged event)
	{
		tileObjectChangedHandler(event.getPrevious(), event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectDespawned(final DecorativeObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getDecorativeObject());
	}

	@Subscribe
	public void onDecorativeObjectSpawned(final DecorativeObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getDecorativeObject());
	}

	@Subscribe
	public void onGameObjectChanged(final GameObjectChanged event)
	{
		tileObjectChangedHandler(event.getPrevious(), event.getGameObject());
	}

	@Subscribe
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getGameObject());
	}

	@Subscribe
	public void onGameObjectSpawned(final GameObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getGameObject());
	}

	@Subscribe
	public void onGroundObjectChanged(final GroundObjectChanged event)
	{
		tileObjectChangedHandler(event.getPrevious(), event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectDespawned(final GroundObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getGroundObject());
	}

	@Subscribe
	public void onGroundObjectSpawned(final GroundObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getGroundObject());
	}

	@Subscribe
	public void onWallObjectChanged(final WallObjectChanged event)
	{
		tileObjectChangedHandler(event.getPrevious(), event.getWallObject());
	}

	@Subscribe
	public void onWallObjectDespawned(final WallObjectDespawned event)
	{
		tileObjectDespawnedHandler(event.getWallObject());
	}

	@Subscribe
	public void onWallObjectSpawned(final WallObjectSpawned event)
	{
		tileObjectSpawnedHandler(event.getWallObject());
	}

	private void tileObjectChangedHandler(final TileObject prev, final TileObject changedTo)
	{
		tileObjectDespawnedHandler(prev);
		tileObjectSpawnedHandler(changedTo);
	}

	private void tileObjectDespawnedHandler(final TileObject despawned)
	{
		namedObjectsToMark.remove(despawned);
	}

	private void tileObjectSpawnedHandler(final TileObject spawned)
	{
		checkClueNamedObject(clue, spawned);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("cluescroll") && !config.displayHintArrows())
		{
			client.clearHintArrow();
		}
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event)
	{
		final GameState state = event.getGameState();

		if (state != GameState.LOGGED_IN)
		{
			namedObjectsToMark.clear();
		}

		if (state == GameState.LOGIN_SCREEN)
		{
			resetClue(true);
		}
		else if (state == GameState.HOPPING)
		{
			namedObjectCheckThisTick = true;
		}
	}

	@Subscribe
	public void onGameTick(final GameTick event)
	{
		objectsToMark.clear();

		if (clue != null)
		{

			if (clue instanceof MultipleLocationsClueScroll)
			{
				final List<WorldPoint> locations = ((MultipleLocationsClueScroll) clue).getLocations();

				if (clue instanceof ThreeStepCrypticClue)
				{
					List<Integer> objectIds = ((ThreeStepCrypticClue) clue).getObjectIds();

					if (objectIds.size() > 0)
					{
						for (WorldPoint location : locations)
						{
							if (location != null)
							{
								for (int objectId : objectIds)
								{
									highlightObjectsForLocation(location, objectId);
								}
							}
						}
					}
				}

				final List<WorldPoint> mapPoints = Lists.newArrayList(Iterables.concat(locations, clue.getExtraMapPoints()));
				if (mapPoints.size() > 0)
				{
					addMapPoints(mapPoints);
				}
			}

			if (clue.getLocation() != null)
			{
				final boolean npcHintArrowMarked = client.getHintArrowNpc() != null && npcsToMark.contains(client.getHintArrowNpc());

				if (!npcHintArrowMarked)
				{
					client.clearHintArrow();
				}

				WorldPoint centerPoint = clue.getLocation().getCenterWorldPoint();

				// Only set the location hint arrow if we do not already have more accurate location
				if (!npcHintArrowMarked && config.displayHintArrows() && WorldPoint.isInScene(client, centerPoint.getX(), centerPoint.getY()))
				{
					client.setHintArrow(centerPoint);
				}

				final List<WorldPoint> mapPoints = new ArrayList<>(clue.getExtraMapPoints());
				mapPoints.add(centerPoint);
				addMapPoints(mapPoints);

				if (clue.getObjectId() != -1)
				{
					highlightObjectsForLocation(centerPoint, clue.getObjectId());
				}
			}

			clue.getPathObjects().forEach(pathObject -> highlightObjectsForLocation(pathObject.getLeft(), pathObject.getRight()));

			// Load the current plane's tiles if a tick has elapsed since the player has changed planes
			// or upon reaching a logged in state after hopping worlds
			if (namedObjectCheckThisTick)
			{
				namedObjectCheckThisTick = false;
				checkClueNamedObjects(clue);
			}

			// Delay one tick when changing planes before scanning for new named objects on the new plane
			if (currentPlane != client.getPlane())
			{
				currentPlane = client.getPlane();
				namedObjectCheckThisTick = true;
			}
		}

		// Reset clue when receiving a new beginner or master clue
		// These clues use a single item ID, so we cannot detect step changes based on the item ID changing
		final Widget chatDialogClueItem = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE);
		if (chatDialogClueItem != null
			&& (chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_BEGINNER || chatDialogClueItem.getItemId() == ItemID.CLUE_SCROLL_MASTER))
		{
			resetClue(false);
		}

		final Widget clueScrollText = client.getWidget(WidgetInfo.CLUE_SCROLL_TEXT);

		if (clueScrollText != null)
		{
			ClueScroll clueScroll = findClueScroll(clueScrollText.getText());
			updateClue(clueScroll);
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() < WidgetID.BEGINNER_CLUE_MAP_CHAMPIONS_GUILD
			|| event.getGroupId() > WidgetID.BEGINNER_CLUE_MAP_WIZARDS_TOWER)
		{
			return;
		}

		updateClue(MapClue.forWidgetID(event.getGroupId()));
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted)
	{
		if (developerMode && commandExecuted.getCommand().equals("clue"))
		{
			String text = Strings.join(commandExecuted.getArguments(), " ");

			if (text.isEmpty())
			{
				resetClue(true);
			}
			else
			{
				ClueScroll clueScroll = findClueScroll(text);
				log.debug("Found clue scroll for '{}': {}", text, clueScroll);
				updateClue(clueScroll);
			}
		}
	}

	public BufferedImage getClueScrollImage()
	{
		return itemManager.getImage(ItemID.CLUE_SCROLL_MASTER);
	}

	BufferedImage getEmoteImage()
	{
		if (emoteImage != null)
		{
			return emoteImage;
		}

		emoteImage = ImageUtil.loadImageResource(getClass(), "emote.png");

		return emoteImage;
	}

	public BufferedImage getSpadeImage()
	{
		return itemManager.getImage(ItemID.SPADE);
	}

	BufferedImage getMapArrow()
	{
		if (mapArrow != null)
		{
			return mapArrow;
		}

		mapArrow = ImageUtil.loadImageResource(getClass(), "/util/clue_arrow.png");

		return mapArrow;
	}

	private void resetClue(boolean withItemId)
	{
		if (clue instanceof MultipleLocationsClueScroll)
		{
			((MultipleLocationsClueScroll) clue).reset();
		}

		if (withItemId)
		{
			clueItemId = null;
		}

		clue = null;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);
		worldMapPointsSet = false;
		npcsToMark.clear();
		namedObjectsToMark.clear();

		if (config.displayHintArrows())
		{
			client.clearHintArrow();
		}
	}

	@Nullable
	private ClueScroll findClueScroll(String rawText)
	{
		// Remove line breaks and also the rare occasion where there are double line breaks
		final String text = Text.sanitizeMultilineText(rawText).toLowerCase();

		// Early return if this is same clue as already existing one
		if (clue != null && clue.getText() != null && clue.getText().equalsIgnoreCase(text))
		{
			return clue;
		}

		if (text.startsWith("i'd like to hear some music."))
		{
			return MusicClue.forText(rawText);
		}

		final CoordinateClue coordinateClue = CoordinateClue.forText(text);
		if (coordinateClue != null)
		{
			return coordinateClue;
		}

		final AnagramClue anagramClue = AnagramClue.forText(text);
		if (anagramClue != null)
		{
			return anagramClue;
		}

		final CipherClue cipherClue = CipherClue.forText(text);
		if (cipherClue != null)
		{
			return cipherClue;
		}

		final CrypticClue crypticClue = CrypticClue.forText(text);

		if (crypticClue != null)
		{
			return crypticClue;
		}

		final EmoteClue emoteClue = EmoteClue.forText(text);

		if (emoteClue != null)
		{
			return emoteClue;
		}

		final FaloTheBardClue faloTheBardClue = FaloTheBardClue.forText(text);

		if (faloTheBardClue != null)
		{
			return faloTheBardClue;
		}

		final HotColdClue hotColdClue = HotColdClue.forText(text);

		if (hotColdClue != null)
		{
			return hotColdClue;
		}

		final SkillChallengeClue skillChallengeClue = SkillChallengeClue.forText(text, rawText);

		if (skillChallengeClue != null)
		{
			return skillChallengeClue;
		}

		// three step cryptic clues need unedited text to check which steps are already done
		final ThreeStepCrypticClue threeStepCrypticClue = ThreeStepCrypticClue.forText(text, rawText);

		if (threeStepCrypticClue != null)
		{
			return threeStepCrypticClue;
		}

		// We have unknown clue, reset
		log.warn("Encountered unhandled clue text: {}", rawText);
		resetClue(true);
		return null;
	}

	private void addMapPoints(List<WorldPoint> worldPoints)
	{
		if (worldMapPointsSet)
		{
			return;
		}

		worldMapPointsSet = true;
		worldMapPointManager.removeIf(ClueScrollWorldMapPoint.class::isInstance);

		for (final WorldPoint point : worldPoints)
		{
			worldMapPointManager.add(new ClueScrollWorldMapPoint(point, this));

			// Check for mirror coordinates
			WorldPoint mirrorPoint = WorldPoint.getMirrorPoint(point, true);
			if (mirrorPoint != null)
			{
				worldMapPointManager.add(new ClueScrollWorldMapPoint(mirrorPoint, this));
			}
		}
	}

	private void highlightObjectsForLocation(final WorldPoint location, final int objectId)
	{
		final LocalPoint localLocation = LocalPoint.fromWorld(client, location);

		if (localLocation == null)
		{
			return;
		}

		final Scene scene = client.getScene();
		final Tile[][][] tiles = scene.getTiles();
		final Tile tile = tiles[client.getPlane()][localLocation.getSceneX()][localLocation.getSceneY()];

		if (tile == null)
		{
			return;
		}

		for (GameObject gameObject : tile.getGameObjects())
		{
			if (gameObject == null)
			{
				continue;
			}

			if (gameObject.getId() == objectId)
			{
				objectsToMark.add(gameObject);
				continue;
			}

			// Check impostors
			final ObjectComposition comp = client.getObjectDefinition(gameObject.getId());
			final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

			if (impostor != null && impostor.getId() == objectId)
			{
				objectsToMark.add(gameObject);
			}
		}

		WallObject wallObject = tile.getWallObject();
		if (wallObject != null)
		{
			if (wallObject.getId() == objectId)
			{
				objectsToMark.add(wallObject);
			}
			// Check impostors
			else
			{
				final ObjectComposition comp = client.getObjectDefinition(wallObject.getId());
				final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

				if (impostor != null && impostor.getId() == objectId)
				{
					objectsToMark.add(wallObject);
				}
			}
		}

		GroundObject groundObject = tile.getGroundObject();
		if (groundObject != null)
		{
			if (groundObject.getId() == objectId)
			{
				objectsToMark.add(groundObject);
			}
			// Check impostors
			else
			{
				final ObjectComposition comp = client.getObjectDefinition(groundObject.getId());
				final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

				if (impostor != null && impostor.getId() == objectId)
				{
					objectsToMark.add(groundObject);
				}
			}
		}
	}

	private void checkClueNPCs(ClueScroll clue, final NPC... npcs)
	{
		if (clue instanceof ThreeStepCrypticClue)
		{
			ThreeStepCrypticClue threeStepCrypticClue = (ThreeStepCrypticClue) clue;

			if (threeStepCrypticClue.getNpcs().isEmpty())
			{
				return;
			}

			for (NPC npc : npcs)
			{
				if (npc == null || npc.getName() == null)
				{
					continue;
				}

				for (String npcName : threeStepCrypticClue.getNpcs())
				{
					if (!npc.getName().equals(npcName))
					{
						continue;
					}

					npcsToMark.add(npc);
				}
			}
		}
		else
		{
			if (clue.getNpc() == null)
			{
				return;
			}

			for (NPC npc : npcs)
			{
				if (npc == null || npc.getName() == null || !npc.getName().equals(clue.getNpc()))
				{
					continue;
				}
				npcsToMark.add(npc);
			}
		}

		if (!npcsToMark.isEmpty() && config.displayHintArrows())
		{
			// Always set hint arrow to first seen NPC
			client.setHintArrow(npcsToMark.get(0));
		}

	}

	/**
	 * Scans all of the current plane's loaded tiles for {@link TileObject}s and passes any found objects to
	 * {@link ClueHelperPlugin#checkClueNamedObject(ClueScroll, TileObject)} for storing in the cache of discovered
	 * named objects.
	 *
	 * @param clue The active clue scroll
	 */
	private void checkClueNamedObjects(@Nullable ClueScroll clue)
	{
		if (!(clue instanceof SkillChallengeClue))
		{
			return;
		}

		// Search loaded tiles for objects
		for (final Tile[] tiles : client.getScene().getTiles()[client.getPlane()])
		{
			for (final Tile tile : tiles)
			{
				if (tile == null)
				{
					continue;
				}

				for (final GameObject object : tile.getGameObjects())
				{
					if (object == null)
					{
						continue;
					}

					checkClueNamedObject(clue, object);
				}
			}
		}
	}

	/**
	 * Checks passed objects against the active clue's object name and regions. If the clue is a
	 * {@link SkillChallengeClue} and the object matches its allowable object name and is within its regions, the
	 * object will be stored in the cache of discovered named objects.
	 *
	 * @param clue   The active clue scroll
	 * @param object The spawned or scanned object
	 */
	private void checkClueNamedObject(@Nullable final ClueScroll clue, @Nonnull final TileObject object)
	{
		if (!(clue instanceof SkillChallengeClue))
		{
			return;
		}

		SkillChallengeClue skillChallengeClue = (SkillChallengeClue) clue;

		final String objectName = skillChallengeClue.getObjectName();
		final List<Integer> regionIds = skillChallengeClue.getObjectRegions();

		if (objectName == null || !regionIds.contains(object.getWorldLocation().getRegionID()))
		{
			return;
		}

		final ObjectComposition comp = client.getObjectDefinition(object.getId());
		final ObjectComposition impostor = comp.getImpostorIds() != null ? comp.getImpostor() : comp;

		if (comp.getName().equals(objectName) || impostor.getName().equals(objectName))
		{
			namedObjectsToMark.add(object);
		}
	}

	private void updateClue(final ClueScroll clue)
	{
		if (clue == null || clue == this.clue)
		{
			return;
		}

		resetClue(false);
		checkClueNPCs(clue, client.getCachedNPCs());
		checkClueNamedObjects(clue);
		// If we have a clue, save that knowledge
		// so the clue window doesn't have to be open.
		this.clue = clue;
	}

	void highlightWidget(Graphics2D graphics, Widget toHighlight, Widget container, Rectangle padding, String text)
	{
		padding = MoreObjects.firstNonNull(padding, new Rectangle());

		Point canvasLocation = toHighlight.getCanvasLocation();

		if (canvasLocation == null)
		{
			return;
		}

		Point windowLocation = container.getCanvasLocation();

		if (windowLocation.getY() > canvasLocation.getY() + toHighlight.getHeight()
			|| windowLocation.getY() + container.getHeight() < canvasLocation.getY())
		{
			return;
		}

		// Visible area of widget
		Area widgetArea = new Area(
			new Rectangle(
				canvasLocation.getX() - padding.x,
				Math.max(canvasLocation.getY(), windowLocation.getY()) - padding.y,
				toHighlight.getWidth() + padding.x + padding.width,
				Math.min(
					Math.min(windowLocation.getY() + container.getHeight() - canvasLocation.getY(), toHighlight.getHeight()),
					Math.min(canvasLocation.getY() + toHighlight.getHeight() - windowLocation.getY(), toHighlight.getHeight())) + padding.y + padding.height
			));

		OverlayUtil.renderHoverableArea(graphics, widgetArea, client.getMouseCanvasPosition(),
			HIGHLIGHT_FILL_COLOR, HIGHLIGHT_BORDER_COLOR, HIGHLIGHT_HOVER_BORDER_COLOR);

		if (text == null)
		{
			return;
		}

		FontMetrics fontMetrics = graphics.getFontMetrics();

		textComponent.setPosition(new java.awt.Point(
			canvasLocation.getX() + toHighlight.getWidth() / 2 - fontMetrics.stringWidth(text) / 2,
			canvasLocation.getY() + fontMetrics.getHeight()));
		textComponent.setText(text);
		textComponent.render(graphics);
	}

	void scrollToWidget(WidgetInfo list, WidgetInfo scrollbar, Widget... toHighlight)
	{
		final Widget parent = client.getWidget(list);
		int averageCentralY = 0;
		int nonnullCount = 0;
		for (Widget widget : toHighlight)
		{
			if (widget != null)
			{
				averageCentralY += widget.getRelativeY() + widget.getHeight() / 2;
				nonnullCount += 1;
			}
		}
		if (nonnullCount == 0)
		{
			return;
		}
		averageCentralY /= nonnullCount;
		final int newScroll = Math.max(0, Math.min(parent.getScrollHeight(),
			averageCentralY - parent.getHeight() / 2));

		client.runScript(
			ScriptID.UPDATE_SCROLLBAR,
			scrollbar.getId(),
			list.getId(),
			newScroll
		);
	}

	private boolean testClueTag(int itemId)
	{
		ClueScroll c = clue;
		if (c == null)
		{
			return false;
		}

		if (c instanceof EmoteClue)
		{
			EmoteClue emote = (EmoteClue) c;

			for (ItemRequirement ir : emote.getItemRequirements())
			{
				if (ir.fulfilledBy(itemId))
				{
					return true;
				}
			}
		}
		else if (c instanceof CoordinateClue || c instanceof HotColdClue)
		{
			return itemId == ItemID.SPADE;
		}
		else if (c instanceof MapClue)
		{
			MapClue mapClue = (MapClue) c;

			return mapClue.getObjectId() == -1 && itemId == ItemID.SPADE;
		}
		else if (c instanceof SkillChallengeClue)
		{
			SkillChallengeClue challengeClue = (SkillChallengeClue) c;

			for (Requirement requirement : challengeClue.getRequirements())
			{
				// TODO: Add item requirements.
			}
		}

		return false;
	}
}
