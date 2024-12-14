package com.ecommerce.entity;

import java.util.Arrays;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    private int categoryId;
    private int accountId;
    private boolean isDeleted;
    private int amount;

    private byte[] image;
    private String base64Image;


    public Product() {
    }

    public Product(int id, String name, String base64Image, double price, String description, int categoryId, int accountId, boolean isDeleted, int amount, Category category, Account account) {
        this.id = id;
        this.name = name;
        this.base64Image = base64Image;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.accountId = accountId;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
                ", categoryId=" + categoryId +
                ", accountId=" + accountId +
                ", isDeleted=" + isDeleted +
                ", amount=" + amount +
                ", image=" + Arrays.toString(image) +
                ", base64Image='" + base64Image + '\'' +
                '}';
    }
}
