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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "INFORME_ACCIDENTE_TRANSITO")
@NamedQueries({
    @NamedQuery(name = "InformeAccidenteTransito.findAll", query = "SELECT i FROM InformeAccidenteTransito i")
    , @NamedQuery(name = "InformeAccidenteTransito.findById", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.id = :id")
    , @NamedQuery(name = "InformeAccidenteTransito.findByTipoGravedad", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.tipoGravedad = :tipoGravedad")
    , @NamedQuery(name = "InformeAccidenteTransito.findByFechaHora", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.fechaHora = :fechaHora")
    , @NamedQuery(name = "InformeAccidenteTransito.findByClaseAccidente", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.claseAccidente = :claseAccidente")
    , @NamedQuery(name = "InformeAccidenteTransito.findByChoqueCon", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.choqueCon = :choqueCon")
    , @NamedQuery(name = "InformeAccidenteTransito.findByObjetoFijo", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.objetoFijo = :objetoFijo")
    , @NamedQuery(name = "InformeAccidenteTransito.findByNumeroMuertos", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.numeroMuertos = :numeroMuertos")
    , @NamedQuery(name = "InformeAccidenteTransito.findByNumeroHeridos", query = "SELECT i FROM InformeAccidenteTransito i WHERE i.numeroHeridos = :numeroHeridos")})
public class InformeAccidenteTransito implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_GRAVEDAD")
    private String tipoGravedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Size(max = 20)
    @Column(name = "CLASE_ACCIDENTE")
    private String claseAccidente;
    @Size(max = 20)
    @Column(name = "CHOQUE_CON")
    private String choqueCon;
    @Size(max = 20)
    @Column(name = "OBJETO_FIJO")
    private String objetoFijo;
    @Lob
    @Column(name = "CROQUIS")
    private Serializable croquis;
    @Column(name = "NUMERO_MUERTOS")
    private BigInteger numeroMuertos;
    @Column(name = "NUMERO_HERIDOS")
    private BigInteger numeroHeridos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informeAccidenteTransitoId")
    private List<Testigos> testigosList;
    @JoinColumn(name = "AGENTE", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona agente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "informeAccidenteTransito")
    private Lugar lugar;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "informeAccidenteTransito")
    private CaracteristicaLugar caracteristicaLugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informeAccidenteTransitoId")
    private List<VehiculosAfectados> vehiculosAfectadosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "informeAccidenteTransito")
    private CaracteristicaVia caracteristicaVia;

    public InformeAccidenteTransito() {
    }

    public InformeAccidenteTransito(BigDecimal id) {
        this.id = id;
    }

    public InformeAccidenteTransito(BigDecimal id, String tipoGravedad, Date fechaHora) {
        this.id = id;
        this.tipoGravedad = tipoGravedad;
        this.fechaHora = fechaHora;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipoGravedad() {
        return tipoGravedad;
    }

    public void setTipoGravedad(String tipoGravedad) {
        this.tipoGravedad = tipoGravedad;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getClaseAccidente() {
        return claseAccidente;
    }

    public void setClaseAccidente(String claseAccidente) {
        this.claseAccidente = claseAccidente;
    }

    public String getChoqueCon() {
        return choqueCon;
    }

    public void setChoqueCon(String choqueCon) {
        this.choqueCon = choqueCon;
    }

    public String getObjetoFijo() {
        return objetoFijo;
    }

    public void setObjetoFijo(String objetoFijo) {
        this.objetoFijo = objetoFijo;
    }

    public Serializable getCroquis() {
        return croquis;
    }

    public void setCroquis(Serializable croquis) {
        this.croquis = croquis;
    }

    public BigInteger getNumeroMuertos() {
        return numeroMuertos;
    }

    public void setNumeroMuertos(BigInteger numeroMuertos) {
        this.numeroMuertos = numeroMuertos;
    }

    public BigInteger getNumeroHeridos() {
        return numeroHeridos;
    }

    public void setNumeroHeridos(BigInteger numeroHeridos) {
        this.numeroHeridos = numeroHeridos;
    }

    public List<Testigos> getTestigosList() {
        return testigosList;
    }

    public void setTestigosList(List<Testigos> testigosList) {
        this.testigosList = testigosList;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public CaracteristicaLugar getCaracteristicaLugar() {
        return caracteristicaLugar;
    }

    public void setCaracteristicaLugar(CaracteristicaLugar caracteristicaLugar) {
        this.caracteristicaLugar = caracteristicaLugar;
    }

    public List<VehiculosAfectados> getVehiculosAfectadosList() {
        return vehiculosAfectadosList;
    }

    public void setVehiculosAfectadosList(List<VehiculosAfectados> vehiculosAfectadosList) {
        this.vehiculosAfectadosList = vehiculosAfectadosList;
    }

    public CaracteristicaVia getCaracteristicaVia() {
        return caracteristicaVia;
    }

    public void setCaracteristicaVia(CaracteristicaVia caracteristicaVia) {
        this.caracteristicaVia = caracteristicaVia;
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
        if (!(object instanceof InformeAccidenteTransito)) {
            return false;
        }
        InformeAccidenteTransito other = (InformeAccidenteTransito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.InformeAccidenteTransito[ id=" + id + " ]";
    }
    
}
