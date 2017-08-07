package com.util;

import com.mongo.MongoBaseImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by zhangheng on 2017/8/7.
 */
public class ReflectUtil {
    public static <T> Class<T> findParameterizedType(Class<? extends MongoBaseImpl> aClass) throws ClassNotFoundException {
        Type type = aClass.getGenericSuperclass();
        //如果泛型在父类上
        if(!(type instanceof ParameterizedType)){
            type = aClass.getSuperclass().getGenericSuperclass();
        }
        if (!(type instanceof ParameterizedType)){
            return null;
        }
        Type[] types = ((ParameterizedType)type).getActualTypeArguments();
        if (types==null || types.length==0){
            return null;
        }
        return (Class) types[0];
    }
}
