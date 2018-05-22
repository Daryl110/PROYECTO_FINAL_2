/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "POLIZA_SEGURO")
@NamedQueries({
    @NamedQuery(name = "PolizaSeguro.findAll", query = "SELECT p FROM PolizaSeguro p")
    , @NamedQuery(name = "PolizaSeguro.findByNPoliza", query = "SELECT p FROM PolizaSeguro p WHERE p.nPoliza = :nPoliza")
    , @NamedQuery(name = "PolizaSeguro.findByFechaVencimiento", query = "SELECT p FROM PolizaSeguro p WHERE p.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "PolizaSeguro.findByCompaniaAseguradora", query = "SELECT p FROM PolizaSeguro p WHERE p.companiaAseguradora = :companiaAseguradora")
    , @NamedQuery(name = "PolizaSeguro.findByPlaca", query = "SELECT p FROM PolizaSeguro p WHERE p.placa = :placa")})
@XmlRootElement
public class PolizaSeguro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "N_POLIZA")
    private String nPoliza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Size(max = 20)
    @Column(name = "COMPANIA_ASEGURADORA")
    private String companiaAseguradora;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLACA")
    private String placa;
    @JoinColumn(name = "PLACA", referencedColumnName = "PLACA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vehiculo vehiculo;

    public PolizaSeguro() {
    }

    public PolizaSeguro(String placa) {
        this.placa = placa;
    }

    public PolizaSeguro(String placa, String nPoliza, Date fechaVencimiento) {
        this.placa = placa;
        this.nPoliza = nPoliza;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNPoliza() {
        return nPoliza;
    }

    public void setNPoliza(String nPoliza) {
        this.nPoliza = nPoliza;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCompaniaAseguradora() {
        return companiaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        this.companiaAseguradora = companiaAseguradora;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
        if (!(object instanceof PolizaSeguro)) {
            return false;
        }
        PolizaSeguro other = (PolizaSeguro) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.PolizaSeguro[ placa=" + placa + " ]";
    }
    
}
