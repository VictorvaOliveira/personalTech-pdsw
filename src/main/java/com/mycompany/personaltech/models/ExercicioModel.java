/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Exercicio;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

    public void editExercicio(long idAluno, Long idEx, String tipoExercicio, String exercicio, int serie, int peso, int repeticao) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        Exercicio ex = em.find(Exercicio.class, idEx);
        ex.setTipo(tipoExercicio);
        ex.setExercicio(exercicio);
        ex.setSerie(serie);
        ex.setRepeticao(repeticao);
        ex.setPeso(peso);

        commitAndClose();
    }

    public void insertExercicio(long idAluno, String tipoExercicio, String exercicio, int numSerie, int numRepeticao, int numPeso) {
        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        Exercicio ex = new Exercicio();
        ex.setTipo(tipoExercicio);
        ex.setExercicio(exercicio);
        ex.setSerie(numSerie);
        ex.setRepeticao(numRepeticao);
        ex.setPeso(numPeso);
        

        Aluno aluno = em.find(Aluno.class, idAluno);
        aluno.addExercicio(ex);
        commitAndClose();
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
}
