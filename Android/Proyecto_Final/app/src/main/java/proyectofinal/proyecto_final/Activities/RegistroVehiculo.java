package proyectofinal.proyecto_final.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import proyectofinal.proyecto_final.R;

public class RegistroVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vehiculo);
    }
    public void ingresar(View view){
        startActivity(new Intent(this,Menu.class));

    }
}
