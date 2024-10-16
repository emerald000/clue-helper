package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.enums.ClueQuest;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

public class RadimusErkleLocation extends NPCLocation {

    public RadimusErkleLocation() {
        super(100000, 100000, new WorldPoint(0, 0, 0),
                NpcID.RADIMUS_ERKLE);
    }

    @Override
    public WorldPoint getWorldPoint(final Client client) {
        if (client.getVarpValue(ClueQuest.LEGENDS_QUEST.getVarPlayer()) < 50) {
            return new WorldPoint(2724, 3368, 0);
        }
        else {
            return new WorldPoint(2724, 3378, 0);
        }
    }
}
