package demo2;

import com.demo2.mapper.AccountMapper;
import com.demo2.pojo.Account;
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
 * 测试基本的 CRUD 操作
 */
public class Demo2Test {

    InputStream in = null;
    SqlSession sqlSession = null;
    AccountMapper mapper = null;

    @Before  //  测试方法执行之前执行
    public void init() throws Exception {
        // 1 将配置文件读到字节输入流
        in = Resources.getResourceAsStream("com/demo2/mybatis-config.xml");
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

    //  测试查询所有
    @Test
    public void testFindAll() {
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    //  测试根据 id 查询
    @Test
    public void testFindById() {
        int id = 1;
        Account account = mapper.findById(id);
        System.out.println(account);
    }

    //  测试保存
    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("小刘");
        account.setMoney(3000.0);
        System.out.println("保存操作之前：" + account);
        mapper.saveAccount(account);
        System.out.println("保存操作之后：" + account);
        //  提交事务
        sqlSession.commit();
    }

    //  测试更新操作
    @Test
    public void testUpdateAccount() {
        Account account = mapper.findById(1);
        account.setMoney(5000.0);
        mapper.updateAccount(account);
        //  提交事务
        sqlSession.commit();
    }

    //  测试根据 id 删除
    @Test
    public void testDelete() {
        int id = 6;
        mapper.deleteAccount(id);
        //  提交事务
        sqlSession.commit();
    }

    //  测试根据名称模糊查询
    @Test
    public void testFindByName() {
        //String name = "%李%";
        String name = "李";
        List<Account> accountList = mapper.findByName(name);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    //  测试使用聚合函数查询记录数
    @Test
    public void testFindTotal() {
        int count = mapper.findTotal();
        System.out.println(count);
    }

    //  测试多参数查询
    @Test
    public void test() {
        List<Account> accountList = mapper.findByNameAndMoney("李", 4000.0);
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}
