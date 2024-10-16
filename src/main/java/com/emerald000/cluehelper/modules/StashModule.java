package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import lombok.AllArgsConstructor;
import net.runelite.api.Perspective;
import net.runelite.api.ScriptID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

@AllArgsConstructor
public class StashModule implements ClueModule {

    private final WorldPoint worldPoint;
    private final int stashId;

    @Override
    public final void renderWorldOverlay(final ClueHelperPlugin plugin, final Graphics2D graphics2D) {
        if (!plugin.getStashesUsed().contains(worldPoint)) {
            if (worldPoint.getPlane() == plugin.getClient().getLocalPlayer().getWorldLocation().getPlane()) {
                final LocalPoint localPoint = LocalPoint.fromWorld(plugin.getClient().getTopLevelWorldView(), worldPoint.getX(), worldPoint.getY());
                if (localPoint != null) {
                    final Polygon polygon = Perspective.getCanvasTilePoly(plugin.getClient(), localPoint);
                    if (polygon != null) {
                        OverlayUtil.renderPolygon(graphics2D, polygon, Color.GREEN);
                    }
                }
            }
        }
    }

    @Override
    public final void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        plugin.getClient().runScript(ScriptID.WATSON_STASH_UNIT_CHECK, stashId, 0, 0, 0);
        final int[] intStack = plugin.getClient().getIntStack();
        final boolean stashUnitBuilt = intStack[0] == 1;

        panelComponent.getChildren().add(LineComponent.builder()
                .left("STASH:")
                .right(stashUnitBuilt ? "✓" : "✗")
                .rightColor(stashUnitBuilt ? Color.GREEN : Color.RED)
                .build());
    }
}
