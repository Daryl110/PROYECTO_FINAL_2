package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Toast;

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

    public void registrar(int id,int municipio,
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
            municipioId = this.traerBD("Municipio",municipio);
            request.put("municipioId", municipioId);
            infractor = this.traerBD("Persona",nipInfractor);
            request.put("infractor", infractor);
            agente = this.traerBD("Persona",nipAgente);
            request.put("agente", agente);
            if (nipTestigo != null){
                testigo = this.traerBD("Persona",nipTestigo);
                request.put("testigo", testigo);
            }
            request.put("radioAccion", radio);
            tipoInfraccionId = this.traerBD("TipoInfraccion",tipoInfraccion);
            request.put("tipoInfraccionCodigo", tipoInfraccionId);
            request.put("tipoInfractor", tipoInfractor);
            vehiculo = this.traerBD("Vehiculo",placaVehiculo);
            request.put("vehiculoPlaca", vehiculo);
            request.put("viaPrincipal", viaPrincipal);
            request.put("viaSecundaria", viaSecundaria);
            request.put("estado","HABILITADO");

            this.registrar("El Comparendo",request,activity);

        }catch(Exception ex){
            Toast.makeText(this.activity,"El comparendo no se pudo registrar",Toast.LENGTH_LONG).show();
        }
    }
}
