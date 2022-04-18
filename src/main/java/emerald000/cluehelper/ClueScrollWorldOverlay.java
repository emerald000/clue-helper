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
package emerald000.cluehelper;

import emerald000.cluehelper.clues.ClueArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.NPC;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import emerald000.cluehelper.clues.ClueScroll;
import emerald000.cluehelper.clues.EmoteClue;
import emerald000.cluehelper.clues.ThreeStepCrypticClue;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class ClueScrollWorldOverlay extends Overlay
{
	public static final int IMAGE_Z_OFFSET = 30;

	public static final Color CLICKBOX_BORDER_COLOR = Color.ORANGE;
	public static final Color CLICKBOX_HOVER_BORDER_COLOR = CLICKBOX_BORDER_COLOR.darker();
	public static final Color CLICKBOX_FILL_COLOR = new Color(0, 255, 0, 20);

	private final ClueHelperPlugin plugin;

	@Inject
	private ClueScrollWorldOverlay(ClueHelperPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
	}

	@Nullable
	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Mark NPCs
		for (NPC npc : plugin.getNpcsToMark())
		{
			OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
		}

		// Mark Objects
		for (TileObject gameObject : plugin.getObjectsToMark())
		{
			OverlayUtil.renderHoverableArea(graphics, gameObject.getClickbox(), plugin.getClient().getMouseCanvasPosition(), CLICKBOX_FILL_COLOR, CLICKBOX_BORDER_COLOR, CLICKBOX_HOVER_BORDER_COLOR);

			if (plugin.getClue() != null && plugin.getClue().getObjectId() == gameObject.getId())
			{
				OverlayUtil.renderImageLocation(plugin.getClient(), graphics, gameObject.getLocalLocation(), plugin.getClueScrollImage(), IMAGE_Z_OFFSET);
			}
		}

		ClueScroll clue = plugin.getClue();

		if (clue != null)
		{
			List<ClueScroll> steps = new ArrayList<>();

			if (clue instanceof ThreeStepCrypticClue)
			{
				ThreeStepCrypticClue threeStepsClue = (ThreeStepCrypticClue) clue;
				steps = threeStepsClue.getClueSteps().stream().filter(e -> !e.getValue()).map(Map.Entry::getKey).collect(Collectors.toList());
			}
			else
			{
				steps.add(clue);
			}

			for (ClueScroll step : steps)
			{
				// Draw the overlay only if there are no NPCs and no objects to highlight.
				if (step.getNpc() == null && step.getObjectId() == -1 && step.getLocation() != null)
				{
					// Only draw the location if the client is on one of the planes of the location of the clue step.
					int clientPlane = plugin.getClient().getPlane();
					ClueArea stepArea = step.getLocation();

					if (clientPlane >= stepArea.getLowerPlane() && clientPlane <= stepArea.getHigherPlane())
					{
						WorldPoint swWorldPoint = stepArea.getSouthWestLowerWorldPoint();
						WorldPoint neWorldPoint = stepArea.getNorthEastHigherWorldPoint();

						drawLocationOverlay(graphics, swWorldPoint, neWorldPoint);

						// Some regions are mirrored (e.g. Prifddinas).
						WorldPoint swMirrorLocation = WorldPoint.getMirrorPoint(swWorldPoint, false);
						WorldPoint neMirrorLocation = WorldPoint.getMirrorPoint(neWorldPoint, false);
						if (swMirrorLocation != swWorldPoint || neMirrorLocation != neWorldPoint)
						{
							drawLocationOverlay(graphics, swMirrorLocation, neMirrorLocation);
						}
					}
				}

				// Clue specific overlay
				step.makeWorldOverlayHint(graphics, plugin);
			}
		}

		EmoteClue activeSTASHClue = plugin.getActiveSTASHClue();
		if (activeSTASHClue != null && activeSTASHClue != clue)
		{
			activeSTASHClue.makeSTASHOverlay(graphics, plugin);
		}

		return null;
	}

	private void drawLocationOverlay(Graphics2D graphics, WorldPoint swLocation, WorldPoint neLocation)
	{
		LocalPoint swLocalLocation = LocalPoint.fromWorld(plugin.getClient(), swLocation.getX(), swLocation.getY());
		LocalPoint neLocalLocation = LocalPoint.fromWorld(plugin.getClient(), neLocation.getX(), neLocation.getY());

		// Both corners are in the scene. Simply draw the overlay.
		if (swLocalLocation != null && neLocalLocation != null)
		{
			ClueHelperUtils.renderRectangleOverlay(plugin.getClient(), graphics, swLocalLocation, neLocalLocation, plugin.getEmoteImage(), Color.ORANGE);
		}
		else
		{
			// Some clue areas are really large and don't fit in the whole scene.
			// So we find the closest point in the scene if the location is not in the scene.
			LocalPoint swClosestLocalLocation = ClueHelperUtils.closestInScene(plugin.getClient(), swLocation);
			LocalPoint neClosestLocalLocation = ClueHelperUtils.closestInScene(plugin.getClient(), neLocation);

			// If both corners have different x and y coordinates after bringing them into the scene, the location is partially in the scene.
			if (swClosestLocalLocation != null && neClosestLocalLocation != null && swClosestLocalLocation.getX() != neClosestLocalLocation.getX() && swClosestLocalLocation.getY() != neClosestLocalLocation.getY())
			{
				ClueHelperUtils.renderRectangleOverlay(plugin.getClient(), graphics, swClosestLocalLocation, neClosestLocalLocation, plugin.getEmoteImage(), Color.ORANGE);
			}
		}
	}
}
