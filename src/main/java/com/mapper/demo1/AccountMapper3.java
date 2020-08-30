package com.mapper.demo1;

import com.pojo.Account;

import java.util.List;

/**
 * 入门程序
 * <p>
 * 基于持久层接口实现类方式的持久层接口
 */
public interface AccountMapper3 {

    List<Account> findAll();

}
