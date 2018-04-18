/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entity.Aluno;
import com.mycompany.personaltech.entity.Endereco;
import com.mycompany.personaltech.entity.PersonalTrainer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.personaltech.entity.Usuario;
import com.mycompany.personaltech.model.UsuarioModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class CadastroUsuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String sexo = request.getParameter("sexo");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String tipoUsuario = request.getParameter("tipoUsuario");
            //Convertendo data para tipo date
            String dataNascimento = request.getParameter("dataNascimento");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date dataInfo = df.parse(dataNascimento);
            //Recuperando dados do endereço
            String numero = request.getParameter("numero");
            Integer numeroInt = Integer.parseInt(numero);
            String logradouro = request.getParameter("logradouro");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String complemento = request.getParameter("complemento");
            String cep = request.getParameter("cep");
            String estado = request.getParameter("estado");
            
            Usuario usuario = null;
            if (tipoUsuario.equals("P")) {
                usuario = new PersonalTrainer();
            } else if (tipoUsuario.equals("A")) {
                usuario = new Aluno();
            }

            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuario.setCpf(cpf);
            usuario.setDataNascimento(dataInfo);
            usuario.setEmail(email);
            usuario.setLogin(login);
            usuario.setSenha(senha);

            Endereco end = new Endereco();
            end.setBairro(bairro);
            end.setCep(cep);
            end.setCidade(cidade);
            end.setEstado(estado);
            end.setLogradouro(logradouro);
            end.setNumero(numeroInt);
            if (complemento != null) {
                end.setComplemento(nome);
            }

            usuario.setEndereco(end);
            
            UsuarioModel UserM = new UsuarioModel();
            UserM.cadastarUsuario(usuario);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
