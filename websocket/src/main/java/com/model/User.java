package com.model;

import java.io.Serializable;

/**
 * Created by zhangheng on 2017/8/7.
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;


    private String username;


    private String personinfo;

    private String password;

    public String getPersoninfo() {
        return personinfo;
    }

    public void setPersoninfo(String personinfo) {
        this.personinfo = personinfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
