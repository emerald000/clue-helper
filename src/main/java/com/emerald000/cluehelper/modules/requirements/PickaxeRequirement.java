package com.emerald000.cluehelper.modules.requirements;

import lombok.Getter;
import net.runelite.api.ItemID;

public class PickaxeRequirement extends InventoryRequirement {

    @Getter
    private static final int[] pickaxes = {
            ItemID.BRONZE_PICKAXE,
            ItemID.IRON_PICKAXE,
            ItemID.STEEL_PICKAXE,
            ItemID.BLACK_PICKAXE,
            ItemID.MITHRIL_PICKAXE,
            ItemID.ADAMANT_PICKAXE,
            ItemID.RUNE_PICKAXE,
            ItemID.DRAGON_PICKAXE,
            ItemID.DRAGON_PICKAXE_12797, // Upgrade kit
            ItemID.DRAGON_PICKAXE_OR,
            ItemID.DRAGON_PICKAXE_OR_25376, // Trailblazer
            ItemID.INFERNAL_PICKAXE,
            ItemID.INFERNAL_PICKAXE_OR,
            ItemID.INFERNAL_PICKAXE_UNCHARGED,
            ItemID.INFERNAL_PICKAXE_UNCHARGED_25369, // (or)
            ItemID.CRYSTAL_PICKAXE,
            ItemID.CRYSTAL_PICKAXE_INACTIVE,
            ItemID.GILDED_PICKAXE,
            ItemID._3RD_AGE_PICKAXE};

    public PickaxeRequirement() {
        this(false);
    }

    public PickaxeRequirement(final boolean optional) {
        super("Pickaxe", 1, optional, pickaxes);
    }
}
