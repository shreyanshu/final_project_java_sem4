package com.shreyansh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by User on 9/13/2017.
 */
public class ConfigConnection {
    private final String username = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/JavaFinalAssignment";

    Connection connection = null;

    public ConfigConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Statement getStatement()
    {
        Statement statement = null;
        try
        {
            statement = connection.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return statement;
    }

}
