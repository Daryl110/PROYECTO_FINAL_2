package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
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

import proyectofinal.proyecto_final.Activities.Menu;

public class CtlUsuario{

    public static JSONObject objResponse;

    public CtlUsuario() {
        objResponse = new JSONObject();
    }

    public void iniciarSesion(String nombreUsuario, String contrasenia, Activity context){
        Map<String,String> params = new HashMap<>();
        params.put("nombreUsuario",nombreUsuario);
        params.put("contrasenia",contrasenia);

        JSONObject response = this.iniciarSesionPost("http://192.168.137.34:8080/API-Proyecto/Recursos/Sesion/",params,context);

        if (response.length() != 0){
            try {
                boolean acceso = response.getBoolean("Acceso");

                if (acceso){
                    String rol = response.getString("Rol");
                    if (rol.equals("Agente")){
                        Intent intent = new Intent(context,Menu.class);
                        intent.putExtra("cedula",response.getString("Cedula"));
                        intent.putExtra("nombreUsuario",nombreUsuario);
                        context.startActivity(intent);
                    }
                }else{
                    Toast.makeText(context,"No se ha podido iniciar sesión",Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject iniciarSesionPost(String urlServidor, Map parametros, Activity context){
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
                urlServidor,
                objRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public JSONObject onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        objResponse = response;
                        return response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error",error.toString());
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);

        queue.add(objectRequest);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return objResponse;
    }
}
