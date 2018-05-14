/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "VALORES")
@NamedQueries({
    @NamedQuery(name = "Valores.findAll", query = "SELECT v FROM Valores v")
    , @NamedQuery(name = "Valores.findByFecha", query = "SELECT v FROM Valores v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Valores.findByValorSalarioMinimo", query = "SELECT v FROM Valores v WHERE v.valorSalarioMinimo = :valorSalarioMinimo")
    , @NamedQuery(name = "Valores.findByValorDiaMora", query = "SELECT v FROM Valores v WHERE v.valorDiaMora = :valorDiaMora")
    , @NamedQuery(name = "Valores.findByDescuentoComparendo", query = "SELECT v FROM Valores v WHERE v.descuentoComparendo = :descuentoComparendo")
    , @NamedQuery(name = "Valores.findByDiasHabiles", query = "SELECT v FROM Valores v WHERE v.diasHabiles = :diasHabiles")})
public class Valores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_SALARIO_MINIMO")
    private BigInteger valorSalarioMinimo;
    @Column(name = "VALOR_DIA_MORA")
    private BigInteger valorDiaMora;
    @Column(name = "DESCUENTO_COMPARENDO")
    private BigInteger descuentoComparendo;
    @Column(name = "DIAS_HABILES")
    private BigInteger diasHabiles;

    public Valores() {
    }

    public Valores(Date fecha) {
        this.fecha = fecha;
    }

    public Valores(Date fecha, BigInteger valorSalarioMinimo) {
        this.fecha = fecha;
        this.valorSalarioMinimo = valorSalarioMinimo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getValorSalarioMinimo() {
        return valorSalarioMinimo;
    }

    public void setValorSalarioMinimo(BigInteger valorSalarioMinimo) {
        this.valorSalarioMinimo = valorSalarioMinimo;
    }

    public BigInteger getValorDiaMora() {
        return valorDiaMora;
    }

    public void setValorDiaMora(BigInteger valorDiaMora) {
        this.valorDiaMora = valorDiaMora;
    }

    public BigInteger getDescuentoComparendo() {
        return descuentoComparendo;
    }

    public void setDescuentoComparendo(BigInteger descuentoComparendo) {
        this.descuentoComparendo = descuentoComparendo;
    }

    public BigInteger getDiasHabiles() {
        return diasHabiles;
    }

    public void setDiasHabiles(BigInteger diasHabiles) {
        this.diasHabiles = diasHabiles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valores)) {
            return false;
        }
        Valores other = (Valores) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Valores[ fecha=" + fecha + " ]";
    }
    
}
