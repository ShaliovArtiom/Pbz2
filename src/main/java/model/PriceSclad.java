package model;

import java.sql.Date;

public class PriceSclad {

    private String idProduct;
    private int purchasePrice;
    private int costPrice;
    private String idKombinat;
    private Date date;

    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idProduct;
            case 1: return idKombinat;
            case 2: return costPrice;
            case 3: return purchasePrice;
            case 4: return date;
            default: return"";
        }
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

    public String getIdKombinat() {
        return idKombinat;
    }

    public void setIdKombinat(String idKombinat) {
        this.idKombinat = idKombinat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
