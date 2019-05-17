package com.company.model.dao;

import java.util.List;

public interface GenericDao<T,Key> extends  AutoCloseable{
    void create (T entity);
    T findByKey(Key key);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
}
