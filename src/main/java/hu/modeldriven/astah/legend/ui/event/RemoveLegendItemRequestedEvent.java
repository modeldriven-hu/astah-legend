package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

import java.security.PrivilegedAction;

public class RemoveLegendItemRequestedEvent implements Event {

    private final LegendItem legendItem;

    public RemoveLegendItemRequestedEvent(LegendItem legendItem) {
        this.legendItem = legendItem;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }
}
