package proyectofinal.proyecto_final.Controlador;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class ControladorAbstracto {

    private final String url = "http://localhost:8080/API-Proyecto/Recursos/";

    protected Client cliente = ClientBuilder.newClient();

    protected String conectarConAPI(String ws, String metodo, String contentData, byte[] postDataEnBytes) {
        try {
            URL api = new URL(this.url + ws);
            HttpURLConnection conexion = (HttpURLConnection) api.openConnection();
            conexion.setRequestMethod(metodo);
            conexion.setRequestProperty("Content-Type", contentData);
            if (metodo.equals("POST")) {
                conexion.setRequestProperty("Content-Length", String.valueOf(postDataEnBytes.length));
                conexion.setDoOutput(true);
                conexion.getOutputStream().write(postDataEnBytes);
            }
            Reader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
            String respuestaJson = "";

            for (int i = entrada.read(); i != -1; i = entrada.read()) {
                respuestaJson += (char) i;
            }
            return respuestaJson;
        } catch (MalformedURLException ex) {
            return "";
        } catch (IOException ex) {
            return "";
        }
    }

    protected String traerlistar(String ws){
        return this.conectarConAPI(ws, "GET", "application/json", null);
    }

    //public abstract DefaultTableModel listar(String entidad);

    protected Response registrar(String json, String entidad){
        return cliente.target(this.url + entidad+"/").request(MediaType.APPLICATION_JSON).post(Entity.json(json));
    }

    protected Response modificar(String json,String entidad,Object id){
        return cliente.target(this.url + entidad+"/"+id).request(MediaType.APPLICATION_JSON).put(Entity.json(json));
    }

    public abstract JSONObject buscar(Object id, String entidad);

    public abstract boolean eliminar(Object id,String entidad);
}
