package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

public class ModifyLegendItemRequestedEvent implements Event {

    private final LegendItem legendItem;

    public ModifyLegendItemRequestedEvent(LegendItem legendItem) {
        this.legendItem = legendItem;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }
}
