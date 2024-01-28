package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.legend.ui.model.BorderFormat;
import hu.modeldriven.astah.legend.ui.model.BorderType;
import hu.modeldriven.astah.legend.ui.model.LegendStyle;
import hu.modeldriven.astah.legend.ui.model.impl.LegendStyleImpl;

import javax.swing.*;
import java.awt.Color;
import java.util.function.Consumer;

public class LegendStylePanel extends AbstractLegendStylePanel {

    private final transient LegendStyleDialog parentComponent;
    private final transient Consumer<LegendStyle> callback;

    public LegendStylePanel(LegendStyleDialog parentComponent, Consumer<LegendStyle> callback) {
        super();
        this.parentComponent = parentComponent;
        this.callback = callback;
        initUIComponents();
    }

    private void initUIComponents() {
        backgroundColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendStylePanel.this,
                    "Choose Background Color",
                    backgroundColorPanel.getBackground());

            if (newColor != null) {
                this.backgroundColorPanel.setBackground(newColor);
            }
        });

        borderColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendStylePanel.this,
                    "Choose Border Color",
                    borderColorPanel.getBackground());

            if (newColor != null) {
                this.borderColorPanel.setBackground(newColor);
            }
        });

        okButton.addActionListener(actionEvent -> {

            callback.accept(new LegendStyleImpl(
                    backgroundColorPanel.getBackground(),
                    borderColorPanel.getBackground(),
                    Integer.parseInt(borderWidthTextField.getText()),
                    BorderType.getByName(borderTypeComboBox.getSelectedItem().toString()),
                    BorderFormat.getByName(borderFormatComboBox.getSelectedItem().toString()))
            );

            parentComponent.dispose();
        });

        cancelButton.addActionListener(actionEvent -> parentComponent.dispose());
    }

    public void setLegendStyle(LegendStyle legendStyle) {
        this.backgroundColorPanel.setBackground(legendStyle.getBackgroundColor());
        this.borderColorPanel.setBackground(legendStyle.getBorderColor());
        this.borderWidthTextField.setText(String.valueOf(legendStyle.getBorderWidth()));

        for (int i = 0; i < borderTypeComboBox.getItemCount(); i++) {
            if (borderTypeComboBox.getItemAt(i)
                    .equals(legendStyle.getBorderType().getName())) {
                borderTypeComboBox.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < borderFormatComboBox.getItemCount(); i++) {
            if (borderFormatComboBox.getItemAt(i)
                    .equals(legendStyle.getBorderFormat().getName())) {
                borderFormatComboBox.setSelectedIndex(i);
                break;
            }
        }

    }


}
