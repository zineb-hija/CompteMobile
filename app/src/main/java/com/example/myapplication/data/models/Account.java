package com.example.myapplication.data.models;
public class Account {
    private String id;
    private String type; // "epargne" ou "courant"
    private double balance;

    public Account(String id, String type, double balance) {
        this.id = id;
        this.type = type;
        this.balance = balance;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}