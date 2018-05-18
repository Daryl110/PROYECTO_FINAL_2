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

public class CtlUsuario extends Cliente{

    public static JSONObject objResponse;

    public CtlUsuario() {
        objResponse = new JSONObject();
    }

    public void iniciarSesion(String nombreUsuario, String contrasenia, Activity context){
        Map<String,String> params = new HashMap<>();
        params.put("nombreUsuario",nombreUsuario);
        params.put("contrasenia",contrasenia);

        this.iniciarSesionPost(this.urlPeticion+"Sesion/",params,context,nombreUsuario);
    }

    public void iniciarSesionPost(String urlServidor, Map parametros, final Activity context,final String nombreUsuario){
        JSONObject objRequest = new JSONObject();
        ArrayList<String> keys = new ArrayList<>(parametros.keySet());

        try{
            for (int i = 0;i < parametros.size();i++){
                objRequest.put(keys.get(i),parametros.get(keys.get(i)));
            }
        }catch (JSONException je){
            Toast.makeText(context, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
        }

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                urlServidor,
                objRequest,
                new Response.Listener<JSONObject>() {
                    @Override
                    public JSONObject onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
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
                                    }else{
                                        Toast.makeText(context, "Este rol no esta permitido en la aplicación", Toast.LENGTH_LONG).show();
                                    }
                                }else{
                                    Toast.makeText(context,"No se ha podido iniciar sesión",Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }else{
                            Toast.makeText(context, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
                        }
                        return response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error",error.toString());
                        Toast.makeText(context, "No se ha podido iniciar sesion", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(context);

        queue.add(objectRequest);
    }
}
