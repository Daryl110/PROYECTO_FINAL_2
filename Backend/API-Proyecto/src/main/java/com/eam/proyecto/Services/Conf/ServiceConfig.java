package com.eam.proyecto.Services.Conf;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @author Daryl Ospina
 */
@javax.ws.rs.ApplicationPath("Recursos")
public class ServiceConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.eam.proyecto.Services.service.ServicioAdministrador.class);
        resources.add(com.eam.proyecto.Services.service.ServicioAsistencia.class);
        resources.add(com.eam.proyecto.Services.service.ServicioBlindaje.class);
        resources.add(com.eam.proyecto.Services.service.ServicioCaracteristicaLugar.class);
        resources.add(com.eam.proyecto.Services.service.ServicioCaracteristicaVia.class);
        resources.add(com.eam.proyecto.Services.service.ServicioComparendo.class);
        resources.add(com.eam.proyecto.Services.service.ServicioCurso.class);
        resources.add(com.eam.proyecto.Services.service.ServicioDetalleComparendo.class);
        resources.add(com.eam.proyecto.Services.service.ServicioEmpresa.class);
        resources.add(com.eam.proyecto.Services.service.ServicioExamen.class);
        resources.add(com.eam.proyecto.Services.service.ServicioGrua.class);
        resources.add(com.eam.proyecto.Services.service.ServicioHistorialDuenio.class);
        resources.add(com.eam.proyecto.Services.service.ServicioInformeAccidente.class);
        resources.add(com.eam.proyecto.Services.service.ServicioIniciarSesion.class);
        resources.add(com.eam.proyecto.Services.service.ServicioLicencia.class);
        resources.add(com.eam.proyecto.Services.service.ServicioLugar.class);
        resources.add(com.eam.proyecto.Services.service.ServicioMunicipio.class);
        resources.add(com.eam.proyecto.Services.service.ServicioPagoComparendo.class);
        resources.add(com.eam.proyecto.Services.service.ServicioPerjudicados.class);
        resources.add(com.eam.proyecto.Services.service.ServicioPersona.class);
        resources.add(com.eam.proyecto.Services.service.ServicioPolizaSeguro.class);
        resources.add(com.eam.proyecto.Services.service.ServicioRequisitos.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTestigo.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTipoCarroceria.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTipoDocumento.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTipoInfraccion.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTipoTramite.class);
        resources.add(com.eam.proyecto.Services.service.ServicioTramite.class);
        resources.add(com.eam.proyecto.Services.service.ServicioUsuario.class);
        resources.add(com.eam.proyecto.Services.service.ServicioValidacion.class);
        resources.add(com.eam.proyecto.Services.service.ServicioValores.class);
        resources.add(com.eam.proyecto.Services.service.ServicioVehiculo.class);
        resources.add(com.eam.proyecto.Services.service.ServicioVehiculoTramite.class);
        resources.add(com.eam.proyecto.Services.service.ServicioVehiculosAfectados.class);
    }
    
}

