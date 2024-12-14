package com.ecommerce.entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private int isUser;
    private int isAdmin;
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Account() {

    }

    public Account(int id, String username, String password, int isSeller, int isAdmin, String address, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isUser = isSeller;
        this.isAdmin = isAdmin;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSeller() {
        return isUser;
    }

    public void setIsSeller(int isSeller) {
        this.isUser = isSeller;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
