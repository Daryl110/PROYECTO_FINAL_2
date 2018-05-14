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
@Table(name = "TIPO_INFRACCION")
@NamedQueries({
    @NamedQuery(name = "TipoInfraccion.findAll", query = "SELECT t FROM TipoInfraccion t")
    , @NamedQuery(name = "TipoInfraccion.findByCodigo", query = "SELECT t FROM TipoInfraccion t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoInfraccion.findByInmovilizacion", query = "SELECT t FROM TipoInfraccion t WHERE t.inmovilizacion = :inmovilizacion")
    , @NamedQuery(name = "TipoInfraccion.findBySuspencionLicencia", query = "SELECT t FROM TipoInfraccion t WHERE t.suspencionLicencia = :suspencionLicencia")
    , @NamedQuery(name = "TipoInfraccion.findBySalariosMinimos", query = "SELECT t FROM TipoInfraccion t WHERE t.salariosMinimos = :salariosMinimos")})
public class TipoInfraccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INMOVILIZACION")
    private BigInteger inmovilizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUSPENCION_LICENCIA")
    private BigInteger suspencionLicencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIOS_MINIMOS")
    private BigInteger salariosMinimos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInfraccionCodigo")
    private List<Comparendo> comparendoList;

    public TipoInfraccion() {
    }

    public TipoInfraccion(String codigo) {
        this.codigo = codigo;
    }

    public TipoInfraccion(String codigo, BigInteger inmovilizacion, BigInteger suspencionLicencia, BigInteger salariosMinimos) {
        this.codigo = codigo;
        this.inmovilizacion = inmovilizacion;
        this.suspencionLicencia = suspencionLicencia;
        this.salariosMinimos = salariosMinimos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigInteger getInmovilizacion() {
        return inmovilizacion;
    }

    public void setInmovilizacion(BigInteger inmovilizacion) {
        this.inmovilizacion = inmovilizacion;
    }

    public BigInteger getSuspencionLicencia() {
        return suspencionLicencia;
    }

    public void setSuspencionLicencia(BigInteger suspencionLicencia) {
        this.suspencionLicencia = suspencionLicencia;
    }

    public BigInteger getSalariosMinimos() {
        return salariosMinimos;
    }

    public void setSalariosMinimos(BigInteger salariosMinimos) {
        this.salariosMinimos = salariosMinimos;
    }

    public List<Comparendo> getComparendoList() {
        return comparendoList;
    }

    public void setComparendoList(List<Comparendo> comparendoList) {
        this.comparendoList = comparendoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInfraccion)) {
            return false;
        }
        TipoInfraccion other = (TipoInfraccion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.TipoInfraccion[ codigo=" + codigo + " ]";
    }
    
}
