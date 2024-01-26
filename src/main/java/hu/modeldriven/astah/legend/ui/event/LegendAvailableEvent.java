package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.core.eventbus.Event;

public class LegendAvailableEvent implements Event {

    private final Legend legend;

    public LegendAvailableEvent(Legend legend) {
        this.legend = legend;
    }

    public Legend getLegend() {
        return legend;
    }
}
