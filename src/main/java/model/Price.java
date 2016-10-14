package model;


public class Price {

    private String idProduct;
    private int purchasePrice;
    private int costPrice;

    public Price(String idProduct, int purchasePrice, int costPrice) {
        this.idProduct = idProduct;
        this.purchasePrice = purchasePrice;
        this.costPrice = costPrice;
    }

    public Price() {}

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

    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idProduct;
            case 1: return purchasePrice;
            case 2: return costPrice;
            case 3: return columnIndex;
            default: return"";
        }
    }
}
