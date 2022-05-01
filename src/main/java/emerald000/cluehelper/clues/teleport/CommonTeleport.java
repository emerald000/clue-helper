/*
 * Copyright (c) 2020, emerald000
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package emerald000.cluehelper.clues.teleport;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import net.runelite.client.plugins.achievementdiary.FavourRequirement.Favour;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import static net.runelite.api.Quest.HOLY_GRAIL;
import static net.runelite.api.Quest.*;
import static net.runelite.api.Skill.AGILITY;
import static net.runelite.api.Skill.COOKING;
import static net.runelite.api.Skill.FISHING;
import static net.runelite.api.Skill.MAGIC;
import static net.runelite.api.Varbits.EXPLORER_RING_TELEPORTS;
import emerald000.cluehelper.ClueHelperPlugin;
import emerald000.cluehelper.clues.requirement.AllQuestsRequirement;
import emerald000.cluehelper.clues.requirement.AndRequirement;
import static emerald000.cluehelper.clues.requirement.CommonRequirement.*;
import emerald000.cluehelper.clues.requirement.DiaryRequirement;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.ELITE;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.HARD;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.MEDIUM;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.ARDOUGNE;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.DESERT;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.FREMENNIK;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.KANDARIN;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.VARROCK;
import emerald000.cluehelper.clues.requirement.EquipmentRequirement;
import emerald000.cluehelper.clues.requirement.FavourRequirement;
import emerald000.cluehelper.clues.requirement.Fulfilled;
import emerald000.cluehelper.clues.requirement.HomeTeleportRequirement;
import emerald000.cluehelper.clues.requirement.HouseRequirement;
import emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.BRIMHAVEN;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.POLLNIVNEACH;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.PRIFDDINAS;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.RELLEKKA;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.RIMMINGTON;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.TAVERLEY;
import static emerald000.cluehelper.clues.requirement.HouseRequirement.HouseLocation.YANILLE;
import emerald000.cluehelper.clues.requirement.InventoryRequirement;
import emerald000.cluehelper.clues.requirement.MinigameTeleportRequirement;
import emerald000.cluehelper.clues.requirement.NMZRequirement;
import emerald000.cluehelper.clues.requirement.OrRequirement;
import emerald000.cluehelper.clues.requirement.QuestRequirement;
import emerald000.cluehelper.clues.requirement.Requirement;
import emerald000.cluehelper.clues.requirement.RuneRequirement;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.AIR;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.ASTRAL;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.BLOOD;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.EARTH;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.FIRE;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.LAW;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.NATURE;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.SOUL;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.WATER;
import emerald000.cluehelper.clues.requirement.SkillRequirement;
import emerald000.cluehelper.clues.requirement.SpellbookRequirement;
import static emerald000.cluehelper.clues.requirement.SpellbookRequirement.Spellbook.ANCIENT;
import static emerald000.cluehelper.clues.requirement.SpellbookRequirement.Spellbook.ARCEUUS;
import static emerald000.cluehelper.clues.requirement.SpellbookRequirement.Spellbook.LUNAR;
import static emerald000.cluehelper.clues.requirement.SpellbookRequirement.Spellbook.STANDARD;
import emerald000.cluehelper.clues.requirement.VarbitsRequirement;
import static emerald000.cluehelper.clues.requirement.VarbitsRequirement.ComparisonType.LESS_THAN;

@Getter
public enum CommonTeleport implements Teleport
{
	AMULET_OF_GLORY_AL_KHARID("Amulet of Glory: Al Kharid",
		CAN_TELEPORT_WITH_AMULET_OF_GLORY.getRequirement()),
	AMULET_OF_GLORY_DRAYNOR_VILLAGE("Amulet of Glory: Draynor Village",
		CAN_TELEPORT_WITH_AMULET_OF_GLORY.getRequirement()),
	AMULET_OF_GLORY_EDGEVILLE("Amulet of Glory: Edgeville",
		CAN_TELEPORT_WITH_AMULET_OF_GLORY.getRequirement()),
	AMULET_OF_GLORY_KARAMJA("Amulet of Glory: Karamja",
		CAN_TELEPORT_WITH_AMULET_OF_GLORY.getRequirement()),
	ANCIENT_ANNAKARL("Ancient: Annakarl Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 90),
				new RuneRequirement(BLOOD, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(ANNAKARL_TELEPORT))),
	ANCIENT_CARRALLANGAR("Ancient: Carrallangar Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 84),
				new RuneRequirement(SOUL, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(CARRALLANGAR_TELEPORT))),
	ANCIENT_DAREEYAK("Ancient: Dareeyak Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 78),
				new RuneRequirement(AIR, 2),
				new RuneRequirement(FIRE, 3),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(DAREEYAK_TELEPORT))),
	ANCIENT_GHORROCK("Ancient: Ghorrock Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 96),
				new RuneRequirement(WATER, 8),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(GHORROCK_TELEPORT))),
	ANCIENT_KHARYRLL("Ancient: Kharyrll Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 66),
				new RuneRequirement(BLOOD),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(KHARYRLL_TELEPORT))),
	ANCIENT_LASSAR("Ancient: Lassar Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 72),
				new RuneRequirement(WATER, 4),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(LASSAR_TELEPORT))),
	ANCIENT_PADDEWWA("Ancient: Paddewwa Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 64),
				new RuneRequirement(AIR),
				new RuneRequirement(FIRE),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(PADDEWWA_TELEPORT))),
	ANCIENT_SENNTISTEN("Ancient: Senntisten Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ANCIENT),
				new SkillRequirement(MAGIC, 60),
				new RuneRequirement(SOUL),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(SENNTISTEN_TELEPORT))),
	ARCEUUS_APE_ATOLL("Arceuus: Ape Atoll Teleport",
		new QuestRequirement(MONKEY_MADNESS_I),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 90),
				new RuneRequirement(BLOOD, 2),
				new RuneRequirement(LAW, 2),
				new RuneRequirement(SOUL, 2)),
			new InventoryRequirement(BARROWS_TELEPORT))),
	ARCEUUS_BARROWS("Arceuus: Barrows Teleport",
		new QuestRequirement(PRIEST_IN_PERIL),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 83),
				new RuneRequirement(BLOOD),
				new RuneRequirement(LAW, 2),
				new RuneRequirement(SOUL, 2)),
			new InventoryRequirement(BARROWS_TELEPORT))),
	ARCEUUS_CEMETERY("Arceuus: Cemetery Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 71),
				new RuneRequirement(SOUL),
				new RuneRequirement(BLOOD),
				new RuneRequirement(LAW)),
			new InventoryRequirement(CEMETERY_TELEPORT))),
	ARCEUUS_DRAYNOR_MANOR("Arceuus: Draynor Manor Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 17),
				new RuneRequirement(EARTH),
				new RuneRequirement(WATER),
				new RuneRequirement(LAW)),
			new InventoryRequirement(DRAYNOR_MANOR_TELEPORT))),
	ARCEUUS_FENKENSTRAINS_CASTLE("Arceuus: Fenkenstrain's Castle Teleport",
		new QuestRequirement(PRIEST_IN_PERIL),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 48),
				new RuneRequirement(LAW),
				new RuneRequirement(EARTH),
				new RuneRequirement(SOUL)),
			new InventoryRequirement(FENKENSTRAINS_CASTLE_TELEPORT))),
	ARCEUUS_HARMONY_ISLAND("Arceuus: Harmony Island Teleport",
		new QuestRequirement(THE_GREAT_BRAIN_ROBBERY),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 65),
				new RuneRequirement(LAW),
				new RuneRequirement(NATURE),
				new RuneRequirement(SOUL)),
			new InventoryRequirement(HARMONY_ISLAND_TELEPORT))),
	ARCEUUS_HOME("Arceuus: Home Teleport",
		new SpellbookRequirement(ARCEUUS),
		new HomeTeleportRequirement()),
	// TODO: Arceuus Library
	ARCEUUS_SALVE_GRAVEYARD("Arceuus: Salve Graveyard Teleport",
		new QuestRequirement(PRIEST_IN_PERIL),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 40),
				new RuneRequirement(LAW),
				new RuneRequirement(SOUL, 2)),
			new InventoryRequirement(SALVE_GRAVEYARD_TELEPORT))),
	ARCEUUS_WEST_ARDOUGNE("Arceuus: West Ardougne Teleport",
		new QuestRequirement(BIOHAZARD),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 68),
				new RuneRequirement(LAW, 2),
				new RuneRequirement(SOUL, 2)),
			new InventoryRequirement(WEST_ARDOUGNE_TELEPORT))),
	ARDOUGNE_CLOAK_MONASTERY("Ardougne Cloak: Monastery",
		new OrRequirement(
			new InventoryRequirement(ARDOUGNE_CLOAK_1),
			new InventoryRequirement(ARDOUGNE_CLOAK_2),
			new InventoryRequirement(ARDOUGNE_CLOAK_3),
			new InventoryRequirement(ARDOUGNE_CLOAK_4))),
	ARDOUGNE_CLOAK_2_FARM("Ardougne Cloak 2: Farm",
		new OrRequirement(
			new InventoryRequirement(ARDOUGNE_CLOAK_2),
			new InventoryRequirement(ARDOUGNE_CLOAK_3),
			new InventoryRequirement(ARDOUGNE_CLOAK_4))),
	BOAT_BURGH_DE_ROTT_TO_MEIYERDITCH("Boat: Burgh de Rott to Meiyerditch",
		new QuestRequirement(DARKNESS_OF_HALLOWVALE, true)),
	BOAT_CAPTAIN_BARNABY_TO_BRIMHAVEN("Boat: Captain Barnaby to Brimhaven",
		new OrRequirement(
			new InventoryRequirement(COINS_995, 30),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 15),
				new OrRequirement(
					new EquipmentRequirement(KARAMJA_GLOVES_1),
					new EquipmentRequirement(KARAMJA_GLOVES_2),
					new EquipmentRequirement(KARAMJA_GLOVES_3),
					new EquipmentRequirement(KARAMJA_GLOVES_4))),
			new EquipmentRequirement(RING_OF_CHAROSA))),
	BOAT_MORTTON_TO_THE_HOLLOWS("Boat: Mort'ton to the Hollows",
		new QuestRequirement(IN_AID_OF_THE_MYREQUE, true),
		new InventoryRequirement(COINS_995, 10)),
	BOAT_MUSHROOM_FOREST_TO_LITHKREN("Boat: Mushroom Forest to Lithkren",
		new QuestRequirement(DRAGON_SLAYER_II, true)),
	BOAT_PIRATES_COVE_TO_LUNAR_ISLE("Boat: Pirates' Cove to Lunar Isle",
		new QuestRequirement(LUNAR_DIPLOMACY, true)),
	BOAT_PISCATORIS_TO_GNOME_STRONGHOLD("Boat: Piscatoris to Gnome Stronghold",
		new OrRequirement(
			new InventoryRequirement(COINS_995, 50),
			new QuestRequirement(SWAN_SONG),
			new EquipmentRequirement(RING_OF_CHAROSA))),
	// TODO: Check free unlock (varbit: 10150)s
	BOAT_PORT_PHASMATYS_TO_SLEPE("Boat: Port Phasmatys to Slepe",
		new QuestRequirement(PRIEST_IN_PERIL),
		new InventoryRequirement(COINS_995, 10000)),
	BOAT_RELLEKKA_TO_ISLAND_OF_STONE("Boat: Rellekka to Island of Stone",
		new QuestRequirement(THE_FREMENNIK_EXILES, true)),
	BOAT_RELLEKKA_TO_MISCELLANIA("Boat: Rellekka to Miscellania",
		new QuestRequirement(THE_FREMENNIK_TRIALS)),
	BOAT_RELLEKKA_TO_NEITIZNOT("Boat: Rellekka to Neitiznot",
		new QuestRequirement(THE_FREMENNIK_ISLES, true)),
	BOAT_RELLEKKA_TO_WATERBIRTH_ISLAND("Boat: Rellekka to Waterbirth Island",
		new QuestRequirement(THE_FREMENNIK_TRIALS, true)),
	BOAT_NORTH_EAST_OF_RELLEKKA_TO_WEISS("Boat: Rellekka to Weiss",
		new QuestRequirement(MAKING_FRIENDS_WITH_MY_ARM, true)),
	BOAT_RIMMINGTON_TO_CORSAIR_COVE("Boat: Rimmington to Corsair Cove",
		new QuestRequirement(THE_CORSAIR_CURSE)),
	BURNING_AMULET_BANDIT_CAMP("Burning Amulet: Bandit Camp",
		CAN_TELEPORT_WITH_BURNING_AMULET.getRequirement()),
	BURNING_AMULET_CHAOS_TEMPLE("Burning Amulet: Chaos Temple",
		CAN_TELEPORT_WITH_BURNING_AMULET.getRequirement()),
	BURNING_AMULET_LAVA_MAZE("Burning Amulet: Lava Maze",
		CAN_TELEPORT_WITH_BURNING_AMULET.getRequirement()),
	// TODO: Check charges
	CAMULET_ENTRANCE("Camulet: Entrance",
		new InventoryRequirement(CAMULET),
		new DiaryRequirement(DESERT, HARD)),
	CART_TO_SHILO_VILLAGE("Cart to Shilo Village",
		new QuestRequirement(SHILO_VILLAGE),
		new InventoryRequirement(COINS_995, 200)),
	CHARTER_SHIP_MOS_LEHARMLESS("Charter Ship: Mos Le'Harmless",
		new QuestRequirement(CABIN_FEVER),
		new OrRequirement(
			new InventoryRequirement(COINS_995, 550),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 275),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_MUSA_POINT("Charter Ship: Musa Point",
		new OrRequirement(
			new InventoryRequirement(COINS_995, 200),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 100),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 50),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_PORT_PHASMATYS("Charter Ship: Port Phasmatys",
		new QuestRequirement(PRIEST_IN_PERIL),
		new OrRequirement(
			new InventoryRequirement(COINS_995, 1100),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 550),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 275),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_PORT_SARIM("Charter Ship: Port Sarim",
		new OrRequirement(
			new InventoryRequirement(COINS_995, 400),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 200),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 100),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_PORT_TYRAS("Charter Ship: Port Tyras",
		new QuestRequirement(REGICIDE),
		new OrRequirement(
			new InventoryRequirement(COINS_995, 3200),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 1600),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 800),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_PRIFDDINAS("Charter Ship: Prifddinas",
		new QuestRequirement(SONG_OF_THE_ELVES),
		new OrRequirement(
			new InventoryRequirement(COINS_995, 1420),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 710),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 355),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	CHARTER_SHIP_SHIP_YARD("Charter Ship: Ship Yard",
		new QuestRequirement(THE_GRAND_TREE),
		new OrRequirement(
			new InventoryRequirement(COINS_995, 200),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 100),
				new OrRequirement(
					new QuestRequirement(CABIN_FEVER),
					new EquipmentRequirement(RING_OF_CHAROSA))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 50),
				new QuestRequirement(CABIN_FEVER),
				new EquipmentRequirement(RING_OF_CHAROSA)))),
	// TODO: Check Charges
	CHRONICLE("Chronicle",
		new InventoryRequirement(ItemID.CHRONICLE)),
	COMBAT_BRACELET_CHAMPIONS_GUILD("Combat Bracelet: Champions' Guild",
		CAN_TELEPORT_WITH_COMBAT_BRACELET.getRequirement()),
	COMBAT_BRACELET_MONASTERY("Combat Bracelet: Monastery",
		CAN_TELEPORT_WITH_COMBAT_BRACELET.getRequirement()),
	COMBAT_BRACELET_RANGING_GUILD("Combat Bracelet: Ranging Guild",
		CAN_TELEPORT_WITH_COMBAT_BRACELET.getRequirement()),
	COMBAT_BRACELET_WARRIORS_GUILD("Combat Bracelet: Warriors' Guild",
		CAN_TELEPORT_WITH_COMBAT_BRACELET.getRequirement()),
	DESERT_AMULET_2_NARDAH("Desert Amulet 2: Nardah",
		new OrRequirement(
			new InventoryRequirement(DESERT_AMULET_4))),
	DESERT_AMULET_4_KALPHITE_CAVE("Desert Amulet 4: Kalphite Cave",
			new InventoryRequirement(DESERT_AMULET_4)),
	DIARY_CAPE_JARR("Diary Cape: Jarr",
		new OrRequirement(
			new InventoryRequirement(ACHIEVEMENT_DIARY_CAPE),
			new InventoryRequirement(ACHIEVEMENT_DIARY_CAPE_T))),
	DIARY_CAPE_PIRATE_JACKIE_THE_FRUIT("Diary Cape: Pirate Jackie the Fruit",
		new OrRequirement(
			new InventoryRequirement(ACHIEVEMENT_DIARY_CAPE),
			new InventoryRequirement(ACHIEVEMENT_DIARY_CAPE_T))),
	DIGSITE_PENDANT_DIGSITE("Digsite Pendant: Digsite",
		CAN_TELEPORT_WITH_DIGSITE_PENDANT.getRequirement()),
	DIGSITE_PENDANT_LITHKREN("Digsite Pendant: Lithkren",
		CAN_TELEPORT_WITH_DIGSITE_PENDANT.getRequirement()),
	DORGESH_KAAN_SPHERE("Dorgesh-Kaan Sphere",
		new QuestRequirement(DEATH_TO_THE_DORGESHUUN),
		new InventoryRequirement(DORGESHKAAN_SPHERE)),
	DRAKANS_MEDALLION_DARKMEYER("Drakan's Medallion: Darkmeyer",
		new InventoryRequirement(DRAKANS_MEDALLION),
		new QuestRequirement(SINS_OF_THE_FATHER)),
	DRAKANS_MEDALLION_VER_SINHAZA("Drakan's Medallion: Ver Sinhaza",
		new InventoryRequirement(DRAKANS_MEDALLION)),
	ECTOPHIAL("Ectophial",
		new InventoryRequirement(ItemID.ECTOPHIAL)),
	ENCHANTED_LYRE_NEITIZNOT("Enchanted Lyre: Neitiznot",
		CAN_TELEPORT_WITH_ENCHANTED_LYRE.getRequirement(),
		new DiaryRequirement(FREMENNIK, ELITE)),
	ENCHANTED_LYRE_RELLEKKA("Enchanted Lyre: Rellekka",
		CAN_TELEPORT_WITH_ENCHANTED_LYRE.getRequirement()),
	ENCHANTED_LYRE_WATERBIRTH("Enchanted Lyre: Waterbirth",
		CAN_TELEPORT_WITH_ENCHANTED_LYRE.getRequirement(),
		new DiaryRequirement(FREMENNIK, HARD)),
	EXPLORERS_RING_2("Explorer's Ring 2",
		new OrRequirement(
			new AndRequirement(
				new InventoryRequirement(ItemID.EXPLORERS_RING_2),
				new VarbitsRequirement("Teleport available", EXPLORER_RING_TELEPORTS, LESS_THAN, 3)),
			new AndRequirement(
				new InventoryRequirement(EXPLORERS_RING_3),
				new VarbitsRequirement("Teleport available", EXPLORER_RING_TELEPORTS, LESS_THAN, 3)),
			new InventoryRequirement(EXPLORERS_RING_4))),
	FAIRY_RING_AIR("Fairy Ring: AIR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_AIQ("Fairy Ring: AIQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_AJQ("Fairy Ring: AJQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(DEATH_TO_THE_DORGESHUUN)),
	FAIRY_RING_AJR("Fairy Ring: AJR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_AJS("Fairy Ring: AJS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_AKQ("Fairy Ring: AKQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_AKS("Fairy Ring: AKS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_ALQ("Fairy Ring: ALQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(PRIEST_IN_PERIL)),
	FAIRY_RING_ALS("Fairy Ring: ALS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_BIP("Fairy Ring: BIP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(PRIEST_IN_PERIL),
		new SkillRequirement(AGILITY, 50)),
	FAIRY_RING_BIQ("Fairy Ring: BIQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_BJR("Fairy Ring: BJR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(HOLY_GRAIL)),
	FAIRY_RING_BJS("Fairy Ring: BJS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new SkillRequirement(AGILITY, 76),
		new QuestRequirement(REGICIDE)),
	FAIRY_RING_BKP("Fairy Ring: BKP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_BKR("Fairy Ring: BKR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(PRIEST_IN_PERIL)),
	FAIRY_RING_BLR("Fairy Ring: BLR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CIP("Fairy Ring: CIP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(THE_FREMENNIK_TRIALS)),
	FAIRY_RING_CIQ("Fairy Ring: CIQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	// TODO: Check Unlock State
	FAIRY_RING_CIR("Fairy Ring: CIR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CIS("Fairy Ring: CIS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CJR("Fairy Ring: CJR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CKR("Fairy Ring: CKR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CKS("Fairy Ring: CKS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(PRIEST_IN_PERIL)),
	FAIRY_RING_CLP("Fairy Ring: CLP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_CLR("Fairy Ring: CLR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement(),
		new QuestRequirement(MONKEY_MADNESS_I)),
	FAIRY_RING_CLS("Fairy Ring: CLS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DIS("Fairy Ring: DIS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DJP("Fairy Ring: DJP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DJR("Fairy Ring: DJR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DKP("Fairy Ring: DKP",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DKR("Fairy Ring: DKR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DKS("Fairy Ring: DKS",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DLQ("Fairy Ring: DLQ",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_DLR("Fairy Ring: DLR",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	//TODO: Certificate before quest completion
	FAIRY_RING_HIDEOUT("Fairy Ring: Hideout",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FAIRY_RING_ZANARIS("Fairy Ring: Zanaris",
		CAN_TELEPORT_WITH_FAIRY_RING.getRequirement()),
	FARMING_CAPE("Farming Cape",
		new OrRequirement(
			new InventoryRequirement(ItemID.FARMING_CAPE),
			new InventoryRequirement(FARMING_CAPET),
			new InventoryRequirement(MAX_CAPE),
			new InventoryRequirement(MAX_CAPE_13342))),
	FISHING_CAPE_OTTOS_GROTTO("Fishing Cape: Otto's Grotto",
		new OrRequirement(
			new InventoryRequirement(FISHING_CAPE),
			new InventoryRequirement(FISHING_CAPET),
			new InventoryRequirement(MAX_CAPE),
			new InventoryRequirement(MAX_CAPE_13342))),
	FREMENNIK_SEA_BOOTS("Fremennik Sea Boots",
		new OrRequirement(
			new InventoryRequirement(FREMENNIK_SEA_BOOTS_4))),
	GAMES_NECKLACE_BARBARIAN_OUTPOST("Games Necklace: Barbarian Outpost",
		CAN_TELEPORT_WITH_GAMES_NECKLACE.getRequirement()),
	GAMES_NECKLACE_BURTHORPE("Games Necklace: Burthorpe",
		CAN_TELEPORT_WITH_GAMES_NECKLACE.getRequirement()),
	GAMES_NECKLACE_CORPOREAL_BEAST("Games Necklace: Corporeal Beast",
		CAN_TELEPORT_WITH_GAMES_NECKLACE.getRequirement()),
	GNOME_GLIDER_AL_KHARID("Gnome Glider: Al Kharid",
		new QuestRequirement(THE_GRAND_TREE)),
	GNOME_GLIDER_APE_ATOLL("Gnome Glider: Ape Atoll",
		new QuestRequirement(MONKEY_MADNESS_II)),
	GNOME_GLIDER_FELDIP_HILLS("Gnome Glider: Feldip Hills",
		new QuestRequirement(ONE_SMALL_FAVOUR),
		new QuestRequirement(THE_GRAND_TREE)),
	GNOME_GLIDER_KARAMJA("Gnome Glider: Karamja",
		new QuestRequirement(THE_GRAND_TREE)),
	// TODO: Check for route unlock + logs
	HOT_AIR_BALLOON_TAVERLEY("Hot Air Balloon: Taverley",
		new QuestRequirement(ENLIGHTENED_JOURNEY)),
	HOT_AIR_BALLOON_VARROCK("Hot Air Balloon: Varrock",
		new QuestRequirement(ENLIGHTENED_JOURNEY)),
	// TODO: Check charges
	HUNTER_CAPE_BLACK_CHINCHOMPAS("Hunter Cape: Black Chinchompas",
		new OrRequirement(
			new InventoryRequirement(HUNTER_CAPE),
			new InventoryRequirement(HUNTER_CAPET),
			new InventoryRequirement(MAX_CAPE),
			new InventoryRequirement(MAX_CAPE_13342))),
	HUNTER_CAPE_CARNIVOROUS_CHINCHOMPAS("Hunter Cape: Carnivorous Chinchompas",
		new OrRequirement(
			new InventoryRequirement(HUNTER_CAPE),
			new InventoryRequirement(HUNTER_CAPET),
			new InventoryRequirement(MAX_CAPE),
			new InventoryRequirement(MAX_CAPE_13342))),
	ICY_BASALT("Icy Basalt",
		new InventoryRequirement(ItemID.ICY_BASALT)),
	// TODO: Check charges
	KANDARIN_HEADGEAR_3("Kandarin Headgear 3",
		new OrRequirement(
			new InventoryRequirement(ItemID.KANDARIN_HEADGEAR_3),
			new InventoryRequirement(KANDARIN_HEADGEAR_4))),
	KARAMJA_GLOVES_3_GEM_MINE("Karamja Gloves 3: Gem Mine",
		new OrRequirement(
			new InventoryRequirement(KARAMJA_GLOVES_3),
			new InventoryRequirement(KARAMJA_GLOVES_4))),
	KAZGAR_TO_DORGESHUUN_MINES("Kazgar: Lumbridge Cellar To Dorgeshuun Mines",
		new QuestRequirement(THE_LOST_TRIBE)),
	// TODO: Check charges
	KHAREDSTS_MEMOIRS_A_DARK_DISPOSITION("Kharedst's Memoirs: A Dark Disposition",
		new QuestRequirement(THE_ASCENT_OF_ARCEUUS),
		new InventoryRequirement(KHAREDSTS_MEMOIRS)),
	KHAREDSTS_MEMOIRS_HISTORY_AND_HEARSAY("Kharedst's Memoirs: History and Hearsay",
		new QuestRequirement(TALE_OF_THE_RIGHTEOUS),
		new InventoryRequirement(KHAREDSTS_MEMOIRS)),
	KHAREDSTS_MEMOIRS_JEWELRY_OF_JUBILATION("Kharedst's Memoirs: Jewelry of Jubilation",
		new QuestRequirement(THE_FORSAKEN_TOWER),
		new InventoryRequirement(KHAREDSTS_MEMOIRS)),
	KHAREDSTS_MEMOIRS_LUNCH_BY_THE_LANCALLIUMS("Kharedst's Memoirs: Lunch by the Lancalliums",
		new QuestRequirement(THE_DEPTHS_OF_DESPAIR),
		new InventoryRequirement(KHAREDSTS_MEMOIRS)),
	KHAREDSTS_MEMOIRS_THE_FISHERS_FLUTE("Kharedst's Memoirs: The Fisher's Flute",
		new QuestRequirement(THE_QUEEN_OF_THIEVES),
		new InventoryRequirement(KHAREDSTS_MEMOIRS)),
	LUNAR_CATHERBY("Lunar: Catherby Teleport",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 87),
		new RuneRequirement(LAW, 3),
		new RuneRequirement(ASTRAL, 3),
		new RuneRequirement(WATER, 10)),
	LUNAR_FISHING_GUILD("Lunar: Fishing Guild",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 85),
		new RuneRequirement(LAW, 3),
		new RuneRequirement(ASTRAL, 3),
		new RuneRequirement(WATER, 10)),
	LUNAR_ICE_PLATEAU("Lunar: Ice Plateau",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 89),
		new RuneRequirement(LAW, 3),
		new RuneRequirement(ASTRAL, 3),
		new RuneRequirement(WATER, 8)),
	LUNAR_KHAZARD("Lunar: Khazard Teleport",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 78),
		new RuneRequirement(LAW, 2),
		new RuneRequirement(ASTRAL, 2),
		new RuneRequirement(WATER, 4)),
	LUNAR_HOME_TELEPORT("Lunar: Home Teleport",
		new SpellbookRequirement(LUNAR),
		new HomeTeleportRequirement()),
	LUNAR_MOONCLAN("Lunar: Moonclan Teleport",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 69),
		new RuneRequirement(LAW),
		new RuneRequirement(ASTRAL, 2),
		new RuneRequirement(EARTH, 2)),
	LUNAR_WATERBIRTH("Lunar: Waterbirth Teleport",
		new SpellbookRequirement(LUNAR),
		new SkillRequirement(MAGIC, 71),
		new RuneRequirement(LAW),
		new RuneRequirement(ASTRAL, 2),
		new RuneRequirement(WATER)),
	MAGIC_CARPET_BEDABIN_CAMP("Magic Carpet: Bedabin Camp",
		CAN_PAY_FOR_MAGIC_CARPET.getRequirement(),
		new QuestRequirement(THE_TOURIST_TRAP)),
	MAGIC_CARPET_POLLNIVNEACH("Magic Carpet: Pollnivneach",
		CAN_PAY_FOR_MAGIC_CARPET.getRequirement()),
	// TODO: Check cost
	MINECART_KELDAGRIM_TO_WHITE_WOLF_MOUNTAIN("Minecart: Keldagrim to White Wolf Mountain",
		new QuestRequirement(THE_GIANT_DWARF),
		new QuestRequirement(FISHING_CONTEST)),
	MINECART_TO_KELDAGRIM("Minecart: To Keldagrim",
		new QuestRequirement(THE_GIANT_DWARF, true)),
	// TODO: Check for tutorial completed
	MINIGAME_BARBARIAN_ASSAULT("Minigame Teleport: Barbarian Assault",
		new MinigameTeleportRequirement()),
	MINIGAME_BLAST_FURNACE("Minigame Teleport: Blast Furnace",
		new MinigameTeleportRequirement(),
		new QuestRequirement(THE_GIANT_DWARF, true)),
	MINIGAME_BURTHORPE("Minigame Teleport: Burthorpe",
		new MinigameTeleportRequirement()),
	MINIGAME_CASTLE_WARS("Minigame Teleport: Castle Wars",
		new MinigameTeleportRequirement()),
	MINIGAME_CLAN_WARS("Minigame Teleport: Clan Wars",
		new MinigameTeleportRequirement()),
	MINIGAME_FISHING_TRAWLER("Minigame Teleport: Fishing Trawler",
		new MinigameTeleportRequirement(),
		new SkillRequirement(FISHING, 15)),
	MINIGAME_NIGHTMARE_ZONE("Minigame Teleport: Nightmare Zone",
		new MinigameTeleportRequirement(),
		new NMZRequirement()),
	MINIGAME_RAT_PITS_KELDAGRIM("Minigame Teleport: Rat Pits (Keldagrim)",
		new MinigameTeleportRequirement(),
		new QuestRequirement(RATCATCHERS)),
	MINIGAME_RAT_PITS_PORT_SARIM("Minigame Teleport: Rat Pits (Port Sarim)",
		new MinigameTeleportRequirement(),
		new QuestRequirement(RATCATCHERS)),
	MINIGAME_SHADES_OF_MORTTON("Minigame Teleport: Shades of Mort'ton",
		new MinigameTeleportRequirement(),
		new QuestRequirement(SHADES_OF_MORTTON)),
	MINIGAME_SOUL_WARS("Minigame Teleport: Soul Wars",
		new MinigameTeleportRequirement()),
	// TODO: Check entered
	MINIGAME_TITHE_FARM("Minigame Teleport: Tithe Farm",
		new MinigameTeleportRequirement(),
		new FavourRequirement(Favour.HOSIDIUS, 100)),
	MINIGAME_TROUBLE_BREWING("Minigame Teleport: Trouble Brewing",
		new MinigameTeleportRequirement(),
		new QuestRequirement(CABIN_FEVER),
		new SkillRequirement(COOKING, 40)),
	MORYTANIA_LEGS_3_BURGH_DE_ROTT("Morytania Legs 3: Burgh de Rott",
		new OrRequirement(
			new InventoryRequirement(MORYTANIA_LEGS_3),
			new InventoryRequirement(MORYTANIA_LEGS_4))),
	MYTHICAL_CAPE("Mythical Cape",
		new InventoryRequirement(MYTHICAL_CAPE_22114)),
	NECKLACE_OF_PASSAGE_EAGLES_EYRIE("Necklace of Passage: Eagle's Eyrie",
		CAN_TELEPORT_WITH_NECKLACE_OF_PASSAGE.getRequirement()),
	NECKLACE_OF_PASSAGE_OUTPOST("Necklace of Passage: Outpost",
		CAN_TELEPORT_WITH_NECKLACE_OF_PASSAGE.getRequirement()),
	NECKLACE_OF_PASSAGE_WIZARDS_TOWER("Necklace of Passage: Wizards' Tower",
		CAN_TELEPORT_WITH_NECKLACE_OF_PASSAGE.getRequirement()),
	PHARAOHS_SCEPTER_JALDRAOCHT("Pharaoh's Scepter: Jaldraocht",
		CAN_TELEPORT_WITH_PHARAOHS_SCEPTER.getRequirement()),
	PHARAOHS_SCEPTER_JALEUSTROPHOS("Pharaoh's Scepter: Jaleustrophos",
		CAN_TELEPORT_WITH_PHARAOHS_SCEPTER.getRequirement()),
	QUEST_CAPE("Quest Cape",
		new AllQuestsRequirement(),
		new OrRequirement(
			new InventoryRequirement(QUEST_POINT_CAPE),
			new InventoryRequirement(QUEST_POINT_CAPE_T))),
	// TODO: Check Respawn Location
	RESPAWN_FALADOR("Respawn Teleport: Falador",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(ARCEUUS),
				new SkillRequirement(MAGIC, 34),
				new RuneRequirement(LAW),
				new RuneRequirement(SOUL)),
			new InventoryRequirement(RING_OF_RETURNING1),
			new InventoryRequirement(RING_OF_RETURNING2),
			new InventoryRequirement(RING_OF_RETURNING3),
			new InventoryRequirement(RING_OF_RETURNING4),
			new InventoryRequirement(RING_OF_RETURNING5))),
	RING_OF_DUELING_CASTLE_WARS("Ring of Dueling: Castle Wars",
		CAN_TELEPORT_WITH_RING_OF_DUELING.getRequirement()),
	RING_OF_DUELING_DUEL_ARENA("Ring of Dueling: Duel Arena",
		CAN_TELEPORT_WITH_RING_OF_DUELING.getRequirement()),
	RING_OF_DUELING_FEROX_ENCLAVE("Ring of Dueling: Ferox Enclave",
		CAN_TELEPORT_WITH_RING_OF_DUELING.getRequirement()),
	RING_OF_WEALTH_FALADOR("Ring of Wealth: Falador",
		CAN_TELEPORT_WITH_RING_OF_WEALTH.getRequirement()),
	RING_OF_WEALTH_GRAND_EXCHANGE("Ring of Wealth: Grand Exchange",
		CAN_TELEPORT_WITH_RING_OF_WEALTH.getRequirement()),
	RING_OF_WEALTH_MISCELLANIA("Ring of Wealth: Miscellania",
		CAN_TELEPORT_WITH_RING_OF_WEALTH.getRequirement(),
		new QuestRequirement(THRONE_OF_MISCELLANIA)),
	ROYAL_SEED_POD("Royal Seed Pod",
		new OrRequirement(
			new InventoryRequirement(ItemID.ROYAL_SEED_POD),
			new InventoryRequirement(GRAND_SEED_POD))),
	// TODO: Check Master Scroll Book
	SCROLL_DIGSITE("Scroll: Digsite",
		new InventoryRequirement(DIGSITE_TELEPORT)),
	SCROLL_FELDIP_HILLS("Scroll: Feldip Hills",
		new InventoryRequirement(FELDIP_HILLS_TELEPORT)),
	SCROLL_IORWERTH_CAMP("Scroll: Iorwerth Camp",
		new InventoryRequirement(IORWERTH_CAMP_TELEPORT)),
	SCROLL_LUMBERYARD("Scroll: Lumberyard",
		new InventoryRequirement(LUMBERYARD_TELEPORT)),
	SCROLL_LUNAR_ISLE("Scroll: Lunar Isle",
		new InventoryRequirement(LUNAR_ISLE_TELEPORT),
		new QuestRequirement(LUNAR_DIPLOMACY)),
	SCROLL_MORTTON("Scroll: Mort'ton",
		new InventoryRequirement(MORTTON_TELEPORT),
		new QuestRequirement(PRIEST_IN_PERIL)),
	SCROLL_MOS_LEHARMLESS("Scroll: Mos Le'Harmless",
		new InventoryRequirement(MOS_LEHARMLESS_TELEPORT),
		new QuestRequirement(CABIN_FEVER)),
	SCROLL_NARDAH("Scroll: Nardah",
		new InventoryRequirement(NARDAH_TELEPORT)),
	SCROLL_PISCATORIS("Scroll: Piscatoris",
		new InventoryRequirement(PISCATORIS_TELEPORT)),
	SCROLL_REVENANT_CAVE("Scroll: Revenant Cave Teleport",
		new InventoryRequirement(REVENANT_CAVE_TELEPORT)),
	SCROLL_TAI_BWO_WANNAI("Scroll: Tai Bwo Wannai",
		new InventoryRequirement(TAI_BWO_WANNAI_TELEPORT)),
	SCROLL_WATSON("Scroll: Watson",
		new InventoryRequirement(WATSON_TELEPORT)),
	SCROLL_ZUL_ANDRA("Scroll: Zul-Andra",
		new InventoryRequirement(ZULANDRA_TELEPORT),
		new QuestRequirement(REGICIDE)),
	SKILLS_NECKLACE_COOKS_GUILD("Skills Necklace: Cooks' Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	SKILLS_NECKLACE_CRAFTING_GUILD("Skills Necklace: Crafting Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	SKILLS_NECKLACE_FARMING_GUILD("Skills Necklace: Farming Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	SKILLS_NECKLACE_FISHING_GUILD("Skills Necklace: Fishing Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	SKILLS_NECKLACE_MINING_GUILD("Skills Necklace: Mining Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	SKILLS_NECKLACE_WOODCUTTING_GUILD("Skills Necklace: Woodcutting Guild",
		CAN_TELEPORT_WITH_SKILLS_NECKLACE.getRequirement()),
	// TODO: Check charges.
	SKULL_SCEPTRE("Skull sceptre",
		new OrRequirement(
			new InventoryRequirement(ItemID.SKULL_SCEPTRE),
			new InventoryRequirement(SKULL_SCEPTRE_I))),
	SLAYER_RING_FREMENNIK_SLAYER_DUNGEON("Slayer Ring: Fremennik Slayer Dungeon",
		CAN_TELEPORT_WITH_SLAYER_RING.getRequirement()),
	SLAYER_RING_SLAYER_TOWER("Slayer Ring: Slayer Tower",
		CAN_TELEPORT_WITH_SLAYER_RING.getRequirement(),
		new QuestRequirement(PRIEST_IN_PERIL)),
	SLAYER_RING_STRONGHOLD_SLAYER_CAVE("Slayer Ring: Stronghold Slayer Cave",
		CAN_TELEPORT_WITH_SLAYER_RING.getRequirement()),
	// TODO: Check spirit tree is planted
	SPIRIT_TREE_BRIMHAVEN("Spirit Tree: Brimhaven",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	SPIRIT_TREE_ETCETERIA("Spirit Tree: Etceteria",
		new QuestRequirement(TREE_GNOME_VILLAGE),
		new QuestRequirement(THE_FREMENNIK_TRIALS)),
	SPIRIT_TREE_FELDIP_HILLS("Spirit Tree: Feldip Hills",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	SPIRIT_TREE_GNOME_STRONGHOLD("Spirit Tree: Gnome Stronghold",
		new QuestRequirement(TREE_GNOME_VILLAGE),
		new QuestRequirement(THE_GRAND_TREE)),
	SPIRIT_TREE_HOSIDIUS("Spirit Tree: Hosidius",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	SPIRIT_TREE_KHAZARD_BATTLEFIELD("Spirit Tree: Khazard Battlefield",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	SPIRIT_TREE_PORT_SARIM("Spirit Tree: Port Sarim",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	SPIRIT_TREE_TREE_GNOME_VILLAGE("Spirit Tree: Tree Gnome Village",
		new QuestRequirement(TREE_GNOME_VILLAGE)),
	// TODO: Check for RfD progress
	STANDARD_APE_ATOLL("Standard: Ape Atoll",
		new SpellbookRequirement(STANDARD),
		new SkillRequirement(MAGIC, 64),
		new RuneRequirement(WATER, 2),
		new RuneRequirement(FIRE, 2),
		new RuneRequirement(LAW, 2),
		new InventoryRequirement(BANANA)),
	STANDARD_ARDOUGNE("Standard: Ardougne Teleport",
		new QuestRequirement(PLAGUE_CITY),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 51),
				new RuneRequirement(WATER, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(ARDOUGNE_TELEPORT))),
	STANDARD_CAMELOT("Standard: Camelot Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 45),
				new RuneRequirement(AIR, 5),
				new RuneRequirement(LAW)),
			new InventoryRequirement(CAMELOT_TELEPORT))),
	STANDARD_FALADOR("Standard: Falador Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 37),
				new RuneRequirement(AIR, 3),
				new RuneRequirement(WATER),
				new RuneRequirement(LAW)),
			new InventoryRequirement(FALADOR_TELEPORT))),
	STANDARD_GRAND_EXCHANGE("Standard: Grand Exchange Teleport",
		new DiaryRequirement(VARROCK, MEDIUM),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 25),
				new RuneRequirement(AIR, 3),
				new RuneRequirement(FIRE),
				new RuneRequirement(LAW)),
			new InventoryRequirement(VARROCK_TELEPORT))),
	// TODO: Check spell unlocked
	STANDARD_KOUREND("Standard: Kourend Teleport",
		new SpellbookRequirement(STANDARD),
		new SkillRequirement(MAGIC, 69),
		new RuneRequirement(WATER, 4),
		new RuneRequirement(FIRE, 5),
		new RuneRequirement(LAW, 2),
		new RuneRequirement(SOUL, 2)),
	STANDARD_LUMBRIDGE("Standard: Lumbridge Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new HomeTeleportRequirement()),
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 31),
				new RuneRequirement(AIR, 3),
				new RuneRequirement(EARTH),
				new RuneRequirement(LAW)),
			new InventoryRequirement(LUMBRIDGE_TELEPORT))),
	STANDARD_SEERS("Standard: Seers' Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 37),
				new RuneRequirement(AIR, 3),
				new RuneRequirement(WATER),
				new RuneRequirement(LAW)),
			new InventoryRequirement(FALADOR_TELEPORT)),
		new DiaryRequirement(KANDARIN, HARD)),
	STANDARD_TROLLHEIM("Standard: Trollheim Teleport",
		new QuestRequirement(EADGARS_RUSE),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 61),
				new RuneRequirement(FIRE, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(TROLLHEIM_TELEPORT),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)
			))),
	STANDARD_VARROCK("Standard: Varrock Teleport",
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 25),
				new RuneRequirement(AIR, 3),
				new RuneRequirement(FIRE),
				new RuneRequirement(LAW)),
			new InventoryRequirement(VARROCK_TELEPORT))),
	STANDARD_WATCHTOWER("Standard: Watchtower Teleport",
		new QuestRequirement(WATCHTOWER),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 58),
				new RuneRequirement(EARTH, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(WATCHTOWER_TELEPORT))),
	STANDARD_YANILLE("Standard: Yanille Teleport",
		new QuestRequirement(WATCHTOWER),
		new DiaryRequirement(ARDOUGNE, HARD),
		new OrRequirement(
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 58),
				new RuneRequirement(EARTH, 2),
				new RuneRequirement(LAW, 2)),
			new InventoryRequirement(WATCHTOWER_TELEPORT))),
	STONY_BASALT("Stony Basalt",
		new InventoryRequirement(ItemID.STONY_BASALT)),
	TELEPORT_CRYSTAL_LLETYA("Teleport Crystal: Lletya",
		CAN_TELEPORT_WITH_TELEPORT_CRYSTAL.getRequirement()),
	TELEPORT_CRYSTAL_PRIFDDINAS("Teleport Crystal: Prifddinas",
		CAN_TELEPORT_WITH_TELEPORT_CRYSTAL.getRequirement(),
		new QuestRequirement(SONG_OF_THE_ELVES)),
	TELEPORT_TO_HOUSE_BRIMHAVEN("Teleport to House: Brimhaven",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(BRIMHAVEN)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(BRIMHAVEN_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_HOSIDIUS("Teleport to House: Hosidius",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(HouseLocation.HOSIDIUS)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(HOSIDIUS_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_POLLNIVNEACH("Teleport to House: Pollnivneach",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(POLLNIVNEACH)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(POLLNIVNEACH_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_PRIFDDINAS("Teleport to House: Prifddinas",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(PRIFDDINAS)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(PRIFDDINAS_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_RELLEKKA("Teleport to House: Rellekka",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(RELLEKKA)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(RELLEKKA_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_RIMMINGTON("Teleport to House: Rimmington",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(RIMMINGTON)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(RIMMINGTON_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_TAVERLEY("Teleport to House: Taverley",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(TAVERLEY)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(TAVERLEY_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	TELEPORT_TO_HOUSE_YANILLE("Teleport to House: Yanille",
		new OrRequirement(
			new AndRequirement(
				CAN_CAST_TELEPORT_TO_HOUSE.getRequirement(),
				new HouseRequirement(YANILLE)),
			new AndRequirement(
				new InventoryRequirement(TELEPORT_TO_HOUSE),
				new InventoryRequirement(SCROLL_OF_REDIRECTION)),
			new InventoryRequirement(YANILLE_TELEPORT),
			new InventoryRequirement(CONSTRUCT_CAPE),
			new InventoryRequirement(CONSTRUCT_CAPET))),
	// TODO: Check uses
	WESTERN_BANNER_3("Western Banner 3",
		new OrRequirement(
			new InventoryRequirement(ItemID.WESTERN_BANNER_3),
			new InventoryRequirement(WESTERN_BANNER_4))),
	WILDERNESS_CRABS_TELEPORT("Wilderness Crabs Teleport",
		new InventoryRequirement(ItemID.WILDERNESS_CRABS_TELEPORT)),
	WILDERNESS_LEVER("Wilderness Lever"),
	WILDERNESS_OBELISK_13("Wilderness Obelisk: 13"),
	WILDERNESS_OBELISK_19("Wilderness Obelisk: 19"),
	WILDERNESS_OBELISK_27("Wilderness Obelisk: 27"),
	WILDERNESS_OBELISK_35("Wilderness Obelisk: 35"),
	WILDERNESS_OBELISK_44("Wilderness Obelisk: 44"),
	WILDERNESS_OBELISK_50("Wilderness Obelisk: 50"),
	// TODO: Check uses
	WILDERNESS_SWORD_3("Wilderness Sword 3",
		new OrRequirement(
			new InventoryRequirement(ItemID.WILDERNESS_SWORD_3),
			new InventoryRequirement(WILDERNESS_SWORD_4))),
	XERICS_TALISMAN_XERICS_GLADE("Xeric's Talisman: Xeric's Glade",
		new InventoryRequirement(XERICS_TALISMAN)),
	XERICS_TALISMAN_XERICS_HEART("Xeric's Talisman: Xeric's Heart",
		new InventoryRequirement(XERICS_TALISMAN),
		new QuestRequirement(ARCHITECTURAL_ALLIANCE)),
	XERICS_TALISMAN_XERICS_INFERNO("Xeric's Talisman: Xeric's Inferno",
		new InventoryRequirement(XERICS_TALISMAN)),
	XERICS_TALISMAN_XERICS_LOOKOUT("Xeric's Talisman: Xeric's Look-out",
		new InventoryRequirement(XERICS_TALISMAN));

	private final String text;
	private final List<Requirement> requirements;

	CommonTeleport(String text, Requirement... requirements)
	{
		this.text = text;
		this.requirements = Arrays.asList(requirements);
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		return new AndRequirement(requirements).fulfilledBy(plugin);
	}
}