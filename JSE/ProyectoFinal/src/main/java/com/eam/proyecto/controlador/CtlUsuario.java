/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

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

/**
 *
 * @author Daryl Ospina
 */
public class CtlUsuario extends ICTL {

    public boolean iniciarSesion(String nombreUsaurio, String contrasenia) {
        try {
            URL api = new URL(this.url + "Sesion/");
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("validacion", "{\"nombreUsuario\":\"" + nombreUsaurio + "\",\"contrasenia\":\"" + contrasenia + "\"}");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
                postData.append('?');
                postData.append(URLEncoder.encode(parametro.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(parametro.getValue())+"", "UTF-8"));
            }
            byte[] postDataEnBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conexion = (HttpURLConnection) api.openConnection();

            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("Content-Length", String.valueOf(postDataEnBytes.length));
            conexion.setDoOutput(true);
            conexion.getOutputStream().write(postDataEnBytes);

            Reader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
            for (int i = entrada.read(); i != -1; i = entrada.read()) {
                System.out.println((char) i);
            }

            return true;
        } catch (MalformedURLException | UnsupportedEncodingException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

}
