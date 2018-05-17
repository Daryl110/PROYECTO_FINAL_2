package proyectofinal.proyecto_final.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import proyectofinal.proyecto_final.Controlador.CtlUsuario;
import proyectofinal.proyecto_final.R;

public class Menu extends AppCompatActivity {

    private String usuario,cedula;
    private TextView lblCedula,lblUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle = getIntent().getExtras();

        cedula = bundle.getString("cedula");
        usuario = bundle.getString("nombreUsuario");

        lblCedula = (TextView) findViewById(R.id.txtCedula_menu);
        lblCedula.setText(cedula);

        lblUsuario = (TextView) findViewById(R.id.txtUsuario_menu);
        lblUsuario.setText(usuario);

        CtlUsuario.objResponse = new JSONObject();
    }


    public void RCiudadano(View view){
        startActivity(new Intent(this,RegistroPersona.class));
    }
    public void RVehiculo(View view){
        startActivity(new Intent(this,RegistroVehiculo.class));

    }
    public void RComparendo(View view){
        startActivity(new Intent(this,ComparendoFormulario1.class));

    }
    public void CComparendo(View view){
        startActivity(new Intent(this,ConsultaComparendo.class));

    }
}
