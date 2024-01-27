package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.model.impl.LegendStyleImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * FIXME This is still mutable, and this has to be changed
 */
public class Legend {

    private String name;
    private LegendStyle style;

    private final List<LegendItem> legendItems;

    public Legend() {
        this.name = " ";
        this.style = new LegendStyleImpl();
        this.legendItems = new ArrayList<>();
    }

    public Legend(String name, LegendStyle style, List<LegendItem> legendItems) {
        this.name = name;
        this.style = style;
        this.legendItems = legendItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LegendStyle getStyle() {
        return style;
    }

    public void setStyle(LegendStyle style) {
        this.style = style;
    }

    public List<LegendItem> getLegendItems() {
        return legendItems;
    }

}
