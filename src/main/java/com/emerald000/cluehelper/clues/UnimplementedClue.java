package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.enums.ClueTier;

public final class UnimplementedClue extends Clue {
    public UnimplementedClue(final int clueId, final ClueTier tier) {
        setClueId(clueId);
        setTier(tier);
        setLocation(null);
        setIconId(0);
    }
}
