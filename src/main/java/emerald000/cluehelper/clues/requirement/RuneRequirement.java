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

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.*;
import net.runelite.api.Varbits;
import static net.runelite.api.Varbits.*;
import net.runelite.client.game.RunepouchRune;
import emerald000.cluehelper.ClueHelperPlugin;

@Getter
@AllArgsConstructor
public class RuneRequirement implements Requirement
{
	@Getter
	@AllArgsConstructor
	public
	enum Rune
	{
		AIR("Air",
			Sets.newHashSet(AIR_RUNE, MIST_RUNE, DUST_RUNE, SMOKE_RUNE),
			Sets.newHashSet(STAFF_OF_AIR, AIR_BATTLESTAFF, MYSTIC_AIR_STAFF, MIST_BATTLESTAFF, MYSTIC_MIST_STAFF, DUST_BATTLESTAFF, MYSTIC_DUST_STAFF, SMOKE_BATTLESTAFF, MYSTIC_SMOKE_STAFF)),
		ASTRAL("Astral", Sets.newHashSet(ASTRAL_RUNE)),
		BLOOD("Blood", Sets.newHashSet(BLOOD_RUNE)),
		BODY("Body", Sets.newHashSet(BODY_RUNE)),
		CHAOS("Chaos", Sets.newHashSet(CHAOS_RUNE)),
		COSMIC("Cosmic", Sets.newHashSet(COSMIC_RUNE)),
		DEATH("Death", Sets.newHashSet(DEATH_RUNE)),
		EARTH("Earth",
			Sets.newHashSet(EARTH_RUNE, LAVA_RUNE, MUD_RUNE, DUST_RUNE),
			Sets.newHashSet(STAFF_OF_EARTH, EARTH_BATTLESTAFF, MYSTIC_EARTH_STAFF, LAVA_BATTLESTAFF, LAVA_BATTLESTAFF_21198, MYSTIC_LAVA_STAFF, MYSTIC_LAVA_STAFF_21200, MUD_BATTLESTAFF, MYSTIC_MUD_STAFF, DUST_BATTLESTAFF, MYSTIC_DUST_STAFF)),
		FIRE("Fire",
			Sets.newHashSet(FIRE_RUNE, LAVA_RUNE, STEAM_RUNE, SMOKE_RUNE),
			Sets.newHashSet(TOME_OF_FIRE, STAFF_OF_FIRE, FIRE_BATTLESTAFF, MYSTIC_FIRE_STAFF, LAVA_BATTLESTAFF, LAVA_BATTLESTAFF_21198, MYSTIC_LAVA_STAFF, MYSTIC_LAVA_STAFF_21200, STEAM_BATTLESTAFF, STEAM_BATTLESTAFF_12795, MYSTIC_STEAM_STAFF, MYSTIC_STEAM_STAFF_12796, SMOKE_BATTLESTAFF, MYSTIC_SMOKE_STAFF)),
		LAW("Law", Sets.newHashSet(LAW_RUNE)),
		MIND("Mind", Sets.newHashSet(MIND_RUNE)),
		NATURE("Nature",
			Sets.newHashSet(NATURE_RUNE),
			Sets.newHashSet(BRYOPHYTAS_STAFF)),
		SOUL("Soul", Sets.newHashSet(SOUL_RUNE)),
		WATER("Water",
			Sets.newHashSet(WATER_RUNE, MUD_RUNE, STEAM_RUNE, MIST_RUNE),
			Sets.newHashSet(STAFF_OF_WATER, WATER_BATTLESTAFF, MYSTIC_WATER_STAFF, MUD_BATTLESTAFF, MYSTIC_MUD_STAFF, STEAM_BATTLESTAFF, STEAM_BATTLESTAFF_12795, MYSTIC_STEAM_STAFF, MYSTIC_STEAM_STAFF_12796, MIST_BATTLESTAFF, MYSTIC_MIST_STAFF, KODAI_WAND, TOME_OF_WATER)),
		WRATH("Wrath", Sets.newHashSet(WRATH_RUNE));

		String name;
		Set<Integer> inventoryFulfillment;
		Set<Integer> equipmentFulfillment;

		Rune(String name, Set<Integer> inventoryFulfillment)
		{
			this(name, inventoryFulfillment, new HashSet<>(0));
		}
	}

	private static final Varbits[] TYPE_VARBITS = {RUNE_POUCH_RUNE1, RUNE_POUCH_RUNE2, RUNE_POUCH_RUNE3};
	private static final Varbits[] AMOUNT_VARBITS = {RUNE_POUCH_AMOUNT1, RUNE_POUCH_AMOUNT2, RUNE_POUCH_AMOUNT3};
	private static final Requirement runePouchRequirement = new OrRequirement(new InventoryRequirement(RUNE_POUCH), new InventoryRequirement(RUNE_POUCH_L));

	private final Rune rune;
	private final int quantity;

	public RuneRequirement(Rune rune)
	{
		this(rune, 1);
	}

	@Override
	public String getText(Client client)
	{
		return quantity + " " + rune.getName() + (quantity > 1 ? " runes" : " rune");
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Client client = plugin.getClient();

		// Check for an equipped item that creates the required rune.
		ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipment != null)
		{
			for (int equipmentId : rune.getEquipmentFulfillment())
			{
				if (equipment.contains(equipmentId))
				{
					return Fulfilled.TRUE;
				}
			}
		}

		// Check the inventory for runes that counts as the required rune.
		int totalQuantity = 0;

		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory != null)
		{
			for (int inventoryId : rune.getInventoryFulfillment())
			{
				totalQuantity += inventory.count(inventoryId);
				if (totalQuantity >= quantity)
				{
					return Fulfilled.TRUE;
				}
			}
		}

		// Check Rune Pouch
		if (runePouchRequirement.fulfilledBy(plugin) == Fulfilled.TRUE)
		{
			for (int i = 0; i <= 2; i++)
			{
				RunepouchRune runepouchRune = RunepouchRune.getRune(client.getVar(TYPE_VARBITS[i]));
				if (runepouchRune != null && rune.getInventoryFulfillment().contains(runepouchRune.getItemId()))
				{
					totalQuantity += client.getVar(AMOUNT_VARBITS[i]);
					if (totalQuantity >= quantity)
					{
						return Fulfilled.TRUE;
					}
				}
			}
		}

		return Fulfilled.FALSE;
	}
}
