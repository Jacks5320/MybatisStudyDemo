package com.demo2.mapper;

import com.demo2.pojo.Account;

import java.util.List;

/**
 * 持久层接口
 */
public interface AccountMapper {
    List<Account> findAll();

    Account findByName(String name);

    void save(Account account);

    void update(Account account);

    void delete(Integer id);
}
