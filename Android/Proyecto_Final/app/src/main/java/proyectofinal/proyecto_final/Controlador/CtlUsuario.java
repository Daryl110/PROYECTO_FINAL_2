package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Toast;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CtlUsuario extends ControladorAbstracto {

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
    public JSONObject buscar(Object id, String entidad) {
        return null;
    }

    @Override
    public boolean eliminar(Object id, String entidad) {
        return false;
    }
}
