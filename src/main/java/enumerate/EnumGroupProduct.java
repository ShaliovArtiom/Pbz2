package enumerate;


public enum EnumGroupProduct {
    KI("колбасные изделия", 1),
    MP("мясные полуфабрикаты", 2),
    C("сыры", 3),
    M("молоко", 4),
    TI("творожные изделия", 5);

    private String nameEnum;
    private int idEnum;

    EnumGroupProduct(String nameEnum, int idEnum) {
        this.nameEnum = nameEnum;
        this.idEnum = idEnum;
    }

    public String getNameEnum() {
        return nameEnum;
    }

    public int getIdEnum() {
        return idEnum;
    }
}
