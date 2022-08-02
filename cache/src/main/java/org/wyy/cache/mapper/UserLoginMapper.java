package org.wyy.cache.mapper;

import org.wyy.cache.entity.UserLogin;

import java.util.List;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2021/9/8 5:46 下午
 **/
public interface UserLoginMapper {

    /**
     * 开启本地缓存
     * @param name
     * @return
     */
    List<UserLogin> queryByNameLocalCache(String name);

    /**
     * 不开启本地缓存
     * @param name
     * @return
     */
    List<UserLogin> queryByNameNoLocalCache(String name);

    /**
     * 开启全局缓存
     * @param name
     * @return
     */
    List<UserLogin> queryByNameLevel2Cache(String name);

    void save(UserLogin bean);

    void update(UserLogin bean);

    void delete(Long id);

    /**
     * 对象查询
     * @param condition
     * @return
     */
    List<UserLogin> queryByCondition(UserLogin condition);
}
