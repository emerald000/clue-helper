/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import net.runelite.api.Client;
import static net.runelite.api.EquipmentInventorySlot.LEGS;
import static net.runelite.api.EquipmentInventorySlot.*;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Perspective;
import net.runelite.api.ScriptID;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static emerald000.cluehelper.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import static emerald000.cluehelper.ClueScrollOverlay.UNICODE_BALLOT_X;
import static emerald000.cluehelper.ClueScrollOverlay.UNICODE_CHECK_MARK;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.Enemy.DOUBLE_AGENT_108;
import static emerald000.cluehelper.clues.Enemy.DOUBLE_AGENT_141;
import static emerald000.cluehelper.clues.Enemy.DOUBLE_AGENT_65;
import emerald000.cluehelper.clues.emote.Emote;
import static emerald000.cluehelper.clues.emote.Emote.BULL_ROARER;
import static emerald000.cluehelper.clues.emote.Emote.*;
import emerald000.cluehelper.clues.emote.STASHUnit;
import static emerald000.cluehelper.clues.emote.STASHUnit.SHANTAY_PASS;
import static emerald000.cluehelper.clues.emote.STASHUnit.*;
import emerald000.cluehelper.clues.item.ItemRequirement;
import static emerald000.cluehelper.clues.item.ItemRequirements.all;
import static emerald000.cluehelper.clues.item.ItemRequirements.any;
import static emerald000.cluehelper.clues.item.ItemRequirements.emptySlot;
import static emerald000.cluehelper.clues.item.ItemRequirements.item;
import static emerald000.cluehelper.clues.item.ItemRequirements.range;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@SuperBuilder
public class EmoteClue extends ClueScroll
{
	private static final List<EmoteClue> CLUES = ImmutableList.of(
		// Beginner
		EmoteClue.builder()
			.text("Blow a raspberry at Gypsy Aris in her tent. Equip a gold ring and a gold necklace.")
			.clueId(CLUE_SCROLL_BEGINNER)
			.area("Varrock")
			.stashUnit(GYPSY_TENT_ENTRANCE)
			.location(new ClueArea(3201, 3422, 3205, 3425, 0))
			.firstEmote(RASPBERRY)
			.itemRequirement(item(GOLD_RING))
			.itemRequirement(item(GOLD_NECKLACE))
			.build(),
		EmoteClue.builder()
			.text("Bow to Brugsen Bursen at the Grand Exchange.")
			.area("Grand Exchange")
			.location(new ClueArea(3163, 3475, 3167, 3479, 0))
			.firstEmote(BOW)
			.build(),
		EmoteClue.builder()
			.text("Cheer at Iffie Nitter. Equip a chef hat and a red cape.")
			.area("Varrock")
			.stashUnit(FINE_CLOTHES_ENTRANCE)
			.location(new ClueArea(3202, 3414, 3208, 3419, 0))
			.firstEmote(CHEER)
			.itemRequirement(item(CHEFS_HAT))
			.itemRequirement(item(RED_CAPE))
			.build(),
		EmoteClue.builder()
			.text("Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.")
			.area("Lumbridge")
			.stashUnit(BOB_AXES_ENTRANCE)
			.location(new ClueArea(3228, 3201, 3233, 3205, 0))
			.firstEmote(CLAP)
			.itemRequirement(item(BRONZE_AXE))
			.itemRequirement(item(LEATHER_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Panic at Al Kharid mine.")
			.area("Al Kharid mine")
			.location(new ClueArea(3285, 3271, 3314, 3318, 0))
			.firstEmote(PANIC)
			.build(),
		EmoteClue.builder()
			.text("Spin at Flynn's Mace Shop.")
			.area("Falador")
			.location(new ClueArea(2948, 3385, 2952, 3390, 0))
			.firstEmote(SPIN)
			.build(),

		// Easy
		EmoteClue.builder()
			.text("Blow a raspberry at the monkey cage in Ardougne Zoo. Equip a studded leather body, bronze platelegs and a normal staff with no orb.")
			.clueId(CLUE_SCROLL_EASY_10216)
			.area("Ardougne Zoo")
			.stashUnit(NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO)
			.location(new ClueArea(2596, 3273, 2609, 3284, 0))
			.firstEmote(RASPBERRY)
			.itemRequirement(item(STUDDED_BODY))
			.itemRequirement(item(BRONZE_PLATELEGS))
			.itemRequirement(item(STAFF))
			.build(),
		EmoteClue.builder()
			.text("Blow raspberries outside the entrance to Keep Le Faye. Equip a coif, an iron platebody and leather gloves.")
			.clueId(CLUE_SCROLL_EASY_10222)
			.area("Keep Le Faye")
			.stashUnit(OUTSIDE_KEEP_LE_FAYE)
			.location(new ClueArea(2757, 3399, 2763, 3406, 0))
			.firstEmote(RASPBERRY)
			.itemRequirement(item(COIF))
			.itemRequirement(item(IRON_PLATEBODY))
			.itemRequirement(item(LEATHER_GLOVES))
			.build(),
		EmoteClue.builder()
			.text("Bow in the ticket office of the Duel Arena. Equip an iron chain body, leather chaps and coif.")
			.clueId(CLUE_SCROLL_EASY_10232)
			.area("Duel Arena")
			.stashUnit(MUBARIZS_ROOM_AT_THE_DUEL_ARENA)
			.location(new ClueArea(3312, 3240, 3316, 3244, 0))
			.firstEmote(BOW)
			.itemRequirement(item(IRON_CHAINBODY))
			.itemRequirement(item(LEATHER_CHAPS))
			.itemRequirement(item(COIF))
			.build(),
		EmoteClue.builder()
			.text("Bow outside the entrance to the Legends' Guild. Equip iron platelegs, an emerald amulet and an oak longbow.")
			.clueId(CLUE_SCROLL_EASY_10188)
			.area("Legends' Guild")
			.stashUnit(OUTSIDE_THE_LEGENDS_GUILD_GATES)
			.location(new ClueArea(2725, 3343, 2732, 3349, 0))
			.firstEmote(BOW)
			.itemRequirement(item(IRON_PLATELEGS))
			.itemRequirement(item(OAK_LONGBOW))
			.itemRequirement(item(EMERALD_AMULET))
			.build(),
		EmoteClue.builder()
			.text("Cheer at the Druids' Circle. Equip a blue wizard hat, a bronze two-handed sword and HAM boots.")
			.clueId(CLUE_SCROLL_EASY_10210)
			.area("Taverley stone circle")
			.stashUnit(TAVERLEY_STONE_CIRCLE)
			.location(new ClueArea(2920, 3478, 2931, 3489, 0))
			.firstEmote(CHEER)
			.itemRequirement(item(BLUE_WIZARD_HAT))
			.itemRequirement(item(BRONZE_2H_SWORD))
			.itemRequirement(item(HAM_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Cheer at the games room. Have nothing equipped at all when you do.")
			.clueId(CLUE_SCROLL_EASY_10212)
			.area("Games room")
			.location(new ClueArea(2194, 4946, 2221, 4973, 0))
			.firstEmote(CHEER)
			.itemRequirement(emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO))
			.build(),
		EmoteClue.builder()
			.text("Cheer for the monks at Port Sarim. Equip a coif, steel plateskirt and a sapphire necklace.")
			.clueId(CLUE_SCROLL_EASY_10192)
			.area("Port Sarim")
			.stashUnit(NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM)
			.location(new ClueArea(3044, 3234, 3050, 3237, 0))
			.firstEmote(CHEER)
			.itemRequirement(item(COIF))
			.itemRequirement(item(STEEL_PLATESKIRT))
			.itemRequirement(item(SAPPHIRE_NECKLACE))
			.build(),
		EmoteClue.builder()
			.text("Clap in the main exam room in the Exam Centre. Equip a white apron, green gnome boots and leather gloves.")
			.clueId(CLUE_SCROLL_EASY_10228)
			.area("Exam Centre")
			.stashUnit(OUTSIDE_THE_DIGSITE_EXAM_CENTRE)
			.location(new ClueArea(3357, 3332, 3367, 3348, 0))
			.firstEmote(CLAP)
			.itemRequirement(item(WHITE_APRON))
			.itemRequirement(item(GREEN_BOOTS))
			.itemRequirement(item(LEATHER_GLOVES))
			.build(),
		EmoteClue.builder()
			.text("Clap on the causeway to the Wizards' Tower. Equip an iron medium helmet, emerald ring and a white apron.")
			.clueId(CLUE_SCROLL_EASY_10182)
			.area("Wizards' Tower")
			.stashUnit(ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER)
			.location(new ClueArea(3112, 3171, 3115, 3209, 0))
			.firstEmote(CLAP)
			.itemRequirement(item(IRON_MED_HELM))
			.itemRequirement(item(EMERALD_RING))
			.itemRequirement(item(WHITE_APRON))
			.build(),
		EmoteClue.builder()
			.text("Clap on the top level of the mill, north of East Ardougne. Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.")
			.clueId(CLUE_SCROLL_EASY_10206)
			.area("East Ardougne")
			.stashUnit(UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL)
			.location(new ClueArea(2630, 3384, 2635, 3388, 2))
			.firstEmote(CLAP)
			.itemRequirement(item(BLUE_ROBE_TOP))
			.itemRequirement(item(HAM_ROBE))
			.itemRequirement(item(TIARA))
			.build(),
		EmoteClue.builder()
			.text("Dance a jig by the entrance to the Fishing Guild. Equip an emerald ring, a sapphire amulet, and a bronze chain body.")
			.clueId(CLUE_SCROLL_EASY_10220)
			.area("Fishing Guild")
			.stashUnit(OUTSIDE_THE_FISHING_GUILD)
			.location(new ClueArea(2608, 3390, 2613, 3393, 0))
			.firstEmote(JIG)
			.itemRequirement(item(EMERALD_RING))
			.itemRequirement(item(SAPPHIRE_AMULET))
			.itemRequirement(item(BRONZE_CHAINBODY))
			.build(),
		EmoteClue.builder()
			.text("Dance at the crossroads north of Draynor. Equip an iron chain body, a sapphire ring and a longbow.")
			.clueId(CLUE_SCROLL_EASY_10200)
			.area("Draynor Village")
			.stashUnit(CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE)
			.location(new ClueArea(3108, 3293, 3111, 3296, 0))
			.firstEmote(DANCE)
			.itemRequirement(item(IRON_CHAINBODY))
			.itemRequirement(item(SAPPHIRE_RING))
			.itemRequirement(item(LONGBOW))
			.build(),
		EmoteClue.builder()
			.text("Dance at the entrance to the Grand Exchange. Equip a pink skirt, pink robe top and a body tiara.")
			.clueId(CLUE_SCROLL_EASY_19831)
			.area("Grand Exchange")
			.stashUnit(SOUTH_OF_THE_GRAND_EXCHANGE)
			.location(new ClueArea(3161, 3461, 3170, 3470, 0))
			.firstEmote(DANCE)
			.itemRequirement(item(PINK_SKIRT))
			.itemRequirement(item(PINK_ROBE_TOP))
			.itemRequirement(item(BODY_TIARA))
			.build(),
		EmoteClue.builder()
			.text("Dance in the Party Room. Equip a steel full helmet, steel platebody and an iron plateskirt.")
			.clueId(CLUE_SCROLL_EASY_10208)
			.area("Falador Party Room")
			.stashUnit(OUTSIDE_THE_FALADOR_PARTY_ROOM)
			.location(new ClueArea(3036, 3371, 3055, 3385, 0))
			.firstEmote(DANCE)
			.itemRequirement(item(STEEL_FULL_HELM))
			.itemRequirement(item(STEEL_PLATEBODY))
			.itemRequirement(item(IRON_PLATESKIRT))
			.build(),
		EmoteClue.builder()
			.text("Dance in the shack in Lumbridge Swamp. Equip a bronze dagger, iron full helmet and a gold ring.")
			.clueId(CLUE_SCROLL_EASY_10180)
			.area("Lumbridge swamp")
			.stashUnit(NEAR_A_SHED_IN_LUMBRIDGE_SWAMP)
			.location(new ClueArea(3202, 3168, 3204, 3170, 0))
			.firstEmote(DANCE)
			.itemRequirement(item(BRONZE_DAGGER))
			.itemRequirement(item(IRON_FULL_HELM))
			.itemRequirement(item(GOLD_RING))
			.build(),
		EmoteClue.builder()
			.text("Do a jig in Varrock's rune store. Equip an air tiara and a staff of water.")
			.clueId(CLUE_SCROLL_EASY_19833)
			.area("Varrock rune store")
			.stashUnit(AUBURYS_SHOP_IN_VARROCK)
			.location(new ClueArea(3252, 3399, 3254, 3404, 0))
			.firstEmote(JIG)
			.itemRequirement(item(AIR_TIARA))
			.itemRequirement(item(STAFF_OF_WATER))
			.build(),
		EmoteClue.builder()
			.text("Headbang in the mine north of Al Kharid. Equip a desert shirt, leather gloves and leather boots.")
			.clueId(CLUE_SCROLL_EASY_10194)
			.area("Al Kharid mine")
			.stashUnit(AL_KHARID_SCORPION_MINE)
			.location(new ClueArea(3290, 3274, 3306, 3317, 0))
			.firstEmote(HEADBANG)
			.itemRequirement(item(DESERT_SHIRT))
			.itemRequirement(item(LEATHER_GLOVES))
			.itemRequirement(item(LEATHER_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy at the beehives. Equip a desert shirt, green gnome robe bottoms and a steel axe.")
			.clueId(CLUE_SCROLL_EASY_10214)
			.area("Catherby")
			.stashUnit(CATHERBY_BEEHIVE_FIELD)
			.location(new ClueArea(2752, 3437, 2766, 3450, 0))
			.firstEmote(JUMP_FOR_JOY)
			.itemRequirement(item(DESERT_SHIRT))
			.itemRequirement(item(GREEN_ROBE_BOTTOMS))
			.itemRequirement(item(STEEL_AXE))
			.build(),
		EmoteClue.builder()
			.text("Laugh at the crossroads south of the Sinclair Mansion. Equip a cowl, a blue wizard robe top and an iron scimitar.")
			.clueId(CLUE_SCROLL_EASY_10226)
			.area("Sinclair Mansion")
			.stashUnit(ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION)
			.location(new ClueArea(2737, 3533, 2744, 3541, 0))
			.firstEmote(LAUGH)
			.itemRequirement(item(LEATHER_COWL))
			.itemRequirement(item(BLUE_WIZARD_ROBE))
			.itemRequirement(item(IRON_SCIMITAR))
			.build(),
		EmoteClue.builder()
			.text("Panic in the Limestone Mine. Equip bronze platelegs, a steel pickaxe and a steel medium helmet.")
			.clueId(CLUE_SCROLL_EASY_10186)
			.area("Limestone Mine")
			.stashUnit(LIMESTONE_MINE)
			.location(new ClueArea(3367, 3497, 3374, 3502, 0))
			.firstEmote(PANIC)
			.itemRequirement(item(BRONZE_PLATELEGS))
			.itemRequirement(item(STEEL_PICKAXE))
			.itemRequirement(item(STEEL_MED_HELM))
			.build(),
		EmoteClue.builder()
			.text("Panic on the pier where you catch the Fishing trawler. Have nothing equipped at all when you do.")
			.clueId(CLUE_SCROLL_EASY_10224)
			.area("Fishing trawler")
			.location(new ClueArea(2676, 3163, 2676, 3173, 0))
			.firstEmote(PANIC)
			.itemRequirement(emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO))
			.build(),
		EmoteClue.builder()
			.text("Shrug in the mine near Rimmington. Equip a gold necklace, a gold ring and a bronze spear.")
			.clueId(CLUE_SCROLL_EASY_10202)
			.area("Rimmington mine")
			.stashUnit(RIMMINGTON_MINE)
			.location(new ClueArea(2970, 3228, 2989, 3251, 0))
			.firstEmote(SHRUG)
			.itemRequirement(item(GOLD_NECKLACE))
			.itemRequirement(item(GOLD_RING))
			.itemRequirement(item(BRONZE_SPEAR))
			.build(),
		EmoteClue.builder()
			.text("Spin at the crossroads north of Rimmington. Equip a green gnome hat, cream gnome top and leather chaps.")
			.clueId(CLUE_SCROLL_EASY_10218)
			.area("Rimmington")
			.stashUnit(ROAD_JUNCTION_NORTH_OF_RIMMINGTON)
			.location(new ClueArea(2979, 3274, 2984, 3278, 0))
			.firstEmote(SPIN)
			.itemRequirement(item(GREEN_HAT))
			.itemRequirement(item(CREAM_ROBE_TOP))
			.itemRequirement(item(LEATHER_CHAPS))
			.build(),
		EmoteClue.builder()
			.text("Spin in Draynor Manor by the fountain. Equip an iron platebody, studded leather chaps and a bronze full helmet.")
			.clueId(CLUE_SCROLL_EASY_10196)
			.area("Draynor Manor")
			.stashUnit(DRAYNOR_MANOR_BY_THE_FOUNTAIN)
			.location(new ClueArea(3085, 3332, 3090, 3337, 0))
			.firstEmote(SPIN)
			.itemRequirement(item(IRON_PLATEBODY))
			.itemRequirement(item(STUDDED_CHAPS))
			.itemRequirement(item(BRONZE_FULL_HELM))
			.build(),
		EmoteClue.builder()
			.text("Spin in the Varrock Castle courtyard. Equip a black axe, a coif and a ruby ring.")
			.clueId(CLUE_SCROLL_EASY_12162)
			.area("Varrock Castle")
			.stashUnit(OUTSIDE_VARROCK_PALACE_COURTYARD)
			.location(new ClueArea(3208, 3459, 3217, 3466, 0))
			.firstEmote(SPIN)
			.itemRequirement(item(BLACK_AXE))
			.itemRequirement(item(COIF))
			.itemRequirement(item(RUBY_RING))
			.build(),
		EmoteClue.builder()
			.text("Think in middle of the wheat field by the Lumbridge mill. Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.")
			.clueId(CLUE_SCROLL_EASY_10198)
			.area("Lumbridge mill")
			.stashUnit(WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL)
			.location(new ClueArea(3155, 3295, 3160, 3302, 0))
			.firstEmote(THINK)
			.itemRequirement(item(BLUE_ROBE_TOP))
			.itemRequirement(item(TURQUOISE_ROBE_BOTTOMS))
			.itemRequirement(item(OAK_SHORTBOW))
			.build(),
		EmoteClue.builder()
			.text("Wave along the south fence of the Lumber Yard. Equip a hard leather body, leather chaps and a bronze axe.")
			.clueId(CLUE_SCROLL_EASY_10230)
			.area("Lumber Yard")
			.stashUnit(NEAR_THE_SAWMILL_OPERATORS_BOOTH)
			.location(new ClueArea(3300, 3488, 3313, 3492, 0))
			.firstEmote(WAVE)
			.itemRequirement(item(HARDLEATHER_BODY))
			.itemRequirement(item(LEATHER_CHAPS))
			.itemRequirement(item(BRONZE_AXE))
			.build(),
		EmoteClue.builder()
			.text("Wave in the Falador gem store. Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.")
			.clueId(CLUE_SCROLL_EASY_12164)
			.area("Falador")
			.stashUnit(NEAR_HERQUINS_SHOP_IN_FALADOR)
			.location(new ClueArea(2944, 3332, 2946, 3337, 0))
			.firstEmote(WAVE)
			.itemRequirement(item(MITHRIL_PICKAXE))
			.itemRequirement(item(BLACK_PLATEBODY))
			.itemRequirement(item(IRON_KITESHIELD))
			.build(),
		EmoteClue.builder()
			.text("Wave on Mudskipper Point. Equip a black cape, leather chaps and a steel mace.")
			.clueId(CLUE_SCROLL_EASY_10190)
			.area("Mudskipper Point")
			.stashUnit(MUDSKIPPER_POINT)
			.location(new ClueArea(2981, 3106, 3005, 3130, 0))
			.firstEmote(WAVE)
			.itemRequirement(item(BLACK_CAPE))
			.itemRequirement(item(LEATHER_CHAPS))
			.itemRequirement(item(STEEL_MACE))
			.build(),
		EmoteClue.builder()
			.text("Yawn in Draynor Marketplace. Equip studded leather chaps, an iron kiteshield and a steel longsword.")
			.clueId(CLUE_SCROLL_EASY_10184)
			.area("Draynor")
			.stashUnit(DRAYNOR_VILLAGE_MARKET)
			.location(new ClueArea(3075, 3245, 3086, 3255, 0))
			.firstEmote(YAWN)
			.itemRequirement(item(STUDDED_CHAPS))
			.itemRequirement(item(IRON_KITESHIELD))
			.itemRequirement(item(STEEL_LONGSWORD))
			.build(),
		EmoteClue.builder()
			.text("Yawn in the Varrock library. Equip a green gnome robe top, HAM robe bottom and an iron warhammer.")
			.clueId(CLUE_SCROLL_EASY_10204)
			.area("Varrock Castle")
			.stashUnit(VARROCK_PALACE_LIBRARY)
			.location(new ClueArea(3207, 3490, 3214, 3497, 0))
			.firstEmote(YAWN)
			.itemRequirement(item(GREEN_ROBE_TOP))
			.itemRequirement(item(HAM_ROBE))
			.itemRequirement(item(IRON_WARHAMMER))
			.build(),

		// Medium
		EmoteClue.builder()
			.text("Beckon in Tai Bwo Wannai. Clap before you talk to me. Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.")
			.clueId(CLUE_SCROLL_MEDIUM_10260)
			.area("Tai Bwo Wannai")
			.stashUnit(SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE)
			.location(new ClueArea(2777, 3059, 2810, 3073, 0))
			.firstEmote(BECKON)
			.secondEmote(CLAP)
			.itemRequirement(item(GREEN_DHIDE_CHAPS))
			.itemRequirement(any("Ring of dueling", item(RING_OF_DUELING1), item(RING_OF_DUELING2), item(RING_OF_DUELING3), item(RING_OF_DUELING4), item(RING_OF_DUELING5), item(RING_OF_DUELING6), item(RING_OF_DUELING7), item(RING_OF_DUELING8)))
			.itemRequirement(item(MITHRIL_MED_HELM))
			.build(),
		EmoteClue.builder()
			.text("Beckon in the Shayzien Combat Ring. Show your anger before you talk to me. Equip an adamant platebody, adamant full helm and adamant platelegs.")
			.area("Shayzien Combat Ring")
			.stashUnit(WEST_OF_THE_SHAYZIEN_COMBAT_RING)
			.location(new ClueArea(1539, 3619, 1548, 3627, 0))
			.firstEmote(BECKON)
			.secondEmote(ANGRY)
			.itemRequirement(item(ADAMANT_PLATELEGS))
			.itemRequirement(item(ADAMANT_PLATEBODY))
			.itemRequirement(item(ADAMANT_FULL_HELM))
			.build(),
		EmoteClue.builder()
			.text("Beckon in the Digsite, near the eastern winch. Bow before you talk to me. Equip a green gnome hat, snakeskin boots and an iron pickaxe.")
			.clueId(CLUE_SCROLL_MEDIUM_10274)
			.area("Digsite")
			.stashUnit(DIGSITE)
			.location(new ClueArea(3367, 3423, 3372, 3430, 0))
			.firstEmote(BECKON)
			.secondEmote(BOW)
			.itemRequirement(item(GREEN_HAT))
			.itemRequirement(item(GREEN_HAT))
			.itemRequirement(item(SNAKESKIN_BOOTS))
			.itemRequirement(item(IRON_PICKAXE))
			.build(),
		EmoteClue.builder()
			.text("Cheer in the Barbarian Agility Arena. Headbang before you talk to me. Equip a steel platebody, maple shortbow and a Wilderness cape.")
			.clueId(CLUE_SCROLL_MEDIUM_10264)
			.area("Barbarian Outpost")
			.stashUnit(BARBARIAN_OUTPOST_OBSTACLE_COURSE)
			.location(new ClueArea(2529, 3542, 2553, 3556, 0))
			.firstEmote(CHEER)
			.secondEmote(HEADBANG)
			.itemRequirement(item(STEEL_PLATEBODY))
			.itemRequirement(item(MAPLE_SHORTBOW))
			.itemRequirement(range("Any team cape", TEAM1_CAPE, TEAM50_CAPE))
			.build(),
		EmoteClue.builder()
			.text("Cheer in the Edgeville general store. Dance before you talk to me. Equip a brown apron, leather boots and leather gloves.")
			.clueId(CLUE_SCROLL_MEDIUM_12031)
			.area("Edgeville")
			.stashUnit(NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE)
			.location(new ClueArea(3076, 3507, 3084, 3513, 0))
			.firstEmote(CHEER)
			.secondEmote(DANCE)
			.itemRequirement(item(BROWN_APRON))
			.itemRequirement(item(LEATHER_BOOTS))
			.itemRequirement(item(LEATHER_GLOVES))
			.build(),
		EmoteClue.builder()
			.text("Cheer in the Ogre Pen in the Training Camp. Show you are angry before you talk to me. Equip a green dragonhide body and chaps and a steel square shield.")
			.clueId(CLUE_SCROLL_MEDIUM_10272)
			.area("King Lathas' camp")
			.stashUnit(OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP)
			.location(new ClueArea(2523, 3373, 2533, 3377, 0))
			.firstEmote(CHEER)
			.secondEmote(ANGRY)
			.itemRequirement(item(GREEN_DHIDE_BODY))
			.itemRequirement(item(GREEN_DHIDE_CHAPS))
			.itemRequirement(item(STEEL_SQ_SHIELD))
			.build(),
		EmoteClue.builder()
			.text("Clap in Seers court house. Spin before you talk to me. Equip an adamant halberd, blue mystic robe bottom and a diamond ring.")
			.area("Seers Village")
			.stashUnit(OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE)
			.location(new ClueArea(2732, 3467, 2739, 3471, 0))
			.firstEmote(CLAP)
			.secondEmote(SPIN)
			.itemRequirement(item(ADAMANT_HALBERD))
			.itemRequirement(item(MYSTIC_ROBE_BOTTOM))
			.itemRequirement(item(DIAMOND_RING))
			.build(),
		EmoteClue.builder()
			.text("Clap your hands north of Mount Karuulm Spin before you talk to me. Equip an adamant warhammer, a ring of life and a pair of mithril boots.")
			.clueId(CLUE_SCROLL_MEDIUM_23046)
			.area("Mount Karuulm")
			.stashUnit(NORTH_OF_MOUNT_KARUULM)
			.location(new ClueArea(1292, 3837, 1323, 3854, 0))
			.firstEmote(CLAP)
			.secondEmote(SPIN)
			.itemRequirement(item(ADAMANT_WARHAMMER))
			.itemRequirement(item(RING_OF_LIFE))
			.itemRequirement(item(MITHRIL_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Cry in the Catherby Ranging shop. Bow before you talk to me. Equip blue gnome boots, a hard leather body and an unblessed silver sickle.")
			.clueId(CLUE_SCROLL_MEDIUM_10276)
			.area("Catherby")
			.stashUnit(HICKTONS_ARCHERY_EMPORIUM)
			.location(new ClueArea(2821, 3441, 2825, 3445, 0))
			.firstEmote(CRY)
			.secondEmote(BOW)
			.itemRequirement(item(BLUE_BOOTS))
			.itemRequirement(item(HARDLEATHER_BODY))
			.itemRequirement(item(SILVER_SICKLE))
			.build(),
		EmoteClue.builder()
			.text("Cry in the Draynor Village jail. Jump for joy before you talk to me. Equip an adamant sword, a sapphire amulet and an adamant plateskirt.")
			.clueId(CLUE_SCROLL_MEDIUM_19780)
			.area("Draynor Village jail")
			.stashUnit(OUTSIDE_DRAYNOR_VILLAGE_JAIL)
			.location(new ClueArea(3121, 3240, 3130, 3246, 0))
			.firstEmote(CRY)
			.secondEmote(JUMP_FOR_JOY)
			.itemRequirement(item(ADAMANT_SWORD))
			.itemRequirement(item(SAPPHIRE_AMULET))
			.itemRequirement(item(ADAMANT_PLATESKIRT))
			.build(),
		EmoteClue.builder()
			.text("Cry on the shore of Catherby beach. Laugh before you talk to me, equip an adamant sq shield, a bone dagger and mithril platebody.")
			.clueId(CLUE_SCROLL_MEDIUM_12027)
			.area("Catherby")
			.stashUnit(OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY)
			.location(new ClueArea(2849, 3424, 2857, 3431, 0))
			.firstEmote(CRY)
			.secondEmote(LAUGH)
			.itemRequirement(item(ADAMANT_SQ_SHIELD))
			.itemRequirement(item(BONE_DAGGER))
			.itemRequirement(item(MITHRIL_PLATEBODY))
			.build(),
		EmoteClue.builder()
			.text("Cry on top of the western tree in the Gnome Agility Arena. Indicate 'no' before you talk to me. Equip a steel kiteshield, ring of forging and green dragonhide chaps.")
			.clueId(CLUE_SCROLL_MEDIUM_10266)
			.area("Gnome Stronghold")
			.stashUnit(GNOME_STRONGHOLD_BALANCING_ROPE)
			.location(new ClueArea(2472, 3418, 2477, 3421, 2))
			.firstEmote(CRY)
			.secondEmote(NO)
			.itemRequirement(item(STEEL_KITESHIELD))
			.itemRequirement(item(RING_OF_FORGING))
			.itemRequirement(item(GREEN_DHIDE_CHAPS))
			.build(),
		EmoteClue.builder()
			.text("Dance a jig under Shantay's Awning. Bow before you talk to me. Equip a pointed blue snail helmet, an air staff and a bronze square shield.")
			.clueId(CLUE_SCROLL_MEDIUM_10278)
			.area("Shantay Pass")
			.stashUnit(SHANTAY_PASS)
			.location(new ClueArea(3301, 3121, 3306, 3126, 0))
			.firstEmote(JIG)
			.secondEmote(BOW)
			.itemRequirement(any("Bruise blue snelm (pointed)", item(BRUISE_BLUE_SNELM_3343)))
			.itemRequirement(item(STAFF_OF_AIR))
			.itemRequirement(item(BRONZE_SQ_SHIELD))
			.build(),
		EmoteClue.builder()
			.text("Dance in the centre of Canifis. Bow before you talk to me. Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.")
			.clueId(CLUE_SCROLL_MEDIUM_10254)
			.area("Canifis")
			.stashUnit(CENTRE_OF_CANIFIS)
			.location(new ClueArea(3485, 3480, 3503, 3496, 0))
			.firstEmote(DANCE)
			.secondEmote(BOW)
			.itemRequirement(item(GREEN_ROBE_TOP))
			.itemRequirement(item(MITHRIL_PLATELEGS))
			.itemRequirement(item(IRON_2H_SWORD))
			.build(),
		EmoteClue.builder()
			.text("Dance in the dark caves beneath Lumbridge Swamp. Blow a kiss before you talk to me. Equip an air staff, Bronze full helm and an amulet of power.")
			.clueId(CLUE_SCROLL_MEDIUM_12021)
			.area("Lumbridge swamp caves")
			.stashUnit(LUMBRIDGE_SWAMP_CAVES)
			.location(new ClueArea(3146, 9540, 3258, 9599, 0))
			.firstEmote(DANCE)
			.secondEmote(BLOW_KISS)
			.firePitVarbits(Varbits.FIRE_PIT_LUMBRIDGE_SWAMP)
			.itemRequirement(item(STAFF_OF_AIR))
			.itemRequirement(item(BRONZE_FULL_HELM))
			.itemRequirement(item(AMULET_OF_POWER))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy in the TzHaar sword shop. Shrug before you talk to me. Equip a Steel longsword, Blue D'hide body and blue mystic gloves.")
			.area("Tzhaar weapon store")
			.stashUnit(TZHAAR_WEAPONS_STORE)
			.location(new ClueArea(2476, 5144, 2479, 5148, 0))
			.firstEmote(JUMP_FOR_JOY)
			.secondEmote(SHRUG)
			.itemRequirement(item(STEEL_LONGSWORD))
			.itemRequirement(item(BLUE_DHIDE_BODY))
			.itemRequirement(item(MYSTIC_GLOVES))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy in Yanille bank. Dance a jig before you talk to me. Equip a brown apron, adamantite medium helmet and snakeskin chaps.")
			.clueId(CLUE_SCROLL_MEDIUM_10268)
			.area("Yanille")
			.stashUnit(OUTSIDE_YANILLE_BANK)
			.location(new ClueArea(2609, 3088, 2613, 3097, 0))
			.firstEmote(JUMP_FOR_JOY)
			.secondEmote(JIG)
			.itemRequirement(item(BROWN_APRON))
			.itemRequirement(item(ADAMANT_MED_HELM))
			.itemRequirement(item(SNAKESKIN_CHAPS))
			.build(),
		EmoteClue.builder()
			.text("Panic by the mausoleum in Morytania. Wave before you speak to me. Equip a mithril plate skirt, a maple longbow and no boots.")
			.clueId(CLUE_SCROLL_MEDIUM_10256)
			.area("Morytania mausoleum, access via the experiments cave")
			.stashUnit(MAUSOLEUM_OFF_THE_MORYTANIA_COAST)
			.location(new ClueArea(3490, 3567, 3514, 3581, 0))
			.firstEmote(PANIC)
			.secondEmote(WAVE)
			.itemRequirement(item(MITHRIL_PLATESKIRT))
			.itemRequirement(item(MAPLE_LONGBOW))
			.itemRequirement(emptySlot("No boots", BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Shrug in Catherby bank. Yawn before you talk to me. Equip a maple longbow, green d'hide chaps and an iron med helm.")
			.clueId(CLUE_SCROLL_MEDIUM_12023)
			.area("Catherby")
			.stashUnit(OUTSIDE_CATHERBY_BANK)
			.location(new ClueArea(2806, 3438, 2812, 3441, 0))
			.firstEmote(SHRUG)
			.secondEmote(YAWN)
			.itemRequirement(item(MAPLE_LONGBOW))
			.itemRequirement(item(GREEN_DHIDE_CHAPS))
			.itemRequirement(item(IRON_MED_HELM))
			.build(),
		EmoteClue.builder()
			.text("Spin on the bridge by the Barbarian Village. Salute before you talk to me. Equip purple gloves, a steel kiteshield and a mithril full helmet.")
			.clueId(CLUE_SCROLL_MEDIUM_10258)
			.area("Barbarian Village")
			.stashUnit(EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE)
			.location(new ClueArea(3103, 3420, 3107, 3421, 0))
			.firstEmote(SPIN)
			.secondEmote(SALUTE)
			.itemRequirement(item(PURPLE_GLOVES))
			.itemRequirement(item(STEEL_KITESHIELD))
			.itemRequirement(item(MITHRIL_FULL_HELM))
			.build(),
		EmoteClue.builder()
			.text("Think in the centre of the Observatory. Spin before you talk to me. Equip a mithril chain body, green dragonhide chaps and a ruby amulet.")
			.clueId(CLUE_SCROLL_MEDIUM_10270)
			.area("Observatory")
			.stashUnit(OBSERVATORY)
			.location(new ClueArea(2438, 3159, 2443, 3164, 0))
			.firstEmote(THINK)
			.secondEmote(SPIN)
			.itemRequirement(item(MITHRIL_CHAINBODY))
			.itemRequirement(item(GREEN_DHIDE_CHAPS))
			.itemRequirement(item(RUBY_AMULET))
			.build(),
		EmoteClue.builder()
			.text("Yawn in the Castle Wars lobby. Shrug before you talk to me. Equip a ruby amulet, a mithril scimitar and a Wilderness cape.")
			.clueId(CLUE_SCROLL_MEDIUM_10262)
			.area("Castle Wars")
			.stashUnit(CASTLE_WARS_BANK)
			.location(new ClueArea(2438, 3082, 2446, 3098, 0))
			.firstEmote(YAWN)
			.secondEmote(SHRUG)
			.itemRequirement(item(RUBY_AMULET))
			.itemRequirement(item(MITHRIL_SCIMITAR))
			.itemRequirement(range("Any team cape", TEAM1_CAPE, TEAM50_CAPE))
			.build(),
		EmoteClue.builder()
			.text("Yawn in the centre of the Arceuus Library. Nod your head before you talk to me. Equip blue dragonhide vambraces, adamant boots and an adamant dagger.")
			.area("Arceuus library")
			.stashUnit(ENTRANCE_OF_THE_ARCEUUS_LIBRARY)
			.location(new ClueArea(1627, 3802, 1638, 3813, 0))
			.firstEmote(YAWN)
			.secondEmote(YES)
			.itemRequirement(item(BLUE_DHIDE_VAMBRACES))
			.itemRequirement(item(ADAMANT_BOOTS))
			.itemRequirement(item(ADAMANT_DAGGER))
			.build(),

		// Hard
		EmoteClue.builder()
			.text("Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.")
			.clueId(CLUE_SCROLL_HARD_12544)
			.area("Kharazi Jungle")
			.stashUnit(NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE)
			.location(new ClueArea(2949, 2883, 2971, 2945, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(BECKON)
			.itemRequirement(any("Any stole", item(GUTHIX_STOLE), item(SARADOMIN_STOLE), item(ZAMORAK_STOLE), item(ARMADYL_STOLE), item(BANDOS_STOLE), item(ANCIENT_STOLE)))
			.itemRequirement(any("Any heraldic rune shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5)))
			.build(),
		EmoteClue.builder()
			.text("Blow a kiss between the tables in Shilo Village bank. Beware of double agents! Equip a blue mystic hat, bone spear and rune platebody.")
			.clueId(CLUE_SCROLL_HARD_10252)
			.area("Shilo Village")
			.stashUnit(SHILO_VILLAGE_BANK)
			.location(new ClueArea(2851, 2952, 2854, 2955, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(BLOW_KISS)
			.itemRequirement(item(MYSTIC_HAT))
			.itemRequirement(item(BONE_SPEAR))
			.itemRequirement(item(RUNE_PLATEBODY))
			.build(),
		EmoteClue.builder()
			.text("Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.")
			.clueId(CLUE_SCROLL_HARD_10236)
			.area("Fishing Guild")
			.stashUnit(FISHING_GUILD_BANK)
			.location(new ClueArea(2588, 3413, 2592, 3419, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(RASPBERRY)
			.itemRequirement(item(ELEMENTAL_SHIELD))
			.itemRequirement(item(BLUE_DHIDE_CHAPS))
			.itemRequirement(item(RUNE_WARHAMMER))
			.build(),
		EmoteClue.builder()
			.text("Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.")
			.clueId(CLUE_SCROLL_HARD_10238)
			.area("Lighthouse")
			.stashUnit(TOP_FLOOR_OF_THE_LIGHTHOUSE)
			.location(new ClueArea(2504, 3637, 2513, 3645, 2))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(BOW)
			.itemRequirement(item(BLUE_DHIDE_BODY))
			.itemRequirement(item(BLUE_DHIDE_VAMBRACES))
			.itemRequirement(emptySlot("No amulet or ring", AMULET, RING))
			.build(),
		EmoteClue.builder()
			.text("Cheer at the top of the agility pyramid. Beware of double agents! Equip a blue mystic robe top, and any rune heraldic shield.")
			.clueId(CLUE_SCROLL_HARD_12550)
			.area("Agility Pyramid")
			.stashUnit(AGILITY_PYRAMID)
			.location(new ClueArea(3042, 4695, 3047, 4700, 3))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(CHEER)
			.itemRequirement(item(MYSTIC_ROBE_TOP))
			.itemRequirement(any("Any rune heraldic shield", item(RUNE_SHIELD_H1), item(RUNE_SHIELD_H2), item(RUNE_SHIELD_H3), item(RUNE_SHIELD_H4), item(RUNE_SHIELD_H5)))
			.build(),
		EmoteClue.builder()
			.text("Dance at the cat-doored pyramid in Sophanem. Beware of double agents! Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.")
			.clueId(CLUE_SCROLL_HARD_10242)
			.area("Pyramid Of Sophanem")
			.stashUnit(OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM)
			.location(new ClueArea(3292, 2780, 3297, 2784, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(DANCE)
			.itemRequirement(item(RING_OF_LIFE))
			.itemRequirement(item(AMULET_OF_GLORY))
			.itemRequirement(item(ADAMANT_2H_SWORD))
			.build(),
		EmoteClue.builder()
			.text("Headbang at the exam centre. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.")
			.clueId(CLUE_SCROLL_HARD_12542)
			.area("Exam Centre")
			.stashUnit(INSIDE_THE_DIGSITE_EXAM_CENTRE)
			.location(new ClueArea(3357, 3332, 3367, 3348, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(HEADBANG)
			.itemRequirement(item(MYSTIC_FIRE_STAFF))
			.itemRequirement(item(DIAMOND_BRACELET))
			.itemRequirement(item(RUNE_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Jig at Jiggig. Beware of double agents! Equip a Rune spear, rune platelegs and any rune heraldic helm.")
			.clueId(CLUE_SCROLL_HARD_12548)
			.area("Jiggig")
			.stashUnit(IN_THE_MIDDLE_OF_JIGGIG)
			.location(new ClueArea(2475, 3041, 2488, 3052, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(JIG)
			.itemRequirement(range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5))
			.itemRequirement(item(RUNE_SPEAR))
			.itemRequirement(item(RUNE_PLATELEGS))
			.build(),
		EmoteClue.builder()
			.text("Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.")
			.clueId(CLUE_SCROLL_HARD_10248)
			.area("Mountain Camp")
			.stashUnit(MOUNTAIN_CAMP_GOAT_ENCLOSURE)
			.location(new ClueArea(2811, 3680, 2813, 3681, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(LAUGH)
			.itemRequirement(item(RUNE_FULL_HELM))
			.itemRequirement(item(BLUE_DHIDE_CHAPS))
			.itemRequirement(item(FIRE_BATTLESTAFF))
			.build(),
		EmoteClue.builder()
			.text("Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.")
			.clueId(CLUE_SCROLL_HARD_10250)
			.area("White Wolf Mountain")
			.stashUnit(GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN)
			.location(new ClueArea(2845, 3497, 2849, 3500, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(PANIC)
			.itemRequirement(item(MITHRIL_PLATELEGS))
			.itemRequirement(item(RING_OF_LIFE))
			.itemRequirement(item(RUNE_AXE))
			.build(),
		EmoteClue.builder()
			.text("Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.")
			.clueId(CLUE_SCROLL_HARD_10240)
			.area("Haunted Woods")
			.location(new ClueArea(3611, 3483, 3621, 3493, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(PANIC)
			.itemRequirement(emptySlot("Nothing at all", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO))
			.build(),
		EmoteClue.builder()
			.text("Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.")
			.clueId(CLUE_SCROLL_HARD_12546)
			.area("Wilderness volcano")
			.stashUnit(VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS)
			.location(new ClueArea(3361, 3935, 3373, 3936, 0))
			.enemy(DOUBLE_AGENT_65)
			.firstEmote(PANIC)
			.itemRequirement(any("Any headband", range(RED_HEADBAND, BROWN_HEADBAND), range(WHITE_HEADBAND, GREEN_HEADBAND)))
			.itemRequirement(any("Any crozier", item(ANCIENT_CROZIER), item(ARMADYL_CROZIER), item(BANDOS_CROZIER), range(SARADOMIN_CROZIER, ZAMORAK_CROZIER)))
			.build(),
		EmoteClue.builder()
			.text("Salute in the banana plantation. Beware of double agents! Equip a diamond ring, amulet of power, and nothing on your chest and legs.")
			.clueId(CLUE_SCROLL_HARD_10246)
			.area("Karamja")
			.stashUnit(WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION)
			.location(new ClueArea(2909, 3155, 2932, 3174, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(SALUTE)
			.itemRequirement(item(DIAMOND_RING))
			.itemRequirement(item(AMULET_OF_POWER))
			.itemRequirement(emptySlot("No chest or legs", BODY, LEGS))
			.build(),
		EmoteClue.builder()
			.text("Salute in the centre of the mess hall. Beware of double agents! Equip a rune halberd rune platebody, and an amulet of strength.")
			.clueId(CLUE_SCROLL_HARD_12552)
			.area("Hosidius mess hall")
			.stashUnit(HOSIDIUS_MESS)
			.location(new ClueArea(1644, 3624, 1648, 3636, 0))
			.enemy(DOUBLE_AGENT_108)
			.firstEmote(SALUTE)
			.itemRequirement(item(RUNE_HALBERD))
			.itemRequirement(item(RUNE_PLATEBODY))
			.itemRequirement(item(AMULET_OF_STRENGTH))
			.build(),
		EmoteClue.builder()
			.text("Shrug in the Zamorak temple found in the Eastern Wilderness. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.")
			.clueId(CLUE_SCROLL_HARD_10234)
			.area("Chaos temple")
			.stashUnit(CHAOS_TEMPLE_IN_THE_SOUTHEASTERN_WILDERNESS)
			.location(new ClueArea(3236, 3605, 3242, 3614, 0))
			.enemy(DOUBLE_AGENT_65)
			.firstEmote(SHRUG)
			.itemRequirement(item(RUNE_PLATELEGS))
			.itemRequirement(item(IRON_PLATEBODY))
			.itemRequirement(item(BLUE_DHIDE_VAMBRACES))
			.build(),
		EmoteClue.builder()
			.text("Yawn in the rogues' general store. Beware of double agents! Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.")
			.clueId(CLUE_SCROLL_HARD_10244)
			.area("Rogues general store")
			.stashUnit(NOTERAZZOS_SHOP_IN_THE_WILDERNESS)
			.location(new ClueArea(3024, 3699, 3027, 3704, 0))
			.enemy(DOUBLE_AGENT_65)
			.firstEmote(YAWN)
			.itemRequirement(item(ADAMANT_SQ_SHIELD))
			.itemRequirement(item(BLUE_DHIDE_VAMBRACES))
			.itemRequirement(item(RUNE_PICKAXE))
			.build(),

		// Elite
		EmoteClue.builder()
			.text("Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.")
			.clueId(CLUE_SCROLL_ELITE_12075)
			.area("Lava maze")
			.stashUnit(NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE)
			.location(new ClueArea(3064, 3856, 3071, 3863, 0))
			.firstEmote(BLOW_KISS)
			.itemRequirement(item(BLACK_DHIDE_CHAPS))
			.itemRequirement(any("Spotted cape", item(SPOTTED_CAPE), item(SPOTTED_CAPE_10073)))
			.itemRequirement(item(ROLLING_PIN))
			.build(),
		EmoteClue.builder()
			.text("Bow on the ground floor of the Legend's guild. Equip Legend's cape, a dragon battleaxe and an amulet of glory.")
			.clueId(CLUE_SCROLL_ELITE_19789)
			.area("Legends' Guild")
			.stashUnit(OUTSIDE_THE_LEGENDS_GUILD_DOOR)
			// Needs full area
			.location(new ClueArea(2728, 3377, 0))
			.firstEmote(BOW)
			.itemRequirement(item(CAPE_OF_LEGENDS))
			.itemRequirement(item(DRAGON_BATTLEAXE))
			.itemRequirement(any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6)))
			.build(),
		// TODO: God books (or)
		EmoteClue.builder()
			.text("Bow upstairs in the Edgeville Monastery. Equip a completed prayer book.")
			.clueId(CLUE_SCROLL_ELITE_12078)
			.area("Edgeville Monastery")
			.stashUnit(SOUTHEAST_CORNER_OF_THE_MONASTERY)
			.location(new ClueArea(3044, 3482, 3059, 3499, 1))
			.firstEmote(BOW)
			.itemRequirement(any("Any god book", item(HOLY_BOOK), item(BOOK_OF_BALANCE), item(UNHOLY_BOOK), item(BOOK_OF_LAW), item(BOOK_OF_WAR), item(BOOK_OF_DARKNESS)))
			.build(),
		// TODO: RCB (or)
		EmoteClue.builder()
			.text("Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.")
			.clueId(CLUE_SCROLL_ELITE_12076)
			.area("Shadow dungeon")
			.stashUnit(ENTRANCE_OF_THE_CAVE_OF_DAMIS)
			.location(new ClueArea(2625, 5057, 2749, 5118, 0))
			.firstEmote(CHEER)
			.itemRequirement(any("Any mitre", item(GUTHIX_MITRE), item(SARADOMIN_MITRE), item(ZAMORAK_MITRE), item(ANCIENT_MITRE), item(BANDOS_MITRE), item(ARMADYL_MITRE)))
			.itemRequirement(item(RUNE_CROSSBOW))
			.itemRequirement(item(CLIMBING_BOOTS))
			// Not emote item
			.itemRequirement(item(RING_OF_VISIBILITY))
			.build(),
		EmoteClue.builder()
			.text("Dance on the Fishing Platform. Equip barrows gloves, an amulet of glory and a dragon med helm.")
			.clueId(CLUE_SCROLL_ELITE_12079)
			.area("Fishing Platform")
			.stashUnit(SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM)
			.location(new ClueArea(2762, 3273, 2794, 3291, 0))
			.firstEmote(DANCE)
			.itemRequirement(any("Any amulet of glory", item(AMULET_OF_GLORY), item(AMULET_OF_GLORY1), item(AMULET_OF_GLORY2), item(AMULET_OF_GLORY3), item(AMULET_OF_GLORY4), item(AMULET_OF_GLORY5), item(AMULET_OF_GLORY6)))
			.itemRequirement(item(BARROWS_GLOVES))
			.itemRequirement(item(DRAGON_MED_HELM))
			.build(),
		EmoteClue.builder()
			.text("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.")
			.clueId(CLUE_SCROLL_ELITE_12080)
			.area("Slayer Tower")
			.stashUnit(OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM)
			.location(new ClueArea(3405, 3531, 3452, 3579, 2))
			.firstEmote(HEADBANG)
			.itemRequirement(item(SEERCULL))
			.itemRequirement(range("Combat bracelet", COMBAT_BRACELET4, COMBAT_BRACELET))
			.itemRequirement(item(HELM_OF_NEITIZNOT))
			.build(),
		EmoteClue.builder()
			.text("Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.")
			.clueId(CLUE_SCROLL_ELITE_19791)
			.area("Fight Arena pub")
			.stashUnit(OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA)
			.location(new ClueArea(2563, 3139, 2570, 3150, 0))
			.firstEmote(HEADBANG)
			.itemRequirement(any("Any pirate bandana", item(PIRATE_BANDANA), item(PIRATE_BANDANA_7124), item(PIRATE_BANDANA_7130), item(PIRATE_BANDANA_7136)))
			.itemRequirement(item(DRAGON_NECKLACE))
			.itemRequirement(item(MAGIC_LONGBOW))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.")
			.clueId(CLUE_SCROLL_ELITE_12074)
			.area("Fremennik Isles")
			.stashUnit(NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES)
			.location(new ClueArea(2373, 3848, 2377, 3852, 0))
			.firstEmote(JUMP_FOR_JOY)
			.itemRequirement(item(RUNE_BOOTS))
			.itemRequirement(item(PROSELYTE_HAUBERK))
			.itemRequirement(item(DRAGONSTONE_RING))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body and any rune heraldic helm.")
			.clueId(CLUE_SCROLL_ELITE_12083)
			.area("Ancient cavern")
			.stashUnit(ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL)
			.location(new ClueArea(1734, 5319, 1789, 5367, 0, 1))
			.firstEmote(JUMP_FOR_JOY)
			.itemRequirement(item(GRANITE_SHIELD))
			.itemRequirement(item(SPLITBARK_BODY))
			.itemRequirement(range("Any rune heraldic helm", RUNE_HELM_H1, RUNE_HELM_H5))
			.build(),
		EmoteClue.builder()
			.text("Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.")
			.clueId(CLUE_SCROLL_ELITE_12082)
			.area("Fountain of heroes")
			.stashUnit(FOUNTAIN_OF_HEROES)
			.location(new ClueArea(2914, 9891, 2921, 9896, 0))
			.firstEmote(LAUGH)
			.itemRequirement(item(SPLITBARK_LEGS))
			.itemRequirement(any("Dragon boots", item(DRAGON_BOOTS), item(DRAGON_BOOTS_G)))
			.itemRequirement(item(RUNE_LONGSWORD))
			.build(),
		EmoteClue.builder()
			.text("Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.")
			.clueId(CLUE_SCROLL_ELITE_19790)
			.area("Ardougne")
			.stashUnit(NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET)
			.location(new ClueArea(2664, 3301, 2671, 3306, 0))
			.firstEmote(LAUGH)
			.itemRequirement(any("Castle wars bracelet", range(CASTLE_WARS_BRACELET3, CASTLE_WARS_BRACELET1)))
			.itemRequirement(item(DRAGONSTONE_AMULET))
			.itemRequirement(item(RING_OF_FORGING))
			.build(),
		EmoteClue.builder()
			.text("Panic at the area flowers meet snow. Equip Blue D'hide vambraces, a dragon spear and a rune plateskirt.")
			.clueId(CLUE_SCROLL_ELITE_19787)
			.area("Trollweiss mountain")
			.stashUnit(HALFWAY_DOWN_TROLLWEISS_MOUNTAIN)
			.location(new ClueArea(2774, 3779, 2782, 3786, 0))
			.firstEmote(PANIC)
			.itemRequirement(item(BLUE_DHIDE_VAMBRACES))
			.itemRequirement(item(DRAGON_SPEAR))
			.itemRequirement(item(RUNE_PLATESKIRT))
			// Not a clue item
			.itemRequirement(item(SLED_4084))
			.build(),
		EmoteClue.builder()
			.text("Salute in the Warriors' guild bank. Equip only a black salamander.")
			.area("Warriors' guild")
			.stashUnit(WARRIORS_GUILD_BANK)
			.location(new ClueArea(2843, 3537, 2848, 3545, 0))
			.firstEmote(SALUTE)
			.itemRequirement(item(BLACK_SALAMANDER))
			.itemRequirement(emptySlot("Nothing else", HEAD, CAPE, AMULET, BODY, SHIELD, LEGS, GLOVES, BOOTS, RING, AMMO))
			.build(),
		EmoteClue.builder()
			.text("Shrug in the Shayzien war tent. Equip a blue mystic robe bottom, a rune kiteshield and any bob shirt.")
			.area("Shayzien war tent")
			.stashUnit(SHAYZIEN_WAR_TENT)
			// Needs full area
			.location(new ClueArea(1487, 3635, 0))
			.firstEmote(SHRUG)
			.itemRequirement(item(MYSTIC_ROBE_BOTTOM))
			.itemRequirement(item(RUNE_KITESHIELD))
			.itemRequirement(range("Any bob shirt", BOBS_RED_SHIRT, BOBS_PURPLE_SHIRT))
			.build(),
		EmoteClue.builder()
			.text("Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.")
			.clueId(CLUE_SCROLL_ELITE) // 12073
			.area("West Ardougne Church")
			.stashUnit(CHAPEL_IN_WEST_ARDOUGNE)
			.location(new ClueArea(2524, 3285, 2532, 3295, 0))
			.firstEmote(SPIN)
			.itemRequirement(item(DRAGON_SPEAR))
			.itemRequirement(item(RED_DHIDE_CHAPS))
			.build(),
		EmoteClue.builder()
			.text("Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.")
			.clueId(CLUE_SCROLL_ELITE_12081)
			.area("Trollheim Mountain")
			.stashUnit(ON_TOP_OF_TROLLHEIM_MOUNTAIN)
			.location(new ClueArea(2886, 3673, 2895, 3682, 0))
			.firstEmote(YAWN)
			.itemRequirement(any("Lava battlestaff", item(LAVA_BATTLESTAFF), item(LAVA_BATTLESTAFF_21198)))
			.itemRequirement(item(BLACK_DHIDE_VAMBRACES))
			.itemRequirement(item(MIND_SHIELD))
			.build(),
		EmoteClue.builder()
			.text("Salute by the Charcoal Burners. Equip a Farmer's strawhat, Shayzien platebody (5) and Pyromancer robes.")
			.clueId(CLUE_SCROLL_ELITE_25786)
			.area("Hosidius, charcoal burners")
			.stashUnit(CHARCOAL_BURNERS)
			.location(new ClueArea(1711, 3463, 1721, 3468, 0))
			.firstEmote(SALUTE)
			.itemRequirement(any("Farmer's strawhat", item(FARMERS_STRAWHAT), item(FARMERS_STRAWHAT_13647)))
			.itemRequirement(item(SHAYZIEN_BODY_5))
			.itemRequirement(item(PYROMANCER_ROBE))
			.build(),

		// Master
		EmoteClue.builder()
			.text("Beckon by a collection of crystalline maple trees. Beware of double agents! Equip Bryophyta's staff and a nature tiara.")
			.area("North of Prifddinas")
			.stashUnit(CRYSTALLINE_MAPLE_TREES)
			// Needs full area
			.location(new ClueArea(2208, 3424, 2212, 3428, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(BECKON)
			.itemRequirement(range("Bryophyta's staff", BRYOPHYTAS_STAFF_UNCHARGED, BRYOPHYTAS_STAFF))
			.itemRequirement(item(NATURE_TIARA))
			.build(),
		EmoteClue.builder()
			.text("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword.")
			.area("K'ril's chamber")
			.stashUnit(OUTSIDE_KRIL_TSUTSAROTHS_ROOM)
			// Needs full area
			.location(new ClueArea(2925, 5333, 2))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(BLOW_KISS)
			.itemRequirement(item(ZAMORAK_FULL_HELM))
			.itemRequirement(item(SHADOW_SWORD))
			.build(),
		EmoteClue.builder()
			.text("Blow a raspberry in the bank of the Warriors' Guild. Beware of double agents! Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.")
			.area("Warriors' guild")
			.stashUnit(WARRIORS_GUILD_BANK_29047)
			.location(new ClueArea(2843, 3537, 2848, 3545, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(RASPBERRY)
			.itemRequirement(item(DRAGON_BATTLEAXE))
			.itemRequirement(any("Dragon defender or Avernic defender", item(DRAGON_DEFENDER), item(DRAGON_DEFENDER_T), item(DRAGON_DEFENDER_L), item(AVERNIC_DEFENDER), item(AVERNIC_DEFENDER_L)))
			.itemRequirement(any("Any slayer helmet", item(SLAYER_HELMET), item(BLACK_SLAYER_HELMET), item(GREEN_SLAYER_HELMET), item(PURPLE_SLAYER_HELMET), item(RED_SLAYER_HELMET), item(TURQUOISE_SLAYER_HELMET), item(SLAYER_HELMET_I), item(BLACK_SLAYER_HELMET_I), item(GREEN_SLAYER_HELMET_I), item(PURPLE_SLAYER_HELMET_I), item(RED_SLAYER_HELMET_I), item(TURQUOISE_SLAYER_HELMET_I), item(HYDRA_SLAYER_HELMET), item(HYDRA_SLAYER_HELMET_I), item(TWISTED_SLAYER_HELMET), item(TWISTED_SLAYER_HELMET_I), item(SLAYER_HELMET_I_25177), item(BLACK_SLAYER_HELMET_I_25179), item(GREEN_SLAYER_HELMET_I_25181), item(RED_SLAYER_HELMET_I_25183), item(PURPLE_SLAYER_HELMET_I_25185), item(TURQUOISE_SLAYER_HELMET_I_25187), item(HYDRA_SLAYER_HELMET_I_25189), item(TWISTED_SLAYER_HELMET_I_25191)))
			.build(),
		EmoteClue.builder()
			.text("Bow in the Iorwerth Camp. Beware of double agents! Equip a charged crystal bow.")
			.area("Lord Iorwerth's camp")
			.stashUnit(TENT_IN_LORD_IORWERTHS_ENCAMPMENT)
			// Needs full area
			.location(new ClueArea(2205, 3252, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(BOW)
			.itemRequirement(any("Crystal Bow", item(CRYSTAL_BOW), item(CRYSTAL_BOW_24123)))
			.build(),
		EmoteClue.builder()
			.text("Cheer in the Entrana church. Beware of double agents! Equip a full set of black dragonhide armour.")
			.area("Entrana church")
			.stashUnit(ENTRANA_CHAPEL)
			.location(new ClueArea(2841, 3345, 2857, 3351, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(CHEER)
			.itemRequirement(item(BLACK_DHIDE_VAMBRACES))
			.itemRequirement(item(BLACK_DHIDE_CHAPS))
			.itemRequirement(item(BLACK_DHIDE_BODY))
			.build(),
		EmoteClue.builder()
			.text("Clap in the magic axe hut. Beware of double agents! Equip only some flared trousers.")
			.area("Magic axe hut")
			.stashUnit(OUTSIDE_THE_WILDERNESS_AXE_HUT)
			.location(new ClueArea(3187, 3958, 3194, 3962, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(CLAP)
			.itemRequirement(item(FLARED_TROUSERS))
			.itemRequirement(emptySlot("Nothing else", HEAD, CAPE, AMULET, WEAPON, BODY, SHIELD, GLOVES, BOOTS, RING, AMMO))
			// Not an emote item
			.itemRequirement(item(LOCKPICK))
			.build(),
		EmoteClue.builder()
			.text("Cry in the TzHaar gem store. Beware of double agents! Equip a fire cape and TokTz-Xil-Ul.")
			.area("Tzhaar gem store")
			.stashUnit(TZHAAR_GEM_STORE)
			.location(new ClueArea(2463, 5147, 2466, 5150, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(CRY)
			.itemRequirement(any("Fire cape", item(FIRE_CAPE), item(FIRE_CAPE_L), item(FIRE_MAX_CAPE), item(FIRE_MAX_CAPE_L), item(INFERNAL_CAPE), item(INFERNAL_CAPE_L), item(INFERNAL_MAX_CAPE_21285), item(INFERNAL_MAX_CAPE_L)))
			.itemRequirement(item(TOKTZXILUL))
			.build(),
		EmoteClue.builder()
			.text("Dance in Iban's temple. Beware of double agents! Equip Iban's staff, a black mystic top and a black mystic bottom.")
			.area("Iban's temple")
			.stashUnit(WELL_OF_VOYAGE)
			// Needs full area
			.location(new ClueArea(2006, 4709, 2013, 4716, 1))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(DANCE)
			.itemRequirement(any("Iban's staff", item(IBANS_STAFF), item(IBANS_STAFF_U)))
			.itemRequirement(item(MYSTIC_ROBE_TOP_DARK))
			.itemRequirement(item(MYSTIC_ROBE_BOTTOM_DARK))
			.build(),
		EmoteClue.builder()
			.text("Dance in the King Black Dragon's lair. Beware of double agents! Equip a black dragonhide body, black dragonhide vambraces and a black dragon mask.")
			.area("King black dragon's lair")
			.stashUnit(KING_BLACK_DRAGONS_LAIR)
			.location(new ClueArea(2256, 4680, 2287, 4711, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(DANCE)
			.itemRequirement(item(BLACK_DHIDE_BODY))
			.itemRequirement(item(BLACK_DHIDE_VAMBRACES))
			.itemRequirement(item(BLACK_DRAGON_MASK))
			.build(),
		EmoteClue.builder()
			.text("Do a jig at the barrows chest. Beware of double agents! Equip any full barrows set.")
			.area("Barrows chest")
			.stashUnit(BARROWS_CHEST)
			// Needs full area
			.location(new ClueArea(3547, 9690, 3556, 9699, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(JIG)
			.itemRequirement(any("Any full barrows set", all(any("Ahrim's hood", item(AHRIMS_HOOD), range(AHRIMS_HOOD_100, AHRIMS_HOOD_0)), any("Ahrim's staff", item(AHRIMS_STAFF), range(AHRIMS_STAFF_100, AHRIMS_STAFF_0)), any("Ahrim's robetop", item(AHRIMS_ROBETOP), range(AHRIMS_ROBETOP_100, AHRIMS_ROBETOP_0)), any("Ahrim's robeskirt", item(AHRIMS_ROBESKIRT), range(AHRIMS_ROBESKIRT_100, AHRIMS_ROBESKIRT_0))), all(any("Dharok's helm", item(DHAROKS_HELM), range(DHAROKS_HELM_100, DHAROKS_HELM_0)), any("Dharok's greataxe", item(DHAROKS_GREATAXE), range(DHAROKS_GREATAXE_100, DHAROKS_GREATAXE_0)), any("Dharok's platebody", item(DHAROKS_PLATEBODY), range(DHAROKS_PLATEBODY_100, DHAROKS_PLATEBODY_0)), any("Dharok's platelegs", item(DHAROKS_PLATELEGS), range(DHAROKS_PLATELEGS_100, DHAROKS_PLATELEGS_0))), all(any("Guthan's helm", item(GUTHANS_HELM), range(GUTHANS_HELM_100, GUTHANS_HELM_0)), any("Guthan's warspear", item(GUTHANS_WARSPEAR), range(GUTHANS_WARSPEAR_100, GUTHANS_WARSPEAR_0)), any("Guthan's platebody", item(GUTHANS_PLATEBODY), range(GUTHANS_PLATEBODY_100, GUTHANS_PLATEBODY_0)), any("Guthan's chainskirt", item(GUTHANS_CHAINSKIRT), range(GUTHANS_CHAINSKIRT_100, GUTHANS_CHAINSKIRT_0))), all(any("Karil's coif", item(KARILS_COIF), range(KARILS_COIF_100, KARILS_COIF_0)), any("Karil's crossbow", item(KARILS_CROSSBOW), range(KARILS_CROSSBOW_100, KARILS_CROSSBOW_0)), any("Karil's leathertop", item(KARILS_LEATHERTOP), range(KARILS_LEATHERTOP_100, KARILS_LEATHERTOP_0)), any("Karil's leatherskirt", item(KARILS_LEATHERSKIRT), range(KARILS_LEATHERSKIRT_100, KARILS_LEATHERSKIRT_0))), all(any("Torag's helm", item(TORAGS_HELM), range(TORAGS_HELM_100, TORAGS_HELM_0)), any("Torag's hammers", item(TORAGS_HAMMERS), range(TORAGS_HAMMERS_100, TORAGS_HAMMERS_0)), any("Torag's platebody", item(TORAGS_PLATEBODY), range(TORAGS_PLATEBODY_100, TORAGS_PLATEBODY_0)), any("Torag's platelegs", item(TORAGS_PLATELEGS), range(TORAGS_PLATELEGS_100, TORAGS_PLATELEGS_0))), all(any("Verac's helm", item(VERACS_HELM), range(VERACS_HELM_100, VERACS_HELM_0)), any("Verac's flail", item(VERACS_FLAIL), range(VERACS_FLAIL_100, VERACS_FLAIL_0)), any("Verac's brassard", item(VERACS_BRASSARD), range(VERACS_BRASSARD_100, VERACS_BRASSARD_0)), any("Verac's plateskirt", item(VERACS_PLATESKIRT), range(VERACS_PLATESKIRT_100, VERACS_PLATESKIRT_0)))))
			.build(),
		EmoteClue.builder()
			.text("Flap at the death altar. Beware of double agents! Equip a death tiara, a legend's cape and any ring of wealth.")
			.area("Death altar")
			.stashUnit(DEATH_ALTAR)
			.location(new ClueArea(2200, 4831, 2211, 4842, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(FLAP)
			.itemRequirement(any("Any ring of wealth", item(RING_OF_WEALTH), item(RING_OF_WEALTH_1), item(RING_OF_WEALTH_2), item(RING_OF_WEALTH_3), item(RING_OF_WEALTH_4), item(RING_OF_WEALTH_5), item(RING_OF_WEALTH_I), item(RING_OF_WEALTH_I1), item(RING_OF_WEALTH_I2), item(RING_OF_WEALTH_I3), item(RING_OF_WEALTH_I4), item(RING_OF_WEALTH_I5)))
			.itemRequirement(item(DEATH_TIARA))
			.itemRequirement(item(CAPE_OF_LEGENDS))
			.build(),
		EmoteClue.builder()
			.text("Goblin Salute in the Goblin Village. Beware of double agents! Equip a bandos godsword, a bandos cloak and a bandos platebody.")
			.area("Goblin Village")
			.stashUnit(OUTSIDE_MUDKNUCKLES_HUT)
			// Needs full area
			.location(new ClueArea(2956, 3505, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(GOBLIN_SALUTE)
			.itemRequirement(item(BANDOS_PLATEBODY))
			.itemRequirement(item(BANDOS_CLOAK))
			.itemRequirement(any("Bandos godsword", item(BANDOS_GODSWORD), item(BANDOS_GODSWORD_OR)))
			.build(),
		EmoteClue.builder()
			.text("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.")
			.area("Zul-Andra")
			.stashUnit(NEAR_THE_PIER_IN_ZULANDRA)
			.location(new ClueArea(2195, 3054, 2201, 3058, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(JUMP_FOR_JOY)
			.itemRequirement(item(DRAGON_2H_SWORD))
			.itemRequirement(item(BANDOS_BOOTS))
			.itemRequirement(item(OBSIDIAN_CAPE))
			.build(),
		EmoteClue.builder()
			.text("Panic by the big egg where no one dare goes and the ground is burnt. Beware of double agents! Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.")
			.area("Lava dragon isle")
			.stashUnit(SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE)
			.location(new ClueArea(3223, 3828, 3229, 3835, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(PANIC)
			.itemRequirement(item(DRAGON_MED_HELM))
			.itemRequirement(item(TOKTZKETXIL))
			.itemRequirement(item(BRINE_SABRE))
			.itemRequirement(item(RUNE_PLATEBODY))
			.itemRequirement(any("Uncharged Amulet of glory", item(AMULET_OF_GLORY)))
			.build(),
		EmoteClue.builder()
			.text("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.")
			.area("Draynor Village")
			.stashUnit(BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE)
			// Needs full area
			.location(new ClueArea(3088, 3254, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(ANGRY)
			.itemRequirement(any("Abyssal whip", item(ABYSSAL_WHIP), item(VOLCANIC_ABYSSAL_WHIP), item(FROZEN_ABYSSAL_WHIP)))
			.itemRequirement(item(CAPE_OF_LEGENDS))
			.itemRequirement(item(SPINED_CHAPS))
			.build(),
		EmoteClue.builder()
			.text("Show your anger towards the Statue of Saradomin in Ellamaria's garden. Beware of double agents! Equip a zamorak godsword.")
			.area("Varrock Castle")
			.stashUnit(BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS)
			.location(new ClueArea(3227, 3477, 3233, 3482, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(ANGRY)
			.itemRequirement(any("Zamorak godsword", item(ZAMORAK_GODSWORD), item(ZAMORAK_GODSWORD_OR)))
			.build(),
		EmoteClue.builder()
			.text("Slap your head in the centre of the Kourend catacombs. Beware of double agents! Equip the arclight and the amulet of the damned.")
			.area("Kourend catacombs")
			.stashUnit(CENTRE_OF_THE_CATACOMBS_OF_KOUREND)
			.location(new ClueArea(1659, 10043, 1668, 10052, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(SLAP_HEAD)
			.itemRequirement(item(ARCLIGHT))
			.itemRequirement(any("Amulet of the damned", item(AMULET_OF_THE_DAMNED), item(AMULET_OF_THE_DAMNED_FULL)))
			.build(),
		EmoteClue.builder()
			.text("Spin in front of the Soul altar. Beware of double agents! Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.")
			.area("Soul altar")
			.stashUnit(SOUL_ALTAR)
			.location(new ClueArea(1810, 3850, 1821, 3859, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(SPIN)
			.itemRequirement(any("Dragon or Crystal pickaxe", item(DRAGON_PICKAXE), item(DRAGON_PICKAXE_12797), item(INFERNAL_PICKAXE), item(INFERNAL_PICKAXE_UNCHARGED), item(DRAGON_PICKAXE_OR), item(DRAGON_PICKAXE_OR_25376), item(CRYSTAL_PICKAXE), item(CRYSTAL_PICKAXE_INACTIVE), item(INFERNAL_PICKAXE_OR), item(INFERNAL_PICKAXE_UNCHARGED_25369)))
			.itemRequirement(item(HELM_OF_NEITIZNOT))
			.itemRequirement(item(RUNE_BOOTS))
			.build(),
		EmoteClue.builder()
			.text("Stamp in the Enchanted valley west of the waterfall. Beware of double agents! Equip a dragon axe.")
			.area("Enchanted Valley")
			.stashUnit(NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY)
			.location(new ClueArea(3026, 4519, 3038, 4522, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(STAMP)
			.itemRequirement(any("Dragon/Crystal Axe", item(DRAGON_AXE), item(DRAGON_AXE_OR), item(CRYSTAL_AXE), item(CRYSTAL_AXE_INACTIVE), item(INFERNAL_AXE), item(INFERNAL_AXE_UNCHARGED), item(INFERNAL_AXE_OR), item(INFERNAL_AXE_UNCHARGED_25371)))
			.build(),
		EmoteClue.builder()
			.text("Swing a bullroarer at the top of the Watchtower. Beware of double agents! Equip a dragon plateskirt, climbing boots and a dragon chainbody.")
			.area("Yanille Watchtower")
			.stashUnit(TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER)
			.location(new ClueArea(2927, 4711, 2934, 4718, 2))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(BULL_ROARER)
			.itemRequirement(any("Dragon plateskirt", item(DRAGON_PLATESKIRT), item(DRAGON_PLATESKIRT_G)))
			.itemRequirement(item(CLIMBING_BOOTS))
			.itemRequirement(any("Dragon chainbody", item(DRAGON_CHAINBODY_3140), item(DRAGON_CHAINBODY_G)))
			.itemRequirement(item(ItemID.BULL_ROARER))
			.build(),
		EmoteClue.builder()
			.text("Wave on the northern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.")
			.area("Castle Drakan")
			.stashUnit(NORTHERN_WALL_OF_CASTLE_DRAKAN)
			.location(new ClueArea(3546, 3379, 3562, 3379, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(WAVE)
			.itemRequirement(any("Dragon sq shield", item(DRAGON_SQ_SHIELD), item(DRAGON_SQ_SHIELD_G)))
			.itemRequirement(item(SPLITBARK_BODY))
			.itemRequirement(any("Any boater", item(RED_BOATER), item(ORANGE_BOATER), item(GREEN_BOATER), item(BLUE_BOATER), item(BLACK_BOATER), item(PINK_BOATER), item(PURPLE_BOATER), item(WHITE_BOATER)))
			.build(),
		EmoteClue.builder()
			.text("Yawn in the 7th room of Pyramid Plunder. Beware of double agents! Equip a pharaoh sceptre and a full set of menaphite robes.")
			.area("Pyramid Plunder")
			.stashUnit(_7TH_CHAMBER_OF_JALSAVRAH)
			// Needs full area
			.location(new ClueArea(1944, 4427, 0))
			.enemy(DOUBLE_AGENT_141)
			.firstEmote(YAWN)
			.itemRequirement(any("Pharaoh's sceptre", item(PHARAOHS_SCEPTRE_UNCHARGED), item(PHARAOHS_SCEPTRE_26948), item(PHARAOHS_SCEPTRE_26950)))
			.itemRequirement(any("Full set of menaphite robes", all(item(MENAPHITE_PURPLE_HAT), item(MENAPHITE_PURPLE_TOP), range(MENAPHITE_PURPLE_ROBE, MENAPHITE_PURPLE_KILT)), all(item(MENAPHITE_RED_HAT), item(MENAPHITE_RED_TOP), range(MENAPHITE_RED_ROBE, MENAPHITE_RED_KILT))))
			.build()
	);

	@Nullable
	private final STASHUnit stashUnit;
	@Nonnull
	private final Emote firstEmote;
	@Nullable
	private final Emote secondEmote;
	//TODO: Remove me.
	@Singular
	@Nonnull
	private final Set<ItemRequirement> itemRequirements;

	private final String type = "Emote Clue";

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
		panelComponent.getChildren().add(LineComponent.builder().left("Emotes:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(firstEmote.getName())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		if (secondEmote != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left(secondEmote.getName())
				.leftColor(TITLED_CONTENT_COLOR)
				.build());
		}

		Client client = plugin.getClient();

		if (stashUnit != null)
		{
			client.runScript(ScriptID.WATSON_STASH_UNIT_CHECK, stashUnit.getObjectId(), 0, 0, 0);
			int[] intStack = client.getIntStack();
			boolean stashUnitBuilt = intStack[0] == 1;

			panelComponent.getChildren().add(LineComponent.builder()
				.left("STASH Unit:")
				.right(stashUnitBuilt ? UNICODE_CHECK_MARK : UNICODE_BALLOT_X)
				.rightColor(stashUnitBuilt ? Color.GREEN : Color.RED)
				.build());
		}

		// TODO: Remove
		panelComponent.getChildren().add(LineComponent.builder().left("Equip:").build());

		Item[] equipment = plugin.getEquippedItems();
		Item[] inventory = plugin.getInventoryItems();

		// If equipment is null, the player is wearing nothing
		if (equipment == null)
		{
			equipment = new Item[0];
		}

		// If inventory is null, the player has nothing in their inventory
		if (inventory == null)
		{
			inventory = new Item[0];
		}

		Item[] combined = new Item[equipment.length + inventory.length];
		System.arraycopy(equipment, 0, combined, 0, equipment.length);
		System.arraycopy(inventory, 0, combined, equipment.length, inventory.length);

		for (ItemRequirement requirement : itemRequirements)
		{
			boolean equipmentFulfilled = requirement.fulfilledBy(equipment);
			boolean combinedFulfilled = requirement.fulfilledBy(combined);

			panelComponent.getChildren().add(LineComponent.builder()
				.left(requirement.getCollectiveName(client))
				.leftColor(TITLED_CONTENT_COLOR)
				.right(combinedFulfilled ? UNICODE_CHECK_MARK : UNICODE_BALLOT_X)
				.rightFont(FontManager.getDefaultFont())
				.rightColor(equipmentFulfilled ? Color.GREEN : (combinedFulfilled ? Color.ORANGE : Color.RED))
				.build());
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
		makeSTASHOverlay(graphics, plugin);
	}

	public void makeSTASHOverlay(Graphics2D graphics, ClueHelperPlugin plugin)
	{
		if (stashUnit != null)
		{
			final WorldPoint[] worldPoints = stashUnit.getWorldPoints();

			for (final WorldPoint worldPoint : worldPoints)
			{
				final LocalPoint stashUnitLocalPoint = LocalPoint.fromWorld(plugin.getClient(), worldPoint);

				if (stashUnitLocalPoint != null)
				{
					final Polygon poly = Perspective.getCanvasTilePoly(plugin.getClient(), stashUnitLocalPoint);
					if (poly != null)
					{
						OverlayUtil.renderPolygon(graphics, poly, Color.RED);
					}
				}
			}
		}
	}

	@Nullable
	public static EmoteClue forText(String text)
	{
		for (EmoteClue clue : CLUES)
		{
			if (text.equalsIgnoreCase(clue.getText()))
			{
				return clue;
			}
		}

		return null;
	}
}
