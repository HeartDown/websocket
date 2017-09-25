package com.mongo;

import com.util.ReflectUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

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
    public void insert(T object) {
        try {
            //主动给当前实体类设置id值
            Field field = entityClass.getField("id");
            field.set(object,UUID.randomUUID().toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        template.insert(object);
    }

    @Override
    public T findById(String id) {
        return template.findOne(new Query(Criteria.where("id").is(id)),entityClass);
    }

    @Override
    public T findOne(Query query) {
        return template.findOne(query,entityClass);
    }
    @Override
    public List<T> findAll() {
        return template.findAll(entityClass);
    }

    @Override
    public List<T> findAllByQuery(Query query) {
        return template.find(query,entityClass);
    }

    @Override
    public int upsert(Query query, Update update) {
       return template.upsert(query,update,entityClass).getN();
    }
    @Override
    public void createCollection(String collectionName) {
        template.createCollection(collectionName);
    }
    @Override
    public int remove(Query query) {
       return template.remove(query).getN();
    }

    @Override
    public int removeObj(Object object) {
        return template.remove(object).getN();
    }
}
