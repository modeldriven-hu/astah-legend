package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.legend.ui.model.LegendStyle;

import javax.swing.*;
import java.awt.Color;
import java.util.function.Consumer;

public class LegendStylePanel extends AbstractLegendStylePanel {

    private final LegendStyleDialog parent;
    private final Consumer<LegendStyle> callback;

    private LegendStyle legendStyle;

    public LegendStylePanel(LegendStyleDialog parent, Consumer<LegendStyle> callback) {
        super();
        this.parent = parent;
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

            LegendStyle legendStyle = new LegendStyle(

            );

            callback.accept(legendStyle);

            parent.dispose();
        });

        cancelButton.addActionListener(actionEvent -> {
            parent.dispose();
        });

    }

    public void setLegendStyle(LegendStyle legendStyle) {
        this.legendStyle = legendStyle;
        this.backgroundColorPanel.setBackground(legendStyle.getBackgroundColor());
        this.borderColorPanel.setBackground(legendStyle.getBorderColor());
        this.borderWidthTextField.setValue(legendStyle.getBorderWidth());

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
