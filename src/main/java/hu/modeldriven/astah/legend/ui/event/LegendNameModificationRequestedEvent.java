package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.core.eventbus.Event;

public class LegendNameModificationRequestedEvent implements Event {

    private final String name;

    public LegendNameModificationRequestedEvent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
