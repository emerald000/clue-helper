package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.ClueHelperWorldOverlay;
import com.emerald000.cluehelper.clues.Clue;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.ImageUtil;

import javax.annotation.Nullable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AreaLocation implements ClueLocation {

    private final int west;
    private final int south;
    private final int east;
    private final int north;
    private final int plane;
    private final String imagePath;
    @Nullable
    private BufferedImage image = null;

    public AreaLocation(final int west, final int south, final int east, final int north, final int plane) {
        this(west, south, east, north, plane, "");
    }

    public AreaLocation(final int west, final int south, final int east, final int north, final int plane, final String imagePath) {
        this.west = west;
        this.south = south;
        this.east = east;
        this.north = north;
        this.plane = plane;
        this.imagePath = imagePath;
    }

    @Override
    public final WorldPoint getWorldPoint(final Client client) {
        return new WorldPoint((west + east) / 2, (south + north) / 2, plane);
    }

    @Override
    public final void renderWorldOverlay(final ClueHelperPlugin plugin, final Graphics2D graphics2D) {
        OverlayUtil.renderPolygon(graphics2D, ClueHelperWorldOverlay.getAreaPolygon(plugin.getClient(), west, south, east, north, plane), Color.CYAN);
        final Clue clue = plugin.getActiveClue();
        if (clue != null) {
            LocalPoint localPoint = LocalPoint.fromWorld(plugin.getClient().getTopLevelWorldView(), getWorldPoint(plugin.getClient()));
            if (localPoint != null) {
                if ((east - west) % 2 != 0) {
                    localPoint = localPoint.dx(Perspective.LOCAL_TILE_SIZE / 2);
                }
                if ((north - south) % 2 != 0) {
                    localPoint = localPoint.dy(Perspective.LOCAL_TILE_SIZE / 2);
                }
                BufferedImage imageToShow = image;
                if (imageToShow == null) {
                    if (imagePath.isEmpty()) {
                        imageToShow = clue.getImage(plugin);
                    } else {
                        imageToShow = ImageUtil.loadImageResource(AreaLocation.class, imagePath);
                        image = imageToShow;
                    }
                }
                // TODO: Render extended scene
                OverlayUtil.renderImageLocation(plugin.getClient(), graphics2D, localPoint, imageToShow, 0);
            }
        }
    }
}
