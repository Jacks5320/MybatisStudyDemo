package com.demo3.pojo;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String accountName;
    private double nowMoney;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", nowMoney='" + nowMoney + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(double nowMoney) {
        this.nowMoney = nowMoney;
    }
}
