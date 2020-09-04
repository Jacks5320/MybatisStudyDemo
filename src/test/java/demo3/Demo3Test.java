package demo3;

import com.mapper.demo3.AccountMapper;
import com.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试动态 SQL 相关方法
 */
public class Demo3Test {
    InputStream in = null;
    SqlSession sqlSession = null;
    AccountMapper mapper = null;

    @Before  //  测试方法执行之前执行
    public void init() throws Exception {
        // 1 将配置文件读到字节输入流
        in = Resources.getResourceAsStream("com/mapper/demo3/mybatis-config.xml");
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

    //  测试使用 if 标签作为 条件判断
    @Test
    public void testFindByCondition(){
        //  1 都为空，默认查询 所有
        //Account account = new Account(null,null,0.0);
        //  2 部分为空
        //Account account = new Account(1,null,0.0);
        //  3 与数据库不一致，数据库中 1 号是 小张，查出结果为 null
        Account account = new Account(1,"小李",null);

        List<Account> accountList = mapper.findByCondition(account);

        for (Account ac : accountList){
            System.out.println(ac);
        }
    }

    // 测试choose 方法
    @Test
    public void testFindByChoose(){
        //  1 都为空，默认查询执行，otherwise 中的条件
        //Account account = new Account(null,null,null);
        //  2 部分为空
        //Account account = new Account(2,null,null);
        //  3 与数据库不一致，默认使用 id 属性后跳出
        Account account = new Account(1,"小李",null);

        List<Account> accountList = mapper.findByChoose(account);

        for (Account ac : accountList){
            System.out.println(ac);
        }
    }

    // 测试 使用 trim 处理字符
    @Test
    public void testFindByTrim(){
        //  1 都为空，默认查询所有 select * from tb_account
        //Account account = new Account(null,null,null);
        //  2 部分为空，select * from tb_account where id = ?
        //Account account = new Account(2,null,null);
        //  3 与数据库不一致，返回 null，select * from tb_account where id = ? AND name=?
        Account account = new Account(1,"小李",100.0);

        List<Account> accountList = mapper.findByTrim(account);

        for (Account ac : accountList){
            System.out.println(ac);
        }
    }

    //  测试批量保存
    @Test
    public void testSaveList(){
        Account a1 = new Account(null,"小新",123000.0);
        Account a2 = new Account(null,"小华",213000.0);
        Account a3 = new Account(null,"小白",312000.0);
        List<Account> accountList = new ArrayList<>();
        accountList.add(a1);
        accountList.add(a2);
        accountList.add(a3);
        mapper.saveList(accountList);
        System.out.println("----------------------------------------");
        sqlSession.commit();
    }

    //  测试批量更新
    @Test
    public void testUpdateList(){
        Account a1 = new Account(1,"aaa",0.0);
        Account a2 = new Account(2,"bbb",0.0);
        Account a3 = new Account(3,"ccc",0.0);
        List<Account> accountList = new ArrayList<>();
        accountList.add(a1);
        accountList.add(a2);
        accountList.add(a3);
        mapper.updateList(accountList);
        System.out.println("----------------------------------------");
        sqlSession.commit();
    }

    //  测试使用 bind 标签拼接模糊查询的 %
    @Test
    public void testFindByName(){
        List<Account> accountList = mapper.findByName("小");
        for (Account account : accountList){
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        Account account = mapper.findById(1);
        System.out.println(account);
    }
}
