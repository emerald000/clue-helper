package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.enums.ClueQuest;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

public class ElunedLocation extends NPCLocation {

    public ElunedLocation() {
        super(100000, 100000, new WorldPoint(0, 0, 0),
                NpcID.ELUNED,
                NpcID.ELUNED_8766,
                NpcID.ELUNED_8767,
                NpcID.ELUNED_8829,
                NpcID.ELUNED_9145);
    }

    @Override
    public WorldPoint getWorldPoint(final Client client) {
        if (client.getVarbitValue(9050) < 2) {
            // In one of two clearings
            // TODO: (2290, 3146, 0)
            return new WorldPoint(2206, 3158, 0);
        }
        if (client.getVarbitValue(797) == 1) {
            // In Lletya headquarters
            return new WorldPoint(2353, 3171, 0);
        }
        final int songOfTheElvesProgress = client.getVarbitValue(ClueQuest.SONG_OF_THE_ELVES.getVarbit());
        if (songOfTheElvesProgress <= 162) {
            // In Lletya
            // TODO: Burning Lletya
            return new WorldPoint(2326, 3161, 0);
        }
        if (songOfTheElvesProgress < ClueQuest.SONG_OF_THE_ELVES.getCompletedValue()) {
            // Underground Pass
            return new WorldPoint(2448, 6089, 0);
        }
        // Prifddinas
        return new WorldPoint(3229, 6062, 0);
    }
}
