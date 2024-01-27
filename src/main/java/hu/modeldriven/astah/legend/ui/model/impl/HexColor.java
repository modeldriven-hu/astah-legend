package hu.modeldriven.astah.legend.ui.model.impl;

import java.awt.Color;

public class HexColor {

    public final Color color;

    public HexColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String hex = "#" + Integer.toHexString(color.getRGB()).substring(2);
        return hex.toUpperCase();
    }

}
