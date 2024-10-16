package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class BarbarianHerbloreRequirement implements ClueModule {
    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final int barbVarbit = plugin.getClient().getVarbitValue(9613);
        // Training fully completed
        if (barbVarbit >= 10) {
            return;
        }
        Color colour = Color.RED;
        String symbol = "✗";
        // Training potentially progressed enough
        if (barbVarbit >= 2) {
            colour = Color.YELLOW;
            symbol = "?";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Barbarian herblore training")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

    }
}
