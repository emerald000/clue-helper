/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package emerald000.cluehelper.clues;

import com.google.common.collect.ImmutableList;
import java.awt.Graphics2D;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import static net.runelite.api.EquipmentInventorySlot.GLOVES;
import static net.runelite.api.EquipmentInventorySlot.SHIELD;
import static net.runelite.api.EquipmentInventorySlot.WEAPON;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.ClueScrollWorldOverlay.CLICKBOX_BORDER_COLOR;
import static emerald000.cluehelper.ClueScrollWorldOverlay.CLICKBOX_FILL_COLOR;
import static emerald000.cluehelper.ClueScrollWorldOverlay.CLICKBOX_HOVER_BORDER_COLOR;
import static emerald000.cluehelper.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import emerald000.cluehelper.clues.requirement.AndRequirement;
import static emerald000.cluehelper.clues.requirement.CommonRequirement.*;
import emerald000.cluehelper.clues.requirement.EmptySlotRequirement;
import emerald000.cluehelper.clues.requirement.EquipmentRequirement;
import emerald000.cluehelper.clues.requirement.InventoryRequirement;
import emerald000.cluehelper.clues.requirement.OrRequirement;
import emerald000.cluehelper.clues.requirement.Requirement;
import emerald000.cluehelper.clues.requirement.RuneRequirement;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.BLOOD;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.COSMIC;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.EARTH;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.LAW;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.NATURE;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.SOUL;
import static emerald000.cluehelper.clues.requirement.RuneRequirement.Rune.WATER;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@SuperBuilder
public class SkillChallengeClue extends ClueScroll
{
	private static final ClueArea CHARLIE_LOCATION = new ClueArea(3206, 3390, 0);
	private static final ClueArea SHERLOCK_LOCATION = new ClueArea(2733, 3413, 0);

