package com.demo4.mapper;

import com.demo3.pojo.Account;

import java.util.List;

/**
 * 持久层接口，pojo 使用 demo 3 中的 pojo
 */
public interface AccountMapper {

    List<Account> findAll();

    void updateAccount(Account account);
}
