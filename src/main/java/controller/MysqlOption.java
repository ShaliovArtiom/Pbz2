package controller;

import Storage.Storage;
import model.*;

import java.sql.*;

public class MysqlOption {

    public static MysqlOption instance = null;
    private String query;
    private ResultSet resultSet;
    private DBWorker worker = DBWorker.getInstance();


    public MysqlOption() {
    }

    public void readTable(int number) {
        if (number == 1) {
            query = "select * from price";
            readPriceTableSQL();
        }
        if (number == 2) {
            query = "select * from sclad";
            readScladTableSQL();
        }

        if(number == 3){
            query = "select * from product";
            readProductTableSQL();
        }

        if(number == 4){
            query = "select * from kombinat";
            readKombinatTableSQL();
        }

    }

    private void readPriceTableSQL() {
        try {
            worker.openConnection();
            Statement statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Price price = new Price();
                price.setIdProduct(resultSet.getString(1));
                price.setPurchasePrice(resultSet.getInt(2));
                price.setCostPrice(resultSet.getInt(3));
                Storage.getIstance().addPriceList(price);
            }
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPriceTable(Price price){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into price(idP, purchasePrice, costPrise) values (?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, price.getIdProduct());
            preparedStatement.setInt(2, price.getPurchasePrice());
            preparedStatement.setInt(3, price.getCostPrice());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().addPriceList(price);
    }

    public void deletePriceTable(Price price){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from price WHERE idP = ?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, price.getIdProduct());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().getPriceList().remove(price);
    }

