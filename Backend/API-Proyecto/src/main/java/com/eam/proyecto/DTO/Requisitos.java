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
@Table(name = "REQUISITOS")
@NamedQueries({
    @NamedQuery(name = "Requisitos.findAll", query = "SELECT r FROM Requisitos r")
    , @NamedQuery(name = "Requisitos.findById", query = "SELECT r FROM Requisitos r WHERE r.id = :id")
    , @NamedQuery(name = "Requisitos.findByDescripcion", query = "SELECT r FROM Requisitos r WHERE r.descripcion = :descripcion")})
@XmlRootElement
public class Requisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "TIPO_TRAMITE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoTramite tipoTramiteId;

    public Requisitos() {
    }

    public Requisitos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTramite getTipoTramiteId() {
        return tipoTramiteId;
    }

    public void setTipoTramiteId(TipoTramite tipoTramiteId) {
        this.tipoTramiteId = tipoTramiteId;
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
        if (!(object instanceof Requisitos)) {
            return false;
        }
        Requisitos other = (Requisitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Requisitos[ id=" + id + " ]";
    }
    
}
