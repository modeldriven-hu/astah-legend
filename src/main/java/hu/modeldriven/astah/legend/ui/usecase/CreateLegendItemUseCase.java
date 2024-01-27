package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.core.palette.Palette;
import hu.modeldriven.astah.core.palette.PassionPalette;
import hu.modeldriven.astah.legend.ui.event.AddLegendItemRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.LegendItemCreatedEvent;
import hu.modeldriven.astah.legend.ui.model.impl.LegendItemImpl;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class CreateLegendItemUseCase implements EventHandler<AddLegendItemRequestedEvent> {

    private final EventBus eventBus;
    private final Palette palette;

    private int paletteCounter;

    public CreateLegendItemUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
        this.palette = new PassionPalette();
    }

    @Override
    public void handleEvent(AddLegendItemRequestedEvent event) {
        eventBus.publish(new LegendItemCreatedEvent(new LegendItemImpl(palette.getItems().get(paletteCounter).getColor())));
        paletteCounter = (paletteCounter + 1) % palette.getItems().size();
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(AddLegendItemRequestedEvent.class);
    }
}
