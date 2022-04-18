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
package emerald000.cluehelper.clues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
@AllArgsConstructor
public class ClueArea
{
	private final int westLimit;
	private final int southLimit;
	private final int eastLimit;
	private final int northLimit;
	private final int lowerPlane;
	private final int higherPlane;

	// Single tile
	ClueArea(int x, int y, int plane)
	{
		this(x, y, x, y, plane, plane);
	}

	// Single plane
	ClueArea(int westLimit, int southLimit, int eastLimit, int northLimit, int plane)
	{
		this(westLimit, southLimit, eastLimit, northLimit, plane, plane);
	}

	public WorldPoint getCenterWorldPoint()
	{
		return new WorldPoint(
			(westLimit + eastLimit) / 2,
			(southLimit + northLimit) / 2,
			lowerPlane);
	}

	public WorldPoint getSouthWestLowerWorldPoint()
	{
		return new WorldPoint(westLimit, southLimit, lowerPlane);
	}

	public WorldPoint getNorthEastHigherWorldPoint()
	{
		return new WorldPoint(eastLimit, northLimit, higherPlane);
	}
}
