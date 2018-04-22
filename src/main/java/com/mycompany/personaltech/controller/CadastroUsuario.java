package com.mycompany.personaltech.controller;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Endereco;
import com.mycompany.personaltech.entities.PersonalTrainer;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
        aluno.setNome("JOAO");
        aluno.setSobrenome("DA SILVA");
        aluno.setCpf("12312312312");
        aluno.setLogin("JOAOABC");
        aluno.setSenha("abc123");
        aluno.setEmail("JOAO@GMAIL");
        aluno.setSexo("M");
        aluno.setDataNascimento(setDataNascimentoAluno(aluno));
        aluno.setEndereco(setEnderecoAluno());
        PersonalTrainer pt = em.find(PersonalTrainer.class, (long) 1);
        pt.setAlunos(aluno);
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

    private Date setDataNascimentoAluno(Aluno aluno) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2000);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 14);
        return c.getTime();
    }

    private Endereco setEnderecoAluno() {
        Endereco end = new Endereco();
        end.setLogradouro("RUA 01");
        end.setBairro("CORDEIRO");
        end.setNumero(123);
        end.setCep("555-432");
        end.setCidade("RECIFE");
        end.setEstado("PERNAMBUCO");
        end.setComplemento("DE ESQUINA");
        return end;
    }

}
