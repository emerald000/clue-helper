package com.emerald000.cluehelper.cluesteps;

import com.emerald000.cluehelper.clues.BasicClue;
import com.emerald000.cluehelper.clues.CharlieClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.DigClue;
import com.emerald000.cluehelper.clues.EmoteClue;
import com.emerald000.cluehelper.clues.HotColdClue;
import com.emerald000.cluehelper.clues.UnreadBeginnerClue;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.modules.requirements.EquipmentRequirement;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.InterfaceID;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BeginnerClues {
    @Getter
    private static final List<Clue> hotColdClues = new ArrayList<>(5);
    private static final Map<String, Clue> textClues = new HashMap<>(36);
    private static final Map<Integer, Clue> mapClues = new HashMap<>(5);

    @Getter
    private static final Clue unreadClue = new UnreadBeginnerClue();

    @Getter
    private static final Clue charlieDone = new CharlieClue(true);

    static {
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                "North-west of Draynor Manor",
                3093, 3376, 3099, 3382, 0));
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                "North-east of Draynor Village, wheat field",
                3117, 3279, 3123, 3285, 0));
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                "Ice Mountain",
                3004, 3472, 3010, 3478, 0));
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                "North Lumbridge cow field",
                3171, 3333, 3177, 3339, 0));
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                "North-east of Al Kharid mine",
                3329, 3310, 3335, 3316, 0));

        textClues.put("The anagram reveals<br> who to speak to next:<br>AN EARL",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Al Kharid, plateskirt shop",
                        new NPCLocation(new WorldPoint(3316, 3163, 0),
                                NpcID.RANAEL)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>CHAR GAME DISORDER",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Wizards' Tower, basement",
                        new NPCLocation(100000, 100000, new WorldPoint(3104, 9571, 0),
                                NpcID.ARCHMAGE_SEDRIDOR,
                                NpcID.ARCHMAGE_SEDRIDOR_11433)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>CARPET AHOY",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Varrock, Apothecary",
                        new NPCLocation(new WorldPoint(3195, 3404, 0),
                                NpcID.APOTHECARY)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>I CORD",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "North of Falador, Doric",
                        new NPCLocation(new WorldPoint(2952, 3452, 0),
                                NpcID.DORIC)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>IN BAR",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Port Sarim, battleaxe store",
                        new NPCLocation(new WorldPoint(3027, 3249, 0),
                                NpcID.BRIAN)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>RAIN COVE",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Draynor Manor gate",
                        new NPCLocation(new WorldPoint(3110, 3330, 0),
                                NpcID.VERONICA)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>RUG DETER",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "West of Varrock, Gertrude",
                        new NPCLocation(new WorldPoint(3150, 3409, 0),
                                NpcID.GERTRUDE,
                                NpcID.GERTRUDE_7723)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>SIR SHARE RED",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Falador, Hairdresser",
                        new NPCLocation(new WorldPoint(2945, 3380, 0),
                                NpcID.HAIRDRESSER)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>TAUNT ROOF",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Draynor Village, market",
                        new NPCLocation(new WorldPoint(3085, 3252, 0),
                                NpcID.FORTUNATO)));
        textClues.put("Always walking around the castle grounds and somehow knows everyone's age.",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Lumbridge Castle, Hans",
                        new NPCLocation(new WorldPoint(3221, 3219, 0),
                                NpcID.HANS)));
        textClues.put("Buried beneath the ground, who knows where it's found.<br><br>Lucky for you, a man called Reldo may have a clue.",
                new HotColdClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER));
        textClues.put("In the place Duke Horacio calls home, talk to a man with a hat dropped by goblins.",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Lumbridge Castle, kitchen",
                        new NPCLocation(new WorldPoint(3209, 3215, 0),
                                NpcID.COOK_4626)));
        textClues.put("In a village of barbarians, I am the one who guards the village from up high.",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Barbarian Village, watchtower, top floor",
                        new NPCLocation(new WorldPoint(3097, 3429, 2),
                                NpcID.HUNDING)));
        textClues.put("Near the open desert I reside, to get past me you must abide. Go forward if you dare, for when you pass me, you'll be sweating by your hair.",
                new BasicClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Shantay Pass",
                        new NPCLocation(new WorldPoint(3304, 3124, 0),
                                NpcID.SHANTAY)));
        textClues.put("Blow a raspberry at Aris in her tent. Equip a gold ring and a gold necklace.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Varrock, fortune teller",
                        new AreaLocation(3201, 3422, 3205, 3425, 0),
                        Emote.RASPBERRY,
                        new WorldPoint(3206, 3422, 0),
                        NullObjectID.NULL_34736,
                        new EquipmentRequirement(ItemID.GOLD_RING),
                        new EquipmentRequirement(ItemID.GOLD_NECKLACE)));
        textClues.put("Bow to Brugsen Bursen at the Grand Exchange.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Grand Exchange",
                        new AreaLocation(3163, 3475, 3167, 3479, 0),
                        Emote.BOW));
        textClues.put("Cheer at Iffie Nitter. Equip a chef hat and a red cape.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Varrock, clothes shop",
                        new AreaLocation(3202, 3414, 3208, 3419, 0),
                        Emote.CHEER,
                        new WorldPoint(3209, 3416, 0),
                        NullObjectID.NULL_34737,
                        new EquipmentRequirement(ItemID.CHEFS_HAT),
                        new EquipmentRequirement(ItemID.RED_CAPE)));
        textClues.put("Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Lumbridge, axe shop",
                        new AreaLocation(3228, 3201, 3233, 3205, 0),
                        Emote.CLAP,
                        new WorldPoint(3233, 3200, 0),
                        NullObjectID.NULL_34738,
                        new EquipmentRequirement(ItemID.BRONZE_AXE),
                        new EquipmentRequirement(ItemID.LEATHER_BOOTS)));
        textClues.put("Panic at Al Kharid mine.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Al Kharid mine",
                        new AreaLocation(3285, 3271, 3314, 3318, 0),
                        Emote.PANIC));
        textClues.put("Spin at Flynn's Mace Shop.",
                new EmoteClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Falador, mace shop",
                        new AreaLocation(2948, 3385, 2952, 3390, 0),
                        Emote.SPIN));
        textClues.put("Talk to Charlie the Tramp in Varrock.",
                new CharlieClue(false));
        textClues.put("I need to give Charlie a piece of iron ore.",
                new CharlieClue(ItemID.IRON_ORE));
        textClues.put("I have given the iron ore to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie a raw herring.",
                new CharlieClue(ItemID.RAW_HERRING));
        textClues.put("I have given the herring to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie one iron dagger.",
                new CharlieClue(ItemID.IRON_DAGGER));
        textClues.put("I have given the iron dagger to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie some leather chaps.",
                new CharlieClue(ItemID.LEATHER_CHAPS));
        textClues.put("I have given the leather chaps to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie a raw trout.",
                new CharlieClue(ItemID.RAW_TROUT));
        textClues.put("I need to give Charlie a cooked trout.",
                new CharlieClue(ItemID.TROUT));
        textClues.put("I have given the trout to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie a cooked pike.",
                new CharlieClue(ItemID.PIKE));
        textClues.put("I have given the pike to Charlie, maybe I should talk to him.",
                charlieDone);
        textClues.put("I need to give Charlie a leather body.",
                new CharlieClue(ItemID.LEATHER_BODY));
        textClues.put("I have given the leather body to Charlie, maybe I should talk to him.",
                charlieDone);

        mapClues.put(InterfaceID.CLUE_BEGINNER_MAP_CHAMPIONS_GUILD,
                new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "West of Champions' Guild",
                        3166, 3359, 3168, 3361, 0));
        mapClues.put(InterfaceID.CLUE_BEGINNER_MAP_VARROCK_EAST_MINE,
                new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "Varrock East Mine",
                        3289, 3372, 3291, 3374, 0));
        mapClues.put(InterfaceID.CLUE_BEGINNER_MAP_DYANOR,
                new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "South of Draynor Village",
                        3091, 3225, 3093, 3227, 0));
        mapClues.put(InterfaceID.CLUE_BEGINNER_MAP_NORTH_OF_FALADOR,
                new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "North of Falador, standing stones",
                        3042, 3398, 3044, 3400, 0));
        mapClues.put(InterfaceID.CLUE_BEGINNER_MAP_WIZARDS_TOWER,
                new DigClue(ItemID.CLUE_SCROLL_BEGINNER, ClueTier.BEGINNER,
                        "South of Wizards' Tower",
                        3108, 3152, 3110, 3154, 0));
    }

    @Nullable
    public static Clue getClue(final String clueText) {
        return textClues.get(clueText);
    }

    @Nullable
    public static Clue getClue(final int interfaceId) {
        return mapClues.get(interfaceId);
    }
}
