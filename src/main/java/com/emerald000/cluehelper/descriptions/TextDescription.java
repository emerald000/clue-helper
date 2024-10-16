package com.emerald000.cluehelper.descriptions;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextDescription implements ClueDescription {

    private String description;

    // TODO: Handle floors
    @Override
    public final String getText(final ClueHelperPlugin plugin) {
        switch (plugin.getConfig().floorNumbering()) {
            case BRITISH:
                return description.replace("2nd floor", "1st floor")
                        .replace("3rd floor", "2nd floor");
            case AMERICAN:
            default:
                return description;
        }
    }
}
