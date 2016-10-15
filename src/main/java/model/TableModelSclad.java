package model;

import Storage.Storage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableModelSclad extends AbstractTableModel {

    private int columnCount = 5;
    private List<Sclad> sourceScladList;
    private List<Sclad> displayedScladList;

    public TableModelSclad() {
        sourceScladList = Storage.getIstance().getScladList();
        displayedScladList = new ArrayList<>(sourceScladList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedScladList = sourceScladList;
        refresh();
    }

    public void refresh() {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedScladList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Sclad sclad = displayedScladList.get(rowIndex);
        return sclad.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид склада";
            case 1: return "Ид Продукта";
            case 2: return "Ид Комбината";
            case 3: return "Номер продукта";
            case 4: return "Дата поступления продукта";
        }
        return "";
    }

    public void filterId(String id)
    {
        Iterator<Sclad> iterator = displayedScladList.iterator();
        while (iterator.hasNext()) {
            Sclad sclad = iterator.next();
            if (!id.isEmpty() && !sclad.getIdSclad().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Sclad> getDisplayedScladList() {
        return displayedScladList;
    }
}
