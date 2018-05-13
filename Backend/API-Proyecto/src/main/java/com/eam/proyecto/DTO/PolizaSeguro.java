/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "POLIZA_SEGURO")
@NamedQueries({
    @NamedQuery(name = "PolizaSeguro.findAll", query = "SELECT p FROM PolizaSeguro p")})
@XmlRootElement
public class PolizaSeguro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_POLIZA")
    private BigDecimal nPoliza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Size(max = 20)
    @Column(name = "COMPANIA_ASEGURADORA")
    private String companiaAseguradora;
    @JoinColumn(name = "VEHICULO_PLACA", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoPlaca;

    public PolizaSeguro() {
    }

    public PolizaSeguro(BigDecimal nPoliza) {
        this.nPoliza = nPoliza;
    }

    public PolizaSeguro(BigDecimal nPoliza, Date fechaVencimiento) {
        this.nPoliza = nPoliza;
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getNPoliza() {
        return nPoliza;
    }

    public void setNPoliza(BigDecimal nPoliza) {
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

    public Vehiculo getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(Vehiculo vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPoliza != null ? nPoliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolizaSeguro)) {
            return false;
        }
        PolizaSeguro other = (PolizaSeguro) object;
        if ((this.nPoliza == null && other.nPoliza != null) || (this.nPoliza != null && !this.nPoliza.equals(other.nPoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.PolizaSeguro[ nPoliza=" + nPoliza + " ]";
    }
    
}
