package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.components.LegendStyleDialog;
import hu.modeldriven.astah.legend.ui.event.LegendStyleModifiedEvent;
import hu.modeldriven.astah.legend.ui.event.ModifyLegendStyleRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

public class DisplayLegendStyleDialogUseCase implements EventHandler<ModifyLegendStyleRequestedEvent> {

    private final EventBus eventBus;

    public DisplayLegendStyleDialogUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(ModifyLegendStyleRequestedEvent event) {
        LegendStyleDialog dialog = new LegendStyleDialog(legendStyle -> {
            eventBus.publish(new LegendStyleModifiedEvent(legendStyle));
        });

        dialog.setLegendStyle(event.getLegendStyle());
        dialog.setVisible(true);
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ModifyLegendStyleRequestedEvent.class);
    }
}
