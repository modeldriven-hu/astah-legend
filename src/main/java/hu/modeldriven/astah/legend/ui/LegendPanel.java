package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.LegendModel;
import hu.modeldriven.astah.legend.ui.usecase.*;
import hu.modeldriven.core.eventbus.EventBus;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;

public class LegendPanel extends AbstractLegendPanel{

    private final Component parentComponent;
    private final EventBus eventBus;

    private final LegendItemTableModel tableModel;

    public LegendPanel(Component parentComponent, EventBus eventBus){
        super();
        this.parentComponent = parentComponent;
        this.eventBus = eventBus;
        this.tableModel = new LegendItemTableModel();
        initUIComponents();
        initUseCases();
    }

    private void initUIComponents() {
        initLegendPanel();
        initLegendItemPanel();
    }

    private void initLegendPanel(){
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

    private void initLegendItemPanel(){
        addButton.addActionListener( e -> eventBus.publish(new AddLegendItemRequestedEvent()));

        removeButton.addActionListener( e -> {
            if (legendItemTable.getSelectedRowCount() == 1){
                LegendItem item = tableModel.getRow(legendItemTable.getSelectedRow());
                eventBus.publish(new RemoveLegendItemRequestedEvent(item));
            }
        });

        this.legendItemTable.setModel(tableModel);
    }

    private void initUseCases() {
        eventBus.subscribe(new LegendModel(eventBus));
        eventBus.subscribe(new CreateLegendItemUseCase(eventBus));
        eventBus.subscribe(new UpdateTableOnLegendItemCreationUseCase(tableModel));
        eventBus.subscribe(new ClearLegendNameUseCase(legendNameTextField));
        eventBus.subscribe(new ClearLegendItemsTableUseCase(tableModel));
        eventBus.subscribe(new RemoveLegendItemUseCase(tableModel));
    }

}
