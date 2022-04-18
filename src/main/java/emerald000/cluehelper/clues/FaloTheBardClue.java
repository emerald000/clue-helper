/*
 * Copyright (c) 2019, Twiglet1022 <https://github.com/Twiglet1022>
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
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import static net.runelite.api.ItemID.*;
import emerald000.cluehelper.ClueHelperPlugin;
import emerald000.cluehelper.clues.requirement.InventoryRequirement;
import emerald000.cluehelper.clues.requirement.OrRequirement;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@SuperBuilder
public class FaloTheBardClue extends ClueScroll
{
	private static final ClueArea FALO_LOCATION = new ClueArea(2689, 3550, 0);

	private static final List<FaloTheBardClue> CLUES = ImmutableList.of(
		FaloTheBardClue.builder()
			.text("A blood red weapon, a strong curved sword, found on the island of primate lords.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Dragon Scimitar",
				new InventoryRequirement(DRAGON_SCIMITAR),
				new InventoryRequirement(DRAGON_SCIMITAR_OR)))
			.build(),
		// TODO: God book (or)
		FaloTheBardClue.builder()
			.text("A book that preaches of some great figure, lending strength, might and vigour.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Complete God Book",
				new InventoryRequirement(HOLY_BOOK),
				new InventoryRequirement(BOOK_OF_BALANCE),
				new InventoryRequirement(UNHOLY_BOOK),
				new InventoryRequirement(BOOK_OF_LAW),
				new InventoryRequirement(BOOK_OF_WAR),
				new InventoryRequirement(BOOK_OF_DARKNESS)))
			.build(),
		FaloTheBardClue.builder()
			.text("A bow of elven craft was made, it shimmers bright, but will soon fade.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(CRYSTAL_BOW))
			.build(),
		FaloTheBardClue.builder()
			.text("A fiery axe of great inferno, when you use it, you'll wonder where the logs go.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Infernal axe",
				new InventoryRequirement(INFERNAL_AXE),
				new InventoryRequirement(INFERNAL_AXE_OR)))
			.build(),
		FaloTheBardClue.builder()
			.text("A mark used to increase one's grace, found atop a seer's place.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(MARK_OF_GRACE))
			.build(),
		FaloTheBardClue.builder()
			.text("A molten beast with fiery breath, you acquire these with its death.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(LAVA_DRAGON_BONES))
			.build(),
		FaloTheBardClue.builder()
			.text("A shiny helmet of flight, to obtain this with melee, struggle you might.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(ARMADYL_HELMET))
			.build(),
		FaloTheBardClue.builder()
			.text("A sword held in the other hand, red its colour, Cyclops strength you must withstand.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Dragon Defender",
				new InventoryRequirement(DRAGON_DEFENDER),
				new InventoryRequirement(DRAGON_DEFENDER_T),
				new InventoryRequirement(DRAGON_DEFENDER_L),
				new InventoryRequirement(AVERNIC_DEFENDER),
				new InventoryRequirement(AVERNIC_DEFENDER_L)))
			.build(),
		FaloTheBardClue.builder()
			.text("A token used to kill mythical beasts, in hopes of a blade or just for an xp feast.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(WARRIOR_GUILD_TOKEN))
			.build(),
		FaloTheBardClue.builder()
			.text("Green is my favourite, mature ale I do love, this takes your herblore above.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(GREENMANS_ALEM))
			.build(),
		FaloTheBardClue.builder()
			.text("It can hold down a boat or crush a goat, this object, you see, is quite heavy.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(BARRELCHEST_ANCHOR))
			.build(),
		FaloTheBardClue.builder()
			.text("It comes from the ground, underneath the snowy plain. Trolls aplenty, with what looks like a mane.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(BASALT))
			.build(),
		FaloTheBardClue.builder()
			.text("No attack to wield, only strength is required, made of obsidian, but with no room for a shield.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Tzhaar-ket-om",
				new InventoryRequirement(TZHAARKETOM),
				new InventoryRequirement(TZHAARKETOM_T)))
			.build(),
		FaloTheBardClue.builder()
			.text("Penance healers runners and more, obtaining this body often gives much deplore.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Fighter Torso",
				new InventoryRequirement(FIGHTER_TORSO),
				new InventoryRequirement(FIGHTER_TORSO_L)))
			.build(),
		FaloTheBardClue.builder()
			.text("Strangely found in a chest, many believe these gloves are the best.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(BARROWS_GLOVES))
			.build(),
		FaloTheBardClue.builder()
			.text("These gloves of white won't help you fight, but aid in cooking, they just might.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(COOKING_GAUNTLETS))
			.build(),
		FaloTheBardClue.builder()
			.text("They come from some time ago, from a land unto the east. Fossilised they have become, this small and gentle beast.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(NUMULITE))
			.build(),
		FaloTheBardClue.builder()
			.text("To slay a dragon you must first do, before this chest piece can be put on you.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new InventoryRequirement(RUNE_PLATEBODY))
			.build(),
		FaloTheBardClue.builder()
			.text("Vampyres are agile opponents, damaged best with a weapon of many components.")
			.location(FALO_LOCATION)
			.npc("Falo the Bard")
			.requirement(new OrRequirement("Rod of Ivandis (or its upgrades)",
				new InventoryRequirement(ROD_OF_IVANDIS_1),
				new InventoryRequirement(ROD_OF_IVANDIS_2),
				new InventoryRequirement(ROD_OF_IVANDIS_3),
				new InventoryRequirement(ROD_OF_IVANDIS_4),
				new InventoryRequirement(ROD_OF_IVANDIS_5),
				new InventoryRequirement(ROD_OF_IVANDIS_6),
				new InventoryRequirement(ROD_OF_IVANDIS_7),
				new InventoryRequirement(ROD_OF_IVANDIS_8),
				new InventoryRequirement(ROD_OF_IVANDIS_9),
				new InventoryRequirement(ROD_OF_IVANDIS_10),
				new InventoryRequirement(IVANDIS_FLAIL),
				new InventoryRequirement(BLISTERWOOD_FLAIL)))
			.build());

	private final String type = "Falo the Bard Clue";

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
	}

	@Nullable
	public static FaloTheBardClue forText(String text)
	{
		for (FaloTheBardClue clue : CLUES)
		{
			if (text.equalsIgnoreCase(clue.getText()))
			{
				return clue;
			}
		}

		return null;
	}
}
