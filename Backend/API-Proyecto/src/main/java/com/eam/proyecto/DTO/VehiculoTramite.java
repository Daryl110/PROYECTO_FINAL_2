/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "VEHICULO_TRAMITE")
@NamedQueries({
    @NamedQuery(name = "VehiculoTramite.findAll", query = "SELECT v FROM VehiculoTramite v")})
@XmlRootElement
public class VehiculoTramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 20)
    @Column(name = "COMBUSTIBLE")
    private String combustible;
    @Size(max = 20)
    @Column(name = "CLINDRADA")
    private String clindrada;
    @Column(name = "NO_MOTOR")
    private BigInteger noMotor;
    @Column(name = "NO_CHASIS")
    private BigInteger noChasis;
    @Column(name = "NO_SERIE")
    private BigInteger noSerie;
    @Column(name = "NO_VIN")
    private BigInteger noVin;
    @JoinColumn(name = "BLINDAJE_NUMERO_RESOLUCION", referencedColumnName = "NUMERO_RESOLUCION")
    @ManyToOne
    private Blindaje blindajeNumeroResolucion;
    @JoinColumn(name = "TIPO_CARROCERIA_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private TipoCarroceria tipoCarroceriaCodigo;
    @JoinColumn(name = "PLACA", referencedColumnName = "PLACA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vehiculo vehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoTramiteId")
    private List<Tramite> tramiteList;

    public VehiculoTramite() {
    }

    public VehiculoTramite(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getClindrada() {
        return clindrada;
    }

    public void setClindrada(String clindrada) {
        this.clindrada = clindrada;
    }

    public BigInteger getNoMotor() {
        return noMotor;
    }

    public void setNoMotor(BigInteger noMotor) {
        this.noMotor = noMotor;
    }

    public BigInteger getNoChasis() {
        return noChasis;
    }

    public void setNoChasis(BigInteger noChasis) {
        this.noChasis = noChasis;
    }

    public BigInteger getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(BigInteger noSerie) {
        this.noSerie = noSerie;
    }

    public BigInteger getNoVin() {
        return noVin;
    }

    public void setNoVin(BigInteger noVin) {
        this.noVin = noVin;
    }

    public Blindaje getBlindajeNumeroResolucion() {
        return blindajeNumeroResolucion;
    }

    public void setBlindajeNumeroResolucion(Blindaje blindajeNumeroResolucion) {
        this.blindajeNumeroResolucion = blindajeNumeroResolucion;
    }

    public TipoCarroceria getTipoCarroceriaCodigo() {
        return tipoCarroceriaCodigo;
    }

    public void setTipoCarroceriaCodigo(TipoCarroceria tipoCarroceriaCodigo) {
        this.tipoCarroceriaCodigo = tipoCarroceriaCodigo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @XmlTransient
    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoTramite)) {
            return false;
        }
        VehiculoTramite other = (VehiculoTramite) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.VehiculoTramite[ placa=" + placa + " ]";
    }
    
}
