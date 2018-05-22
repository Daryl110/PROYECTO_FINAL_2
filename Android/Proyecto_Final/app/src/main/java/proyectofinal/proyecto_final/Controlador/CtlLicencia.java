package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Toast;

import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CtlLicencia extends Cliente {

    private Activity activity;

    public CtlLicencia(Activity activity){
        this.activity = activity;
    }

    public void registrar(String numeroLicencia,String oficina,String categoria,String nipPersona,Date fechaExp,Date fechaVen){
        try {
            JSONObject request = new JSONObject(), persona = new JSONObject();
            request.put("categoriaLicencia", categoria);
            request.put("fechaExpedicion", (new SimpleDateFormat("yyyy-MM-dd").format(fechaExp))+"T00:00:00-05:00");
            request.put("fechaVencimiento", (new SimpleDateFormat("yyyy-MM-dd").format(fechaVen))+"T00:00:00-05:00");
            request.put("numeroLicencia", numeroLicencia);
            request.put("oficinaTransito", oficina);
            request.put("persona",nipPersona);
            persona = this.traerBD("Persona",nipPersona);
            request.put("persona1", persona);

            this.registrar("La Licencia",request,activity);

        }catch(Exception ex){
            Toast.makeText(activity, "No se ha podido registrar la licencia", Toast.LENGTH_SHORT).show();
        }
    }
}
