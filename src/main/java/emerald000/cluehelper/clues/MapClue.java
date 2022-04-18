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
import java.awt.Graphics2D;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.api.widgets.WidgetID;
import emerald000.cluehelper.ClueHelperPlugin;
import net.runelite.client.ui.overlay.components.PanelComponent;

@Getter
@SuperBuilder
public class MapClue extends ClueScroll
{
	private static final List<MapClue> CLUES = ImmutableList.of(
		// Beginner
		MapClue.builder()
			.widgetId(WidgetID.BEGINNER_CLUE_MAP_CHAMPIONS_GUILD)
			.location(new ClueArea(3166, 3359, 3168, 3361, 0))
			.area("West of the Champions' Guild")
			.build(),
		MapClue.builder()
			.widgetId(WidgetID.BEGINNER_CLUE_MAP_VARROCK_EAST_MINE)
			.location(new ClueArea(3289, 3372, 3291, 3374, 0))
			.area("Outside Varrock East Mine")
			.build(),
		MapClue.builder()
			.widgetId(WidgetID.BEGINNER_CLUE_MAP_DRAYNOR)
			.location(new ClueArea(3091, 3225, 3093, 3227, 0))
			.area("South of Draynor Village Bank")
			.build(),
		MapClue.builder()
			.widgetId(WidgetID.BEGINNER_CLUE_MAP_NORTH_OF_FALADOR)
			.location(new ClueArea(3042, 3398, 3044, 3400, 0))
			.area("In the standing stones north of Falador")
			.build(),
		MapClue.builder()
			.widgetId(WidgetID.BEGINNER_CLUE_MAP_WIZARDS_TOWER)
			.location(new ClueArea(3108, 3152, 3110, 3154, 0))
			.area("On the south side of the Wizard's Tower (DIS)")
			.build(),

		// Easy
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_EASY_12179)
			.location(new ClueArea(3299, 3290, 3301, 3292, 0))
			.build(),
		/*MapClue.builder()
			.itemId(ItemID.CLUE_SCROLL_EASY_2713)
			.location(new ClueArea(3167, 3360, 3167, 3360, 0))
			.build(),
		MapClue.builder()
			.itemId(ItemID.CLUE_SCROLL_EASY_2716)
			.location(new ClueArea(3290, 3373, 3290, 3373, 0))
			.build(),
		MapClue.builder()
			.itemId(ItemID.CLUE_SCROLL_EASY_2719)
			.location(new ClueArea(3043, 3399, 3043, 3399, 0))
			.build(),*/
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_EASY_3516)
			.location(new ClueArea(2611, 3480, 2613, 3482, 0))
			.build(),
		/*MapClue.builder()
			.itemId(ItemID.CLUE_SCROLL_EASY_3518)
			.location(new ClueArea(3109, 3153, 3109, 3153, 0))
			.build(),*/
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_EASY_7236)
			.location(new ClueArea(2969, 3413, 2971, 3415, 0))
			.build(),

		// Medium
		/*MapClue.builder()
			.itemId(ItemID.CLUE_SCROLL_MEDIUM_2827)
			.location(new ClueArea(3092, 3226, 3092, 3226, 0))
			.build(),*/
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_3596)
			.location(new ClueArea(2905, 3293, 2907, 3295, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_3598)
			.location(new ClueArea(2658, 3488, 0))
			.objectId(ObjectID.CRATE_357)
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_3599)
			.location(new ClueArea(2649, 3230, 2651, 3232, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_3601)
			.location(new ClueArea(2565, 3248, 0))
			.objectId(ObjectID.CRATE_354)
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_3602)
			.location(new ClueArea(2923, 3208, 2925, 3210, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_7286)
			.location(new ClueArea(2535, 3864, 2537, 3866, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_7288)
			.location(new ClueArea(3433, 3265, 3435, 3267, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_7290)
			.location(new ClueArea(2453, 3229, 2455, 3231, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_7292)
			.location(new ClueArea(2577, 3596, 2579, 3598, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_MEDIUM_7294)
			.location(new ClueArea(2666, 3561, 2668, 3563, 0))
			.build(),

		// Hard
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD)
			.location(new ClueArea(3309, 3503, 0))
			.objectId(ObjectID.CRATE_2620)
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_3520)
			.location(new ClueArea(2615, 3076, 2617, 3078, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_3522)
			.location(new ClueArea(2487, 3307, 2489, 3309, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_3524)
			.location(new ClueArea(2457, 3182, 0))
			.objectId(ObjectID.CRATE_18506)
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_3525)
			.location(new ClueArea(3026, 3628, 0))
			.objectId(ObjectID.CRATE_354)
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_7239)
			.location(new ClueArea(3020, 3911, 3022, 3913, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_HARD_7241)
			.location(new ClueArea(2721, 3337, 2723, 3339, 0))
			.build(),

		// Elite
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_12130)
			.location(new ClueArea(2449, 3130, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_19782)
			.location(new ClueArea(2953, 9523, 1))
			.area("In the Mogre Camp, near Port Khazard. You require a Diving Apparatus and a Fishbowl Helmet")
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_19783)
			.location(new ClueArea(2202, 3062, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_19784)
			.location(new ClueArea(1815, 3852, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_19785)
			.location(new ClueArea(3538, 3208, 0))
			.build(),
		MapClue.builder()
			.clueId(ItemID.CLUE_SCROLL_ELITE_19786)
			.location(new ClueArea(2703, 2716, 0))
			.objectId(ObjectID.CRATE_6616)
			.build(),

		// X Marks the Spot
		// TODO
		MapClue.builder()
			.clueId(ItemID.TREASURE_SCROLL_23068)
			.location(new ClueArea(3203, 3213, 0))
			.build(),
		// TODO
		MapClue.builder()
			.clueId(ItemID.MYSTERIOUS_ORB_23069)
			.location(new ClueArea(3108, 3262, 0))
			.build()
	);

	private final int widgetId;

	private final String type = "Map Clue";

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
	}

	// Beginner Map Clues all use the same ItemID, but the WidgetID used to display them is unique
	@Nullable
	public static MapClue forWidgetID(int widgetId)
	{
		for (MapClue clue : CLUES)
		{
			if (clue.widgetId == widgetId)
			{
				return clue;
			}
		}

		return null;
	}

	@Nullable
	public static MapClue forItemId(int itemId)
	{
		for (MapClue clue : CLUES)
		{
			if (clue.clueId == itemId)
			{
				return clue;
			}
		}

		return null;
	}
}
