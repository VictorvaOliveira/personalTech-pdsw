/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Endereco;
import com.mycompany.personaltech.entities.PersonalTrainer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.jpa.jpql.Assert.fail;

/**
 *
 * @author john
 */
@WebServlet(name = "CadastroUser", urlPatterns = {"/CadastroUser"})
public class CadastroUser extends HttpServlet {

    private static EntityManagerFactory emf;
//    private static Logger logger;
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

        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String tipo = request.getParameter("tipoUsuario");

        if (tipo.equals("P")) {
            PersonalTrainer pt = new PersonalTrainer();
            pt = preencherPersonal(pt, request);
            em.persist(pt);

            commitTransaction();
            em.close();
            emf.close();
        } else if (tipo.equals("A")) {
            Aluno aluno = new Aluno();
            String loginPersonal = request.getParameter("loginPersonal");

            String jpql = "SELECT p FROM PersonalTrainer p where p.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, loginPersonal);
            PersonalTrainer pt = null;
            try {
                pt = (PersonalTrainer) query.getSingleResult();
            } catch (NoResultException e) {
                response.sendRedirect("view/cadastro.jsp");
                if (pt == null) {
                    return;
                }
            }
            aluno = preencherAluno(aluno, request);
            pt.addAluno(aluno);
            em.persist(aluno);

            commitTransaction();
            em.close();
            emf.close();
        }
       response.sendRedirect("view/index.jsp"); 
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

    private void commitTransaction() {
        try {
            et.commit();
        } catch (Exception ex) {
//            logger.log(Level.SEVERE, ex.getMessage(), ex);
            if (et.isActive()) {
                et.rollback();
            }
            fail(ex.getMessage());
        }
    }

    private Aluno preencherAluno(Aluno aluno, HttpServletRequest request) {
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
        {
            end.setLogradouro(logradouro);
            end.setBairro(bairro);
            end.setNumero(Integer.parseInt(numero));
            end.setCep(cep);
            end.setCidade(cidade);
            end.setEstado(estado);
            end.setComplemento(complemento);
        }

        aluno.setEndereco(end);
        return aluno;
    }

    private PersonalTrainer preencherPersonal(PersonalTrainer personal, HttpServletRequest request) {
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

        personal.setNome(nome);
        personal.setSobrenome(sobrenome);
        personal.setCpf(cpf);
        personal.setTipo(tipoUsuario);
        personal.setLogin(login);
        personal.setSenha(senha);
        personal.setEmail(email);
        personal.setSexo(sexo);
        personal.setDataNascimento(date);

        Endereco end = new Endereco();
        {
            end.setLogradouro(logradouro);
            end.setBairro(bairro);
            end.setNumero(Integer.parseInt(numero));
            end.setCep(cep);
            end.setCidade(cidade);
            end.setEstado(estado);
            end.setComplemento(complemento);
        }

        personal.setEndereco(end);
        return personal;
    }
}
