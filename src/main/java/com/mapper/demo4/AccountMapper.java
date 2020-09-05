package com.mapper.demo4;

import com.pojo.Account;

public interface AccountMapper {
    //  根据 id 查询
    Account findById(Integer id);
    //  修改
    void updateAccount(Account account);
}
