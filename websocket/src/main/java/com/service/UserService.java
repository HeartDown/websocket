package com.service;

import com.alibaba.fastjson.JSON;
import com.dao.daoimpl.UserDaoImpl;
import com.model.User;
import com.mongo.ServiceBaseImpl;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public boolean login(User user) {
        User dbuser = findOne(new Query(Criteria.where("username")
                .is(user.getUsername())));
        if (dbuser!=null){
            if(dbuser.getPassword().equals(user.getPassword())){
                user.setId(dbuser.getId());
                return true;
            }
        }
        return false;
    }
}
