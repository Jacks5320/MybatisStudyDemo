package com.demo2.mapper;

import com.demo2.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层接口
 */
public interface AccountMapper {
    //  查询所有
    List<Account> findAll();

    //  根据名称查询
    Account findById(Integer id);

    //  保存
    void saveAccount(Account account);

    //  更新
    void updateAccount(Account account);

    //  根据 id 删除用户
    void deleteAccount(Integer id);

    //  根据名称模糊查询
    List<Account> findByName(String name);

    //  使用聚合函数查询
    int findTotal();

    //  根据名称和money查询
    List<Account> findByNameAndMoney(@Param("name") String name,@Param("money") Double money);


}
