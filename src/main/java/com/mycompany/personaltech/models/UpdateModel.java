/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.models;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Endereco;
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
public class UpdateModel {

    private static EntityManagerFactory emf;
    private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;

    public void updateAluno(Aluno aluno, String currentLogin) {

        emf = Persistence.createEntityManagerFactory("PTech_PU");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();

        String jpql = "SELECT a FROM Aluno a WHERE a.login = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, currentLogin);
        Aluno al = (Aluno) query.getSingleResult();
        al.setNome(aluno.getNome());
        al.setSobrenome(aluno.getSobrenome());
        al.setCpf(aluno.getCpf());
        al.setTipo(aluno.getTipo());
        al.setLogin(aluno.getLogin());
        al.setSenha(aluno.getSenha());
        al.setEmail(aluno.getEmail());
        al.setSexo(aluno.getSexo());
        al.setDataNascimento(aluno.getDataNascimento());
        Endereco end = new Endereco();
        end.setLogradouro(aluno.getEndereco().getLogradouro());
        end.setBairro(aluno.getEndereco().getBairro());
        end.setNumero(aluno.getEndereco().getNumero());
        end.setCep(aluno.getEndereco().getCep());
        end.setCidade(aluno.getEndereco().getCidade());
        end.setEstado(aluno.getEndereco().getEstado());
        end.setComplemento(aluno.getEndereco().getComplemento());
        al.setEndereco(end);
        
        em.persist(al);

        commitAndClose();
        
    }

    void commitAndClose() {
        et.commit();
        em.close();
        emf.close();
    }
}
