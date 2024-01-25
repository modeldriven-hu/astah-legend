package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.LegendItemRemovedEvent;
import hu.modeldriven.astah.legend.ui.legendItemTable.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.event.RemoveLegendItemRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class RemoveLegendItemUseCase implements EventHandler<RemoveLegendItemRequestedEvent> {

    private final EventBus eventBus;
    private final LegendItemTableModel tableModel;

    public RemoveLegendItemUseCase(EventBus eventBus, LegendItemTableModel tableModel) {
        this.eventBus = eventBus;
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(RemoveLegendItemRequestedEvent event) {
        this.tableModel.removeLegendItem(event.getLegendItem());
        this.eventBus.publish(new LegendItemRemovedEvent(event.getLegendItem()));
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(RemoveLegendItemRequestedEvent.class);
    }
}
