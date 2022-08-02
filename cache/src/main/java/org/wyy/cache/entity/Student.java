package org.wyy.cache.entity;

import java.io.Serializable;

/**
 * @author Wyy
 * @version v1.0
 * @apiNote
 * @date : 2022/8/1 15:00
 **/

public class Student implements Serializable {

    private Long id;
    private String name;
    private String addr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
