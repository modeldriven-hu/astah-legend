package hu.modeldriven.astah.legend.ui.legendItemTable;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendItemTableModel extends AbstractTableModel {

    private final List<LegendItem> legendItems;

    public LegendItemTableModel() {
        this.legendItems = new ArrayList<>();
    }

    public void addLegendItem(LegendItem legendItem) {
        this.legendItems.add(legendItem);
        fireTableDataChanged();
    }

    public void removeLegendItem(LegendItem legendItem) {
        this.legendItems.removeIf(item -> matches(item, legendItem));
        fireTableDataChanged();
    }

    public void updateLegendItem(LegendItem legendItem) {

        for (int i = 0; i < legendItems.size(); i++) {

            LegendItem item = legendItems.get(i);

            if (matches(item, legendItem)) {
                legendItems.set(i, legendItem);
                fireTableDataChanged();
                break;
            }
        }

    }

    public void moveUp(LegendItem legendItem) {

        for (int currentRow = 0; currentRow < legendItems.size(); currentRow++) {
            LegendItem item = legendItems.get(currentRow);

            if (matches(item, legendItem) && currentRow > 0) {
                Collections.swap(legendItems, currentRow, currentRow - 1);
                fireTableDataChanged();
                return;
            }
        }
    }

    public void moveDown(LegendItem legendItem) {

        for (int currentRow = 0; currentRow < legendItems.size(); currentRow++) {
            LegendItem item = legendItems.get(currentRow);

            if (matches(item, legendItem) && currentRow < legendItems.size() - 1) {
                Collections.swap(legendItems, currentRow, currentRow + 1);
                fireTableDataChanged();
                return;
            }
        }
    }

    private boolean matches(LegendItem a, LegendItem b) {
        return a.getId().equals(b.getId());
    }

    public void reset() {
        this.legendItems.clear();
        fireTableDataChanged();
    }

    public LegendItem getRow(int row) {
        return this.legendItems.get(row);
    }

    @Override
    public int getRowCount() {
        return legendItems.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "Background";
            default:
                return "Unknown column";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
                return String.class;
            case 2:
                return Color.class;
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {

        LegendItem legendItem = legendItems.get(row);

        if (column == 0) {
            return legendItem.getId();
        }

        if (column == 1) {
            return legendItem.getName();
        }

        if (column == 2) {
            return legendItem.getBackgroundColor();
        }

        return null;
    }

}
