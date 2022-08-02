package org.wyy.cache;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wyy.cache.entity.Student;
import org.wyy.cache.mapper.StudentMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2022/8/2 16:45
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CacheTest {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getByName("核弹");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("same session---------");
        List<Student> list2 = mapper.getByName("核弹");
        for (Student student : list2) {
            System.out.println(student);
        }

        System.out.println("same namespace-----------");
        sqlSession.commit();

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        StudentMapper mapper3 = sqlSession3.getMapper(StudentMapper.class);
        List<Student> list3 = mapper3.getByName("核弹");
        for (Student student : list3) {
            System.out.println(student);
        }
    }
}
