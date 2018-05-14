/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

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
public class CtlComboBox extends ControladorAbstracto{

    public void cargarTipoDocumeto(JComboBox cbTipoDocumento) {
        this.cargarCb(cbTipoDocumento, "Seleccione un tipo de documento", "TipoDocumento/");
    }
    
    public void cargarMunicipio(JComboBox cbMunicipio){
        this.cargarCb(cbMunicipio, "Seleccione un municipio", "Municipio/");
    }
    
    public void cargarEps(JComboBox cbEps){
        cbEps.addItem("Seleccione una EPS");
        cbEps.addItem("Cafesalud");
        cbEps.addItem("Nueva EPS");
        cbEps.addItem("Sanitas");
        cbEps.addItem("SaludCoop");
        cbEps.addItem("Golden Group");
        cbEps.addItem("Coomeva");
    }

    private void cargarCb(JComboBox combo, String primerMensaje, String ws) {
        try {
            String response = this.traerlistar(ws);
            JSONArray tiposDoc = ((JSONArray) (new JSONParser().parse(response)));
            combo.addItem(primerMensaje);
            tiposDoc.forEach((obj) -> {
                JSONObject jsonObj = (JSONObject) obj;
                combo.addItem(jsonObj.get("nombre").toString());
            });
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
