package com.eam.proyecto.controlador;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Daryl Ospina
 */
public class CtlPersona extends ControladorAbstracto {

    @Override
    public DefaultTableModel listar(String entidad) {
        String[] lista = {"Nombre", "T.Documento", "N°documento", "Municipio", "Direccion", "EPS", "Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar(entidad + "/");
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            personas.forEach((obj) -> {
                JSONObject persona = (JSONObject) obj;
                modelo.addRow(new Object[]{
                    persona.get("nombreCompleto").toString(),
                    ((JSONObject) (persona.get("tipoDocumentoId"))).get("nombre").toString(),
                    persona.get("nip").toString(),
                    ((JSONObject) (persona.get("municipioId"))).get("nombre").toString(),
                    persona.get("direccion").toString(),
                    persona.get("eps").toString(),
                    persona.get("telefono")
                });
            });
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }

    public boolean guardar(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {

        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(this.registrar(
                            this.crearJson(nombreCompleto, direccion, fechaN,
                                    numeroPlaca, eps, tipoDocId, numeroDoc, 
                                    telefono, municipioId), "Persona").readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }

    public boolean modificar(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {

        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(
                            modificar(this.crearJson(nombreCompleto, direccion,
                                    fechaN, numeroPlaca, eps, tipoDocId, numeroDoc,
                                    telefono, municipioId), "Persona",numeroDoc).readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }

    @Override
    public JSONObject buscar(Object id, String entidad) {
        try {
            String response = this.traerlistar(entidad + "/" + id);
            return ((JSONObject) (new JSONParser().parse(response)));
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public boolean eliminar(Object id, String entidad) {
        try {
            return (boolean) ((JSONObject) (new JSONParser().parse(this.conectarConAPI(entidad + "/" + id, "DELETE", "application/json", null)))).get("Resultado");
        } catch (ParseException ex) {
            return false;
        }
    }

    private String crearJson(String nombreCompleto, String direccion,
            Date fechaN, String numeroPlaca, String eps, int tipoDocId,
            String numeroDoc, String telefono, int municipioId) {
        try {
            JSONObject request = new JSONObject(), tipoDocumento, municipio;
            request.put("direccion", direccion);
            request.put("eps", eps);
            if (fechaN != null) {
                request.put("fechaNacimiento", fechaN.toString());
            }   if (numeroPlaca != null) {
                request.put("placa", Integer.parseInt(numeroPlaca));
            }   municipio = ((JSONObject) (new JSONParser().parse(traerlistar("Municipio/" + municipioId))));
            request.put("municipioId", municipio);
            request.put("nip", numeroDoc);
            request.put("nombreCompleto", nombreCompleto);
            request.put("telefono", telefono);
            tipoDocumento = ((JSONObject) (new JSONParser().parse(traerlistar("TipoDocumento/" + tipoDocId))));
            request.put("tipoDocumentoId", tipoDocumento);
            
            return request.toString();
        } catch (ParseException ex) {
            return null;
        }catch(Exception ex){
            return null;
        }
    }
}
