package com.mapper.demo2;

import com.pojo.Account;

import java.util.List;

/**
 * 入门程序，基本的 CRUD 操作
 */
public interface AccountMapper {

    //  查询所有
    List<Account> findAll();
    //  根据 ID 查询
    Account findById(Integer id);
    //  保存
    void saveAccount(Account account);
    //  更新
    void updateAccount(Account account);
    //  删除
    void deleteById(Integer id);
    //  模糊查询1 使用 ${} 拼接
    List<Account> findByName(String name);
    //  模糊查询2 使用 #{} 拼接
    List<Account> findByName2(String name);
    //  模糊查询3 使用 bind 标签拼接
    List<Account> findByName3(String name);
}
