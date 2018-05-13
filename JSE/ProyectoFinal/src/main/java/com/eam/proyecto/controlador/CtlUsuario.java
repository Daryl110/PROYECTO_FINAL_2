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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class CtlUsuario extends ICTL {

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
            URL api = new URL(this.url + "Sesion/");
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

            HttpURLConnection conexion = (HttpURLConnection) api.openConnection();

            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("Content-Length", String.valueOf(postDataEnBytes.length));
            conexion.setDoOutput(true);
            conexion.getOutputStream().write(postDataEnBytes);

            Reader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
            String respuestaJson = "";

            for (int i = entrada.read(); i != -1; i = entrada.read()) {
                respuestaJson += (char) i;
            }

            JSONObject objRespuesta = ((JSONObject) (new JSONParser().parse(respuestaJson)));

            return objRespuesta;

        } catch (MalformedURLException | UnsupportedEncodingException ex) {
            return null;
        } catch (IOException | ParseException ex) {
            return null;
        }
    }

}
