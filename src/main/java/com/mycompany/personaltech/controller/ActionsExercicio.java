/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Exercicio;
import com.mycompany.personaltech.models.ExercicioModel;
import com.mycompany.personaltech.models.GettersModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "ActionsExercicio", urlPatterns = {"/view/ActionsExercicio"})
public class ActionsExercicio extends HttpServlet {

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

        String user = (String) request.getSession().getAttribute("user");
        String loginAluno = request.getParameter("loginAluno");
        String idAluno = request.getParameter("idAluno");
        long idAl = Long.parseLong(idAluno);
        System.out.println(loginAluno);
        System.out.println(idAluno);
        String idExercicio = request.getParameter("idExercicio");
        long idEx = Long.parseLong(idExercicio);
        String remover = request.getParameter("remover");
        String editar = request.getParameter("editar");
        GettersModel gm;
        ExercicioModel exm;

        if (remover != null) {
            exm = new ExercicioModel();
            exm.removeExercicio(idEx, idAl);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (editar != null) {
            gm = new GettersModel();
            Aluno aluno = gm.getAlunoForUpdate(loginAluno);
            Exercicio ex = gm.getExercicio(idEx);
            request.setAttribute("aluno", aluno);
            request.setAttribute("ex", ex);
            if (ex != null) {
                request.getRequestDispatcher("updateExercicio.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ActionsExercicio</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<img src=\"https://i.ytimg.com/vi/2LCM4q6KpdQ/hqdefault.jpg\"/>");
                out.println("</body>");
                out.println("</html>");
            }
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
