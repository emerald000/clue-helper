package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import net.runelite.api.ItemID;

public class UnreadMasterClue extends Clue {
    public UnreadMasterClue() {
        setClueId(ItemID.CLUE_SCROLL_MASTER);
        setTier(ClueTier.MASTER);
        setDescription(new TextDescription("Read the clue."));
    }
}
