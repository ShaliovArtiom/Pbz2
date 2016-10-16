package model;


import java.sql.Date;

public class Sclad {

    private String idSclad;
    private String idProduct;
    private String idKombinat;
    private int numberProduct;
    private Date date;

    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idSclad;
            case 1: return idProduct;
            case 2: return idKombinat;
            case 3: return numberProduct;
            case 4: return date;
            default: return"";
        }
    }

    public String getIdSclad() {return idSclad;}

    public void setIdSclad(String idSclad) {this.idSclad = idSclad;}

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
