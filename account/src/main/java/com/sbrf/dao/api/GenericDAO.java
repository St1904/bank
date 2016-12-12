package com.sbrf.dao.api;

public interface GenericDAO<T> {
    long create(T t);
    T read(long id);
    void update(T t);
    void delete(T t);
}
