package com.mycommerce.project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public final static String URL = "/login";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        if (username != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", username);
            req.getRequestDispatcher("/list-product").forward(req, resp);
        } else {
            //TODO
        }

    }
}
