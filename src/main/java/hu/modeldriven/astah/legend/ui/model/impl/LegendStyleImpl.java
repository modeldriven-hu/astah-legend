package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.BorderFormat;
import hu.modeldriven.astah.legend.ui.model.BorderType;
import hu.modeldriven.astah.legend.ui.model.LegendStyle;

import java.awt.Color;

public class LegendStyleImpl implements LegendStyle {

    private final Color backgroundColor;
    private final Color borderColor;
    private final int borderWidth;
    private final BorderType borderType;

    private final BorderFormat borderFormat;

    public LegendStyleImpl() {
        this.backgroundColor = new Color(255, 255, 204);
        this.borderColor = Color.BLACK;
        this.borderWidth = 2;
        this.borderType = BorderType.SOLID;
        this.borderFormat = BorderFormat.RECTANGLE;
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
