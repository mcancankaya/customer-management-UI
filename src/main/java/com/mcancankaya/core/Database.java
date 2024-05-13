package com.mcancankaya.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    //Singleton Design Pattern
    private static Database INSTANCE = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:postgresql://localhost:5432/cmsDB";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "123456";

    private Database() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (INSTANCE == null || INSTANCE.getConnection().isClosed()) {
                INSTANCE = new Database();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return INSTANCE.getConnection();
    }
}
