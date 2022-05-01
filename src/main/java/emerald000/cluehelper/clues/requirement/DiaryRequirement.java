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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import static net.runelite.api.Varbits.*;
import emerald000.cluehelper.ClueHelperPlugin;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.EASY;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.ELITE;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.HARD;
import static emerald000.cluehelper.clues.requirement.DiaryRequirement.DiaryLevel.MEDIUM;

@Getter
@AllArgsConstructor
public class DiaryRequirement implements Requirement
{
	@Getter
	@AllArgsConstructor
	public enum DiaryRegion
	{
		ARDOUGNE("Ardougne", ImmutableMap.of(EASY, DIARY_ARDOUGNE_EASY, MEDIUM, DIARY_ARDOUGNE_MEDIUM, HARD, DIARY_ARDOUGNE_HARD, ELITE, DIARY_ARDOUGNE_ELITE)),
		DESERT("Desert", ImmutableMap.of(EASY, DIARY_DESERT_EASY, MEDIUM, DIARY_DESERT_MEDIUM, HARD, DIARY_DESERT_HARD, ELITE, DIARY_DESERT_ELITE)),
		FALADOR("Falador", ImmutableMap.of(EASY, DIARY_FALADOR_EASY, MEDIUM, DIARY_FALADOR_MEDIUM, HARD, DIARY_FALADOR_HARD, ELITE, DIARY_FALADOR_ELITE)),
		FREMENNIK("Fremennik", ImmutableMap.of(EASY, DIARY_FREMENNIK_EASY, MEDIUM, DIARY_FREMENNIK_MEDIUM, HARD, DIARY_FREMENNIK_HARD, ELITE, DIARY_FREMENNIK_ELITE)),
		KANDARIN("Kandarin", ImmutableMap.of(EASY, DIARY_KANDARIN_EASY, MEDIUM, DIARY_KANDARIN_MEDIUM, HARD, DIARY_KANDARIN_HARD, ELITE, DIARY_KANDARIN_ELITE)),
		KARAMJA("Karamja", ImmutableMap.of(EASY, DIARY_KARAMJA_EASY, MEDIUM, DIARY_KARAMJA_MEDIUM, HARD, DIARY_KARAMJA_HARD, ELITE, DIARY_KARAMJA_ELITE)),
		KOUREND_KEBOS("Kourend & Kebos", ImmutableMap.of(EASY, DIARY_KOUREND_EASY, MEDIUM, DIARY_KOUREND_MEDIUM, HARD, DIARY_KOUREND_HARD, ELITE, DIARY_KOUREND_ELITE)),
		LUMBRIDGE_DRAYNOR("Lumbridge & Draynor", ImmutableMap.of(EASY, DIARY_LUMBRIDGE_EASY, MEDIUM, DIARY_LUMBRIDGE_MEDIUM, HARD, DIARY_LUMBRIDGE_HARD, ELITE, DIARY_LUMBRIDGE_ELITE)),
		MORYTANIA("Morytania", ImmutableMap.of(EASY, DIARY_MORYTANIA_EASY, MEDIUM, DIARY_MORYTANIA_MEDIUM, HARD, DIARY_MORYTANIA_HARD, ELITE, DIARY_MORYTANIA_ELITE)),
		VARROCK("Varrock", ImmutableMap.of(EASY, DIARY_VARROCK_EASY, MEDIUM, DIARY_VARROCK_MEDIUM, HARD, DIARY_VARROCK_HARD, ELITE, DIARY_VARROCK_ELITE)),
		WESTERN_PROVINCES("Western Provinces", ImmutableMap.of(EASY, DIARY_WESTERN_EASY, MEDIUM, DIARY_WESTERN_MEDIUM, HARD, DIARY_WESTERN_HARD, ELITE, DIARY_WESTERN_ELITE)),
		WILDERNESS("Wilderness", ImmutableMap.of(EASY, DIARY_WILDERNESS_EASY, MEDIUM, DIARY_WILDERNESS_MEDIUM, HARD, DIARY_WILDERNESS_HARD, ELITE, DIARY_WILDERNESS_ELITE));

		final String name;
		final Map<DiaryLevel, Integer> varbitsMap;
	}

	@Getter
	@AllArgsConstructor
	public enum DiaryLevel
	{
		EASY("Easy"),
		MEDIUM("Medium"),
		HARD("Hard"),
		ELITE("Elite");

		final String name;
	}

	final DiaryRegion region;
	final DiaryLevel level;

	@Override
	public String getText(Client client)
	{
		return level.getName() + " " + region.getName() + " Diary";
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		if (plugin.getClient().getVarbitValue(region.getVarbitsMap().get(level)) == 1)
		{
			return Fulfilled.TRUE;
		}
		return Fulfilled.FALSE;
	}
}
