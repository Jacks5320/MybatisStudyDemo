package com.demo1.mapper;

import com.demo1.pojo.Account;

import java.util.List;

/**
 * 这里使用 com.mapper 的实现类
 */
public interface AccountMapper3 {

    List<Account> findAccountList();

}
