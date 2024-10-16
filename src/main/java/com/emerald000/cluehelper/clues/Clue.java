package com.emerald000.cluehelper.clues;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.descriptions.ClueDescription;
import com.emerald000.cluehelper.enums.ClueTier;
import com.emerald000.cluehelper.locations.ClueLocation;
import com.emerald000.cluehelper.modules.ClueModule;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

public class Clue {
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private int clueId;

    @NonNull
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private ClueTier tier;

    @Nullable
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private ClueLocation location;

    @NonNull
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private ClueDescription description;

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private int iconId;

    private BufferedImage image = null;

    @NonNull
    @Getter
    private final Collection<ClueModule> clueModules = new ArrayList<>(0);

    final void addClueModule(final ClueModule clueModule) {
        clueModules.add(clueModule);
    }

    public BufferedImage getImage(final ClueHelperPlugin plugin) {
        if (image == null) {
            image = plugin.getItemManager().getImage(iconId);
        }
        return image;
    }

    public void reset() {

    }
}
