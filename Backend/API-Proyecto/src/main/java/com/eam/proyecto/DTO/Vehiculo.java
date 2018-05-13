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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "VEHICULO")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")})
@XmlRootElement
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 10)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 10)
    @Column(name = "LINEA")
    private String linea;
    @Column(name = "CAPACIDAD_CARGA")
    private BigInteger capacidadCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LICENCIA_TRANSITO")
    private String licenciaTransito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLASE_VEHICULO_ID")
    private String claseVehiculoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LUGAR_MATRICULA")
    private String lugarMatricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_VEHICULO_ID")
    private String tipoVehiculoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Size(max = 20)
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "NUMERO_PASAJEROS")
    private BigInteger numeroPasajeros;
    @Column(name = "NO_TARGETA_OPERACION")
    private BigInteger noTargetaOperacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<PolizaSeguro> polizaSeguroList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private VehiculoTramite vehiculoTramite;
    @JoinColumn(name = "EMPRESA_NIT", referencedColumnName = "NIT")
    @ManyToOne
    private Empresa empresaNit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<HistorialDuenio> historialDuenioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<Colores> coloresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<Comparendo> comparendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<VehiculosAfectados> vehiculosAfectadosList;

    public Vehiculo() {
    }

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public Vehiculo(String placa, String licenciaTransito, String claseVehiculoId, String lugarMatricula, String tipoVehiculoId, String nacionalidad) {
        this.placa = placa;
        this.licenciaTransito = licenciaTransito;
        this.claseVehiculoId = claseVehiculoId;
        this.lugarMatricula = lugarMatricula;
        this.tipoVehiculoId = tipoVehiculoId;
        this.nacionalidad = nacionalidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public BigInteger getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(BigInteger capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getLicenciaTransito() {
        return licenciaTransito;
    }

    public void setLicenciaTransito(String licenciaTransito) {
        this.licenciaTransito = licenciaTransito;
    }

    public String getClaseVehiculoId() {
        return claseVehiculoId;
    }

    public void setClaseVehiculoId(String claseVehiculoId) {
        this.claseVehiculoId = claseVehiculoId;
    }

    public String getLugarMatricula() {
        return lugarMatricula;
    }

    public void setLugarMatricula(String lugarMatricula) {
        this.lugarMatricula = lugarMatricula;
    }

    public String getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(String tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigInteger getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(BigInteger numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public BigInteger getNoTargetaOperacion() {
        return noTargetaOperacion;
    }

    public void setNoTargetaOperacion(BigInteger noTargetaOperacion) {
        this.noTargetaOperacion = noTargetaOperacion;
    }

    @XmlTransient
    public List<PolizaSeguro> getPolizaSeguroList() {
        return polizaSeguroList;
    }

    public void setPolizaSeguroList(List<PolizaSeguro> polizaSeguroList) {
        this.polizaSeguroList = polizaSeguroList;
    }

    public VehiculoTramite getVehiculoTramite() {
        return vehiculoTramite;
    }

    public void setVehiculoTramite(VehiculoTramite vehiculoTramite) {
        this.vehiculoTramite = vehiculoTramite;
    }

    public Empresa getEmpresaNit() {
        return empresaNit;
    }

    public void setEmpresaNit(Empresa empresaNit) {
        this.empresaNit = empresaNit;
    }

    @XmlTransient
    public List<HistorialDuenio> getHistorialDuenioList() {
        return historialDuenioList;
    }

    public void setHistorialDuenioList(List<HistorialDuenio> historialDuenioList) {
        this.historialDuenioList = historialDuenioList;
    }

    @XmlTransient
    public List<Colores> getColoresList() {
        return coloresList;
    }

    public void setColoresList(List<Colores> coloresList) {
        this.coloresList = coloresList;
    }

    @XmlTransient
    public List<Comparendo> getComparendoList() {
        return comparendoList;
    }

    public void setComparendoList(List<Comparendo> comparendoList) {
        this.comparendoList = comparendoList;
    }

    @XmlTransient
    public List<VehiculosAfectados> getVehiculosAfectadosList() {
        return vehiculosAfectadosList;
    }

    public void setVehiculosAfectadosList(List<VehiculosAfectados> vehiculosAfectadosList) {
        this.vehiculosAfectadosList = vehiculosAfectadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.proyecto.DTO.Vehiculo[ placa=" + placa + " ]";
    }
    
}
