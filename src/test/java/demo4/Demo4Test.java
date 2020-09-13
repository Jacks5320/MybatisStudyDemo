package demo4;

import com.mapper.demo4.AccountMapper;
import com.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * 测试一级缓存，测试的时候需要注释掉 映射文件中的 <cache/> 标签
 */

public class Demo4Test {

    /*
    感受一级缓存
     */
    @Test
    public void testFindByCache() throws Exception {
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account a1 = mapper.findById(1);
        Account a2 = mapper.findById(1);
        System.out.println(a1 == a2);
    }

    /*
    缓存失败情况一：SqlSession 对象不同
     */
    @Test
    public void testDifferentSqlSession() throws Exception{
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //  第一个 SqlSession 对象
        SqlSession s1 = sqlSessionFactory.openSession();
        AccountMapper m1 = s1.getMapper(AccountMapper.class);
        //  第二个 SqlSession 对象
        SqlSession s2 = sqlSessionFactory.openSession();
        AccountMapper m2 = s2.getMapper(AccountMapper.class);

        Account a1 = m1.findById(1);
        Account a2 = m2.findById(1);
        System.out.println(a1 == a2);
    }
    /*
        缓存失败情况二：SqlSession 相同，查询条件不同，缓存中没有该数据
     */
    @Test
    public void testDifferentCondition() throws Exception{
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);

        Account a1 = mapper.findById(1);
        Account a2 = mapper.findById(2);
        System.out.println(a1 == a2);
    }
    /*
        缓存失败情况三：两次查询之间进行了 增删改操作
    */
    @Test
    public void testCUDbtTowFind() throws Exception{
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        //  第一次查询
        Account a1 = mapper.findById(1);
        //  修改第一条记录
        Account account = new Account(1,"ffff",1600.0);
        mapper.updateAccount(account);
        //  第二次查询
        Account a2 = mapper.findById(1);
        System.out.println(a1 == a2);
    }
    /*
    缓存失败情况四：手动清除缓存。
*/
    @Test
    public void testClearCache() throws Exception{
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        //  第一次查询
        Account a1 = mapper.findById(1);
        //  清除缓存
        sqlSession.clearCache();
        //  第二次查询
        Account a2 = mapper.findById(1);
        System.out.println(a1 == a2);
    }
}
