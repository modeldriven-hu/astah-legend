package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.impl.LegendItemImpl;

import javax.swing.*;
import java.awt.Color;
import java.util.function.Consumer;

public class LegendItemPanel extends AbstractLegendItemPanel {

    private final transient LegendItemDialog parentComponent;
    private final transient Consumer<LegendItem> callback;
    private transient LegendItem legendItem;

    public LegendItemPanel(LegendItemDialog parentComponent, Consumer<LegendItem> callback) {
        super();
        this.parentComponent = parentComponent;
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

            LegendItem item = new LegendItemImpl(
                    legendItem.getId(),
                    nameField.getText(),
                    backgroundColorPanel.getBackground(),
                    textColorPanel.getBackground(),
                    scriptTextArea.getText(),
                    legendItem.ignorePresentation()
            );

            callback.accept(item);

            parentComponent.dispose();
        });

        cancelButton.addActionListener(actionEvent -> parentComponent.dispose());
    }

    public void setLegendItem(LegendItem legendItem) {
        this.legendItem = legendItem;
        this.nameField.setText(legendItem.getName());
        this.backgroundColorPanel.setBackground(legendItem.getBackgroundColor());
        this.textColorPanel.setBackground(legendItem.getTextColor());
        this.scriptTextArea.setText(legendItem.getScript());
        this.ignorePresentationCheckBox.setSelected(legendItem.ignorePresentation());
    }
}
