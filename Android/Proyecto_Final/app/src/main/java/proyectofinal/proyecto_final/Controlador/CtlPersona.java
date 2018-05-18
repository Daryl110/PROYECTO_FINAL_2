package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CtlPersona extends Cliente{

    private Activity activity;

    public CtlPersona(Activity activity){
        this.activity = activity;
    }

    public boolean registrar(String nip, String nombreCompleto, String direccion, String telefono, String eps,
                             int tipoDocumento, int municipio, Date fechaN){
        try {
            JSONObject request = new JSONObject(), tipoDocumentoId = new JSONObject(), municipioId = new JSONObject();
            request.put("direccion", direccion);
            request.put("eps", eps);
            request.put("fechaNacimiento", (new SimpleDateFormat("yyyy-MM-dd").format(fechaN))+"T00:00:00-05:00");
            municipioId = this.traerBD("Municipio",this.activity,municipio);
            request.put("municipioId", municipioId);
            request.put("nip", nip);
            request.put("nombreCompleto", nombreCompleto);
            request.put("telefono", telefono);
            tipoDocumentoId = this.traerBD("TipoDocumento",this.activity,tipoDocumento);
            request.put("tipoDocumento", tipoDocumentoId);

            this.registrar("Persona",request,activity);

            return true;
        }catch(Exception ex){
            return false;
        }
    }


}
