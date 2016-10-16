package model;

import enumerate.EnumRegeonKombinat;

public class Kombinat {
    private String idKombinat;
    private String nameKombinat;
    private String adressKombinat;
    private String telephoneKombinat;
    private String FIOKombinat;
    private String positionKombinat;
    private EnumRegeonKombinat enumRegeonKombinat;


    public Object get(int columnIndex){
        switch(columnIndex){
            case 0: return idKombinat;
            case 1: return nameKombinat;
            case 2: return adressKombinat;
            case 3: return telephoneKombinat;
            case 4: return FIOKombinat;
            case 5: return positionKombinat;
            case 6: return enumRegeonKombinat.getNameEnum();
            default: return"";
        }
    }

    public String getIdKombinat() {
        return idKombinat;
    }

    public void setIdKombinat(String idKombinat) {
        this.idKombinat = idKombinat;
    }

    public String getNameKombinat() {
        return nameKombinat;
    }

    public void setNameKombinat(String nameKombinat) {
        this.nameKombinat = nameKombinat;
    }

    public String getAdressKombinat() {
        return adressKombinat;
    }

    public void setAdressKombinat(String adressKombinat) {
        this.adressKombinat = adressKombinat;
    }

    public String getFIOKombinat() {
        return FIOKombinat;
    }

    public void setFIOKombinat(String FIOKombinat) {
        this.FIOKombinat = FIOKombinat;
    }

    public String getPositionKombinat() {
        return positionKombinat;
    }

    public void setPositionKombinat(String positionKombinat) {
        this.positionKombinat = positionKombinat;
    }

    public String getTelephoneKombinat() {
        return telephoneKombinat;
    }

    public void setTelephoneKombinat(String telephoneKombinat) {
        this.telephoneKombinat = telephoneKombinat;
    }

    public EnumRegeonKombinat getEnumRegeonKombinat() {
        return enumRegeonKombinat;
    }

    public void setEnumRegeonKombinat(String name) {
        for(EnumRegeonKombinat enumRegeonKombinat1 : EnumRegeonKombinat.values()){
            if(enumRegeonKombinat1.getNameEnum().equals(name)){
                this.enumRegeonKombinat = enumRegeonKombinat1;
            }
        }
    }
}
