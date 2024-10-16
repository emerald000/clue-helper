package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.enums.Emote;
import com.emerald000.cluehelper.locations.ClueLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import com.emerald000.cluehelper.modules.EmoteModule;
import com.emerald000.cluehelper.modules.StashModule;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

import java.awt.image.BufferedImage;

@Getter
public class EmoteClue extends Clue {

    private final Emote firstEmote;
    private final Emote secondEmote;

    public EmoteClue(final int clueId,
                     final ClueTier tier,
                     final String description,
                     final ClueLocation location,
                     final Emote emote,
                     final ClueModule... requirements) {
        this(clueId, tier, description, location, emote, null, -1, requirements);
    }

    public EmoteClue(final int clueId,
                     final ClueTier tier,
                     final String description,
                     final ClueLocation location,
                     final Emote emote,
                     final WorldPoint stashWorldPoint,
                     final int stashId,
                     final ClueModule... requirements) {
        this(clueId, tier, description, location, emote, null, stashWorldPoint, stashId, requirements);
    }

    public EmoteClue(final int clueId,
                     final ClueTier tier,
                     final String description,
                     final ClueLocation location,
                     final Emote firstEmote,
                     final Emote secondEmote,
                     final WorldPoint stashWorldPoint,
                     final int stashId,
                     final ClueModule... requirements) {
        setClueId(clueId);
        setTier(tier);
        setDescription(new TextDescription(description));
        setLocation(location);
        setIconId(tier.getItemImageId());
        this.firstEmote = firstEmote;
        this.secondEmote = secondEmote;
        addClueModule(new EmoteModule(firstEmote, secondEmote));
        if (stashWorldPoint != null && stashId != -1) {
            addClueModule(new StashModule(stashWorldPoint, stashId));
        }
        for (final ClueModule clueModule : requirements) {
            addClueModule(clueModule);
        }
    }

    @Override
    public BufferedImage getImage(final ClueHelperPlugin plugin) {
        return firstEmote.getImage();
    }
}
