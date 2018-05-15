/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "HISTORIAL_DUENO")
@NamedQueries({
    @NamedQuery(name = "HistorialDueno.findAll", query = "SELECT h FROM HistorialDueno h")
    , @NamedQuery(name = "HistorialDueno.findById", query = "SELECT h FROM HistorialDueno h WHERE h.id = :id")
    , @NamedQuery(name = "HistorialDueno.findByFecha", query = "SELECT h FROM HistorialDueno h WHERE h.fecha = :fecha")})
@XmlRootElement
public class HistorialDueno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "PERSONA_NIP", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona personaNip;
    @JoinColumn(name = "VEHICULO_PLACA", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoPlaca;

    public HistorialDueno() {
    }

    public HistorialDueno(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getPersonaNip() {
        return personaNip;
    }

    public void setPersonaNip(Persona personaNip) {
        this.personaNip = personaNip;
    }

    public Vehiculo getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(Vehiculo vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
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
        if (!(object instanceof HistorialDueno)) {
            return false;
        }
        HistorialDueno other = (HistorialDueno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.HistorialDueno[ id=" + id + " ]";
    }
    
}
