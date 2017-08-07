package com.mongo;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangheng on 2017/8/7.
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {RuntimeException.class})
public class ServiceBaseImpl<T> implements ServiceBase<T>{

    protected MongoBase<T> mongoBase;
    @Override
    public void insert(T object, String connectionName) {
        mongoBase.insert(object,connectionName);
    }

    @Override
    public T findById(String id) {
         return mongoBase.findById(id);
    }

    @Override
    public T findOne(Query query, String connectionName) {
        return mongoBase.findOne(query,connectionName);
    }

    @Override
    public List<T> findAll(String collectionName) {
        return mongoBase.findAll(collectionName);
    }

    @Override
    public List<T> findAllByQuery(Query query, String collectionName) {
        return mongoBase.findAllByQuery(query,collectionName);
    }

    @Override
    public int upsert(Query query, Update update, String collectionName) {
        return mongoBase.upsert(query,update,collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoBase.createCollection(collectionName);
    }

    @Override
    public int remove(Query query, String collectionName) {
        return mongoBase.remove(query,collectionName);
    }

    @Override
    public int removeObj(Object object) {
        return mongoBase.removeObj(object);
    }
}
