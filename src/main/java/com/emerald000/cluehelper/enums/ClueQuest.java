package com.emerald000.cluehelper.enums;

import com.emerald000.cluehelper.modules.requirements.SkillRequirement;
import lombok.Getter;
import net.runelite.api.Skill;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum ClueQuest {

    BIOHAZARD("Biohazard", 0, 68, 16),
    BONE_VOYAGE("Bone Voyage", 5795, 0, 50,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 10, true),
                    new SkillRequirement(Skill.HERBLORE, 10, true),
                    new SkillRequirement(Skill.THIEVING, 25, false))),
    CHILDREN_OF_THE_SUN("Children of the Sun", 9632, 0, 24),
    CREATURE_OF_FENKENSTRAIN("Creature of Fenkenstrain", 13715, 0, 9,
            List.of(),
            List.of(
                    new SkillRequirement(Skill.THIEVING, 25, true),
                    new SkillRequirement(Skill.CRAFTING, 20, true))),
    DESERT_TREASURE_I("Desert Treasure I", 358, 0, 15,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 15, true),
                    new SkillRequirement(Skill.FLETCHING, 10, true),
                    new SkillRequirement(Skill.SMITHING, 20, true),
                    new SkillRequirement(Skill.THIEVING, 42, true),
                    new SkillRequirement(Skill.HERBLORE, 10, true)),
            List.of(
                    new SkillRequirement(Skill.THIEVING, 53, false),
                    new SkillRequirement(Skill.MAGIC, 50, false),
                    new SkillRequirement(Skill.FIREMAKING, 50, true))),
    DEATH_PLATEAU("Death Plateau", 0, 314, 80),
    DRAGON_SLAYER_I("Dragon Slayer I", 0, 176, 10),
    ENTER_THE_ABYSS("Enter the Abyss", 0, 492, 4),
    FAIRYTALE_II_CURE_A_QUEEN("Fairytale II - Cure a Queen", 2326, 0, 90,
            List.of(
                    new SkillRequirement(Skill.CRAFTING, 31, true),
                    new SkillRequirement(Skill.WOODCUTTING, 36, true)),
            List.of(
                    new SkillRequirement(Skill.THIEVING, 40, false),
                    new SkillRequirement(Skill.FARMING, 49, true),
                    new SkillRequirement(Skill.HERBLORE, 57, true))),
    HORROR_FROM_THE_DEEP("Horror from the Deep", 34, 0, 10,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 35, true))),
    IN_AID_OF_THE_MYREQUE("In Aid of the Myreque", 1990, 0, 430,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 25, true),
                    new SkillRequirement(Skill.CRAFTING, 25, false),
                    new SkillRequirement(Skill.MINING, 15, false),
                    new SkillRequirement(Skill.MAGIC, 7, true))),
    LEGENDS_QUEST("Legends' Quest", 0, 139, 75,
            List.of(
                    new SkillRequirement(Skill.MINING, 50, true),
                    new SkillRequirement(Skill.SMITHING, 40, true),
                    new SkillRequirement(Skill.MAGIC, 59, true),
                    new SkillRequirement(Skill.CRAFTING, 40, true),
                    new SkillRequirement(Skill.COOKING, 53, true),
                    new SkillRequirement(Skill.FISHING, 53, true),
                    new SkillRequirement(Skill.HERBLORE, 25, true),
                    new SkillRequirement(Skill.WOODCUTTING, 36, true),
                    new SkillRequirement(Skill.AGILITY, 32, true),
                    new SkillRequirement(Skill.RANGED, 25, false)),
            List.of(
                    new SkillRequirement(Skill.AGILITY, 50, true),
                    new SkillRequirement(Skill.CRAFTING, 50, true),
                    new SkillRequirement(Skill.HERBLORE, 45, true),
                    new SkillRequirement(Skill.MAGIC, 56, true),
                    new SkillRequirement(Skill.MINING, 52, true),
                    new SkillRequirement(Skill.PRAYER, 42, true),
                    new SkillRequirement(Skill.SMITHING, 50, true),
                    new SkillRequirement(Skill.STRENGTH, 50, true),
                    new SkillRequirement(Skill.THIEVING, 50, true),
                    new SkillRequirement(Skill.WOODCUTTING, 50, true))),
    LUNAR_DIPLOMACY("Lunar Diplomacy", 2448, 0, 190,
            List.of(
                    new SkillRequirement(Skill.HERBLORE, 5, false),
                    new SkillRequirement(Skill.CRAFTING, 61, false),
                    new SkillRequirement(Skill.DEFENCE, 40, false),
                    new SkillRequirement(Skill.FIREMAKING, 49, false),
                    new SkillRequirement(Skill.MAGIC, 65, false),
                    new SkillRequirement(Skill.MINING, 60, false),
                    new SkillRequirement(Skill.WOODCUTTING, 55, false),
                    new SkillRequirement(Skill.AGILITY, 32, true))),
    MAKING_FRIENDS_WITH_MY_ARM("Making Friends with My Arm", 6528, 0, 200,
            List.of(
                    new SkillRequirement(Skill.FIREMAKING, 66, false),
                    new SkillRequirement(Skill.MINING, 72, true),
                    new SkillRequirement(Skill.CONSTRUCTION, 35, true),
                    new SkillRequirement(Skill.AGILITY, 68, true),
                    new SkillRequirement(Skill.FARMING, 29, true),
                    new SkillRequirement(Skill.HERBLORE, 31, true),
                    new SkillRequirement(Skill.THIEVING, 30, false),
                    new SkillRequirement(Skill.MAGIC, 66, true),
                    new SkillRequirement(Skill.COOKING, 62, true),
                    new SkillRequirement(Skill.FISHING, 62, true),
                    new SkillRequirement(Skill.SMITHING, 45, true),
                    new SkillRequirement(Skill.CRAFTING, 40, true),
                    new SkillRequirement(Skill.HUNTER, 10, false))),
    MOURNINGS_END_PART_I("Mourning's End Part I", 0, 517, 9,
            List.of(
                    new SkillRequirement(Skill.RANGED, 60, false),
                    new SkillRequirement(Skill.THIEVING, 50, false),
                    new SkillRequirement(Skill.AGILITY, 56, true),
                    new SkillRequirement(Skill.FLETCHING, 5, true),
                    new SkillRequirement(Skill.COOKING, 30, true))),
    MOURNINGS_END_PART_II("Mourning's End Part II", 1103, 0, 60,
            List.of(
                    new SkillRequirement(Skill.RANGED, 60, false),
                    new SkillRequirement(Skill.THIEVING, 50, false),
                    new SkillRequirement(Skill.AGILITY, 56, true),
                    new SkillRequirement(Skill.FLETCHING, 5, true),
                    new SkillRequirement(Skill.COOKING, 30, true))),
    PRIEST_IN_PERIL("Priest in Peril", 0, 302, 60),
    REGICIDE("Regicide", 0, 328, 15,
            List.of(
                    new SkillRequirement(Skill.CRAFTING, 10, false),
                    new SkillRequirement(Skill.RANGED, 25, false)),
            List.of(
                    new SkillRequirement(Skill.AGILITY, 56, true))),
    SHADES_OF_MORTTON("Shades of Mort'ton", 0, 339, 85,
            List.of(
                    new SkillRequirement(Skill.CRAFTING, 20, true),
                    new SkillRequirement(Skill.HERBLORE, 15, true),
                    new SkillRequirement(Skill.FIREMAKING, 5, true))),
    SONG_OF_THE_ELVES("Song of the Elves", 9016, 0, 200,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 70, false),
                    new SkillRequirement(Skill.CONSTRUCTION, 70, false),
                    new SkillRequirement(Skill.FARMING, 70, false),
                    new SkillRequirement(Skill.HERBLORE, 70, false),
                    new SkillRequirement(Skill.HUNTER, 70, false),
                    new SkillRequirement(Skill.MINING, 70, false),
                    new SkillRequirement(Skill.SMITHING, 70, false),
                    new SkillRequirement(Skill.WOODCUTTING, 70, false),
                    new SkillRequirement(Skill.RANGED, 60, false),
                    new SkillRequirement(Skill.FLETCHING, 5, true),
                    new SkillRequirement(Skill.COOKING, 30, true),
                    new SkillRequirement(Skill.THIEVING, 50, false))),
    THE_GRAND_TREE("The Grand Tree", 0, 150, 160,
            List.of(),
            List.of(
                    new SkillRequirement(Skill.AGILITY, 25, true))),
    THE_TOURIST_TRAP("The Tourist Trap", 0, 197, 30,
            List.of(),
            List.of(
                    new SkillRequirement(Skill.SMITHING, 20, true),
                    new SkillRequirement(Skill.FLETCHING, 10, true))),
    TREE_GNOME_VILLAGE("Tree Gnome Village", 0, 111, 9),
    WATCHTOWER("Watchtower", 0, 212, 13,
            List.of(
                    new SkillRequirement(Skill.AGILITY, 18, true)),
            List.of(
                    new SkillRequirement(Skill.MAGIC, 14, true),
                    new SkillRequirement(Skill.THIEVING, 15, true),
                    new SkillRequirement(Skill.AGILITY, 25, true),
                    new SkillRequirement(Skill.HERBLORE, 14, true),
                    new SkillRequirement(Skill.MINING, 40, true)));

    private final String name;
    private final int varbit;
    private final int varPlayer;
    private final int completedValue;
    // Skill requirements to start the quest
    private final List<SkillRequirement> startRequirements;
    // Extra skill requirements to finish the quest
    private final List<SkillRequirement> finishRequirements;

    ClueQuest(final String name,
              final int varbit,
              final int varPlayer,
              final int completedValue) {
        this(name, varbit, varPlayer, completedValue, new ArrayList<>(0));
    }

    ClueQuest(final String name,
              final int varbit,
              final int varPlayer,
              final int completedValue,
              final List<SkillRequirement> startRequirements) {
        this(name, varbit, varPlayer, completedValue, startRequirements, new ArrayList<>(0));
    }

    ClueQuest(final String name,
              final int varbit,
              final int varPlayer,
              final int completedValue,
              final List<SkillRequirement> startRequirements,
              final List<SkillRequirement> finishRequirements) {
        this.name = name;
        this.varbit = varbit;
        this.varPlayer = varPlayer;
        this.completedValue = completedValue;
        this.startRequirements = startRequirements;
        this.finishRequirements = finishRequirements;
    }
}
