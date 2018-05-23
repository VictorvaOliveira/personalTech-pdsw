/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Endereco;
import com.mycompany.personaltech.models.GettersModel;
import com.mycompany.personaltech.models.UpdateModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/view/UpdateController"})
public class UpdateController extends HttpServlet {

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
        
        String currentLogin = request.getParameter("currentLogin");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String sexo = request.getParameter("sexo");
        String cpf = request.getParameter("cpf");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String dataNascimento = request.getParameter("dataNascimento");
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String complemento = request.getParameter("complemento");
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);
        aluno.setCpf(cpf);
        aluno.setTipo(tipoUsuario);
        aluno.setLogin(login);
        aluno.setSenha(senha);
        aluno.setEmail(email);
        aluno.setSexo(sexo);
        aluno.setDataNascimento(date);

        Endereco end = new Endereco();
        end.setLogradouro(logradouro);
        end.setBairro(bairro);
        end.setNumero(Integer.parseInt(numero));
        end.setCep(cep);
        end.setCidade(cidade);
        end.setEstado(estado);
        end.setComplemento(complemento);
        aluno.setEndereco(end);

        UpdateModel um = new UpdateModel();
        um.updateAluno(aluno, currentLogin);
        
        List<Aluno> alunos = null;
        GettersModel gm = new GettersModel();
        alunos = gm.getAlunos((String) request.getSession().getAttribute("user"));
        request.setAttribute("alunos", alunos);
        
        request.getRequestDispatcher("welcomep.jsp").forward(request, response);

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
