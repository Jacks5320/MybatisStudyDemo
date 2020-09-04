package com.mapper.demo3;

import com.pojo.Account;

import java.util.List;

/**
 * 入门程序，基本的 CRUD 操作
 */
public interface AccountMapper {
    //  根据条件查询
    List<Account> findByCondition(Account account);
    //  选择条件查询
    List<Account> findByChoose(Account account);
    //  使用 trim 拼接
    List<Account> findByTrim(Account account);
    //  批量保存
    void saveList(List<Account> accounts);
    //  批量更新
    void updateList(List<Account> accounts);
    //  使用 bind 标签拼接模糊查询的 %
    List<Account> findByName(String name);
    //  使用 sql 标签提取出重复 sql 语句
    Account findById(Integer id);
}
