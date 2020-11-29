package demo7;

import com.mapper.demo7.AccountMapper;
import com.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo7Test {

    AccountMapper accountMapper;
    SqlSession sqlSession;

    @Before
    public void loadConfiguration() throws IOException {
        InputStream in = Resources.getResourceAsStream("com/mapper/demo7/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    /**
     * 使用 limit 关键字进行分页
     */
    @Test
    public void testFindPage() {
        //long totalSize = accountMapper.getTotalSize();
        //System.out.println(totalSize);

        Map<String, Integer> map = new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 2);
        List<Account> page = accountMapper.findPage(map);
        System.out.println(page);
    }

    /**
     * 使用 RowBounds 进行分页
     */
    @Test
    public void testFindPage2() {
        RowBounds rowBounds = new RowBounds(2, 2);
        List<Account> accountList = accountMapper.findPage2(rowBounds);
        System.out.println(accountList);

        // 下面是用 SqlSession 提供的方法传入 RowBounds 对象
        // 对象用于传入查询条件
        //Account account = new Account();
        //List<Object> list = sqlSession.selectList("com.mapper.demo7.AccountMapper.findPage2", account, rowBounds);
        //System.out.println(list);
    }
}