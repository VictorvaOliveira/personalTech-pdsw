/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.models.ExercicioModel;
import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.TipoExercicio;
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
@WebServlet(name = "UpdateExercicio", urlPatterns = {"/view/UpdateExercicio"})
public class UpdateExercicio extends HttpServlet {

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

        Long idEx = Long.parseLong(request.getParameter("idEx"));
        String exercicio = request.getParameter("exercicio");
        String serie = request.getParameter("serie");
        String peso = request.getParameter("peso");
        String repeticao = request.getParameter("repeticao");
        
        int numPeso = Integer.parseInt(peso);
        int numSerie = Integer.parseInt(serie);
        int numRepeticao = Integer.parseInt(repeticao);
        

        String tipoExercicio = exercicio.substring(0, exercicio.indexOf("_"));

        if (tipoExercicio.equals("ABD")) {
            tipoExercicio = TipoExercicio.ABDOMINAIS.toString();
        } else if (tipoExercicio.equals("BICEPS")) {
            tipoExercicio = TipoExercicio.BICEPS.toString();
        } else if (tipoExercicio.equals("COXAS")) {
            tipoExercicio = TipoExercicio.COXAS.toString();
        } else if (tipoExercicio.equals("DORS")) {
            tipoExercicio = TipoExercicio.DORSAIS.toString();
        } else if (tipoExercicio.equals("OMBRO")) {
            tipoExercicio = TipoExercicio.OMBRO.toString();
        } else if (tipoExercicio.equals("PEIT")) {
            tipoExercicio = TipoExercicio.PEITORAL.toString();
        } else if (tipoExercicio.equals("PERNAS")) {
            tipoExercicio = TipoExercicio.PERNAS.toString();
        } else if (tipoExercicio.equals("TRICEPS")) {
            tipoExercicio = TipoExercicio.TRICEPS.toString();
        }

        Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
        long idAluno = aluno.getId();

        ExercicioModel exm = new ExercicioModel();
        exm.editExercicio(idAluno,idEx,tipoExercicio,exercicio, numSerie, numPeso, numRepeticao);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateExercicio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateExercicio at " + request.getContextPath() + "</h1>");
            out.println(idAluno);
            out.println(idEx);
            out.println(exercicio);
            out.println(serie);
            out.println(peso);
            out.println(repeticao);
            out.println("</body>");
            out.println("</html>");
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
