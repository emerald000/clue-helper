package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.ClueDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.locations.ClueLocation;
import com.emerald000.cluehelper.modules.ClueModule;

public class BasicClue extends Clue {
    public BasicClue(final int clueId, final ClueTier tier, final String description, final ClueLocation location, final ClueModule... clueModules) {
        this(clueId, tier, new TextDescription(description), location, clueModules);
    }

    public BasicClue(final int clueId, final ClueTier tier, final ClueDescription description, final ClueLocation location, final ClueModule... clueModules) {
        setClueId(clueId);
        setTier(tier);
        setLocation(location);
        setDescription(description);
        setIconId(tier.getItemImageId());
        for (final ClueModule clueModule : clueModules) {
            addClueModule(clueModule);
        }
    }
}
