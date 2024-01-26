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

    private final List<LegendItem> legendItems = new ArrayList<LegendItem>();

    public Legend() {
        this.style = new LegendStyleImpl();
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
