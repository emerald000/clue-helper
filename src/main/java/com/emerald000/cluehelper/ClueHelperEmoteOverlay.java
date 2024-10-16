package com.emerald000.cluehelper;

import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.EmoteClue;
import net.runelite.api.Client;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;

final class ClueHelperEmoteOverlay extends Overlay {
    private final ClueHelperPlugin plugin;
    private final Client client;

    private boolean hasScrolled = false;

    @Inject
    private ClueHelperEmoteOverlay(final ClueHelperPlugin plugin, final Client client) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.plugin = plugin;
        this.client = client;
    }

    @Nullable
    @Override
    public Dimension render(final Graphics2D graphics) {
        final Clue clue = plugin.getActiveClue();

        if (!(clue instanceof EmoteClue)) {
            hasScrolled = false;
            return null;
        }
        final EmoteClue emoteClue = (EmoteClue) clue;

        if (emoteClue.getFirstEmote().getSpriteId() == -1) {
            return null;
        }

        final Widget emoteContainer = client.getWidget(ComponentID.EMOTES_EMOTE_CONTAINER);

        if (emoteContainer == null || emoteContainer.isHidden()) {
            return null;
        }

        final Widget emoteWindow = client.getWidget(ComponentID.EMOTES_WINDOW);

        if (emoteWindow == null) {
            return null;
        }

        Widget firstEmoteWidget = null;
        Widget secondEmoteWidget = null;

        for (final Widget emoteWidget : emoteContainer.getDynamicChildren()) {
            if (emoteWidget.getSpriteId() == emoteClue.getFirstEmote().getSpriteId()) {
                firstEmoteWidget = emoteWidget;
                plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null,
                        emoteClue.getSecondEmote() != null ? "1st" : null);
            } else if (emoteClue.getSecondEmote() != null
                    && emoteWidget.getSpriteId() == emoteClue.getSecondEmote().getSpriteId()) {
                secondEmoteWidget = emoteWidget;
                plugin.highlightWidget(graphics, emoteWidget, emoteWindow, null, "2nd");
            }
        }
        if (!hasScrolled) {
            hasScrolled = true;
            plugin.scrollToWidget(ComponentID.EMOTES_EMOTE_SCROLL_CONTAINER, ComponentID.EMOTES_EMOTE_SCROLLBAR, firstEmoteWidget, secondEmoteWidget);
        }

        return null;
    }
}

