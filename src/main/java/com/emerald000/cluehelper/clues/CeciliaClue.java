package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.descriptions.TextDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.AreaLocation;
import com.emerald000.cluehelper.modules.requirements.SongRequirement;
import lombok.Getter;

@Getter
public class CeciliaClue extends Clue {

    private final String song;

    public CeciliaClue(final int clueId, final ClueTier clueTier, final String song, final int varPlayerId, final int bitShift) {
        setClueId(clueId);
        setTier(clueTier);
        setDescription(new TextDescription("Falador Park, Cecilia"));
        setLocation(new AreaLocation(2986, 3380, 2994, 3388, 0, "/music.png"));
        setIconId(clueTier.getItemImageId());
        this.song = song;
        addClueModule(new SongRequirement(song, varPlayerId, bitShift));
    }
}
