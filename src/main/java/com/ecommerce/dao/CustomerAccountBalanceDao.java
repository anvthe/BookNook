package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.CustomerAccountBalance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountBalanceDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public CustomerAccountBalance getAccountBalanceByAccountNumber(String accountNumber) {
        CustomerAccountBalance accountBalance = new CustomerAccountBalance();
        String query = "SELECT * FROM customer_account_balance WHERE account_number = " + accountNumber;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                accountBalance.setAccountNumber(resultSet.getString(1));
                accountBalance.setBalance(resultSet.getInt(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accountBalance;
    }

    public void updateBalance(String accountNumber, double remainingAmount) {
        String query = "UPDATE customer_account_balance SET balance = ? WHERE account_number = ?";
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, remainingAmount);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
