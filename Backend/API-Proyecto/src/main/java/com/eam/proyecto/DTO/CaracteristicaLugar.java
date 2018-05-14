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

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "CARACTERISTICA_LUGAR")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaLugar.findAll", query = "SELECT c FROM CaracteristicaLugar c")
    , @NamedQuery(name = "CaracteristicaLugar.findById", query = "SELECT c FROM CaracteristicaLugar c WHERE c.id = :id")
    , @NamedQuery(name = "CaracteristicaLugar.findByAreaId", query = "SELECT c FROM CaracteristicaLugar c WHERE c.areaId = :areaId")
    , @NamedQuery(name = "CaracteristicaLugar.findBySectorId", query = "SELECT c FROM CaracteristicaLugar c WHERE c.sectorId = :sectorId")
    , @NamedQuery(name = "CaracteristicaLugar.findByZonaId", query = "SELECT c FROM CaracteristicaLugar c WHERE c.zonaId = :zonaId")
    , @NamedQuery(name = "CaracteristicaLugar.findByDisenioId", query = "SELECT c FROM CaracteristicaLugar c WHERE c.disenioId = :disenioId")
    , @NamedQuery(name = "CaracteristicaLugar.findByTiempoId", query = "SELECT c FROM CaracteristicaLugar c WHERE c.tiempoId = :tiempoId")})
public class CaracteristicaLugar implements Serializable {

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
    @Column(name = "AREA_ID")
    private String areaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SECTOR_ID")
    private String sectorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ZONA_ID")
    private String zonaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DISENIO_ID")
    private String disenioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIEMPO_ID")
    private String tiempoId;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private InformeAccidenteTransito informeAccidenteTransito;

    public CaracteristicaLugar() {
    }

    public CaracteristicaLugar(BigDecimal id) {
        this.id = id;
    }

    public CaracteristicaLugar(BigDecimal id, String areaId, String sectorId, String zonaId, String disenioId, String tiempoId) {
        this.id = id;
        this.areaId = areaId;
        this.sectorId = sectorId;
        this.zonaId = zonaId;
        this.disenioId = disenioId;
        this.tiempoId = tiempoId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getZonaId() {
        return zonaId;
    }

    public void setZonaId(String zonaId) {
        this.zonaId = zonaId;
    }

    public String getDisenioId() {
        return disenioId;
    }

    public void setDisenioId(String disenioId) {
        this.disenioId = disenioId;
    }

    public String getTiempoId() {
        return tiempoId;
    }

    public void setTiempoId(String tiempoId) {
        this.tiempoId = tiempoId;
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
        if (!(object instanceof CaracteristicaLugar)) {
            return false;
        }
        CaracteristicaLugar other = (CaracteristicaLugar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.CaracteristicaLugar[ id=" + id + " ]";
    }
    
}
