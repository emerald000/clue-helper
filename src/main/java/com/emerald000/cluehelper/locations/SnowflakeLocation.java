package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.enums.ClueQuest;
import net.runelite.api.Client;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

public class SnowflakeLocation extends NPCLocation {
    public SnowflakeLocation() {
        super(new WorldPoint(0, 0, 0), NpcID.SNOWFLAKE);
    }

    @Override
    public WorldPoint getWorldPoint(final Client client) {
        final int questProgress = client.getVarbitValue(ClueQuest.MAKING_FRIENDS_WITH_MY_ARM.getVarbit());
        if (questProgress <= 144) {
            return new WorldPoint(2878, 3948, 0);
        } else {
            return new WorldPoint(2872, 3934, 0);
        }
    }
}
