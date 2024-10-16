package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ObjectLocation implements ObjectLocationInterface {

    private final WorldPoint worldPoint;
    @Getter
    private final List<Integer> objectIds = new ArrayList<>(1);

    public ObjectLocation(final WorldPoint worldPoint, final int... objectIds) {
        this.worldPoint = worldPoint;
        for (final int id : objectIds) {
            this.objectIds.add(id);
        }
    }

    @Override
    public final WorldPoint getWorldPoint(final Client client) {
        return worldPoint;
    }

    @Override
    public final void processNewActiveClue(final ClueHelperPlugin plugin) {
        final LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient().getTopLevelWorldView(), getWorldPoint(plugin.getClient()).getX(), getWorldPoint(plugin.getClient()).getY());
        if (localLocation != null) {
            final Tile tile = plugin.getClient().getTopLevelWorldView().getScene().getTiles()[getWorldPoint(plugin.getClient()).getPlane()][localLocation.getSceneX()][localLocation.getSceneY()];
            if (tile != null) {
                for (final GameObject gameObject : tile.getGameObjects()) {
                    if (gameObject != null && objectIds.contains(gameObject.getId())) {
                        plugin.getHighlightedObjects().add(gameObject);
                    }
                }
            }
        }
    }
}
