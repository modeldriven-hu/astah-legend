package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.core.eventbus.Event;

public class SaveFileRequestedEvent implements Event {

    private Legend legend;

    public SaveFileRequestedEvent(Legend legend) {
        this.legend = legend;
    }

    public Legend getLegend() {
        return legend;
    }
}
