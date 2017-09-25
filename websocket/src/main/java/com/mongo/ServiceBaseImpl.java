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
    public void insert(T object) {
        mongoBase.insert(object);
    }

    @Override
    public T findById(String id) {
         return mongoBase.findById(id);
    }

    @Override
    public T findOne(Query query) {
        return mongoBase.findOne(query);
    }

    @Override
    public List<T> findAll() {
        return mongoBase.findAll();
    }

    @Override
    public List<T> findAllByQuery(Query query) {
        return mongoBase.findAllByQuery(query);
    }

    @Override
    public int upsert(Query query, Update update) {
        return mongoBase.upsert(query,update);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoBase.createCollection(collectionName);
    }

    @Override
    public int remove(Query query) {
        return mongoBase.remove(query);
    }

    @Override
    public int removeObj(Object object) {
        return mongoBase.removeObj(object);
    }
}
