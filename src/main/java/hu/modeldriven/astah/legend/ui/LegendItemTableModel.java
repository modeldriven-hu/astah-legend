package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class LegendItemTableModel extends AbstractTableModel {

    private List<LegendItem> legendItems;

    public LegendItemTableModel(){
        this.legendItems = new ArrayList<>();
    }

    public void addLegendItem(LegendItem legendItem){
        this.legendItems.add(legendItem);
        fireTableDataChanged();
    }

    public void reset(){
        this.legendItems.clear();
        fireTableDataChanged();
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
            case 0: return "Id";
            case 1: return "Legend item";
            case 2: return "Name";
            default:
                return "Unknown column";
        }
    }

    @Override
    public Object getValueAt(int row, int column) {

        LegendItem legendItem = legendItems.get(row);

        if (column == 0) {
            return legendItem.getId();
        }

        if (column == 1) {
            return legendItem.getBackgroundColor();
        }

        if (column == 2) {
            return legendItem.getName();
        }

        return null;
    }
}
