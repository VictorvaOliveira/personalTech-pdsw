/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author john
 */
@Entity
@Table(name = "TB_AVALIACAO")
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUM_PESO", length = 10, nullable = false)
    private Double peso;

    @Column(name = "NUM_ALTURA", length = 10, nullable = false)
    private Double altura;

    @Column(name = "TXT_PRESSAOART", length = 10, nullable = false)
    private String pressaoArtAtual;

    @Column(name = "TXT_OBS", length = 100, nullable = true)
    private String obs;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_AVALIACAO", nullable = false)
    private Date dataAvaliacao;

    public Avaliacao() {
        
    }

    public Avaliacao(double peso, double altura, String pressao, String obspressao, Date date) {
        this.peso = peso;
        this.altura = altura;
        this.pressaoArtAtual = pressao;
        this.obs = obspressao;
        this.dataAvaliacao = date;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getPressaoArtAtual() {
        return pressaoArtAtual;
    }

    public void setPressaoArtAtual(String pressaoArtAtual) {
        this.pressaoArtAtual = pressaoArtAtual;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personaltech.entities.Avaliacao[ id=" + id + " ]";
    }

}
