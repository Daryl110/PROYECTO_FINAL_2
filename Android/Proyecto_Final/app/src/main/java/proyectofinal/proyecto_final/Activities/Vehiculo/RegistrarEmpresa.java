package proyectofinal.proyecto_final.Activities.Vehiculo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlEmpresa;
import proyectofinal.proyecto_final.R;

public class RegistrarEmpresa extends AppCompatActivity {

    private CtlCombo controladorCombo;
    private CtlEmpresa controladorEmpresa;
    private EditText txtNombre,txtNit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);

        this.controladorCombo = new CtlCombo(this);
        this.controladorEmpresa = new CtlEmpresa(this);

        this.txtNit = (EditText) findViewById(R.id.txtNit_empresa);
        this.txtNombre = (EditText) findViewById(R.id.txtNombre_empresa);
    }

    public void registrar(View view){
        if (this.txtNombre.getText().toString().isEmpty() || this.txtNit.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos para poder registrar",Toast.LENGTH_SHORT).show();
        }else{
            String nombre,nit;

            nombre = this.txtNombre.getText().toString().trim();
            nit = this.txtNit.getText().toString().trim();

            this.controladorEmpresa.registrar(nit,nombre);
        }
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
