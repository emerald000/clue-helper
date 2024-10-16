package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.KeyClueDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.KeyClueLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.locations.ObjectLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.Client;

public class KeyClue extends Clue {

    private final KeyClueLocation keyClueLocation;

    public KeyClue(final int clueId,
                   final ClueTier tier,
                   final String keyDescription,
                   final NPCLocation keyLocation,
                   final int keyId,
                   final String finalDescription,
                   final ObjectLocation finalLocation,
                   final ClueModule... requirements) {
        setClueId(clueId);
        setTier(tier);
        setDescription(new KeyClueDescription(keyDescription, keyId, finalDescription));
        keyClueLocation = new KeyClueLocation(keyLocation, keyId, finalLocation);
        setLocation(keyClueLocation);
        setIconId(tier.getItemImageId());
        for (final ClueModule clueModule : requirements) {
            addClueModule(clueModule);
        }
    }

    public boolean hasKey(final Client client) {
        return keyClueLocation.hasKey(client);
    }
}
