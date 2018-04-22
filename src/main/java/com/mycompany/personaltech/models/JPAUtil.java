/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author john
 */
public class JPAUtil {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public JPAUtil() {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
    }
}
