package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.LegendNameModificationRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class UpdateLegendNameUseCase implements EventHandler<LegendNameModificationRequestedEvent> {

    private final JTextField textField;

    public UpdateLegendNameUseCase(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void handleEvent(LegendNameModificationRequestedEvent event) {
        this.textField.setText(event.getName());
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(LegendNameModificationRequestedEvent.class);
    }
}
