package com.emerald000.cluehelper;

import com.emerald000.cluehelper.clues.CeciliaClue;
import com.emerald000.cluehelper.clues.Clue;
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
import java.awt.Rectangle;

final class ClueHelperMusicOverlay extends Overlay {
    private final ClueHelperPlugin plugin;
    private final Client client;

    private boolean hasScrolled = false;

    @Inject
    private ClueHelperMusicOverlay(final ClueHelperPlugin plugin, final Client client) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.plugin = plugin;
        this.client = client;
    }

    @Nullable
    @Override
    public Dimension render(final Graphics2D graphics) {
        final Clue activeClue = plugin.getActiveClue();

        if (!(activeClue instanceof CeciliaClue)) {
            hasScrolled = false;
            return null;
        }

        final CeciliaClue ceciliaClue = (CeciliaClue) activeClue;

        final Widget musicContainer = client.getWidget(ComponentID.MUSIC_CONTAINER);

        if (musicContainer == null || musicContainer.isHidden()) {
            return null;
        }

        final Widget trackList = client.getWidget(ComponentID.MUSIC_LIST);
        final String trackToFind = ceciliaClue.getSong();
        Widget found = null;

        if (trackList == null) {
            return null;
        }

        for (final Widget track : trackList.getDynamicChildren()) {
            if (track.getText().equals(trackToFind)) {
                found = track;
                break;
            }
        }

        if (found == null) {
            return null;
        }

        if (!hasScrolled) {
            hasScrolled = true;
            plugin.scrollToWidget(ComponentID.MUSIC_SCROLL_CONTAINER, ComponentID.MUSIC_SCROLLBAR, found);
        }
        plugin.highlightWidget(graphics, found, trackList, new Rectangle(2, 1, 0, 1), null);

        return null;
    }
}
