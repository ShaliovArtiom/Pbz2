package model.TableModel;

import Storage.Storage;
import model.PriceSclad;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelPriceSlad extends AbstractTableModel {

    private int columnCount = 5;
    private List<PriceSclad> sourcePriceScladList;
    private List<PriceSclad> displayedPriceScladList;

    public TableModelPriceSlad() {
        sourcePriceScladList = Storage.getIstance().getPriceScladList();
        displayedPriceScladList = new ArrayList<>(sourcePriceScladList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedPriceScladList = new ArrayList<>(sourcePriceScladList);
        refresh();
    }

    public void refresh()
    {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedPriceScladList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        PriceSclad priceSclad = displayedPriceScladList.get(rowIndex);
        return priceSclad.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид Продукта";
            case 1: return "Ид Комбината";
            case 2: return "Закупочная цена($)";
            case 3: return "Рознечная цена($)";
            case 4: return "Дата поступления продукта";
        }
        return "";
    }

}
