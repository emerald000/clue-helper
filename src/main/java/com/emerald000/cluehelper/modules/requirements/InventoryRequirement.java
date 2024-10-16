package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.Getter;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class InventoryRequirement implements ClueModule {

    @Getter
    private final List<Integer> itemIds = new ArrayList<>(1);
    private final int count;
    private final boolean optional;
    private final String display;

    public InventoryRequirement(final int itemId) {
        this(itemId, false);
    }

    public InventoryRequirement(final int itemId, final boolean optional) {
        this("", 1, optional, itemId);
    }

    public InventoryRequirement(final String display, final int... itemIds) {
        this(display, 1, false, itemIds);
    }

    public InventoryRequirement(final String display, final int count, final boolean optional, final int... itemIds) {
        this.display = display;
        this.count = count;
        this.optional = optional;
        for (final int itemId : itemIds) {
            this.itemIds.add(itemId);
        }
    }

    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        Color colour = Color.RED;
        String symbol = "✗";
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        for (final int itemId : itemIds) {
            if (inventory != null && inventory.count(itemId) >= count) {
                colour = Color.GREEN;
                symbol = "✓";
                break;
            } else {
                final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
                if (equipment != null && equipment.count(itemId) >= count) {
                    colour = Color.GREEN;
                    symbol = "✓";
                    break;
                }
            }
        }

        String finalDisplay = "";
        if (!display.isEmpty()) {
            finalDisplay = display;
        } else {
            if (count > 1) {
                finalDisplay = count + " ";
            }
            finalDisplay += plugin.getItemManager().getItemComposition(itemIds.get(0)).getName();
        }
        if (optional) {
            finalDisplay += " (optional)";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(finalDisplay)
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
