package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;

import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CtlComparendo extends Cliente {

    private Activity activity;

    public CtlComparendo(Activity activity){
        this.activity = activity;
    }

    public int asignarId(String entidad){
        return this.numeroRegistros(entidad,this.activity)+1;
    }

    public boolean registrar(int id,int municipio,
            Date fecha,
            String localidad,String viaPrincipal,String viaSecundaria,String descripcion,
                             String modalidad,String radio,String tipoInfractor,
                             String placaVehiculo,String nipTestigo,String nipAgente,
                             String nipInfractor,String tipoInfraccion){
        try {
            JSONObject request = new JSONObject(), testigo = new JSONObject(), agente = new JSONObject(),
                infractor = new JSONObject(),vehiculo = new JSONObject(),tipoInfraccionId = new JSONObject(),
                municipioId = new JSONObject();

            request.put("descripcion", descripcion);
            request.put("fecha", (new SimpleDateFormat("yyyy-MM-dd").format(fecha))+"T00:00:00-05:00");
            request.put("id", id);
            request.put("localidadComuna", localidad);
            request.put("modalidadTransporte", modalidad);
            municipioId = this.traerBD("Municipio",this.activity,municipio);
            request.put("municipioId", municipioId);
            infractor = this.traerBD("Persona",this.activity,nipInfractor);
            request.put("personaNip", infractor);
            agente = this.traerBD("Persona",this.activity,nipAgente);
            request.put("personaNip1", agente);
            testigo = this.traerBD("Persona",this.activity,nipTestigo);
            request.put("personaNip2", testigo);
            request.put("radioAccion", radio);
            tipoInfraccionId = this.traerBD("TipoInfraccion",this.activity,tipoInfraccion);
            request.put("tipoInfraccionCodigo", tipoInfraccionId);
            request.put("tipoInfractor", tipoInfractor);
            vehiculo = this.traerBD("Vehiculo",this.activity,placaVehiculo);
            request.put("vehiculoPlaca", vehiculo);
            request.put("viaPrincipal", viaPrincipal);
            request.put("viaSecundaria", viaSecundaria);

            this.registrar("Comparendo",request,activity);

            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
