package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.event.LegendItemCreatedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class UpdateTableOnLegendItemCreationUseCase implements EventHandler<LegendItemCreatedEvent> {

    private final LegendItemTableModel tableModel;

    public UpdateTableOnLegendItemCreationUseCase(LegendItemTableModel tableModel){
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(LegendItemCreatedEvent event) {
        this.tableModel.addLegendItem(event.getLegendItem());
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(LegendItemCreatedEvent.class);
    }
}
