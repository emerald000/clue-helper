package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.Emote;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

public class EmoteModule implements ClueModule {

    private final Collection<Emote> emotes = new ArrayList<>(1);

    public EmoteModule(final Emote firstEmote, final Emote secondEmote) {
        emotes.add(firstEmote);
        if (secondEmote != null) {
            emotes.add(secondEmote);
        }
    }
}
