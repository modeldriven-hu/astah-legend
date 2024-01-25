package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.*;
import java.awt.BorderLayout;

public class LegendItemDialog extends JDialog {

    private final LegendItemPanel contentPanel;

    public LegendItemDialog(){
        super();
        this.contentPanel = new LegendItemPanel(this);
        initUIComponents();
    }

    private void initUIComponents() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        this.setModal(true);
        this.pack();
    }

    public void setLegendItem(LegendItem legendItem) {
        contentPanel.setLegendItem(legendItem);
    }

}
