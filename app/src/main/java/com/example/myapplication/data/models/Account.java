package com.example.myapplication.data.models;

public class Account {
    private int id;
    private String type;
    private double balance;

    public Account(int id, String type, double balance) {
        this.id = id;
        this.type = type;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}