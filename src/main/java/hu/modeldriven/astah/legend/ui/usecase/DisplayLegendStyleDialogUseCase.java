package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.components.LegendStyleDialog;
import hu.modeldriven.astah.legend.ui.event.LegendStyleModifiedEvent;
import hu.modeldriven.astah.legend.ui.event.ModifyLegendStyleRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.awt.Component;
import java.util.Collections;
import java.util.List;

public class DisplayLegendStyleDialogUseCase implements EventHandler<ModifyLegendStyleRequestedEvent> {

    private final EventBus eventBus;
    private final Component parentComponent;

    public DisplayLegendStyleDialogUseCase(EventBus eventBus, Component parentComponent) {
        this.eventBus = eventBus;
        this.parentComponent = parentComponent;
    }

    @Override
    public void handleEvent(ModifyLegendStyleRequestedEvent event) {
        LegendStyleDialog dialog = new LegendStyleDialog(legendStyle -> {
            eventBus.publish(new LegendStyleModifiedEvent(legendStyle));
        });

        dialog.setLegendStyle(event.getLegendStyle());
        dialog.setLocationRelativeTo(parentComponent);
        dialog.setVisible(true);
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ModifyLegendStyleRequestedEvent.class);
    }
}
