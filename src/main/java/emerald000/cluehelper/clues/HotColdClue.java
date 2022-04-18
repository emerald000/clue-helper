/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
 * Copyright (c) 2019, Jordan Atwood <nightfirecat@protonmail.com>
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import static emerald000.cluehelper.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import emerald000.cluehelper.ClueHelperPlugin;
import emerald000.cluehelper.clues.hotcold.HotColdArea;
import emerald000.cluehelper.clues.hotcold.HotColdLocation;
import emerald000.cluehelper.clues.hotcold.HotColdSolver;
import emerald000.cluehelper.clues.hotcold.HotColdTemperature;
import emerald000.cluehelper.clues.hotcold.HotColdTemperatureChange;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

@EqualsAndHashCode(callSuper = false, exclude = {"hotColdSolver", "finalLocation"})
@Getter
@SuperBuilder
@Slf4j
public class HotColdClue extends ClueScroll implements MultipleLocationsClueScroll
{
	public static final HotColdClue BEGINNER_CLUE = HotColdClue.builder()
		.text("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Reldo may have a clue.")
		.area("Varrock Castle")
		.npc("Reldo")
		.location(new ClueArea(3211, 3494, 0))
		.hotColdSolver(initializeSolver(true))
		.build();

	private static final HotColdClue MASTER_CLUE = HotColdClue.builder()
		.text("Buried beneath the ground, who knows where it's found. Lucky for you, A man called Jorral may have a clue.")
		.area("Outpost")
		.npc("Jorral")
		.location(new ClueArea(2436, 3347, 0))
		.hotColdSolver(initializeSolver(false))
		.build();

	@Nullable
	private HotColdSolver hotColdSolver;
	@Nullable
	private WorldPoint finalLocation;

	private final String type = "Hot Cold Clue";

	@Nullable
	public static HotColdClue forText(String text)
	{
		if (text.equalsIgnoreCase(BEGINNER_CLUE.getText()))
		{
			BEGINNER_CLUE.reset();
			return BEGINNER_CLUE;
		}
		else if (text.equalsIgnoreCase(MASTER_CLUE.getText()))
		{
			MASTER_CLUE.reset();
			return MASTER_CLUE;
		}

		return null;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
		if (hotColdSolver != null)
		{
			// strange device has not been tested yet, show how to get it
			if (hotColdSolver.getLastWorldPoint() == null && finalLocation == null)
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Use the Strange Device.")
					.leftColor(TITLED_CONTENT_COLOR)
					.build());
			}
			// strange device has been tested, show possible locations for final dig spot
			else
			{
				panelComponent.getChildren().add(LineComponent.builder()
					.left("Possible locations:")
					.build());

				final Map<HotColdArea, Integer> locationCounts = new EnumMap<>(HotColdArea.class);
				final Collection<HotColdLocation> digLocations = hotColdSolver.getPossibleLocations();

				for (HotColdLocation hotColdLocation : digLocations)
				{
					HotColdArea hotColdArea = hotColdLocation.getHotColdArea();

					if (locationCounts.containsKey(hotColdArea))
					{
						locationCounts.put(hotColdArea, locationCounts.get(hotColdArea) + 1);
					}
					else
					{
						locationCounts.put(hotColdArea, 1);
					}
				}

				if (digLocations.size() > 10)
				{
					for (HotColdArea area : locationCounts.keySet())
					{
						panelComponent.getChildren().add(LineComponent.builder()
							.left(area.getName())
							.right(Integer.toString(locationCounts.get(area)))
							.build());
					}
				}
				else
				{
					for (HotColdArea area : locationCounts.keySet())
					{
						panelComponent.getChildren().add(LineComponent.builder()
							.left(area.getName() + ':')
							.build());

						for (HotColdLocation hotColdLocation : digLocations)
						{
							if (hotColdLocation.getHotColdArea() == area)
							{
								panelComponent.getChildren().add(LineComponent.builder()
									.left("- " + hotColdLocation.getArea())
									.leftColor(Color.LIGHT_GRAY)
									.build());

								if (digLocations.size() <= 5 && hotColdLocation.getEnemy() != null)
								{
									panelComponent.getChildren().add(LineComponent.builder()
										.left(hotColdLocation.getEnemy().getText())
										.leftColor(Color.YELLOW)
										.build());
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
		if (hotColdSolver != null)
		{
			// when final location has been found
			if (finalLocation != null)
			{
				LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), finalLocation);

				if (localLocation != null)
				{
					OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
				}
			}

			// once the number of possible dig locations is below 10, show the dig spots
			final Collection<HotColdLocation> digLocations = hotColdSolver.getPossibleLocations();
			if (digLocations.size() < 10)
			{
				// Mark potential dig locations
				for (HotColdLocation hotColdLocation : digLocations)
				{
					WorldPoint wp = hotColdLocation.getWorldPoint();
					LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), wp.getX(), wp.getY());

					if (localLocation != null)
					{
						final int size;
						if (this == BEGINNER_CLUE)
						{
							size = 7;
						}
						else
						{
							size = 9;
						}

						ClueHelperUtils.renderSquareOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE, size);
					}
				}
			}
		}
	}

