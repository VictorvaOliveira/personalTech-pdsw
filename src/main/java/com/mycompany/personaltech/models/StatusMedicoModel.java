/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.MedStatus;
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
public class StatusMedicoModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public MedStatus cadastrar(long idAluno, String diabetes, String pressao, String obsProbPressao, boolean cardiaco, String obsProbCardiado, boolean osseo, String obsProbOsseo) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT a FROM Aluno a WHERE a.id = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, idAluno);
        Aluno aluno = (Aluno) query.getSingleResult();

        MedStatus medStatus = new MedStatus();
        medStatus.setDiabetes(diabetes);
        medStatus.setProbPressaoAterial(pressao);
        medStatus.setObsProbPressaoAterial(obsProbPressao);
        medStatus.setProbCardiaco(cardiaco);
        medStatus.setObsProbCardiaco(obsProbCardiado);
        medStatus.setProbOsseo(osseo);
        medStatus.setObsprobOsseo(obsProbOsseo);
        
        aluno.setMedStatus(medStatus);        

        commitAndClose();
        
        return medStatus;
    }
    
    
    // Not being used now
    public MedStatus getStatusMed(long idStatusMed) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        
        String jpql = "SELECT m FROM MedStatus m WHERE m.id = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, idStatusMed);
        MedStatus medStatus = (MedStatus) query.getSingleResult();
        
        commitAndClose();
        
        return medStatus;
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }

}
