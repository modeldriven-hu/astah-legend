package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;

public interface LegendItem {

    String getId();

    String getName();

    Color getBackgroundColor();

    Color getTextColor();

    String getScript();

    boolean ignorePresentation();

}
