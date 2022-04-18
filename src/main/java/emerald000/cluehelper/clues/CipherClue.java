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
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import static net.runelite.api.ItemID.*;
import static net.runelite.api.ObjectID.*;
import static net.runelite.api.Quest.ALFRED_GRIMHANDS_BARCRAWL;
import static net.runelite.api.Quest.FAIRYTALE_II__CURE_A_QUEEN;
import static net.runelite.api.Quest.HOLY_GRAIL;
import static net.runelite.api.Quest.LOST_CITY;
import static net.runelite.api.Quest.MOURNINGS_END_PART_I;
import static net.runelite.api.Quest.PRIEST_IN_PERIL;
import static net.runelite.api.Quest.SWAN_SONG;
import net.runelite.api.coords.WorldPoint;
import emerald000.cluehelper.clues.requirement.QuestRequirement;
import static emerald000.cluehelper.clues.teleport.CommonTeleport.*;
import static emerald000.cluehelper.clues.teleport.CommonTeleport.ECTOPHIAL;
import static emerald000.cluehelper.clues.teleport.CommonTeleport.WESTERN_BANNER_3;

@Getter
@SuperBuilder
public class CipherClue extends ClueScroll
{
	private static final String CIPHER_TEXT = "The cipher reveals who to speak to next: ";

