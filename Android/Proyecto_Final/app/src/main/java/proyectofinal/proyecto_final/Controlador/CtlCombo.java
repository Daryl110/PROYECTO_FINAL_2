package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CtlCombo extends Cliente{

    private Activity activity;

    public CtlCombo(Activity activity) {
        this.activity = activity;
    }

    public void cargarEps(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una EPS");
        items.add("Cafesalud");
        items.add("Nueva EPS");
        items.add("Sanitas");
        items.add("SaludCoop");
        items.add("Golden Group");
        items.add("Coomeva");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarViaSecundaria(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una via secundaria");
        items.add("AV");
        items.add("CL");
        items.add("CR");
        items.add("AU");
        items.add("DG");
        items.add("TR");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarViaPrincipal(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una via principal");
        items.add("AV");
        items.add("CL");
        items.add("CR");
        items.add("AU");
        items.add("DG");
        items.add("TR");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarCategoriaLicencia(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una categoria");
        items.add("Motocicletas");
        items.add("Vehiculos de nivel 1");
        items.add("Vehiculos de nivel 2");
        items.add("Vehiculos de nivel 3");
        items.add("Vehiculos de nivel 4");
        items.add("Vehiculos de nivel 5");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarModalidad(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una modalidad");
        items.add("PASAJEROS COLECTIVO");
        items.add("PASAJEROS  INDIVIDUAL");
        items.add("PASAJEROS  MASIVO");
        items.add("PASAJEROS  ESPECIAL ESCOLAR");
        items.add("PASAJEROS  ESPECIAL ASALARIADO");
        items.add("PASAJEROS  ESPECIAL DE TURISMO");
        items.add("PASAJEROS  ESPECIAL OCASIONAL");
        items.add("MIXTO");
        items.add("CARGA");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarRadio(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione el radio de acción");
        items.add("NACIONAL");
        items.add("MUNICIPAL");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTipoInfractor(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione tipo de infractor");
        items.add("CONDUCTOR");
        items.add("PEATON");
        items.add("PASAJERO");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarClaseVehiculo(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una clase");
        items.add("Privado");
        items.add("Publico");
        items.add("Diplomatico");
        items.add("Oficial");
        items.add("Especial");
        items.add("Otros");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargarTipoVehiculo(Spinner spinner){
        List<String> items = new ArrayList<>();

        items.add("Seleccione una clase");
        items.add("Automovil");
        items.add("Bus");
        items.add("Buseta");
        items.add("Camion");
        items.add("Campero");
        items.add("Microbus");
        items.add("Tractocamion");
        items.add("Motocicleta");
        items.add("Motocarro");
        items.add("Mototriciclo");
        items.add("Cuatrimoto");
        items.add("Volqueta");
        items.add("Otro");

        ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void cargar(Spinner spinner, String entidad, String loqquierover,String primerValor){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(this.urlPeticion+entidad+"/");
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray array = ((JSONArray)(new JSONParser().parse(json)));
            List<String> items = new ArrayList<>();

            items.add(primerValor);

            for (int i = 0;i < array.size();i++) {
                JSONObject obj = ((JSONObject) (array.get(i)));
                items.add(obj.get(loqquierover).toString());
            }

            ArrayAdapter<CharSequence> dataAdapter = new ArrayAdapter(this.activity,android.R.layout.simple_spinner_item,new ArrayList(items));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(dataAdapter);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
