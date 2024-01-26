package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;

public interface LegendStyle {

    Color getBackgroundColor();

    Color getBorderColor();

    int getBorderWidth();

    BorderType getBorderType();

    BorderFormat getBorderFormat();
}
