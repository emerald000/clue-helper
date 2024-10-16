package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import net.runelite.api.ItemID;

public class UnreadBeginnerClue extends Clue {
    public UnreadBeginnerClue() {
        setClueId(ItemID.CLUE_SCROLL_BEGINNER);
        setTier(ClueTier.BEGINNER);
        setDescription(new TextDescription("Read the clue."));
    }
}
