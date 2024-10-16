package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class EquipmentRequirement implements ClueModule {

    private final String description;
    private final List<Integer> itemIds = new ArrayList<>(1);

    public EquipmentRequirement(final int itemId) {
        this("", itemId);
    }

    public EquipmentRequirement(final String description, final int... itemIds) {
        this.description = description;
        for (final int itemId : itemIds) {
            this.itemIds.add(itemId);
        }
    }

    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        Color colour = Color.RED;
        String symbol = "✗";
        String finalDescription = description;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        for (final int itemId : itemIds) {
            if (equipment != null && equipment.contains(itemId)) {
                colour = Color.GREEN;
                symbol = "✓";
                break;
            } else if (inventory != null && inventory.contains(itemId)) {
                colour = Color.YELLOW;
                symbol = "✓";
            }
        }

        if (finalDescription.isEmpty()) {
            finalDescription = plugin.getItemManager().getItemComposition(itemIds.get(0)).getName();
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(finalDescription)
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