    public void renamePriceTable(Price price){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update price SET idP = ?, purchasePrice = ?, costPrise = ? WHERE idP = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, price.getIdProduct());
            preparedStatement.setInt(2, price.getPurchasePrice());
            preparedStatement.setInt(3, price.getCostPrice());
            preparedStatement.setString(4, price.getIdProduct());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }

    private void readScladTableSQL() {
        try {
            worker.openConnection();
            Statement statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Sclad sclad = new Sclad();
                sclad.setIdSclad(resultSet.getString(1));
                sclad.setIdProduct(resultSet.getString(2));
                sclad.setIdKombinat(resultSet.getString(3));
                sclad.setNumberProduct(resultSet.getInt(4));
                sclad.setDate(resultSet.getDate(5));
                Storage.getIstance().addScladList(sclad);
            }
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addScladTable(Sclad sclad){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into sclad(idS, idP, idK, numberP, dateP) values (?, ?, ?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, sclad.getIdSclad());
            preparedStatement.setString(2, sclad.getIdProduct());
            preparedStatement.setString(3, sclad.getIdKombinat());
            preparedStatement.setInt(4, sclad.getNumberProduct());
            preparedStatement.setString(5, sclad.getDate().toString());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().addScladList(sclad);
    }

    public void deleteSckladTable(Sclad sclad){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from sclad WHERE idS = ?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, sclad.getIdSclad());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().getScladList().remove(sclad);
    }

    public void renameScladTable(Sclad sclad){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update sclad SET idP = ?, idK = ?, numberP = ?, dateP =? WHERE idS = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, sclad.getIdProduct());
            preparedStatement.setString(2, sclad.getIdKombinat());
            preparedStatement.setInt(3, sclad.getNumberProduct());
            preparedStatement.setString(4, sclad.getDate().toString());
            preparedStatement.setString(5, sclad.getIdSclad());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }

    private void readProductTableSQL() {
        try {
            worker.openConnection();
            Statement statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setIdProduct(resultSet.getString(1));
                product.setNameProduct(resultSet.getString(2));
                product.setEnumGradeProduct(resultSet.getString(3));
                product.setEnumGroupProduct(resultSet.getString(4));
                Storage.getIstance().addProductList(product);
            }
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductTable(Product product){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into product(idP, nameP, gradeP, groupP) values (?, ?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, product.getIdProduct());
            preparedStatement.setString(2, product.getNameProduct());
            preparedStatement.setInt(3, product.getEnumGradeProduct().getIdEnum());
            preparedStatement.setInt(4, product.getEnumGroupProduct().getIdEnum());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().addProductList(product);
    }

    public void deleteProductTable(Product product){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from product WHERE idP = ?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, product.getIdProduct());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().getProductList().remove(product);
    }

    public void renameProductTable(Product product){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update product SET nameP = ?, gradeP =?, groupP =? WHERE idP = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setInt(2, product.getEnumGradeProduct().getIdEnum());
            preparedStatement.setInt(3, product.getEnumGroupProduct().getIdEnum());
            preparedStatement.setString(4, product.getIdProduct());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }

    private void readKombinatTableSQL() {
        try {
            worker.openConnection();
            Statement statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Kombinat kombinat = new Kombinat();
                kombinat.setIdKombinat(resultSet.getString(1));
                kombinat.setNameKombinat(resultSet.getString(2));
                kombinat.setAdressKombinat(resultSet.getString(3));
                kombinat.setTelephoneKombinat(resultSet.getString(4));
                kombinat.setFIOKombinat(resultSet.getString(5));
                kombinat.setPositionKombinat(resultSet.getString(6));
                kombinat.setEnumRegeonKombinat(resultSet.getString(7));
                Storage.getIstance().addKombinatList(kombinat);
            }
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addKombinatTable(Kombinat kombinat){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into kombinat(idK, nameK, adressK, telephoneK, FIOK, positionK, regeonK)" +
                " values (?, ?, ?, ?, ?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, kombinat.getIdKombinat());
            preparedStatement.setString(2, kombinat.getNameKombinat());
            preparedStatement.setString(3, kombinat.getAdressKombinat());
            preparedStatement.setString(4, kombinat.getTelephoneKombinat());
            preparedStatement.setString(5, kombinat.getFIOKombinat());
            preparedStatement.setString(6, kombinat.getPositionKombinat());
            preparedStatement.setInt(7, kombinat.getEnumRegeonKombinat().getIdEnum());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().addKombinatList(kombinat);
    }

    public void deleteKombinatTable(Kombinat kombinat){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from kombinat WHERE idK = ?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, kombinat.getIdKombinat());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().getKombinatList().remove(kombinat);
    }


    public void renameKombinatTable(Kombinat kombinat){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update kombinat SET nameK = ?, adressK =?, telephoneK =?, FIOK =?, positionK =?, regeonK =? WHERE idK = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, kombinat.getNameKombinat());
            preparedStatement.setString(2, kombinat.getAdressKombinat());
            preparedStatement.setString(3, kombinat.getTelephoneKombinat());
            preparedStatement.setString(4, kombinat.getFIOKombinat());
            preparedStatement.setString(5, kombinat.getPositionKombinat());
            preparedStatement.setInt(6, kombinat.getEnumRegeonKombinat().getIdEnum());
            preparedStatement.setString(7, kombinat.getIdKombinat());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }

    public void makePriceScladTableSQL(java.sql.Date date){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "select price.idP, sclad.idK, price.costPrise, price.purchasePrice, sclad.dateP from price, sclad where dateP = ?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, date.toString());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                PriceSclad priceSclad = new PriceSclad();
                priceSclad.setIdProduct(resultSet.getString(1));
                priceSclad.setIdKombinat(resultSet.getString(2));
                priceSclad.setCostPrice(resultSet.getInt(3));
                priceSclad.setPurchasePrice(resultSet.getInt(4));
                priceSclad.setDate(resultSet.getDate(5));
                Storage.getIstance().addPriceScladList(priceSclad);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }


    public void makeProductScladPriceTableSQL(java.sql.Date firstDate, java.sql.Date lastDate, String name){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "select product.nameP, price.costPrise, price.purchasePrice, sclad.dateP from product, price, sclad " +
                "where (nameP = ? and dateP between (?) and  (?));";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, firstDate.toString());
            preparedStatement.setString(3, lastDate.toString());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                ProductScladPrice productScladPrice = new ProductScladPrice();
                productScladPrice.setNameProduct(resultSet.getString(1));
                productScladPrice.setPurchasePrice(resultSet.getInt(2));
                productScladPrice.setCostPrice(resultSet.getInt(3));
                productScladPrice.setDate(resultSet.getDate(4));

                Storage.getIstance().addProudctScladPrice(productScladPrice);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }



    public static MysqlOption getInstance() {
        if (instance == null) {
            instance = new MysqlOption();
        }
        return instance;
    }
}
