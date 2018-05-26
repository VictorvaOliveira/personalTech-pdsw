/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Avaliacao;
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
public class AvaliacaoModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;
    
    public void cadastrarAvaliacao(String loginAluno, Avaliacao avaliacao) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        
        String jpql = "SELECT a FROM Aluno a WHERE a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, loginAluno);
        Aluno aluno = (Aluno) query.getSingleResult();
        aluno.addAvaliacao(avaliacao);
        
        // teste
        System.out.println("\nTESTE: " + aluno.getNome()+"\n");
        List<Avaliacao> avaliacoes = aluno.getAvaliacoes();
        System.out.println("AVALIACOES:");
        for (Avaliacao av : avaliacoes) {
            System.out.println(av.getPeso());
        }
        System.out.println();
        //end teste
        
        commitAndClose();
    }
    
    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
    
}
