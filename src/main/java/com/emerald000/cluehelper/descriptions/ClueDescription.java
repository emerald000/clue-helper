package com.emerald000.cluehelper.descriptions;

import com.emerald000.cluehelper.ClueHelperPlugin;

@FunctionalInterface
public interface ClueDescription {
    String getText(ClueHelperPlugin plugin);
}
