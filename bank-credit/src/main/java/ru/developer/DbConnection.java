package ru.developer;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    @Value("${urlDB}")
    private String urlDB;

    private Connection conn;

    public Connection getConnection() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(urlDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
