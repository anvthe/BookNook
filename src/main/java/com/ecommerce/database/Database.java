package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String URL = "jdbc:sqlite:C:/Users/User/DataGripProjects/spring parallel processing/identifier.sqlite"; // Replace with your database path
    private static final String DRIVER = "org.sqlite.JDBC";

    public Connection getConnection() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName(DRIVER);

            // Establish the connection
            conn = DriverManager.getConnection(URL);
            return conn;
        } catch (Exception e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Database database = new Database();
        Connection connection = database.getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully: " + connection);
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}