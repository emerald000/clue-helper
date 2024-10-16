package com.emerald000.cluehelper.cluesteps;

import com.emerald000.cluehelper.clues.BasicClue;
import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.DigClue;
import com.emerald000.cluehelper.clues.EmoteClue;
import com.emerald000.cluehelper.clues.FaloClue;
import com.emerald000.cluehelper.clues.HotColdClue;
import com.emerald000.cluehelper.clues.SherlockClue;
import com.emerald000.cluehelper.clues.UnimplementedClue;
import com.emerald000.cluehelper.clues.UnreadMasterClue;
import com.emerald000.cluehelper.enums.ClueEnemy;
import com.emerald000.cluehelper.enums.ClueQuest;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.locations.ObjectLocation;
import com.emerald000.cluehelper.locations.RadimusErkleLocation;
import com.emerald000.cluehelper.locations.SnowflakeLocation;
import com.emerald000.cluehelper.modules.EnemyModule;
import com.emerald000.cluehelper.modules.requirements.AxeRequirement;
import com.emerald000.cluehelper.modules.requirements.BarbarianHerbloreRequirement;
import com.emerald000.cluehelper.modules.requirements.BarrowsArmourSetRequirement;
import com.emerald000.cluehelper.modules.requirements.DustyKeyRequirement;
import com.emerald000.cluehelper.modules.requirements.EquipmentRequirement;
import com.emerald000.cluehelper.modules.requirements.GuthixEquipmentRequirement;
import com.emerald000.cluehelper.modules.requirements.InventoryRequirement;
import com.emerald000.cluehelper.modules.requirements.KharaziJungleRequirement;
import com.emerald000.cluehelper.modules.requirements.PickaxeRequirement;
import com.emerald000.cluehelper.modules.requirements.QuestRequirement;
import com.emerald000.cluehelper.modules.requirements.RangedAttackRequirement;
import com.emerald000.cluehelper.modules.requirements.SkillRequirement;
import com.emerald000.cluehelper.modules.requirements.ViyeldiCavesRequirement;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.ObjectID;
import net.runelite.api.Skill;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MasterClues {

    //TODO: Count
    private static final Map<String, Clue> textClues = new HashMap<>(0);
    @Getter
    private static final List<Clue> hotColdClues = new ArrayList<>(131);

    @Getter
    private static final Clue unreadClue = new UnreadMasterClue();
    @Getter
    static final Clue sherlockDone = new SherlockClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER, true);

    static {
        // Anagrams
        textClues.put("This anagram reveals<br>who to speak to next:<br><br>A ELF KNOWS",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Weiss, Snowflake",
                        new SnowflakeLocation(),
                        new QuestRequirement(ClueQuest.MAKING_FRIENDS_WITH_MY_ARM, 80)));
        textClues.put("This anagram reveals<br>who to speak to next:<br><br>BRUCIE CATNAP",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Shayzien Administration",
                        new NPCLocation(new WorldPoint(1530, 3567, 0),
                                NpcID.CAPTAIN_BRUCE)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Car If Ices", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Ded War", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Dim Tharn", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Duo Plug", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Forlun", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("This anagram reveals<br>who to speak to next:<br><br>IM N ZEZIM",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Puro-Puro",
                        new NPCLocation(new WorldPoint(2592, 4319, 0),
                                NpcID.IMMENIZZ),
                        new SkillRequirement(Skill.HUNTER, 17, false)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Mal in Tau", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Mold La Ran", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("This anagram reveals<br>who to speak to next:<br><br>MUS KIL READER",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Legends' Guild",
                        new RadimusErkleLocation(),
                        new QuestRequirement(ClueQuest.LEGENDS_QUEST, 1)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Rip Maul", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("This anagram reveals<br>who to speak to next:<br><br>RUE GO",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Lletya, south building",
                        new NPCLocation(new WorldPoint(2336, 3161, 0),
                                NpcID.GOREU),
                        new QuestRequirement(ClueQuest.MOURNINGS_END_PART_I, 1)));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Slam Duster Grail", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Ten Wigs On", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The anagram reveals<br> who to speak to next:<br>Twenty Cure Iron", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        // Coordinates
        textClues.put("1 degree 30 minutes north<br>8 degrees 11 minutes west",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Isafdar, south of Iorwerth Camp",
                        2177, 3208, 2179, 3210, 0,
                        new QuestRequirement(ClueQuest.REGICIDE, 2),
                        new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        textClues.put("1 degree 54 minutes south 8 degrees 54 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("2 degrees 9 minutes south 6 degrees 58 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("3 degrees 9 minutes south 43 degrees 26 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("3 degrees 26 minutes north 12 degrees 18 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("3 degrees 50 minutes north 9 degrees 7 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("4 degrees 58 minutes north 36 degrees 56 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("5 degrees 13 minutes north 4 degrees 16 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("7 degrees 37 minutes north 35 degrees 18 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("8 degrees 1 minute north 20 degrees 58 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("8 degrees 11 minutes north<br>12 degrees 30 minutes east",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Water obelisk, go through Taverley Dungeon",
                        2839, 3422, 2841, 3424, 0,
                        new DustyKeyRequirement(),
                        new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        textClues.put("12 degrees 35 minutes north 36 degrees 22 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("12 degrees 45 minutes north<br>20 degrees 9 minutes east",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Wilderness, Obelisk of Air, level 7",
                        3084, 3568, 3086, 3570, 0,
                        new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        textClues.put("13 degrees 33 minutes south 15 degrees 26 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("16 degrees 41 minutes north 30 degrees 54 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("18 degrees 3 minutes north 3 degrees 3 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("18 degrees 26 minutes north 37 degrees 15 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("19 degrees 43 minutes north 23 degrees 11 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("20 degrees 35 minutes north 15 degrees 58 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("20 degrees 45 minutes north 7 degrees 26 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("21 degrees 37 minutes north<br>21 degrees 13 minutes west",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Arceuus, dense essence mine",
                        1760, 3852, 1762, 3854, 0,
                        new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        textClues.put("21 degrees 56 minutes north<br>10 degrees 56 minutes west",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "South-west of Lunar Isle",
                        2089, 3862, 2091, 3864, 0,
                        new EnemyModule(ClueEnemy.ANCIENT_WIZARDS),
                        new QuestRequirement(ClueQuest.LUNAR_DIPLOMACY, 125)));
        textClues.put("22 degrees 24 minutes north 31 degrees 11 minutes west", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("24 degrees 0 minutes north 29 degrees 22 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("24 degrees 18 minutes north 23 degrees 22 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("24 degrees 22 minutes north 27 degrees 0 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("23 degrees 58 minutes north 18 degrees 22 minutes east", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        // Cryptic
        textClues.put("2 musical birds. Dig in front of the spinning light.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A chisel and hammer reside in his home, strange for one of magic. Impress him with your magical equipment.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A dwarf, approaching death, but very much in the light.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Temple of Light, death altar",
                        new NPCLocation(new WorldPoint(1860, 4641, 0),
                                NpcID.THORGEL),
                        new QuestRequirement(ClueQuest.MOURNINGS_END_PART_II, 40)));
        textClues.put("A massive battle rages beneath so be careful when you dig by the large broken crossbow.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Anger Abbot Langley.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Anger those who adhere to Saradomin's edicts to prevent travel.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("For a list of all possible locations, see here.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Come brave adventurer, your sense is on fire. If you talk to me, it's an old god you desire.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Darkness wanders around me, but fills my mind with knowledge.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Arceuus Library, top floor",
                        new NPCLocation(new WorldPoint(1633, 3823, 2),
                                NpcID.BIBLIA)));
        // TODO: Verify area
        textClues.put("Dig in front of the icy arena where 1 of 4 was fought.",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Ice Path arena (Verify)",
                        2874, 3754, 2880, 3760, 0,
                        new QuestRequirement(ClueQuest.DESERT_TREASURE_I, 378, 0, 5)));
        textClues.put("Faint sounds of 'Arr', fire giants found deep, the eastern tip of a lake, are the rewards you could reap.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Elvish onions.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Fiendish cooks probably won't dig the dirty dishes.",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Rogues' Den",
                        3040, 4970, 3046, 4976, 1));
        textClues.put("The doorman of the Warriors' Guild wishes to be impressed by how strong your equipment is.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Great demons, dragons, and spiders protect this blue rock, beneath which, you may find what you seek.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Guthix left his mark in a fiery lake, dig at the tip of it.",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Wilderness, west of Mage Arena, level 52",
                        3065, 3932, 3071, 3937, 0));
        textClues.put("Here, there are tears, but nobody is crying. Speak to the guardian and show off your alignment to balance.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Chasm of Tears",
                        new ObjectLocation(new WorldPoint(3252, 9516, 2),
                                NullObjectID.NULL_3193), // Juna base object
                        new GuthixEquipmentRequirement(3)));
        textClues.put("Hopefully this set of armour will help you to keep surviving.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("If you're feeling brave, dig beneath the dragon's eye.",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Viyeldi caves",
                        2406, 4712, 2412, 4718, 0,
                        new QuestRequirement(ClueQuest.LEGENDS_QUEST, 16),
                        new KharaziJungleRequirement(),
                        new ViyeldiCavesRequirement()));
        textClues.put("I lie beneath the first descent to the holy encampment.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("My life was spared but these voices remain, now guarding these iron gates is my bane.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("One of several rhyming brothers, in business attire with an obsession for paper work.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Pentagrams and demons, burnt bones and remains, I wonder what the blood contains.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Robin wishes to see your finest ranged equipment.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Port Phasmatys, inn",
                        new NPCLocation(new WorldPoint(3676, 3494, 0),
                                NpcID.ROBIN),
                        new QuestRequirement(ClueQuest.PRIEST_IN_PERIL),
                        new RangedAttackRequirement(181)));
        textClues.put("She's small but can build both literally and figuratively.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Shhhh!", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("South of a river in a town surrounded by the undead, what lies beneath the furnace?", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("The far north eastern corner where 1 of 4 was defeated, the shadows still linger.",
                new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Shadow Dungeon, north-east corner",
                        2742, 5112, 2746, 5116, 0,
                        new EquipmentRequirement("Ring of visibility",
                                ItemID.RING_OF_VISIBILITY,
                                ItemID.RING_OF_SHADOWS_UNCHARGED,
                                ItemID.RING_OF_SHADOWS),
                        new QuestRequirement(ClueQuest.DESERT_TREASURE_I, 11)));
        textClues.put("This place sure is a mess.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Under a giant robotic bird that cannot fly.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Where safe to speak, the man who offers the pouch of smallest size wishes to see your alignment.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        // Emote
        textClues.put("Beckon by a collection of crystalline maple trees. Beware of double agents! Equip Bryophyta's staff and a nature tiara.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a Zamorak full helm and the shadow sword.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Blow a raspberry at the bank of the Warrior's[sic] guild. Beware of double agents! Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Bow in the Iorwerth Camp. Beware of double agents! Equip a charged crystal bow.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Cheer in the Entrana church. Beware of double agents! Equip a set of full black dragonhide armour.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Clap in the magic axe hut. Beware of double agents. Equip only flared trousers", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Cry in the Tzhaar gem store. Beware of the double agents! Equip a fire cape and a TokTz-Xil-Ul.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top and a black mystic bottom.",
                new EmoteClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Underground Pass, Iban's temple",
                        new AreaLocation(2006, 4709, 2013, 4716, 1),
                        Emote.DANCE,
                        new WorldPoint(2006, 4709, 1),
                        NullObjectID.NULL_29043,
                        new EquipmentRequirement("Iban's staff",
                                ItemID.IBANS_STAFF,
                                ItemID.IBANS_STAFF_U),
                        new EquipmentRequirement(ItemID.MYSTIC_ROBE_TOP_DARK),
                        new EquipmentRequirement(ItemID.MYSTIC_ROBE_BOTTOM_DARK),
                        new QuestRequirement(ClueQuest.REGICIDE, 2),
                        new EnemyModule(ClueEnemy.DOUBLE_AGENT)));
        textClues.put("Dance in the King Black Dragon's lair. Beware of double agents! Equip a black d'hide body, black d'hide vambraces and a black dragon mask.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Do a jig at the Barrows chest. Beware of double agents! Equip any full barrows set.",
                new EmoteClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Barrows, final chest",
                        new AreaLocation(3547, 9690, 3556, 9699, 0),
                        Emote.JIG,
                        new WorldPoint(3547, 9690, 0),
                        NullObjectID.NULL_29042,
                        new BarrowsArmourSetRequirement(),
                        new QuestRequirement(ClueQuest.PRIEST_IN_PERIL),
                        new SkillRequirement(Skill.DEFENCE, 70, false),
                        new EnemyModule(ClueEnemy.DOUBLE_AGENT)));
        textClues.put("Flap at the Death Altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Salute outside the gates of Cam Torum. Beware of double agents! Equip a full set of blue moon equipment.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Goblin Salute at the Goblin Village. Beware of double agents! Equip a Bandos platebody, Bandos cloak and Bandos godsword.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Show your anger towards the Statue of Saradomin in Ellamaria's garden.<br><br>Beware of double agents! Equip a Zamorak godsword.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip arclight or emberlight along with the amulet of the damned.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Spin in front of the Soul Altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Swing a bullroarer at the top of the Watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.",
                new EmoteClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Watchtower, top floor",
                        new AreaLocation(2927, 4711, 2934, 4718, 2),
                        Emote.BULLROARER,
                        new WorldPoint(2930, 4718, 2),
                        NullObjectID.NULL_29057,
                        new InventoryRequirement(ItemID.BULLROARER),
                        new EquipmentRequirement("Dragon plateskirt",
                                ItemID.DRAGON_PLATESKIRT,
                                ItemID.DRAGON_PLATESKIRT_G,
                                ItemID.DRAGON_PLATESKIRT_CR),
                        new EquipmentRequirement("Climbing boots",
                                ItemID.CLIMBING_BOOTS,
                                ItemID.CLIMBING_BOOTS_G),
                        new EquipmentRequirement("Dragon chainbody",
                                ItemID.DRAGON_CHAINBODY_3140, // Regular
                                ItemID.DRAGON_CHAINBODY_G,
                                ItemID.DRAGON_CHAINBODY_CR),
                        new QuestRequirement(ClueQuest.LEGENDS_QUEST, 3),
                        new QuestRequirement(ClueQuest.WATCHTOWER),
                        new QuestRequirement(ClueQuest.DEATH_PLATEAU),
                        new SkillRequirement(Skill.DEFENCE, 60, false),
                        new EnemyModule(ClueEnemy.DOUBLE_AGENT)));
        textClues.put("Wave on the northern wall of the Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharaoh's sceptre and a full set of menaphite robes.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        // Sherlock
        textClues.put("Show this to Sherlock.",
                new SherlockClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER, false));
        textClues.put("Equip an abyssal whip in front of the abyssal demons of the Slayer Tower.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Smith a runite med helm.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Teleport to a spirit tree you planted yourself.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Create a Barrows teleport tablet.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Slay a nechryael in the Slayer tower.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Slayer Tower, top floor, kill a Nechryael",
                        new NPCLocation(new WorldPoint(3440, 3566, 2),
                                NpcID.NECHRYAEL),
                        new SkillRequirement(Skill.SLAYER, 80, true)));
        textClues.put("<str>Slay a nechryael in the Slayer tower.</str>",
                sherlockDone);
        textClues.put("Kill the spiritual, magic and godly whilst representing their own god.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Create an unstrung dragonstone amulet at a furnace.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Burn a magic log.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Burn a redwood log.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Catch a tecu salamander.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Ralos' Rise, catch a tecu salamander",
                        new NPCLocation(new WorldPoint(1472, 3096, 0),
                                NpcID.TECU_SALAMANDER),
                        new SkillRequirement(Skill.HUNTER, 79, true),
                        new QuestRequirement(ClueQuest.CHILDREN_OF_THE_SUN),
                        new InventoryRequirement(ItemID.SMALL_FISHING_NET),
                        new InventoryRequirement(ItemID.ROPE)));
        textClues.put("<str>Catch a tecu salamander.</str>",
                sherlockDone);
        textClues.put("Complete a lap of the Rellekka rooftop agility course whilst sporting the finest amount of grace.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Mix an anti-venom potion.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Mine a piece of runite ore whilst sporting the finest mining gear.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Mine a runite rock",
                        // TODO: Rune rocks locations
                        null,
                        new PickaxeRequirement(),
                        new EquipmentRequirement("Prospector helmet",
                                ItemID.PROSPECTOR_HELMET,
                                ItemID.GOLDEN_PROSPECTOR_HELMET),
                        new EquipmentRequirement("Prospector jacket",
                                ItemID.PROSPECTOR_JACKET,
                                ItemID.GOLDEN_PROSPECTOR_HELMET,
                                ItemID.VARROCK_ARMOUR_4),
                        new EquipmentRequirement("Prospector legs",
                                ItemID.PROSPECTOR_LEGS,
                                ItemID.GOLDEN_PROSPECTOR_LEGS),
                        new EquipmentRequirement("Prospector boots",
                                ItemID.PROSPECTOR_BOOTS,
                                ItemID.GOLDEN_PROSPECTOR_BOOTS),
                        new SkillRequirement(Skill.MINING, 85, true)));
        textClues.put("<str>Mine a piece of runite ore whilst sporting the finest mining gear.</str>",
                sherlockDone);
        textClues.put("Blast Mine does not work for this challenge", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Steal a gem from the Ardougne market.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Pickpocket an elf.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Bind a blood rune at the Blood Altar.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Either blood altar may be used.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Mix a ranging mix potion.", new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Mix a ranging mix potion",
                null,
                new InventoryRequirement(ItemID.RANGING_POTION2),
                new InventoryRequirement(ItemID.CAVIAR),
                new SkillRequirement(Skill.HERBLORE, 80, true),
                new BarbarianHerbloreRequirement()));
        textClues.put("<str>Mix a ranging mix potion.</str>",
                sherlockDone);
        textClues.put("Fletch a rune dart.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Fletch a rune dart",
                        null,
                        new InventoryRequirement(ItemID.RUNE_DART_TIP),
                        new InventoryRequirement("Feather",
                                ItemID.FEATHER,
                                ItemID.STRIPY_FEATHER,
                                ItemID.RED_FEATHER,
                                ItemID.BLUE_FEATHER,
                                ItemID.YELLOW_FEATHER,
                                ItemID.ORANGE_FEATHER),
                        new SkillRequirement(Skill.FLETCHING, 81, true),
                        new QuestRequirement(ClueQuest.THE_TOURIST_TRAP, 16)));
        textClues.put("<str>Fletch a rune dart.</str>",
                sherlockDone);
        textClues.put("Cremate a set of Fiyr remains.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Cremate Fiyr remains",
                        // TODO: All pyre sites locations
                        new ObjectLocation(new WorldPoint(3507, 3276, 0),
                                ObjectID.FUNERAL_PYRE,
                                ObjectID.MAGIC_PYRE,
                                ObjectID.MAGIC_PYRE_4105,
                                ObjectID.REDWOOD_PYRE,
                                ObjectID.REDWOOD_PYRE_28866),
                        new SkillRequirement(Skill.FIREMAKING, 80, true),
                        new QuestRequirement(ClueQuest.SHADES_OF_MORTTON),
                        new InventoryRequirement(ItemID.FIYR_REMAINS),
                        new InventoryRequirement("Magic/Redwood pyre logs",
                                ItemID.MAGIC_PYRE_LOGS,
                                ItemID.REDWOOD_PYRE_LOGS),
                        new InventoryRequirement(ItemID.TINDERBOX)));
        textClues.put("<str>Cremate a set of Fiyr remains.</str>",
                sherlockDone);
        textClues.put("Dissect a sacred eel.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Dissect a sacred eel",
                        new NPCLocation(new WorldPoint(2199, 3066, 0),
                                NpcID.FISHING_SPOT_6488),
                        new SkillRequirement(Skill.FISHING, 87, true),
                        new SkillRequirement(Skill.COOKING, 72, true),
                        new QuestRequirement(ClueQuest.REGICIDE, 8),
                        new SkillRequirement(Skill.AGILITY, 56, true),
                        new InventoryRequirement(ItemID.KNIFE),
                        new InventoryRequirement("Sacred eel (fishing rod + fishing bait)", ItemID.SACRED_EEL)));
        textClues.put("<str>Dissect a sacred eel.</str>",
                sherlockDone);
        textClues.put("Kill a lizardman shaman.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Kill a lizardman shaman",
                        // TODO: Other locations
                        new NPCLocation(new WorldPoint(1434, 3711, 0),
                                NpcID.LIZARDMAN_SHAMAN,
                                NpcID.LIZARDMAN_SHAMAN_6767,
                                NpcID.LIZARDMAN_SHAMAN_7573,
                                NpcID.LIZARDMAN_SHAMAN_7574,
                                NpcID.LIZARDMAN_SHAMAN_7744,
                                NpcID.LIZARDMAN_SHAMAN_7745,
                                NpcID.LIZARDMAN_SHAMAN_8565)));
        textClues.put("<str>Kill a lizardman shaman.</str>",
                sherlockDone);
        textClues.put("Angle for an Anglerfish in your finest fishing gear.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Chop a redwood log whilst sporting the finest lumberjack gear.",
                new BasicClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        "Chop a redwood log",
                        // TODO: Redwood locations
                        null,
                        new AxeRequirement(),
                        new EquipmentRequirement("Lumberjack hat",
                                ItemID.LUMBERJACK_HAT,
                                ItemID.FORESTRY_HAT,
                                ItemID.FORESTRY_KIT,
                                ItemID.FORESTRY_BASKET,
                                ItemID.OPEN_FORESTRY_BASKET),
                        new EquipmentRequirement("Lumberjack top",
                                ItemID.LUMBERJACK_TOP,
                                ItemID.FORESTRY_TOP,
                                ItemID.FORESTRY_KIT,
                                ItemID.FORESTRY_BASKET,
                                ItemID.OPEN_FORESTRY_BASKET),
                        new EquipmentRequirement("Lumberjack legs",
                                ItemID.LUMBERJACK_LEGS,
                                ItemID.FORESTRY_LEGS,
                                ItemID.FORESTRY_KIT,
                                ItemID.FORESTRY_BASKET,
                                ItemID.OPEN_FORESTRY_BASKET),
                        new EquipmentRequirement("Lumberjack boots",
                                ItemID.LUMBERJACK_BOOTS,
                                ItemID.FORESTRY_BOOTS,
                                ItemID.FORESTRY_KIT,
                                ItemID.FORESTRY_BASKET,
                                ItemID.OPEN_FORESTRY_BASKET),
                        new SkillRequirement(Skill.WOODCUTTING, 90, true)));
        textClues.put("<str>Chop a redwood log whilst sporting the finest lumberjack gear.</str>",
                sherlockDone);
        textClues.put("Craft a light orb in the Dorgesh-Kaan bank.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Kill a reanimated abyssal.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Kill a Fiyr shade inside Mort'tons shade catacombs.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        // Falo
        textClues.put("Falo the bard wants to see you.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER, false));
        textClues.put("A blood red weapon, a strong curved sword, found on the island of primate lords.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A book that preaches of some great figure, lending strength, might and vigour.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A bow of elven craft was made, it shimmers bright, but will soon fade.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A fiery axe of great inferno, when you use it, you'll wonder where the logs go.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A mark used to increase one's grace, found atop a seer's place.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement(
                                ItemID.MARK_OF_GRACE)));
        textClues.put("A molten beast with fiery breath, you acquire these with its death.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A shiny helmet of flight, to obtain this with melee, struggle you might.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A sword held in the other hand, red its colour, Cyclops strength you must withstand.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("A token used to kill mythical beasts, in hopes of a blade or just for an xp feast.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement(
                                ItemID.WARRIOR_GUILD_TOKEN)));
        textClues.put("Green is my favourite, mature ale I do love, this takes your herblore above.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("It can hold down a boat or crush a goat, this object, you see, is quite heavy.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("It comes from the ground, underneath the snowy plain. Trolls aplenty, with what looks like a mane.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement(
                                ItemID.BASALT)));
        textClues.put("No attack to wield, only strength is required, made of obsidian, but with no room for a shield.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement("Tzhaar-ket-om",
                                ItemID.TZHAARKETOM,
                                ItemID.TZHAARKETOM_T)));
        textClues.put("Penance healers runners and more, obtaining this body often gives much deplore.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Strangely found in a chest, many believe these gloves are the best.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("These gloves of white won't help you fight, but aid in cooking, they just might.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("They come from some time ago, from a land unto the east. Fossilised they have become, this small and gentle beast.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement(
                                ItemID.NUMULITE)));
        textClues.put("To slay a dragon you must first do, before this chest piece can be put on you.", new UnimplementedClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));
        textClues.put("Vampyres are agile opponents, damaged best with a weapon of many components.",
                new FaloClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                        new InventoryRequirement("Rod of Ivandis, Ivandis flail, or Blisterwood flail",
                                ItemID.ROD_OF_IVANDIS_1,
                                ItemID.ROD_OF_IVANDIS_2,
                                ItemID.ROD_OF_IVANDIS_3,
                                ItemID.ROD_OF_IVANDIS_4,
                                ItemID.ROD_OF_IVANDIS_5,
                                ItemID.ROD_OF_IVANDIS_6,
                                ItemID.ROD_OF_IVANDIS_7,
                                ItemID.ROD_OF_IVANDIS_8,
                                ItemID.ROD_OF_IVANDIS_9,
                                ItemID.ROD_OF_IVANDIS_10,
                                ItemID.IVANDIS_FLAIL,
                                ItemID.BLISTERWOOD_FLAIL),
                        new QuestRequirement(ClueQuest.IN_AID_OF_THE_MYREQUE, 420)));
        // Hot-Cold
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of the Warriors' Guild in Burthorpe.",
                2856, 3558, 2864, 3566, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Taverley, east of herblore shop",
                2911, 3421, 2919, 3429, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Barbarian Village.",
                3029, 3434, 3037, 3442, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of Miazrqa's tower, outside Goblin Village.",
                2968, 3482, 2976, 3490, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "In the cow pen north of Sarah's Farming Shop.",
                3027, 3300, 3035, 3308, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside the Falador Party Room.",
                3026, 3360, 3034, 3368, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside the Crafting Guild cow pen.",
                2913, 3291, 2921, 3299, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "In the centre of the Rimmington mine.",
                2972, 3235, 2980, 3243, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Mudskipper Point, near the starfish in the south-west corner.",
                2983, 3106, 2991, 3114, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "The Troll arena, south of Trollheim.",
                2906, 3611, 2914, 3619, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Nardah genie cave.",
                3355, 2908, 3363, 2916, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Al Kharid mine.",
                3275, 3259, 3283, 3267, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of Menaphos gate.",
                3219, 2816, 3227, 2824, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Bedabin Camp, near the north tent.",
                3157, 3043, 3165, 3051, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Uzer.",
                3428, 3101, 3436, 3109, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Pollnivneach.",
                3284, 2972, 3292, 2980, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Next to Mage Training Arena.",
                3341, 3289, 3349, 3297, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-west of Shantay Pass.",
                3288, 3103, 3296, 3111, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the ruins of Ullek.",
                3424, 2769, 3432, 2777, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Jiggig, east of fairy ring (BKP).",
                2405, 3049, 2413, 3057, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the south-easternmost lake in Feldip Hills.",
                2582, 2893, 2590, 2901, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of the gnome glider (Lemantolly Undri).",
                2551, 2968, 2559, 2976, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of Rantz, west of the empty glass bottles.",
                2607, 2946, 2615, 2954, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of Jiggig.",
                2482, 3003, 2490, 3011, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside the red chinchompa hunting ground entrance, south of the Hunting expert's hut.",
                2526, 2897, 2534, 2905, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the ?-shaped lake, near the Hunter icon.",
                2565, 2914, 2573, 2922, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Directly west of the Castle Wars balloon.",
                2447, 3108, 2455, 3116, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "At the Mountain Camp.",
                2796, 3665, 2804, 3673, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "At the Rellekka Hunter area, near the Hunter icon.",
                2716, 3780, 2724, 3788, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the Keldagrim entrance mine.",
                2707, 3685, 2715, 3693, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside the fence in the south-western corner of Rellekka.",
                2600, 3644, 2608, 3652, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the Lighthouse.",
                2581, 3597, 2589, 3605, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of Etceteria's castle.",
                2613, 3858, 2621, 3866, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside Miscellania's courtyard.",
                2523, 3864, 2531, 3872, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Central Fremennik Isles mine.",
                2370, 3846, 2378, 3854, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West Fremennik Isles mine.",
                2309, 3846, 2317, 3854, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the Jatizso mine entrance.",
                2389, 3808, 2397, 3816, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Pirates' Cove.",
                2207, 3813, 2215, 3821, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Astral Altar.",
                2145, 3861, 2153, 3869, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Lunar Isle, inside the village.",
                2080, 3912, 2088, 3920, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Lunar Isle, north of the village.",
                2102, 3945, 2110, 3953, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Isle of Souls Mine, south of the Soul Wars lobby.",
                2185, 2790, 2193, 2798, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-west of the Sinclair Mansion, near the log balance shortcut.",
                2726, 3584, 2734, 3592, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Catherby, between the bank and the beehives, near small rock formation.",
                2770, 3432, 2778, 3440, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Grand Tree, just east of the terrorchick gnome enclosure.",
                2444, 3499, 2452, 3507, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside Seers' Village bank.",
                2728, 3481, 2736, 3489, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "McGrubor's Wood.",
                2649, 3481, 2657, 3489, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the Fishing Guild.",
                2586, 3365, 2594, 3373, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Outside Witchaven, west of Jeb, Holgart, and Caroline.",
                2703, 3302, 2711, 3310, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Ground floor inside the Necromancer Tower. Easily accessed by using fairy ring code djp.",
                2663, 3237, 2671, 3245, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the Fight Arena, north-west of the Nightmare Zone.",
                2583, 3131, 2591, 3139, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Tree Gnome Village, near the general store icon.",
                2526, 3160, 2534, 3168, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Grave of Scorpius.",
                2463, 3223, 2471, 3231, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Khazard Battlefield, south of Tracker gnome 2.",
                2518, 3248, 2526, 3256, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West Ardougne, near the staircase outside the Civic Office.",
                2531, 3318, 2539, 3326, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-west Tree Gnome Stronghold.",
                2407, 3425, 2415, 3433, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the Tree Gnome Stronghold, north-east of the Outpost.",
                2453, 3358, 2461, 3366, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of Almera's house on Baxtorian Falls.",
                2526, 3473, 2534, 3481, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Inside the Barbarian Agility Course. Completion of Alfred Grimhand's Barcrawl is required.",
                2536, 3544, 2544, 3552, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Musa Point, banana plantation.",
                2909, 3165, 2917, 3173, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Brimhaven, east of the fruit tree patch.",
                2778, 3211, 2786, 3219, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Brimhaven.",
                2714, 3163, 2722, 3171, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the gnome glider.",
                2962, 2972, 2970, 2980, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-eastern part of Kharazi Jungle.",
                2900, 2921, 2908, 2929, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-western part of Kharazi Jungle.",
                2782, 2895, 2790, 2903, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Northern part of Crash Island.",
                2905, 2733, 2913, 2741, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the stone circle near Varrock's entrance.",
                3221, 3352, 3229, 3360, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Just north-west of the Lumbridge Fishing tutor.",
                3230, 3165, 3238, 3173, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of the pond between Lumbridge and Draynor Village.",
                3165, 3275, 3173, 3283, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-east of Gertrude's house west of Varrock.",
                3150, 3417, 3158, 3425, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of Draynor Village bank.",
                3094, 3230, 3102, 3238, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of Lumber Yard, east of Assistant Serf.",
                3297, 3480, 3305, 3488, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "In the north-east area of Burgh de Rott, by the reverse-L-shaped ruins.",
                3542, 3248, 3550, 3256, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-western part of Darkmeyer.",
                3600, 3322, 3608, 3330, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of Port Phasmatys, south-east of fairy ring.",
                3607, 3481, 3615, 3489, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Inside The Hollows, south of the bridge which was repaired in a quest.",
                3495, 3417, 3503, 3425, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Inside the Mort Myre Swamp, north-west of the Nature Grotto.",
                3414, 3368, 3422, 3376, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "At Haunted Mine quest start.",
                3440, 3251, 3448, 3259, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the Morytania Mausoleum.",
                3495, 3535, 3503, 3543, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Northern area of Mos Le'Harmless, between the lakes.",
                3736, 3037, 3744, 3045, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Near Mos Le'Harmless southern bar.",
                3662, 2968, 3670, 2976, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Northern part of Dragontooth Island.",
                3807, 3565, 3815, 3573, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Southern part of Dragontooth Island.",
                3799, 3528, 3807, 3536, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-east of Slepe, near the tents.",
                3765, 3379, 3773, 3387, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-west of Eagles' Peak.",
                2293, 3525, 2301, 3533, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Piscatoris Fishing Colony.",
                2330, 3681, 2338, 3689, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Eastern part of Piscatoris Hunter area, south-west of the Falconry.",
                2355, 3560, 2363, 3568, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-west of the crystal gate to Arandar.",
                2366, 3315, 2374, 3323, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of Iorwerth Camp.",
                2264, 3238, 2272, 3246, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-west of Iorwerth Camp.",
                2173, 3278, 2181, 3286, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "In Lletya.",
                2333, 3162, 2341, 3170, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Near Tyras Camp.",
                2202, 3154, 2210, 3162, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "The northern house at Zul-Andra.",
                2192, 3053, 2200, 3061, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of the Grand Exchange, level 5 Wilderness.",
                3169, 3552, 3177, 3560, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the Dark Warriors' Fortress, level 12 Wilderness.",
                3032, 3608, 3040, 3616, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of the Corporeal Beast's lair, level 20 Wilderness.",
                3218, 3675, 3226, 3683, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Inside the Ruins north of the Graveyard of Shadows, level 27 Wilderness.",
                3170, 3732, 3178, 3740, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of Venenatis' nest, level 28 Wilderness.",
                3373, 3733, 3381, 3741, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of Venenatis' nest, level 32 Wilderness.",
                3307, 3769, 3315, 3777, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of the Wilderness canoe exit, level 35 Wilderness.",
                3148, 3792, 3156, 3800, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS_OR_BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the Chaos Temple, level 37 Wilderness.",
                2970, 3810, 2978, 3818, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of Callisto, level 38 Wilderness.",
                3289, 3809, 3297, 3817, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-west of the Deserted Keep, level 49 Wilderness.",
                3132, 3910, 3140, 3918, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the Wilderness Agility Course, level 54 Wilderness.",
                2977, 3940, 2985, 3948, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Next to the bank in the Lovakengj blast mine.",
                1500, 3855, 1508, 3863, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Northern part of the Lovakengj blast mine.",
                1484, 3877, 1492, 3885, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Next to the lovakite furnace in Lovakengj.",
                1503, 3815, 1511, 3823, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Next to mithril rock in the Lovakengj mine.",
                1473, 3774, 1481, 3782, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Western entrance in the Lovakengj sulphur mine. Facemask or Slayer Helmet recommended.",
                1424, 3865, 1432, 3873, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-east of the bank in Shayzien Encampment.",
                1494, 3623, 1502, 3631, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Overpass between Lovakengj and Shayzien.",
                1463, 3710, 1471, 3718, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Within Lizardman Canyon, east of the ladder.",
                1486, 3694, 1494, 3702, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Shayzien Encampment, south-east of the Combat Ring.",
                1553, 3620, 1561, 3628, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of the bank in Shayzien.",
                1486, 3598, 1494, 3606, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-west of the Arceuus Library.",
                1599, 3839, 1607, 3847, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "By the entrance to the Arceuus church.",
                1678, 3788, 1686, 3796, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the Dark Altar.",
                1694, 3877, 1702, 3885, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "By the south-eastern entrance to Arceuus.",
                1706, 3696, 1714, 3704, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "By the Arceuus essence mine.",
                1758, 3848, 1766, 3856, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-east of the Arceuus essence mine.",
                1769, 3863, 1777, 3871, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the Piscarilius mine.",
                1764, 3701, 1772, 3709, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South of the gravestone in Kingstown.",
                1714, 3639, 1722, 3647, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of the Mess hall.",
                1652, 3617, 1660, 3625, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "East of Watson's house.",
                1649, 3569, 1657, 3577, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North of Tithe Farm, next to the pond.",
                1803, 3519, 1811, 3527, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "West of the Farming Guild.",
                1204, 3732, 1212, 3740, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "North-east of the Kebos Lowlands, east of the dairy cow.",
                1320, 3718, 1328, 3726, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "South-west of the Kebos Swamp, below the crimson swifts.",
                1183, 3576, 1191, 3584, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Amongst the trees at the Locus Oasis in Varlamore",
                1691, 2986, 1699, 2994, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "Overlooking the Sunset Coast in Varlamore",
                1530, 2993, 1538, 3001, 0,
                new EnemyModule(ClueEnemy.BRASSICAN_MAGE)));
        // TODO: Complete
        hotColdClues.add(new DigClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER,
                "In the centre of the Bazaar in Civitas illa Fortis",
                1676, 3103, 1684, 3111, 0,
                new EnemyModule(ClueEnemy.ANCIENT_WIZARDS)));
        textClues.put("Buried beneath the ground, who knows where it's found.<br><br>Lucky for you, a man called Jorral may have a clue.",
                new HotColdClue(ItemID.CLUE_SCROLL_MASTER, ClueTier.MASTER));

        // TODO: New Varlamore part 2 steps.
    }

    @Nullable
    public static Clue getClue(final String clueText) {
        return textClues.get(clueText);
    }
}
