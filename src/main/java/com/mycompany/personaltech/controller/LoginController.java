/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.PersonalTrainer;
import com.mycompany.personaltech.models.LoginPersonalModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
@MultipartConfig
public class LoginController extends HttpServlet {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

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

        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        if (tipo.equals("P")) {
            String jpql = "SELECT p FROM PersonalTrainer p where p.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, login);
            PersonalTrainer pt = null;
            try {
                pt = (PersonalTrainer) query.getSingleResult();
                if (!senha.equals(pt.getSenha())) {
                    response.sendRedirect("view/wronglogin.jsp");
                } else if (senha.equals(pt.getSenha())) {
                    response.sendRedirect("view/welcomep.jsp");
                }
            } catch (NoResultException e) {
                commitAndClose();
                response.sendRedirect("view/wronglogin.jsp");
                return;
            }
            commitAndClose();
            if (pt != null) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginController</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet LoginController at " + pt.getNome() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } else if (tipo.equals("A")) {
            String jpql = "SELECT a FROM Aluno a where a.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, login);
            Aluno aluno = null;
            try {
                aluno = (Aluno) query.getSingleResult();
                if (!senha.equals(aluno.getSenha())) {
                    response.sendRedirect("view/wronglogin.jsp");
                } else if (senha.equals(aluno.getSenha())) {
                    response.sendRedirect("view/welcomea.jsp");
                }
            } catch (NoResultException e) {
                commitAndClose();
                response.sendRedirect("view/wronglogin.jsp");
                return;
            }
            commitAndClose();
            if (aluno != null) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginController</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet LoginController at " + aluno.getNome() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } else {
            response.sendRedirect("view/login.jsp");
        }

//        LoginPersonalModel lpm = new LoginPersonalModel();
//        boolean bool = lpm.verificarLogin(login, senha, tipo);
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
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
