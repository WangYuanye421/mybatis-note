package org.wyy.cache.mapper;

import org.wyy.cache.entity.Student;

import java.util.List;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2022/8/1 15:00
 **/
public interface StudentMapper {

    List<Student> getByName(String name);
}
