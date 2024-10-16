package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.ClueHelperPlugin;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;

import java.awt.Graphics2D;

@FunctionalInterface
public interface ClueLocation {
    WorldPoint getWorldPoint(Client client);

    default void renderWorldOverlay(final ClueHelperPlugin plugin, final Graphics2D graphics2D) {

    }

    default void processNewActiveClue(final ClueHelperPlugin plugin) {

    }
}
