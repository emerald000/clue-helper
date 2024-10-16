package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AllArgsConstructor;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.util.Set;

@AllArgsConstructor
public class GuthixEquipmentRequirement implements ClueModule {
    private final int requiredNumberOfItems;

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        int currentNumberOfItems = 0;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        if (equipment != null) {
            for (final Item item : equipment.getItems()) {
                if (GUTHIX_ITEMS.contains(item.getId())) {
                    currentNumberOfItems += 1;
                }
            }
        }

        Color colour = Color.RED;
        if (currentNumberOfItems >= requiredNumberOfItems) {
            colour = Color.GREEN;
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left(requiredNumberOfItems + " Guthix items")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(Integer.toString(currentNumberOfItems))
                .rightColor(colour)
                .build());
    }

    private static final Set<Integer> GUTHIX_ITEMS = Set.of(
            // Weapon
            ItemID.GUTHIX_STAFF,
            ItemID.RUNE_SCIMITAR_23330, // Guthix
            ItemID.GUTHIX_CROZIER,
            ItemID.STAFF_OF_BALANCE,
            ItemID.GUTHIX_MJOLNIR,
            ItemID.BANNER_8660, // Guthix
            ItemID.VOID_KNIGHT_MACE,
            ItemID.VOID_KNIGHT_MACE_L,
            // Head
            ItemID.GUTHIX_FULL_HELM,
            ItemID.GUTHIX_COIF,
            ItemID.GUTHIX_MITRE,
            ItemID.GUTHIX_HALO,
            ItemID.GUTHIX_HALO_L,
            ItemID.GUTHIX_MAX_HOOD,
            ItemID.IMBUED_GUTHIX_MAX_HOOD,
            ItemID.RUNE_HERALDIC_HELM_8474, // Guthix
            ItemID.ADAMANT_HERALDIC_HELM_22169, // Guthix
            ItemID.STEEL_HERALDIC_HELM_8692, // Guthix
            ItemID.VOID_MELEE_HELM,
            ItemID.VOID_MELEE_HELM_L,
            ItemID.VOID_MELEE_HELM_OR,
            ItemID.VOID_MELEE_HELM_LOR,
            ItemID.VOID_RANGER_HELM,
            ItemID.VOID_RANGER_HELM_L,
            ItemID.VOID_RANGER_HELM_OR,
            ItemID.VOID_RANGER_HELM_LOR,
            ItemID.VOID_MAGE_HELM,
            ItemID.VOID_MAGE_HELM_L,
            ItemID.VOID_MAGE_HELM_OR,
            ItemID.VOID_MAGE_HELM_LOR,
            // Cape
            ItemID.GUTHIX_CAPE,
            ItemID.GUTHIX_MAX_CAPE,
            ItemID.IMBUED_GUTHIX_CAPE,
            ItemID.IMBUED_GUTHIX_CAPE_L,
            ItemID.IMBUED_GUTHIX_CAPE_DEADMAN,
            ItemID.IMBUED_GUTHIX_MAX_CAPE,
            ItemID.IMBUED_GUTHIX_MAX_CAPE_L,
            ItemID.GUTHIX_CLOAK,
            // Neck
            ItemID.GUTHIX_STOLE,
            ItemID.VOID_SEAL1,
            ItemID.VOID_SEAL2,
            ItemID.VOID_SEAL3,
            ItemID.VOID_SEAL4,
            ItemID.VOID_SEAL5,
            ItemID.VOID_SEAL6,
            ItemID.VOID_SEAL7,
            ItemID.VOID_SEAL8,
            // Ammunition
            ItemID.PEACEFUL_BLESSING,
            // Body
            ItemID.GUTHIX_PLATEBODY,
            ItemID.GUTHIX_DHIDE_BODY,
            ItemID.GUTHIX_ROBE_TOP,
            ItemID.VOID_KNIGHT_TOP,
            ItemID.VOID_KNIGHT_TOP_L,
            ItemID.VOID_KNIGHT_TOP_OR,
            ItemID.VOID_KNIGHT_TOP_LOR,
            ItemID.ELITE_VOID_TOP,
            ItemID.ELITE_VOID_TOP_L,
            ItemID.ELITE_VOID_TOP_OR,
            ItemID.ELITE_VOID_TOP_LOR,
            // Shield
            ItemID.BOOK_OF_BALANCE,
            ItemID.BOOK_OF_BALANCE_OR,
            ItemID.DAMAGED_BOOK_3843, // Guthix
            ItemID.GUTHIX_KITESHIELD,
            ItemID.GUTHIX_DHIDE_SHIELD,
            ItemID.RUNE_KITESHIELD_8724, // Guthix
            ItemID.ADAMANT_KITESHIELD_22137, // Guthix
            ItemID.STEEL_KITESHIELD_8756, // Guthix
            // Legs
            ItemID.GUTHIX_PLATELEGS,
            ItemID.GUTHIX_PLATESKIRT,
            ItemID.GUTHIX_CHAPS,
            ItemID.GUTHIX_ROBE_LEGS,
            ItemID.VOID_KNIGHT_ROBE,
            ItemID.VOID_KNIGHT_ROBE_L,
            ItemID.VOID_KNIGHT_ROBE_OR,
            ItemID.VOID_KNIGHT_ROBE_LOR,
            ItemID.ELITE_VOID_ROBE,
            ItemID.ELITE_VOID_ROBE_L,
            ItemID.ELITE_VOID_ROBE_OR,
            ItemID.ELITE_VOID_ROBE_LOR,
            // Hands
            ItemID.GUTHIX_BRACERS,
            ItemID.VOID_KNIGHT_GLOVES,
            ItemID.VOID_KNIGHT_GLOVES_L,
            ItemID.VOID_KNIGHT_GLOVES_OR,
            ItemID.VOID_KNIGHT_GLOVES_LOR,
            // Feet
            ItemID.GUTHIX_DHIDE_BOOTS);
}
