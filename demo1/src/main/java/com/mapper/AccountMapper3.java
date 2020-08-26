package com.mapper;

import com.pojo.Account;

import java.util.List;

/**
 * 这里使用 mapper 的实现类
 */
public interface AccountMapper3 {

    List<Account> findAccountList();

}
