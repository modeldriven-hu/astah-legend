package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;

public class LegendStyle {

    private Color backgroundColor = Color.RED;
    private Color borderColor = Color.GREEN;
    private int borderWidth = 1;
    private BorderStyle borderStyle = BorderStyle.DASHED;

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

    public BorderStyle getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle = borderStyle;
    }

    public BorderFormat getBorderFormat() {
        return borderFormat;
    }

    public void setBorderFormat(BorderFormat borderFormat) {
        this.borderFormat = borderFormat;
    }
}
