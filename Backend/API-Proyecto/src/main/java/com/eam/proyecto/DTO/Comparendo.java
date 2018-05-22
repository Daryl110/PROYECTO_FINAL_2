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
    @NamedQuery(name = "Comparendo.findAll", query = "SELECT c FROM Comparendo c")
    , @NamedQuery(name = "Comparendo.findById", query = "SELECT c FROM Comparendo c WHERE c.id = :id")
    , @NamedQuery(name = "Comparendo.findByFecha", query = "SELECT c FROM Comparendo c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Comparendo.findByLocalidadComuna", query = "SELECT c FROM Comparendo c WHERE c.localidadComuna = :localidadComuna")
    , @NamedQuery(name = "Comparendo.findByViaPrincipal", query = "SELECT c FROM Comparendo c WHERE c.viaPrincipal = :viaPrincipal")
    , @NamedQuery(name = "Comparendo.findByViaSecundaria", query = "SELECT c FROM Comparendo c WHERE c.viaSecundaria = :viaSecundaria")
    , @NamedQuery(name = "Comparendo.findByModalidadTransporte", query = "SELECT c FROM Comparendo c WHERE c.modalidadTransporte = :modalidadTransporte")
    , @NamedQuery(name = "Comparendo.findByRadioAccion", query = "SELECT c FROM Comparendo c WHERE c.radioAccion = :radioAccion")
    , @NamedQuery(name = "Comparendo.findByTipoInfractor", query = "SELECT c FROM Comparendo c WHERE c.tipoInfractor = :tipoInfractor")
    , @NamedQuery(name = "Comparendo.findByDescripcion", query = "SELECT c FROM Comparendo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Comparendo.findByEstado", query = "SELECT c FROM Comparendo c WHERE c.estado = :estado")})
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOCALIDAD_COMUNA")
    private String localidadComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VIA_PRINCIPAL")
    private String viaPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VIA_SECUNDARIA")
    private String viaSecundaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MODALIDAD_TRANSPORTE")
    private String modalidadTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RADIO_ACCION")
    private String radioAccion;
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
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "GRUA_ID", referencedColumnName = "NUMERO_GRUA")
    @ManyToOne
    private Grua gruaId;
    @JoinColumn(name = "MUNICIPIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    @JoinColumn(name = "TESTIGO", referencedColumnName = "NIP")
    @ManyToOne
    private Persona testigo;
    @JoinColumn(name = "INFRACTOR", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona infractor;
    @JoinColumn(name = "AGENTE", referencedColumnName = "NIP")
    @ManyToOne(optional = false)
    private Persona agente;
    @JoinColumn(name = "TIPO_INFRACCION_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private TipoInfraccion tipoInfraccionCodigo;
    @JoinColumn(name = "VEHICULO_PLACA", referencedColumnName = "PLACA")
    @ManyToOne(optional = false)
    private Vehiculo vehiculoPlaca;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "comparendo")
    private DetalleComparendo detalleComparendo;

    public Comparendo() {
    }

    public Comparendo(BigDecimal id) {
        this.id = id;
    }

    public Comparendo(BigDecimal id, Date fecha, String localidadComuna, String viaPrincipal, String viaSecundaria, String modalidadTransporte, String radioAccion, String tipoInfractor, String descripcion, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.localidadComuna = localidadComuna;
        this.viaPrincipal = viaPrincipal;
        this.viaSecundaria = viaSecundaria;
        this.modalidadTransporte = modalidadTransporte;
        this.radioAccion = radioAccion;
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

    public String getViaPrincipal() {
        return viaPrincipal;
    }

    public void setViaPrincipal(String viaPrincipal) {
        this.viaPrincipal = viaPrincipal;
    }

    public String getViaSecundaria() {
        return viaSecundaria;
    }

    public void setViaSecundaria(String viaSecundaria) {
        this.viaSecundaria = viaSecundaria;
    }

    public String getModalidadTransporte() {
        return modalidadTransporte;
    }

    public void setModalidadTransporte(String modalidadTransporte) {
        this.modalidadTransporte = modalidadTransporte;
    }

    public String getRadioAccion() {
        return radioAccion;
    }

    public void setRadioAccion(String radioAccion) {
        this.radioAccion = radioAccion;
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

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public Persona getTestigo() {
        return testigo;
    }

    public void setTestigo(Persona testigo) {
        this.testigo = testigo;
    }

    public Persona getInfractor() {
        return infractor;
    }

    public void setInfractor(Persona infractor) {
        this.infractor = infractor;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public TipoInfraccion getTipoInfraccionCodigo() {
        return tipoInfraccionCodigo;
    }

    public void setTipoInfraccionCodigo(TipoInfraccion tipoInfraccionCodigo) {
        this.tipoInfraccionCodigo = tipoInfraccionCodigo;
    }

    public Vehiculo getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(Vehiculo vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
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
