package com.dao.daoimpl;

import com.model.User;
import com.mongo.MongoBaseImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends MongoBaseImpl<User>{
    public UserDaoImpl() throws ClassNotFoundException {
    }
}
