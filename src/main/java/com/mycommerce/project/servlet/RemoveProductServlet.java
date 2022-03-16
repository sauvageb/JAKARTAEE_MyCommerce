package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("productId");
        try {
            Long id = Long.parseLong(idStr);
            ProductDao dao = DaoFactory.getProductDao();
            dao.removeProduct(id);

            resp.sendRedirect(ListProductServlet.URL);

        } catch (NumberFormatException e) {
            //TODO
        }
    }
}
