package com.emerald000.cluehelper.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClueEnemy {
    ANCIENT_WIZARDS("3 Ancient wizards"),
    ANCIENT_WIZARDS_OR_BRASSICAN_MAGE("Brassican mage or 3 Ancient wizards"),
    BRASSICAN_MAGE("Brassican mage"),
    DOUBLE_AGENT("Double agent"),
    SARADOMIN_WIZARD("Saradomin wizard"),
    ZAMORAK_WIZARD("Zamorak wizard");

    private final String name;
}
