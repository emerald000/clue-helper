package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.cluesteps.BeginnerClues;
import com.emerald000.cluehelper.cluesteps.MasterClues;
import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.modules.HotColdModule;
import com.emerald000.cluehelper.modules.requirements.InventoryRequirement;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class HotColdClue extends Clue {

    @Getter
    private List<Clue> possibleClues;
    @Nullable
    private WorldPoint previousWorldPoint;

    public HotColdClue(final int clueId, final ClueTier tier) {
        if (tier == ClueTier.BEGINNER || tier == ClueTier.MASTER) {
            setClueId(clueId);
            setTier(tier);
            setDescription(new TextDescription("Hot-Cold clue"));
            setIconId(tier.getItemImageId());
            addClueModule(new InventoryRequirement(ItemID.SPADE));
            addClueModule(new HotColdModule());
            reset();
            // TODO: All Locations on map
        } else {
            throw new IllegalArgumentException("HotColdClue requires Beginner or Master clue tier");
        }
    }

    @Override
    public void reset() {
        if (getTier() == ClueTier.BEGINNER) {
            possibleClues = new ArrayList<>(BeginnerClues.getHotColdClues());
        } else {
            possibleClues = new ArrayList<>(MasterClues.getHotColdClues());
        }
        previousWorldPoint = null;
    }

    @Nullable
    public Clue updateHotCold(final WorldPoint playerLocation, final String message, final ClueHelperPlugin plugin) {
        final int minDistance;
        final int maxDistance;
        if (message.startsWith("The device is ice cold")) {
            minDistance = 500;
            maxDistance = 50000;
        } else if (message.startsWith("The device is very cold")) {
            minDistance = 200;
            maxDistance = 499;
        } else if (message.startsWith("The device is cold")) {
            minDistance = 150;
            maxDistance = 199;
        } else if (message.startsWith("The device is warm")) {
            minDistance = 100;
            maxDistance = 149;
        } else if (message.startsWith("The device is hot")) {
            minDistance = 70;
            maxDistance = 99;
        } else if (message.startsWith("The device is very hot")) {
            minDistance = 30;
            maxDistance = 69;
        } else if (message.startsWith("The device is incredibly hot")) {
            if (getTier() == ClueTier.BEGINNER) {
                minDistance = 4;
            } else {
                minDistance = 5;
            }
            maxDistance = 29;
        } else if (message.startsWith("The device is visibly shaking")) {
            minDistance = 0;
            if (getTier() == ClueTier.BEGINNER) {
                maxDistance = 3;
            } else {
                maxDistance = 4;
            }
        } else {
            return null;
        }

        possibleClues.removeIf(clue -> {
            if (clue.getLocation() != null) {
                final int distance = playerLocation.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                return distance > maxDistance || distance < minDistance;
            }
            return true;
        });

        if (previousWorldPoint != null) {
            if (message.endsWith("warmer than last time.")) {
                possibleClues.removeIf(clue -> {
                    if (clue.getLocation() != null) {
                        final int playerDistance = playerLocation.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        final int previousDistance = previousWorldPoint.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        return playerDistance >= previousDistance;
                    }
                    return true;
                });
            } else if (message.endsWith("colder than last time.")) {
                possibleClues.removeIf(clue -> {
                    if (clue.getLocation() != null) {
                        final int playerDistance = playerLocation.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        final int previousDistance = previousWorldPoint.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        return playerDistance <= previousDistance;
                    }
                    return true;
                });

            } else if (message.endsWith("the same temperature as last time.")) {
                possibleClues.removeIf(clue -> {
                    if (clue.getLocation() != null) {
                        final int playerDistance = playerLocation.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        final int previousDistance = previousWorldPoint.distanceTo2D(clue.getLocation().getWorldPoint(plugin.getClient()));
                        return playerDistance != previousDistance;
                    }
                    return true;
                });
            }
        }

        previousWorldPoint = playerLocation;
        if (possibleClues.size() == 1) {
            return possibleClues.get(0);
        }
        return null;
    }
}
