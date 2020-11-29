package demo6;

import com.mapper.demo6.CommodityMapper;
import com.mapper.demo6.CommodityOrderMapper;
import com.pojo.Commodity;
import com.pojo.CommodityOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo6Test {

    CommodityMapper commodityMapper = null;
    CommodityOrderMapper commodityOrderMapper = null;

    @Before
    public void loadConfiguration() throws IOException {
        InputStream in = Resources.getResourceAsStream("com/mapper/demo6/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        commodityMapper = sqlSession.getMapper(CommodityMapper.class);
        commodityOrderMapper = sqlSession.getMapper(CommodityOrderMapper.class);
    }

    /**
     * 测试查询一个商品所在的订单列表
     */
    @Test
    public void findTwoTables(){
        List<Commodity> commodityList = commodityMapper.findAll();
        for (Commodity u : commodityList){
            System.out.println(u);
        }
    }

    /**
     * 测试查询一个订单的商品列表
     */
    @Test
    public void findTwoTables2(){
        List<CommodityOrder> commodityList = commodityOrderMapper.findAll();
        for (CommodityOrder o : commodityList){
            System.out.println(o);
        }
    }
}
