/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.PersonalTrainer;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author john
 */
public class LoginPersonalModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public synchronized boolean log(String login, String senha, String tipo) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        if (tipo.equals("P")) {
            String jpql = "SELECT p FROM PersonalTrainer p where p.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, login);
            PersonalTrainer pt = null;
            try {
                pt = (PersonalTrainer) query.getSingleResult();
                if (!senha.equals(pt.getSenha())) {
                    return false;
                } else if (senha.equals(pt.getSenha())) {
                    return true;
                }
            } catch (NoResultException e) {
                commitAndClose();
                return false;
            }
            commitAndClose();
            if (pt == null) {
                return false;
            }
        } else if (tipo.equals("A")) {
            String jpql = "SELECT a FROM Aluno a where a.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, login);
            Aluno aluno = null;
            try {
                aluno = (Aluno) query.getSingleResult();
                if (!senha.equals(aluno.getSenha())) {
                    return false;
                } else if (senha.equals(aluno.getSenha())) {
                    return true;
                }
            } catch (NoResultException e) {
                commitAndClose();
                return false;
            }
            commitAndClose();
            if (aluno != null) {
                return false;
            }
        }
        return false;
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
}
