package com.emerald000.cluehelper.descriptions;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.AllArgsConstructor;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;

@AllArgsConstructor
public class KeyClueDescription implements ClueDescription {

    private final String keyDescription;
    private final int keyId;
    private final String finalDescription;

    @Override
    public String getText(final ClueHelperPlugin plugin) {
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);
        if (inventory != null && inventory.contains(keyId)) {
            return finalDescription;
        } else {
            return keyDescription;
        }
    }
}
