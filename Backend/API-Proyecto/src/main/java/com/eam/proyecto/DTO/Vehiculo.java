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
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculo.findByLinea", query = "SELECT v FROM Vehiculo v WHERE v.linea = :linea")
    , @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculo.findByLicenciaTransito", query = "SELECT v FROM Vehiculo v WHERE v.licenciaTransito = :licenciaTransito")
    , @NamedQuery(name = "Vehiculo.findByClaseVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.claseVehiculo = :claseVehiculo")
    , @NamedQuery(name = "Vehiculo.findByTipoVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.tipoVehiculo = :tipoVehiculo")
    , @NamedQuery(name = "Vehiculo.findByLugarMatricula", query = "SELECT v FROM Vehiculo v WHERE v.lugarMatricula = :lugarMatricula")
    , @NamedQuery(name = "Vehiculo.findByNacionalidad", query = "SELECT v FROM Vehiculo v WHERE v.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculo.findByCapacidadCarga", query = "SELECT v FROM Vehiculo v WHERE v.capacidadCarga = :capacidadCarga")
    , @NamedQuery(name = "Vehiculo.findByNumeroPasajeros", query = "SELECT v FROM Vehiculo v WHERE v.numeroPasajeros = :numeroPasajeros")
    , @NamedQuery(name = "Vehiculo.findByNoTargetaOperacion", query = "SELECT v FROM Vehiculo v WHERE v.noTargetaOperacion = :noTargetaOperacion")})
@XmlRootElement
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 20)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 20)
    @Column(name = "LINEA")
    private String linea;
    @Size(max = 20)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 20)
    @Column(name = "LICENCIA_TRANSITO")
    private String licenciaTransito;
    @Size(max = 20)
    @Column(name = "CLASE_VEHICULO")
    private String claseVehiculo;
    @Size(max = 20)
    @Column(name = "TIPO_VEHICULO")
    private String tipoVehiculo;
    @Size(max = 20)
    @Column(name = "LUGAR_MATRICULA")
    private String lugarMatricula;
    @Size(max = 20)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Size(max = 20)
    @Column(name = "COLOR")
    private String color;
    @Column(name = "CAPACIDAD_CARGA")
    private BigInteger capacidadCarga;
    @Column(name = "NUMERO_PASAJEROS")
    private BigInteger numeroPasajeros;
    @Column(name = "NO_TARGETA_OPERACION")
    private BigInteger noTargetaOperacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private PolizaSeguro polizaSeguro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private VehiculoTramite vehiculoTramite;
    @JoinColumn(name = "EMPRESA_NIT", referencedColumnName = "NIT")
    @ManyToOne
    private Empresa empresaNit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<Comparendo> comparendoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<VehiculosAfectados> vehiculosAfectadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlaca")
    private List<HistorialDueno> historialDuenoList;

    public Vehiculo() {
    }

    public Vehiculo(String placa) {
        this.placa = placa;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLicenciaTransito() {
        return licenciaTransito;
    }

    public void setLicenciaTransito(String licenciaTransito) {
        this.licenciaTransito = licenciaTransito;
    }

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getLugarMatricula() {
        return lugarMatricula;
    }

    public void setLugarMatricula(String lugarMatricula) {
        this.lugarMatricula = lugarMatricula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigInteger getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(BigInteger capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
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

    public PolizaSeguro getPolizaSeguro() {
        return polizaSeguro;
    }

    public void setPolizaSeguro(PolizaSeguro polizaSeguro) {
        this.polizaSeguro = polizaSeguro;
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
