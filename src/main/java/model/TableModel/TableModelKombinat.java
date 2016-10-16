package model.TableModel;

import Storage.Storage;
import model.Kombinat;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TableModelKombinat extends AbstractTableModel {

    private int columnCount = 7;
    private List<Kombinat> sourceKombinattList;
    private List<Kombinat> displayedKombinatList;

    public TableModelKombinat() {
        sourceKombinattList = Storage.getIstance().getKombinatList();
        displayedKombinatList = new ArrayList<>(sourceKombinattList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedKombinatList = sourceKombinattList;
        refresh();
    }

    public void refresh() {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedKombinatList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Kombinat kombinat = displayedKombinatList.get(rowIndex);
        return kombinat.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид комбината";
            case 1: return "Название комбината";
            case 2: return "Адресс комбината";
            case 3: return "Телефон комбината";
            case 4: return "ФИО сотрудника";
            case 5: return "Должность сотрудника";
            case 6: return "Регион";
        }
        return "";
    }

    public void filterId(String id)
    {
        Iterator<Kombinat> iterator = displayedKombinatList.iterator();
        while (iterator.hasNext()) {
            Kombinat kombinat = iterator.next();
            if (!id.isEmpty() && !kombinat.getIdKombinat().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Kombinat> getDisplayedKombinatList() {
        return displayedKombinatList;
    }
}
