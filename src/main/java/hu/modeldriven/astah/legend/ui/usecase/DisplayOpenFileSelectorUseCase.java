package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.event.LegendAvailableEvent;
import hu.modeldriven.astah.legend.ui.event.OpenFileRequestedEvent;
import hu.modeldriven.astah.legend.ui.model.LegendFile;
import hu.modeldriven.astah.legend.ui.model.impl.YAMLLegendFile;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class DisplayOpenFileSelectorUseCase implements EventHandler<OpenFileRequestedEvent> {

    private final EventBus eventBus;
    private final Component parentComponent;

    public DisplayOpenFileSelectorUseCase(EventBus eventBus, Component parentComponent) {
        this.eventBus = eventBus;
        this.parentComponent = parentComponent;
    }

    @Override
    public void handleEvent(OpenFileRequestedEvent event) {
        final JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter restrict = new FileNameExtensionFilter("YAML files", "yaml", "yml");
        fileChooser.addChoosableFileFilter(restrict);

        if (fileChooser.showOpenDialog(parentComponent) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                LegendFile legendFile = new YAMLLegendFile(file);
                eventBus.publish(new LegendAvailableEvent(legendFile.asLegend()));
            } catch (Exception e) {
                eventBus.publish(new ExceptionOccurredEvent(e));
            }
        }
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(OpenFileRequestedEvent.class);
    }
}
