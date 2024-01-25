package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.ResetRequestedEvent;
import hu.modeldriven.astah.legend.ui.legendItemTable.LegendItemTableModel;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class ClearLegendItemsTableUseCase implements EventHandler<ResetRequestedEvent> {

    private final LegendItemTableModel tableModel;

    public ClearLegendItemsTableUseCase(LegendItemTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(ResetRequestedEvent event) {
        this.tableModel.reset();
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ResetRequestedEvent.class);
    }
}
