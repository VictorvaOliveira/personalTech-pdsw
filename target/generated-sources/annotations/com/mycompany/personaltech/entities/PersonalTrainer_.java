package com.mycompany.personaltech.entities;

import com.mycompany.personaltech.entities.Aluno;
import com.mycompany.personaltech.entities.Endereco;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-17T11:43:53")
@StaticMetamodel(PersonalTrainer.class)
public class PersonalTrainer_ { 

    public static volatile SingularAttribute<PersonalTrainer, String> senha;
    public static volatile SingularAttribute<PersonalTrainer, String> tipo;
    public static volatile SingularAttribute<PersonalTrainer, Endereco> endereco;
    public static volatile ListAttribute<PersonalTrainer, Aluno> alunos;
    public static volatile SingularAttribute<PersonalTrainer, String> cpf;
    public static volatile SingularAttribute<PersonalTrainer, String> nome;
    public static volatile SingularAttribute<PersonalTrainer, Long> id;
    public static volatile SingularAttribute<PersonalTrainer, String> sobrenome;
    public static volatile SingularAttribute<PersonalTrainer, String> login;
    public static volatile SingularAttribute<PersonalTrainer, String> sexo;
    public static volatile SingularAttribute<PersonalTrainer, Date> dataNascimento;
    public static volatile SingularAttribute<PersonalTrainer, String> email;

}