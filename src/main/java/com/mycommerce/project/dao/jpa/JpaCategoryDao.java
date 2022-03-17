package com.mycommerce.project.dao.jpa;

import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.entity.Category;
import com.mycommerce.project.dao.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaCategoryDao implements CategoryDao {

    @Override
    public Long add(Category category) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(category);
            em.flush();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            return category.getId();
        }
    }

    @Override
    public void remove(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        Category category = findById(id);
        et.begin();
        try {
            em.remove(em.contains(category) ? category : em.merge(category));
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
    public List<Category> getAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        TypedQuery<Category> query =
                em.createQuery("SELECT c FROM Category AS c", Category.class);
        List<Category> categories = query.getResultList();
        em.close();
        return categories;
    }

    @Override
    public void update(Category category) {
        //  TODO
        throw new RuntimeException("update not implemented");
    }

    @Override
    public void remove(Category category) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(category);
            em.remove(category);
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
    public Category findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Category c = em.find(Category.class, id);
        em.close();

        return c;
    }


}
