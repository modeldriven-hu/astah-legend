package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.components.AbstractLegendPanel;
import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.astah.legend.ui.legendItemTable.ColorTableCellRenderer;
import hu.modeldriven.astah.legend.ui.legendItemTable.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.LegendModel;
import hu.modeldriven.astah.legend.ui.usecase.*;
import hu.modeldriven.core.eventbus.EventBus;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.Component;

public class LegendPanel extends AbstractLegendPanel {

    private final Component parentComponent;
    private final EventBus eventBus;

    private final LegendItemTableModel tableModel;

    private final LegendModel legendModel;

    public LegendPanel(Component parentComponent, EventBus eventBus) {
        super();
        this.parentComponent = parentComponent;
        this.eventBus = eventBus;
        this.tableModel = new LegendItemTableModel();
        this.legendModel = new LegendModel(eventBus);
        initUIComponents();
        initUseCases();
    }

    private void initUIComponents() {
        initLegendPanel();
        initLegendItemPanel();
    }

    private void initLegendPanel() {
        newButton.addActionListener(e -> eventBus.publish(new ResetRequestedEvent()));
        openButton.addActionListener(e -> eventBus.publish(new OpenFileRequestedEvent()));
        saveButton.addActionListener(e -> eventBus.publish(new SaveFileRequestedEvent()));
        applyLegendButton.addActionListener(e -> eventBus.publish(new ApplyLegendRequestedEvent()));

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

            private void onFieldChanged() {
                eventBus.publish(new LegendNameChangedEvent(legendNameTextField.getText()));
            }
        });

        configureStyleButton.addActionListener(e -> {
            eventBus.publish(new ModifyLegendStyleRequestedEvent(legendModel.getLegend().getStyle()));
        });
    }

    private void initLegendItemPanel() {
        addButton.addActionListener(e -> eventBus.publish(new AddLegendItemRequestedEvent()));

        removeButton.addActionListener(e -> {
            if (legendItemTable.getSelectedRowCount() == 1) {
                LegendItem item = tableModel.getRow(legendItemTable.getSelectedRow());
                eventBus.publish(new RemoveLegendItemRequestedEvent(item));
            }
        });

        upButton.addActionListener(e -> {
            if (legendItemTable.getSelectedRowCount() == 1) {
                LegendItem item = tableModel.getRow(legendItemTable.getSelectedRow());
                eventBus.publish(new ReorganizeLegendItemRequestedEvent(item, ReorganizeLegendItemRequestedEvent.Direction.UP));
            }
        });

        downButton.addActionListener(e -> {
            if (legendItemTable.getSelectedRowCount() == 1) {
                LegendItem item = tableModel.getRow(legendItemTable.getSelectedRow());
                eventBus.publish(new ReorganizeLegendItemRequestedEvent(item, ReorganizeLegendItemRequestedEvent.Direction.DOWN));
            }
        });

        editButton.addActionListener(e -> {
            if (legendItemTable.getSelectedRowCount() == 1) {
                LegendItem item = tableModel.getRow(legendItemTable.getSelectedRow());
                eventBus.publish(new ModifyLegendItemRequestedEvent(item));
            }
        });

        this.legendItemTable.setModel(tableModel);
        this.legendItemTable.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
        this.legendItemTable.getColumnModel().getColumn(0).setWidth(0);
        this.legendItemTable.getColumnModel().getColumn(0).setMinWidth(0);
        this.legendItemTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void initUseCases() {
        eventBus.subscribe(legendModel);
        eventBus.subscribe(new CreateLegendItemUseCase(eventBus));
        eventBus.subscribe(new UpdateTableOnLegendItemCreationUseCase(tableModel));
        eventBus.subscribe(new ClearLegendNameUseCase(legendNameTextField));
        eventBus.subscribe(new ClearLegendItemsTableUseCase(tableModel));
        eventBus.subscribe(new RemoveLegendItemUseCase(eventBus, tableModel));
        eventBus.subscribe(new ReorganizeLegendItemUseCase(eventBus, tableModel));
        eventBus.subscribe(new DisplayLegendItemEditDialogUseCase(eventBus));
        eventBus.subscribe(new UpdateTableOnLegendItemModificationUseCase(tableModel));
        eventBus.subscribe(new DisplayLegendStyleDialogUseCase(eventBus));
    }

}
