package com.aurora.pojo;

public class User {
    private String name;
    private Double balance;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public User() {
    }

    public User(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
