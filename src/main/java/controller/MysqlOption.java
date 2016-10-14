package controller;

import Storage.Storage;
import model.Price;
import model.Sclad;

import javax.xml.crypto.Data;
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
                sclad.setIdProduct(resultSet.getString(1));
                sclad.setIdKombinat(resultSet.getString(2));
                sclad.setNumberProduct(resultSet.getInt(3));
                sclad.setData(resultSet.getDate(4));
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
        query = "insert into sclad(idP, idK, numberP, dataP) values (?, ?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, sclad.getIdProduct());
            preparedStatement.setString(2, sclad.getIdKombinat());
            preparedStatement.setInt(3, sclad.getNumberProduct());
            preparedStatement.setDate(4, sclad.getData());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().addScladList(sclad);
    }

    public static MysqlOption getInstance() {
        if (instance == null) {
            instance = new MysqlOption();
        }
        return instance;
    }
}
