package com.emerald000.cluehelper.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

@AllArgsConstructor
@Getter
public enum ClueTier {

    BEGINNER("Beginner Clue", ItemID.CLUE_SCROLL_BEGINNER),
    EASY("Easy Clue", ItemID.CLUE_SCROLL_EASY),
    MEDIUM("Medium Clue", ItemID.CLUE_SCROLL_MEDIUM),
    HARD("Hard Clue", ItemID.CLUE_SCROLL_HARD),
    ELITE("Elite Clue", ItemID.CLUE_SCROLL_ELITE),
    MASTER("Master Clue", ItemID.CLUE_SCROLL_MASTER);

    private final String name;
    private final int itemImageId;
}
