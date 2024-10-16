package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class SalveIslandRequirement implements ClueModule {
    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        final Client client = plugin.getClient();
        final int agilityLevel = client.getRealSkillLevel(Skill.AGILITY);
        if (agilityLevel < 50
                && client.getVarbitValue(ClueQuest.FAIRYTALE_II_CURE_A_QUEEN.getVarbit()) < 40) {
            final Color colour;
            final String symbol;
            if (agilityLevel + SkillRequirement.getMaxBoost(Skill.AGILITY, agilityLevel) >= 50) {
                colour = Color.YELLOW;
                symbol = "✓";
            } else {
                colour = Color.RED;
                symbol = "✗";
            }

            panelComponent.getChildren().add(LineComponent.builder()
                    .left("50 Agility or Fairytale II - Cure a Queen (partial)")
                    .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                    .right(symbol)
                    .rightColor(colour)
                    .build());
        }
    }
}
