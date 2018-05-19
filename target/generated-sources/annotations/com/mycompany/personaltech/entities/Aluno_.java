package com.mycompany.personaltech.entities;

import com.mycompany.personaltech.entities.Avaliacao;
import com.mycompany.personaltech.entities.Endereco;
import com.mycompany.personaltech.entities.Exercicio;
import com.mycompany.personaltech.entities.MedStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-18T23:29:49")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile ListAttribute<Aluno, Exercicio> exercicios;
    public static volatile SingularAttribute<Aluno, String> tipo;
    public static volatile SingularAttribute<Aluno, Endereco> endereco;
    public static volatile SingularAttribute<Aluno, MedStatus> medStatus;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, String> login;
    public static volatile SingularAttribute<Aluno, String> senha;
    public static volatile ListAttribute<Aluno, Avaliacao> avaliacoes;
    public static volatile SingularAttribute<Aluno, String> cpf;
    public static volatile SingularAttribute<Aluno, Long> id;
    public static volatile SingularAttribute<Aluno, String> sobrenome;
    public static volatile SingularAttribute<Aluno, String> sexo;
    public static volatile SingularAttribute<Aluno, Date> dataNascimento;
    public static volatile SingularAttribute<Aluno, String> email;

}