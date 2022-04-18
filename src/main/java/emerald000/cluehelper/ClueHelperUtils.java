package emerald000.cluehelper;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javax.annotation.Nonnull;
import net.runelite.api.Client;
import net.runelite.api.Constants;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayUtil;

public class ClueHelperUtils
{
	public static void renderSquareOverlay(Client client, Graphics2D graphics, LocalPoint localLocation, BufferedImage image, Color color, int size)
	{
		final int swX = localLocation.getX() - ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);
		final int swY = localLocation.getY() - ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);
		final LocalPoint swLocalLocation = new LocalPoint(swX, swY);

		final int neX = localLocation.getX() + ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);
		final int neY = localLocation.getY() + ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);
		final LocalPoint neLocalLocation = new LocalPoint(neX, neY);

		renderRectangleOverlay(client, graphics, swLocalLocation, neLocalLocation, image, color);
	}

	//TODO: Comment
	public static void renderRectangleOverlay(Client client, Graphics2D graphics, LocalPoint swLocalLocation, LocalPoint neLocalLocation, BufferedImage image, Color color)
	{
		final Polygon poly = ClueHelperUtils.getCanvasTileRectanglePoly(client, swLocalLocation, neLocalLocation);

		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
		}

		final LocalPoint centerLocalLocation = new LocalPoint(
			(swLocalLocation.getX() + neLocalLocation.getX()) / 2,
			(swLocalLocation.getY() + neLocalLocation.getY()) / 2);

		if (image != null)
		{
			OverlayUtil.renderImageLocation(client, graphics, centerLocalLocation, image, 0);
		}
	}

	// TODO: Simplify
	/**
	 * Returns a polygon representing a rectangular area.
	 *
	 * @param client the game client
	 * @param swLocalLocation the southwesternmost location of the rectangle
	 * @param neLocalLocation the northeasternmost location of the rectangle
	 * @return a polygon representing the tiles in the area
	 */
	public static Polygon getCanvasTileRectanglePoly(@Nonnull Client client, @Nonnull LocalPoint swLocalLocation, @Nonnull LocalPoint neLocalLocation)
	{
		final int plane = client.getPlane();
		final byte[][][] tileSettings = client.getTileSettings();
		Polygon poly = new Polygon();

		// SW (inclusive) to NW (exclusive)
		for (int y = swLocalLocation.getY() - (Perspective.LOCAL_TILE_SIZE / 2); y <= neLocalLocation.getY() - (Perspective.LOCAL_TILE_SIZE / 2); y += Perspective.LOCAL_TILE_SIZE)
		{
			LocalPoint localPoint = new LocalPoint(swLocalLocation.getX() - (Perspective.LOCAL_TILE_SIZE / 2), y);

			// Check if the center of the tile is a bridge. Increase plane if it is.
			LocalPoint centerPoint = new LocalPoint(localPoint.getX() + Perspective.LOCAL_TILE_SIZE / 2, localPoint.getY() + Perspective.LOCAL_TILE_SIZE / 2);
			final int sceneX = centerPoint.getSceneX();
			final int sceneY = centerPoint.getSceneY();
			if (sceneX < 0 || sceneY < 0 || sceneX >= Perspective.SCENE_SIZE || sceneY >= Perspective.SCENE_SIZE)
			{
				return null;
			}
			int centerPlane = plane;
			if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE)
			{
				centerPlane += 1;
			}

			Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), ClueHelperUtils.getHeight(client, localPoint.getX(), localPoint.getY(), centerPlane));
			if (point != null)
			{
				poly.addPoint(point.getX(), point.getY());
			}
		}

		// NW (inclusive) to NE (exclusive)
		for (int x = swLocalLocation.getX() - (Perspective.LOCAL_TILE_SIZE / 2); x <= neLocalLocation.getX() - (Perspective.LOCAL_TILE_SIZE / 2); x += Perspective.LOCAL_TILE_SIZE)
		{
			LocalPoint localPoint = new LocalPoint(x, neLocalLocation.getY() + (Perspective.LOCAL_TILE_SIZE / 2));

			// Check if the center of the tile is a bridge. Increase plane if it is.
			LocalPoint centerPoint = new LocalPoint(localPoint.getX() + Perspective.LOCAL_TILE_SIZE / 2, localPoint.getY() - Perspective.LOCAL_TILE_SIZE / 2);
			final int sceneX = centerPoint.getSceneX();
			final int sceneY = centerPoint.getSceneY();
			if (sceneX < 0 || sceneY < 0 || sceneX >= Perspective.SCENE_SIZE || sceneY >= Perspective.SCENE_SIZE)
			{
				return null;
			}
			int centerPlane = plane;
			if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE)
			{
				centerPlane += 1;
			}

			Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), ClueHelperUtils.getHeight(client, localPoint.getX(), localPoint.getY(), centerPlane));
			if (point != null)
			{
				poly.addPoint(point.getX(), point.getY());
			}
		}

		// NE (inclusive) to SE (exclusive)
		for (int y = neLocalLocation.getY() + (Perspective.LOCAL_TILE_SIZE / 2); y >= swLocalLocation.getY() + (Perspective.LOCAL_TILE_SIZE / 2); y -= Perspective.LOCAL_TILE_SIZE)
		{
			LocalPoint localPoint = new LocalPoint(neLocalLocation.getX() + (Perspective.LOCAL_TILE_SIZE / 2), y);

			// Check if the center of the tile is a bridge. Increase plane if it is.
			LocalPoint centerPoint = new LocalPoint(localPoint.getX() - Perspective.LOCAL_TILE_SIZE / 2, localPoint.getY() - Perspective.LOCAL_TILE_SIZE / 2);
			final int sceneX = centerPoint.getSceneX();
			final int sceneY = centerPoint.getSceneY();
			if (sceneX < 0 || sceneY < 0 || sceneX >= Perspective.SCENE_SIZE || sceneY >= Perspective.SCENE_SIZE)
			{
				return null;
			}
			int centerPlane = plane;
			if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE)
			{
				centerPlane += 1;
			}

			Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), ClueHelperUtils.getHeight(client, localPoint.getX(), localPoint.getY(), centerPlane));
			if (point != null)
			{
				poly.addPoint(point.getX(), point.getY());
			}
		}

		// SE (inclusive) to SW (exclusive)
		for (int x = neLocalLocation.getX() + (Perspective.LOCAL_TILE_SIZE / 2); x >= swLocalLocation.getX() + (Perspective.LOCAL_TILE_SIZE / 2); x -= Perspective.LOCAL_TILE_SIZE)
		{
			LocalPoint localPoint = new LocalPoint(x, swLocalLocation.getY() - (Perspective.LOCAL_TILE_SIZE / 2));

			// Check if the center of the tile is a bridge. Increase plane if it is.
			LocalPoint centerPoint = new LocalPoint(localPoint.getX() - Perspective.LOCAL_TILE_SIZE / 2, localPoint.getY() + Perspective.LOCAL_TILE_SIZE / 2);
			final int sceneX = centerPoint.getSceneX();
			final int sceneY = centerPoint.getSceneY();
			if (sceneX < 0 || sceneY < 0 || sceneX >= Perspective.SCENE_SIZE || sceneY >= Perspective.SCENE_SIZE)
			{
				return null;
			}
			int centerPlane = plane;
			if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & Constants.TILE_FLAG_BRIDGE) == Constants.TILE_FLAG_BRIDGE)
			{
				centerPlane += 1;
			}

			Point point = Perspective.localToCanvas(client, localPoint.getX(), localPoint.getY(), ClueHelperUtils.getHeight(client, localPoint.getX(), localPoint.getY(), centerPlane));
			if (point != null)
			{
				poly.addPoint(point.getX(), point.getY());
			}
		}

		return poly;
	}

	/**
	 * Get the height of a location, in local coordinates. Interpolates the height from the adjacent tiles.
	 * Does not account for bridges.
	 * @param client
	 * @param localX
	 * @param localY
	 * @param plane
	 * @return
	 */
	private static int getHeight(@Nonnull Client client, int localX, int localY, int plane)
	{
		int sceneX = localX >> Perspective.LOCAL_COORD_BITS;
		int sceneY = localY >> Perspective.LOCAL_COORD_BITS;
		if (sceneX >= 0 && sceneY >= 0 && sceneX < Perspective.SCENE_SIZE && sceneY < Perspective.SCENE_SIZE)
		{
			int[][][] tileHeights = client.getTileHeights();

			int x = localX & (Perspective.LOCAL_TILE_SIZE - 1);
			int y = localY & (Perspective.LOCAL_TILE_SIZE - 1);
			int var8 = x * tileHeights[plane][sceneX + 1][sceneY] + (Perspective.LOCAL_TILE_SIZE - x) * tileHeights[plane][sceneX][sceneY] >> Perspective.LOCAL_COORD_BITS;
			int var9 = tileHeights[plane][sceneX][sceneY + 1] * (Perspective.LOCAL_TILE_SIZE - x) + x * tileHeights[plane][sceneX + 1][sceneY + 1] >> Perspective.LOCAL_COORD_BITS;
			return (Perspective.LOCAL_TILE_SIZE - y) * var8 + y * var9 >> Perspective.LOCAL_COORD_BITS;
		}

		return 0;
	}

	/**
	 * Gets the local coordinate at the center of the passed tile or the closest one if not in the scene.
	 *
	 * @param client the client
	 * @param world  the passed tile
	 * @return coordinate of the tile or the closest one in the scene
	 */
	public static LocalPoint closestInScene(Client client, WorldPoint world)
	{
		if (client.getPlane() != world.getPlane())
		{
			return null;
		}
		return closestInScene(client, world.getX(), world.getY());
	}

	/**
	 * Gets the local coordinate at the center of the passed tile or the closest one if not in the scene.
	 *
	 * @param client the client
	 * @param x      x-axis coordinate of the tile
	 * @param y      y-axis coordinate of the tile
	 * @return coordinate of the tile or the closest one in the scene
	 */
	public static LocalPoint closestInScene(Client client, int x, int y)
	{
		final int baseX = client.getBaseX();
		final int baseY = client.getBaseY();

		int clampedX = x - baseX;
		if (clampedX < 0)
		{
			clampedX = 0;
		}
		else if (clampedX > Constants.SCENE_SIZE - 1)
		{
			clampedX = Constants.SCENE_SIZE - 1;
		}

		int clampedY = y - baseY;
		if (clampedY < 0)
		{
			clampedY = 0;
		}
		else if (clampedY > Constants.SCENE_SIZE - 1)
		{
			clampedY = Constants.SCENE_SIZE - 1;
		}
		return LocalPoint.fromScene(clampedX, clampedY);
	}
}

