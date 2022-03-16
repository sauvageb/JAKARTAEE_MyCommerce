package com.mycommerce.project.servlet;

import com.mycommerce.project.dao.entity.Product;
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

@WebServlet(AddProductServlet.URL)
public class AddProductServlet extends HttpServlet {

    public static final String URL = "/auth/add-product";

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        this.emf = Persistence.createEntityManagerFactory("ecommerce-pu");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("pName");
        String productContent = req.getParameter("pContent");
        String productPriceStr = req.getParameter("pPrice");

        try {
            float productPrice = Float.parseFloat(productPriceStr);

            Product newProduct = new Product(productName, productContent, productPrice);
//            ProductDao productDao = DaoFactory.getProductDao();
//            Long id = productDao.add(newProduct);

            EntityManager em = this.emf.createEntityManager();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.persist(newProduct);

                // Required for getting id in product object (for the sendRedirect method)
                em.flush();

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

            resp.sendRedirect(ShowProductServlet.URL + "?id=" + newProduct.getId());
//            resp.sendRedirect(ShowProductServlet.URL + "?id=" + id);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
