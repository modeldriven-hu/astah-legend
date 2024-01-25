package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.core.eventbus.EventBus;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LegendPanel extends AbstractLegendPanel{

    private final Component parentComponent;
    private final EventBus eventBus;

    public LegendPanel(Component parentComponent, EventBus eventBus){
        super();
        this.parentComponent = parentComponent;
        this.eventBus = eventBus;
        initUIComponents();
        initUseCases();
    }

    private void initUIComponents() {
        newButton.addActionListener( e -> eventBus.publish(new ResetRequestedEvent()));
        openButton.addActionListener( e -> eventBus.publish(new OpenFileRequestedEvent()));
        saveButton.addActionListener( e -> eventBus.publish(new SaveFileRequestedEvent()));
        applyLegendButton.addActionListener( e -> eventBus.publish(new ApplyLegendRequestedEvent()));

        legendNameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                onFieldChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                onFieldChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                onFieldChanged();
            }

            private void onFieldChanged(){
                eventBus.publish(new LegendNameChangedEvent(legendNameTextField.getText()));
            }
        });
    }

    private void initUseCases() {
    }

}
