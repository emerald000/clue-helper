package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import java.awt.Graphics2D;

@AllArgsConstructor
@Getter
public class ObjectHighlightModule implements ClueModule {

    private WorldPoint location;
    private int objectId;

    @Override
    public final void processNewActiveClue(final ClueHelperPlugin plugin) {
        final LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient().getTopLevelWorldView(), location.getX(), location.getY());
        if (localLocation != null) {
            final Tile tile = plugin.getClient().getTopLevelWorldView().getScene().getTiles()[location.getPlane()][localLocation.getSceneX()][localLocation.getSceneY()];
            if (tile != null) {
                for (final GameObject gameObject : tile.getGameObjects()) {
                    if (gameObject != null && objectId == gameObject.getId()) {
                        plugin.getHighlightedObjects().add(gameObject);
                    }
                }
            }
        }
    }
}
