package com.emerald000.cluehelper.modules;

import com.emerald000.cluehelper.ClueHelperPlugin;
import com.emerald000.cluehelper.enums.ClueEnemy;
import lombok.AllArgsConstructor;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;

@AllArgsConstructor
public class EnemyModule implements ClueModule {

    private ClueEnemy enemy;

    @Override
    public void renderOverlayPanel(final ClueHelperPlugin plugin, final PanelComponent panelComponent) {
        panelComponent.getChildren().add(LineComponent.builder()
                .left(enemy.getName())
                .leftColor(Color.YELLOW)
                .build());
    }
}
