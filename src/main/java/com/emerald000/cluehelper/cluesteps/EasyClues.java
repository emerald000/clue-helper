package com.emerald000.cluehelper.cluesteps;

import com.emerald000.cluehelper.clues.BasicClue;
import com.emerald000.cluehelper.clues.CeciliaClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.DigClue;
import com.emerald000.cluehelper.clues.EmoteClue;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.locations.ObjectLocation;
import com.emerald000.cluehelper.modules.requirements.EquipmentRequirement;
import com.emerald000.cluehelper.modules.requirements.NothingEquippedRequirement;
import com.emerald000.cluehelper.modules.requirements.QuestRequirement;
import com.emerald000.cluehelper.modules.requirements.SkillRequirement;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public final class EasyClues {
    private static final Map<Integer, Clue> clues = new HashMap<>(164);

    static {
        clues.put(ItemID.CLUE_SCROLL_EASY, new BasicClue(ItemID.CLUE_SCROLL_EASY, ClueTier.EASY,
                "Lumbridge Castle, second floor",
                new ObjectLocation(new WorldPoint(3209, 3218, 1),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2678, new BasicClue(ItemID.CLUE_SCROLL_EASY_2678, ClueTier.EASY,
                "Lumbridge Castle entrance, south tower, 2nd floor",
                new ObjectLocation(new WorldPoint(3228, 3212, 1),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2679, new BasicClue(ItemID.CLUE_SCROLL_EASY_2679, ClueTier.EASY,
                "Lumbridge, Goblin house, east of river",
                new ObjectLocation(new WorldPoint(3245, 3245, 0),
                        ObjectID.BOXES)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2680, new BasicClue(ItemID.CLUE_SCROLL_EASY_2691, ClueTier.EASY,
                "Al Kharid Palace, 2nd floor",
                new ObjectLocation(new WorldPoint(3301, 3169, 1),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2681, new BasicClue(ItemID.CLUE_SCROLL_EASY_2681, ClueTier.EASY,
                "Lumbridge Castle, Hans",
                new NPCLocation(new WorldPoint(3221, 3219, 0),
                        NpcID.HANS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2682, new BasicClue(ItemID.CLUE_SCROLL_EASY_2682, ClueTier.EASY,
                "Al Kharid, north house",
                new ObjectLocation(new WorldPoint(3289, 3202, 0),
                        ObjectID.CRATE_358)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2683, new BasicClue(ItemID.CLUE_SCROLL_EASY_2683, ClueTier.EASY,
                "Al Kharid, scimitar shop",
                new NPCLocation(new WorldPoint(3288, 3190, 0),
                        NpcID.ZEKE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2684, new BasicClue(ItemID.CLUE_SCROLL_EASY_2684, ClueTier.EASY,
                "Al Kharid, tannery",
                new NPCLocation(new WorldPoint(3274, 3191, 0),
                        NpcID.ELLIS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2685, new BasicClue(ItemID.CLUE_SCROLL_EASY_2685, ClueTier.EASY,
                "Varrock, south entrance",
                new ObjectLocation(new WorldPoint(3203, 3384, 0),
                        ObjectID.BOXES_5111)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2686, new BasicClue(ItemID.CLUE_SCROLL_EASY_2686, ClueTier.EASY,
                "Varrock, Blue Moon Inn",
                new NPCLocation(new WorldPoint(3226, 3398, 0),
                        NpcID.BARTENDER_1312)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2687, new BasicClue(ItemID.CLUE_SCROLL_EASY_2687, ClueTier.EASY,
                "Varrock, east bank, 2nd floor",
                new ObjectLocation(new WorldPoint(3250, 3420, 1),
                        ObjectID.DRAWERS_7194,
                        ObjectID.DRAWERS_7195)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2688, new BasicClue(ItemID.CLUE_SCROLL_EASY_2688, ClueTier.EASY,
                "Varrock, platebody shop",
                new ObjectLocation(new WorldPoint(3228, 3433, 0),
                        ObjectID.CRATE_5106)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2689, new BasicClue(ItemID.CLUE_SCROLL_EASY_2689, ClueTier.EASY,
                "West of Varrock, Gertrude's house",
                new ObjectLocation(new WorldPoint(3156, 3406, 0),
                        ObjectID.DRAWERS_7194,
                        ObjectID.DRAWERS_7195)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2690, new BasicClue(ItemID.CLUE_SCROLL_EASY_2690, ClueTier.EASY,
                "Barbarian Village, helmet shop",
                new ObjectLocation(new WorldPoint(3073, 3430, 0),
                        ObjectID.CRATES_11600)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2691, new BasicClue(ItemID.CLUE_SCROLL_EASY_2680, ClueTier.EASY,
                "Falador, shield shop, 2nd floor",
                new ObjectLocation(new WorldPoint(2971, 3386, 1),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2692, new BasicClue(ItemID.CLUE_SCROLL_EASY_2692, ClueTier.EASY,
                "Falador, general store",
                new ObjectLocation(new WorldPoint(2955, 3390, 0),
                        ObjectID.CRATES_24088)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2693, new BasicClue(ItemID.CLUE_SCROLL_EASY_2693, ClueTier.EASY,
                "Falador Castle, courtyard",
                new NPCLocation(new WorldPoint(2977, 3342, 0),
                        NpcID.SQUIRE_4737)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2694, new BasicClue(ItemID.CLUE_SCROLL_EASY_2694, ClueTier.EASY,
                "Falador, chainmail shop",
                new ObjectLocation(new WorldPoint(2969, 3311, 0),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2695, new BasicClue(ItemID.CLUE_SCROLL_EASY_2695, ClueTier.EASY,
                "Port Sarim, fishing shop",
                new ObjectLocation(new WorldPoint(3012, 3222, 0),
                        ObjectID.CRATE_9534)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2696, new BasicClue(ItemID.CLUE_SCROLL_EASY_2696, ClueTier.EASY,
                "Port Sarim, pub",
                new NPCLocation(new WorldPoint(3047, 3257, 0),
                        NpcID.BARTENDER_1313)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2697, new BasicClue(ItemID.CLUE_SCROLL_EASY_2697, ClueTier.EASY,
                "Draynor Village, rope shop",
                new NPCLocation(new WorldPoint(3099, 3259, 0),
                        NpcID.NED)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2698, new BasicClue(ItemID.CLUE_SCROLL_EASY_2698, ClueTier.EASY,
                "North of Falador, Doric",
                new NPCLocation(new WorldPoint(2952, 3452, 0),
                        NpcID.DORIC)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2699, new BasicClue(ItemID.CLUE_SCROLL_EASY_2699, ClueTier.EASY,
                "Taverley, sword shop",
                new NPCLocation(new WorldPoint(2885, 3450, 0),
                        NpcID.GAIUS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2700, new BasicClue(ItemID.CLUE_SCROLL_EASY_2700, ClueTier.EASY,
                "Catherby, archery shop",
                new ObjectLocation(new WorldPoint(2825, 3442, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2701, new BasicClue(ItemID.CLUE_SCROLL_EASY_2710, ClueTier.EASY,
                "Catherby, general store",
                new NPCLocation(new WorldPoint(2803, 3430, 0),
                        NpcID.ARHEIN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2702, new BasicClue(ItemID.CLUE_SCROLL_EASY_2702, ClueTier.EASY,
                "Camelot Castle, courtyard",
                new NPCLocation(new WorldPoint(2761, 3497, 0),
                        NpcID.SIR_KAY)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2703, new BasicClue(ItemID.CLUE_SCROLL_EASY_2703, ClueTier.EASY,
                "Camelot Castle, west tower, 3rd floor",
                new ObjectLocation(new WorldPoint(2748, 3495, 2),
                        ObjectID.CLOSED_CHEST_25592,
                        ObjectID.OPEN_CHEST_25593)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2704, new BasicClue(ItemID.CLUE_SCROLL_EASY_2704, ClueTier.EASY,
                "East Ardougne guardhouse, north-west of market",
                new ObjectLocation(new WorldPoint(2645, 3338, 0),
                        ObjectID.CRATE_356)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2705, new BasicClue(ItemID.CLUE_SCROLL_EASY_2705, ClueTier.EASY,
                "East Ardougne, market",
                new ObjectLocation(new WorldPoint(2654, 3299, 0),
                        ObjectID.BOXES_361)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2706, new BasicClue(ItemID.CLUE_SCROLL_EASY_2706, ClueTier.EASY,
                "East Ardougne, general store",
                new ObjectLocation(new WorldPoint(2615, 3291, 0),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2707, new BasicClue(ItemID.CLUE_SCROLL_EASY_2707, ClueTier.EASY,
                "East Ardougne, north of north bank",
                new ObjectLocation(new WorldPoint(2617, 3347, 0),
                        ObjectID.CRATE_355)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2708, new BasicClue(ItemID.CLUE_SCROLL_EASY_2708, ClueTier.EASY,
                "Varrock, clothes shop, 2nd floor",
                new ObjectLocation(new WorldPoint(3206, 3419, 1),
                        ObjectID.DRAWERS_7194,
                        ObjectID.DRAWERS_7195)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2709, new BasicClue(ItemID.CLUE_SCROLL_EASY_2709, ClueTier.EASY,
                "Varrock Castle, tree patch",
                new ObjectLocation(new WorldPoint(3226, 3452, 0),
                        ObjectID.CRATE_5107)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2710, new BasicClue(ItemID.CLUE_SCROLL_EASY_2710, ClueTier.EASY,
                "East Ardougne, pub, 2nd floor",
                new ObjectLocation(new WorldPoint(2574, 3326, 1),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2711, new BasicClue(ItemID.CLUE_SCROLL_EASY_2711, ClueTier.EASY,
                "East Ardougne, church, 2nd floor",
                new ObjectLocation(new WorldPoint(2612, 3304, 1),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2712, new BasicClue(ItemID.CLUE_SCROLL_EASY_2712, ClueTier.EASY,
                "East Falador, west of fountain",
                new ObjectLocation(new WorldPoint(3029, 3355, 0),
                        ObjectID.CRATES_24088)));
        clues.put(ItemID.CLUE_SCROLL_EASY_2713, new DigClue(ItemID.CLUE_SCROLL_EASY_2713, ClueTier.EASY,
                "West of Champions' Guild",
                3166, 3359, 3168, 3361, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_2716, new DigClue(ItemID.CLUE_SCROLL_EASY_2716, ClueTier.EASY,
                "Varrock East Mine",
                3289, 3372, 3291, 3374, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_2719, new DigClue(ItemID.CLUE_SCROLL_EASY_2719, ClueTier.EASY,
                "North of Falador, standing stones",
                3042, 3398, 3044, 3400, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_3490, new BasicClue(ItemID.CLUE_SCROLL_EASY_3490, ClueTier.EASY,
                "Burthorpe, north-east house",
                new ObjectLocation(new WorldPoint(2929, 3570, 0),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3491, new BasicClue(ItemID.CLUE_SCROLL_EASY_3491, ClueTier.EASY,
                "Yanille, north-east house",
                new ObjectLocation(new WorldPoint(2598, 3105, 0),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3492, new BasicClue(ItemID.CLUE_SCROLL_EASY_3492, ClueTier.EASY,
                "Yanille, hunter shop",
                new ObjectLocation(new WorldPoint(2570, 3085, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3493, new BasicClue(ItemID.CLUE_SCROLL_EASY_3493, ClueTier.EASY,
                "Dwarven Mine, crossbow shop",
                new ObjectLocation(new WorldPoint(3000, 9798, 0),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3494, new BasicClue(ItemID.CLUE_SCROLL_EASY_3494, ClueTier.EASY,
                "Rimmington, north-east house, 2nd floor",
                new ObjectLocation(new WorldPoint(2970, 3214, 1),
                        ObjectID.DRAWERS_352, ObjectID.DRAWERS_353)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3495, new BasicClue(ItemID.CLUE_SCROLL_EASY_3495, ClueTier.EASY,
                "Port Sarim, food store, 2nd floor",
                new ObjectLocation(new WorldPoint(3016, 3205, 1),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3496, new BasicClue(ItemID.CLUE_SCROLL_EASY_3496, ClueTier.EASY,
                "Port Sarim, east of fishing shop",
                new NPCLocation(new WorldPoint(3028, 3218, 0),
                        NpcID.CAPTAIN_TOBIAS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3497, new BasicClue(ItemID.CLUE_SCROLL_EASY_3497, ClueTier.EASY,
                "East Falador, house north of fountain, 2nd floor",
                new ObjectLocation(new WorldPoint(3041, 3364, 1),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3498, new BasicClue(ItemID.CLUE_SCROLL_EASY_3498, ClueTier.EASY,
                "East Falador, south of fountain",
                new ObjectLocation(new WorldPoint(3039, 3342, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3499, new BasicClue(ItemID.CLUE_SCROLL_EASY_3499, ClueTier.EASY,
                "Taverley, sword shop",
                new ObjectLocation(new WorldPoint(2886, 3449, 0),
                        ObjectID.BOXES_360)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3500, new BasicClue(ItemID.CLUE_SCROLL_EASY_3500, ClueTier.EASY,
                "Taverley, south-east house",
                new ObjectLocation(new WorldPoint(2894, 3418, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3501, new BasicClue(ItemID.CLUE_SCROLL_EASY_3501, ClueTier.EASY,
                "Al Kharid, west of cactus patch",
                new ObjectLocation(new WorldPoint(3308, 3206, 0),
                        ObjectID.BOXES_361)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3502, new BasicClue(ItemID.CLUE_SCROLL_EASY_3502, ClueTier.EASY,
                "Draynor Manor, top floor",
                new ObjectLocation(new WorldPoint(3106, 3369, 2),
                        ObjectID.CRATE_11485)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3503, new BasicClue(ItemID.CLUE_SCROLL_EASY_3503, ClueTier.EASY,
                "Burthorpe, north-west tent",
                new ObjectLocation(new WorldPoint(2885, 3540, 0),
                        ObjectID.BOXES_3686)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3504, new BasicClue(ItemID.CLUE_SCROLL_EASY_3504, ClueTier.EASY,
                "Port Khazard, south of bank",
                new ObjectLocation(new WorldPoint(2660, 3149, 0),
                        ObjectID.CRATE_366)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3505, new BasicClue(ItemID.CLUE_SCROLL_EASY_3505, ClueTier.EASY,
                "East Ardougne, north of market",
                new ObjectLocation(new WorldPoint(2653, 3320, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3506, new BasicClue(ItemID.CLUE_SCROLL_EASY_3506, ClueTier.EASY,
                "Hemenster, north-west house",
                new ObjectLocation(new WorldPoint(2636, 3453, 0),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3507, new BasicClue(ItemID.CLUE_SCROLL_EASY_3507, ClueTier.EASY,
                "Catherby, north-west house, 2nd floor",
                new ObjectLocation(new WorldPoint(2809, 3451, 1),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3508, new BasicClue(ItemID.CLUE_SCROLL_EASY_3508, ClueTier.EASY,
                "Seers' Village, spinning wheel house, 2nd floor",
                new ObjectLocation(new WorldPoint(2716, 3471, 1),
                        ObjectID.DRAWERS_25766,
                        ObjectID.DRAWERS_25767)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3509, new BasicClue(ItemID.CLUE_SCROLL_EASY_3509, ClueTier.EASY,
                "Seers' Village, south-west house",
                new ObjectLocation(new WorldPoint(2699, 3470, 0),
                        ObjectID.CRATE_25775)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3510, new DigClue(ItemID.CLUE_SCROLL_EASY_3510, ClueTier.EASY,
                "North-west of the Grand Tree",
                2458, 3504, 2460, 3506, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_3512, new BasicClue(ItemID.CLUE_SCROLL_EASY_3512, ClueTier.EASY,
                "Draynor Village, north-east house",
                new ObjectLocation(new WorldPoint(3097, 3277, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3513, new BasicClue(ItemID.CLUE_SCROLL_EASY_3513, ClueTier.EASY,
                "Sinclair Mansion",
                new NPCLocation(new WorldPoint(2736, 3579, 0),
                        NpcID.LOUISA)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3514, new BasicClue(ItemID.CLUE_SCROLL_EASY_3514, ClueTier.EASY,
                "Emir's Arena, south-east upper ledge",
                new NPCLocation(new WorldPoint(3367, 3219, 0),
                        NpcID.JEED)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3515, new BasicClue(ItemID.CLUE_SCROLL_EASY_3515, ClueTier.EASY,
                "Varrock Castle, kitchen",
                new ObjectLocation(new WorldPoint(3224, 3492, 0),
                        ObjectID.CRATE_5113)));
        clues.put(ItemID.CLUE_SCROLL_EASY_3516, new DigClue(ItemID.CLUE_SCROLL_EASY_3516, ClueTier.EASY,
                "East of Coal Trucks",
                2611, 3480, 2613, 3482, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_3518, new DigClue(ItemID.CLUE_SCROLL_EASY_3518, ClueTier.EASY,
                "South of Wizards' Tower",
                3108, 3152, 3110, 3154, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_7236, new DigClue(ItemID.CLUE_SCROLL_EASY_7236, ClueTier.EASY,
                "North of Falador",
                2969, 3413, 2971, 3415, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_7238, new BasicClue(ItemID.CLUE_SCROLL_EASY_7238, ClueTier.EASY,
                "Canifis, meat shop",
                new ObjectLocation(new WorldPoint(3509, 3497, 0),
                        ObjectID.CRATE_24344),
                new QuestRequirement(ClueQuest.PRIEST_IN_PERIL)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10180, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10180, ClueTier.EASY,
                "Lumbridge Swamp, shed",
                new AreaLocation(3202, 3168, 3204, 3170, 0),
                Emote.DANCE,
                new WorldPoint(3201, 3171, 0),
                NullObjectID.NULL_28958,
                new EquipmentRequirement(ItemID.BRONZE_DAGGER),
                new EquipmentRequirement(ItemID.IRON_FULL_HELM),
                new EquipmentRequirement(ItemID.GOLD_RING)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10182, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10182, ClueTier.EASY,
                "North of Wizards' Tower",
                new AreaLocation(3112, 3171, 3115, 3209, 0),
                Emote.CLAP,
                new WorldPoint(3115, 3194, 0),
                NullObjectID.NULL_28959,
                new EquipmentRequirement(ItemID.IRON_MED_HELM),
                new EquipmentRequirement(ItemID.EMERALD_RING),
                new EquipmentRequirement(ItemID.WHITE_APRON)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10184, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10184, ClueTier.EASY,
                "Draynor Village, market",
                new AreaLocation(3075, 3245, 3086, 3255, 0),
                Emote.YAWN,
                new WorldPoint(3083, 3254, 0),
                NullObjectID.NULL_28960,
                new EquipmentRequirement(ItemID.STUDDED_CHAPS),
                new EquipmentRequirement(ItemID.IRON_KITESHIELD),
                new EquipmentRequirement(ItemID.STEEL_LONGSWORD),
                new SkillRequirement(Skill.RANGED, 20, false),
                new SkillRequirement(Skill.ATTACK, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10186, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10186, ClueTier.EASY,
                "Silvarea, limestone mine",
                new AreaLocation(3367, 3497, 3374, 3502, 0),
                Emote.PANIC,
                new WorldPoint(3373, 3498, 0),
                NullObjectID.NULL_28961,
                new EquipmentRequirement(ItemID.BRONZE_PLATELEGS),
                new EquipmentRequirement(ItemID.STEEL_PICKAXE),
                new EquipmentRequirement(ItemID.STEEL_MED_HELM),
                new SkillRequirement(Skill.ATTACK, 5, false),
                new SkillRequirement(Skill.DEFENCE, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10188, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10188, ClueTier.EASY,
                "Outside Legends' Guild",
                new AreaLocation(2725, 3343, 2732, 3349, 0),
                Emote.BOW,
                new WorldPoint(2735, 3350, 0),
                NullObjectID.NULL_28962,
                new EquipmentRequirement(ItemID.IRON_PLATELEGS),
                new EquipmentRequirement(ItemID.EMERALD_AMULET),
                new EquipmentRequirement(ItemID.OAK_LONGBOW),
                new SkillRequirement(Skill.RANGED, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10190, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10190, ClueTier.EASY,
                "Mudskipper Point",
                new AreaLocation(2981, 3106, 3005, 3130, 0),
                Emote.WAVE,
                new WorldPoint(2988, 3111, 0),
                NullObjectID.NULL_28963,
                new EquipmentRequirement(ItemID.BLACK_CAPE),
                new EquipmentRequirement(ItemID.LEATHER_CHAPS),
                new EquipmentRequirement(ItemID.STEEL_MACE),
                new SkillRequirement(Skill.ATTACK, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10192, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10192, ClueTier.EASY,
                "Port Sarim, north-east dock, near Entrana boat",
                new AreaLocation(3044, 3234, 3050, 3237, 0),
                Emote.CHEER,
                new WorldPoint(3050, 3237, 0),
                NullObjectID.NULL_28964,
                new SkillRequirement(Skill.DEFENCE, 5, false),
                new SkillRequirement(Skill.RANGED, 20, false),
                new EquipmentRequirement(ItemID.COIF),
                new EquipmentRequirement(ItemID.STEEL_PLATESKIRT),
                new EquipmentRequirement(ItemID.SAPPHIRE_NECKLACE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10194, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10194, ClueTier.EASY,
                "Al Kharid mine",
                new AreaLocation(3290, 3274, 3306, 3317, 0),
                Emote.HEADBANG,
                new WorldPoint(3303, 3289, 0),
                NullObjectID.NULL_28965,
                new EquipmentRequirement(ItemID.DESERT_SHIRT),
                new EquipmentRequirement(ItemID.LEATHER_GLOVES),
                new EquipmentRequirement(ItemID.LEATHER_BOOTS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10196, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10196, ClueTier.EASY,
                "Draynor Manor, fountain",
                new AreaLocation(3085, 3332, 3090, 3337, 0),
                Emote.SPIN,
                new WorldPoint(3089, 3331, 0),
                NullObjectID.NULL_28966,
                new EquipmentRequirement(ItemID.IRON_PLATEBODY),
                new EquipmentRequirement(ItemID.STUDDED_CHAPS),
                new EquipmentRequirement(ItemID.BRONZE_FULL_HELM),
                new SkillRequirement(Skill.RANGED, 20, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10198, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10198, ClueTier.EASY,
                "Wheat field near Lumbridge windmill",
                new AreaLocation(3155, 3295, 3160, 3302, 0),
                Emote.THINK,
                new WorldPoint(3163, 3297, 0),
                NullObjectID.NULL_28967,
                new EquipmentRequirement(ItemID.BLUE_ROBE_TOP),
                new EquipmentRequirement(ItemID.TURQUOISE_ROBE_BOTTOMS),
                new EquipmentRequirement(ItemID.OAK_SHORTBOW),
                new SkillRequirement(Skill.RANGED, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10200, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10200, ClueTier.EASY,
                "North-east of Draynor Village",
                new AreaLocation(3108, 3293, 3111, 3296, 0),
                Emote.DANCE,
                new WorldPoint(3111, 3289, 0),
                NullObjectID.NULL_28968,
                new EquipmentRequirement(ItemID.IRON_CHAINBODY),
                new EquipmentRequirement(ItemID.SAPPHIRE_RING),
                new EquipmentRequirement(ItemID.LONGBOW)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10202, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10202, ClueTier.EASY,
                "Rimmington Mine",
                new AreaLocation(2970, 3228, 2989, 3251, 0),
                Emote.SHRUG,
                new WorldPoint(2976, 3239, 0),
                NullObjectID.NULL_28969,
                new EquipmentRequirement(ItemID.GOLD_NECKLACE),
                new EquipmentRequirement(ItemID.GOLD_RING),
                new EquipmentRequirement(ItemID.BRONZE_SPEAR)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10204, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10204, ClueTier.EASY,
                "Varrock Castle, library",
                new AreaLocation(3207, 3490, 3214, 3497, 0),
                Emote.YAWN,
                new WorldPoint(3214, 3490, 0),
                NullObjectID.NULL_28970,
                new EquipmentRequirement(ItemID.GREEN_ROBE_TOP),
                new EquipmentRequirement(ItemID.HAM_ROBE),
                new EquipmentRequirement(ItemID.IRON_WARHAMMER)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10206, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10206, ClueTier.EASY,
                "Ardougne, windmill, top floor",
                new AreaLocation(2630, 3384, 2635, 3388, 2),
                Emote.CLAP,
                new WorldPoint(2635, 3386, 2),
                NullObjectID.NULL_28971,
                new EquipmentRequirement(ItemID.BLUE_ROBE_TOP),
                new EquipmentRequirement(ItemID.HAM_ROBE),
                new EquipmentRequirement(ItemID.TIARA)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10208, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10208, ClueTier.EASY,
                "Falador, Party Room",
                new AreaLocation(3036, 3371, 3055, 3385, 0),
                Emote.DANCE,
                new WorldPoint(3043, 3371, 0),
                NullObjectID.NULL_28972,
                new EquipmentRequirement(ItemID.STEEL_FULL_HELM),
                new EquipmentRequirement(ItemID.STEEL_PLATEBODY),
                new EquipmentRequirement(ItemID.IRON_PLATESKIRT),
                new SkillRequirement(Skill.DEFENCE, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10210, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10210, ClueTier.EASY,
                "Taverley, stone circle",
                new AreaLocation(2920, 3478, 2931, 3489, 0),
                Emote.CHEER,
                new WorldPoint(2924, 3477, 0),
                NullObjectID.NULL_28973,
                new EquipmentRequirement(ItemID.BLUE_WIZARD_HAT),
                new EquipmentRequirement(ItemID.BRONZE_2H_SWORD),
                new EquipmentRequirement(ItemID.HAM_BOOTS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10212, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10212, ClueTier.EASY,
                "Burthorpe Games Room",
                new AreaLocation(2194, 4946, 2221, 4973, 0),
                Emote.CHEER,
                new NothingEquippedRequirement()));
        clues.put(ItemID.CLUE_SCROLL_EASY_10214, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10214, ClueTier.EASY,
                "Catherby, beehives",
                new AreaLocation(2752, 3437, 2766, 3450, 0),
                Emote.JUMP_FOR_JOY,
                new WorldPoint(2764, 3438, 0),
                NullObjectID.NULL_28974,
                new EquipmentRequirement(ItemID.DESERT_SHIRT),
                new EquipmentRequirement(ItemID.GREEN_ROBE_BOTTOMS),
                new EquipmentRequirement(ItemID.STEEL_AXE),
                new SkillRequirement(Skill.ATTACK, 5, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10216, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10216, ClueTier.EASY,
                "Ardougne Zoo, north entrance",
                new AreaLocation(2596, 3273, 2609, 3284, 0),
                Emote.RASPBERRY,
                new WorldPoint(2608, 3284, 0),
                NullObjectID.NULL_28975,
                new EquipmentRequirement(ItemID.STUDDED_BODY),
                new EquipmentRequirement(ItemID.BRONZE_PLATELEGS),
                new EquipmentRequirement(ItemID.STAFF),
                new SkillRequirement(Skill.RANGED, 20, false),
                new SkillRequirement(Skill.DEFENCE, 20, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10218, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10218, ClueTier.EASY,
                "North of Rimmington, crossroads",
                new AreaLocation(2979, 3274, 2984, 3278, 0),
                Emote.SPIN,
                new WorldPoint(2981, 3278, 0),
                NullObjectID.NULL_28976,
                new EquipmentRequirement(ItemID.GREEN_HAT),
                new EquipmentRequirement(ItemID.CREAM_ROBE_TOP),
                new EquipmentRequirement(ItemID.LEATHER_CHAPS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10220, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10220, ClueTier.EASY,
                "Fishing Guild, outside",
                new AreaLocation(2608, 3390, 2613, 3393, 0),
                Emote.JIG,
                new WorldPoint(2608, 3393, 0),
                NullObjectID.NULL_28977,
                new EquipmentRequirement(ItemID.EMERALD_RING),
                new EquipmentRequirement(ItemID.SAPPHIRE_AMULET),
                new EquipmentRequirement(ItemID.BRONZE_CHAINBODY)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10222, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10222, ClueTier.EASY,
                "Outside Keep Le Faye",
                new AreaLocation(2757, 3399, 2763, 3406, 0),
                Emote.RASPBERRY,
                new WorldPoint(2756, 3399, 0),
                NullObjectID.NULL_28978,
                new EquipmentRequirement(ItemID.COIF),
                new EquipmentRequirement(ItemID.IRON_PLATEBODY),
                new EquipmentRequirement(ItemID.LEATHER_GLOVES),
                new SkillRequirement(Skill.RANGED, 20, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10224, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10224, ClueTier.EASY,
                "Port Khazard, Trawler pier",
                new AreaLocation(2676, 3163, 2676, 3173, 0),
                Emote.PANIC,
                new NothingEquippedRequirement()));
        clues.put(ItemID.CLUE_SCROLL_EASY_10226, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10226, ClueTier.EASY,
                "South of Sinclair Mansion",
                new AreaLocation(2737, 3533, 2744, 3541, 0),
                Emote.LAUGH,
                new WorldPoint(2735, 3534, 0),
                NullObjectID.NULL_28979,
                new EquipmentRequirement(ItemID.LEATHER_COWL),
                new EquipmentRequirement(ItemID.BLUE_WIZARD_ROBE),
                new EquipmentRequirement(ItemID.IRON_SCIMITAR)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10228, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10228, ClueTier.EASY,
                "Digsite, Exam Centre",
                new AreaLocation(3357, 3332, 3367, 3348, 0),
                Emote.CLAP,
                new WorldPoint(3353, 3343, 0),
                NullObjectID.NULL_28980,
                new EquipmentRequirement(ItemID.WHITE_APRON),
                new EquipmentRequirement(ItemID.GREEN_BOOTS),
                new EquipmentRequirement(ItemID.LEATHER_GLOVES)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10230, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10230, ClueTier.EASY,
                "Lumber Yard",
                new AreaLocation(3300, 3488, 3313, 3492, 0),
                Emote.WAVE,
                new WorldPoint(3298, 3490, 0),
                NullObjectID.NULL_28981,
                new EquipmentRequirement(ItemID.HARDLEATHER_BODY),
                new EquipmentRequirement(ItemID.LEATHER_CHAPS),
                new EquipmentRequirement(ItemID.BRONZE_AXE),
                new SkillRequirement(Skill.DEFENCE, 10, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_10232, new EmoteClue(ItemID.CLUE_SCROLL_EASY_10232, ClueTier.EASY,
                "Emir's Arena, entrance",
                new AreaLocation(3312, 3240, 3316, 3244, 0),
                Emote.BOW,
                new WorldPoint(3316, 3242, 0),
                NullObjectID.NULL_28982,
                new EquipmentRequirement(ItemID.IRON_CHAINBODY),
                new EquipmentRequirement(ItemID.LEATHER_CHAPS),
                new EquipmentRequirement(ItemID.COIF),
                new SkillRequirement(Skill.RANGED, 20, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12162, new EmoteClue(ItemID.CLUE_SCROLL_EASY_12162, ClueTier.EASY,
                "Varrock Castle, courtyard",
                new AreaLocation(3208, 3459, 3217, 3466, 0),
                Emote.SPIN,
                new WorldPoint(3211, 3456, 0),
                NullObjectID.NULL_28983,
                new EquipmentRequirement(ItemID.BLACK_AXE),
                new EquipmentRequirement(ItemID.COIF),
                new EquipmentRequirement(ItemID.RUBY_RING),
                new SkillRequirement(Skill.ATTACK, 10, false),
                new SkillRequirement(Skill.RANGED, 20, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12164, new EmoteClue(ItemID.CLUE_SCROLL_EASY_12164, ClueTier.EASY,
                "Falador, gem shop",
                new AreaLocation(2944, 3332, 2946, 3337, 0),
                Emote.WAVE,
                new WorldPoint(2941, 3339, 0),
                NullObjectID.NULL_28984,
                new EquipmentRequirement(ItemID.MITHRIL_PICKAXE),
                new EquipmentRequirement(ItemID.BLACK_PLATEBODY),
                new EquipmentRequirement(ItemID.IRON_KITESHIELD),
                new SkillRequirement(Skill.ATTACK, 20, false),
                new SkillRequirement(Skill.DEFENCE, 10, false)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12166, new BasicClue(ItemID.CLUE_SCROLL_EASY_12166, ClueTier.EASY,
                "Lumbridge Swamp, west house",
                new ObjectLocation(new WorldPoint(3146, 3177, 0),
                        ObjectID.BOOKCASE_9523)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12167, new BasicClue(ItemID.CLUE_SCROLL_EASY_12167, ClueTier.EASY,
                "Wizards' Tower",
                new ObjectLocation(new WorldPoint(3113, 3158, 0),
                        ObjectID.BOOKCASE_12539)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12168, new BasicClue(ItemID.CLUE_SCROLL_EASY_12168, ClueTier.EASY,
                "Draynor Village, dye shop",
                new ObjectLocation(new WorldPoint(3087, 3261, 0),
                        ObjectID.WARDROBE_5622,
                        ObjectID.WARDROBE_5623)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12169, new BasicClue(ItemID.CLUE_SCROLL_EASY_12169, ClueTier.EASY,
                "Falador, Party Room, 2nd floor",
                new NPCLocation(new WorldPoint(3046, 3383, 1),
                        NpcID.LUCY)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12170, new DigClue(ItemID.CLUE_SCROLL_EASY_12170, ClueTier.EASY,
                "North of Falador, standing stones",
                3039, 3398, 3041, 3400, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_12172, new BasicClue(ItemID.CLUE_SCROLL_EASY_12172, ClueTier.EASY,
                "Barbarian Village, south-east of tavern",
                new ObjectLocation(new WorldPoint(3085, 3429, 0),
                        ObjectID.CLOSED_CHEST_375, ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12173, new BasicClue(ItemID.CLUE_SCROLL_EASY_12173, ClueTier.EASY,
                "Edgeville, south-west house",
                new NPCLocation(new WorldPoint(3079, 3492, 0),
                        NpcID.DORIS)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12174, new BasicClue(ItemID.CLUE_SCROLL_EASY_12174, ClueTier.EASY,
                "Edgeville mausoleum",
                new ObjectLocation(new WorldPoint(3090, 3476, 0),
                        ObjectID.COFFIN,
                        ObjectID.COFFIN_3577)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12175, new BasicClue(ItemID.CLUE_SCROLL_EASY_12175, ClueTier.EASY,
                "South of Digsite",
                new ObjectLocation(new WorldPoint(3345, 3378, 0),
                        ObjectID.BUSH_2357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12176, new BasicClue(ItemID.CLUE_SCROLL_EASY_12176, ClueTier.EASY,
                "Varrock, west bank, basement",
                new ObjectLocation(new WorldPoint(3187, 9825, 0),
                        ObjectID.CRATE_5107)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12177, new BasicClue(ItemID.CLUE_SCROLL_EASY_12177, ClueTier.EASY,
                "Edgeville Monastery, south-east bookcase",
                new ObjectLocation(new WorldPoint(3054, 3483, 0),
                        ObjectID.BOOKCASE_380)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12178, new BasicClue(ItemID.CLUE_SCROLL_EASY_12178, ClueTier.EASY,
                "Dwarven Mine, north pickaxe shop",
                new ObjectLocation(new WorldPoint(3035, 9849, 0),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12179, new DigClue(ItemID.CLUE_SCROLL_EASY_12179, ClueTier.EASY,
                "Al Kharid mine",
                3299, 3290, 3301, 3292, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_12181, new BasicClue(ItemID.CLUE_SCROLL_EASY_12181, ClueTier.EASY,
                "Falador, shield shop",
                new NPCLocation(new WorldPoint(2976, 3384, 0),
                        NpcID.CASSIE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12182, new BasicClue(ItemID.CLUE_SCROLL_EASY_12182, ClueTier.EASY,
                "Falador Castle, 2nd floor",
                new NPCLocation(new WorldPoint(2983, 3337, 1),
                        NpcID.AMBASSADOR_SPANFIPPLE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12183, new BasicClue(ItemID.CLUE_SCROLL_EASY_12183, ClueTier.EASY,
                "Falador, Hairdresser",
                new NPCLocation(new WorldPoint(2945, 3380, 0),
                        NpcID.HAIRDRESSER)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12184, new BasicClue(ItemID.CLUE_SCROLL_EASY_12184, ClueTier.EASY,
                "Taverley, herblore shop",
                new NPCLocation(new WorldPoint(2899, 3429, 0),
                        NpcID.JATIX)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12185, new BasicClue(ItemID.CLUE_SCROLL_EASY_12185, ClueTier.EASY,
                "Burthorpe, pub",
                new ObjectLocation(new WorldPoint(2913, 3536, 0),
                        ObjectID.CRATE_354)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12186, new BasicClue(ItemID.CLUE_SCROLL_EASY_12186, ClueTier.EASY,
                "South Falador Farm",
                new NPCLocation(new WorldPoint(3036, 3294, 0),
                        NpcID.SARAH)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12187, new BasicClue(ItemID.CLUE_SCROLL_EASY_12187, ClueTier.EASY,
                "North of Falador, towards Mind Altar",
                new NPCLocation(new WorldPoint(2979, 3436, 0),
                        NpcID.RUSTY)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12188, new BasicClue(ItemID.CLUE_SCROLL_EASY_12188, ClueTier.EASY,
                "Port Sarim, house west of pub",
                new ObjectLocation(new WorldPoint(3024, 3259, 0),
                        ObjectID.DRAWERS,
                        ObjectID.DRAWERS_349)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12189, new BasicClue(ItemID.CLUE_SCROLL_EASY_12189, ClueTier.EASY,
                "Rimmington mine",
                new ObjectLocation(new WorldPoint(2978, 3239, 0),
                        ObjectID.WHEELBARROW_9625)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12190, new BasicClue(ItemID.CLUE_SCROLL_EASY_12190, ClueTier.EASY,
                "Taverley, lake peninsula",
                new NPCLocation(new WorldPoint(2925, 3405, 0),
                        NpcID.THE_LADY_OF_THE_LAKE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12191, new BasicClue(ItemID.CLUE_SCROLL_EASY_12191, ClueTier.EASY,
                "Taverley, outhouse",
                new ObjectLocation(new WorldPoint(2914, 3433, 0),
                        ObjectID.CRATE_357)));
        clues.put(ItemID.CLUE_SCROLL_EASY_12192, new BasicClue(ItemID.CLUE_SCROLL_EASY_12192, ClueTier.EASY,
                "Shantay Pass, talk to Shantay and declare being an outlaw to get sent to Port Sarim jail",
                new ObjectLocation(new WorldPoint(3013, 3179, 0),
                        ObjectID.BUCKET_9568)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19814, new DigClue(ItemID.CLUE_SCROLL_EASY_19814, ClueTier.EASY,
                "Lumbridge Castle, courtyard",
                3218, 3212, 3225, 3223, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_19816, new BasicClue(ItemID.CLUE_SCROLL_EASY_19816, ClueTier.EASY,
                "Edgeville Dungeon, Vannaka",
                new NPCLocation(new WorldPoint(3147, 9914, 0),
                        NpcID.VANNAKA)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19817, new BasicClue(ItemID.CLUE_SCROLL_EASY_19817, ClueTier.EASY,
                "Varrock, Apothecary",
                new NPCLocation(new WorldPoint(3195, 3404, 0),
                        NpcID.APOTHECARY)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19818, new BasicClue(ItemID.CLUE_SCROLL_EASY_19818, ClueTier.EASY,
                "Hosidius, south of house portal",
                new ObjectLocation(new WorldPoint(1746, 3490, 0),
                        ObjectID.DRAWERS_350,
                        ObjectID.DRAWERS_351)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19819, new BasicClue(ItemID.CLUE_SCROLL_EASY_19819, ClueTier.EASY,
                "Falador, gem shop",
                new NPCLocation(new WorldPoint(2945, 3334, 0),
                        NpcID.HERQUIN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19820, new BasicClue(ItemID.CLUE_SCROLL_EASY_19820, ClueTier.EASY,
                "Hosidius, church",
                new NPCLocation(new WorldPoint(1734, 3577, 0),
                        NpcID.FATHER_JEAN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19821, new BasicClue(ItemID.CLUE_SCROLL_EASY_19821, ClueTier.EASY,
                "Port Piscarilius, fishing shop",
                new NPCLocation(new WorldPoint(1837, 3785, 0),
                        NpcID.TYNAN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19822, new BasicClue(ItemID.CLUE_SCROLL_EASY_19822, ClueTier.EASY,
                "Rimmington, Chemist",
                new NPCLocation(new WorldPoint(2932, 3210, 0),
                        NpcID.CHEMIST)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19823, new BasicClue(ItemID.CLUE_SCROLL_EASY_19823, ClueTier.EASY,
                "Draynor Manor, Tool Leprechaun",
                new NPCLocation(0, 0, new WorldPoint(3088, 3357, 0),
                        NpcID.TOOL_LEPRECHAUN_12109)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19824, new BasicClue(ItemID.CLUE_SCROLL_EASY_19824, ClueTier.EASY,
                "Port Sarim, north of fishing shop",
                new NPCLocation(new WorldPoint(3018, 3233, 0),
                        NpcID.THE_FACE)));
        // TODO: Multiple locations
        clues.put(ItemID.CLUE_SCROLL_EASY_19825, new BasicClue(ItemID.CLUE_SCROLL_EASY_19825, ClueTier.EASY,
                "Hosidius, saltpeter mine",
                new NPCLocation(new WorldPoint(1703, 3524, 0),
                        NpcID.KONOO)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19826, new DigClue(ItemID.CLUE_SCROLL_EASY_19826, ClueTier.EASY,
                "Kourend Castle, courtyard",
                1630, 3665, 1643, 3681, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_19828, new BasicClue(ItemID.CLUE_SCROLL_EASY_19828, ClueTier.EASY,
                "Gnome Stronghold, south-east of agility course, 2nd floor",
                new NPCLocation(new WorldPoint(2489, 3410, 1),
                        NpcID.ERMIN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19829, new BasicClue(ItemID.CLUE_SCROLL_EASY_19829, ClueTier.EASY,
                "Hosidius, kitchen",
                new ObjectLocation(new WorldPoint(1683, 3616, 0),
                        ObjectID.CRATES_27533)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19830, new BasicClue(ItemID.CLUE_SCROLL_EASY_19830, ClueTier.EASY,
                "Lumbridge, Doomsayer",
                new NPCLocation(new WorldPoint(3232, 3223, 0),
                        NpcID.DOOMSAYER)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19831, new EmoteClue(ItemID.CLUE_SCROLL_EASY_19831, ClueTier.EASY,
                "Grand Exchange, entrance",
                new AreaLocation(3161, 3461, 3170, 3470, 0),
                Emote.DANCE,
                new WorldPoint(3159, 3464, 0),
                NullObjectID.NULL_28985,
                new EquipmentRequirement(ItemID.PINK_SKIRT),
                new EquipmentRequirement(ItemID.PINK_ROBE_TOP),
                new EquipmentRequirement(ItemID.BODY_TIARA)));
        clues.put(ItemID.CLUE_SCROLL_EASY_19833, new EmoteClue(ItemID.CLUE_SCROLL_EASY_19833, ClueTier.EASY,
                "Varrock, rune shop",
                new AreaLocation(3252, 3399, 3254, 3404, 0),
                Emote.JIG,
                new WorldPoint(3252, 3404, 0),
                NullObjectID.NULL_28986,
                new EquipmentRequirement(ItemID.AIR_TIARA),
                new EquipmentRequirement(ItemID.STAFF_OF_WATER)));
        clues.put(ItemID.CLUE_SCROLL_EASY_22001, new DigClue(ItemID.CLUE_SCROLL_EASY_22001, ClueTier.EASY,
                "Corsair Cove, south-west cabin",
                2528, 2836, 2531, 2840, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_23149, new BasicClue(ItemID.CLUE_SCROLL_EASY_23149, ClueTier.EASY,
                "Taverley, next to crystal chest",
                new ObjectLocation(new WorldPoint(2915, 3452, 0),
                        ObjectID.BOXES_360)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23150, new BasicClue(ItemID.CLUE_SCROLL_EASY_23150, ClueTier.EASY,
                "Lumbridge Swamp, west house",
                new ObjectLocation(new WorldPoint(3149, 3177, 0),
                        ObjectID.BOOKCASE_9523)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23151, new BasicClue(ItemID.CLUE_SCROLL_EASY_23151, ClueTier.EASY,
                "Lumbridge, sheep farmhouse",
                new ObjectLocation(new WorldPoint(3185, 3274, 0),
                        ObjectID.CLOSED_CHEST_375,
                        ObjectID.OPEN_CHEST_378)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23152, new BasicClue(ItemID.CLUE_SCROLL_EASY_23152, ClueTier.EASY,
                "Varrock, platebody shop",
                new ObjectLocation(new WorldPoint(3228, 3433, 0),
                        ObjectID.CRATE_5106)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23153, new BasicClue(ItemID.CLUE_SCROLL_EASY_23153, ClueTier.EASY,
                "Rimmington, crafting shop",
                new ObjectLocation(new WorldPoint(2946, 3207, 0),
                        ObjectID.CRATE_9533)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23154, new BasicClue(ItemID.CLUE_SCROLL_EASY_23154, ClueTier.EASY,
                "Falador, general store",
                new ObjectLocation(new WorldPoint(2955, 3390, 0),
                        ObjectID.CRATES_24088)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23155, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23155, ClueTier.EASY,
                "Vision", 24, 9));
        clues.put(ItemID.CLUE_SCROLL_EASY_23156, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23156, ClueTier.EASY,
                "The Forlorn Homestead", 24, 27));
        clues.put(ItemID.CLUE_SCROLL_EASY_23157, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23157, ClueTier.EASY,
                "Tiptoe", 346, 10));
        clues.put(ItemID.CLUE_SCROLL_EASY_23158, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23158, ClueTier.EASY,
                "Rugged Terrain", 24, 29));
        clues.put(ItemID.CLUE_SCROLL_EASY_23159, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23159, ClueTier.EASY,
                "On the Shore", 1338, 22));
        clues.put(ItemID.CLUE_SCROLL_EASY_23160, new CeciliaClue(ItemID.CLUE_SCROLL_EASY_23160, ClueTier.EASY,
                "Alone", 20, 2));
        clues.put(ItemID.CLUE_SCROLL_EASY_23161, new BasicClue(ItemID.CLUE_SCROLL_EASY_23161, ClueTier.EASY,
                "Port Piscarilius, docks",
                new NPCLocation(new WorldPoint(1821, 3690, 0),
                        NpcID.CHARLES)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23162, new BasicClue(ItemID.CLUE_SCROLL_EASY_23162, ClueTier.EASY,
                "Draynor Village, Morgan's house",
                new NPCLocation(new WorldPoint(3099, 3269, 0),
                        NpcID.MORGAN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23163, new BasicClue(ItemID.CLUE_SCROLL_EASY_23163, ClueTier.EASY,
                "Falador, chainmail shop",
                new NPCLocation(new WorldPoint(2973, 3313, 0),
                        NpcID.WAYNE)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23164, new BasicClue(ItemID.CLUE_SCROLL_EASY_23164, ClueTier.EASY,
                "North-west of Al Kharid mine",
                new NPCLocation(new WorldPoint(3284, 3330, 0),
                        NpcID.ALI_THE_LEAFLET_DROPPER)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23165, new BasicClue(ItemID.CLUE_SCROLL_EASY_23165, ClueTier.EASY,
                "Burthorpe, slayer master",
                new NPCLocation(new WorldPoint(2931, 3536, 0),
                        NpcID.TURAEL_13560,
                        NpcID.TURAEL_13618,
                        NpcID.AYA)));
        clues.put(ItemID.CLUE_SCROLL_EASY_23166, new BasicClue(ItemID.CLUE_SCROLL_EASY_23166, ClueTier.EASY,
                "Varrock, pub",
                new NPCLocation(new WorldPoint(3230, 3400, 0),
                        NpcID.COOK_2895)));
        clues.put(ItemID.CLUE_SCROLL_EASY_25788, new DigClue(ItemID.CLUE_SCROLL_EASY_25788, ClueTier.EASY,
                "Shayzien, Giant's Den entrance",
                1415, 3589, 1419, 3593, 0));
        clues.put(ItemID.CLUE_SCROLL_EASY_25789, new BasicClue(ItemID.CLUE_SCROLL_EASY_25789, ClueTier.EASY,
                "Hosidius, east of market",
                new ObjectLocation(new WorldPoint(1799, 3613, 0),
                        ObjectID.CRATES_27533)));
        clues.put(ItemID.CLUE_SCROLL_EASY_28913, new BasicClue(ItemID.CLUE_SCROLL_EASY_28913, ClueTier.EASY,
                "Hunter Guild, 2nd floor",
                new ObjectLocation(new WorldPoint(1560, 3048, 2),
                        ObjectID.FOOD_POT),
                new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_28914, new EmoteClue(ItemID.CLUE_SCROLL_EASY_28914, ClueTier.EASY,
                "Fortis, Grand Museum",
                new AreaLocation(1710, 3161, 1714, 3165, 0),
                Emote.YAWN,
                new WorldPoint(1723, 3153, 0),
                NullObjectID.NULL_50738,
                new EquipmentRequirement(ItemID.EMERALD_NECKLACE),
                new EquipmentRequirement(ItemID.BLUE_SKIRT),
                new EquipmentRequirement(ItemID.TURQUOISE_ROBE_TOP),
                new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_29853, new DigClue(ItemID.CLUE_SCROLL_EASY_28913, ClueTier.EASY,
                "Aldarin, outside bank",
                1389, 2925, 1393, 2928, 0,
                new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN)));
        clues.put(ItemID.CLUE_SCROLL_EASY_29854, new DigClue(ItemID.CLUE_SCROLL_EASY_28913, ClueTier.EASY,
                "Varlamore, north-west of Quetzacalli Gorge",
                1490, 3256, 1490, 3258, 0,
                new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN)));
    }

    @Nullable
    public static Clue getClue(final int itemId) {
        return clues.get(itemId);
    }
}
