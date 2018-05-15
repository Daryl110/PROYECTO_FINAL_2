/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "LICENCIA")
@NamedQueries({
    @NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l")
    , @NamedQuery(name = "Licencia.findByPersona", query = "SELECT l FROM Licencia l WHERE l.persona = :persona")
    , @NamedQuery(name = "Licencia.findByNumeroLicencia", query = "SELECT l FROM Licencia l WHERE l.numeroLicencia = :numeroLicencia")
    , @NamedQuery(name = "Licencia.findByFechaExpedicion", query = "SELECT l FROM Licencia l WHERE l.fechaExpedicion = :fechaExpedicion")
    , @NamedQuery(name = "Licencia.findByFechaVencimiento", query = "SELECT l FROM Licencia l WHERE l.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Licencia.findByOficinaTransito", query = "SELECT l FROM Licencia l WHERE l.oficinaTransito = :oficinaTransito")
    , @NamedQuery(name = "Licencia.findByCategoriaLicencia", query = "SELECT l FROM Licencia l WHERE l.categoriaLicencia = :categoriaLicencia")})
@XmlRootElement
public class Licencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PERSONA")
    private String persona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_LICENCIA")
    private String numeroLicencia;
    @Column(name = "FECHA_EXPEDICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicion;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Size(max = 20)
    @Column(name = "OFICINA_TRANSITO")
    private String oficinaTransito;
    @Size(max = 10)
    @Column(name = "CATEGORIA_LICENCIA")
    private String categoriaLicencia;
    @JoinColumn(name = "PERSONA", referencedColumnName = "NIP", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona1;

    public Licencia() {
    }

    public Licencia(String persona) {
        this.persona = persona;
    }

    public Licencia(String persona, String numeroLicencia) {
        this.persona = persona;
        this.numeroLicencia = numeroLicencia;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getOficinaTransito() {
        return oficinaTransito;
    }

    public void setOficinaTransito(String oficinaTransito) {
        this.oficinaTransito = oficinaTransito;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persona != null ? persona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.persona == null && other.persona != null) || (this.persona != null && !this.persona.equals(other.persona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Licencia[ persona=" + persona + " ]";
    }
    
}
