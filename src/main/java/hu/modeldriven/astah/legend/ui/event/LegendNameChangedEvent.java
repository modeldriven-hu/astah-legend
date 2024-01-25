package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.core.eventbus.Event;

public class LegendNameChangedEvent implements Event {

    private final String name;

    public LegendNameChangedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
