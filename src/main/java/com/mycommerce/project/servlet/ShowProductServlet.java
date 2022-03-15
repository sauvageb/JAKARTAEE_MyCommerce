package com.mycommerce.project.servlet;

import com.mycommerce.dao.DaoFactory;
import com.mycommerce.dao.base.ProductDao;
import com.mycommerce.dao.exception.UnknownProductException;
import com.mycommerce.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product-details")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Product Details</title>");
        pw.println("</head>");
        pw.println("<body>");
        try {
            Long id = Long.parseLong(idStr);
            ProductDao productDao = DaoFactory.getProductDao();
            Product product = productDao.findProductById(id);

            pw.println("<h1>Product Details :</h1>");
            pw.println("<ul>");
            pw.println("<li>" + product.getName() + "</li>");
            pw.println("<li>" + product.getContent() + "</li>");
            pw.println("<li>" + product.getPrice() + "</li>");
            pw.println("</ul>");
        } catch (NumberFormatException e) {
            pw.println("<h1> Product Details : </h1>");
            pw.println("<p>product id must be an integer</p>");
        } catch (UnknownProductException e) {
            pw.println("<h1> Product Details : </h1>");
            pw.println("<p>product with id " + idStr + " does not exist </p>");
        } finally {
            pw.println("</body>");
            pw.println("</html>");
        }
    }
}
