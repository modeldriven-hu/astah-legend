package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.legend.ui.model.LegendStyle;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.function.Consumer;

public class LegendStyleDialog extends JDialog {

    private final LegendStylePanel contentPanel;

    public LegendStyleDialog(Consumer<LegendStyle> consumer) {
        super();
        this.contentPanel = new LegendStylePanel(this, consumer);
        initUIComponents();
    }

    private void initUIComponents() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        this.setModal(true);
        this.pack();
    }

    public void setLegendStyle(LegendStyle legendStyle) {
        contentPanel.setLegendStyle(legendStyle);
    }

}
