package com.festech.webapi.repo;


import java.util.List;

public interface IBaseRepo<T> {

    T selectByPrimaryKey(Object key);

    int insert(T entity);

    int insertList(List<T> entityList);

    int deleteByPrimaryKey(Object key);

    int updateByPrimaryKey(T entity);

    int updateByPrimaryKeySelective(T entity);

    T selectOne(T object);

    List<T> select(T object);

    List<T> selectAll();

    int insertOrUpdate(T entity);

}
