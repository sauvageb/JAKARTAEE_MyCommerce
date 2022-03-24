package com.mycommerce.project.dao.jpa;

import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.entity.Product;
import com.mycommerce.project.dao.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaProductDao implements ProductDao {

    @Override
    public Product findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Product p = em.find(Product.class, id);
        em.close();
        return p;
    }

    @Override
    public Long add(Product product) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            if (em.contains(product)) {
                em.persist(product);
                em.flush();
            } else {
                product = em.merge(product);
                em.persist(product);
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            return product.getId();
        }
    }

    @Override
    public void remove(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Product p = em.find(Product.class, id);
            em.remove(p);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<Product> getAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        TypedQuery<Product> query =
                em.createQuery("SELECT p FROM Product AS p", Product.class);
        List<Product> products = query.getResultList();
        em.close();
        return products;
    }

    @Override
    public void update(Product product) {
        //  TODO
    }

    @Override
    public void remove(Product product) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            if (em.contains(product)) {
                em.remove(product);
            } else {
                product = em.merge(product);
                em.remove(product);
            }
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}
