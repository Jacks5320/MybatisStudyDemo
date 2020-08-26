package com.mapper;

import com.pojo.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 实现类：不推荐使用，作为了解
 */
public class AccountMapper3Impl implements AccountMapper3 {

    private final SqlSessionFactory sqlSessionFactory;

    public AccountMapper3Impl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Account> findAccountList() {
        // 1 使用 工厂 创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //  参数为对应的方法名
        return sqlSession.selectList("com.mapper.AccountMapper3.findAccountList");
    }
}
