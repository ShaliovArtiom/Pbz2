package model;

import java.sql.Date;

public class ProductScladPrice {

    private String nameProduct;
    private int purchasePrice;
    private int costPrice;
    private Date date;

    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return nameProduct;
            case 1: return costPrice;
            case 2: return purchasePrice;
            case 3: return date;
            default: return"";
        }
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
