package hu.modeldriven.astah.legend.ui.usecase;

import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.event.SaveFileRequestedEvent;
import hu.modeldriven.astah.legend.ui.model.LegendFile;
import hu.modeldriven.astah.legend.ui.model.impl.YAMLLegendFile;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class SaveFileUseCase implements EventHandler<SaveFileRequestedEvent> {

    private final EventBus eventBus;
    private final Component parentComponent;

    public SaveFileUseCase(EventBus eventBus, Component parentComponent) {
        this.eventBus = eventBus;
        this.parentComponent = parentComponent;
    }

    @Override
    public void handleEvent(SaveFileRequestedEvent event) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("YAML files", "yaml");
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);

            if (fileChooser.showSaveDialog(parentComponent) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                if (file.exists()) {
                    int result = JOptionPane.showConfirmDialog(null,
                            "The file already exists. Do you want to overwrite it?",
                            "File Already Exists",
                            JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.NO_OPTION) {
                        return;
                    }
                }

                if (!file.getName().endsWith(".yaml")){
                    file = new File(file.getParent() + File.separator + file.getName() + ".yaml");
                }

                LegendFile legendFile = new YAMLLegendFile(file);
                legendFile.write(event.getLegend());
            }

        } catch (Exception e){
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(SaveFileRequestedEvent.class);
    }
}
