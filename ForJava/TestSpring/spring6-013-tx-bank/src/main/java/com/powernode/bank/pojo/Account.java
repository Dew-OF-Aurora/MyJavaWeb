package com.powernode.bank.pojo;

/**
 * 银行账户类
 * @author 动力节点
 * @version 1.0
 * @className Account
 * @since 1.0
 **/
public class Account {
    private String name;
    private Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account() {
    }

    public Account(String name, Double balance) {
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
