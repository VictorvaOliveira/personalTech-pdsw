package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.jpa.jpql.Assert.fail;

public class CadastroUsuario extends HttpServlet {

    private static EntityManagerFactory emf;
//    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        
        Aluno aluno = new Aluno();        
        aluno.setNome("joao");
        em.persist(aluno);
        
        commitTransaction();
        em.close();
        emf.close();

}
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

@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }

}
