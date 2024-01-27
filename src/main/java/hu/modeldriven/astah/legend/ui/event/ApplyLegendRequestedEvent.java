package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.core.eventbus.Event;

public class ApplyLegendRequestedEvent implements Event {


    private final Legend legend;

    public ApplyLegendRequestedEvent(Legend legend) {
        this.legend = legend;
    }

    public Legend getLegend() {
        return legend;
    }
}
