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

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import static net.runelite.api.Quest.LEGENDS_QUEST;
import static net.runelite.api.Skill.AGILITY;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.requirement.CommonRequirement.CAN_USE_AXE;
import static emerald000.cluehelper.clues.requirement.CommonRequirement.CAN_USE_MACHETE;

@Getter
public class KharaziJungleEntranceRequirement implements Requirement
{
	private static final Requirement HAS_79_AGILITY = new SkillRequirement(AGILITY, 79, false);
	private static final Requirement HAS_AXE_AND_MACHETE = new AndRequirement(
		CAN_USE_AXE.getRequirement(),
		CAN_USE_MACHETE.getRequirement());
	private static final Requirement HAS_COMPLETED_LEGENDS_QUEST = new QuestRequirement(LEGENDS_QUEST);
	private static final Requirement HAS_RADIMUS_NOTES = new OrRequirement(
		new InventoryRequirement(ItemID.RADIMUS_NOTES),
		new InventoryRequirement(ItemID.RADIMUS_NOTES_715));

	private String text = "Axe & Machete";

	@Override
	public String getText(Client client)
	{
		return text;
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		if (HAS_79_AGILITY.fulfilledBy(plugin) == Fulfilled.TRUE)
		{
			text = "79 Agility";
			return Fulfilled.TRUE;
		}
		if (HAS_COMPLETED_LEGENDS_QUEST.fulfilledBy(plugin) == Fulfilled.TRUE)
		{
			text = "Axe & Machete";
			return HAS_AXE_AND_MACHETE.fulfilledBy(plugin);
		}
		else
		{
			text = "Axe, Machete & Radimus notes";
			return new AndRequirement(HAS_AXE_AND_MACHETE, HAS_RADIMUS_NOTES).fulfilledBy(plugin);
		}
	}
}
