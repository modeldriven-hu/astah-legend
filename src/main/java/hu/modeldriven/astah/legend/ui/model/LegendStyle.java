package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;

public class LegendStyle {

    private Color backgroundColor = Color.RED;
    private Color borderColor = Color.GREEN;
    private int borderWidth = 1;
    private BorderType borderType = BorderType.DASHED;

    private BorderFormat borderFormat = BorderFormat.ROUNDED;

    public LegendStyle() {
    }

    public LegendStyle(Color backgroundColor, Color borderColor, int borderWidth, BorderType borderType, BorderFormat borderFormat) {
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
