package proyectofinal.proyecto_final.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import proyectofinal.proyecto_final.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
