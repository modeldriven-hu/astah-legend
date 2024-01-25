package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class LegendItemPanel extends AbstractLegendItemPanel{

    private LegendItem legendItem;

    public LegendItemPanel(){
        super();
        initUIComponents();
    }

    private void initUIComponents() {

        backgroundColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendItemPanel.this,
                    "Choose Background Color",
                    legendItem.getBackgroundColor());

            if (newColor != null){
                this.backgroundColorPanel.setBackground(newColor);
                legendItem.setBackgroundColor(newColor);
            }
        });

        textColorButton.addActionListener(actionEvent -> {
            Color newColor = JColorChooser.showDialog(
                    LegendItemPanel.this,
                    "Choose Text Color",
                    legendItem.getTextColor());

            if (newColor != null){
                this.textColorPanel.setBackground(newColor);
                legendItem.setTextColor(newColor);
            }
        });

        okButton.addActionListener(actionEvent -> {
            System.out.println("Ok pressed");
        });

        cancelButton.addActionListener(actionEvent -> {
            System.out.println("Cancel pressed");
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
