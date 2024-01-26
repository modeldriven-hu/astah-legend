package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;
import java.util.UUID;

public interface LegendItem {

    String getId();

    String getName();

    Color getBackgroundColor();

    Color getTextColor();

    String getScript();

}
