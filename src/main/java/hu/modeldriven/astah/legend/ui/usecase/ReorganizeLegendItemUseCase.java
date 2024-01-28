package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.LegendItemReorganizedEvent;
import hu.modeldriven.astah.legend.ui.event.ReorganizeLegendItemRequestedEvent;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.table.LegendItemTableModel;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class ReorganizeLegendItemUseCase implements EventHandler<ReorganizeLegendItemRequestedEvent> {

    private final EventBus eventBus;
    private final LegendItemTableModel tableModel;

    public ReorganizeLegendItemUseCase(EventBus eventBus, LegendItemTableModel tableModel) {
        this.eventBus = eventBus;
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(ReorganizeLegendItemRequestedEvent event) {

        LegendItem legendItem = event.getLegendItem();

        if (event.getDirection().equals(ReorganizeLegendItemRequestedEvent.Direction.UP)) {
            tableModel.moveUp(legendItem);
            eventBus.publish(new LegendItemReorganizedEvent(legendItem, LegendItemReorganizedEvent.Direction.UP));
        } else {
            tableModel.moveDown(legendItem);
            eventBus.publish(new LegendItemReorganizedEvent(legendItem, LegendItemReorganizedEvent.Direction.DOWN));
        }

    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ReorganizeLegendItemRequestedEvent.class);
    }
}
