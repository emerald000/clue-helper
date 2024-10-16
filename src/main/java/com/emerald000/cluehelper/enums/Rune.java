package com.emerald000.cluehelper.enums;

import lombok.AllArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum Rune {
    AIR(1,
            List.of(
                    ItemID.AIR_RUNE,
                    ItemID.MIST_RUNE,
                    ItemID.DUST_RUNE,
                    ItemID.SMOKE_RUNE),
            List.of(
                    ItemID.STAFF_OF_AIR,
                    ItemID.AIR_BATTLESTAFF,
                    ItemID.MYSTIC_AIR_STAFF,
                    ItemID.MIST_BATTLESTAFF,
                    ItemID.MYSTIC_MIST_STAFF,
                    ItemID.DUST_BATTLESTAFF,
                    ItemID.MYSTIC_DUST_STAFF,
                    ItemID.SMOKE_BATTLESTAFF,
                    ItemID.MYSTIC_SMOKE_STAFF)),
    WATER(2,
            List.of(
                    ItemID.WATER_RUNE,
                    ItemID.MUD_RUNE,
                    ItemID.STEAM_RUNE,
                    ItemID.MIST_RUNE),
            List.of(
                    ItemID.STAFF_OF_WATER,
                    ItemID.WATER_BATTLESTAFF,
                    ItemID.MYSTIC_WATER_STAFF,
                    ItemID.MUD_BATTLESTAFF,
                    ItemID.MYSTIC_MUD_STAFF,
                    ItemID.STEAM_BATTLESTAFF,
                    ItemID.STEAM_BATTLESTAFF_12795,
                    ItemID.MYSTIC_STEAM_STAFF,
                    ItemID.MYSTIC_STEAM_STAFF_12796,
                    ItemID.MIST_BATTLESTAFF,
                    ItemID.MYSTIC_MIST_STAFF,
                    ItemID.KODAI_WAND,
                    ItemID.TOME_OF_WATER)),
    EARTH(3,
            List.of(
                    ItemID.EARTH_RUNE,
                    ItemID.LAVA_RUNE,
                    ItemID.MUD_RUNE,
                    ItemID.DUST_RUNE),
            List.of(
                    ItemID.STAFF_OF_EARTH,
                    ItemID.EARTH_BATTLESTAFF,
                    ItemID.MYSTIC_EARTH_STAFF,
                    ItemID.LAVA_BATTLESTAFF,
                    ItemID.LAVA_BATTLESTAFF_21198,
                    ItemID.MYSTIC_LAVA_STAFF,
                    ItemID.MYSTIC_LAVA_STAFF_21200,
                    ItemID.MUD_BATTLESTAFF,
                    ItemID.MYSTIC_MUD_STAFF,
                    ItemID.DUST_BATTLESTAFF,
                    ItemID.MYSTIC_DUST_STAFF,
                    ItemID.TOME_OF_EARTH)),
    FIRE(4,
            List.of(
                    ItemID.FIRE_RUNE,
                    ItemID.LAVA_RUNE,
                    ItemID.STEAM_RUNE,
                    ItemID.SMOKE_RUNE,
                    ItemID.SUNFIRE_RUNE),
            List.of(
                    ItemID.TOME_OF_FIRE,
                    ItemID.STAFF_OF_FIRE,
                    ItemID.FIRE_BATTLESTAFF,
                    ItemID.MYSTIC_FIRE_STAFF,
                    ItemID.LAVA_BATTLESTAFF,
                    ItemID.LAVA_BATTLESTAFF_21198,
                    ItemID.MYSTIC_LAVA_STAFF,
                    ItemID.MYSTIC_LAVA_STAFF_21200,
                    ItemID.STEAM_BATTLESTAFF,
                    ItemID.STEAM_BATTLESTAFF_12795,
                    ItemID.MYSTIC_STEAM_STAFF,
                    ItemID.MYSTIC_STEAM_STAFF_12796,
                    ItemID.SMOKE_BATTLESTAFF,
                    ItemID.MYSTIC_SMOKE_STAFF)),
    MIND(5, ItemID.MIND_RUNE),
    CHAOS(6, ItemID.CHAOS_RUNE),
    DEATH(7, ItemID.DEATH_RUNE),
    BLOOD(8, ItemID.BLOOD_RUNE),
    COSMIC(9, ItemID.COSMIC_RUNE),
    NATURE(10,
            List.of(
                    ItemID.NATURE_RUNE),
            List.of(
                    ItemID.BRYOPHYTAS_STAFF)),
    LAW(11, ItemID.LAW_RUNE),
    BODY(12, ItemID.BODY_RUNE),
    SOUL(13, ItemID.SOUL_RUNE),
    ASTRAL(14, ItemID.ASTRAL_RUNE),
    MIST(15, ItemID.MIST_RUNE),
    MUD(16, ItemID.MUD_RUNE),
    DUST(17, ItemID.DUST_RUNE),
    LAVA(18, ItemID.LAVA_RUNE),
    STEAM(19, ItemID.STEAM_RUNE),
    SMOKE(20, ItemID.SMOKE_RUNE),
    WRATH(21, ItemID.WRATH_RUNE),
    SUNFIRE(22, ItemID.SUNFIRE_RUNE);

    private final int pouchId;
    private final List<Integer> inventoryItems;
    private final List<Integer> equipmentItems;

    Rune(final int pouchId, final int itemId) {
        this(pouchId, List.of(itemId));
    }

    Rune(final int pouchId, final List<Integer> inventoryItems) {
        this(pouchId, inventoryItems, new ArrayList<>(0));
    }

    @Nullable
    private static Rune getRune(final int pouchId) {
        for (final Rune rune : values()) {
            if (rune.pouchId == pouchId) {
                return rune;
            }
        }
        return null;
    }

    public static int getRuneCount(final Client client, final Rune rune) {
        final ItemContainer equipment = client.getItemContainer(InventoryID.EQUIPMENT);
        if (equipment != null) {
            for (final int itemId : rune.equipmentItems) {
                if (equipment.contains(itemId)) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        final ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
        if (inventory != null) {
            int count = 0;
            for (final int itemId : rune.inventoryItems) {
                count += inventory.count(itemId);
            }
            if (inventory.contains(ItemID.RUNE_POUCH)
                    || inventory.contains(ItemID.RUNE_POUCH_L)
                    || inventory.contains(ItemID.DIVINE_RUNE_POUCH)
                    || inventory.contains(ItemID.DIVINE_RUNE_POUCH_L)) {
                final Rune pouchRune1 = getRune(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE1));
                if (pouchRune1 != null && rune.inventoryItems.contains(pouchRune1.inventoryItems.get(0))) {
                    count += client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT1);
                }
                final Rune pouchRune2 = getRune(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE2));
                if (pouchRune2 != null && rune.inventoryItems.contains(pouchRune2.inventoryItems.get(0))) {
                    count += client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT2);
                }
                final Rune pouchRune3 = getRune(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE3));
                if (pouchRune3 != null && rune.inventoryItems.contains(pouchRune3.inventoryItems.get(0))) {
                    count += client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT3);
                }
            }
            if (inventory.contains(ItemID.DIVINE_RUNE_POUCH)
                    || inventory.contains(ItemID.DIVINE_RUNE_POUCH_L)) {
                final Rune pouchRune4 = getRune(client.getVarbitValue(Varbits.RUNE_POUCH_RUNE4));
                if (pouchRune4 != null && rune.inventoryItems.contains(pouchRune4.inventoryItems.get(0))) {
                    count += client.getVarbitValue(Varbits.RUNE_POUCH_AMOUNT4);
                }
            }
            return count;
        }
        return 0;
    }
}
