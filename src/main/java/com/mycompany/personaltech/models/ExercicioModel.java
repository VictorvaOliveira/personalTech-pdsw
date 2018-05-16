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
public class ExercicioModel {
    
    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public void removeExercicio(Long idExercicio, Long idAluno) {
            emf = Persistence.createEntityManagerFactory("PTech_PU");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            
            Aluno aluno = em.find(Aluno.class, idAluno);
            Exercicio exercicio = em.find(Exercicio.class, idExercicio);
            aluno.getExercicios().remove(exercicio);
            commitAndClose();
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
    
}
