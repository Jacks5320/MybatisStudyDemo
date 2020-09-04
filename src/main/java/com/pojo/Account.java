package com.pojo;

import java.io.Serializable;

/**
 * 实体类
 */
public class Account implements Serializable {
    private Integer id;
    private String accountName;
    private Double nowMoney;

    public Account() {
    }

    //  加入构造，方便测试时 new 对象
    public Account(Integer id, String accountName, Double nowMoney) {
        this.id = id;
        this.accountName = accountName;
        this.nowMoney = nowMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", nowMoney=" + nowMoney +
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

    public Double getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(Double nowMoney) {
        this.nowMoney = nowMoney;
    }
}
