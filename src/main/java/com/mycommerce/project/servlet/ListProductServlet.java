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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(ListProductServlet.URL)
public class ListProductServlet extends HttpServlet {

    public final static String URL = "/list-product";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching all products
        ProductDao productDao = DaoFactory.getProductDao();
        List<Product> productList = productDao.getAllProducts();

        // Passing data in view
        req.setAttribute("productList", productList);

        // Forwarding/Displaying listProduct JSP
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);

//        PrintWriter pw = resp.getWriter();
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("<html>");
//        printWriter.println("<head>");
//        printWriter.println("<title>Product List</title>");
//        printWriter.println("</head>");
//        printWriter.println("<body>");
//        printWriter.println("<h1> Products : </h1>");
//        pw.println("<ul>");
//        productList.forEach(product -> {
//            pw.println("<li>" + product.getName() + "-" + product.getPrice() + "</li>");
//        });
//        pw.println("</ul>");
//        printWriter.println("</body>");
//        printWriter.println("</html>");
    }
}
