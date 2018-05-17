package com.eam.proyecto.Services.service;

import com.eam.proyecto.DTO.Administrador;
import com.eam.proyecto.DTO.Usuario;
import com.eam.proyecto.util.Herramientas;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
    public Response iniciarSesion(String json) {
        try {
            String jsonDecodificada = URLDecoder.decode(json, "UTF-8"),jsonTransformado = jsonDecodificada,
                    cedula = "";

            if (jsonTransformado.contains("=")) {
                jsonTransformado = jsonDecodificada.split("=")[1];
            }
            
            JSONObject obj = (JSONObject) new JSONParser().parse(jsonTransformado),
                    objRespuesta = new JSONObject();

            ServicioAdministrador serviceAdmin = new ServicioAdministrador();
            ServicioUsuario serviceUsuario = new ServicioUsuario();

            ArrayList<Administrador> admins = new ArrayList<>(serviceAdmin.findAll());
            ArrayList<Usuario> usus = new ArrayList<>(serviceUsuario.findAll());

            boolean acceso = false;
            String rol = "";

            for (Administrador admin : admins) {
                if (admin.getUsuario().equals(obj.get("nombreUsuario").toString())
                        && admin.getContrasena().equals(obj.get("contrasenia"))) {
                    acceso = true;
                    rol = "Administrador";
                    cedula = "No posee cedula";
                }
            }

            for (Usuario usu : usus) {
                if (usu.getNombreUsuario().equals(obj.get("nombreUsuario").toString())
                        && usu.getPassword().equals(obj.get("contrasenia"))) {
                    acceso = true;
                    rol = usu.getTipoUsuario();
                    cedula = usu.getPersonaNip().getNip();
                }
            }

            objRespuesta.put("Acceso", acceso);
            objRespuesta.put("Rol", rol);
            objRespuesta.put("Cedula", cedula);
            return Herramientas.construirResponse(objRespuesta.toString());

        } catch (UnsupportedEncodingException | ParseException ex) {
            return null;
        }
    }
}
