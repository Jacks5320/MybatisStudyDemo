package demo4;

import com.demo4.mapper.AccountMapper;
import com.demo3.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 核心配置文件中的标签
 */
public class Demo4Test {

    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("com/demo4/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accountList = mapper.findAll();
        for(Account account : accountList){
            System.out.println(account);
        }
    }
}
