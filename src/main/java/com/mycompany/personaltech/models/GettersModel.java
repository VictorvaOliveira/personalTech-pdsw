/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Exercicio;
import com.mycompany.personaltech.entities.PersonalTrainer;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author john
 */
public class GettersModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public List<Aluno> getAlunos(String loginPt) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT p FROM PersonalTrainer p WHERE p.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, loginPt);

        PersonalTrainer pt = (PersonalTrainer) query.getSingleResult();
        List<Aluno> listaDeAlunos = pt.getAlunos();
        commitAndClose();
        return listaDeAlunos;

    }

    public Aluno getAluno(String login) {
        return getAlunoForUpdate(login);
    }

    public Aluno getAlunoForUpdate(String login) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT a FROM Aluno a WHERE a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, login);
        Aluno aluno = (Aluno) query.getSingleResult();
        if (aluno != null) {
            return aluno;
        }
        return null;
    }

    public Exercicio getExercicio(long idEx) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        Exercicio ex = em.find(Exercicio.class, (idEx));
        if (ex != null) {
            return ex;
        }
        return null;
    }

    public List<Exercicio> getExercicioPorAluno(String loginAluno) {

        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT a FROM Aluno a WHERE a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, loginAluno);

        Aluno aluno = (Aluno) query.getResultList();
        List<Exercicio> listaDeExercicio = aluno.getExercicios();
        commitAndClose();
        return listaDeExercicio;
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }

}
