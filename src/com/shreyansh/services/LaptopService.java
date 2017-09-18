package com.shreyansh.services;

import com.shreyansh.domains.Laptop;
import com.shreyansh.utils.ConfigConnection;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 9/13/2017.
 */
public class LaptopService {

    public List<Laptop> selectAll(){

        List<Laptop> laptopList = new ArrayList<>();
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "select * from laptop";

        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Laptop laptop = new Laptop();
                laptop.setId(rs.getInt("id"));
                laptop.setBrand(rs.getString("brand"));
                laptop.setModelNo(rs.getString("modelNo"));
                laptop.setPrice(rs.getInt("price"));
                laptop.setRating(rs.getInt("rating"));
                laptopList.add(laptop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptopList;
    }

    public void delete(int id){
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "delete from laptop where id = " + id;
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addLaptop(Laptop laptop){
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "insert into laptop(brand, modelNo, price, rating) values(\"" + laptop.getBrand() + "\",\"" + laptop.getModelNo() + "\",\"" + laptop.getPrice() + "\",\"" + laptop.getRating() + "\")";

        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editLaptop(Laptop laptop, int id){
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "update laptop set brand = \""+ laptop.getBrand() + "\", modelNo = \"" + laptop.getModelNo() + "\", price = \"" + laptop.getPrice() + "\", rating = \"" + laptop.getRating() + "\" where id = "+ id;

        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Laptop getLaptop(int id){
        Laptop laptop = null;
        ConfigConnection configConnection = new ConfigConnection();
        String query = "select * from laptop where id = " + id;
        Statement statement = configConnection.getStatement();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                laptop = new Laptop();
                laptop.setId(rs.getInt("id"));
                laptop.setModelNo(rs.getString("modelNo"));
                laptop.setRating(rs.getInt("rating"));
                laptop.setBrand(rs.getString("brand"));
                laptop.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(query);

//        System.out.println(laptop.getPrice()+" " + laptop.getBrand() + " ");
        return laptop;
    }

}
