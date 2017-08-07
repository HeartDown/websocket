package com.dao.daoimpl;

import com.dao.UserDao;
import com.model.User;
import com.mongo.MongoBaseImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Repository("userDaoImpl")
public class UserDaoImpl extends MongoBaseImpl<User>{
    public UserDaoImpl() throws ClassNotFoundException {
    }
}
