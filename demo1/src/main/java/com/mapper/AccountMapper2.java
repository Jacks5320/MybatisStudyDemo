package com.mapper;

import com.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 这里使用 注解 的方式实现查询。
 */
public interface AccountMapper2 {

    @Select("select * from tb_account")
    List<Account> findAccountList();

}
