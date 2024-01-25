package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.event.ReorganizeLegendItemRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class ReorganizeLegendItemUseCase implements EventHandler<ReorganizeLegendItemRequestedEvent> {

    private final LegendItemTableModel tableModel;

    public ReorganizeLegendItemUseCase(LegendItemTableModel tableModel){
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(ReorganizeLegendItemRequestedEvent event) {
        if (event.getDirection().equals(ReorganizeLegendItemRequestedEvent.Direction.UP)){
            tableModel.moveUp(event.getLegendItem());
        } else {
            tableModel.moveDown(event.getLegendItem());
        }
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ReorganizeLegendItemRequestedEvent.class);
    }
}
