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

import emerald000.cluehelper.ClueHelperPlugin;
import emerald000.cluehelper.clues.requirement.Requirement;
import emerald000.cluehelper.clues.teleport.Teleport;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import net.runelite.api.Varbits;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;

@SuperBuilder
@Getter
public abstract class ClueScroll
{
	// TODO: Remove
	@Setter(AccessLevel.PROTECTED)
	private boolean requiresSpade;

	// TODO: Remove
	@Setter(AccessLevel.PROTECTED)
	private boolean requiresLight;

	// TODO: Remove
	@Setter(AccessLevel.PROTECTED)
	@Varbit
	@Builder.Default
	private int firePitVarbits = -1;

	@Nullable
	private final String text;
	@Nullable
	private final String area;
	@Nullable
	private final String solution;
	@Nullable
	private final ClueArea location;
	@Nullable
	private final String npc;
	@Builder.Default
	private final int objectId = -1;
	@Nullable
	private final String question;
	@Nullable
	private final String answer;
	@Nullable
	private final Enemy enemy;
	@Builder.Default
	final int clueId = -1;

	@Nonnull
	@Singular
	private final List<Teleport> teleports;
	@Nonnull
	@Singular
	private final List<Requirement> requirements;
	@Nonnull
	@Singular
	private final List<WorldPoint> extraMapPoints;
	@Nonnull
	private final List<ImmutablePair<WorldPoint, Integer>> pathObjects;

	public abstract String getType();

	public void makeOverlayHint(PanelComponent panelComponent, ClueHelperPlugin plugin)
	{
	}

	public void makeWorldOverlayHint(Graphics2D graphics, ClueHelperPlugin plugin)
	{
	}

	static abstract class ClueScrollBuilder<C extends ClueScroll, B extends ClueScrollBuilder<C, B>>
	{
		private List<ImmutablePair<WorldPoint, Integer>> pathObjects = new ArrayList<>();

		// Pretty builder method to add a path object.
		B pathObject(WorldPoint worldPoint, int objectId)
		{
			pathObjects.add(ImmutablePair.of(worldPoint, objectId));
			return self();
		}
	}
}
