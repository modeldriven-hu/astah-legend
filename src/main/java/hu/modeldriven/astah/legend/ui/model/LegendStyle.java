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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public BorderType getBorderType() {
        return borderType;
    }

    public void setBorderType(BorderType borderType) {
        this.borderType = borderType;
    }

    public BorderFormat getBorderFormat() {
        return borderFormat;
    }

    public void setBorderFormat(BorderFormat borderFormat) {
        this.borderFormat = borderFormat;
    }
}
