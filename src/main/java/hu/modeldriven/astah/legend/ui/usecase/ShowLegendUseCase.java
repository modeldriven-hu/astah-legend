package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class ShowLegendUseCase implements EventHandler<LegendAvailableEvent> {

    private final EventBus eventBus;

    public ShowLegendUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(LegendAvailableEvent event) {

        Legend legend = event.getLegend();

        eventBus.publish(new ResetRequestedEvent());
        eventBus.publish(new LegendNameModificationRequestedEvent(legend.getName()));
        eventBus.publish(new LegendStyleModifiedEvent(legend.getStyle()));

        for (LegendItem legendItem : legend.getLegendItems()) {
            eventBus.publish(new LegendItemCreatedEvent(legendItem));
        }
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(LegendAvailableEvent.class);
    }
}
