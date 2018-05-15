/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "DETALLE_COMPARENDO")
@NamedQueries({
    @NamedQuery(name = "DetalleComparendo.findAll", query = "SELECT d FROM DetalleComparendo d")
    , @NamedQuery(name = "DetalleComparendo.findById", query = "SELECT d FROM DetalleComparendo d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleComparendo.findByAceptacionCompatrendo", query = "SELECT d FROM DetalleComparendo d WHERE d.aceptacionCompatrendo = :aceptacionCompatrendo")
    , @NamedQuery(name = "DetalleComparendo.findByFechaAsistencia", query = "SELECT d FROM DetalleComparendo d WHERE d.fechaAsistencia = :fechaAsistencia")})
@XmlRootElement
public class DetalleComparendo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACEPTACION_COMPATRENDO")
    private BigInteger aceptacionCompatrendo;
    @Column(name = "FECHA_ASISTENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsistencia;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detalleComparendo")
    private PagoComparendo pagoComparendo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detalleComparendo")
    private Asistencia asistencia;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Comparendo comparendo;

    public DetalleComparendo() {
    }

    public DetalleComparendo(BigDecimal id) {
        this.id = id;
    }

    public DetalleComparendo(BigDecimal id, BigInteger aceptacionCompatrendo) {
        this.id = id;
        this.aceptacionCompatrendo = aceptacionCompatrendo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getAceptacionCompatrendo() {
        return aceptacionCompatrendo;
    }

    public void setAceptacionCompatrendo(BigInteger aceptacionCompatrendo) {
        this.aceptacionCompatrendo = aceptacionCompatrendo;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public PagoComparendo getPagoComparendo() {
        return pagoComparendo;
    }

    public void setPagoComparendo(PagoComparendo pagoComparendo) {
        this.pagoComparendo = pagoComparendo;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Comparendo getComparendo() {
        return comparendo;
    }

    public void setComparendo(Comparendo comparendo) {
        this.comparendo = comparendo;
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
        if (!(object instanceof DetalleComparendo)) {
            return false;
        }
        DetalleComparendo other = (DetalleComparendo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.DetalleComparendo[ id=" + id + " ]";
    }
    
}
