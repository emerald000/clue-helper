package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class NothingEquippedRequirement implements ClueModule {
    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final Color colour;
        final String symbol;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        if (equipment == null || equipment.count() == 0) {
            colour = Color.GREEN;
            symbol = "✓";
        } else {
            colour = Color.RED;
            symbol = "✗";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Nothing equipped")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
