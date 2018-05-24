/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.MedStatus;
import com.mycompany.personaltech.models.GettersModel;
import com.mycompany.personaltech.models.StatusMedicoModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "CadastroStatusMedico", urlPatterns = {"/view/CadastroStatusMedico"})
public class CadastroStatusMedico extends HttpServlet {

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
        
        GettersModel gm = new GettersModel();

        Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");

        String diabetes = request.getParameter("diabetes");
        String pressao = request.getParameter("pressao");
        String obsPresArt = request.getParameter("obsPresArt");
        String cardiaco = request.getParameter("cardiaco");
        boolean card = false;
        if (cardiaco.equals("positivo")) {
            card = true;
        }
        String obsProbCard = request.getParameter("obsProbCard");
        String osseo = request.getParameter("osseo");
        boolean osso = false;
        if (osseo.equals("positivo")) {
            osso = true;
        }
        String obsProbOsseo = request.getParameter("obsProbOsseo");

        StatusMedicoModel smm = new StatusMedicoModel();
        MedStatus medStatus = smm.cadastrar(aluno.getId(), diabetes, pressao, obsProbOsseo, card, obsProbCard, osso, obsProbOsseo);

        // Sets Aluno in the session
        aluno = gm.getAluno(aluno.getLogin());
        request.getSession().setAttribute("aluno", aluno);

        /*
        Neste ponto do sistema, o aluno já está salvo na sessão, logo não há necessidade
        de criar um atributo no request ou mesmo um novo atributo na sessão.
        Basta usar o atributo medStatus existente no atributo aluno da sessão
         */
        request.getRequestDispatcher("visMedStatus.jsp").forward(request, response);

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
