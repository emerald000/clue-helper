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
package emerald000.cluehelper.clues.requirement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Quest;
import static net.runelite.api.Quest.THE_FEUD;
import static net.runelite.api.Skill.MAGIC;
import static net.runelite.api.Skill.MINING;
import static net.runelite.api.Skill.WOODCUTTING;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.ELITE;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.HARD;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.DESERT;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.LUMBRIDGE_DRAYNOR;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.AIR;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.EARTH;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.LAW;
import static emerald000.cluehelper.clues.requirement.SpellbookRequirement.Spellbook.STANDARD;

@Getter
@AllArgsConstructor
public enum CommonRequirement
{
	CAN_CAST_TELEPORT_TO_HOUSE(
		new OrRequirement("Can Teleport to PoH",
			new AndRequirement(
				new SpellbookRequirement(STANDARD),
				new SkillRequirement(MAGIC, 40),
				new RuneRequirement(AIR),
				new RuneRequirement(EARTH),
				new RuneRequirement(LAW)),
			new InventoryRequirement(TELEPORT_TO_HOUSE))),
	CAN_PAY_FOR_MAGIC_CARPET(
		new OrRequirement("Can pay for Magic Carpet",
			new InventoryRequirement(COINS_995, 200),
			new DiaryRequirement(DESERT, HARD),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 100),
				new OrRequirement(
					new EquipmentRequirement(RING_OF_CHAROSA),
					new QuestRequirement(THE_FEUD))),
			new AndRequirement(
				new InventoryRequirement(COINS_995, 75),
				new EquipmentRequirement(RING_OF_CHAROSA),
				new QuestRequirement(THE_FEUD)))),
	CAN_TELEPORT_WITH_AMULET_OF_GLORY(
		new OrRequirement("Charged Amulet of Glory",
			new InventoryRequirement(AMULET_OF_GLORY1),
			new InventoryRequirement(AMULET_OF_GLORY2),
			new InventoryRequirement(AMULET_OF_GLORY3),
			new InventoryRequirement(AMULET_OF_GLORY4),
			new InventoryRequirement(AMULET_OF_GLORY5),
			new InventoryRequirement(AMULET_OF_GLORY6),
			new InventoryRequirement(AMULET_OF_GLORY_T1),
			new InventoryRequirement(AMULET_OF_GLORY_T2),
			new InventoryRequirement(AMULET_OF_GLORY_T3),
			new InventoryRequirement(AMULET_OF_GLORY_T4),
			new InventoryRequirement(AMULET_OF_GLORY_T5),
			new InventoryRequirement(AMULET_OF_GLORY_T6),
			new InventoryRequirement(AMULET_OF_ETERNAL_GLORY))),
	CAN_TELEPORT_WITH_BURNING_AMULET(
		new OrRequirement("Burning Amulet",
			new InventoryRequirement(BURNING_AMULET1),
			new InventoryRequirement(BURNING_AMULET2),
			new InventoryRequirement(BURNING_AMULET3),
			new InventoryRequirement(BURNING_AMULET4),
			new InventoryRequirement(BURNING_AMULET5))),
	CAN_TELEPORT_WITH_COMBAT_BRACELET(
		new OrRequirement("Charged Combat Bracelet",
			new InventoryRequirement(COMBAT_BRACELET1),
			new InventoryRequirement(COMBAT_BRACELET2),
			new InventoryRequirement(COMBAT_BRACELET3),
			new InventoryRequirement(COMBAT_BRACELET4),
			new InventoryRequirement(COMBAT_BRACELET5),
			new InventoryRequirement(COMBAT_BRACELET6))),
	CAN_TELEPORT_WITH_DIGSITE_PENDANT(
		new AndRequirement("Can use Digsite Pendant",
			new QuestRequirement(Quest.THE_DIG_SITE),
			new OrRequirement(
				new InventoryRequirement(DIGSITE_PENDANT_1),
				new InventoryRequirement(DIGSITE_PENDANT_2),
				new InventoryRequirement(DIGSITE_PENDANT_3),
				new InventoryRequirement(DIGSITE_PENDANT_4),
				new InventoryRequirement(DIGSITE_PENDANT_5)))),
	CAN_TELEPORT_WITH_ENCHANTED_LYRE(
		new AndRequirement("Can use Enchanted Lyre",
			new QuestRequirement(Quest.THE_FREMENNIK_TRIALS),
			new OrRequirement(
				new InventoryRequirement(ENCHANTED_LYRE1),
				new InventoryRequirement(ENCHANTED_LYRE2),
				new InventoryRequirement(ENCHANTED_LYRE3),
				new InventoryRequirement(ENCHANTED_LYRE4),
				new InventoryRequirement(ENCHANTED_LYRE5),
				new InventoryRequirement(ENCHANTED_LYREI)))),
	// TODO: Find varbits
	CAN_TELEPORT_WITH_FAIRY_RING(
		new AndRequirement("Can use Fairy Rings",
			new QuestRequirement(Quest.FAIRYTALE_II__CURE_A_QUEEN, true),
			new OrRequirement(
				new InventoryRequirement(DRAMEN_STAFF),
				new InventoryRequirement(LUNAR_STAFF),
				new DiaryRequirement(LUMBRIDGE_DRAYNOR, ELITE)))),
	CAN_TELEPORT_WITH_GAMES_NECKLACE(
		new OrRequirement("Games Necklace",
			new InventoryRequirement(GAMES_NECKLACE1),
			new InventoryRequirement(GAMES_NECKLACE2),
			new InventoryRequirement(GAMES_NECKLACE3),
			new InventoryRequirement(GAMES_NECKLACE4),
			new InventoryRequirement(GAMES_NECKLACE5),
			new InventoryRequirement(GAMES_NECKLACE6),
			new InventoryRequirement(GAMES_NECKLACE7),
			new InventoryRequirement(GAMES_NECKLACE8))),
	CAN_TELEPORT_WITH_NECKLACE_OF_PASSAGE(
		new OrRequirement("Necklace of Passage",
			new InventoryRequirement(NECKLACE_OF_PASSAGE1),
			new InventoryRequirement(NECKLACE_OF_PASSAGE2),
			new InventoryRequirement(NECKLACE_OF_PASSAGE3),
			new InventoryRequirement(NECKLACE_OF_PASSAGE4),
			new InventoryRequirement(NECKLACE_OF_PASSAGE5))),
	CAN_TELEPORT_WITH_PHARAOHS_SCEPTER(
		new OrRequirement("Charged Pharaoh's Scepter",
			new InventoryRequirement(PHARAOHS_SCEPTRE_1),
			new InventoryRequirement(PHARAOHS_SCEPTRE_2),
			new InventoryRequirement(PHARAOHS_SCEPTRE_3),
			new InventoryRequirement(PHARAOHS_SCEPTRE_4),
			new InventoryRequirement(PHARAOHS_SCEPTRE_5),
			new InventoryRequirement(PHARAOHS_SCEPTRE_6),
			new InventoryRequirement(PHARAOHS_SCEPTRE_7),
			new InventoryRequirement(PHARAOHS_SCEPTRE_8))),
	CAN_TELEPORT_WITH_RING_OF_DUELING(
		new OrRequirement("Ring of Dueling",
			new InventoryRequirement(RING_OF_DUELING1),
			new InventoryRequirement(RING_OF_DUELING2),
			new InventoryRequirement(RING_OF_DUELING3),
			new InventoryRequirement(RING_OF_DUELING4),
			new InventoryRequirement(RING_OF_DUELING5),
			new InventoryRequirement(RING_OF_DUELING6),
			new InventoryRequirement(RING_OF_DUELING7),
			new InventoryRequirement(RING_OF_DUELING8))),
	CAN_TELEPORT_WITH_RING_OF_WEALTH(
		new OrRequirement("Charged Ring of Wealth",
			new InventoryRequirement(RING_OF_WEALTH_1),
			new InventoryRequirement(RING_OF_WEALTH_2),
			new InventoryRequirement(RING_OF_WEALTH_3),
			new InventoryRequirement(RING_OF_WEALTH_4),
			new InventoryRequirement(RING_OF_WEALTH_5),
			new InventoryRequirement(RING_OF_WEALTH_I1),
			new InventoryRequirement(RING_OF_WEALTH_I2),
			new InventoryRequirement(RING_OF_WEALTH_I3),
			new InventoryRequirement(RING_OF_WEALTH_I4),
			new InventoryRequirement(RING_OF_WEALTH_I5))),
	CAN_TELEPORT_WITH_SKILLS_NECKLACE(
		new OrRequirement("Charged Skills Necklace",
			new InventoryRequirement(SKILLS_NECKLACE1),
			new InventoryRequirement(SKILLS_NECKLACE2),
			new InventoryRequirement(SKILLS_NECKLACE3),
			new InventoryRequirement(SKILLS_NECKLACE4),
			new InventoryRequirement(SKILLS_NECKLACE5),
			new InventoryRequirement(SKILLS_NECKLACE6))),
	CAN_TELEPORT_WITH_SLAYER_RING(
		new OrRequirement("Slayer Ring",
			new InventoryRequirement(SLAYER_RING_1),
			new InventoryRequirement(SLAYER_RING_2),
			new InventoryRequirement(SLAYER_RING_3),
			new InventoryRequirement(SLAYER_RING_4),
			new InventoryRequirement(SLAYER_RING_5),
			new InventoryRequirement(SLAYER_RING_6),
			new InventoryRequirement(SLAYER_RING_7),
			new InventoryRequirement(SLAYER_RING_8),
			new InventoryRequirement(SLAYER_RING_ETERNAL))),
	CAN_TELEPORT_WITH_TELEPORT_CRYSTAL(
		new OrRequirement("Teleport Crystal",
			new InventoryRequirement(TELEPORT_CRYSTAL_1),
			new InventoryRequirement(TELEPORT_CRYSTAL_2),
			new InventoryRequirement(TELEPORT_CRYSTAL_3),
			new InventoryRequirement(TELEPORT_CRYSTAL_4),
			new InventoryRequirement(TELEPORT_CRYSTAL_5),
			new InventoryRequirement(ETERNAL_TELEPORT_CRYSTAL))),
	CAN_USE_AXE(
		new OrRequirement("Axe",
			new InventoryRequirement(BRONZE_AXE),
			new InventoryRequirement(IRON_AXE),
			new AndRequirement(
				new InventoryRequirement(STEEL_AXE),
				new SkillRequirement(WOODCUTTING, 6)),
			new AndRequirement(
				new InventoryRequirement(BLACK_AXE),
				new SkillRequirement(WOODCUTTING, 11)),
			new AndRequirement(
				new InventoryRequirement(MITHRIL_AXE),
				new SkillRequirement(WOODCUTTING, 21)),
			new AndRequirement(
				new InventoryRequirement(ADAMANT_AXE),
				new SkillRequirement(WOODCUTTING, 31)),
			new AndRequirement(
				new InventoryRequirement(RUNE_AXE),
				new SkillRequirement(WOODCUTTING, 41)),
			new AndRequirement(
				new InventoryRequirement(GILDED_AXE),
				new SkillRequirement(WOODCUTTING, 41)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_AXE),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_AXE_OR),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_AXE),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_AXE_OR),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_AXE_UNCHARGED),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_AXE_UNCHARGED_25371),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(_3RD_AGE_AXE),
				new SkillRequirement(WOODCUTTING, 61)),
			new AndRequirement(
				new InventoryRequirement(CRYSTAL_AXE),
				new SkillRequirement(WOODCUTTING, 71)),
			new AndRequirement(
				new InventoryRequirement(CRYSTAL_AXE_INACTIVE),
				new SkillRequirement(WOODCUTTING, 71)))),
	CAN_USE_FISHING_ROD(
		new OrRequirement("Fishing Rod",
			new InventoryRequirement(FISHING_ROD),
			new InventoryRequirement(PEARL_FISHING_ROD))),
	CAN_USE_FLY_FISHING_ROD(
		new OrRequirement("Fly fishing rod",
			new InventoryRequirement(FLY_FISHING_ROD),
			new InventoryRequirement(PEARL_FLY_FISHING_ROD))),
	CAN_USE_GHOSTSPEAK_AMULET(
		new OrRequirement("Ghostspeak Amulet",
			new EquipmentRequirement(GHOSTSPEAK_AMULET),
			new EquipmentRequirement(GHOSTSPEAK_AMULET_4250),
			new EquipmentRequirement(MORYTANIA_LEGS_2),
			new EquipmentRequirement(MORYTANIA_LEGS_3),
			new EquipmentRequirement(MORYTANIA_LEGS_4))),
	CAN_USE_HARPOON(
		new OrRequirement("Harpoon",
			new InventoryRequirement(HARPOON),
			new InventoryRequirement(BARBTAIL_HARPOON),
			new InventoryRequirement(DRAGON_HARPOON),
			new InventoryRequirement(DRAGON_HARPOON_OR),
			new InventoryRequirement(INFERNAL_HARPOON),
			new InventoryRequirement(INFERNAL_HARPOON_OR),
			new InventoryRequirement(INFERNAL_HARPOON_UNCHARGED),
			new InventoryRequirement(INFERNAL_HARPOON_UNCHARGED_25367),
			new InventoryRequirement(CRYSTAL_HARPOON),
			new InventoryRequirement(CRYSTAL_HARPOON_INACTIVE))),
	CAN_USE_MACHETE(
		new OrRequirement("Machete",
			new InventoryRequirement(MACHETE),
			new InventoryRequirement(JADE_MACHETE),
			new InventoryRequirement(OPAL_MACHETE),
			new InventoryRequirement(RED_TOPAZ_MACHETE))),
	CAN_USE_PICKAXE(
		new OrRequirement("Pickaxe",
			new InventoryRequirement(BRONZE_PICKAXE),
			new InventoryRequirement(IRON_PICKAXE),
			new AndRequirement(
				new InventoryRequirement(STEEL_PICKAXE),
				new SkillRequirement(MINING, 6)),
			new AndRequirement(
				new InventoryRequirement(BLACK_PICKAXE),
				new SkillRequirement(MINING, 11)),
			new AndRequirement(
				new InventoryRequirement(MITHRIL_PICKAXE),
				new SkillRequirement(MINING, 21)),
			new AndRequirement(
				new InventoryRequirement(ADAMANT_PICKAXE),
				new SkillRequirement(MINING, 31)),
			new AndRequirement(
				new InventoryRequirement(RUNE_PICKAXE),
				new SkillRequirement(MINING, 41)),
			new AndRequirement(
				new InventoryRequirement(GILDED_PICKAXE),
				new SkillRequirement(MINING, 41)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_PICKAXE),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_PICKAXE_12797),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_PICKAXE_OR),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(DRAGON_PICKAXE_OR_25376),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_PICKAXE),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_PICKAXE_OR),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_PICKAXE_UNCHARGED),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(INFERNAL_PICKAXE_UNCHARGED_25369),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(_3RD_AGE_PICKAXE),
				new SkillRequirement(MINING, 61)),
			new AndRequirement(
				new InventoryRequirement(CRYSTAL_PICKAXE),
				new SkillRequirement(MINING, 71)),
			new AndRequirement(
				new InventoryRequirement(CRYSTAL_PICKAXE_INACTIVE),
				new SkillRequirement(MINING, 71)))),
	HAS_GRACEFUL_BOOTS_EQUIPPED(
		new OrRequirement("Graceful Boots",
			new EquipmentRequirement(GRACEFUL_BOOTS),
			new EquipmentRequirement(GRACEFUL_BOOTS_11861),
			new EquipmentRequirement(GRACEFUL_BOOTS_13589),
			new EquipmentRequirement(GRACEFUL_BOOTS_13590),
			new EquipmentRequirement(GRACEFUL_BOOTS_13601),
			new EquipmentRequirement(GRACEFUL_BOOTS_13602),
			new EquipmentRequirement(GRACEFUL_BOOTS_13613),
			new EquipmentRequirement(GRACEFUL_BOOTS_13614),
			new EquipmentRequirement(GRACEFUL_BOOTS_13625),
			new EquipmentRequirement(GRACEFUL_BOOTS_13626),
			new EquipmentRequirement(GRACEFUL_BOOTS_13637),
			new EquipmentRequirement(GRACEFUL_BOOTS_13638),
			new EquipmentRequirement(GRACEFUL_BOOTS_13677),
			new EquipmentRequirement(GRACEFUL_BOOTS_13678),
			new EquipmentRequirement(GRACEFUL_BOOTS_21076),
			new EquipmentRequirement(GRACEFUL_BOOTS_21078),
			new EquipmentRequirement(GRACEFUL_BOOTS_24758),
			new EquipmentRequirement(GRACEFUL_BOOTS_24760),
			new EquipmentRequirement(GRACEFUL_BOOTS_25084),
			new EquipmentRequirement(GRACEFUL_BOOTS_25086))),
	HAS_GRACEFUL_CAPE_EQUIPPED(
		new OrRequirement("Graceful Cape",
			new EquipmentRequirement(GRACEFUL_CAPE),
			new EquipmentRequirement(GRACEFUL_CAPE_11853),
			new EquipmentRequirement(GRACEFUL_CAPE_13581),
			new EquipmentRequirement(GRACEFUL_CAPE_13582),
			new EquipmentRequirement(GRACEFUL_CAPE_13593),
			new EquipmentRequirement(GRACEFUL_CAPE_13594),
			new EquipmentRequirement(GRACEFUL_CAPE_13605),
			new EquipmentRequirement(GRACEFUL_CAPE_13606),
			new EquipmentRequirement(GRACEFUL_CAPE_13617),
			new EquipmentRequirement(GRACEFUL_CAPE_13618),
			new EquipmentRequirement(GRACEFUL_CAPE_13629),
			new EquipmentRequirement(GRACEFUL_CAPE_13630),
			new EquipmentRequirement(GRACEFUL_CAPE_13669),
			new EquipmentRequirement(GRACEFUL_CAPE_13670),
			new EquipmentRequirement(GRACEFUL_CAPE_21064),
			new EquipmentRequirement(GRACEFUL_CAPE_21066),
			new EquipmentRequirement(GRACEFUL_CAPE_24746),
			new EquipmentRequirement(GRACEFUL_CAPE_24748),
			new EquipmentRequirement(GRACEFUL_CAPE_25072),
			new EquipmentRequirement(GRACEFUL_CAPE_25074),
			new EquipmentRequirement(AGILITY_CAPE),
			new EquipmentRequirement(AGILITY_CAPE_13340),
			new EquipmentRequirement(AGILITY_CAPET),
			new EquipmentRequirement(AGILITY_CAPET_13341),
			new EquipmentRequirement(MAX_CAPE),
			new EquipmentRequirement(MAX_CAPE_13342))),
	HAS_GRACEFUL_GLOVES_EQUIPPED(
		new OrRequirement("Graceful Gloves",
			new EquipmentRequirement(GRACEFUL_GLOVES),
			new EquipmentRequirement(GRACEFUL_GLOVES_11859),
			new EquipmentRequirement(GRACEFUL_GLOVES_13587),
			new EquipmentRequirement(GRACEFUL_GLOVES_13588),
			new EquipmentRequirement(GRACEFUL_GLOVES_13599),
			new EquipmentRequirement(GRACEFUL_GLOVES_13600),
			new EquipmentRequirement(GRACEFUL_GLOVES_13611),
			new EquipmentRequirement(GRACEFUL_GLOVES_13612),
			new EquipmentRequirement(GRACEFUL_GLOVES_13623),
			new EquipmentRequirement(GRACEFUL_GLOVES_13624),
			new EquipmentRequirement(GRACEFUL_GLOVES_13635),
			new EquipmentRequirement(GRACEFUL_GLOVES_13636),
			new EquipmentRequirement(GRACEFUL_GLOVES_13675),
			new EquipmentRequirement(GRACEFUL_GLOVES_13676),
			new EquipmentRequirement(GRACEFUL_GLOVES_21073),
			new EquipmentRequirement(GRACEFUL_GLOVES_21075),
			new EquipmentRequirement(GRACEFUL_GLOVES_24755),
			new EquipmentRequirement(GRACEFUL_GLOVES_24757),
			new EquipmentRequirement(GRACEFUL_GLOVES_25081),
			new EquipmentRequirement(GRACEFUL_GLOVES_25083))),
	HAS_GRACEFUL_HOOD_EQUIPPED(
		new OrRequirement("Graceful Hood",
			new EquipmentRequirement(GRACEFUL_HOOD),
			new EquipmentRequirement(GRACEFUL_HOOD_11851),
			new EquipmentRequirement(GRACEFUL_HOOD_13579),
			new EquipmentRequirement(GRACEFUL_HOOD_13580),
			new EquipmentRequirement(GRACEFUL_HOOD_13591),
			new EquipmentRequirement(GRACEFUL_HOOD_13592),
			new EquipmentRequirement(GRACEFUL_HOOD_13603),
			new EquipmentRequirement(GRACEFUL_HOOD_13604),
			new EquipmentRequirement(GRACEFUL_HOOD_13615),
			new EquipmentRequirement(GRACEFUL_HOOD_13616),
			new EquipmentRequirement(GRACEFUL_HOOD_13627),
			new EquipmentRequirement(GRACEFUL_HOOD_13628),
			new EquipmentRequirement(GRACEFUL_HOOD_13667),
			new EquipmentRequirement(GRACEFUL_HOOD_13668),
			new EquipmentRequirement(GRACEFUL_HOOD_21061),
			new EquipmentRequirement(GRACEFUL_HOOD_21063),
			new EquipmentRequirement(GRACEFUL_HOOD_24743),
			new EquipmentRequirement(GRACEFUL_HOOD_24745),
			new EquipmentRequirement(GRACEFUL_HOOD_25069),
			new EquipmentRequirement(GRACEFUL_HOOD_25071))),
	HAS_GRACEFUL_LEGS_EQUIPPED(
		new OrRequirement("Graceful Legs",
			new EquipmentRequirement(GRACEFUL_LEGS),
			new EquipmentRequirement(GRACEFUL_LEGS_11857),
			new EquipmentRequirement(GRACEFUL_LEGS_13585),
			new EquipmentRequirement(GRACEFUL_LEGS_13586),
			new EquipmentRequirement(GRACEFUL_LEGS_13597),
			new EquipmentRequirement(GRACEFUL_LEGS_13598),
			new EquipmentRequirement(GRACEFUL_LEGS_13609),
			new EquipmentRequirement(GRACEFUL_LEGS_13610),
			new EquipmentRequirement(GRACEFUL_LEGS_13621),
			new EquipmentRequirement(GRACEFUL_LEGS_13622),
			new EquipmentRequirement(GRACEFUL_LEGS_13633),
			new EquipmentRequirement(GRACEFUL_LEGS_13634),
			new EquipmentRequirement(GRACEFUL_LEGS_13673),
			new EquipmentRequirement(GRACEFUL_LEGS_13674),
			new EquipmentRequirement(GRACEFUL_LEGS_21070),
			new EquipmentRequirement(GRACEFUL_LEGS_21072),
			new EquipmentRequirement(GRACEFUL_LEGS_24752),
			new EquipmentRequirement(GRACEFUL_LEGS_24754),
			new EquipmentRequirement(GRACEFUL_LEGS_25078),
			new EquipmentRequirement(GRACEFUL_LEGS_25080))),
	HAS_GRACEFUL_TOP_EQUIPPED(
		new OrRequirement("Graceful Top",
			new EquipmentRequirement(GRACEFUL_TOP),
			new EquipmentRequirement(GRACEFUL_TOP_11855),
			new EquipmentRequirement(GRACEFUL_TOP_13583),
			new EquipmentRequirement(GRACEFUL_TOP_13584),
			new EquipmentRequirement(GRACEFUL_TOP_13595),
			new EquipmentRequirement(GRACEFUL_TOP_13596),
			new EquipmentRequirement(GRACEFUL_TOP_13607),
			new EquipmentRequirement(GRACEFUL_TOP_13608),
			new EquipmentRequirement(GRACEFUL_TOP_13619),
			new EquipmentRequirement(GRACEFUL_TOP_13620),
			new EquipmentRequirement(GRACEFUL_TOP_13631),
			new EquipmentRequirement(GRACEFUL_TOP_13632),
			new EquipmentRequirement(GRACEFUL_TOP_13671),
			new EquipmentRequirement(GRACEFUL_TOP_13672),
			new EquipmentRequirement(GRACEFUL_TOP_21067),
			new EquipmentRequirement(GRACEFUL_TOP_21069),
			new EquipmentRequirement(GRACEFUL_TOP_24749),
			new EquipmentRequirement(GRACEFUL_TOP_24751),
			new EquipmentRequirement(GRACEFUL_TOP_25075),
			new EquipmentRequirement(GRACEFUL_TOP_25077))),
	HAS_SLAYER_HELMET(
		new OrRequirement("Slayer Helmet",
			new EquipmentRequirement(SLAYER_HELMET),
			new EquipmentRequirement(SLAYER_HELMET_I),
			new EquipmentRequirement(BLACK_SLAYER_HELMET),
			new EquipmentRequirement(BLACK_SLAYER_HELMET_I),
			new EquipmentRequirement(PURPLE_SLAYER_HELMET),
			new EquipmentRequirement(PURPLE_SLAYER_HELMET_I),
			new EquipmentRequirement(RED_SLAYER_HELMET),
			new EquipmentRequirement(RED_SLAYER_HELMET_I),
			new EquipmentRequirement(GREEN_SLAYER_HELMET),
			new EquipmentRequirement(GREEN_SLAYER_HELMET_I),
			new EquipmentRequirement(TURQUOISE_SLAYER_HELMET),
			new EquipmentRequirement(TURQUOISE_SLAYER_HELMET_I),
			new EquipmentRequirement(HYDRA_SLAYER_HELMET),
			new EquipmentRequirement(HYDRA_SLAYER_HELMET_I),
			new EquipmentRequirement(TWISTED_SLAYER_HELMET),
			new EquipmentRequirement(TWISTED_SLAYER_HELMET_I),
			new EquipmentRequirement(TZTOK_SLAYER_HELMET),
			new EquipmentRequirement(TZTOK_SLAYER_HELMET_I),
			new EquipmentRequirement(VAMPYRIC_SLAYER_HELMET),
			new EquipmentRequirement(VAMPYRIC_SLAYER_HELMET_I),
			new EquipmentRequirement(TZKAL_SLAYER_HELMET),
			new EquipmentRequirement(TZKAL_SLAYER_HELMET_I))),
	HAS_FACEMASK(
		new OrRequirement("Facemask",
			new EquipmentRequirement(FACEMASK),
			HAS_SLAYER_HELMET.getRequirement()));

	private final Requirement requirement;
}
