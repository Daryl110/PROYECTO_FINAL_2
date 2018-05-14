/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "BLINDAJE")
@NamedQueries({
    @NamedQuery(name = "Blindaje.findAll", query = "SELECT b FROM Blindaje b")
    , @NamedQuery(name = "Blindaje.findByNumeroResolucion", query = "SELECT b FROM Blindaje b WHERE b.numeroResolucion = :numeroResolucion")
    , @NamedQuery(name = "Blindaje.findByFecha", query = "SELECT b FROM Blindaje b WHERE b.fecha = :fecha")})
public class Blindaje implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_RESOLUCION")
    private BigDecimal numeroResolucion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "blindajeNumeroResolucion")
    private List<VehiculoTramite> vehiculoTramiteList;

    public Blindaje() {
    }

    public Blindaje(BigDecimal numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public BigDecimal getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(BigDecimal numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<VehiculoTramite> getVehiculoTramiteList() {
        return vehiculoTramiteList;
    }

    public void setVehiculoTramiteList(List<VehiculoTramite> vehiculoTramiteList) {
        this.vehiculoTramiteList = vehiculoTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroResolucion != null ? numeroResolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blindaje)) {
            return false;
        }
        Blindaje other = (Blindaje) object;
        if ((this.numeroResolucion == null && other.numeroResolucion != null) || (this.numeroResolucion != null && !this.numeroResolucion.equals(other.numeroResolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Blindaje[ numeroResolucion=" + numeroResolucion + " ]";
    }
    
}
