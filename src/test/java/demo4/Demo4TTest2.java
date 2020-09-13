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
 * 测试二级缓存，测试时需要在映射文件中加入 <cache/> 标签
 */
public class Demo4TTest2 {
    @Test
    public void testFindById() throws Exception {
        InputStream in = Resources.getResourceAsStream("com/mapper/demo4/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account a1 = mapper.findById(1);
        //sqlSession.clearCache();      //  测试能不能清除二级缓存
        Account a2 = mapper.findById(1);
        System.out.println(a1 == a2);
    }
}
