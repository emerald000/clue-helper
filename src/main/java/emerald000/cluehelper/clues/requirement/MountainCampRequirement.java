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
import static net.runelite.api.ItemID.ROPE;
import static net.runelite.api.Quest.MOUNTAIN_DAUGHTER;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.requirement.Fulfilled.TRUE;

@Getter
public class MountainCampRequirement implements Requirement
{
	private static final Requirement HAS_STARTED_MOUNTAIN_DAUGHTER = new QuestRequirement(MOUNTAIN_DAUGHTER, true);
	private static final Requirement HAS_ROPE = new InventoryRequirement(ROPE);

	private String text = "Mountain Daughter (partial)";

	@Override
	public String getText(Client client)
	{
		return text;
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Fulfilled questStarted = HAS_STARTED_MOUNTAIN_DAUGHTER.fulfilledBy(plugin);
		switch (questStarted)
		{
			case TRUE:
			case PARTIAL:
				text = HAS_STARTED_MOUNTAIN_DAUGHTER.getText(plugin.getClient());
				return TRUE;
			case FALSE:
			default:
				text = HAS_ROPE.getText(plugin.getClient());
				return HAS_ROPE.fulfilledBy(plugin);
		}
	}
}
