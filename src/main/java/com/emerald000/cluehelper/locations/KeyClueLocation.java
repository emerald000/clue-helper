package com.emerald000.cluehelper.locations;

import com.emerald000.cluehelper.ClueHelperPlugin;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.coords.WorldPoint;

import java.util.List;

public class KeyClueLocation implements NPCLocationInterface, ObjectLocationInterface {

    private final NPCLocation keyLocation;
    private final int keyId;
    private final ObjectLocation finalLocation;

    public KeyClueLocation(final NPCLocation keyLocation, final int keyId, final ObjectLocation finalLocation) {
        this.keyLocation = keyLocation;
        this.keyId = keyId;
        this.finalLocation = finalLocation;
    }

    @Override
    public List<Integer> getNpcIds() {
        return keyLocation.getNpcIds();
    }

    @Override
    public List<Integer> getObjectIds() {
        return finalLocation.getObjectIds();
    }

    @Override
    public WorldPoint getWorldPoint(final Client client) {
        if (hasKey(client)) {
            return finalLocation.getWorldPoint(client);
        }
        return keyLocation.getWorldPoint(client);
    }

    @Override
    public int getRadiusX() {
        return keyLocation.getRadiusX();
    }

    @Override
    public int getRadiusY() {
        return keyLocation.getRadiusY();
    }

    @Override
    public void processNewActiveClue(final ClueHelperPlugin plugin) {
        keyLocation.processNewActiveClue(plugin);
        finalLocation.processNewActiveClue(plugin);
    }

    public boolean hasKey(final Client client) {
        final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
        return inventory != null && inventory.contains(keyId);
    }
}
