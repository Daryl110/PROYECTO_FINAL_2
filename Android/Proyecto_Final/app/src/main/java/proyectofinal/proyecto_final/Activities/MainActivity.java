package proyectofinal.proyecto_final.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import proyectofinal.proyecto_final.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombreUsu, txtContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtNombreUsu = (EditText) findViewById(R.id.txtNombeUsuario);
        this.txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
    }

    public void post(String urlPeticion, final Map parametros) {
        JSONObject objRequest = new JSONObject();
        ArrayList<String> keys = new ArrayList<>(parametros.keySet());

        try{
            for (int i = 0;i < parametros.size();i++){
                objRequest.put(keys.get(i),parametros.get(keys.get(i)));
            }
        }catch (JSONException je){
            System.out.println(je);
        }

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                urlPeticion,
                objRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error",error.toString());
                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(objectRequest);
    }

    public void ingresar(View view) {
        String nombreUsuario, contrasenia;
        try {
            nombreUsuario = txtNombreUsu.getText().toString();
            contrasenia = txtContrasenia.getText().toString();

            Map<String,String> params = new HashMap<>();
            params.put("nombreUsuario",nombreUsuario);
            params.put("contrasenia",contrasenia);

            this.post("http://192.168.0.13:8080/API-Proyecto/Recursos/Sesion/",params);
        } catch (Exception e) {
            Toast.makeText(this, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
        }
    }
}
