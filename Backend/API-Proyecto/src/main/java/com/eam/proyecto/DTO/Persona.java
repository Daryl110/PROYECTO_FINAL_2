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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
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
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 20)
    @Column(name = "EPS")
    private String eps;
    @Column(name = "PLACA")
    private BigInteger placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<Testigos> testigosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<InformeAccidenteTransito> informeAccidenteTransitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<HistorialDuenio> historialDuenioList;
    @JoinColumn(name = "MUNICIPIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Municipio municipioId;
    @JoinColumn(name = "TIPO_DOCUMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumentoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<Perjudicados> perjudicadosList;
    @OneToMany(mappedBy = "personaId")
    private List<Tramite> tramiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuidadano")
    private List<Comparendo> comparendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
    private List<Comparendo> comparendoList1;
    @OneToMany(mappedBy = "testigo")
    private List<Comparendo> comparendoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<Usuario> usuarioList;

    public Persona() {
    }

    public Persona(String nip) {
        this.nip = nip;
    }

    public Persona(String nip, String nombreCompleto, String direccion, String telefono) {
        this.nip = nip;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
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

    public BigInteger getPlaca() {
        return placa;
    }

    public void setPlaca(BigInteger placa) {
        this.placa = placa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @XmlTransient
    public List<HistorialDuenio> getHistorialDuenioList() {
        return historialDuenioList;
    }

    public void setHistorialDuenioList(List<HistorialDuenio> historialDuenioList) {
        this.historialDuenioList = historialDuenioList;
    }

    public Municipio getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Municipio municipioId) {
        this.municipioId = municipioId;
    }

    public TipoDocumento getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(TipoDocumento tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
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
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
