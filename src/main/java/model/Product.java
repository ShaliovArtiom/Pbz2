package model;

import enumerate.EnumGradeProduct;
import enumerate.EnumGroupProduct;

public class Product {

    private String idProduct;
    private String nameProduct;
    private EnumGradeProduct enumGradeProduct;
    private EnumGroupProduct enumGroupProduct;


    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idProduct;
            case 1: return nameProduct;
            case 2: return enumGradeProduct.getNameEnum();
            case 3: return enumGroupProduct.getNameEnum();
            default: return"";
        }
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public EnumGradeProduct getEnumGradeProduct() {
        return enumGradeProduct;
    }

    public void setEnumGradeProduct(String name) {
        for(EnumGradeProduct enumGradeProduct1 : EnumGradeProduct.values()){
            if(enumGradeProduct1.getNameEnum().equals(name)){
                this.enumGradeProduct = enumGradeProduct1;
            }
        }
    }

    public EnumGroupProduct getEnumGroupProduct() {
        return enumGroupProduct;
    }

    public void setEnumGroupProduct(String name) {
        for(EnumGroupProduct enumGroupProduct1 : EnumGroupProduct.values()){
            if(enumGroupProduct1.getNameEnum().equals(name)){
                this.enumGroupProduct = enumGroupProduct1;
            }
        }
    }
}
