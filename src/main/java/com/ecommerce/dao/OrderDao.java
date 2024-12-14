package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Account;
import com.ecommerce.entity.CartProduct;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // Call ProductDao class to access with database.
    ProductDao productDao = new ProductDao();
    AccountDao accountDao = new AccountDao();

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        List<CartProduct> list = orderDao.getOrderDetailHistory(1);
        for (CartProduct cartProduct : list) {
            System.out.println(cartProduct.toString());
        }
    }

    // Method to get last order id in database.
    public int getLastOrderId() {
        String query = "SELECT id FROM [order] ORDER BY id DESC LIMIT 1";
        int orderId = 0;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderId;
    }

    // Method to insert order detail information.
    private void createOrderDetail(List<CartProduct> cartProducts) {
        String query = "INSERT INTO order_detail (order_id, product_id, product_quantity, product_price) VALUES (?, ?, ?, ?);";
        // Get latest orderId to insert list of cartProduct to order.
        int orderId = getLastOrderId();
        for (CartProduct cartProduct : cartProducts) {
            productDao.decreaseProductAmount(cartProduct.getProduct().getId(), cartProduct.getQuantity());
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2, cartProduct.getProduct().getId());
                preparedStatement.setInt(3, cartProduct.getQuantity());
                preparedStatement.setDouble(4, cartProduct.getPrice());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Create order_detail catch:");
                System.out.println(e.getMessage());
            }
        }
    }

    // Method to insert order information to database.
    public void createOrder(int accountId, double totalPrice, List<CartProduct> cartProducts) {
        connection = Database.getConnection();
        String query = "INSERT INTO [order] (account_id, total, date) VALUES (?, ?, DATE('now'))";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, accountId);
            preparedStatement.setDouble(2, totalPrice);
            preparedStatement.executeUpdate();

        } catch ( SQLException e) {
            System.out.println("Create order catch:");
            System.out.println(e.getMessage());
        }

        // Call create order detail method.
        createOrderDetail(cartProducts);
    }

    // Method to get order detail list of a seller.
    public List<CartProduct> getSellerOrderDetail(int productId) {
        List<CartProduct> list = new ArrayList<>();
        String query = "SELECT * FROM order_detail WHERE product_id = " + productId;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = productDao.getProduct(resultSet.getInt(1));
                int productQuantity = resultSet.getInt(3);
                double productPrice = resultSet.getDouble(4);

                list.add(new CartProduct(product, productQuantity, productPrice));
            }
        } catch (SQLException e) {
            System.out.println("Query cart product list catch:");
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Method to get order history of a customer.
    public List<Order> getOrderHistory(int accountId) {
        Account account = accountDao.getAccount(accountId);
        String query;
        if(account.getIsAdmin()==1) {
            query = "SELECT * FROM [order] ";
        }else {
            query = "SELECT * FROM [order] WHERE account_id = " + accountId;
        }

        List<Order> list = new ArrayList<>();
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                double orderTotal = resultSet.getDouble(3);

                list.add(new Order(orderId, orderTotal, null));
            }
        } catch ( SQLException e) {
            System.out.println("Order history catch:");
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Method to get order detail history.
    public List<CartProduct> getOrderDetailHistory(int orderId) {
        List<CartProduct> list = new ArrayList<>();
        String query = "SELECT * FROM order_detail WHERE order_id = " + orderId;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = productDao.getProduct(resultSet.getInt(1));
                int quantity = resultSet.getInt(3);
                double price = resultSet.getDouble(4);

                list.add(new CartProduct(product, quantity ,price));
            }
        } catch (SQLException e) {
            System.out.println("Get order detail catch:");
            System.out.println(e.getMessage());
        }
        return list;
    }
}