package com.mongo;

import com.util.ReflectUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangheng on 2017/8/7.
 */
public class MongoBaseImpl<T> implements MongoBase<T>{
    @Resource
    private MongoTemplate template;

    public MongoBaseImpl() throws ClassNotFoundException {
            this.entityClass = ReflectUtil.findParameterizedType(getClass());
    }

    private Class<T> entityClass;
    public void insert(T object, String connectionName) {
        template.insert(object,connectionName);
    }

    @Override
    public T findById(String id) {
        return template.findOne(new Query(Criteria.where("id").is(id)),entityClass);
    }

    @Override
    public T findOne(Query query, String connectionName) {
        return template.findOne(query,entityClass,connectionName);
    }
    @Override
    public List<T> findAll(String collectionName) {
        return template.findAll(entityClass);
    }

    @Override
    public List<T> findAllByQuery(Query query, String collectionName) {
        return template.find(query,entityClass,collectionName);
    }

    @Override
    public int upsert(Query query, Update update, String collectionName) {
       return template.upsert(query,update,entityClass,collectionName).getN();
    }
    @Override
    public void createCollection(String collectionName) {
        template.createCollection(collectionName);
    }
    @Override
    public int remove(Query query, String collectionName) {
       return template.remove(query,collectionName).getN();
    }

    @Override
    public int removeObj(Object object) {
        return template.remove(object).getN();
    }
}
