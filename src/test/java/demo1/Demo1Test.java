package demo1;

import com.demo1.mapper.AccountMapper;
import com.demo1.mapper.AccountMapper2;
import com.demo1.mapper.AccountMapper3;
import com.demo1.mapper.AccountMapper3Impl;
import com.demo1.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1Test {

    //  用 xml 配置的方式实现
    @Test
    public void testXmlMapper() throws IOException {
        // 1 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("demo1/mybatis-config.xml");
        // 2 创建 SqlSessionFactory 工厂：使用 SqlSessionFactoryBuilder 构建者
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3 使用工厂生产 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        // 4 使用 SqlSession 创建 Mapper 的代理对象
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        // 5 使用代理对象执行方法
        List<Account> accountList = mapper.findAccountList();
        for (Account account : accountList){
            System.out.println(account);
        }
        // 6 释放资源
        sqlSession.close();
        inputStream.close();
    }

    //  用注解的方式实现
    @Test
    public void testAnnotationMapper() throws IOException {
        // 1 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("demo1/mybatis-config.xml");
        // 2 创建 SqlSessionFactory 工厂：使用 SqlSessionFactoryBuilder 构建者
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3 使用工厂生产 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        // 4 使用 SqlSession 创建 Mapper 的代理对象，这里是 AccountMapper2
        AccountMapper2 mapper = sqlSession.getMapper(AccountMapper2.class);
        // 5 使用代理对象执行方法
        List<Account> accountList = mapper.findAccountList();
        for (Account account : accountList){
            System.out.println(account);
        }
        // 6 释放资源
        sqlSession.close();
        inputStream.close();
    }

    //  用实现类的方式实现
    @Test
    public void testMapperImpl() throws IOException {
        // 1 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("demo1/mybatis-config.xml");
        // 2 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3 创建 Mapper 对象
        AccountMapper3 mapper = new AccountMapper3Impl(factory);
        // 4 执行方法
        List<Account> accountList = mapper.findAccountList();
        for (Account account : accountList){
            System.out.println(account);
        }
        // 5 释放资源
        inputStream.close();
    }
}
