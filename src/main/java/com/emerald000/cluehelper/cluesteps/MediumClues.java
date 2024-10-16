package com.emerald000.cluehelper.cluesteps;

import com.emerald000.cluehelper.clues.BasicClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.DigClue;
import com.emerald000.cluehelper.clues.EmoteClue;
import com.emerald000.cluehelper.clues.KeyClue;
import com.emerald000.cluehelper.clues.UnimplementedClue;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.locations.ObjectLocation;
import com.emerald000.cluehelper.modules.ObjectHighlightModule;
import com.emerald000.cluehelper.modules.QuestionModule;
import com.emerald000.cluehelper.modules.requirements.EmptySlotRequirement;
import com.emerald000.cluehelper.modules.requirements.EquipmentRequirement;
import com.emerald000.cluehelper.modules.requirements.QuestRequirement;
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

public final class MediumClues {
    private static final Map<Integer, Clue> clues = new HashMap<>(157);

    static {
        clues.put(ItemID.CLUE_SCROLL_MEDIUM, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2803, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2803, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2805, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2805, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2807, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2807, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2809, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2809, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2811, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2811, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2813, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2813, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2815, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2815, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2817, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2817, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2819, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2819, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2821, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2821, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2823, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2823, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2825, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2825, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2827, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2827, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2831, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2831, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2833, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2835, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2835, new KeyClue(ItemID.CLUE_SCROLL_MEDIUM_2833, ClueTier.MEDIUM,
                "East Ardougne, kill a guard for the key",
                new NPCLocation(new WorldPoint(2660, 3309, 0),
                        NpcID.GUARD_5418,
                        NpcID.GUARD_11937,
                        NpcID.GUARD_11938,
                        NpcID.GUARD_11939),
                ItemID.KEY_MEDIUM_2836,
                "East Ardougne, Jerico's house, 2nd floor",
                new ObjectLocation(new WorldPoint(2611, 3324, 1),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2837, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2837, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2839, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2839, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2843, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2843, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2845, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2845, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2847, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2847, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2848, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2848, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2849, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2849, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2851, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2851, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2853, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2853, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2855, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2855, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2856, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2856, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2857, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2857, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_2858, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_2858, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3582, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3582, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3584, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3584, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3586, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3586, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3588, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3588, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3590, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3590, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3592, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3592, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3594, new DigClue(ItemID.CLUE_SCROLL_MEDIUM_3594, ClueTier.MEDIUM,
                "Gnome Stronghold, swamp",
                2415, 3515, 2417, 3517, 0));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3596, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3596, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3598, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3598, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3599, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3599, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3601, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3601, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3602, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3602, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3604, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3604, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3605, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3605, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3607, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3607, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3609, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_3609, ClueTier.MEDIUM,
                "Canifis, clothes shop",
                new ObjectLocation(new WorldPoint(3498, 3507, 0),
                        ObjectID.CRATE_24344),
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3610, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3610, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3611, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3611, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3612, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3612, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3613, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3613, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3614, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3614, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3615, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3615, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3616, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3616, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3617, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3617, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_3618, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_3618, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7274, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7274, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7276, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7276, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7278, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7278, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7280, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7280, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7282, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7282, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7284, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7284, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7286, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7286, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7288, new DigClue(ItemID.CLUE_SCROLL_MEDIUM_7288, ClueTier.MEDIUM,
                "West of Mort'ton",
                3433, 3265, 3435, 3267, 0,
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7290, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7290, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7292, new DigClue(ItemID.CLUE_SCROLL_MEDIUM_7292, ClueTier.MEDIUM,
                "East of the Lighthouse",
                2577, 3596, 2579, 3598, 0));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7294, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7294, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7296, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7296, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7298, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7298, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7300, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7300, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7301, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7301, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7303, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7303, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7304, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_7304, ClueTier.MEDIUM,
                "Ranging Guild",
                new ObjectLocation(new WorldPoint(2671, 3437, 0),
                        ObjectID.CRATE_356),
                new SkillRequirement(Skill.RANGED, 40, true)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7305, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7305, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7307, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7307, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7309, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7309, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7311, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7311, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7313, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7313, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7315, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_7315, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_7317, new DigClue(ItemID.CLUE_SCROLL_MEDIUM_7317, ClueTier.MEDIUM,
                "Karamja, north of nature altar",
                2874, 3045, 2876, 3047, 0));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10254, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10254, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10256, new EmoteClue(ItemID.CLUE_SCROLL_MEDIUM_10256, ClueTier.MEDIUM,
                "Morytania, Mausoleum",
                new AreaLocation(3490, 3567, 3514, 3581, 0),
                Emote.PANIC,
                Emote.WAVE,
                new WorldPoint(3500, 3575, 0),
                NullObjectID.NULL_28988,
                new EquipmentRequirement(ItemID.MITHRIL_PLATESKIRT),
                new EquipmentRequirement(ItemID.MAPLE_LONGBOW),
                new EmptySlotRequirement(EquipmentInventorySlot.BOOTS),
                new SkillRequirement(Skill.DEFENCE, 20, false),
                new SkillRequirement(Skill.RANGED, 30, false),
                // TODO: Find correct varbit value
                new QuestRequirement(ClueQuest.CREATURE_OF_FENKENSTRAIN, 8)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10258, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10258, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10262, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10262, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10264, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10264, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10266, new EmoteClue(ItemID.CLUE_SCROLL_MEDIUM_10266, ClueTier.MEDIUM,
                "Gnome Stronghold, agility course, 3rd floor",
                new AreaLocation(2472, 3418, 2477, 3421, 2),
                Emote.CRY,
                Emote.NO,
                new WorldPoint(2473, 3418, 2),
                NullObjectID.NULL_28993,
                new EquipmentRequirement(ItemID.STEEL_KITESHIELD),
                new EquipmentRequirement(ItemID.RING_OF_FORGING),
                new EquipmentRequirement(ItemID.GREEN_DHIDE_CHAPS),
                new SkillRequirement(Skill.DEFENCE, 5, false),
                new SkillRequirement(Skill.RANGED, 40, false),
                new ObjectHighlightModule(new WorldPoint(2473, 3425, 0),
                        ObjectID.OBSTACLE_NET_23134),
                new ObjectHighlightModule(new WorldPoint(2473, 3422, 1),
                        ObjectID.TREE_BRANCH_23559)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10268, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10268, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10270, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10270, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10272, new EmoteClue(ItemID.CLUE_SCROLL_MEDIUM_10272, ClueTier.MEDIUM,
                "Combat Training Camp",
                new AreaLocation(2523, 3373, 2533, 3377, 0),
                Emote.CHEER,
                Emote.ANGRY,
                new WorldPoint(2533, 3377, 0),
                NullObjectID.NULL_28996,
                new EquipmentRequirement(ItemID.GREEN_DHIDE_BODY),
                new EquipmentRequirement(ItemID.GREEN_DHIDE_CHAPS),
                new EquipmentRequirement(ItemID.STEEL_SQ_SHIELD),
                new QuestRequirement(ClueQuest.DRAGON_SLAYER_I),
                new QuestRequirement(ClueQuest.BIOHAZARD),
                new SkillRequirement(Skill.RANGED, 40, false),
                new SkillRequirement(Skill.DEFENCE, 40, false)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10274, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10274, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10276, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10276, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_10278, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_10278, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12021, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12021, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12023, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12023, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12025, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12025, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12027, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12027, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12029, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12029, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12031, new EmoteClue(ItemID.CLUE_SCROLL_MEDIUM_12031, ClueTier.MEDIUM,
                "Edgeville, general store",
                new AreaLocation(3076, 3507, 3084, 3513, 0),
                Emote.CHEER,
                Emote.DANCE,
                new WorldPoint(3077, 3503, 0),
                NullObjectID.NULL_29005,
                new EquipmentRequirement(ItemID.BROWN_APRON),
                new EquipmentRequirement(ItemID.LEATHER_BOOTS),
                new EquipmentRequirement(ItemID.LEATHER_GLOVES)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12033, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12033, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12035, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12035, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12037, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12037, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12039, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12039, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12041, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12041, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12043, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12043, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12045, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12045, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12047, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12047, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12049, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12049, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12051, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12051, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12053, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12053, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12055, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12055, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12057, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12057, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12059, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12059, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12061, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12061, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12063, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12063, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12065, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_12065, ClueTier.MEDIUM,
                "Falador, pub",
                new NPCLocation(new WorldPoint(2958, 3371, 0),
                        NpcID.KAYLEE),
                new QuestionModule(18)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12067, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12067, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12069, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12069, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_12071, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_12071, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19734, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_19734, ClueTier.MEDIUM,
                "Shayzien Encampment, east of War Tent",
                new NPCLocation(new WorldPoint(1504, 3632, 0),
                        NpcID.CAPTAIN_GINEA),
                new QuestionModule(113)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19736, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19736, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19738, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19738, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19740, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19740, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19742, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19742, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19744, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19744, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19746, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19746, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19748, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19748, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19750, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19750, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19752, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_19752, ClueTier.MEDIUM,
                "Seers' Village, flax field",
                new NPCLocation(new WorldPoint(2744, 3444, 0),
                        NpcID.FLAX_KEEPER),
                new QuestionModule(676)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19754, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19754, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19756, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19756, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19758, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19758, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19760, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19760, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19762, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19762, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19766, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19766, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19768, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_19768, ClueTier.MEDIUM,
                "Pollnivneach, kebab store",
                new NPCLocation(new WorldPoint(3354, 2975, 0),
                        NpcID.ALI_THE_KEBAB_SELLER,
                        NpcID.ISMAIL_THE_KEBAB_SELLER),
                new QuestionModule(399)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19772, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_19772, ClueTier.MEDIUM,
                "Paterdomus Temple, Drezel",
                new NPCLocation(new WorldPoint(3440, 9895, 0),
                        NpcID.DREZEL),
                new QuestionModule(7),
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL, 8)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19774, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19774, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19776, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19776, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19778, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19778, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_19780, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_19780, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23046, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23046, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23131, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23131, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23133, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23133, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23135, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23135, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23136, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23136, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23137, new DigClue(ItemID.CLUE_SCROLL_MEDIUM_23137, ClueTier.MEDIUM,
                "Fossil Island, north-east island",
                3769, 3897, 3771, 3899, 0,
                new QuestRequirement(ClueQuest.BONE_VOYAGE)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23138, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23138, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23139, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23139, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23140, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23140, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23141, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23141, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23142, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23142, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_23143, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_23143, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_25783, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_25783, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_25784, new BasicClue(ItemID.CLUE_SCROLL_MEDIUM_25784, ClueTier.MEDIUM,
                "Shayzien pub",
                new NPCLocation(new WorldPoint(1551, 3565, 0),
                        NpcID.DRUNKEN_SOLDIER),
                new QuestionModule(598)));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_28907, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_28907, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_28908, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_28908, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_28909, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_28909, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_29857, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_29857, ClueTier.MEDIUM));
        clues.put(ItemID.CLUE_SCROLL_MEDIUM_29858, new UnimplementedClue(ItemID.CLUE_SCROLL_MEDIUM_29858, ClueTier.MEDIUM));
    }

    @Nullable
    public static Clue getClue(final int itemId) {
        return clues.get(itemId);
    }
}
