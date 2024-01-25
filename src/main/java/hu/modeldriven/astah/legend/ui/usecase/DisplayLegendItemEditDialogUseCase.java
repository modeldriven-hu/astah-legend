package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.components.LegendItemDialog;
import hu.modeldriven.astah.legend.ui.event.ModifyLegendItemRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.LegendItemModifiedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class DisplayLegendItemEditDialogUseCase implements EventHandler<ModifyLegendItemRequestedEvent> {

    private final EventBus eventBus;

    public DisplayLegendItemEditDialogUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(ModifyLegendItemRequestedEvent event) {
        LegendItemDialog dialog = new LegendItemDialog(legendItem -> {
            eventBus.publish(new LegendItemModifiedEvent(legendItem));
        });

        dialog.setLegendItem(event.getLegendItem());
        dialog.setVisible(true);
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ModifyLegendItemRequestedEvent.class);
    }
}
