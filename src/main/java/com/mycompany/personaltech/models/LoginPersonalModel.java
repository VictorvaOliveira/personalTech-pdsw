/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.PersonalTrainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author john
 */
public class LoginPersonalModel {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public boolean verificarLogin(String login, String senha, String tipoUsuarioLogin) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT p FROM PersonalTrainer p where p.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "CB");

        PersonalTrainer pt = (PersonalTrainer) query.getSingleResult();
        em.close();
        emf.close();

        if (senha.equals(pt.getSenha())) {
            return true;
        }
        return false;
    }
}
