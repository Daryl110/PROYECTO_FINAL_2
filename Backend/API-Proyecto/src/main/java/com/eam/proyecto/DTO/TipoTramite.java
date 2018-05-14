/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "TIPO_TRAMITE")
@NamedQueries({
    @NamedQuery(name = "TipoTramite.findAll", query = "SELECT t FROM TipoTramite t")
    , @NamedQuery(name = "TipoTramite.findById", query = "SELECT t FROM TipoTramite t WHERE t.id = :id")
    , @NamedQuery(name = "TipoTramite.findByDescripcion", query = "SELECT t FROM TipoTramite t WHERE t.descripcion = :descripcion")})
public class TipoTramite implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTramiteId")
    private List<Tramite> tramiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTramiteId")
    private List<Requisitos> requisitosList;

    public TipoTramite() {
    }

    public TipoTramite(BigDecimal id) {
        this.id = id;
    }

    public TipoTramite(BigDecimal id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    public List<Requisitos> getRequisitosList() {
        return requisitosList;
    }

    public void setRequisitosList(List<Requisitos> requisitosList) {
        this.requisitosList = requisitosList;
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
        if (!(object instanceof TipoTramite)) {
            return false;
        }
        TipoTramite other = (TipoTramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.TipoTramite[ id=" + id + " ]";
    }
    
}
