package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.entity.Product;
import com.mycommerce.project.dao.exception.UnknownProductException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(ShowProductServlet.URL)
public class ShowProductServlet extends HttpServlet {

    public static final String URL = "/product-details";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            Long id = Long.parseLong(idStr);
            ProductDao productDao = DaoFactory.getProductDao();
            Product product = productDao.findById(id);

            req.setAttribute("product", product);

        } catch (NumberFormatException e) {
            req.setAttribute("ERROR_TYPE_ID_PRODUCT", true);
        } catch (UnknownProductException e) {
            req.setAttribute("ERROR_UNKNOWN_PRODUCT", true);
        } finally {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/showProduct.jsp");
            rd.forward(req, resp);
        }
    }
}
