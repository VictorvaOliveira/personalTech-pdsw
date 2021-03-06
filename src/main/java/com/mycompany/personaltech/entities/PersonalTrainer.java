/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author john
 */
@Entity
@Table(name = "TB_PERSONAL")
public class PersonalTrainer implements Serializable {

//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TXT_NOME", length = 255, nullable = false)
    private String nome;
    
    @Column(name = "TXT_SOBRENOME", length = 255, nullable = false)
    private String sobrenome;
    
    @Column(name = "TXT_CPF", length = 14, unique = true, nullable = false)
    private String cpf;
    
    @Column(name = "TXT_LOGIN", length = 50, unique = true, nullable = false)
    private String login;
    
    @Column(name = "TXT_SENHA", length = 20, nullable = false)
    private String senha;
    
    @Column(name = "TXT_EMAIL", length = 50, nullable = false)
    private String email;
    
    @Column(name = "TXT_SEXO", length = 1, nullable = false)
    private String sexo;
    
    @Column(name = "TXT_TIPO_USER", length = 1, nullable = false)
    private String tipo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_NASCIMENTO", nullable = true)
    private Date dataNascimento;

    @Embedded
    private Endereco endereco;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = false)
    @JoinColumn(name = "ID_PT",referencedColumnName = "ID")
    private List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    
    public void addAluno(Aluno aluno) {
        if (this.alunos == null) {
            this.alunos = new ArrayList<>();
        }
        this.alunos.add(aluno);
    }
    
    public void removeAluno(Aluno aluno) {
        if (this.alunos == null) {
            return;
        }
        this.alunos.remove(aluno);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalTrainer)) {
            return false;
        }
        PersonalTrainer other = (PersonalTrainer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.persoanaltech.entities.PersonalTrainer[ id=" + id + " ]";
    }

}
