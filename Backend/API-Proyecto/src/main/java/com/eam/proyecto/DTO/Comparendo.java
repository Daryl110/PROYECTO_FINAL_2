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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMPARENDO")
@NamedQueries({
    @NamedQuery(name = "Comparendo.findAll", query = "SELECT c FROM Comparendo c")})
@XmlRootElement
public class Comparendo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "LOCALIDAD_COMUNA")
    private String localidadComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RADIO_ACCION_ID")
    private String radioAccionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_INFRACTOR")
    private String tipoInfractor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "GRUA_ID", referencedColumnName = "NUMERO_GRUA")
    @ManyToOne
    private Grua gruaId;
    @JoinColumn(name = "MODALIDAD_TRANSPORTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ModalidadTransporte modalidadTransporteId;
    @JoinColumn(name = "MUNICIPIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    @JoinColumn(name = "CUIDADANO", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona cuidadano;
    @JoinColumn(name = "AGENTE", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona agente;
    @JoinColumn(name = "TESTIGO", referencedColumnName = "NIP")
    @ManyToOne
    private Persona testigo;
    @JoinColumn(name = "TIPO_INFRACCION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoInfraccion tipoInfraccion;
    @JoinColumn(name = "VEHICULO_PLACA", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoPlaca;
    @JoinColumn(name = "VIA_PRINCIPAL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Via viaPrincipal;
    @JoinColumn(name = "VIA_SECUNDARIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Via viaSecundaria;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comparendo")
    private DetalleComparendo detalleComparendo;

    public Comparendo() {
    }

    public Comparendo(BigDecimal id) {
        this.id = id;
    }

    public Comparendo(BigDecimal id, Date fecha, String radioAccionId, String tipoInfractor, String descripcion, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.radioAccionId = radioAccionId;
        this.tipoInfractor = tipoInfractor;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLocalidadComuna() {
        return localidadComuna;
    }

    public void setLocalidadComuna(String localidadComuna) {
        this.localidadComuna = localidadComuna;
    }

    public String getRadioAccionId() {
        return radioAccionId;
    }

    public void setRadioAccionId(String radioAccionId) {
        this.radioAccionId = radioAccionId;
    }

    public String getTipoInfractor() {
        return tipoInfractor;
    }

    public void setTipoInfractor(String tipoInfractor) {
        this.tipoInfractor = tipoInfractor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Grua getGruaId() {
        return gruaId;
    }

    public void setGruaId(Grua gruaId) {
        this.gruaId = gruaId;
    }

    public ModalidadTransporte getModalidadTransporteId() {
        return modalidadTransporteId;
    }

    public void setModalidadTransporteId(ModalidadTransporte modalidadTransporteId) {
        this.modalidadTransporteId = modalidadTransporteId;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Persona getCuidadano() {
        return cuidadano;
    }

    public void setCuidadano(Persona cuidadano) {
        this.cuidadano = cuidadano;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public Persona getTestigo() {
        return testigo;
    }

    public void setTestigo(Persona testigo) {
        this.testigo = testigo;
    }

    public TipoInfraccion getTipoInfraccion() {
        return tipoInfraccion;
    }

    public void setTipoInfraccion(TipoInfraccion tipoInfraccion) {
        this.tipoInfraccion = tipoInfraccion;
    }

    public Vehiculo getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(Vehiculo vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    public Via getViaPrincipal() {
        return viaPrincipal;
    }

    public void setViaPrincipal(Via viaPrincipal) {
        this.viaPrincipal = viaPrincipal;
    }

    public Via getViaSecundaria() {
        return viaSecundaria;
    }

    public void setViaSecundaria(Via viaSecundaria) {
        this.viaSecundaria = viaSecundaria;
    }

    public DetalleComparendo getDetalleComparendo() {
        return detalleComparendo;
    }

    public void setDetalleComparendo(DetalleComparendo detalleComparendo) {
        this.detalleComparendo = detalleComparendo;
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
        if (!(object instanceof Comparendo)) {
            return false;
        }
        Comparendo other = (Comparendo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Comparendo[ id=" + id + " ]";
    }
    
}
