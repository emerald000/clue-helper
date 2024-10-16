package com.emerald000.cluehelper.descriptions;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.ClueQuest;
import net.runelite.api.Client;

public class ElunedDescription implements ClueDescription {
    @Override
    public String getText(final ClueHelperPlugin plugin) {
        final Client client = plugin.getClient();
        final int regicideProgress = client.getVarpValue(ClueQuest.REGICIDE.getVarPlayer());
        if (client.getVarbitValue(9050) < 2) {
            // In one of two clearings
            return "Isafdar, Eluned (may need to wait/hop worlds)";
        }
        if (client.getVarbitValue(797) == 1) {
            // In Lletya headquarters
            return "Lletya, east building";
        }
        final int songOfTheElvesProgress = client.getVarbitValue(ClueQuest.SONG_OF_THE_ELVES.getVarbit());
        if (songOfTheElvesProgress <= 162) {
            // In Lletya
            return "Lletya, south-west corner";
        }
        if (songOfTheElvesProgress < ClueQuest.SONG_OF_THE_ELVES.getCompletedValue()) {
            // Underground Pass
            return "Underground Pass, lower floor buildings";
        }
        // Prifddinas
        return "Prifddinas, south-west of house portal";
    }
}
