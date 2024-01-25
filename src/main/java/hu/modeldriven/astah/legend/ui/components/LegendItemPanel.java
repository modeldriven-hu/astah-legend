package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.*;
import java.awt.Color;
import java.util.function.Consumer;

public class LegendItemPanel extends AbstractLegendItemPanel {

    private final LegendItemDialog parent;
    private final Consumer<LegendItem> callback;
    private LegendItem legendItem;

    public LegendItemPanel(LegendItemDialog parent, Consumer<LegendItem> callback) {
        super();
        this.parent = parent;
        this.callback = callback;
        initUIComponents();
    }

    private void initUIComponents() {

        backgroundColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendItemPanel.this,
                    "Choose Background Color",
                    backgroundColorPanel.getBackground());

            if (newColor != null) {
                this.backgroundColorPanel.setBackground(newColor);
            }
        });

        textColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendItemPanel.this,
                    "Choose Text Color",
                    textColorPanel.getBackground());

            if (newColor != null) {
                this.textColorPanel.setBackground(newColor);
            }
        });

        okButton.addActionListener(actionEvent -> {

            LegendItem item = new LegendItem(
                    legendItem.getId(),
                    nameField.getText(),
                    backgroundColorPanel.getBackground(),
                    textColorPanel.getBackground(),
                    scriptTextField.getText()
            );

            callback.accept(item);

            parent.dispose();
        });

        cancelButton.addActionListener(actionEvent -> {
            parent.dispose();
        });
    }

    public void setLegendItem(LegendItem legendItem) {
        this.legendItem = legendItem;
        this.nameField.setText(legendItem.getName());
        this.backgroundColorPanel.setBackground(legendItem.getBackgroundColor());
        this.textColorPanel.setBackground(legendItem.getTextColor());
        this.scriptTextField.setText(legendItem.getScript());
    }
}
