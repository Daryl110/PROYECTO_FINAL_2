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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "GRUA")
@NamedQueries({
    @NamedQuery(name = "Grua.findAll", query = "SELECT g FROM Grua g")
    , @NamedQuery(name = "Grua.findByNumeroGrua", query = "SELECT g FROM Grua g WHERE g.numeroGrua = :numeroGrua")
    , @NamedQuery(name = "Grua.findByPlaca", query = "SELECT g FROM Grua g WHERE g.placa = :placa")
    , @NamedQuery(name = "Grua.findByConsecutivo", query = "SELECT g FROM Grua g WHERE g.consecutivo = :consecutivo")
    , @NamedQuery(name = "Grua.findByDireccionPatioAsignado", query = "SELECT g FROM Grua g WHERE g.direccionPatioAsignado = :direccionPatioAsignado")})
@XmlRootElement
public class Grua implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_GRUA")
    private BigDecimal numeroGrua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONSECUTIVO")
    private String consecutivo;
    @Size(max = 20)
    @Column(name = "DIRECCION_PATIO_ASIGNADO")
    private String direccionPatioAsignado;
    @OneToMany(mappedBy = "gruaId")
    private List<Comparendo> comparendoList;

    public Grua() {
    }

    public Grua(BigDecimal numeroGrua) {
        this.numeroGrua = numeroGrua;
    }

    public Grua(BigDecimal numeroGrua, String placa, String consecutivo) {
        this.numeroGrua = numeroGrua;
        this.placa = placa;
        this.consecutivo = consecutivo;
    }

    public BigDecimal getNumeroGrua() {
        return numeroGrua;
    }

    public void setNumeroGrua(BigDecimal numeroGrua) {
        this.numeroGrua = numeroGrua;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getDireccionPatioAsignado() {
        return direccionPatioAsignado;
    }

    public void setDireccionPatioAsignado(String direccionPatioAsignado) {
        this.direccionPatioAsignado = direccionPatioAsignado;
    }

    @XmlTransient
    public List<Comparendo> getComparendoList() {
        return comparendoList;
    }

    public void setComparendoList(List<Comparendo> comparendoList) {
        this.comparendoList = comparendoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroGrua != null ? numeroGrua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grua)) {
            return false;
        }
        Grua other = (Grua) object;
        if ((this.numeroGrua == null && other.numeroGrua != null) || (this.numeroGrua != null && !this.numeroGrua.equals(other.numeroGrua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Grua[ numeroGrua=" + numeroGrua + " ]";
    }
    
}
