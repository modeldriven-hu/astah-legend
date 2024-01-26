package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.components.LegendItemDialog;
import hu.modeldriven.astah.legend.ui.event.LegendItemModifiedEvent;
import hu.modeldriven.astah.legend.ui.event.ModifyLegendItemRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.awt.Component;
import java.util.Collections;
import java.util.List;

public class DisplayLegendItemDialogUseCase implements EventHandler<ModifyLegendItemRequestedEvent> {

    private final EventBus eventBus;
    private final Component parentComponent;

    public DisplayLegendItemDialogUseCase(EventBus eventBus, Component parentComponent) {
        this.eventBus = eventBus;
        this.parentComponent = parentComponent;
    }

    @Override
    public void handleEvent(ModifyLegendItemRequestedEvent event) {
        LegendItemDialog dialog = new LegendItemDialog(
                legendItem -> eventBus.publish(new LegendItemModifiedEvent(legendItem)));

        dialog.setLegendItem(event.getLegendItem());
        dialog.setLocationRelativeTo(parentComponent);
        dialog.setVisible(true);
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ModifyLegendItemRequestedEvent.class);
    }
}
