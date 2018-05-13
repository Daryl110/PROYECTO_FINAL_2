/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "PERJUDICADOS")
@NamedQueries({
    @NamedQuery(name = "Perjudicados.findAll", query = "SELECT p FROM Perjudicados p")})
@XmlRootElement
public class Perjudicados implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "TIPO_PERJUDICADO")
    private String tipoPerjudicado;
    @Column(name = "CINTURON")
    private Character cinturon;
    @Column(name = "CASCO")
    private Character casco;
    @Size(max = 10)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 10)
    @Column(name = "GRAVEDAD")
    private String gravedad;
    @Size(max = 10)
    @Column(name = "CONDICION")
    private String condicion;
    @JoinColumn(name = "LICENCIA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Licencia licenciaId;
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona personaId;
    @JoinColumn(name = "VEHICULOS_AFECTADOS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private VehiculosAfectados vehiculosAfectadosId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perjudicados")
    private Examen examen;

    public Perjudicados() {
    }

    public Perjudicados(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoPerjudicado() {
        return tipoPerjudicado;
    }

    public void setTipoPerjudicado(String tipoPerjudicado) {
        this.tipoPerjudicado = tipoPerjudicado;
    }

    public Character getCinturon() {
        return cinturon;
    }

    public void setCinturon(Character cinturon) {
        this.cinturon = cinturon;
    }

    public Character getCasco() {
        return casco;
    }

    public void setCasco(Character casco) {
        this.casco = casco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Licencia getLicenciaId() {
        return licenciaId;
    }

    public void setLicenciaId(Licencia licenciaId) {
        this.licenciaId = licenciaId;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

    public VehiculosAfectados getVehiculosAfectadosId() {
        return vehiculosAfectadosId;
    }

    public void setVehiculosAfectadosId(VehiculosAfectados vehiculosAfectadosId) {
        this.vehiculosAfectadosId = vehiculosAfectadosId;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
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
        if (!(object instanceof Perjudicados)) {
            return false;
        }
        Perjudicados other = (Perjudicados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Perjudicados[ id=" + id + " ]";
    }
    
}
