/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
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
    
    public Aluno getAlunoForUpdate(String login) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        
        String jpql = "SELECT a FROM Aluno a WHERE a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, login);
        
        return (Aluno) query.getSingleResult();        
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
}
