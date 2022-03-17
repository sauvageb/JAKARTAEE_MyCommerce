package com.mycommerce.project.dao.base;

import java.util.List;

public interface GenericDao<T, ID extends Number> {

    ID add(T object);

    void update(T object);

    T findById(ID id);

    List<T> getAll();

    void remove(T var1);

    void remove(ID id);
}
