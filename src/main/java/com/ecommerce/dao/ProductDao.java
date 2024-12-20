package com.ecommerce.dao;

import com.ecommerce.database.Database;
import com.ecommerce.entity.Account;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    // Call DAO class to access other entities' database.
    AccountDao accountDao = new AccountDao();
    CategoryDao categoryDao = new CategoryDao();

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        List<Product> list = productDao.getSellerProducts(1);
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    // Method to execute query to get list products.
    private List<Product> getListProductQuery(String query) {
        List<Product> list = new ArrayList<>();
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                String description = resultSet.getString(4);
                Category category = categoryDao.getCategory(resultSet.getInt(5));
                Account account = accountDao.getAccount(resultSet.getInt(6));
                boolean isDelete = resultSet.getBoolean(7);
                int amount = resultSet.getInt(8);

//                // Get base64 image to display.
//                Blob blob = resultSet.getBlob(9);
//                String base64Image = getBase64Image(blob);

                list.add(new Product(id, name, price, description, category, account, isDelete, amount, null, null));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Method to get all products from database.
    public List<Product> getAllProducts() {
        String query = "SELECT * FROM product WHERE is_deleted = false";
        return getListProductQuery(query);
    }

    // Method to get a product by its id from database.
    public Product getProduct(int productId) {
        Product product = new Product();
        String query = "SELECT * FROM product WHERE id = " + productId;
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setDescription(resultSet.getString(4));
                product.setCategory(categoryDao.getCategory(resultSet.getInt(5)));
                product.setAccount(accountDao.getAccount(resultSet.getInt(6)));
                product.setDeleted(resultSet.getBoolean(7));
                product.setAmount(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    // Method to get a categories by its id from database.
    public List<Product> getAllCategoryProducts(int category_id) {
        String query = "SELECT * FROM product WHERE category_id = " + category_id + " AND is_deleted = false";
        return getListProductQuery(query);
    }

    // Method to search a product by a keyword.
    public List<Product> searchProduct(String keyword) {
        // Query with LIKE to match both name and description.
        String query = "SELECT * FROM Product WHERE (name LIKE ? OR description LIKE ?)";

        // Use a prepared statement to prevent SQL injection.
        try {
             Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameters for the query, using "%" around the keyword for partial matching.
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");

            // Execute the query and retrieve the results.
            resultSet = preparedStatement.executeQuery();

            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                // Populate the product list with the results from the database.
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                productList.add(product);
            }
            return productList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    // Method to get all products of a seller.
    public List<Product> getSellerProducts(int sellerId) {
        String query = "SELECT * FROM product WHERE account_id = " + sellerId;
        return getListProductQuery(query);
    }

    // Method to remove a product from database by its id.
    public void removeProduct(Product product) {
        // Get id of the product.
        int productId = product.getId();

        String query = "UPDATE product SET is_deleted = true WHERE product_id = " + productId;
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to add product to database.
    public void addProduct(String productName, double productPrice, String productDescription, int productCategory, int sellerId, int productAmount) {
        String query = "INSERT INTO product (product_name, product_price, product_description, category_id, account_id, is_deleted, product_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, productPrice);
            preparedStatement.setString(3, productDescription);
            preparedStatement.setInt(4, productCategory);
            preparedStatement.setInt(5, sellerId);
            preparedStatement.setBoolean(6, false);
            preparedStatement.setInt(7, productAmount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to edit product in database.
    public void editProduct(int productId, String productName, double productPrice, String productDescription, int productCategory, int productAmount) {
        String query = "UPDATE product SET product_name = ?, product_price = ?, product_description = ?, category_id = ?, product_amount = ? WHERE product_id = ?";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, productPrice);
            preparedStatement.setString(3, productDescription);
            preparedStatement.setInt(4, productCategory);
            preparedStatement.setInt(5, productId);
            preparedStatement.setInt(6, productAmount);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProductAmount(int productId , int productAmount) {
        String query = "UPDATE product SET amount = ? WHERE id = ?";
        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productAmount);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Method to get 12 products to display on each page.
    public List<Product> get12ProductsOfPage(int index) {
        String query = "SELECT * FROM product WHERE is_deleted = false LIMIT " + ((index - 1) * 12) + ", 12";
        return getListProductQuery(query);
    }

    // Method to get total products in database.
    public int getTotalNumberOfProducts() {
        int totalProduct = 0;
        String query = "SELECT COUNT(*) FROM product WHERE is_deleted = false";
        try {
            connection = new Database().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalProduct = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalProduct;
    }

}
