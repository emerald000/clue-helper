package com.emerald000.cluehelper.cluesteps;

import com.emerald000.cluehelper.clues.CeciliaClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.BasicClue;
import com.emerald000.cluehelper.clues.DigClue;
import com.emerald000.cluehelper.clues.EmoteClue;
import com.emerald000.cluehelper.clues.UnimplementedClue;
import com.emerald000.cluehelper.descriptions.ElunedDescription;
import com.emerald000.cluehelper.enums.ClueEnemy;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.locations.ElunedLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.locations.ObjectLocation;
import com.emerald000.cluehelper.modules.EnemyModule;
import com.emerald000.cluehelper.modules.ObjectHighlightModule;
import com.emerald000.cluehelper.modules.QuestionModule;
import com.emerald000.cluehelper.modules.requirements.EmptySlotRequirement;
import com.emerald000.cluehelper.modules.requirements.EquipmentRequirement;
import com.emerald000.cluehelper.modules.requirements.GuTanothGPRequirement;
import com.emerald000.cluehelper.modules.requirements.PickaxeRequirement;
import com.emerald000.cluehelper.modules.requirements.QuestRequirement;
import com.emerald000.cluehelper.modules.requirements.SalveIslandRequirement;
import com.emerald000.cluehelper.modules.requirements.SkillRequirement;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public final class HardClues {
    private static final Map<Integer, Clue> clues = new HashMap<>(182);

    static {
        clues.put(ItemID.CLUE_SCROLL_HARD, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2723, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2723, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2725, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2725, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2727, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2727, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2729, new DigClue(ItemID.CLUE_SCROLL_HARD_2729, ClueTier.HARD,
                "Wilderness, magic axe hut, level 56",
                3188, 3962, 3190, 3964, 0,
                new EnemyModule(ClueEnemy.ZAMORAK_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2731, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2731, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2733, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2733, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2735, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2735, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2737, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2737, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2739, new DigClue(ItemID.CLUE_SCROLL_HARD_2739, ClueTier.HARD,
                "Wilderness, Pirates' Hideout, level 56",
                3038, 3959, 3040, 3961, 0,
                new EnemyModule(ClueEnemy.ZAMORAK_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2741, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2741, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2743, new DigClue(ItemID.CLUE_SCROLL_HARD_2743, ClueTier.HARD,
                "Wilderness, Graveyard of Shadows, level 20",
                3167, 3676, 3169, 3678, 0,
                new EnemyModule(ClueEnemy.ZAMORAK_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2745, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2745, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2747, new DigClue(ItemID.CLUE_SCROLL_HARD_2747, ClueTier.HARD,
                "Wilderness, south of the Silk Chasm, level 32",
                3310, 3768, 3312, 3770, 0,
                new EnemyModule(ClueEnemy.ZAMORAK_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2773, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2773, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2774, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2774, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2776, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2776, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2778, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2778, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2780, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2780, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2782, new BasicClue(ItemID.CLUE_SCROLL_HARD_2782, ClueTier.HARD,
                "Lumbridge Castle, 2nd floor",
                new ObjectLocation(new WorldPoint(3213, 3216, 1),
                        ObjectID.DRAWERS_5618,
                        ObjectID.DRAWERS_5619)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2783, new DigClue(ItemID.CLUE_SCROLL_HARD_2783, ClueTier.HARD,
                "Ardougne Zoo, south entrance",
                2597, 3266, 2599, 3268, 0));
        clues.put(ItemID.CLUE_SCROLL_HARD_2785, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2785, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2786, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2786, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2788, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2788, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2790, new DigClue(ItemID.CLUE_SCROLL_HARD_2790, ClueTier.HARD,
                "Varrock Sewers, moss giants",
                3160, 9903, 3162, 9905, 0));
        clues.put(ItemID.CLUE_SCROLL_HARD_2792, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2792, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2793, new BasicClue(ItemID.CLUE_SCROLL_HARD_2793, ClueTier.HARD,
                "Edgeville Monastery",
                new NPCLocation(new WorldPoint(3058, 3484, 0),
                        NpcID.ABBOT_LANGLEY)));
        clues.put(ItemID.CLUE_SCROLL_HARD_2794, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2794, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2796, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2796, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2797, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_2797, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_2799, new BasicClue(ItemID.CLUE_SCROLL_HARD_2799, ClueTier.HARD,
                "Goblin Village",
                new NPCLocation(new WorldPoint(2957, 3511, 0),
                        NpcID.GENERAL_BENTNOZE)));
        clues.put(ItemID.CLUE_SCROLL_HARD_3520, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3520, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3522, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3522, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3524, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3524, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3525, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3525, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3526, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3526, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3528, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3528, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3530, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3530, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3532, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3532, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3534, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3534, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3536, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3536, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3538, new DigClue(ItemID.CLUE_SCROLL_HARD_3538, ClueTier.HARD,
                "Ship Yard",
                2960, 3023, 2962, 3025, 0,
                new QuestRequirement(ClueQuest.THE_GRAND_TREE, 80),
                new EnemyModule(ClueEnemy.SARADOMIN_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_3540, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3540, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3542, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3542, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3544, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3544, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3546, new DigClue(ItemID.CLUE_SCROLL_HARD_3546, ClueTier.HARD,
                "Gu'Tanoth, raised area",
                2541, 3030, 2543, 3032, 0,
                new QuestRequirement(ClueQuest.WATCHTOWER, 4),
                new GuTanothGPRequirement(),
                new EnemyModule(ClueEnemy.SARADOMIN_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_3548, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3548, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3550, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3550, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3552, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3552, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3554, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3554, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3556, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3556, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3558, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3558, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3560, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3560, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3562, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3562, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3564, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3564, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3566, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3566, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3568, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3568, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3570, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3570, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3572, new BasicClue(ItemID.CLUE_SCROLL_HARD_3572, ClueTier.HARD,
                "Sorcerer's Tower, 2nd floor",
                new ObjectLocation(new WorldPoint(2702, 3409, 1),
                        ObjectID.BOOKCASE_380)));
        clues.put(ItemID.CLUE_SCROLL_HARD_3573, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3573, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3574, new BasicClue(ItemID.CLUE_SCROLL_HARD_3574, ClueTier.HARD,
                "South of Coal Trucks",
                new ObjectLocation(new WorldPoint(2576, 3464, 0),
                        ObjectID.BOXES_6176)));
        clues.put(ItemID.CLUE_SCROLL_HARD_3575, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3575, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3577, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3577, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3579, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3579, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_3580, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_3580, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7239, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7239, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7241, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7241, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7243, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7243, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7245, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7245, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7247, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7247, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7248, new BasicClue(ItemID.CLUE_SCROLL_HARD_7248, ClueTier.HARD,
                "Desert Bandit Camp, general store",
                new ObjectLocation(new WorldPoint(3178, 2987, 0),
                        ObjectID.CRATE_354)));
        clues.put(ItemID.CLUE_SCROLL_HARD_7249, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7249, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7250, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7250, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7251, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7251, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7252, new BasicClue(ItemID.CLUE_SCROLL_HARD_7252, ClueTier.HARD,
                "Yanille Agility Dungeon, pray at Altar and fall down",
                new ObjectLocation(new WorldPoint(2576, 9583, 0),
                        ObjectID.CRATE_357),
                new ObjectHighlightModule(new WorldPoint(2571, 9499, 0),
                        ObjectID.CHAOS_ALTAR_412),
                new SkillRequirement(Skill.AGILITY, 40, true)));
        clues.put(ItemID.CLUE_SCROLL_HARD_7253, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7253, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7254, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7254, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7255, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7255, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7256, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7256, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7258, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7258, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7260, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7260, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7262, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7262, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7264, new DigClue(ItemID.CLUE_SCROLL_HARD_7264, ClueTier.HARD,
                "Wilderness, black salamanders, level 22",
                3304, 3691, 3306, 3693, 0,
                new EnemyModule(ClueEnemy.ZAMORAK_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_7266, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7266, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7268, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7268, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7270, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7270, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_7272, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_7272, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10234, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10234, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10236, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10236, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10238, new EmoteClue(ItemID.CLUE_SCROLL_HARD_10238, ClueTier.HARD,
                "Lighthouse, top floor",
                new AreaLocation(2504, 3637, 2513, 3645, 2),
                Emote.BOW,
                new WorldPoint(2512, 3640, 2),
                NullObjectID.NULL_29011,
                new EquipmentRequirement(ItemID.BLUE_DHIDE_BODY),
                new EquipmentRequirement(ItemID.BLUE_DHIDE_VAMBRACES),
                new EmptySlotRequirement(EquipmentInventorySlot.AMULET),
                new EmptySlotRequirement(EquipmentInventorySlot.RING),
                new QuestRequirement(ClueQuest.HORROR_FROM_THE_DEEP, 3),
                new SkillRequirement(Skill.RANGED, 50, false),
                new SkillRequirement(Skill.DEFENCE, 40, false),
                new EnemyModule(ClueEnemy.DOUBLE_AGENT)));
        clues.put(ItemID.CLUE_SCROLL_HARD_10240, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10240, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10242, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10242, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10244, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10244, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10246, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10246, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10248, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10248, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10250, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10250, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_10252, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_10252, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12542, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12542, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12544, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12544, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12546, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12546, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12548, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12548, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12550, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12550, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12552, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12552, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12554, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12554, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12556, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12556, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12558, new DigClue(ItemID.CLUE_SCROLL_HARD_12558, ClueTier.HARD,
                "Ardougne Island (AIR)",
                2698, 3250, 2700, 3252, 0,
                new QuestRequirement(ClueQuest.FAIRYTALE_II_CURE_A_QUEEN, 40),
                new EnemyModule(ClueEnemy.SARADOMIN_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_12560, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12560, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12562, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12562, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12564, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12564, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12566, new BasicClue(ItemID.CLUE_SCROLL_HARD_12566, ClueTier.HARD,
                "Motherload Mine, Prospector Percy",
                new NPCLocation(new WorldPoint(3116, 9698, 0),
                        NpcID.PROSPECTOR_PERCY),
                new PickaxeRequirement(true),
                new QuestionModule(12)));
        clues.put(ItemID.CLUE_SCROLL_HARD_12568, new BasicClue(ItemID.CLUE_SCROLL_HARD_12568, ClueTier.HARD,
                "Barrows, Strange Old Man",
                new NPCLocation(new WorldPoint(3565, 3292, 0),
                        NpcID.STRANGE_OLD_MAN),
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL),
                new QuestionModule(40)));
        clues.put(ItemID.CLUE_SCROLL_HARD_12570, new BasicClue(ItemID.CLUE_SCROLL_HARD_12570, ClueTier.HARD,
                "Rogues' Den",
                new NPCLocation(new WorldPoint(3051, 4974, 1),
                        NpcID.MARTIN_THWAIT),
                new QuestionModule(2)));
        clues.put(ItemID.CLUE_SCROLL_HARD_12572, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12572, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12574, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12574, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12576, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12576, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12578, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12578, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12581, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12581, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12584, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12584, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12587, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_12587, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_12590, new DigClue(ItemID.CLUE_SCROLL_HARD_12590, ClueTier.HARD,
                "Barbarian Village mine",
                3079, 3419, 3083, 3423, 0));
        clues.put(ItemID.CLUE_SCROLL_HARD_19840, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19840, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19842, new DigClue(ItemID.CLUE_SCROLL_HARD_19842, ClueTier.HARD,
                "Lovakengj, Burning Man",
                1459, 3781, 1461, 3783, 0,
                new EnemyModule(ClueEnemy.SARADOMIN_WIZARD)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19844, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19844, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19846, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19846, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19848, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19848, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19850, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19850, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19852, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19852, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19853, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19853, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19854, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19854, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19856, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19856, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19857, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19857, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19858, new BasicClue(ItemID.CLUE_SCROLL_HARD_19858, ClueTier.HARD,
                "Tree Gnome Village, spirit tree",
                new ObjectLocation(new WorldPoint(2543, 3168, 0),
                        NullObjectID.NULL_1293),
                new QuestRequirement(ClueQuest.TREE_GNOME_VILLAGE),
                new QuestionModule(13112221)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19860, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19860, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19862, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19862, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19864, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19864, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19866, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19866, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19868, new DigClue(ItemID.CLUE_SCROLL_HARD_19868, ClueTier.HARD,
                "River Salve Island (BIP)",
                3407, 3330, 3407, 3330, 0,
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL),
                new SalveIslandRequirement()));
        clues.put(ItemID.CLUE_SCROLL_HARD_19870, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19870, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19872, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19872, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19874, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19874, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19876, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19876, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19878, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19878, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19880, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19880, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19882, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19882, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19884, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19884, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19886, new BasicClue(ItemID.CLUE_SCROLL_HARD_19886, ClueTier.HARD,
                "Lumbridge Guide",
                new NPCLocation(new WorldPoint(3238, 3220, 0),
                        NpcID.LUMBRIDGE_GUIDE)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19888, new BasicClue(ItemID.CLUE_SCROLL_HARD_19888, ClueTier.HARD,
                "Abyss, inner circle",
                new NPCLocation(new WorldPoint(3039, 4834, 0),
                        NpcID.DARK_MAGE),
                new QuestRequirement(ClueQuest.ENTER_THE_ABYSS),
                new QuestionModule(13)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19890, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19890, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19892, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19892, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19894, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19894, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19896, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19896, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19898, new BasicClue(ItemID.CLUE_SCROLL_HARD_19898, ClueTier.HARD,
                new ElunedDescription(),
                new ElunedLocation(),
                new QuestionModule(53000),
                new QuestRequirement(ClueQuest.REGICIDE, 8),
                new SkillRequirement(Skill.AGILITY, 56, true)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19900, new BasicClue(ItemID.CLUE_SCROLL_HARD_19900, ClueTier.HARD,
                "Otto's Grotto, south of Barbarian Outpost",
                new NPCLocation(new WorldPoint(2502, 3489, 0),
                        NpcID.OTTO_GODBLESSED),
                new QuestionModule(3)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19902, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19902, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19904, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19904, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19906, new BasicClue(ItemID.CLUE_SCROLL_HARD_19906, ClueTier.HARD,
                "Fisher Realm, King Percival, 2nd floor",
                new NPCLocation(new WorldPoint(2634, 4682, 1),
                        NpcID.KING_PERCIVAL),
                new QuestionModule(5)));
        clues.put(ItemID.CLUE_SCROLL_HARD_19908, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19908, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_19910, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_19910, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_21526, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_21526, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_21527, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_21527, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23045, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23045, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23167, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23167, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23168, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23168, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23169, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23169, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23170, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23170, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23172, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23172, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23174, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23174, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23175, new CeciliaClue(ItemID.CLUE_SCROLL_HARD_23175, ClueTier.HARD,
                "Complication", 346, 2));
        clues.put(ItemID.CLUE_SCROLL_HARD_23176, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23176, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23177, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23177, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23178, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23178, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23179, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23179, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23180, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23180, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_23181, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_23181, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_24493, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_24493, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_25790, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_25790, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_25791, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_25791, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_25792, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_25792, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_26566, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_26566, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_28915, new DigClue(ItemID.CLUE_SCROLL_HARD_28915, ClueTier.HARD,
                "Avium Savannah, fairy ring",
                1646, 3012, 1646, 3012, 0,
                new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN)));
        clues.put(ItemID.CLUE_SCROLL_HARD_28916, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_28916, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_28918, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_28918, ClueTier.HARD));
        clues.put(ItemID.CLUE_SCROLL_HARD_29859, new UnimplementedClue(ItemID.CLUE_SCROLL_HARD_28918, ClueTier.HARD));
    }

    @Nullable
    public static Clue getClue(final int itemId) {
        return clues.get(itemId);
    }
}
