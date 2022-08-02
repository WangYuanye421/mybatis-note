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
 * @date : 2022/8/3 00:50
 **/
public class MybatisLevel2CacheTests {

    @Resource
    private SqlSessionFactory sqlSessionFactory;


    /**
     * 默认禁用二级缓存
     */
    @Test
    public void defaultDisableLevel2Cache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        System.out.println("\n==================SQLSession中=================\n");
        List<UserLogin> oneMore = mapper.queryByNameLocalCache("核弹");
        for (UserLogin e : oneMore) {
            System.out.println(e);
        }
        System.out.println("\n==================新的SQLSession=================\n");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserLoginMapper mapper2 = sqlSession2.getMapper(UserLoginMapper.class);
        List<UserLogin> list2 = mapper2.queryByNameLocalCache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }

    /**
     * 启用二级缓存（作用域为namespace）
     * mybatis全局配置 cache-enabled: true 或 <cache/>标签
     * 具体的statement 使用 useCache = true，使本地一级缓存变为二级缓存（即作用域由SQLSession提示为namespace）
     *
     * <cache/> <!--开启全局缓存-->
     * 	<select id="queryByNameLevel2Cache" resultMap="BaseMap" useCache="true">
     */
    @Test
    public void enableLevel2Cache(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserLoginMapper mapper = sqlSession.getMapper(UserLoginMapper.class);
        List<UserLogin> list = mapper.queryByNameLevel2Cache("核弹");
        for (UserLogin e : list) {
            System.out.println(e);
        }
        System.out.println("\n========相同的SQLSession=======\n");
        List<UserLogin> oneMore = mapper.queryByNameLevel2Cache("核弹");
        for (UserLogin e : oneMore) {
            System.out.println(e);
        }
        // session如果不关闭，二级缓存无法启用
        sqlSession.commit();
        System.out.println("\n========新的SQLSession=======\n");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserLoginMapper mapper2 = sqlSession2.getMapper(UserLoginMapper.class);
        List<UserLogin> list2 = mapper2.queryByNameLevel2Cache("核弹");
        for (UserLogin e : list2) {
            System.out.println(e);
        }
    }
}
