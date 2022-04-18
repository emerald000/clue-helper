package emerald000.cluehelper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("clue-helper")
public interface ClueHelperConfig extends Config
{
	@ConfigItem(
			keyName = "displayHintArrows",
			name = "Display hint arrows",
			description = "Configures whether or not to display hint arrows for clues"
	)
	default boolean displayHintArrows()
	{
		return true;
	}
}
