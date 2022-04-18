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
import static net.runelite.api.ItemID.ROPE;
import static net.runelite.api.Quest.MOUNTAIN_DAUGHTER;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.EASY;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.ELITE;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.HARD;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.MEDIUM;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryRegion.WILDERNESS;
import static emerald000.cluehelper.clues.requirement.Fulfilled.TRUE;

@Getter
public class ResourceAreaEntranceRequirement implements Requirement
{
	private static final Requirement MEDIUM_DIARY = new DiaryRequirement(WILDERNESS, MEDIUM);
	private static final Requirement HARD_DIARY = new DiaryRequirement(WILDERNESS, HARD);
	private static final Requirement ELITE_DIARY = new DiaryRequirement(WILDERNESS, ELITE);
	private static final Requirement _7500_COINS = new InventoryRequirement(COINS_995, 7500);
	private static final Requirement _6000_COINS = new InventoryRequirement(COINS_995, 6000);
	private static final Requirement _3750_COINS = new InventoryRequirement(COINS_995, 3750);

	private String text = "7500 Coins";

	@Override
	public String getText(Client client)
	{
		return text;
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		if (ELITE_DIARY.fulfilledBy(plugin) == TRUE)
		{
			text = ELITE_DIARY.getText(plugin.getClient());
			return TRUE;
		}
		if (HARD_DIARY.fulfilledBy(plugin) == TRUE)
		{
			text = _3750_COINS.getText(plugin.getClient());
			return _3750_COINS.fulfilledBy(plugin);
		}
		if (MEDIUM_DIARY.fulfilledBy(plugin) == TRUE)
		{
			text = _6000_COINS.getText(plugin.getClient());
			return _6000_COINS.fulfilledBy(plugin);
		}

		text = _7500_COINS.getText(plugin.getClient());
		return _7500_COINS.fulfilledBy(plugin);
	}
}
