package com.shreyansh.services;

import com.shreyansh.domains.User;
import com.shreyansh.utils.ConfigConnection;

import javax.security.sasl.SaslServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 9/13/2017.
 */
public class UserService {

    public boolean verify(String username, String password, String role) {
        ConfigConnection configConnection = new ConfigConnection();
        String query = "select * from user where username = \"" + username + "\" and password = \"" + password + "\" and role = \"" + role + "\"";
        Statement statement = configConnection.getStatement();
        try {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public User getUser(String username, String password, String role) {
        User user = null;
        ConfigConnection configConnection = new ConfigConnection();
        String query = "select * from user where username = \"" + username + "\" and password = \"" + password + "\" and role = \"" + role + "\"";
        Statement statement = configConnection.getStatement();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setCity(rs.getString("city"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void addUser(User user) {
        ConfigConnection configConnection = new ConfigConnection();
        String query = "insert into user(username, password, city, address, role) values(\"" + user.getUsername() + "\",\"" + user.getPassword() + "\",\"" + user.getCity() + "\",\"" + user.getAddress() + "\",\"" + user.getRole() + "\")";
        Statement statement = configConnection.getStatement();
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAll(){
        List<User> userList = new ArrayList<>();
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "select * from user";
        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
                user.setCity(rs.getString("city"));
                user.setId(rs.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteUser(int id){
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        String query = "delete from user where id = " + id;
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int id, User user){
        String query = "update user set username = \""+user.getUsername() + "\", password = \"" + user.getPassword() + "\", city = \"" + user.getCity() + "\", address = \"" + user.getAddress() + "\", role = \"" + user.getRole() + "\" where id = " + id ;
        ConfigConnection configConnection = new ConfigConnection();
        Statement statement = configConnection.getStatement();
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        User user = null;
        ConfigConnection configConnection = new ConfigConnection();
        String query = "select * from user where id = " + id;
        Statement statement = configConnection.getStatement();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setCity(rs.getString("city"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
