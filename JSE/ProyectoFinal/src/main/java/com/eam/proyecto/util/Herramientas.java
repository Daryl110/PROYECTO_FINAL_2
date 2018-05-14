/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class Herramientas {

    //Metodo para obtener ip local
    public String traerIPLocal() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
            for (; n.hasMoreElements();) {
                NetworkInterface e = n.nextElement();

                Enumeration<InetAddress> a = e.getInetAddresses();
                for (; a.hasMoreElements();) {
                    InetAddress addr = a.nextElement();
                    if (e.getDisplayName().equals("Realtek RTL8723AE Wireless LAN 802.11n PCI-E NIC")
                            || e.getDisplayName().equals("Realtek PCIe GBE Family Controller") ||
                            e.getDisplayName().equalsIgnoreCase("Qualcomm Atheros QCA9377 Wireless Network Adapter")) {
                        if (addr.getHostAddress().contains(".")) {
                            ip = addr.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(Herramientas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }
    
    //Metodos para partir una fecha

    public int obtenerAnio(Date fecha) {
        if (fecha == null) {
            return 0;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            return Integer.parseInt(dateFormat.format(fecha));
        }
    }
    public int obtenerMes(Date fecha) {
        if (fecha == null) {
            return 0;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
            return Integer.parseInt(dateFormat.format(fecha));
        }
    }
    public int obtenerDia(Date fecha) {
        if (fecha == null) {
            return 0;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
            return Integer.parseInt(dateFormat.format(fecha));
        }
    }
    
    public JSONObject jsonStringToObject(String json){
        try {
            return (JSONObject)(new JSONParser().parse(json));
        } catch (ParseException ex) {
            System.out.println("[Error] : "+ex);
        }
        return null;
    }
}
