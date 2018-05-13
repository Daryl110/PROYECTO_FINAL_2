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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "CARACTERISTICA_VIA")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaVia.findAll", query = "SELECT c FROM CaracteristicaVia c")})
@XmlRootElement
public class CaracteristicaVia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CARAC_GEOMETRICA_VIA_1")
    private String caracGeometricaVia1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CARAC_GEOMETRICA_VIA_2")
    private String caracGeometricaVia2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CARAC_GEOMETRICA_VIA_3")
    private String caracGeometricaVia3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UTILIZACION")
    private String utilizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CALZADA")
    private String calzada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARRIL")
    private String carril;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MATERIAL")
    private String material;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 20)
    @Column(name = "CONDICION")
    private String condicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ILUMINACION")
    private String iluminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DISMINUCION_VISUAL")
    private String disminucionVisual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTROL_SEMAFORO")
    private String controlSemaforo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CONTROL_SENIALES")
    private String controlSeniales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTROL_DEMARCACION")
    private String controlDemarcacion;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private InformeAccidenteTransito informeAccidenteTransito;

    public CaracteristicaVia() {
    }

    public CaracteristicaVia(BigDecimal id) {
        this.id = id;
    }

    public CaracteristicaVia(BigDecimal id, String caracGeometricaVia1, String caracGeometricaVia2, String caracGeometricaVia3, String utilizacion, String calzada, String carril, String material, String estado, String iluminacion, String disminucionVisual, String controlSemaforo, String controlSeniales, String controlDemarcacion) {
        this.id = id;
        this.caracGeometricaVia1 = caracGeometricaVia1;
        this.caracGeometricaVia2 = caracGeometricaVia2;
        this.caracGeometricaVia3 = caracGeometricaVia3;
        this.utilizacion = utilizacion;
        this.calzada = calzada;
        this.carril = carril;
        this.material = material;
        this.estado = estado;
        this.iluminacion = iluminacion;
        this.disminucionVisual = disminucionVisual;
        this.controlSemaforo = controlSemaforo;
        this.controlSeniales = controlSeniales;
        this.controlDemarcacion = controlDemarcacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCaracGeometricaVia1() {
        return caracGeometricaVia1;
    }

    public void setCaracGeometricaVia1(String caracGeometricaVia1) {
        this.caracGeometricaVia1 = caracGeometricaVia1;
    }

    public String getCaracGeometricaVia2() {
        return caracGeometricaVia2;
    }

    public void setCaracGeometricaVia2(String caracGeometricaVia2) {
        this.caracGeometricaVia2 = caracGeometricaVia2;
    }

    public String getCaracGeometricaVia3() {
        return caracGeometricaVia3;
    }

    public void setCaracGeometricaVia3(String caracGeometricaVia3) {
        this.caracGeometricaVia3 = caracGeometricaVia3;
    }

    public String getUtilizacion() {
        return utilizacion;
    }

    public void setUtilizacion(String utilizacion) {
        this.utilizacion = utilizacion;
    }

    public String getCalzada() {
        return calzada;
    }

    public void setCalzada(String calzada) {
        this.calzada = calzada;
    }

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getIluminacion() {
        return iluminacion;
    }

    public void setIluminacion(String iluminacion) {
        this.iluminacion = iluminacion;
    }

    public String getDisminucionVisual() {
        return disminucionVisual;
    }

    public void setDisminucionVisual(String disminucionVisual) {
        this.disminucionVisual = disminucionVisual;
    }

    public String getControlSemaforo() {
        return controlSemaforo;
    }

    public void setControlSemaforo(String controlSemaforo) {
        this.controlSemaforo = controlSemaforo;
    }

    public String getControlSeniales() {
        return controlSeniales;
    }

    public void setControlSeniales(String controlSeniales) {
        this.controlSeniales = controlSeniales;
    }

    public String getControlDemarcacion() {
        return controlDemarcacion;
    }

    public void setControlDemarcacion(String controlDemarcacion) {
        this.controlDemarcacion = controlDemarcacion;
    }

    public InformeAccidenteTransito getInformeAccidenteTransito() {
        return informeAccidenteTransito;
    }

    public void setInformeAccidenteTransito(InformeAccidenteTransito informeAccidenteTransito) {
        this.informeAccidenteTransito = informeAccidenteTransito;
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
        if (!(object instanceof CaracteristicaVia)) {
            return false;
        }
        CaracteristicaVia other = (CaracteristicaVia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.CaracteristicaVia[ id=" + id + " ]";
    }
    
}
