package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.cluesteps.BeginnerClues;
import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.modules.requirements.InventoryRequirement;
import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;

@Getter
public class CharlieClue extends Clue {

    private final boolean itemKnown;

    public CharlieClue(final boolean itemKnown) {
        setClueId(ItemID.CLUE_SCROLL_BEGINNER);
        setTier(ClueTier.BEGINNER);
        setDescription(new TextDescription("Varrock, south entrance, Charlie the Tramp"));
        setLocation(new NPCLocation(new WorldPoint(3207, 3391, 0), NpcID.CHARLIE_THE_TRAMP));
        setIconId(ClueTier.BEGINNER.getItemImageId());
        this.itemKnown = itemKnown;
    }

    public CharlieClue(final int itemId) {
        this(true);
        addClueModule(new InventoryRequirement(itemId));
    }

    @Nullable
    public static Clue parseDialog(final String dialog) {
        switch (dialog) {
            case "I really need a piece of iron ore.":
                return BeginnerClues.getClue("I need to give Charlie a piece of iron ore.");
            case "I really need a raw herring.":
                return BeginnerClues.getClue("I need to give Charlie a raw herring.");
            case "I really need an iron dagger.":
                return BeginnerClues.getClue("I need to give Charlie one iron dagger.");
            case "I really need some leather chaps.":
                return BeginnerClues.getClue("I need to give Charlie some leather chaps.");
            case "I really need a raw trout.":
                return BeginnerClues.getClue("I need to give Charlie a raw trout.");
            case "I really need a cooked pike.":
                return BeginnerClues.getClue("I need to give Charlie a cooked pike.");
            case "I really need a leather body.":
                return BeginnerClues.getClue("I need to give Charlie a leather body.");
            case "I really need a cooked trout.":
                return BeginnerClues.getClue("I need to give Charlie a cooked trout.");
            default:
                return null;
        }
    }
}
