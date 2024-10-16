package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class GuTanothGPRequirement implements ClueModule {
    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        if (plugin.getClient().getVarpValue(ClueQuest.WATCHTOWER.getVarPlayer()) < ClueQuest.WATCHTOWER.getCompletedValue()
                || plugin.getClient().getRealSkillLevel(Skill.AGILITY) < 71) {

            Color colour = Color.RED;
            String symbol = "✗";
            final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
            if (inventory != null && inventory.count(ItemID.COINS_995) >= 20) {
                colour = Color.GREEN;
                symbol = "✓";
            }

            panelComponent.getChildren().add(LineComponent.builder()
                    .left("20 Coins")
                    .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                    .right(symbol)
                    .rightColor(colour)
                    .build());
        }
    }
}
