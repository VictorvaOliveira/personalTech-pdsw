package com.mycompany.personaltech;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile ListAttribute<Aluno, Exercicio> exercicios;
	public static volatile SingularAttribute<Aluno, TipoUsuario> tipo;
	public static volatile SingularAttribute<Aluno, Endereco> endereco;
	public static volatile SingularAttribute<Aluno, String> nome;
	public static volatile SingularAttribute<Aluno, String> login;
	public static volatile CollectionAttribute<Aluno, String> telefones;
	public static volatile SingularAttribute<Aluno, String> senha;
	public static volatile ListAttribute<Aluno, Avaliacao> avaliacoes;
	public static volatile SingularAttribute<Aluno, String> cpf;
	public static volatile SingularAttribute<Aluno, Long> id;
	public static volatile SingularAttribute<Aluno, String> sobrenome;
	public static volatile SingularAttribute<Aluno, String> sexo;
	public static volatile SingularAttribute<Aluno, Date> dataNascimento;
	public static volatile SingularAttribute<Aluno, String> email;

}

