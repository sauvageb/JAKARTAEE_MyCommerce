package com.mycommerce.project.listener;

import com.mycommerce.project.dao.util.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-------------- APP INITIALIZED -------------- ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------------- APP DESTROYED -------------- ");
        PersistenceManager.closeEntityManagerFactory();
    }
}
