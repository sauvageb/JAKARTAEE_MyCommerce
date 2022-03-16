package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/add-category")
public class AddCategoryServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        this.emf = Persistence.createEntityManagerFactory("ecommerce-pu");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("cName");

        Category newCategory = new Category(categoryName);
        EntityManager em = this.emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(newCategory);
            et.commit();
        } catch (Exception e) {
            System.out.println(e);
            //TODO
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
        resp.sendRedirect(AddProductServlet.URL);
    }

}
