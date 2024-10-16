package com.emerald000.cluehelper;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public final class ClueHelperTest {
    public static void main(final String[] args) throws Exception {
        //noinspection unchecked
        ExternalPluginManager.loadBuiltin(ClueHelperPlugin.class);
        RuneLite.main(args);
    }
}