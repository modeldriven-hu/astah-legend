package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.model.LegendStyle;
import hu.modeldriven.core.eventbus.Event;

public class LegendStyleModifiedEvent implements Event {

    private final LegendStyle legendStyle;

    public LegendStyleModifiedEvent(LegendStyle legendStyle) {
        this.legendStyle = legendStyle;
    }

    public LegendStyle getLegendStyle() {
        return legendStyle;
    }
}
