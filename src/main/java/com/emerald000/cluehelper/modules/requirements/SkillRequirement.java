package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

@AllArgsConstructor
public class SkillRequirement implements ClueModule {

    @Getter
    private final Skill skill;
    @Getter
    private final int level;
    private final boolean boostable;

    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final Color colour;
        final String symbol;
        final int playerLevel = plugin.getClient().getRealSkillLevel(skill);
        if (playerLevel >= level) {
            return;
        } else if (boostable && playerLevel + getMaxBoost(skill, playerLevel) >= level) {
            colour = Color.YELLOW;
            symbol = "✓";
        } else {
            colour = Color.RED;
            symbol = "✗";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(level + " " + skill.getName())
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }

    public static int getMaxBoost(final Skill skill, final int level) {
        switch (skill) {
            case ATTACK:
            case DEFENCE:
            case STRENGTH:
            case RANGED:
            case MAGIC:
                // Smelling Salts
                return (level * 16) / 100 + 11;
            case HITPOINTS:
                // Honey Locust
                if (level <= 75) {
                    return 20;
                }
                // Ambrosia
                else {
                    return level / 4 + 2;
                }
            case PRAYER:
                // Eldritch Nightmare Staff
                return 60;
            case COOKING:
                // Spicy Stew
                if (level < 80) {
                    return 5;
                }
                // Chef's delight(m)
                else {
                    return 6;
                }
            case WOODCUTTING:
            case FLETCHING:
            case FISHING:
            case FIREMAKING:
            case CRAFTING:
            case SMITHING:
            case MINING:
            case HERBLORE:
            case AGILITY:
            case THIEVING:
            case SLAYER:
            case FARMING:
            case RUNECRAFT:
            case HUNTER:
            case CONSTRUCTION:
                // Spicy Stew
                return 5;
            default:
                return 0;
        }
    }
}