	public boolean update(final String message, final ClueHelperPlugin plugin)
	{
		if (hotColdSolver == null)
		{
			return false;
		}

		final Set<HotColdTemperature> temperatureSet;

		if (this == BEGINNER_CLUE)
		{
			temperatureSet = HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES;
		}
		else if (this == MASTER_CLUE)
		{
			temperatureSet = HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES;
		}
		else
		{
			temperatureSet = null;
		}

		final HotColdTemperature temperature = HotColdTemperature.getFromTemperatureSet(temperatureSet, message);

		if (temperature == null)
		{
			return false;
		}

		// Convert from real to overworld
		Player player = plugin.getClient().getLocalPlayer();

		if (player == null)
		{
			return false;
		}

		WorldPoint localWorld = WorldPoint.getMirrorPoint(player.getWorldLocation(), true);
		if (localWorld == null)
		{
			localWorld = player.getWorldLocation();
		}

		boolean master = this == MASTER_CLUE;
		if ((this == BEGINNER_CLUE && temperature == HotColdTemperature.BEGINNER_VISIBLY_SHAKING)
			|| (master && temperature == HotColdTemperature.MASTER_VISIBLY_SHAKING))
		{
			markFinalSpot(localWorld);
		}
		else
		{
			finalLocation = null;
		}

		final HotColdTemperatureChange temperatureChange = HotColdTemperatureChange.of(message);
		hotColdSolver.signal(localWorld, temperature, temperatureChange);

		return true;
	}

	public void reset()
	{
		finalLocation = null;

		if (this == BEGINNER_CLUE)
		{
			this.hotColdSolver = initializeSolver(true);
		}
		else
		{
			this.hotColdSolver = initializeSolver(false);
		}
	}

	@Override
	public List<WorldPoint> getLocations()
	{
		if (hotColdSolver == null)
		{
			return new ArrayList<>();
		}

		if (hotColdSolver.getLastWorldPoint() == null)
		{
			if (getLocation() != null)
			{
				return Collections.singletonList(getLocation().getCenterWorldPoint());
			}
			else
			{
				return new ArrayList<>();
			}
		}
		else
		{
			return hotColdSolver.getPossibleLocations().stream()
				.map(HotColdLocation::getWorldPoint)
				.collect(Collectors.toList());
		}
	}

	private static HotColdSolver initializeSolver(boolean isBeginner)
	{
		final Set<HotColdLocation> locations = Arrays.stream(HotColdLocation.values())
			.filter(l -> l.isBeginnerClue() == isBeginner)
			.collect(Collectors.toSet());
		return new HotColdSolver(locations);
	}

	private void markFinalSpot(WorldPoint wp)
	{
		this.finalLocation = wp;
	}
}
