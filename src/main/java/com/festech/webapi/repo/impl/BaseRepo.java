package com.festech.webapi.repo.impl;

import com.festech.webapi.base.utils.MyMapper;
import com.festech.webapi.repo.IBaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseRepo<T> implements IBaseRepo<T> {

    @Autowired
    protected MyMapper<T> mapper;

    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int insert(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public int insertList(List<T> entityList) {
        return mapper.insertList(entityList);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public T selectOne(T object) {
        return mapper.selectOne(object);
    }

    @Override
    public List<T> select(T object) {
        return mapper.select(object);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insertOrUpdate(T entity) {
        T object = mapper.selectByPrimaryKey(entity);
        if (object == null) {
            return insert(entity);
        }
        return updateByPrimaryKeySelective(entity);


    }

}
