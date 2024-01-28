package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.model.impl.LegendStyleImpl;

import java.util.ArrayList;
import java.util.List;

public interface Legend {

    String getName();

    LegendStyle getStyle();

    List<LegendItem> getLegendItems();

}
