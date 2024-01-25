package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

public class EditLegendItemRequestedEvent implements Event {

    private final LegendItem legendItem;

    public EditLegendItemRequestedEvent(LegendItem legendItem) {
        this.legendItem = legendItem;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }
}
