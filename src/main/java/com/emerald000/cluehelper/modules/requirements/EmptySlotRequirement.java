package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AllArgsConstructor;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.util.Locale;

@AllArgsConstructor
public class EmptySlotRequirement implements ClueModule {

    private final EquipmentInventorySlot slot;

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final Color colour;
        final String symbol;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        if (equipment == null || equipment.getItem(slot.getSlotIdx()) == null) {
            colour = Color.GREEN;
            symbol = "✓";
        } else {
            colour = Color.RED;
            symbol = "✗";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left("No " + slot.toString().toLowerCase(Locale.ROOT) + " equipped")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
