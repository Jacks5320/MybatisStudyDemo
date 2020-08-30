package demo2;

import com.mapper.demo2.AccountMapper;
import com.pojo.Account;
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
        in = Resources.getResourceAsStream("com/mapper/demo2/mybatis-config.xml");
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

    //  1 测试查询所有
    @Test
    public void testFindAll() {
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    // 2 根据 id 查询
    @Test
    public void testFindById(){
        Account account = mapper.findById(1);
        System.out.println(account);
    }

    // 3 新增一条记录
    @Test
    public void testSave(){
        Account account = new Account();
        account.setAccountName("李华");
        System.out.println("提交前：" + account);
        mapper.saveAccount(account);
        //  提交事务！
        sqlSession.commit();
        //  获取到 key
        System.out.println("提交后：" + account);
    }

    // 4 修改一条数据，修改新增数据的 money
    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setNowMoney(10000.0);
        mapper.updateAccount(account);
        // 提交事务！
        sqlSession.commit();
    }

    // 5 删除一条数据
    @Test
    public void testDelete(){
        mapper.deleteById(4);
        // 提交事务
        sqlSession.commit();
    }

    // 6 模糊查询：可以再控制台看日志中发送的 sql 语句，区分 ${} 与 #{} 的区别
    @Test
    public void testFindByName(){
        //模糊查询1：使用 ${}
        List<Account> accountList1 = mapper.findByName("小");
        for (Account account : accountList1){
            System.out.println(account);
        }

        System.out.println(" ------- 分割线 -------- ");

        //模糊查询2：使用 #{}，在外面拼接好再传入，更灵活
        List<Account> accountList2 = mapper.findByName2("%小%");
        for (Account account : accountList2){
            System.out.println(account);
        }

        System.out.println(" ------- 分割线 -------- ");

        //模糊查询3：使用 #{} + bind 标签，可以避免 sql 注入
        List<Account> accountList3 = mapper.findByName3("小");
        for (Account account : accountList3){
            System.out.println(account);
        }
    }
}
