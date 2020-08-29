package com.demo3.mapper;

import com.demo3.pojo.Account;

import java.util.List;

/**
 * 持久层接口
 */
public interface AccountMapper {
    //  查询所有
    List<Account> findAll();

    // 根据 ID 查
    void updateAccount(Account account);
}
