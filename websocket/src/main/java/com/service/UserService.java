package com.service;

import com.dao.daoimpl.UserDaoImpl;
import com.model.User;
import com.mongo.ServiceBaseImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Service
public class UserService extends ServiceBaseImpl<User> {
    private UserDaoImpl userDaoImpl;

    @Resource
    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
        this.mongoBase = userDaoImpl;
    }
}
