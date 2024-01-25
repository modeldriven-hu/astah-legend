package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.*;
import java.awt.BorderLayout;

public class LegendItemDialog extends JDialog {

    private final LegendItemPanel contentPanel;

    public LegendItemDialog(LegendItem legendItem){
        super();
        this.contentPanel = new LegendItemPanel();
        initUIComponents(legendItem);
    }

    private void initUIComponents(LegendItem legendItem) {

        contentPanel.setLegendItem(legendItem);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        this.setModal(true);
        this.pack();
    }

}
