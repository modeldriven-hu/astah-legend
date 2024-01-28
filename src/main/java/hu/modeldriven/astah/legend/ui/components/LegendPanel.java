package hu.modeldriven.astah.legend.ui.components;

import hu.modeldriven.astah.core.AstahRepresentation;
import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.LegendModel;
import hu.modeldriven.astah.legend.ui.table.ColorTableCellRenderer;
import hu.modeldriven.astah.legend.ui.table.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.usecase.*;
import hu.modeldriven.core.eventbus.EventBus;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LegendPanel extends AbstractLegendPanel {

    public static final String BUTTON_FOREGROUND = "Button.foreground";
    private final transient EventBus eventBus;

    private final transient LegendItemTableModel tableModel;

    private final transient LegendModel legendModel;

    public LegendPanel(EventBus eventBus) {
        super();
        this.eventBus = eventBus;
        this.tableModel = new LegendItemTableModel();
        this.legendModel = new LegendModel();
        initUIComponents();
        initUseCases();
    }

    private void initUIComponents() {
        initLegendPanel();
        initLegendItemPanel();
    }

    private void initLegendPanel() {

        newButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_FILE,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        openButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_DESKTOP_MAC,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        saveButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_CONTENT_SAVE,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        applyLegendButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_RUN,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        newButton.addActionListener(e -> {

            int result = JOptionPane.showConfirmDialog(null,
                    "The following operation will clear all fields. Do you want to continue?",
                    "Create a new legend",
                    JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.NO_OPTION) {
                return;
            }

            eventBus.publish(new ResetRequestedEvent());
        });
        openButton.addActionListener(e -> eventBus.publish(new OpenFileRequestedEvent()));
        saveButton.addActionListener(e -> eventBus.publish(new SaveFileRequestedEvent(legendModel.getLegend())));
        applyLegendButton.addActionListener(e -> eventBus.publish(new ApplyLegendRequestedEvent(legendModel.getLegend())));

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

        configureStyleButton.addActionListener(e -> eventBus.publish(new ModifyLegendStyleRequestedEvent(legendModel.getLegend().getStyle())));

        legendItemTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    int row = legendItemTable.rowAtPoint(e.getPoint());

                    if (row == -1) {
                        return;
                    }

                    LegendItem item = tableModel.getRow(row);
                    eventBus.publish(new ModifyLegendItemRequestedEvent(item));
                }
            }
        });
    }

    private void initLegendItemPanel() {

        upButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_ARROW_UP,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        downButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_ARROW_DOWN,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        addButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_PLUS,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        removeButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_MINUS,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

        editButton.setIcon(FontIcon.of(
                MaterialDesign.MDI_PENCIL,
                16,
                UIManager.getColor(BUTTON_FOREGROUND)));

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

        AstahRepresentation astah = new AstahRepresentation();

        eventBus.subscribe(legendModel);
        eventBus.subscribe(new CreateLegendItemUseCase(eventBus));
        eventBus.subscribe(new UpdateTableOnLegendItemCreationUseCase(tableModel));
        eventBus.subscribe(new ClearLegendNameUseCase(legendNameTextField));
        eventBus.subscribe(new ClearLegendItemsTableUseCase(tableModel));
        eventBus.subscribe(new RemoveLegendItemUseCase(eventBus, tableModel));
        eventBus.subscribe(new ReorganizeLegendItemUseCase(eventBus, tableModel));
        eventBus.subscribe(new DisplayLegendItemDialogUseCase(eventBus, this));
        eventBus.subscribe(new UpdateTableOnLegendItemModificationUseCase(tableModel));
        eventBus.subscribe(new DisplayLegendStyleDialogUseCase(eventBus, this));
        eventBus.subscribe(new OpenFileUseCase(eventBus, this));
        eventBus.subscribe(new ShowLegendUseCase(eventBus));
        eventBus.subscribe(new UpdateLegendNameUseCase(legendNameTextField));
        eventBus.subscribe(new DisplayExceptionUseCase());
        eventBus.subscribe(new SaveFileUseCase(eventBus, this));
        eventBus.subscribe(new ApplyLegendToDiagramUseCase(eventBus, astah));
        eventBus.subscribe(new AddLegendFormToDiagramUseCase(eventBus, astah));
    }

}
