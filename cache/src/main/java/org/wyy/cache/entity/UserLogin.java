package org.wyy.cache.entity;


import java.io.Serializable;

/**
 *
 * @author Yuanye Wang
 * @date 2022/7/31 18:01
 **/
public class UserLogin implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String loginIp;

    public UserLogin() {
    }

    public UserLogin(Long id, String name, String address, String loginIp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.loginIp = loginIp;
    }

    public UserLogin(String name, String address, String loginIp) {
        this.name = name;
        this.address = address;
        this.loginIp = loginIp;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
