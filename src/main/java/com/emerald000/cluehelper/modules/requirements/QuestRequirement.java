package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

public class QuestRequirement implements ClueModule {

    private final ClueQuest quest;
    private final int alternateVarbit;
    private final int alternateVarPlayer;
    private final int varValue;

    public QuestRequirement(final ClueQuest quest) {
        this(quest, 0);
    }

    public QuestRequirement(final ClueQuest quest, final int varValue) {
        this(quest, 0, 0, varValue);
    }

    public QuestRequirement(final ClueQuest quest, final int alternateVarbit, final int alternateVarPlayer, final int varValue) {
        this.quest = quest;
        this.alternateVarbit = alternateVarbit;
        this.alternateVarPlayer = alternateVarPlayer;
        this.varValue = varValue;
    }

    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {

        final int targetValue;
        if (varValue == 0) {
            targetValue = quest.getCompletedValue();
        } else {
            targetValue = varValue;
        }

        final int questValue;
        if (alternateVarbit != 0) {
            questValue = plugin.getClient().getVarbitValue(alternateVarbit);
        } else if (alternateVarPlayer != 0) {
            questValue = plugin.getClient().getVarpValue(alternateVarPlayer);
        } else if (quest.getVarPlayer() != 0) {
            questValue = plugin.getClient().getVarpValue(quest.getVarPlayer());
        } else {
            questValue = plugin.getClient().getVarbitValue(quest.getVarbit());
        }

        if (questValue >= targetValue) {
            return;
        }

        String outputString = quest.getName();
        if (varValue != 0) {
            outputString += " (partial)";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(outputString)
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right("✗")
                .rightColor(Color.RED)
                .build());

        if (questValue == 0) {
            startRequirement:
            for (final SkillRequirement startRequirement : quest.getStartRequirements()) {
                // Don't duplicate skill requirements
                final Skill skill = startRequirement.getSkill();
                final int level = startRequirement.getLevel();
                if (plugin.getActiveClue() != null) {
                    for (final ClueModule clueModule : plugin.getActiveClue().getClueModules()) {
                        if (clueModule instanceof SkillRequirement) {
                            final SkillRequirement clueModuleSkillRequirement = (SkillRequirement) clueModule;
                            if (clueModuleSkillRequirement.getSkill() == skill && clueModuleSkillRequirement.getLevel() > level) {
                                continue startRequirement;
                            }
                        }
                    }
                }
                for (final SkillRequirement finishRequirement : quest.getFinishRequirements()) {
                    if (finishRequirement.getSkill() == skill && finishRequirement.getLevel() > level) {
                        continue startRequirement;
                    }
                }
                startRequirement.renderOverlayPanel(plugin, panelComponent);
            }
        }

        finishRequirement:
        for (final SkillRequirement finishRequirement : quest.getFinishRequirements()) {
            // Don't duplicate skill requirements
            final Skill skill = finishRequirement.getSkill();
            final int level = finishRequirement.getLevel();
            if (plugin.getActiveClue() != null) {
                for (final ClueModule clueModule : plugin.getActiveClue().getClueModules()) {
                    if (clueModule instanceof SkillRequirement) {
                        final SkillRequirement clueModuleSkillRequirement = (SkillRequirement) clueModule;
                        if (clueModuleSkillRequirement.getSkill() == skill && clueModuleSkillRequirement.getLevel() > level) {
                            continue finishRequirement;
                        }
                    }
                }
            }
            for (final SkillRequirement startRequirement : quest.getStartRequirements()) {
                if (startRequirement.getSkill() == skill && startRequirement.getLevel() > level) {
                    continue finishRequirement;
                }
            }
            finishRequirement.renderOverlayPanel(plugin, panelComponent);
        }
    }
}
