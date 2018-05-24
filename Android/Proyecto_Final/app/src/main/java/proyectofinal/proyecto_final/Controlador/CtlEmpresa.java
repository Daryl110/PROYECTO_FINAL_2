package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Toast;

import org.json.simple.JSONObject;

public class CtlEmpresa extends Cliente {

    private Activity activity;

    public CtlEmpresa(Activity activity) {
        this.activity = activity;
    }

    public void registrar(String nit,String nombre) {

        try {
            JSONObject request = new JSONObject();
            request.put("nit", nit);
            request.put("nombre", nombre);

            this.registrar("La Empresa", request, activity);

        } catch (Exception ex) {
            Toast.makeText(this.activity, "La empresa no se pudo registrar", Toast.LENGTH_SHORT).show();
        }
    }
}
