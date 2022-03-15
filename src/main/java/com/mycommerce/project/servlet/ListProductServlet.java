package com.mycommerce.project.servlet;

import com.mycommerce.dao.DaoFactory;
import com.mycommerce.dao.base.ProductDao;
import com.mycommerce.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list-product")
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDao = DaoFactory.getProductDao();
        List<Product> productList = productDao.getAllProducts();

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Product List</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1> Products : </h1>");
        pw.println("<ul>");
        productList.forEach(product -> {
            pw.println("<li>" + product.getName() + "-" + product.getPrice() + "</li>");
        });
        pw.println("</ul>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
