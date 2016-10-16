package model.TableModel;

import Storage.Storage;
import model.PriceSclad;
import model.ProductScladPrice;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelProductScladPrice extends AbstractTableModel {

    private int columnCount = 4;
    private List<ProductScladPrice> sourceProductScladPriceList;
    private List<ProductScladPrice> displayedProductScladPricList;

    public TableModelProductScladPrice() {
        sourceProductScladPriceList = Storage.getIstance().getProductScladPriceList();
        displayedProductScladPricList = new ArrayList<>(sourceProductScladPriceList);
    }

    @Override
    public void fireTableDataChanged(){
        displayedProductScladPricList = new ArrayList<>(sourceProductScladPriceList);
        refresh();
    }

    public void refresh()
    {
        super.fireTableDataChanged();
    }

    public int getRowCount() {
        return displayedProductScladPricList.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductScladPrice productScladPrice = displayedProductScladPricList.get(rowIndex);
        return productScladPrice.get(columnIndex);
    }

    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Название продукта";
            case 1: return "Закупочная цена($)";
            case 2: return "Рознечная цена($)";
            case 3: return "Дата поступления продукта";
        }
        return "";
    }

}
