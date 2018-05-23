package proyectofinal.proyecto_final.Activities.Vehiculo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.R;

public class RegistrarEmpresa extends AppCompatActivity {

    private CtlCombo controladorCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);

        this.controladorCombo = new CtlCombo(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        try{
            this.controladorCombo.cargar(RegistroVehiculo.cbEmpresa,"Empresa","nit","Seleccione una empresa");
        }catch (Exception e){

        }
    }
}
