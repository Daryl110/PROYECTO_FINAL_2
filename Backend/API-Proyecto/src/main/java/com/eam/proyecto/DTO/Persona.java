/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.DTO;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daryl Ospina
 */
@Entity
@Table(name = "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByNip", query = "SELECT p FROM Persona p WHERE p.nip = :nip")
    , @NamedQuery(name = "Persona.findByNombreCompleto", query = "SELECT p FROM Persona p WHERE p.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Persona.findByEps", query = "SELECT p FROM Persona p WHERE p.eps = :eps")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByPlacaAgente", query = "SELECT p FROM Persona p WHERE p.placaAgente = :placaAgente")})
@XmlRootElement
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NIP")
    private String nip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EPS")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "PLACA_AGENTE")
    private BigInteger placaAgente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaNip")
    private List<Testigos> testigosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<InformeAccidenteTransito> informeAccidenteTransitoList;
    @JoinColumn(name = "MUNICIPIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    @JoinColumn(name = "TIPO_DOCUMENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaNip")
    private List<Perjudicados> perjudicadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaNip")
    private List<Tramite> tramiteList;
    @OneToMany(mappedBy = "receptor")
    private List<Tramite> tramiteList1;
    @OneToMany(mappedBy = "testigo")
    private List<Comparendo> comparendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infractor", fetch = FetchType.LAZY)
    private List<Comparendo> comparendoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<Comparendo> comparendoList2;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona1")
    private Licencia licencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaNip")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaNip")
    private List<HistorialDueno> historialDuenoList;

    public Persona() {
    }

    public Persona(String nip) {
        this.nip = nip;
    }

    public Persona(String nip, String nombreCompleto, Date fechaNacimiento, String direccion, String eps, String telefono) {
        this.nip = nip;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.eps = eps;
        this.telefono = telefono;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigInteger getPlacaAgente() {
        return placaAgente;
    }

    public void setPlacaAgente(BigInteger placaAgente) {
        this.placaAgente = placaAgente;
    }

    @XmlTransient
    public List<Testigos> getTestigosList() {
        return testigosList;
    }

    public void setTestigosList(List<Testigos> testigosList) {
        this.testigosList = testigosList;
    }

    @XmlTransient
    public List<InformeAccidenteTransito> getInformeAccidenteTransitoList() {
        return informeAccidenteTransitoList;
    }

    public void setInformeAccidenteTransitoList(List<InformeAccidenteTransito> informeAccidenteTransitoList) {
        this.informeAccidenteTransitoList = informeAccidenteTransitoList;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public List<Perjudicados> getPerjudicadosList() {
        return perjudicadosList;
    }

    public void setPerjudicadosList(List<Perjudicados> perjudicadosList) {
        this.perjudicadosList = perjudicadosList;
    }

    @XmlTransient
    public List<Tramite> getTramiteList() {
        return tramiteList;
    }

    public void setTramiteList(List<Tramite> tramiteList) {
        this.tramiteList = tramiteList;
    }

    @XmlTransient
    public List<Tramite> getTramiteList1() {
        return tramiteList1;
    }

    public void setTramiteList1(List<Tramite> tramiteList1) {
        this.tramiteList1 = tramiteList1;
    }

    @XmlTransient
    public List<Comparendo> getComparendoList() {
        return comparendoList;
    }

    public void setComparendoList(List<Comparendo> comparendoList) {
        this.comparendoList = comparendoList;
    }

    @XmlTransient
    public List<Comparendo> getComparendoList1() {
        return comparendoList1;
    }

    public void setComparendoList1(List<Comparendo> comparendoList1) {
        this.comparendoList1 = comparendoList1;
    }

    @XmlTransient
    public List<Comparendo> getComparendoList2() {
        return comparendoList2;
    }

    public void setComparendoList2(List<Comparendo> comparendoList2) {
        this.comparendoList2 = comparendoList2;
    }

    @XmlTransient
    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<HistorialDueno> getHistorialDuenoList() {
        return historialDuenoList;
    }

    public void setHistorialDuenoList(List<HistorialDueno> historialDuenoList) {
        this.historialDuenoList = historialDuenoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nip != null ? nip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.nip == null && other.nip != null) || (this.nip != null && !this.nip.equals(other.nip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Persona[ nip=" + nip + " ]";
    }
    
}
