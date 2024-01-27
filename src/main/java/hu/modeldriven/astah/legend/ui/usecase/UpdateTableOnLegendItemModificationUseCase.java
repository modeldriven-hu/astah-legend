package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.LegendItemModifiedEvent;
import hu.modeldriven.astah.legend.ui.table.LegendItemTableModel;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class UpdateTableOnLegendItemModificationUseCase implements EventHandler<LegendItemModifiedEvent> {

    private final LegendItemTableModel tableModel;

    public UpdateTableOnLegendItemModificationUseCase(LegendItemTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    public void handleEvent(LegendItemModifiedEvent event) {
        this.tableModel.updateLegendItem(event.getLegendItem());
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(LegendItemModifiedEvent.class);
    }
}
