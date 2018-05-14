/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "PAGO_COMPARENDO")
@NamedQueries({
    @NamedQuery(name = "PagoComparendo.findAll", query = "SELECT p FROM PagoComparendo p")
    , @NamedQuery(name = "PagoComparendo.findById", query = "SELECT p FROM PagoComparendo p WHERE p.id = :id")
    , @NamedQuery(name = "PagoComparendo.findByIntereseMora", query = "SELECT p FROM PagoComparendo p WHERE p.intereseMora = :intereseMora")
    , @NamedQuery(name = "PagoComparendo.findByMontoTotal", query = "SELECT p FROM PagoComparendo p WHERE p.montoTotal = :montoTotal")})
public class PagoComparendo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "INTERESE_MORA")
    private BigInteger intereseMora;
    @Column(name = "MONTO_TOTAL")
    private BigInteger montoTotal;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DetalleComparendo detalleComparendo;

    public PagoComparendo() {
    }

    public PagoComparendo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIntereseMora() {
        return intereseMora;
    }

    public void setIntereseMora(BigInteger intereseMora) {
        this.intereseMora = intereseMora;
    }

    public BigInteger getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigInteger montoTotal) {
        this.montoTotal = montoTotal;
    }

    public DetalleComparendo getDetalleComparendo() {
        return detalleComparendo;
    }

    public void setDetalleComparendo(DetalleComparendo detalleComparendo) {
        this.detalleComparendo = detalleComparendo;
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
        if (!(object instanceof PagoComparendo)) {
            return false;
        }
        PagoComparendo other = (PagoComparendo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.PagoComparendo[ id=" + id + " ]";
    }
    
}
