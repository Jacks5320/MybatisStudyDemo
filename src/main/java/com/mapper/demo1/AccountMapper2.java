package com.mapper.demo1;

import com.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 入门程序
 * <p>
 * 基于 注解 方式的持久层接口
 */
public interface AccountMapper2 {

    @Select("select id,name as accountName,money as nowMoney from tb_account")
    List<Account> findAll();
}
