package org.wyy.cache.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2022/8/2 15:25
 **/
@Configuration
@MapperScan(basePackages = {"org.wyy.cache.mapper"})
public class MybatisConfig {

}
