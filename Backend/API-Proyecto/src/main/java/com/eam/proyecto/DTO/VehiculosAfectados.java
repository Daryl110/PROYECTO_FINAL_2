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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "VEHICULOS_AFECTADOS")
@NamedQueries({
    @NamedQuery(name = "VehiculosAfectados.findAll", query = "SELECT v FROM VehiculosAfectados v")})
@XmlRootElement
public class VehiculosAfectados implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 20)
    @Column(name = "INMOVILIZACION")
    private String inmovilizacion;
    @Size(max = 20)
    @Column(name = "DISPOSICION")
    private String disposicion;
    @Column(name = "PRPIETARIO_MISMO_CONDUCTOR")
    private Character prpietarioMismoConductor;
    @Size(max = 20)
    @Column(name = "FALLA_EN")
    private String fallaEn;
    @Size(max = 50)
    @Column(name = "LUGAR_IMPACTO")
    private String lugarImpacto;
    @Size(max = 50)
    @Column(name = "VERSION")
    private String version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculosAfectadosId")
    private List<Perjudicados> perjudicadosList;
    @JoinColumn(name = "INFORME_ACCIDENTE_TRANSITO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private InformeAccidenteTransito informeAccidenteTransitoId;
    @JoinColumn(name = "VEHICULO_PLACA", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoPlaca;

    public VehiculosAfectados() {
    }

    public VehiculosAfectados(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getInmovilizacion() {
        return inmovilizacion;
    }

    public void setInmovilizacion(String inmovilizacion) {
        this.inmovilizacion = inmovilizacion;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public Character getPrpietarioMismoConductor() {
        return prpietarioMismoConductor;
    }

    public void setPrpietarioMismoConductor(Character prpietarioMismoConductor) {
        this.prpietarioMismoConductor = prpietarioMismoConductor;
    }

    public String getFallaEn() {
        return fallaEn;
    }

    public void setFallaEn(String fallaEn) {
        this.fallaEn = fallaEn;
    }

    public String getLugarImpacto() {
        return lugarImpacto;
    }

    public void setLugarImpacto(String lugarImpacto) {
        this.lugarImpacto = lugarImpacto;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlTransient
    public List<Perjudicados> getPerjudicadosList() {
        return perjudicadosList;
    }

    public void setPerjudicadosList(List<Perjudicados> perjudicadosList) {
        this.perjudicadosList = perjudicadosList;
    }

    public InformeAccidenteTransito getInformeAccidenteTransitoId() {
        return informeAccidenteTransitoId;
    }

    public void setInformeAccidenteTransitoId(InformeAccidenteTransito informeAccidenteTransitoId) {
        this.informeAccidenteTransitoId = informeAccidenteTransitoId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculosAfectados)) {
            return false;
        }
        VehiculosAfectados other = (VehiculosAfectados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.VehiculosAfectados[ id=" + id + " ]";
    }
    
}
