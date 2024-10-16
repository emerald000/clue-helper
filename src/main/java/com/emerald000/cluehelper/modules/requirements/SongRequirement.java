package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AllArgsConstructor;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

@AllArgsConstructor
public class SongRequirement implements ClueModule {
    private String song;
    private int varPlayerId;
    private int bitShift;

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {

        final int varPlayer = plugin.getClient().getVarpValue(varPlayerId);

        final Color colour;
        final String symbol;
        if (((varPlayer >>> bitShift) & 1) == 1) {
            colour = Color.GREEN;
            symbol = "✓";
        } else {
            colour = Color.RED;
            symbol = "✗";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(song)
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
