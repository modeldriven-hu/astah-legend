package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.BorderFormat;
import hu.modeldriven.astah.legend.ui.model.BorderType;
import hu.modeldriven.astah.legend.ui.model.LegendStyle;

import java.awt.Color;

public class LegendStyleImpl implements LegendStyle {

    private Color backgroundColor = Color.RED;
    private Color borderColor = Color.GREEN;
    private int borderWidth = 1;
    private BorderType borderType = BorderType.DASHED;

    private BorderFormat borderFormat = BorderFormat.ROUNDED;

    public LegendStyleImpl() {
    }

    public LegendStyleImpl(Color backgroundColor, Color borderColor, int borderWidth, BorderType borderType, BorderFormat borderFormat) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.borderType = borderType;
        this.borderFormat = borderFormat;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public BorderType getBorderType() {
        return borderType;
    }

    public BorderFormat getBorderFormat() {
        return borderFormat;
    }

}
