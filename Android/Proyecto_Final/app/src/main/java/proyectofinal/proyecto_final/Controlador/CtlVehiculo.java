package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Toast;

import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CtlVehiculo extends Cliente {

    private Activity activity;

    public CtlVehiculo(Activity activity) {
        this.activity = activity;
    }

    public void registrar(String claseVehiculo, String tipoVehiculo, String placa, String modelo, String linea
            , String marca, String lugarMatricula, String nacionalidad, int capacidad, int numeroPasajeros, int tarjetaOperacion,
                          String nitEmpresa,String numeroLicencia) {

        try {
            JSONObject request = new JSONObject();
            request.put("capacidadCarga", capacidad);
            request.put("claseVehiculo", claseVehiculo);
            request.put("licenciaTransito", numeroLicencia);
            if (nitEmpresa != null){
                request.put("empresaNit",this.traerBD("Empresa",nitEmpresa));
                request.put("noTargetaOperacion",tarjetaOperacion);
            }
            request.put("linea", linea);
            request.put("lugarMatricula", lugarMatricula);
            request.put("marca", marca);
            request.put("modelo", modelo);
            request.put("nacionalidad", nacionalidad);
            request.put("numeroPasajeros", numeroPasajeros);
            request.put("placa", placa);
            request.put("tipoVehiculo", tipoVehiculo);

            this.registrar("El Vehiculo", request, activity);

        } catch (Exception ex) {
            Toast.makeText(this.activity, "El vehiculo no se pudo registrar", Toast.LENGTH_SHORT).show();
        }
    }
}
