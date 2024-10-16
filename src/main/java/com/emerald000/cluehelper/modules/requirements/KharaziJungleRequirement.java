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

public class KharaziJungleRequirement implements ClueModule {

    private static final int[] machetes = {
            ItemID.MACHETE,
            ItemID.JADE_MACHETE,
            ItemID.OPAL_MACHETE,
            ItemID.RED_TOPAZ_MACHETE};

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final int agilityLevel = plugin.getClient().getRealSkillLevel(Skill.AGILITY);
        final int questProgress = plugin.getClient().getVarpValue(ClueQuest.LEGENDS_QUEST.getVarPlayer());

        // Can use shortcut
        final boolean optional = agilityLevel >= 79 && questProgress >= ClueQuest.LEGENDS_QUEST.getCompletedValue();

        // Axe
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        Color colour = Color.RED;
        String symbol = "✗";
        for (final int itemId : AxeRequirement.getAxes()) {
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
                .left(optional ? "Axe (optional)" : "Axe")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // Machete
        colour = Color.RED;
        symbol = "✗";
        for (final int itemId : machetes) {
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
                .left(optional ? "Machete (optional)" : "Machete")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());

        // Radimus notes
        if (questProgress < ClueQuest.LEGENDS_QUEST.getCompletedValue()) {
            colour = Color.RED;
            symbol = "✗";
            if (inventory != null && inventory.contains(ItemID.RADIMUS_NOTES_715)) {
                colour = Color.GREEN;
                symbol = "✓";
            }
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Radimus notes")
                    .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                    .right(symbol)
                    .rightColor(colour)
                    .build());
        }
    }
}
