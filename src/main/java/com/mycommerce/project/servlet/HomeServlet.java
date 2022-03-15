package com.mycommerce.project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Home</h1>");
        out.println("<a href=\"/list-product\">List product</a>");
        out.println("<a href=\"/login\">Login</a>");
        out.println("<a href=\"/auth/basic-insert\">Add product</a>");
        out.println("</body></html>");
    }
}
