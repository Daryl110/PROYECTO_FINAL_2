/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
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

    public static ArrayList<String> listaGenrica;

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
                listaGenrica = new ArrayList<>();
            }
            JSONArray tiposDoc = ((JSONArray) (new JSONParser().parse(response)));
            combo.addItem(primerMensaje);
            for (int i = 0; i < tiposDoc.size(); i++) {
                JSONObject jsonObj = (JSONObject) tiposDoc.get(i);
                if (ws.equals("Persona/")) {
                    listaGenrica.add(jsonObj.get("nip").toString());
                    combo.addItem(jsonObj.get(quieroVizualizar).toString() + " - " + jsonObj.get("nip").toString());
                } else {
                    combo.addItem(jsonObj.get(quieroVizualizar).toString());
                }
            }
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
    }

    private ArrayList<String> cargarLista(String ws, String concatenarUno, String concatenarDos) {
        ArrayList<String> listaArray = new ArrayList<>();
        try {
            String response = this.traerlistar(ws);
            JSONArray lista = ((JSONArray) (new JSONParser().parse(response)));
            for (int i = 0; i < lista.size(); i++) {
                JSONObject jsonObj = (JSONObject) lista.get(i);
                listaArray.add(jsonObj.get(concatenarUno).toString() + " - " + jsonObj.get(concatenarDos).toString());
            }

        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        }
        return listaArray;
    }

    public DefaultListModel<String> modelList(String ws, String concatenarUno, String concatenarDos) {
        DefaultListModel<String> model = new DefaultListModel<>();
        ArrayList<String> listaArray = this.cargarLista(ws, concatenarUno, concatenarDos);
        listaArray.forEach((string) -> {
            model.addElement(string.toUpperCase());
        });
        return model;
    }

    public void modeloListaFiltrado(JList<String> lst,String texto) {
        DefaultListModel<String> model = new DefaultListModel<>();
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < lst.getModel().getSize(); i++) {
            lista.add(lst.getModel().getElementAt(i));
        }
        lista.stream().filter((lista1) -> (lista1.contains(texto))).forEachOrdered((lista1) -> {
            model.addElement(lista1);
        });
        lst.setModel(model);
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
