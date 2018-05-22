/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Services.service;

import com.eam.proyecto.Services.Estructura.EstructuraRestFul;
import com.eam.proyecto.DTO.Administrador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daryl Ospina
 */
@Path("Administrador")
public class ServicioAdministrador extends EstructuraRestFul<Administrador> {

    public ServicioAdministrador() {
        super(Administrador.class);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Administrador> listar() {
        return super.listar();
    }
    
}
