package com.mycommerce.project.servlet;

import com.mycommerce.dao.DaoFactory;
import com.mycommerce.dao.base.ProductDao;
import com.mycommerce.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/add-product")
public class AddProductServlet extends HttpServlet {

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
            ProductDao productDao = DaoFactory.getProductDao();
            Long id = productDao.addProduct(newProduct);
            resp.sendRedirect(ShowProductServlet.URL + "?id=" + id);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
