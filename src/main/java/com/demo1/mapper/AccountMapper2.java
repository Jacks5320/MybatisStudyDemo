package com.demo1.mapper;

import com.demo1.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 这里使用 注解 的方式实现查询。
 */
public interface AccountMapper2 {

    @Select("select * from tb_account")
    List<Account> findAccountList();

}
