/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class CtlComboBox extends ControladorAbstracto {

    public static ArrayList<String> nipPersonas;

    public void cargarTipoDocumeto(JComboBox cbTipoDocumento) {
        this.cargarCb(cbTipoDocumento, "Seleccione un tipo de documento", "TipoDocumento/", "nombre");
    }

    public void cargarMunicipio(JComboBox cbMunicipio) {
        this.cargarCb(cbMunicipio, "Seleccione un municipio", "Municipio/", "nombre");
    }
    
    public void cargarPersonas(JComboBox cbPersona) {
        this.cargarCb(cbPersona, "Seleccione una persona", "Persona/", "nombreCompleto");
    }
    
    public void cargarPreguntasS(JComboBox cbValidacion) {
        this.cargarCb(cbValidacion, "Seleccione una pregunta de seguridad", "Validacion/", "descripcion");
    }

    public void cargarEps(JComboBox cbEps) {
        cbEps.removeAllItems();
        cbEps.addItem("Seleccione una EPS");
        cbEps.addItem("Cafesalud");
        cbEps.addItem("Nueva EPS");
        cbEps.addItem("Sanitas");
        cbEps.addItem("SaludCoop");
        cbEps.addItem("Golden Group");
        cbEps.addItem("Coomeva");
    }
    
    public void cargarTipoUsuario(JComboBox cbTipoUsuario) {
        cbTipoUsuario.removeAllItems();
        cbTipoUsuario.addItem("Seleccione un tipo usuario");
        cbTipoUsuario.addItem("Ciudadano");
        cbTipoUsuario.addItem("Agente");
        cbTipoUsuario.addItem("Funcionario");
    }

    private void cargarCb(JComboBox combo, String primerMensaje, String ws, String quieroVizualizar) {
        try {
            combo.removeAllItems();
            String response = this.traerlistar(ws);
            if (ws.equals("Persona/")) {
                nipPersonas = new ArrayList<>();
            }
            JSONArray tiposDoc = ((JSONArray) (new JSONParser().parse(response)));
            combo.addItem(primerMensaje);
            for (int i = 0; i < tiposDoc.size(); i++) {
                JSONObject jsonObj = (JSONObject) tiposDoc.get(i);
                if (ws.equals("Persona/")) {
                    nipPersonas.add(jsonObj.get("nip").toString());
                    combo.addItem(jsonObj.get(quieroVizualizar).toString()+" - "+jsonObj.get("nip").toString());
                }else{
                    combo.addItem(jsonObj.get(quieroVizualizar).toString());
                }
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
    }

    @Override
    public DefaultTableModel listar(String entidad) {
        System.out.println("[Error] : Este metodo no esta implementado para esta clase");
        return null;
    }

    @Override
    public JSONObject buscar(Object id, String entidad) {
        System.out.println("[Error] : Este metodo no esta implementado para esta clase");
        return null;
    }

    @Override
    public boolean eliminar(Object id, String entidad) {
        System.out.println("[Error] : Este metodo no esta implementado para esta clase");
        return false;
    }
}
