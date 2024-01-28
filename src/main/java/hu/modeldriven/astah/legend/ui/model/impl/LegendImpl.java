package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.LegendStyle;

import java.util.ArrayList;
import java.util.List;

public class LegendImpl implements Legend {


    private final List<LegendItem> legendItems;
    private String name;
    private LegendStyle style;

    public LegendImpl() {
        this.name = " ";
        this.style = new LegendStyleImpl();
        this.legendItems = new ArrayList<>();
    }

    public LegendImpl(String name, LegendStyle style, List<LegendItem> legendItems) {
        this.name = name;
        this.style = style;
        this.legendItems = legendItems;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LegendStyle getStyle() {
        return style;
    }

    public void setStyle(LegendStyle style) {
        this.style = style;
    }

    @Override
    public List<LegendItem> getLegendItems() {
        return legendItems;
    }


}
