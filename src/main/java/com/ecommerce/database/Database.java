package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:C:/Users/User/DataGripProjects/spring parallel processing/identifier.sqlite"; // Replace with your database path
    private static final String DRIVER = "org.sqlite.JDBC";

    private static Connection connection;

    static {
        try {
            // Load the SQLite JDBC driver
            Class.forName(DRIVER);

            // Establish a single shared connection
            connection = DriverManager.getConnection(URL);

            // Configure SQLite for concurrency
            try (Statement statement = connection.createStatement()) {
                statement.execute("PRAGMA busy_timeout = 5000;"); // Wait 5 seconds for lock release
                statement.execute("PRAGMA journal_mode=WAL;");   // Enable Write-Ahead Logging
            }
        } catch (Exception e) {
            System.err.println("Error initializing database connection: " + e.getMessage());
        }
    }


    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            System.err.println("Error while reconnecting to the database: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = Database.getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully: " + connection);
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}