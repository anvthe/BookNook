package com.ecommerce.entity;

import java.util.Arrays;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    private Category category;
    private Account account;
    private boolean isDeleted;
    private int amount;



    public Product() {
    }

    public Product(int id, String name, double price, String description, Category category, Account account, boolean isDeleted, int amount, byte[] image, String base64Image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.account = account;
        this.isDeleted = isDeleted;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", account=" + account +
                ", isDeleted=" + isDeleted +
                ", amount=" + amount +
                '}';
    }
}
