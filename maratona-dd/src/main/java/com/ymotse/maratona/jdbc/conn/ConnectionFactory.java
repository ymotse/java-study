package com.ymotse.maratona.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //java.sql = Connection, Statement, ResultSet, DriverManager
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://172.21.0.2:3306/anime_store";
        String username = "root";
        String password = "ymotse";

        return DriverManager.getConnection(url, username, password);
    }

}