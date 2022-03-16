package com.mycommerce.project.servlet;


import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/basic-insert")
public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        Product p = new Product();
        p.setName("Bouteille d'eau");
        p.setContent("Bouteille 2L, eau minérale naturelle");
        p.setPrice(0.65F);

        ProductDao productDao = DaoFactory.getProductDao();
        productDao.addProduct(p);
    }
}