	private static final List<CipherClue> CLUES = ImmutableList.of(
		// Medium
		CipherClue.builder()
			.text(CIPHER_TEXT + "BMJ UIF LFCBC TFMMFS")
			.clueId(CLUE_SCROLL_MEDIUM_19768)
			.npc("Ali the Kebab seller")
			.location(new ClueArea(3354, 2974, 0))
			.area("Pollnivneach")
			.question("How many coins would you need to purchase 133 kebabs from me?")
			.answer("399")
			.teleport(TELEPORT_TO_HOUSE_POLLNIVNEACH)
			.teleport(MAGIC_CARPET_POLLNIVNEACH)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "ECRVCKP MJCNGF")
			.clueId(CLUE_SCROLL_MEDIUM_19766)
			.npc("Captain Khaled")
			.location(new ClueArea(1845, 3754, 0))
			.area("Port Piscarilius food hall")
			.question("How many fishing cranes can you find around here?")
			.answer("5")
			.teleport(KHAREDSTS_MEMOIRS_THE_FISHERS_FLUTE)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "GUHCHO")
			.clueId(CLUE_SCROLL_MEDIUM_19772)
			.npc("Drezel")
			.location(new ClueArea(3440, 9895, 0))
			.area("Paterdomus")
			.question("Please solve this for x: 7x - 28 = 21")
			.answer("7")
			.teleport(ARCEUUS_SALVE_GRAVEYARD)
			.teleport(FAIRY_RING_CKS)
			.teleport(SLAYER_RING_SLAYER_TOWER)
			.requirement(new QuestRequirement(PRIEST_IN_PERIL))
			.extraMapPoint(new WorldPoint(3422, 3485, 0))
			.pathObject(new WorldPoint(3422, 3485, 0), TRAPDOOR_3432)
			.pathObject(new WorldPoint(3422, 3485, 0), TRAPDOOR_3433)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "HQNM LZM STSNQ")
			.clueId(CLUE_SCROLL_MEDIUM_19770)
			.npc("Iron Man tutor")
			.location(new ClueArea(3227, 3227, 0))
			.area("Outside Lumbridge Castle")
			.question("How many snakeskins are needed in order to craft 44 boots, 29 vambraces and 34 bandanas?")
			.answer("666")
			.teleport(STANDARD_LUMBRIDGE)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "QSPGFTTPS HSBDLMFCPOF")
			.clueId(CLUE_SCROLL_MEDIUM_19762)
			.npc("Professor Gracklebone")
			.location(new ClueArea(1625, 3802, 0))
			.area("Arceuus Library")
			.question("How many round tables can be found on this floor of the library?")
			.answer("9")
			.teleport(KHAREDSTS_MEMOIRS_A_DARK_DISPOSITION)
			.teleport(FAIRY_RING_CIS)
			.pathObject(new WorldPoint(1634, 3798, 0), DOOR_28460)
			.pathObject(new WorldPoint(1635, 3798, 0), DOOR_28456)
			.pathObject(new WorldPoint(1633, 3817, 0), DOOR_28460)
			.pathObject(new WorldPoint(1632, 3817, 0), DOOR_28456)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "USBJCPSO")
			.clueId(CLUE_SCROLL_MEDIUM_19764)
			.npc("Wizard Traiborn")
			.location(new ClueArea(3112, 3162, 1))
			.area("Wizards' Tower first floor")
			.question("How many air runes would I need to cast 630 wind waves?")
			.answer("3150")
			.teleport(NECKLACE_OF_PASSAGE_WIZARDS_TOWER)
			.teleport(FAIRY_RING_DIS)
			.teleport(AMULET_OF_GLORY_DRAYNOR_VILLAGE)
			.pathObject(new WorldPoint(3109, 3167, 0), DOOR_23972)
			.pathObject(new WorldPoint(3107, 3162, 0), DOOR_23972)
			.pathObject(new WorldPoint(3103, 3159, 0), STAIRCASE_12536)
			.pathObject(new WorldPoint(3109, 3162, 1), DOOR_23972)
			.build(),

		// Hard
		CipherClue.builder()
			.text(CIPHER_TEXT + "BSOPME MZETQPS")
			.clueId(CLUE_SCROLL_HARD_23170)
			.npc("Arnold Lydspor")
			.location(new ClueArea(2329, 3689, 0))
			.area("Piscatoris Fishing Colony")
			.teleport(WESTERN_BANNER_3)
			.teleport(SCROLL_PISCATORIS)
			.teleport(FAIRY_RING_AKQ)
			.requirement(new QuestRequirement(SWAN_SONG))
			.build(),
		// TODO: partial quest completion
		CipherClue.builder()
			.text(CIPHER_TEXT + "GBJSZ RVFFO")
			.clueId(CLUE_SCROLL_HARD_19910)
			.npc("Fairy Queen")
			.location(new ClueArea(2347, 4435, 0))
			.area("Fairy Resistance Hideout")
			.teleport(FAIRY_RING_HIDEOUT)
			.requirement(new QuestRequirement(FAIRYTALE_II__CURE_A_QUEEN))
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "HCKTA IQFHCVJGT")
			.clueId(CLUE_SCROLL_HARD_19908)
			.npc("Fairy Godfather")
			.location(new ClueArea(2446, 4428, 0))
			.area("Zanaris throne room")
			.question("There are 3 inputs and 4 letters on each ring. How many total individual fairy ring codes are possible?")
			.answer("64")
			.teleport(FAIRY_RING_ZANARIS)
			.requirement(new QuestRequirement(LOST_CITY))
			.extraMapPoint(new WorldPoint(3201, 3169, 0))
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "IWPPLQTP")
			.clueId(CLUE_SCROLL_HARD_23172)
			.npc("Gunnjorn")
			.location(new ClueArea(2541, 3548, 0))
			.area("Barbarian Outpost Agility course")
			.teleport(GAMES_NECKLACE_BARBARIAN_OUTPOST)
			.teleport(MINIGAME_BARBARIAN_ASSAULT)
			.requirement(new QuestRequirement(ALFRED_GRIMHANDS_BARCRAWL))
			.pathObject(new WorldPoint(2545, 3570, 0), GATE_2115)
			.pathObject(new WorldPoint(2545, 3569, 0), GATE_2116)
			.pathObject(new WorldPoint(2552, 3559, 0), OBSTACLE_PIPE_20210)
			.build(),
		// TODO: Do something about this.
		CipherClue.builder()
			.text(CIPHER_TEXT + "OVEXON")
			.clueId(CLUE_SCROLL_HARD_19898)
			.npc("Eluned")
			.location(new ClueArea(2289, 3144, 0))
			.area("Outside Lletya (Prifddinas after Song of the Elves)")
			.question("A question on elven crystal math. I have 5 and 3 crystals, large and small respectively. A large crystal is worth 10,000 coins and a small is worth but 1,000. How much are all my crystals worth?")
			.answer("53,000")
			.teleport(TELEPORT_CRYSTAL_LLETYA)
			.requirement(new QuestRequirement(MOURNINGS_END_PART_I, true))
			.extraMapPoint(new WorldPoint(3229, 6061, 0))
			.pathObject(new WorldPoint(2305, 3192, 0), TREE_8742)
			.pathObject(new WorldPoint(2305, 3196, 0), TREE_8742)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "UZZU MUJHRKYYKJ")
			.clueId(CLUE_SCROLL_HARD_19900)
			.npc("Otto Godblessed")
			.location(new ClueArea(2501, 3487, 0))
			.area("Otto's Grotto")
			.question("How many pyre sites are found around this lake?")
			.answer("3")
			.teleport(FISHING_CAPE_OTTOS_GROTTO)
			.teleport(GAMES_NECKLACE_BARBARIAN_OUTPOST)
			.teleport(MINIGAME_BARBARIAN_ASSAULT)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "VTYR APCNTGLW")
			.clueId(CLUE_SCROLL_HARD_19906)
			.npc("King Percival")
			.location(new ClueArea(2634, 4682, 1))
			.area("Fisher Realm Castle")
			.question("How many cannons are on this here castle?")
			.answer("5")
			.teleport(FAIRY_RING_BJR)
			.requirement(new QuestRequirement(HOLY_GRAIL, true))
			.pathObject(new WorldPoint(2635, 4693, 0), LARGE_DOOR_1521)
			.pathObject(new WorldPoint(2634, 4693, 0), LARGE_DOOR_1524)
			.pathObject(new WorldPoint(2633, 4684, 0), DOOR_1535)
			.pathObject(new WorldPoint(2633, 4680, 0), STAIRCASE_16671)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "ZHLUG ROG PDQ")
			.clueId(CLUE_SCROLL_HARD_19904)
			.npc("Weird Old Man")
			.location(new ClueArea(3224, 3112, 0))
			.area("Kalphite Lair entrance")
			.question("SIX LEGS! All of them have 6! There are 25 of them! How many legs?")
			.answer("150")
			.teleport(FAIRY_RING_BIQ)
			.build(),
		CipherClue.builder()
			.text(CIPHER_TEXT + "ZSBKDO ZODO")
			.clueId(CLUE_SCROLL_HARD_19902)
			.npc("Pirate Pete")
			.location(new ClueArea(3680, 3537, 0))
			.area("Dock northeast of the Ectofunctus")
			.teleport(ECTOPHIAL)
			.teleport(FAIRY_RING_ALQ)
			.requirement(new QuestRequirement(PRIEST_IN_PERIL))
			.build(),
		// TODO
		// X Marks the Spot
		CipherClue.builder()
			.text(CIPHER_TEXT + "ESBZOPS QJH QFO")
			.location(new ClueArea(3077, 3260, 0))
			.area("TODO")
			.build()
	);

	private final String type = "Cipher Clue";

	@Nullable
	public static CipherClue forText(String text)
	{
		for (CipherClue clue : CLUES)
		{
			if (text.equalsIgnoreCase(clue.getText())
				|| text.equalsIgnoreCase(clue.getQuestion()))
			{
				return clue;
			}
		}

		return null;
	}
}
