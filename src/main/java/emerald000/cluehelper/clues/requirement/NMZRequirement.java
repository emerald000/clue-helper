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
import java.util.Set;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import static net.runelite.api.Quest.*;
import net.runelite.api.QuestState;
import emerald000.cluehelper.ClueHelperPlugin;

@Getter
public class NMZRequirement implements Requirement
{
	private static final Set<Quest> quests = Sets.immutableEnumSet(
		CONTACT,
		DESERT_TREASURE,
		DRAGON_SLAYER_I,
		DREAM_MENTOR,
		FAIRYTALE_I__GROWING_PAINS,
		FAMILY_CREST,
		FIGHT_ARENA,
		GETTING_AHEAD,
		GRIM_TALES,
		HAUNTED_MINE,
		HOLY_GRAIL,
		HORROR_FROM_THE_DEEP,
		IN_SEARCH_OF_THE_MYREQUE,
		LEGENDS_QUEST,
		LOST_CITY,
		LUNAR_DIPLOMACY,
		MONKEY_MADNESS_I,
		MOUNTAIN_DAUGHTER,
		MY_ARMS_BIG_ADVENTURE,
		ONE_SMALL_FAVOUR,
		RECIPE_FOR_DISASTER,
		ROVING_ELVES,
		SHADOW_OF_THE_STORM,
		SHILO_VILLAGE,
		SONG_OF_THE_ELVES,
		TALE_OF_THE_RIGHTEOUS,
		THE_ASCENT_OF_ARCEUUS,
		THE_CORSAIR_CURSE,
		THE_DEPTHS_OF_DESPAIR,
		THE_FREMENNIK_ISLES,
		THE_GRAND_TREE,
		THE_GREAT_BRAIN_ROBBERY,
		TREE_GNOME_VILLAGE,
		TROLL_ROMANCE,
		TROLL_STRONGHOLD,
		VAMPYRE_SLAYER,
		WHAT_LIES_BELOW,
		WITCHS_HOUSE);

	@Override
	public String getText(Client client)
	{
		return "Can Use Nightmare Zone";
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		int questsCompleted = 0;
		for (Quest quest : quests)
		{
			if (quest.getState(plugin.getClient()) == QuestState.FINISHED)
			{
				questsCompleted++;
				if (questsCompleted == 5)
				{
					return Fulfilled.TRUE;
				}
			}
		}
		return Fulfilled.FALSE;
	}
}
