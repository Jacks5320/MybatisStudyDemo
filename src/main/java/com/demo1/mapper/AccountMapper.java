package com.demo1.mapper;

import com.demo1.pojo.Account;

import java.util.List;

/**
 * 用户的持久层接口
 * 在 MyBatis 中，将持久层接口名称和映射文件叫做 Mapper
 * 这里使用 xml 配置文件
 */
public interface AccountMapper {

    List<Account> findAccountList();
    
}
