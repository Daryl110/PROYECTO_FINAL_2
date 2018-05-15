/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "TESTIGOS")
@NamedQueries({
    @NamedQuery(name = "Testigos.findAll", query = "SELECT t FROM Testigos t")
    , @NamedQuery(name = "Testigos.findById", query = "SELECT t FROM Testigos t WHERE t.id = :id")
    , @NamedQuery(name = "Testigos.findByTestimonio", query = "SELECT t FROM Testigos t WHERE t.testimonio = :testimonio")})
@XmlRootElement
public class Testigos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "TESTIMONIO")
    private String testimonio;
    @JoinColumn(name = "INFORME_ACCIDENTE_TRANSITO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private InformeAccidenteTransito informeAccidenteTransitoId;
    @JoinColumn(name = "PERSONA_NIP", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona personaNip;

    public Testigos() {
    }

    public Testigos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTestimonio() {
        return testimonio;
    }

    public void setTestimonio(String testimonio) {
        this.testimonio = testimonio;
    }

    public InformeAccidenteTransito getInformeAccidenteTransitoId() {
        return informeAccidenteTransitoId;
    }

    public void setInformeAccidenteTransitoId(InformeAccidenteTransito informeAccidenteTransitoId) {
        this.informeAccidenteTransitoId = informeAccidenteTransitoId;
    }

    public Persona getPersonaNip() {
        return personaNip;
    }

    public void setPersonaNip(Persona personaNip) {
        this.personaNip = personaNip;
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
        if (!(object instanceof Testigos)) {
            return false;
        }
        Testigos other = (Testigos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Testigos[ id=" + id + " ]";
    }
    
}
