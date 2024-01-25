package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.AddLegendItemRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.LegendItemCreatedEvent;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Arrays;
import java.util.List;

public class CreateLegendItemUseCase implements EventHandler<AddLegendItemRequestedEvent> {

    private final EventBus eventBus;

    public CreateLegendItemUseCase(EventBus eventBus){
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(AddLegendItemRequestedEvent event) {
        eventBus.publish(new LegendItemCreatedEvent(new LegendItem()));
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Arrays.asList(AddLegendItemRequestedEvent.class);
    }
}
