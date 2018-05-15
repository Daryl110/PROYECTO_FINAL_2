/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import com.eam.proyecto.vista.FrmAdministrador;
import com.eam.proyecto.vista.FrmAgente;
import com.eam.proyecto.vista.FrmCiudadano;
import com.eam.proyecto.vista.FrmFuncionario;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class CtlUsuario extends ControladorAbstracto {

    public void iniciarVentana(JFrame padre, String rol) {
        padre.dispose();
        switch (rol) {
            case "Administrador":
                FrmAdministrador ventanaAdministrador = new FrmAdministrador();
                ventanaAdministrador.setLocationRelativeTo(null);
                ventanaAdministrador.setVisible(true);
                return;
            case "Ciudadano":
                FrmCiudadano ventanaCiudadano = new FrmCiudadano();
                ventanaCiudadano.setLocationRelativeTo(null);
                ventanaCiudadano.setVisible(true);
                return;
            case "Funcionario":
                FrmFuncionario ventanaFuncionario = new FrmFuncionario();
                ventanaFuncionario.setLocationRelativeTo(null);
                ventanaFuncionario.setVisible(true);
                return;
            case "Agente":
                FrmAgente ventanaAgente = new FrmAgente();
                ventanaAgente.setLocationRelativeTo(null);
                ventanaAgente.setVisible(true);
                return;
            default:
                JOptionPane.showMessageDialog(padre, "El rol al que desea acceder no existe");
        }
    }

    public JSONObject iniciarSesion(String nombreUsaurio, String contrasenia) {
        try {
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("validacion", "{\"nombreUsuario\":\"" + nombreUsaurio + "\",\"contrasenia\":\"" + contrasenia + "\"}");

            StringBuilder postData = new StringBuilder();
            
            for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
                postData.append('?');
                postData.append(URLEncoder.encode(parametro.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(parametro.getValue()) + "", "UTF-8"));
            }
            byte[] postDataEnBytes = postData.toString().getBytes("UTF-8");
            
            String respuestaJson = this.conectarConAPI("Sesion/", "POST", "application/json", postDataEnBytes);

            JSONObject objRespuesta = ((JSONObject) (new JSONParser().parse(respuestaJson)));

            return objRespuesta;

        } catch (UnsupportedEncodingException | ParseException ex) {
            return null;
        }
    }
    
    public boolean guardar(String nombreUsuario, String contrasena, 
            String email, String respuestaS, String nipPersona,
            int preguntaS, String tipoUsuario){
        
        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(
                            this.registrar(
                                this.crearJson(nombreUsuario, 
                                        contrasena, 
                                        email, 
                                        respuestaS, 
                                        nipPersona, 
                                        preguntaS, 
                                        tipoUsuario), 
                                    "Usuario").readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }
    
    public boolean modificar(String nombreUsuario, String contrasena, 
            String email, String respuestaS, String nipPersona,
            int preguntaS, String tipoUsuario){
        
        try {

            return (boolean) ((JSONObject) 
                    (new JSONParser().parse(
                            this.modificar(
                                this.crearJson(nombreUsuario, 
                                        contrasena, 
                                        email, 
                                        respuestaS, 
                                        nipPersona, 
                                        preguntaS, 
                                        tipoUsuario), 
                                    "Usuario",nipPersona).readEntity(String.class)))).get("Resultado");

        }catch (ParseException e) {
            return false;
        }
    }

    @Override
    public DefaultTableModel listar(String entidad) {
        String[] lista = {"Nombre de usuario", "Email", "Tipo de usuario", "Nip de la persona", "Nombre de la persona"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, lista);
        try {
            String response = this.traerlistar(entidad + "/");
            JSONArray personas = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < personas.size(); i++) {
                JSONObject persona = (JSONObject) personas.get(i);
                modelo.addRow(new Object[]{
                    persona.get("nombreUsuario").toString(),
                    persona.get("email").toString(),
                    persona.get("tipoUsuario").toString(),
                    ((JSONObject) (persona.get("personaNip"))).get("nip").toString(),
                    ((JSONObject) (persona.get("personaNip"))).get("nombreCompleto").toString(),
                });
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return modelo;
    }
    
     private String crearJson(String nombreUsuario, String contrasena, 
            String email, String respuestaS, String nipPersona,
            int preguntaS, String tipoUsuario) {
        try {
            JSONObject request = new JSONObject(), validacion, persona;
            request.put("nombreUsuario", nombreUsuario);
            request.put("password", contrasena);
            if (email != null) {
                request.put("email", email);
            }else{
                request.put("email", "No se especifico E-Mail");
            }   
            persona = ((JSONObject) (new JSONParser().parse(traerlistar("Persona/" + nipPersona))));
            request.put("personaNip", persona);
            request.put("respuestaSeguridad", respuestaS);
            request.put("tipoUsuario", tipoUsuario);
            validacion = ((JSONObject) (new JSONParser().parse(traerlistar("Validacion/" + preguntaS))));
            request.put("validacionId", validacion);
            
            return request.toString();
        } catch (ParseException ex) {
            return null;
        }catch(Exception ex){
            return null;
        }
    }
}
