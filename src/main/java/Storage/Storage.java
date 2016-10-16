package Storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage istance = null;
    private List<Price> priceList = new ArrayList<>();
    private List<Sclad> scladList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Kombinat> kombinatList = new ArrayList<>();

    private List<PriceSclad> priceScladList = new ArrayList<>();
    private List<ProductScladPrice> productScladPriceList = new ArrayList<>();


    public void addPriceList(Price price) {priceList.add(price);}
    public void addScladList(Sclad sclad) {scladList.add(sclad);}
    public void addProductList(Product product) {productList.add(product);}
    public void addKombinatList(Kombinat kombinat) {kombinatList.add(kombinat);}

    public void addPriceScladList(PriceSclad priceSclad) {priceScladList.add(priceSclad);}
    public void addProudctScladPrice(ProductScladPrice productScladPrice) {productScladPriceList.add(productScladPrice);}


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

    public List<Product> getProductList() {
        return productList;
    }

    public List<Kombinat> getKombinatList() {
        return kombinatList;
    }

    public List<PriceSclad> getPriceScladList() {
        return priceScladList;
    }

    public List<ProductScladPrice> getProductScladPriceList() {
        return productScladPriceList;
    }
}
