/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package com.emerald000.cluehelper;

import com.emerald000.cluehelper.enums.ClueTier;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

import java.awt.image.BufferedImage;

final class ClueHelperWorldMapPoint extends WorldMapPoint {
    private final ClueHelperPlugin plugin;
    private final ClueTier clueTier;
    private final BufferedImage image;
    private final Point point;

    ClueHelperWorldMapPoint(final ClueHelperPlugin plugin, final WorldPoint worldPoint, final ClueTier clueTier) {
        super(worldPoint, null);

        this.plugin = plugin;
        this.clueTier = clueTier;
        this.image = plugin.getWorldMapImage(clueTier);
        this.point = new Point(image.getWidth() / 2, image.getHeight());

        setSnapToEdge(true);
        setJumpOnClick(true);
        setName(clueTier.getName());
        setImage(image);
        setImagePoint(point);
    }

    @Override
    public void onEdgeSnap() {
        setImage(plugin.getItemManager().getImage(clueTier.getItemImageId()));
        setImagePoint(null);
    }

    @Override
    public void onEdgeUnsnap() {
        setImage(image);
        setImagePoint(point);
    }
}
