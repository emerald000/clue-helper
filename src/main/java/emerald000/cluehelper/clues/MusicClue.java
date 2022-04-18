/*
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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

import emerald000.cluehelper.ClueHelperUtils;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import emerald000.cluehelper.ClueHelperPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@SuperBuilder
public class MusicClue extends ClueScroll
{
	private static final Pattern SONG_PATTERN = Pattern.compile("<col=ffffff>([A-Za-z !&',.]+)</col>");

	private final String type = "Music Clue";

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
		// Highlight the zone where you can play the song.
		LocalPoint swLocalLocation = LocalPoint.fromWorld(plugin.getClient(), new WorldPoint(2986, 3380, 0));
		LocalPoint neLocalLocation = LocalPoint.fromWorld(plugin.getClient(), new WorldPoint(2994, 3388, 0));

		if (swLocalLocation != null && neLocalLocation != null)
		{
			ClueHelperUtils.renderRectangleOverlay(plugin.getClient(), graphics, swLocalLocation, neLocalLocation, plugin.getClueScrollImage(), Color.ORANGE);
		}
	}

	@Nullable
	public static MusicClue forText(String text)
	{
		// Easy:
		// Alone: 23160
		// On the Shore: 23159
		// Rugged Terrain: 23158
		// The Forlorn Homestead: 23156
		// Tiptoe: 23157
		// Vision: 23155

		// Medium:
		// Catch Me If You Can: 23141
		// Cave of Beasts: 23142
		// Devils May Care: 23143
		// Faerie: 23139
		// Forgotten: 23140
		// Karamja Jam: 23138

		// Hard:
		// Fossilised: 23180
		// Hells Bells: 23181
		// Little Cave of Horrors: 23177
		// La Mort: 23179
		// Roc and Roll: 23178
		// Scorpia Dances: 23174
		// Subterranea: 23176

		final Matcher m = SONG_PATTERN.matcher(text);
		if (m.find())
		{
			final String song = m.group(1);
			return MusicClue.builder()
				.text(text)
				.area("Falador Park")
				.npc("Cecilia")
				.solution(song)
				.location(new ClueArea(2990, 3384, 0))
				.build();
		}
		return null;
	}
}
