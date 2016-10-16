package model.TableModel;

import Storage.Storage;
import model.Price;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableModelPrice extends AbstractTableModel {

    private int columnCount = 3;
    private List<Price> sourcePriceList;
    private List<Price> displayedPriceList;

    public TableModelPrice() {
        sourcePriceList = Storage.getIstance().getPriceList();
        displayedPriceList = new ArrayList<>(sourcePriceList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedPriceList = new ArrayList<>(sourcePriceList);
        refresh();
    }

    public void refresh()
    {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedPriceList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Price price = displayedPriceList.get(rowIndex);
        return price.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид";
            case 1: return "Закупочная цена($)";
            case 2: return "Рознечная цена($)";
        }
        return "";
    }

    public void filterId(String id)
    {
        Iterator<Price> iterator = displayedPriceList.iterator();
        while (iterator.hasNext()) {
            Price price = iterator.next();
            if (!id.isEmpty() && !price.getIdProduct().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Price> getDisplayedPriceList() {
        return displayedPriceList;
    }
}
