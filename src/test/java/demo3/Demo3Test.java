package demo3;

import com.demo3.mapper.AccountMapper;
import com.demo3.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试结果集封装
 */
public class Demo3Test {

    InputStream in = null;
    SqlSession sqlSession = null;
    AccountMapper mapper = null;

    @Before  //  测试方法执行之前执行
    public void init() throws Exception {
        // 1 将配置文件读到字节输入流
        in = Resources.getResourceAsStream("demo3/mybatis-config.xml");
        // 2 使用构建者读取字节流，创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3 使用工厂创建 SqlSession 对象
        sqlSession = factory.openSession();
        // 4 使用 SqlSession 对象创建 Mapper 代理对象
        mapper = sqlSession.getMapper(AccountMapper.class);
    }

    @After  //  执行方法执行结束后执行
    public void after() throws Exception {
        // 6 释放资源
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList){
            System.out.println(account);
        }
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(2);
        account.setAccountName("小李");
        account.setNowMoney(4000.0);
        mapper.updateAccount(account);
        //  提交事务
        sqlSession.commit();
    }
}
