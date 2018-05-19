/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.models.GettersModel;
import com.mycompany.personaltech.models.LoginPersonalModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author john
 */
@WebServlet(name = "LoginController", urlPatterns = {"/view/LoginController"})
@MultipartConfig
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String tipo = request.getParameter("tipoUsuarioLogin");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        List<Aluno> alunos = null;

        LoginPersonalModel lpm = new LoginPersonalModel();
        boolean result = lpm.log(login, senha, tipo);
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            session.setAttribute("logged", true);
            session.setAttribute("tipo", tipo);

            String sId = session.getId();
            System.out.println("ID SESSÃO: " + sId);
            if (tipo.equals("P")) {
                GettersModel gm = new GettersModel();
                alunos = gm.getAlunos(login);
                request.setAttribute("alunos", alunos);
                request.getRequestDispatcher("welcomep.jsp").forward(request, response);
            } else if (tipo.equals("A")) {
                response.sendRedirect("welcomea.jsp");
            }
        } else {
            response.sendRedirect("wronglogin.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
