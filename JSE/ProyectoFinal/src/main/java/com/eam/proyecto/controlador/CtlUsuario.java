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

    @Override
    public DefaultTableModel listar(String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject buscar(Object id, String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object id, String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
