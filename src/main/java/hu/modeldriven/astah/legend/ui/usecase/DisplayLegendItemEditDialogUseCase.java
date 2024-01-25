package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.LegendItemDialog;
import hu.modeldriven.astah.legend.ui.event.EditLegendItemRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class DisplayLegendItemEditDialogUseCase implements EventHandler<EditLegendItemRequestedEvent> {

    private final EventBus eventBus;

    public DisplayLegendItemEditDialogUseCase(EventBus eventBus){
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(EditLegendItemRequestedEvent event) {
        LegendItemDialog dialog = new LegendItemDialog(event.getLegendItem());
        dialog.setVisible(true);
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(EditLegendItemRequestedEvent.class);
    }
}
