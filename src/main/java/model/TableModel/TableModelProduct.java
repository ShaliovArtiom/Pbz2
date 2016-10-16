package model.TableModel;

import Storage.Storage;
import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableModelProduct extends AbstractTableModel {

    private int columnCount = 4;
    private List<Product> sourceProductList;
    private List<Product> displayedProductList;

    public TableModelProduct() {
        sourceProductList = Storage.getIstance().getProductList();
        displayedProductList = new ArrayList<>(sourceProductList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedProductList = sourceProductList;
        refresh();
    }

    public void refresh() {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedProductList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = displayedProductList.get(rowIndex);
        return product.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Ид Продукта";
            case 1: return "Название продукта";
            case 2: return "Сорт";
            case 3: return "Группа продуктов";
        }
        return "";
    }

    public void filterId(String id)
    {
        Iterator<Product> iterator = displayedProductList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (!id.isEmpty() && !product.getIdProduct().equals(id)) {
                iterator.remove();
            }
        }
    }

    public List<Product> getDisplayedProductList() {
        return displayedProductList;
    }
}
