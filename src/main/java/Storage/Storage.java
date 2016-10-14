package Storage;

import model.Price;
import model.Sclad;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage istance = null;
    private List<Price> priceList = new ArrayList<>();
    private List<Sclad> scladList = new ArrayList<>();


    public void addPriceList(Price price) {priceList.add(price);}
    public void addScladList(Sclad sclad) {scladList.add(sclad);}


    public static Storage getIstance(){
        if(istance == null) {
            istance = new Storage();
        }
        return istance;
    }

    public List<Price> getPriceList() {
        return priceList;
    }

    public List<Sclad> getScladList() {
        return scladList;
    }
}
