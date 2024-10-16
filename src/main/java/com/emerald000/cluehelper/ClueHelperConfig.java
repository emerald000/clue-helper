package com.emerald000.cluehelper;

import com.emerald000.cluehelper.enums.ConfigFloorNumbering;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("cluehelper")
public interface ClueHelperConfig extends Config {
    @ConfigItem(
            keyName = "floorNumbering",
            name = "Floor Numbering",
            description = "Adjust how floor numbers are displayed"
    )
    default ConfigFloorNumbering floorNumbering() {
        return ConfigFloorNumbering.AMERICAN;
    }

    @ConfigItem(
            keyName = "pathfinding",
            name = "Show pathfinding",
            description = "Shows the fastest path to the clue step. Requires the Shortest Path plugin to be installed."
    )
    default boolean pathfinding() {
        return false;
    }
}
