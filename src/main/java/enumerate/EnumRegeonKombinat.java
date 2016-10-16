package enumerate;


public enum  EnumRegeonKombinat {
    Mi("Минский", 1),
    Gr("Гродненскй", 2),
    V("Витебский", 3),
    B("Брестский", 4),
    Go("Гомельский", 5),
    Mo("Могелевский", 6);

    private String nameEnum;
    private int idEnum;

    EnumRegeonKombinat(String nameEnum, int idEnum) {
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
