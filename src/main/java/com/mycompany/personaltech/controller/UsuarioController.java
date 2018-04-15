package com.mycompany.personaltech.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (PrintWriter out = response.getWriter()) {
            if (email.equals("victor@gmail.com") && password.equals("123")) {

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet NewServlet at " + email + " - " + password + "</h1>");
                out.println("</body>");
                out.println("</html>");

                response.sendRedirect("view/index.jsp");

            } else {
                response.sendRedirect("view/login.jsp");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
