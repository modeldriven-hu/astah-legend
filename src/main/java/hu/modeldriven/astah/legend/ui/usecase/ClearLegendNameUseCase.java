package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.ResetRequestedEvent;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class ClearLegendNameUseCase implements EventHandler<ResetRequestedEvent> {

    private final JTextField textField;

    public ClearLegendNameUseCase(JTextField textField){
        this.textField = textField;
    }

    @Override
    public void handleEvent(ResetRequestedEvent event) {
        this.textField.setText("");
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ResetRequestedEvent.class);
    }
}
