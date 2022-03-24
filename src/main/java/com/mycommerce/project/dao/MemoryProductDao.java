package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.entity.Product;
import com.mycommerce.project.dao.exception.UnknownProductException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MemoryProductDao implements ProductDao {

    private static List<Product> products = new ArrayList();
    private static Long idSequence = 1L;

    MemoryProductDao() {
    }

    @Override
    public Long add(Product product) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        product.setId(var1);
        products.add(product);
        return var1;
    }

    @Override
    public void update(Product product) {
        int index = this.getIndexById(product.getId());
        if (index > -1) {
            products.set(index, product);
        } else {
            throw new UnknownProductException(product.getId());
        }
    }

    @Override
    public Product findById(Long id) {
        int index = this.getIndexById(id);
        if (index > -1) {
            Product product = products.get(index);
            return product;
        } else {
            throw new UnknownProductException(id);
        }
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void remove(Product product) {
        this.remove(product.getId());
    }

    @Override
    public void remove(Long id) {
        int index = this.getIndexById(id);
        if (index > -1) {
            products.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private int getIndexById(Long id) {
        for (int i = 0; i < products.size(); ++i) {
            Product product = products.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
