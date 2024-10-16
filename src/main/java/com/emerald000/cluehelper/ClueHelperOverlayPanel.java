package com.emerald000.cluehelper;

import com.emerald000.cluehelper.clues.Clue;
import com.emerald000.cluehelper.clues.UnimplementedClue;
import com.emerald000.cluehelper.modules.ClueModule;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.Dimension;
import java.awt.Graphics2D;

final class ClueHelperOverlayPanel extends OverlayPanel {

    private final ClueHelperPlugin plugin;
    private static final LineComponent SPACER = LineComponent.builder().left("").build();

    @Inject
    private ClueHelperOverlayPanel(final ClueHelperPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
        setPriority(0.0F);
    }

    @Nullable
    @Override
    public Dimension render(final Graphics2D graphics) {
        final Clue clue = plugin.getActiveClue();
        if (clue == null || clue instanceof UnimplementedClue) {
            return null;
        }

        // Title
        panelComponent.getChildren().add(TitleComponent.builder().text(clue.getTier().getName()).build());

        // Location
        panelComponent.getChildren().add(LineComponent.builder()
                .left(clue.getDescription().getText(plugin))
                .leftColor(ClueHelperPlugin.TEXT_COLOUR)
                .build());

        // Modules
        panelComponent.getChildren().add(SPACER);
        for (final ClueModule module : clue.getClueModules()) {
            module.renderOverlayPanel(plugin, panelComponent);
        }

        // Remove bottom spacer
        if (panelComponent.getChildren().get(panelComponent.getChildren().size() - 1) == SPACER) {
            panelComponent.getChildren().remove(panelComponent.getChildren().size() - 1);
        }

        return super.render(graphics);
    }
}
