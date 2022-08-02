package org.wyy.cache;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.wyy.cache.entity.UserLogin;
import org.wyy.cache.mapper.UserLoginMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2022/8/3 00:51
 **/
public class MybatisLocalCacheTest {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 本地缓存默认开启，作用域为sqlSession
     */
    @Test
    public void defaultLocalCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        System.out.println("\n=========================================================================================\n");
        List<UserLogin> list2 = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }

    /**
     * 本地缓存无法通过设置来禁用，
     * 可以使用 flushCache 强制刷新，来达到与禁用缓存相同的效果
     * <select id="queryByNameNoLocalCache" resultMap="BaseMap" flushCache="true">
     */
    @Test
    public void disableLocalCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameNoLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        System.out.println("\n=========================================================================================\n");
        List<UserLogin> list2 = mapper.queryByNameNoLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }

    /**
     * 增删改操作都会刷新
     */
    @Test
    public void queryWithSave(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        UserLogin save = new UserLogin("核弹", "淮南", "172.0.0.2");
        mapper.save(save);
        System.out.println("\n=========================================================================================\n");
        List<UserLogin> list2 = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }

    @Test
    public void queryWithUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        UserLogin save = new UserLogin(24L,"核弹2", "淮南", "172.0.0.2");
        mapper.update(save);
        System.out.println("\n=========================================================================================\n");
        List<UserLogin> list2 = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }

    @Test
    public void queryWithDelete(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        mapper.delete(29L);
        System.out.println("\n=========================================================================================\n");
        List<UserLogin> list2 = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }


    @Test
    public void clearCache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        System.out.println("\n=========================================================================================\n");
        sqlSession.clearCache();
        List<UserLogin> list2 = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }
}
