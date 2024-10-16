package com.emerald000.cluehelper;

import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.KeyClue;
import com.emerald000.cluehelper.modules.ClueModule;
import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Scene;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;

public final class ClueHelperWorldOverlay extends Overlay {

    private final ClueHelperPlugin plugin;

    static private final Color BORDER_COLOR = Color.CYAN;
    static private final Color FILL_COLOR = new Color(0, 255, 255, 20);
    static private final int EXTENDED_SCENE_OFFSET = (Constants.EXTENDED_SCENE_SIZE - Constants.SCENE_SIZE) / 2;

    @Inject
    private ClueHelperWorldOverlay(final ClueHelperPlugin plugin) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
    }

    @Nullable
    @Override
    public Dimension render(final Graphics2D graphics2D) {
        // Render STASH highlights
        for (final WorldPoint worldPoint : plugin.getStashesUsed()) {
            if (worldPoint.getPlane() == plugin.getClient().getLocalPlayer().getWorldLocation().getPlane()) {
                final LocalPoint localPoint = LocalPoint.fromWorld(plugin.getClient().getTopLevelWorldView(), worldPoint.getX(), worldPoint.getY());
                if (localPoint != null) {
                    final Polygon polygon = Perspective.getCanvasTilePoly(plugin.getClient(), localPoint);
                    if (polygon != null) {
                        OverlayUtil.renderPolygon(graphics2D, polygon, Color.RED);
                    }
                }
            }
        }

        final Clue clue = plugin.getActiveClue();
        if (clue == null) {
            return null;
        }

        // Render object highlights
        // Don't show for KeyClue steps if you don't have the key
        if (!(clue instanceof KeyClue) || ((KeyClue) clue).hasKey(plugin.getClient())) {
            for (final GameObject gameObject : plugin.getHighlightedObjects()) {
                if (gameObject.getPlane() != plugin.getClient().getTopLevelWorldView().getPlane()) {
                    continue;
                }
                final Shape shape = gameObject.getConvexHull();
                if (shape != null) {
                    graphics2D.setColor(BORDER_COLOR);
                    graphics2D.draw(shape);
                    graphics2D.setColor(FILL_COLOR);
                    graphics2D.fill(shape);
                }
            }
        }

        // Render NPC highlights
        // Don't show for KeyClue steps once you have the key
        if (!(clue instanceof KeyClue) || !((KeyClue) clue).hasKey(plugin.getClient())) {
            for (final NPC npc : plugin.getHighlightedNPCs()) {
                OverlayUtil.renderActorOverlayImage(graphics2D, npc, plugin.getActiveClue().getImage(plugin), Color.CYAN, 0);
            }
        }

        // Render location highlights
        if (clue.getLocation() != null) {
            clue.getLocation().renderWorldOverlay(plugin, graphics2D);
        }

        // Render modules
        for (final ClueModule module : clue.getClueModules()) {
            module.renderWorldOverlay(plugin, graphics2D);
        }
        return null;
    }

    public static Polygon getAreaPolygon(final Client client, int westWorld, int southWorld, int eastWorld, int northWorld, final int plane) {
        final Polygon poly = new Polygon();

        // Check that the area is in the scene
        if (plane != client.getTopLevelWorldView().getPlane()) {
            return poly;
        }
        final WorldView worldView = client.getTopLevelWorldView();
        final Scene scene = worldView.getScene();
        final int westScene = scene.getBaseX() - EXTENDED_SCENE_OFFSET;
        final int southScene = scene.getBaseY() - EXTENDED_SCENE_OFFSET;
        final int eastScene = westScene + Constants.EXTENDED_SCENE_SIZE;
        final int northScene = southScene + Constants.EXTENDED_SCENE_SIZE;
        if (westWorld > eastScene || westScene > eastWorld || southWorld > northScene || southScene > northWorld) {
            return poly;
        }

        // If part of the area is outside the extended scene, shrink the area so it fits
        if (westWorld < westScene) {
            westWorld = westScene + 1;
        }
        if (southWorld < southScene) {
            southWorld = southScene + 1;
        }
        if (eastWorld > eastScene) {
            eastWorld = eastScene - 1;
        }
        if (northWorld > northScene) {
            northWorld = northScene - 1;
        }

        final byte[][][] tileSettings = scene.getExtendedTileSettings();

        // SW (inclusive) to NW (exclusive)
        for (int y = southWorld; y <= northWorld; y++) {
            LocalPoint localPoint = getLocalPointFromExtendedScene(worldView, westWorld - westScene, y - southScene);
            localPoint = localPoint.plus(1 - Perspective.LOCAL_TILE_SIZE / 2, 1 - Perspective.LOCAL_TILE_SIZE / 2);

            // Adjust for bridges
            int adjustedPlane = plane;
            if (plane < Constants.MAX_Z - 1 && (tileSettings[1][westWorld - westScene][y - southScene] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE) {
                adjustedPlane++;
            }
            final int height = getHeight(scene, localPoint.getX(), localPoint.getY(), adjustedPlane);
            final Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), height);
            if (point != null) {
                poly.addPoint(point.getX(), point.getY());
            }
        }

        // NW (inclusive) to NE (exclusive)
        for (int x = westWorld; x <= eastWorld; x++) {
            LocalPoint localPoint = getLocalPointFromExtendedScene(worldView, x - westScene, northWorld - southScene);
            localPoint = localPoint.plus(1 - Perspective.LOCAL_TILE_SIZE / 2, 1 + Perspective.LOCAL_TILE_SIZE / 2);

            // Adjust for bridges
            int adjustedPlane = plane;
            if (plane < Constants.MAX_Z - 1 && (tileSettings[1][x - westScene][northWorld - southScene] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE) {
                adjustedPlane++;
            }
            final int height = getHeight(scene, localPoint.getX(), localPoint.getY(), adjustedPlane);
            final Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), height);
            if (point != null) {
                poly.addPoint(point.getX(), point.getY());
            }
        }

        // NE (inclusive) to SE (exclusive)
        for (int y = northWorld; y >= southWorld; y--) {
            LocalPoint localPoint = getLocalPointFromExtendedScene(worldView, eastWorld - westScene, y - southScene);
            localPoint = localPoint.plus(1 + Perspective.LOCAL_TILE_SIZE / 2, 1 + Perspective.LOCAL_TILE_SIZE / 2);

            // Adjust for bridges
            int adjustedPlane = plane;
            if (plane < Constants.MAX_Z - 1 && (tileSettings[1][eastWorld - westScene][y - southScene] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE) {
                adjustedPlane++;
            }
            final int height = getHeight(scene, localPoint.getX(), localPoint.getY(), adjustedPlane);
            final Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), height);
            if (point != null) {
                poly.addPoint(point.getX(), point.getY());
            }
        }

        // SE (inclusive) to SW (exclusive)
        for (int x = eastWorld; x >= westWorld; x--) {
            LocalPoint localPoint = getLocalPointFromExtendedScene(worldView, x - westScene, southWorld - southScene);
            localPoint = localPoint.plus(1 + Perspective.LOCAL_TILE_SIZE / 2, 1 - Perspective.LOCAL_TILE_SIZE / 2);

            // Adjust for bridges
            int adjustedPlane = plane;
            if (plane < Constants.MAX_Z - 1 && (tileSettings[1][x - westScene][southWorld - southScene] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE) {
                adjustedPlane++;
            }
            final int height = getHeight(scene, localPoint.getX(), localPoint.getY(), adjustedPlane);
            final Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), height);
            if (point != null) {
                poly.addPoint(point.getX(), point.getY());
            }
        }

        return poly;
    }

    private static LocalPoint getLocalPointFromExtendedScene(final WorldView worldView, final int extendedSceneX, final int extendedSceneY) {
        return new LocalPoint((extendedSceneX << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - EXTENDED_SCENE_OFFSET * Perspective.LOCAL_TILE_SIZE, (extendedSceneY << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - EXTENDED_SCENE_OFFSET * Perspective.LOCAL_TILE_SIZE, worldView.getId());
    }

    private static int getHeight(@Nonnull final Scene scene, final int localX, final int localY, final int plane) {
        final int sceneX = (localX >> Perspective.LOCAL_COORD_BITS) + EXTENDED_SCENE_OFFSET;
        final int sceneY = (localY >> Perspective.LOCAL_COORD_BITS) + EXTENDED_SCENE_OFFSET;
        if (sceneX >= 0 && sceneY >= 0 && sceneX < Constants.EXTENDED_SCENE_SIZE && sceneY < Constants.EXTENDED_SCENE_SIZE) {
            final int[][][] tileHeights = scene.getTileHeights();

            final int x = localX & (Perspective.LOCAL_TILE_SIZE - 1);
            final int y = localY & (Perspective.LOCAL_TILE_SIZE - 1);
            final int var8 = x * tileHeights[plane][sceneX + 1][sceneY] + (Perspective.LOCAL_TILE_SIZE - x) * tileHeights[plane][sceneX][sceneY] >> Perspective.LOCAL_COORD_BITS;
            final int var9 = tileHeights[plane][sceneX][sceneY + 1] * (Perspective.LOCAL_TILE_SIZE - x) + x * tileHeights[plane][sceneX + 1][sceneY + 1] >> Perspective.LOCAL_COORD_BITS;
            return (Perspective.LOCAL_TILE_SIZE - y) * var8 + y * var9 >> Perspective.LOCAL_COORD_BITS;
        }

        return 0;
    }

}