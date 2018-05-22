package proyectofinal.proyecto_final.Activities.Comparendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import proyectofinal.proyecto_final.Activities.Menu;
import proyectofinal.proyecto_final.R;

public class ConsultaComparendo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_comparendo);
    }
    public void ingresar(View view){
        startActivity(new Intent(this,Menu.class));

    }
}
