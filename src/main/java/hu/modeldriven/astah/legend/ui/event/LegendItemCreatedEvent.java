package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

public class LegendItemCreatedEvent implements Event {

    private final LegendItem legendItem;

    public LegendItemCreatedEvent(LegendItem item) {
        this.legendItem = item;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }
}
