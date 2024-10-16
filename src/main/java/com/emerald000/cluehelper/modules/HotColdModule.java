package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.HotColdClue;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;

public class HotColdModule implements ClueModule {

    @Override
    public void renderWorldOverlay(final ClueHelperPlugin plugin, final Graphics2D graphics2D) {
        if (!(plugin.getActiveClue() instanceof HotColdClue)) {
            return;
        }
        final HotColdClue hotColdClue = (HotColdClue) plugin.getActiveClue();

        for (final Clue clue : hotColdClue.getPossibleClues()) {
            if (clue.getLocation() != null) {
                clue.getLocation().renderWorldOverlay(plugin, graphics2D);
            }
        }
    }

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        if (!(plugin.getActiveClue() instanceof HotColdClue)) {
            return;
        }
        final HotColdClue hotColdClue = (HotColdClue) plugin.getActiveClue();

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Possible locations:")
                .build());

        int i = 0;
        final Iterator<Clue> iter = hotColdClue.getPossibleClues().iterator();
        while (i < 5 && iter.hasNext()) {
            final Clue clue = iter.next();
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("- " + clue.getDescription().getText(plugin))
                    .leftColor(Color.LIGHT_GRAY)
                    .build());
            i++;
        }

        if (hotColdClue.getPossibleClues().size() > 5) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("+" + (hotColdClue.getPossibleClues().size() - 5) + " locations")
                    .build());
        }
    }
}
