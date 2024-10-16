package com.emerald000.cluehelper.modules.requirements;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.util.List;

public class BarrowsArmourSetRequirement implements ClueModule {

    private static final List<List<List<Integer>>> barrowsSets =
            List.of(
                    List.of(
                            List.of(
                                    ItemID.AHRIMS_HOOD,
                                    ItemID.AHRIMS_HOOD_100,
                                    ItemID.AHRIMS_HOOD_75,
                                    ItemID.AHRIMS_HOOD_50,
                                    ItemID.AHRIMS_HOOD_25),
                            List.of(
                                    ItemID.AHRIMS_ROBETOP,
                                    ItemID.AHRIMS_ROBETOP_100,
                                    ItemID.AHRIMS_ROBETOP_75,
                                    ItemID.AHRIMS_ROBETOP_50,
                                    ItemID.AHRIMS_ROBETOP_25),
                            List.of(
                                    ItemID.AHRIMS_ROBESKIRT,
                                    ItemID.AHRIMS_ROBESKIRT_100,
                                    ItemID.AHRIMS_ROBESKIRT_75,
                                    ItemID.AHRIMS_ROBESKIRT_50,
                                    ItemID.AHRIMS_ROBESKIRT_25),
                            List.of(
                                    ItemID.AHRIMS_STAFF,
                                    ItemID.AHRIMS_STAFF_100,
                                    ItemID.AHRIMS_STAFF_75,
                                    ItemID.AHRIMS_STAFF_50,
                                    ItemID.AHRIMS_STAFF_25)),
                    List.of(
                            List.of(
                                    ItemID.DHAROKS_HELM,
                                    ItemID.DHAROKS_HELM_100,
                                    ItemID.DHAROKS_HELM_75,
                                    ItemID.DHAROKS_HELM_50,
                                    ItemID.DHAROKS_HELM_25),
                            List.of(
                                    ItemID.DHAROKS_PLATEBODY,
                                    ItemID.DHAROKS_PLATEBODY_100,
                                    ItemID.DHAROKS_PLATEBODY_75,
                                    ItemID.DHAROKS_PLATEBODY_50,
                                    ItemID.DHAROKS_PLATEBODY_25),
                            List.of(
                                    ItemID.DHAROKS_PLATELEGS,
                                    ItemID.DHAROKS_PLATELEGS_100,
                                    ItemID.DHAROKS_PLATELEGS_75,
                                    ItemID.DHAROKS_PLATELEGS_50,
                                    ItemID.DHAROKS_PLATELEGS_25),
                            List.of(
                                    ItemID.DHAROKS_GREATAXE,
                                    ItemID.DHAROKS_GREATAXE_100,
                                    ItemID.DHAROKS_GREATAXE_75,
                                    ItemID.DHAROKS_GREATAXE_50,
                                    ItemID.DHAROKS_GREATAXE_25)),
                    List.of(
                            List.of(
                                    ItemID.GUTHANS_HELM,
                                    ItemID.GUTHANS_HELM_100,
                                    ItemID.GUTHANS_HELM_75,
                                    ItemID.GUTHANS_HELM_50,
                                    ItemID.GUTHANS_HELM_25),
                            List.of(
                                    ItemID.GUTHANS_PLATEBODY,
                                    ItemID.GUTHANS_PLATEBODY_100,
                                    ItemID.GUTHANS_PLATEBODY_75,
                                    ItemID.GUTHANS_PLATEBODY_50,
                                    ItemID.GUTHANS_PLATEBODY_25),
                            List.of(
                                    ItemID.GUTHANS_CHAINSKIRT,
                                    ItemID.GUTHANS_CHAINSKIRT_100,
                                    ItemID.GUTHANS_CHAINSKIRT_75,
                                    ItemID.GUTHANS_CHAINSKIRT_50,
                                    ItemID.GUTHANS_CHAINSKIRT_25),
                            List.of(
                                    ItemID.GUTHANS_WARSPEAR,
                                    ItemID.GUTHANS_WARSPEAR_100,
                                    ItemID.GUTHANS_WARSPEAR_75,
                                    ItemID.GUTHANS_WARSPEAR_50,
                                    ItemID.GUTHANS_WARSPEAR_25)),
                    List.of(
                            List.of(
                                    ItemID.KARILS_COIF,
                                    ItemID.KARILS_COIF_100,
                                    ItemID.KARILS_COIF_75,
                                    ItemID.KARILS_COIF_50,
                                    ItemID.KARILS_COIF_25),
                            List.of(
                                    ItemID.KARILS_LEATHERTOP,
                                    ItemID.KARILS_LEATHERTOP_100,
                                    ItemID.KARILS_LEATHERTOP_75,
                                    ItemID.KARILS_LEATHERTOP_50,
                                    ItemID.KARILS_LEATHERTOP_25),
                            List.of(
                                    ItemID.KARILS_LEATHERSKIRT,
                                    ItemID.KARILS_LEATHERSKIRT_100,
                                    ItemID.KARILS_LEATHERSKIRT_75,
                                    ItemID.KARILS_LEATHERSKIRT_50,
                                    ItemID.KARILS_LEATHERSKIRT_25),
                            List.of(
                                    ItemID.KARILS_CROSSBOW,
                                    ItemID.KARILS_CROSSBOW_100,
                                    ItemID.KARILS_CROSSBOW_75,
                                    ItemID.KARILS_CROSSBOW_50,
                                    ItemID.KARILS_CROSSBOW_25)),
                    List.of(
                            List.of(
                                    ItemID.TORAGS_HELM,
                                    ItemID.TORAGS_HELM_100,
                                    ItemID.TORAGS_HELM_75,
                                    ItemID.TORAGS_HELM_50,
                                    ItemID.TORAGS_HELM_25),
                            List.of(
                                    ItemID.TORAGS_PLATEBODY,
                                    ItemID.TORAGS_PLATEBODY_100,
                                    ItemID.TORAGS_PLATEBODY_75,
                                    ItemID.TORAGS_PLATEBODY_50,
                                    ItemID.TORAGS_PLATEBODY_25),
                            List.of(
                                    ItemID.TORAGS_PLATELEGS,
                                    ItemID.TORAGS_PLATELEGS_100,
                                    ItemID.TORAGS_PLATELEGS_75,
                                    ItemID.TORAGS_PLATELEGS_50,
                                    ItemID.TORAGS_PLATELEGS_25),
                            List.of(
                                    ItemID.TORAGS_HAMMERS,
                                    ItemID.TORAGS_HAMMERS_100,
                                    ItemID.TORAGS_HAMMERS_75,
                                    ItemID.TORAGS_HAMMERS_50,
                                    ItemID.TORAGS_HAMMERS_25)),
                    List.of(
                            List.of(
                                    ItemID.VERACS_HELM,
                                    ItemID.VERACS_HELM_100,
                                    ItemID.VERACS_HELM_75,
                                    ItemID.VERACS_HELM_50,
                                    ItemID.VERACS_HELM_25),
                            List.of(
                                    ItemID.VERACS_BRASSARD,
                                    ItemID.VERACS_BRASSARD_100,
                                    ItemID.VERACS_BRASSARD_75,
                                    ItemID.VERACS_BRASSARD_50,
                                    ItemID.VERACS_BRASSARD_25),
                            List.of(
                                    ItemID.VERACS_PLATESKIRT,
                                    ItemID.VERACS_PLATESKIRT_100,
                                    ItemID.VERACS_PLATESKIRT_75,
                                    ItemID.VERACS_PLATESKIRT_50,
                                    ItemID.VERACS_PLATESKIRT_25),
                            List.of(
                                    ItemID.VERACS_FLAIL,
                                    ItemID.VERACS_FLAIL_100,
                                    ItemID.VERACS_FLAIL_75,
                                    ItemID.VERACS_FLAIL_50,
                                    ItemID.VERACS_FLAIL_25)));

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {

        boolean isSetEquipped = false;
        boolean isSetInventory = false;

        final ItemContainer equipment = plugin.getClient().getItemContainer(InventoryID.EQUIPMENT);
        final ItemContainer inventory = plugin.getClient().getItemContainer(InventoryID.INVENTORY);

        if (equipment != null && inventory != null) {
            for (final List<List<Integer>> barrowsSet : barrowsSets) {
                // Skip checking further sets if one has already been found being equipped
                if (!isSetEquipped) {
                    boolean thisSetEquipped = true;
                    boolean thisSetInventory = true;
                    for (final List<Integer> slot : barrowsSet) {
                        boolean pieceEquipped = false;
                        boolean pieceInventory = false;
                        for (final int pieceId : slot) {
                            if (equipment.contains(pieceId)) {
                                pieceEquipped = true;
                            } else if (inventory.contains(pieceId)) {
                                pieceInventory = true;
                            }
                        }
                        if (!pieceEquipped) {
                            thisSetEquipped = false;
                        }
                        if (!pieceInventory && !pieceEquipped) {
                            thisSetInventory = false;
                        }
                    }
                    if (thisSetEquipped) {
                        isSetEquipped = true;
                    }
                    if (thisSetInventory) {
                        isSetInventory = true;
                    }
                }
            }
        }

        Color colour = Color.RED;
        String symbol = "✗";
        if (isSetEquipped) {
            colour = Color.GREEN;
            symbol = "✓";
        } else if (isSetInventory) {
            colour = Color.YELLOW;
            symbol = "✓";
        }

        panelComponent.getChildren().add(LineComponent.builder()
                .left("Full Barrows set")
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .right(symbol)
                .rightColor(colour)
                .build());
    }
}
