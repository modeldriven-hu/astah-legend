package hu.modeldriven.astah.legend.ui.model;

import java.util.List;

public interface Legend {

    String getName();

    LegendStyle getStyle();

    List<LegendItem> getLegendItems();

}
