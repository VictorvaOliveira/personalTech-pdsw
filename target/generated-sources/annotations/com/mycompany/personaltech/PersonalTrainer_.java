package com.mycompany.personaltech;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonalTrainer.class)
public abstract class PersonalTrainer_ {

	public static volatile SingularAttribute<PersonalTrainer, TipoUsuario> tipo;
	public static volatile SingularAttribute<PersonalTrainer, Endereco> endereco;
	public static volatile ListAttribute<PersonalTrainer, Aluno> alunos;
	public static volatile SingularAttribute<PersonalTrainer, String> nome;
	public static volatile SingularAttribute<PersonalTrainer, String> login;
	public static volatile CollectionAttribute<PersonalTrainer, String> telefones;
	public static volatile SingularAttribute<PersonalTrainer, String> senha;
	public static volatile ListAttribute<PersonalTrainer, Avaliacao> avaliacoes;
	public static volatile SingularAttribute<PersonalTrainer, String> cpf;
	public static volatile SingularAttribute<PersonalTrainer, Long> id;
	public static volatile SingularAttribute<PersonalTrainer, String> sobrenome;
	public static volatile SingularAttribute<PersonalTrainer, String> sexo;
	public static volatile SingularAttribute<PersonalTrainer, Date> dataNascimento;
	public static volatile SingularAttribute<PersonalTrainer, String> email;

}

