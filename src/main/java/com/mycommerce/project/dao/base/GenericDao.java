package com.mycommerce.project.dao.base;

import java.util.List;

public interface GenericDao<T, ID extends Number> {

    ID addProduct(T object);

    void updateProduct(T object);

    T findProductById(ID id);

    List<T> getAllProducts();

    void removeProduct(T var1);

    void removeProduct(ID id);
}
