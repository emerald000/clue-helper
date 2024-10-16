package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.Rune;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class ViyeldiCavesRequirement implements ClueModule {
    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        if (plugin.getClient().getRealSkillLevel(Skill.AGILITY) >= 96) {
            return;
        }

        // Pickaxe
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        Color colour = Color.RED;
        String symbol = "✗";
        for (final int itemId : PickaxeRequirement.getPickaxes()) {
            if (inventory != null && inventory.contains(itemId)) {
                colour = Color.GREEN;
                symbol = "✓";
                break;
            } else if (equipment != null && equipment.contains(itemId)) {
                colour = Color.GREEN;
                symbol = "✓";
                break;
            }
        }
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Pickaxe")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // Lockpick
        colour = Color.RED;
        symbol = "✗";
        if (inventory != null && inventory.contains(ItemID.LOCKPICK)) {
            colour = Color.GREEN;
            symbol = "✓";
        }
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Lockpick")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // Unpowered orb
        colour = Color.RED;
        symbol = "✗";
        if (inventory != null && inventory.contains(ItemID.UNPOWERED_ORB)) {
            colour = Color.GREEN;
            symbol = "✓";
        }
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Unpowered orb")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // 3 Cosmic runes
        colour = Color.RED;
        symbol = "✗";
        if (Rune.getRuneCount(plugin.getClient(), Rune.COSMIC) >= 3) {
            colour = Color.GREEN;
            symbol = "✓";
        }
        panelComponent.getChildren().add(LineComponent.builder()
                .left("3 Cosmic runes")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // 30 Elemental runes
        colour = Color.RED;
        symbol = "✗";
        if (Rune.getRuneCount(plugin.getClient(), Rune.AIR) >= 30 ||
                Rune.getRuneCount(plugin.getClient(), Rune.WATER) >= 30 ||
                Rune.getRuneCount(plugin.getClient(), Rune.EARTH) >= 30 ||
                Rune.getRuneCount(plugin.getClient(), Rune.FIRE) >= 30) {
            colour = Color.GREEN;
            symbol = "✓";
        }
        panelComponent.getChildren().add(LineComponent.builder()
                .left("30 elemental runes")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
