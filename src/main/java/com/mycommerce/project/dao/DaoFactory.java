
package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.ProductDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static ProductDao getProductDao() {
        return new MemoryProductDao();
    }
}
