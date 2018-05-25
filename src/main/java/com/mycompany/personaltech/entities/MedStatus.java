/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltech.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author john
 */
@Entity
@Table(name = "TB_MEDSTATUS")
public class MedStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TXT_DIABETES", length = 10, nullable = false)
    private String diabetes;

    @Column(name = "TXT_PROBPRESSAOART", length = 100, nullable = false)
    private String probPressaoAterial;

    @Column(name = "TXT_OBSPRESSAOART", length = 100, nullable = true)
    private String obsProbPressaoAterial;

    @Column(name = "BOOL_PROBCARDIACO", nullable = false)
    private Boolean probCardiaco;

    @Column(name = "TXT_OBSPROBCARDIACO", length = 100, nullable = true)
    private String obsProbCardiaco;

    @Column(name = "BOOL_PROBOSSEO", nullable = false)
    private Boolean probOsseo;

    @Column(name = "TXT_OBSPROBOSSEO", length = 100, nullable = true)
    private String obsprobOsseo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getProbPressaoAterial() {
        return probPressaoAterial;
    }

    public void setProbPressaoAterial(String probPressaoAterial) {
        this.probPressaoAterial = probPressaoAterial;
    }

    public String getObsProbPressaoAterial() {
        return obsProbPressaoAterial;
    }

    public void setObsProbPressaoAterial(String obsProbPressaoAterial) {
        this.obsProbPressaoAterial = obsProbPressaoAterial;
    }

    public Boolean getProbCardiaco() {
        return probCardiaco;
    }

    public void setProbCardiaco(Boolean probCardiaco) {
        this.probCardiaco = probCardiaco;
    }

    public String getObsProbCardiaco() {
        return obsProbCardiaco;
    }

    public void setObsProbCardiaco(String obsProbCardiaco) {
        this.obsProbCardiaco = obsProbCardiaco;
    }

    public Boolean getProbOsseo() {
        return probOsseo;
    }

    public void setProbOsseo(Boolean probOsseo) {
        this.probOsseo = probOsseo;
    }

    public String getObsprobOsseo() {
        return obsprobOsseo;
    }

    public void setObsprobOsseo(String obsprobOsseo) {
        this.obsprobOsseo = obsprobOsseo;
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
        if (!(object instanceof MedStatus)) {
            return false;
        }
        MedStatus other = (MedStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personaltech.entities.MedStatus[ id=" + id + " ]";
    }

}
