package emerald000.cluehelper;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import emerald000.cluehelper.ClueHelperPlugin;

public class ClueHelperPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ClueHelperPlugin.class);
		RuneLite.main(args);
	}
}