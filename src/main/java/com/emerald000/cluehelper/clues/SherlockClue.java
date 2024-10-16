package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.ClueLocation;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.Getter;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

@Getter
public class SherlockClue extends Clue {

    private final boolean challengeKnown;

    public SherlockClue(final int clueId, final ClueTier tier, final boolean challengeKnown) {
        setClueId(clueId);
        setTier(tier);
        setDescription(new TextDescription("Sherlock, south of Seers' Village"));
        setLocation(new NPCLocation(new WorldPoint(2733, 3413, 0), NpcID.SHERLOCK));
        setIconId(tier.getItemImageId());
        this.challengeKnown = challengeKnown;
    }

    public SherlockClue(final int clueId, final ClueTier tier, final String description, final ClueLocation location, final ClueModule... clueModules) {
        setClueId(clueId);
        setTier(tier);
        setDescription(new TextDescription(description));
        setLocation(location);
        setIconId(tier.getItemImageId());
        for (final ClueModule clueModule : clueModules) {
            addClueModule(clueModule);
        }
        this.challengeKnown = true;
    }
}
