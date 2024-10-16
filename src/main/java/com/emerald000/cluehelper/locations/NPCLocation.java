package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NPCLocation implements NPCLocationInterface {

    private final WorldPoint centreWorldPoint;
    private final int radiusX;
    private final int radiusY;
    private final List<Integer> npcIds = new ArrayList<>(1);

    public NPCLocation(final WorldPoint centreWorldPoint, final int... npcIds) {
        this(100000, 100000, centreWorldPoint, npcIds);
    }

    public NPCLocation(final int radiusX, final int radiusY, final WorldPoint centreWorldPoint, final int... npcIds) {
        this.centreWorldPoint = centreWorldPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        for (final int npcId : npcIds) {
            this.npcIds.add(npcId);
        }
    }

    @Override
    public WorldPoint getWorldPoint(final Client client) {
        return centreWorldPoint;
    }

    @Override
    public final void processNewActiveClue(final ClueHelperPlugin plugin) {
        for (final NPC npc : plugin.getClient().getTopLevelWorldView().npcs()) {
            if (npcIds.contains(npc.getId())) {
                final WorldPoint npcLocation = npc.getWorldLocation();
                if (npcLocation.getPlane() == centreWorldPoint.getPlane()
                        && npcLocation.getX() >= centreWorldPoint.getX() - radiusX
                        && npcLocation.getX() <= centreWorldPoint.getX() + radiusX
                        && npcLocation.getY() >= centreWorldPoint.getY() - radiusY
                        && npcLocation.getY() <= centreWorldPoint.getY() + radiusY) {
                    plugin.getHighlightedNPCs().add(npc);
                }
            }
        }
    }
}
