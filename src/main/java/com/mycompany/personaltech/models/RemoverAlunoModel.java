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
public class RemoverAlunoModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public boolean removeAluno(String user, String loginAluno) {
        if (user != null) {
            emf = Persistence.createEntityManagerFactory("PTech_PU");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            String jpql = "SELECT p FROM PersonalTrainer p WHERE p.login = ?1";
            Query query = em.createQuery(jpql);
            query.setParameter(1, user);
            PersonalTrainer pt = (PersonalTrainer) query.getSingleResult();
            
            Aluno aluno = null;
            List<Aluno> alunos = pt.getAlunos();
            for (Aluno al : alunos) {
                if (al.getLogin().equals(loginAluno)) {
                    aluno = al;
                    em.remove(aluno);
                    alunos.remove(aluno);
                    break;
                } 
            }

            

            commitAndClose();
            return true;
        }
        return false;
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }

}
