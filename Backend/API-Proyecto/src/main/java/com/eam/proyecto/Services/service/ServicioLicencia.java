/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Services.Estructura.EstructuraRestFul;
import com.eam.proyecto.DTO.Licencia;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daryl Ospina
 */
@Path("Licencia")
public class ServicioLicencia extends EstructuraRestFul<Licencia> {
    
    public ServicioLicencia() {
        super(Licencia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response guardar(Licencia entity) {
        return super.guardar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") String id, Licencia entity) {
        return super.modificar(entity);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response remove(@PathParam("id") String id) {
        return super.eliminar(super.buscar(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Licencia find(@PathParam("id") String id) {
        return super.buscar(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Licencia> listar() {
        return super.listar();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Licencia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.buscarRango(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.contar());
    }
    
}
