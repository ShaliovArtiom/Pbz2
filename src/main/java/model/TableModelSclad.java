package model;

import Storage.Storage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelSclad extends AbstractTableModel {

    private int columnCount = 4;
    private List<Sclad> sourcePriceList;
    private List<Sclad> displayedPriceList;

    public TableModelSclad() {
        sourcePriceList = Storage.getIstance().getScladList();
        displayedPriceList = new ArrayList<>(sourcePriceList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedPriceList = sourcePriceList;
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedPriceList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Sclad sclad = displayedPriceList.get(rowIndex);
        return sclad.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид Продукта";
            case 1: return "Ид Комбината";
            case 2: return "Номер продукта";
            case 3: return "Дата поступления продукта";
        }
        return "";
    }

}
