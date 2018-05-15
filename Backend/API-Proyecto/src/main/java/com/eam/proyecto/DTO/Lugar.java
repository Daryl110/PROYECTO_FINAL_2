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
@Table(name = "LUGAR")
@NamedQueries({
    @NamedQuery(name = "Lugar.findAll", query = "SELECT l FROM Lugar l")
    , @NamedQuery(name = "Lugar.findById", query = "SELECT l FROM Lugar l WHERE l.id = :id")
    , @NamedQuery(name = "Lugar.findByCoordenandaX", query = "SELECT l FROM Lugar l WHERE l.coordenandaX = :coordenandaX")
    , @NamedQuery(name = "Lugar.findByCoordenadaY", query = "SELECT l FROM Lugar l WHERE l.coordenadaY = :coordenadaY")
    , @NamedQuery(name = "Lugar.findByDireccion", query = "SELECT l FROM Lugar l WHERE l.direccion = :direccion")
    , @NamedQuery(name = "Lugar.findByLocalidadComuna", query = "SELECT l FROM Lugar l WHERE l.localidadComuna = :localidadComuna")})
@XmlRootElement
public class Lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 5)
    @Column(name = "COORDENANDA_X")
    private String coordenandaX;
    @Size(max = 5)
    @Column(name = "COORDENADA_Y")
    private String coordenadaY;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOCALIDAD_COMUNA")
    private String localidadComuna;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private InformeAccidenteTransito informeAccidenteTransito;

    public Lugar() {
    }

    public Lugar(BigDecimal id) {
        this.id = id;
    }

    public Lugar(BigDecimal id, String direccion, String localidadComuna) {
        this.id = id;
        this.direccion = direccion;
        this.localidadComuna = localidadComuna;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCoordenandaX() {
        return coordenandaX;
    }

    public void setCoordenandaX(String coordenandaX) {
        this.coordenandaX = coordenandaX;
    }

    public String getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(String coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidadComuna() {
        return localidadComuna;
    }

    public void setLocalidadComuna(String localidadComuna) {
        this.localidadComuna = localidadComuna;
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
        if (!(object instanceof Lugar)) {
            return false;
        }
        Lugar other = (Lugar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Lugar[ id=" + id + " ]";
    }
    
}
