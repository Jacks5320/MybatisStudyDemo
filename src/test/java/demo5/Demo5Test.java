package demo5;

import com.mapper.demo5.StudentMapper;
import com.mapper.demo5.TeacherMapper;
import com.pojo.Student;
import com.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试联表查询结果集映射
 */
public class Demo5Test {

    TeacherMapper teacherMapper = null;
    StudentMapper studentMapper = null;

    @Before
    public void loadConfiguration() throws IOException {
        InputStream in = Resources.getResourceAsStream("com/mapper/demo5/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    //  一对一或多对一查询
    @Test
    public void testFindTwoTable(){
        List<Student> students = studentMapper.findStudentList();
        for (Student student : students){
            System.out.println(student);
        }
    }
}
