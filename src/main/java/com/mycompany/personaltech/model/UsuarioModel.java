/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.model;

import com.mycompany.personaltech.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author victor
 */
public class UsuarioModel {

    public void cadastarUsuario(Usuario usuario) {
        try {

            Session session = factory.getCurrentSession();

            Transaction tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Houve um erro na persitência dos dados");
        }
    }
}
