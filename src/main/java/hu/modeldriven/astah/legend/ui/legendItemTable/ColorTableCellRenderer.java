package hu.modeldriven.astah.legend.ui.legendItemTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class ColorTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        this.setText("");

        if (value instanceof Color) {
            this.setBackground((Color) value);
        } else {
            if (isSelected) {
                this.setBackground(UIManager.getColor("Table.selectionBackground"));
            } else {
                this.setBackground(UIManager.getColor("Table.background"));
            }
        }

        return this;
    }
}
