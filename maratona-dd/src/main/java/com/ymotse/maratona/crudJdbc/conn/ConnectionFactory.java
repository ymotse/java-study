package com.ymotse.maratona.crudJdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3308/anime_store";
        String username = "root";
        String password = "ymotse";

        return DriverManager.getConnection(url, username, password);
    }

}
