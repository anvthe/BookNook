package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Account;

import javax.xml.crypto.Data;
import java.sql.*;

public class AccountDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // Method to execute get account query.
    private Account queryGetAccount(String query) {
        Account account = new Account();
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                account.setUsername(resultSet.getString(2));
                account.setPassword(resultSet.getString(3));
                account.setIsSeller(resultSet.getInt(4));
                account.setIsAdmin(resultSet.getInt(5));
                account.setAddress(resultSet.getString(6));
                account.setFirstName(resultSet.getString(7));
                account.setLastName(resultSet.getString(8));
                account.setEmail(resultSet.getString(9));
                account.setPhone(resultSet.getString(10));

                // Remove the image-related part since it's no longer needed.
                // No need to retrieve or set base64 image.
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Method to get account by id.
    public Account getAccount(int accountId) {
        String query = "SELECT * FROM account WHERE account_id = " + accountId;
        return queryGetAccount(query);
    }

    // Method to get login account from database.
    public Account checkLoginAccount(String username, String password) {
        String query = "SELECT * FROM account WHERE account_name = '" + username + "' AND account_password = '" + password + "'";
        return queryGetAccount(query);
    }

    // Method to check if username exists or not.
    public boolean checkUsernameExists(String username) {
        String query = "SELECT * FROM account WHERE account_name = '" + username + "'";
        return (queryGetAccount(query) != null);
    }

    // Method to create an account.
    public void createAccount(String username, String password) {
        String query = "INSERT INTO account (account_name, account_password, account_is_user, account_is_admin) VALUES (?, ?, 0, 0)";
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to edit profile information (without image).
    public void editProfileInformation(int accountId, String firstName, String lastName, String address, String email, String phone) {
        String query = "UPDATE account SET " +
                "account_first_name = ?, " +
                "account_last_name = ?, " +
                "account_address = ?, " +
                "account_email = ?, " +
                "account_phone = ? " +
                "WHERE account_id = ?";
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setInt(6, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update profile catch: " + e.getMessage());
        }
    }

    // Method to update profile information (without image).
    public void updateProfileInformation(int accountId, String firstName, String lastName, String address, String email, String phone) {
        String query = "UPDATE account SET " +
                "account_first_name = ?, " +
                "account_last_name = ?, " +
                "account_address = ?, " +
                "account_email = ?, " +
                "account_phone = ? " +
                "WHERE account_id = ?";
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setInt(6, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update profile catch: " + e.getMessage());
        }
    }
}
