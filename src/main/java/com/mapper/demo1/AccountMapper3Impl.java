package com.mapper.demo1;

import com.pojo.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 持久成实现类
 */
public class AccountMapper3Impl implements AccountMapper3{

    private final SqlSessionFactory sqlSessionFactory;

    public AccountMapper3Impl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Account> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("com.mapper.demo1.AccountMapper3Impl.findAll");
    }
}
