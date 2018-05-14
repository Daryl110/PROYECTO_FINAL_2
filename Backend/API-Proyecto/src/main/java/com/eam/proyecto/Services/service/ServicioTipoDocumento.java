/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Services.Estructura.EstructuraRestFul;
import com.eam.proyecto.DTO.TipoDocumento;
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

/**
 *
 * @author Daryl Ospina
 */
@Path("TipoDocumento")
public class ServicioTipoDocumento extends EstructuraRestFul<TipoDocumento> {
    
    public ServicioTipoDocumento() {
        super(TipoDocumento.class);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TipoDocumento find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoDocumento> findAll() {
        return super.findAll();
    }
    
}
