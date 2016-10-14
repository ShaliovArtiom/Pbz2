package model;


import java.sql.Date;

public class Sclad {

    private String idProduct;
    private String idKombinat;
    private int numberProduct;
    private Date data;


    public Sclad() {
    }

    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idProduct;
            case 1: return idKombinat;
            case 2: return numberProduct;
            case 3: return data;
            default: return"";
        }
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdKombinat() {
        return idKombinat;
    }

    public void setIdKombinat(String idKombinat) {
        this.idKombinat = idKombinat;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
