package com.cucumber.framework.utilities;

import java.sql.*;

public class DatabaseUtil {
    public static Connection Open(String connectionString) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            return DriverManager.getConnection(connectionString);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Close()
    {

    }

    public static void ExecuteQuery(String query, Connection connection)
    {
        Statement statement = null;
        try
        {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        }
        catch (Exception ex)
        {


        }

    }
}
