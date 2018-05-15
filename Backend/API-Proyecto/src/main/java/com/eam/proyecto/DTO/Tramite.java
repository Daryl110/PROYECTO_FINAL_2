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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "TRAMITE")
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t")
    , @NamedQuery(name = "Tramite.findById", query = "SELECT t FROM Tramite t WHERE t.id = :id")
    , @NamedQuery(name = "Tramite.findByFecha", query = "SELECT t FROM Tramite t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Tramite.findByDescripcion", query = "SELECT t FROM Tramite t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tramite.findByValor", query = "SELECT t FROM Tramite t WHERE t.valor = :valor")})
@XmlRootElement
public class Tramite implements Serializable {

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
    @Size(max = 20)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @JoinColumn(name = "PERSONA_NIP", referencedColumnName = "NIP")
    @ManyToOne
    private Persona personaNip;
    @JoinColumn(name = "TIPO_TRAMITE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoTramite tipoTramiteId;
    @JoinColumn(name = "VEHICULO_TRAMITE_ID", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private VehiculoTramite vehiculoTramiteId;

    public Tramite() {
    }

    public Tramite(BigDecimal id) {
        this.id = id;
    }

    public Tramite(BigDecimal id, BigInteger valor) {
        this.id = id;
        this.valor = valor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Persona getPersonaNip() {
        return personaNip;
    }

    public void setPersonaNip(Persona personaNip) {
        this.personaNip = personaNip;
    }

    public TipoTramite getTipoTramiteId() {
        return tipoTramiteId;
    }

    public void setTipoTramiteId(TipoTramite tipoTramiteId) {
        this.tipoTramiteId = tipoTramiteId;
    }

    public VehiculoTramite getVehiculoTramiteId() {
        return vehiculoTramiteId;
    }

    public void setVehiculoTramiteId(VehiculoTramite vehiculoTramiteId) {
        this.vehiculoTramiteId = vehiculoTramiteId;
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
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Tramite[ id=" + id + " ]";
    }
    
}
