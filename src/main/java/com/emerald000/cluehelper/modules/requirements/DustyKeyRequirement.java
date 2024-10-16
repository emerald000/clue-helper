package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class DustyKeyRequirement implements ClueModule {
    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final int agilityLevel = plugin.getClient().getRealSkillLevel(Skill.AGILITY);
        if (agilityLevel >= 70) {
            return;
        }
        Color colour;
        String symbol;
        final String message;
        if (agilityLevel + SkillRequirement.getMaxBoost(Skill.AGILITY, agilityLevel) >= 70) {
            message = "Dusty key or 70 Agility";
            colour = Color.YELLOW;
            symbol = "✓";
        } else {
            message = "Dusty key";
            colour = Color.RED;
            symbol = "✗";
        }
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        if (inventory != null && (inventory.contains(ItemID.DUSTY_KEY) || inventory.contains(ItemID.STEEL_KEY_RING))) {
            colour = Color.GREEN;
            symbol = "✓";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(message)
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
