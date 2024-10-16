package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Graphics2D;

public interface ClueModule {
    default void renderWorldOverlay(final ClueHelperPlugin plugin, final Graphics2D graphics2D) {

    }

    default void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {

    }

    default void processNewActiveClue(final ClueHelperPlugin plugin) {

    }
}
