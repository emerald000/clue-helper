package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AllArgsConstructor;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.http.api.item.ItemStats;

import java.awt.Color;

@AllArgsConstructor
public class RangedAttackRequirement implements ClueModule {
    private final int requiredRangedAttack;

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        int currentRangedAttack = 0;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        if (equipment != null) {
            for (final Item item : equipment.getItems()) {
                final ItemStats itemStats = plugin.getItemManager().getItemStats(item.getId(), false);
                if (itemStats != null) {
                    currentRangedAttack += itemStats.getEquipment().getArange();
                }
            }
        }

        Color colour = Color.RED;
        if (currentRangedAttack >= requiredRangedAttack) {
            colour = Color.GREEN;
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(requiredRangedAttack + " ranged attack")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(Integer.toString(currentRangedAttack))
                .rightColor(colour)
                .build());
    }
}
