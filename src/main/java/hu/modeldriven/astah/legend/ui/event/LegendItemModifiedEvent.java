package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

public class LegendItemModifiedEvent implements Event {

    private final LegendItem legendItem;

    public LegendItemModifiedEvent(LegendItem legendItem) {
        this.legendItem = legendItem;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }
}
