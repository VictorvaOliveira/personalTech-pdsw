/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.models.RemoverAlunoModel;
import com.mycompany.personaltech.models.GettersModel;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "ActionsAluno", urlPatterns = {"/view/ActionsAluno"})
public class ActionsAluno extends HttpServlet {

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
        RemoverAlunoModel ram = new RemoverAlunoModel();
        String user = (String) request.getSession().getAttribute("user");
        String remover = request.getParameter("remover");
        String stats = request.getParameter("stats");
        String avaliar = request.getParameter("avaliar");
        String editar = request.getParameter("editar");
        String visualizar = request.getParameter("visualizar");
        String loginAluno = request.getParameter("loginAluno");
        String medstatus = request.getParameter("medstatus");
        System.out.println("ACTION ON: " + loginAluno);
        GettersModel gm = new GettersModel();
        if (remover != null) {
            boolean result = ram.removeAluno(user, loginAluno);
            request.getRequestDispatcher("welcomep.jsp").forward(request, response);
        } else if (editar != null) {
            Aluno aluno = gm.getAlunoForUpdate(loginAluno);
            if (aluno == null) {
                response.sendRedirect("https://www.youtube.com/watch?v=2LCM4q6KpdQ");
                return;
            }
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String s = formatter.format(aluno.getDataNascimento());
            request.setAttribute("alunoDataNascimento", s);
            request.setAttribute("aluno", aluno);
            request.getRequestDispatcher("updateAluno.jsp").forward(request, response);
        } else if (visualizar != null) {
            Aluno aluno = gm.getAluno(loginAluno);
            request.getSession().setAttribute("aluno", aluno);
            request.setAttribute("aluno", aluno);
            request.getRequestDispatcher("visAluno.jsp").forward(request, response);
        } else if (medstatus != null) {
            Aluno aluno = gm.getAluno(loginAluno);
            request.getSession().setAttribute("aluno", aluno);
            request.setAttribute("aluno", aluno);
            request.getRequestDispatcher("visMedStatus.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
//        if (result) {
//            request.getRequestDispatcher("cadastro.jsp").forward(request, response);

//        } else {
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        }
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
