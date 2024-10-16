package com.emerald000.cluehelper.modules.requirements;

import lombok.Getter;
import net.runelite.api.ItemID;

public class AxeRequirement extends InventoryRequirement {

    @Getter
    private static final int[] axes = {
            ItemID.BRONZE_AXE,
            ItemID.BRONZE_FELLING_AXE,
            ItemID.IRON_AXE,
            ItemID.IRON_FELLING_AXE,
            ItemID.STEEL_AXE,
            ItemID.STEEL_FELLING_AXE,
            ItemID.BLACK_AXE,
            ItemID.BLACK_FELLING_AXE,
            ItemID.MITHRIL_AXE,
            ItemID.MITHRIL_FELLING_AXE,
            ItemID.ADAMANT_AXE,
            ItemID.ADAMANT_FELLING_AXE,
            ItemID.RUNE_AXE,
            ItemID.RUNE_FELLING_AXE,
            ItemID.DRAGON_AXE,
            ItemID.DRAGON_AXE_OR,
            ItemID.DRAGON_FELLING_AXE,
            ItemID.INFERNAL_AXE,
            ItemID.INFERNAL_AXE_UNCHARGED,
            ItemID.INFERNAL_AXE_OR,
            ItemID.INFERNAL_AXE_UNCHARGED_25371, // (or)
            ItemID._3RD_AGE_AXE,
            ItemID._3RD_AGE_FELLING_AXE,
            ItemID.GILDED_AXE,
            ItemID.CRYSTAL_AXE,
            ItemID.CRYSTAL_AXE_INACTIVE,
            ItemID.CRYSTAL_FELLING_AXE,
            ItemID.CRYSTAL_FELLING_AXE_INACTIVE};

    public AxeRequirement() {
        super("Axe", axes);
    }
}
