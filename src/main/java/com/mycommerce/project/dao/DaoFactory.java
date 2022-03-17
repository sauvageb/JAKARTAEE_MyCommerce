
package com.mycommerce.project.dao;


import com.mycommerce.dao.base.ProductDao;
import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.jpa.JpaCategoryDao;
import com.mycommerce.project.dao.jpa.JpaProductDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static ProductDao getProductDao() {
//        return new MemoryProductDao();
        return new JpaProductDao();
    }

    public static CategoryDao getCategoryDao() {
        return new JpaCategoryDao();
    }

}
