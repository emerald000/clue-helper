package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import com.emerald000.cluehelper.modules.requirements.InventoryRequirement;
import net.runelite.api.ItemID;

public class DigClue extends BasicClue {
    public DigClue(final int clueId, final ClueTier tier, final String description, final int west, final int south, final int east, final int north, final int plane, final ClueModule... clueModules) {
        super(clueId, tier, description, new AreaLocation(west, south, east, north, plane));
        addClueModule(new InventoryRequirement(ItemID.SPADE));
        setIconId(ItemID.SPADE);
        for (final ClueModule clueModule : clueModules) {
            addClueModule(clueModule);
        }
    }
}
