package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.cluesteps.MasterClues;
import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.NPCLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import com.emerald000.cluehelper.modules.requirements.InventoryRequirement;
import lombok.Getter;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;

import javax.annotation.Nullable;

@Getter
public class FaloClue extends Clue {

    private final boolean itemKnown;

    public FaloClue(final int itemId, final ClueTier clueTier, final boolean itemKnown) {
        setClueId(itemId);
        setTier(clueTier);
        setDescription(new TextDescription("Falo, north of Seers' Village"));
        setLocation(new NPCLocation(new WorldPoint(2689, 3550, 0), NpcID.FALO_THE_BARD));
        setIconId(clueTier.getItemImageId());
        this.itemKnown = itemKnown;
    }

    public FaloClue(final int itemId, final ClueTier clueTier, final ClueModule... clueModules) {
        this(itemId, clueTier, true);
        for (final ClueModule clueModule : clueModules) {
            addClueModule(clueModule);
            if (clueModule instanceof InventoryRequirement) {
                setIconId(((InventoryRequirement) clueModule).getItemIds().get(0));
            }
        }
    }

    @Nullable
    public static Clue parseDialog(final String dialog) {
        switch (dialog) {
            case "Here goes...<br>A mark used to increase one's grace, found atop a<br>seer's place.":
                return MasterClues.getClue("A mark used to increase one's grace, found atop a seer's place.");
            case "Here goes...<br>No attack to wield, only strength is required, made of<br>obsidian, but with no room for a shield.":
                return MasterClues.getClue("No attack to wield, only strength is required, made of obsidian, but with no room for a shield.");
            case "Here goes...<br>It comes from the ground, underneath the snowy plain.<br>Trolls aplenty, with what looks like a mane.":
                return MasterClues.getClue("It comes from the ground, underneath the snowy plain. Trolls aplenty, with what looks like a mane.");
            case "Here goes...<br>They come from some time ago, from a land unto the<br>east. Fossilised they have become, this small and gentle<br>beast.":
                return MasterClues.getClue("They come from some time ago, from a land unto the east. Fossilised they have become, this small and gentle beast.");
            case "Here goes...<br>Vampyres are agile opponents, damaged best with a<br>weapon of many components.":
                return MasterClues.getClue("Vampyres are agile opponents, damaged best with a weapon of many components.");
            case "Here goes...<br>A token used to kill mythical beasts, in hopes of a blade<br>or just for an xp feast.":
                return MasterClues.getClue("A token used to kill mythical beasts, in hopes of a blade or just for an xp feast.");
            default:
                return null;
        }
    }
}
