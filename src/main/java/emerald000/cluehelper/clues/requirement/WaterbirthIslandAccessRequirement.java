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
import static net.runelite.api.ItemID.COINS_995;
import static net.runelite.api.Quest.THE_FREMENNIK_TRIALS;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.requirement.Fulfilled.FALSE;
import static emerald000.cluehelper.clues.requirement.Fulfilled.TRUE;

@Getter
public class WaterbirthIslandAccessRequirement implements Requirement
{
	private static final Requirement HAS_STARTED_THE_FREMENNIK_TRIALS = new QuestRequirement(THE_FREMENNIK_TRIALS, true);
	private static final Requirement HAS_1000_COINS = new InventoryRequirement(COINS_995, 1000);

	private String text = "The Fremennik Trials (partial)";

	@Override
	public String getText(Client client)
	{
		return text;
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Fulfilled questStarted = HAS_STARTED_THE_FREMENNIK_TRIALS.fulfilledBy(plugin);
		switch (questStarted)
		{
			case TRUE:
				text = "The Fremennik Trials (partial)";
				return TRUE;
			case PARTIAL:
				text = HAS_1000_COINS.getText(plugin.getClient());
				return HAS_1000_COINS.fulfilledBy(plugin);
			case FALSE:
			default:
				text = "The Fremennik Trials (partial) + 1000 coins";
				return FALSE;
		}
	}
}
