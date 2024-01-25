package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.event.ResetRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

/**
 * Represents the internal state of the legend and corresponding items,
 * serving as a single source of truth of the current state
 */
public class LegendModel implements EventHandler<Event> {

    private final EventBus eventBus;

    private Legend legend;

    public LegendModel(EventBus eventBus) {
        this.eventBus = eventBus;
        this.legend = new Legend();
    }

    @Override
    public void handleEvent(Event event) {

        if (event instanceof ResetRequestedEvent) {
            handleResetRequested();
        }

    }

    private void handleResetRequested() {
        this.legend = new Legend();
    }

    public Legend getLegend() {
        // FIXME with a correct interpretation
        Legend legend = new Legend();
        legend.setStyle(new LegendStyle());
        return legend;
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ResetRequestedEvent.class);
    }
}