	private static final List<SkillChallengeClue> CLUES = ImmutableList.of(
		// Beginner Charlie Tasks
		SkillChallengeClue.builder()
			.solution("Cook a Pike")
			.text("i need to cook charlie a pike.")
			.returnText("i need to take the cooked pike to charlie.")
			.returnItem(new InventoryRequirement(PIKE))
			.requirement(new InventoryRequirement(RAW_PIKE))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Cook a Trout")
			.text("i need to cook charlie a trout.")
			.returnText("i need to take the cooked trout to charlie.")
			.returnItem(new InventoryRequirement(TROUT))
			.requirement(new InventoryRequirement(RAW_TROUT))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Craft a Leather Body")
			.text("i need to craft charlie a leather body.")
			.returnText("i need to take the leather body i crafted to charlie.")
			.returnItem(new InventoryRequirement(LEATHER_BODY))
			.requirement(new InventoryRequirement(LEATHER))
			.requirement(new InventoryRequirement(NEEDLE))
			.requirement(new InventoryRequirement(THREAD))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Craft some Leather Chaps")
			.text("I need to craft Charlie some leather chaps.")
			.returnText("i need to take the leather chaps i crafted to charlie.")
			.returnItem(new InventoryRequirement(LEATHER_CHAPS))
			.requirement(new InventoryRequirement(LEATHER))
			.requirement(new InventoryRequirement(NEEDLE))
			.requirement(new InventoryRequirement(THREAD))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Fish a Herring")
			.text("I need to fish Charlie a herring.")
			.returnText("i need to take a raw herring to charlie.")
			.returnItem(new InventoryRequirement(RAW_HERRING))
			.requirement(CAN_USE_FISHING_ROD.getRequirement())
			.requirement(new InventoryRequirement(FISHING_BAIT))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Fish a trout")
			.text("i need to fish charlie a trout.")
			.returnText("i need to take a raw trout to charlie.")
			.returnItem(new InventoryRequirement(RAW_TROUT))
			.requirement(CAN_USE_FLY_FISHING_ROD.getRequirement())
			.requirement(new InventoryRequirement(FEATHER))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Mine some Iron Ore")
			.text("i need to mine charlie a piece of iron ore from an iron vein.")
			.returnText("i need to take the iron ore to charlie.")
			.returnItem(new InventoryRequirement(IRON_ORE))
			.requirement(CAN_USE_PICKAXE.getRequirement())
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.solution("Smith an Iron Dagger")
			.text("i need to smith charlie one iron dagger.")
			.returnText("i need to take the iron dagger i smithed to charlie.")
			.returnItem(new InventoryRequirement(IRON_DAGGER))
			.requirement(new InventoryRequirement(IRON_BAR))
			//TODO: Imcando Hammer
			.requirement(new InventoryRequirement(HAMMER))
			.npc("Charlie the Tramp")
			.location(CHARLIE_LOCATION)
			.build(),

		// Elite Sherlock Tasks
		// 12113: "Burn a yew log"
		// 12113: "catch mottled eel"
		// 12116: "Craft double cosmic runes"
		// 12117: "slay a dust devil"
		// 12122: "mine a mithril ore"
		// 12126:
		// Challenge Scroll ID: 12128
		SkillChallengeClue.builder()
			.text("Equip a Dragon Scimitar.")
			.solution("Equip a Dragon Scimitar")
			.requirement(new OrRequirement("Dragon Scimitar",
				new EquipmentRequirement(DRAGON_SCIMITAR),
				new EquipmentRequirement(DRAGON_SCIMITAR_OR)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("enchant a piece of dragonstone jewellery.")
			.solution("Enchant some Dragonstone Jewellery")
			.requirement(new RuneRequirement(WATER, 15))
			.requirement(new RuneRequirement(EARTH, 15))
			.requirement(new RuneRequirement(COSMIC))
			.requirement(new OrRequirement("Unenchanted Dragonstone Jewellery",
				new InventoryRequirement(DRAGONSTONE_RING),
				new InventoryRequirement(DRAGON_NECKLACE),
				new InventoryRequirement(DRAGONSTONE_BRACELET),
				new InventoryRequirement(DRAGONSTONE_AMULET)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Craft a nature rune.")
			.solution("Craft a nature rune")
			.requirement(new InventoryRequirement(PURE_ESSENCE))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Catch a mottled eel with aerial fishing in Lake Molch.")
			.solution("Catch a mottled eel")
			.area("Lake Molch")
			.requirement(new OrRequirement("Fish Chunks or King Worm",
				new InventoryRequirement(FISH_CHUNKS),
				new InventoryRequirement(KING_WORM)))
			// TODO: Add cormorant's gloves x2
			.requirement(new EmptySlotRequirement(GLOVES))
			.requirement(new EmptySlotRequirement(WEAPON))
			.requirement(new EmptySlotRequirement(SHIELD))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Score a goal in skullball.")
			.solution("Score a goal in skullball")
			.area("Werewolf Agility Course")
			.requirement(new OrRequirement("Ring of Charos",
				new EquipmentRequirement(RING_OF_CHAROS),
				new EquipmentRequirement(RING_OF_CHAROSA)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Complete a lap of Ape atoll agility course.")
			.solution("Complete a lap of Ape Atoll agility course")
			.requirement(new OrRequirement("Ninja Greegree",
				new EquipmentRequirement(NINJA_MONKEY_GREEGREE),
				new EquipmentRequirement(NINJA_MONKEY_GREEGREE_4025),
				new EquipmentRequirement(KRUK_MONKEY_GREEGREE)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Create a super defence potion.")
			.solution("Make a super defence potion")
			.requirement(new InventoryRequirement(CADANTINE_POTION_UNF))
			.requirement(new InventoryRequirement(WHITE_BERRIES))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Steal from a chest in Ardougne Castle.")
			.solution("Steal from a chest in Ardougne Castle")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Craft a green dragonhide body.")
			.solution("Craft a green d'hide body")
			.requirement(new InventoryRequirement(GREEN_DRAGON_LEATHER, 3))
			.requirement(new InventoryRequirement(NEEDLE))
			.requirement(new InventoryRequirement(THREAD))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("String a yew longbow.")
			.solution("String a yew longbow")
			.requirement(new InventoryRequirement(YEW_LONGBOW_U))
			.requirement(new InventoryRequirement(BOW_STRING))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("slay a dust devil.")
			.solution("Kill a Dust Devil")
			.area("Smoke Dungeon or Catacombs of Kourend")
			.requirement(HAS_FACEMASK.getRequirement())
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Catch a black warlock.")
			.solution("Catch a black warlock")
			.area("Feldip Jungle or Farming Guild")
			.requirement(new InventoryRequirement(BUTTERFLY_JAR))
			.requirement(new OrRequirement("Butterfly Net",
				new InventoryRequirement(BUTTERFLY_NET),
				new InventoryRequirement(MAGIC_BUTTERFLY_NET)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Catch a red chinchompa.")
			.solution("Catch a red chinchompa")
			.area("Feldip Jungle or Gwenith")
			.requirement(new InventoryRequirement(BOX_TRAP))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Mine a mithril ore.")
			.solution("Mine some mithril ore")
			.requirement(CAN_USE_PICKAXE.getRequirement())
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Smith a mithril 2h sword.")
			.solution("Smith a mithril 2h sword")
			//TODO: Imcando Hammer
			.requirement(new InventoryRequirement(HAMMER))
			.requirement(new InventoryRequirement(MITHRIL_BAR, 3))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Catch a raw shark.")
			.solution("Catch a shark")
			.requirement(CAN_USE_HARPOON.getRequirement())
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Cut a yew log.")
			.solution("Cut a yew log")
			.requirement(CAN_USE_AXE.getRequirement())
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Fix a magical lamp in Dorgesh-Kaan.")
			.solution("Fix a light orb in Dorgesh-Kaan.")
			.requirement(new InventoryRequirement(LIGHT_ORB))
			.objectName("Broken Lamp")
			.objectRegion(10834)
			.objectRegion(10835)
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Burn a yew log.")
			.solution("Burn a yew log")
			.requirement(new InventoryRequirement(YEW_LOGS))
			.requirement(new InventoryRequirement(TINDERBOX))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("cook a swordfish")
			.solution("Cook a swordfish")
			.requirement(new InventoryRequirement(RAW_SWORDFISH))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Craft multiple cosmic runes from a single essence.")
			.solution("Craft double cosmic runes")
			.area("Zanaris")
			.requirement(new InventoryRequirement(PURE_ESSENCE))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Plant a watermelon seed.")
			.solution("Plant a watermelon seed")
			.requirement(new InventoryRequirement(SEED_DIBBER))
			.requirement(new InventoryRequirement(WATERMELON_SEED, 3))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Activate the Chivalry prayer.")
			.solution("Activate the Chivalry prayer")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("take the lovakengj armourers a boxed set of shayzien supply armour at tier 2 or above.")
			.solution("Hand in a Tier 2 or higher set of Shayzien supply armour")
			.requirement(new OrRequirement("Shayzien Supply Set (Tier 2 or higher)",
				new InventoryRequirement(SHAYZIEN_SUPPLY_SET_2),
				new InventoryRequirement(SHAYZIEN_SUPPLY_SET_3),
				new InventoryRequirement(SHAYZIEN_SUPPLY_SET_4),
				new InventoryRequirement(SHAYZIEN_SUPPLY_SET_5)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),

		// Master Sherlock Tasks
		SkillChallengeClue.builder()
			.text("Equip an abyssal whip in front of the abyssal demons of the Slayer tower.")
			.solution("Equip an abyssal whip in front of the abyssal demons")
			.area("Slayer Tower")
			.requirement(new OrRequirement("Abyssal Whip",
				new EquipmentRequirement(ABYSSAL_WHIP),
				new EquipmentRequirement(FROZEN_ABYSSAL_WHIP),
				new EquipmentRequirement(VOLCANIC_ABYSSAL_WHIP)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Smith a runite med helm.")
			.solution("Smith a rune med helm")
			//TODO: Imcando Hammer
			.requirement(new InventoryRequirement(HAMMER))
			.requirement(new InventoryRequirement(RUNITE_BAR))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Teleport to a spirit tree you planted yourself.")
			.solution("Teleport to a spirit tree you planted")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Create a Barrows teleport tablet.")
			.solution("Create a Barrows teleport tablet")
			.area("Ouditor's house in Arceuus")
			.requirement(new InventoryRequirement(DARK_ESSENCE_BLOCK))
			.requirement(new RuneRequirement(LAW, 2))
			.requirement(new RuneRequirement(SOUL, 2))
			.requirement(new RuneRequirement(BLOOD))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("slay a nechryael in the slayer tower.")
			.solution("Kill a Nechryael")
			.area("Slayer Tower")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		// TODO: Check for god items
		SkillChallengeClue.builder()
			.text("kill the spiritual, magic and godly whilst representing their own god.")
			.solution("Kill a Spiritual Mage while wearing something from their god.")
			.area("God Wars Dungeon")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Create an unstrung dragonstone amulet at a furnace.")
			.solution("Create an unstrung dragonstone amulet")
			.requirement(new InventoryRequirement(GOLD_BAR))
			.requirement(new InventoryRequirement(DRAGONSTONE))
			.requirement(new InventoryRequirement(AMULET_MOULD))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Burn a magic log.")
			.solution("Burn a magic log")
			.requirement(new InventoryRequirement(MAGIC_LOGS))
			.requirement(new InventoryRequirement(TINDERBOX))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Burn a redwood log.")
			.solution("Burn a redwood log")
			.requirement(new InventoryRequirement(REDWOOD_LOGS))
			.requirement(new InventoryRequirement(TINDERBOX))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("complete a lap of the rellekka rooftop agility course whilst sporting the finest amount of grace.")
			.solution("Complete a lap of the agility course in full graceful")
			.area("Rellekka")
			.requirement(HAS_GRACEFUL_BOOTS_EQUIPPED.getRequirement())
			.requirement(HAS_GRACEFUL_CAPE_EQUIPPED.getRequirement())
			.requirement(HAS_GRACEFUL_GLOVES_EQUIPPED.getRequirement())
			.requirement(HAS_GRACEFUL_HOOD_EQUIPPED.getRequirement())
			.requirement(HAS_GRACEFUL_LEGS_EQUIPPED.getRequirement())
			.requirement(HAS_GRACEFUL_TOP_EQUIPPED.getRequirement())
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		// TODO: Can you make an anti-venom 1-3 directly?
		SkillChallengeClue.builder()
			.text("Mix an anti-venom potion.")
			.solution("Mix an anti-venom potion")
			.requirement(new InventoryRequirement(ANTIDOTE4_5952))
			.requirement(new InventoryRequirement(ZULRAHS_SCALES, 20))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("mine a piece of runite ore whilst sporting the finest mining gear.")
			.solution("Mine some Runite ore in full prospector outfit")
			.requirement(CAN_USE_PICKAXE.getRequirement())
			.requirement(new AndRequirement("Prospector outfit",
				new OrRequirement(new EquipmentRequirement(PROSPECTOR_HELMET), new EquipmentRequirement(GOLDEN_PROSPECTOR_HELMET)),
				new OrRequirement(new EquipmentRequirement(PROSPECTOR_JACKET), new EquipmentRequirement(GOLDEN_PROSPECTOR_JACKET), new EquipmentRequirement(VARROCK_ARMOUR_4)),
				new OrRequirement(new EquipmentRequirement(PROSPECTOR_LEGS), new EquipmentRequirement(GOLDEN_PROSPECTOR_LEGS)),
				new OrRequirement(new EquipmentRequirement(PROSPECTOR_BOOTS), new EquipmentRequirement(GOLDEN_PROSPECTOR_BOOTS))))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Steal a gem from the Ardougne market.")
			.solution("Steal a gem")
			.area("Ardougne Market")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Pickpocket an elf.")
			.solution("Pickpocket an elf")
			.area("Lletya or Prifddinas")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Bind a blood rune at the blood altar.")
			.solution("Craft a Blood Rune")
			.requirement(new InventoryRequirement(DARK_ESSENCE_FRAGMENTS))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("mix a ranging mix potion.")
			.solution("Create a ranging mix potion")
			.requirement(new InventoryRequirement(RANGING_POTION2))
			.requirement(new InventoryRequirement(CAVIAR))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Fletch a rune dart.")
			.solution("Fletch a rune dart")
			.requirement(new InventoryRequirement(RUNE_DART_TIP))
			.requirement(new InventoryRequirement(FEATHER))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Cremate a set of fiyr remains.")
			.solution("Cremate a set of fiyr remains")
			.area("Mort'ton")
			.requirement(new OrRequirement("Magic or redwood pyre logs",
				new InventoryRequirement(MAGIC_PYRE_LOGS),
				new InventoryRequirement(REDWOOD_PYRE_LOGS)))
			.requirement(new InventoryRequirement(TINDERBOX))
			.requirement(new InventoryRequirement(FIYR_REMAINS))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Dissect a sacred eel.")
			.solution("Dissect a sacred eel")
			.requirement(new InventoryRequirement(SACRED_EEL))
			.requirement(new InventoryRequirement(KNIFE))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Kill a lizardman shaman.")
			.solution("Kill a lizardman shaman")
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("angle for an anglerfish whilst sporting the finest fishing gear.")
			.solution("Catch an Anglerfish in full Fishing outfit")
			.requirement(CAN_USE_FISHING_ROD.getRequirement())
			.requirement(new InventoryRequirement(SANDWORMS))
			.requirement(new AndRequirement("Angler's outfit",
				new OrRequirement(new EquipmentRequirement(ANGLER_HAT), new EquipmentRequirement(SPIRIT_ANGLER_HEADBAND)),
				new OrRequirement(new EquipmentRequirement(ANGLER_TOP), new EquipmentRequirement(SPIRIT_ANGLER_TOP)),
				new OrRequirement(new EquipmentRequirement(ANGLER_WADERS), new EquipmentRequirement(SPIRIT_ANGLER_WADERS)),
				new OrRequirement(new EquipmentRequirement(ANGLER_BOOTS), new EquipmentRequirement(SPIRIT_ANGLER_BOOTS))))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("chop a redwood log whilst sporting the finest lumberjack gear.")
			.solution("Chop a redwood log in full Lumberjack outfit")
			.requirement(CAN_USE_AXE.getRequirement())
			.requirement(new EquipmentRequirement(LUMBERJACK_HAT))
			.requirement(new EquipmentRequirement(LUMBERJACK_TOP))
			.requirement(new EquipmentRequirement(LUMBERJACK_LEGS))
			.requirement(new EquipmentRequirement(LUMBERJACK_BOOTS))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		// TODO: Get Full Area
		SkillChallengeClue.builder()
			.text("Craft a light orb in the Dorgesh-Kaan bank.")
			.solution("Craft a light orb")
			.area("Dorgesh-Kaan bank")
			.requirement(new InventoryRequirement(CAVE_GOBLIN_WIRE))
			.requirement(new InventoryRequirement(EMPTY_LIGHT_ORB))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		// TODO: Get Full Area
		SkillChallengeClue.builder()
			.text("kill a reanimated abyssal.")
			.solution("Kill a reanimated Abyssal Demon")
			.area("Dark Altar")
			.requirement(new RuneRequirement(SOUL, 4))
			.requirement(new RuneRequirement(NATURE, 4))
			.requirement(new RuneRequirement(BLOOD, 2))
			.requirement(new OrRequirement("Ensouled abyssal head",
				new InventoryRequirement(ENSOULED_ABYSSAL_HEAD),
				new InventoryRequirement(ENSOULED_ABYSSAL_HEAD_13508)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build(),
		SkillChallengeClue.builder()
			.text("Kill a Fiyr shade inside Mort'tons shade catacombs.")
			.solution("Kill a Fiyr shade")
			.area("Shade Catacombs")
			.requirement(new OrRequirement("Silver or Gold Shade Key",
				new InventoryRequirement(SILVER_KEY_RED),
				new InventoryRequirement(SILVER_KEY_BROWN),
				new InventoryRequirement(SILVER_KEY_CRIMSON),
				new InventoryRequirement(SILVER_KEY_BLACK),
				new InventoryRequirement(SILVER_KEY_PURPLE),
				new InventoryRequirement(GOLD_KEY_RED),
				new InventoryRequirement(GOLD_KEY_BROWN),
				new InventoryRequirement(GOLD_KEY_CRIMSON),
				new InventoryRequirement(GOLD_KEY_BLACK),
				new InventoryRequirement(GOLD_KEY_PURPLE)))
			.npc("Sherlock")
			.location(SHERLOCK_LOCATION)
			.build());

	@Nullable
	private final String returnText;
	@Nullable
	private final Requirement returnItem;
	@Nullable
	private final String objectName;
	@Singular
	@Nonnull
	private final List<Integer> objectRegions;
	@Setter
	private boolean challengeCompleted;

	private final String type = "Skill Challenge";

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
		// Mark objects
		if (!challengeCompleted && objectName != null && plugin.getNamedObjectsToMark() != null)
		{
			final Point mousePosition = plugin.getClient().getMouseCanvasPosition();

			for (final TileObject object : plugin.getNamedObjectsToMark())
			{
				if (plugin.getClient().getPlane() != object.getPlane())
				{
					continue;
				}

				OverlayUtil.renderHoverableArea(graphics, object.getClickbox(), mousePosition,
					CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

				OverlayUtil.renderImageLocation(plugin.getClient(), graphics, object.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
			}
		}
	}

	@Nullable
	public static SkillChallengeClue forText(String text, String rawText)
	{
		for (SkillChallengeClue clue : CLUES)
		{
			if (rawText.equalsIgnoreCase(clue.returnText)
				|| rawText.equalsIgnoreCase("<str>" + clue.getText() + "</str>"))
			{
				clue.setChallengeCompleted(true);
				return clue;
			}
			else if (rawText.equalsIgnoreCase(clue.getText()))
			{
				clue.setChallengeCompleted(false);
				return clue;
			}
		}
		return null;
	}
}
