package com.mongo;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by zhangheng on 2017/8/7.
 */
public interface ServiceBase<T> {
    /**
     * 插入一个对象到指定集合中
     * @param object 对象实体
     * @param connectionName 集合名
     */
    public void insert(T object, String connectionName);

    /**
     * 通过id查找实体
     * @param id
     * @return
     */
    public T findById(String id);

    /**
     * 根据查询参数查找实体
     * @param query
     * @param connectionName 集合名
     * @return
     */
    public T findOne(Query query,String connectionName);

    /**
     * 查询全部实体文档
     * @param collectionName 集合名
     * @return
     */
    public List<T> findAll( String collectionName);

    /**
     * 根据Query查询全部实体
     * @param query
     * @param collectionName 集合名
     * @return
     */
    public List<T> findAllByQuery(Query query, String collectionName);
    /**
     * 查找更新,如果没有找到符合的记录,则将更新的记录插入库中
     * @param query
     * @param update
     * @param collectionName
     */
    public int upsert(Query query, Update update, String collectionName);

    /**
     * 创建集合
     * @param collectionName 新集合名称
     */
    public void createCollection(String collectionName);

    /**
     * 根据条件删除
     * @param query
     * @param collectionName 集合名
     */
    public int remove(Query query, String collectionName);
    /**
     * 根据对象删除
     * @param object 删除的对象
     */
    public int removeObj(Object object);
}
