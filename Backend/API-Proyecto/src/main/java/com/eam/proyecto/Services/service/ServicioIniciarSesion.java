package com.eam.proyecto.Services.service;

import com.eam.proyecto.DTO.Administrador;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Daryl Ospina
 */
@Path("Sesion")
public class ServicioIniciarSesion {
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response iniciarSesion(String json){
        try {
            String jsonDecodificada = URLDecoder.decode(json, "UTF-8");
            
            JSONObject obj = (JSONObject) new JSONParser().parse(jsonDecodificada.split("=")[1]);
            System.out.println(json);
            System.out.println(jsonDecodificada);
            ServicioAdministrador admin = new ServicioAdministrador();
            List<Administrador> admins = admin.findAll();
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("True")
                    .build();
        } catch (UnsupportedEncodingException | ParseException ex) {
            return null;
        }
    }
}
