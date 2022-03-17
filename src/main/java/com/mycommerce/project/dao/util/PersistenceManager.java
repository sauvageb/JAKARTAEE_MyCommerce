package com.mycommerce.project.dao.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceManager {

    private static EntityManagerFactory S_INSTANCE;

    private PersistenceManager() {
        // avoid instanciation
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (S_INSTANCE == null) {
            S_INSTANCE = Persistence.createEntityManagerFactory("ecommerce-pu");
        }
        return S_INSTANCE;
    }

    public static void closeEntityManagerFactory() {
        if (S_INSTANCE != null && S_INSTANCE.isOpen()) {
            S_INSTANCE.close();
        }
    }

}
