package proyectofinal.proyecto_final.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlVehiculo;
import proyectofinal.proyecto_final.R;

public class RegistroVehiculo extends AppCompatActivity {

    private Spinner cbClase,cbTipo;
    private EditText txtPlaca,txtModelo,txtLinea,txtMarca,txtLicencia_Transito,txtLugarMatricula,
            txtNacionalidad,txtCapacidad,txtNumeroPasajeros;
    private CtlCombo controladorCombo;
    private CtlVehiculo controladorVehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vehiculo);

        this.controladorCombo = new CtlCombo(this);
        this.controladorVehiculo = new CtlVehiculo(this);

        this.cbClase = (Spinner) findViewById(R.id.cbClaseVehiculo);
        this.cbTipo = (Spinner) findViewById(R.id.cbTipoVehiculo);
        this.txtPlaca = (EditText) findViewById(R.id.txtPlaca);
        this.txtModelo = (EditText) findViewById(R.id.txtModelo);
        this.txtLinea = (EditText) findViewById(R.id.txtLinea);
        this.txtMarca = (EditText) findViewById(R.id.txtMarca);
        this.txtLugarMatricula = (EditText) findViewById(R.id.txtLugarMatricula);
        this.txtNacionalidad = (EditText) findViewById(R.id.txtNacionalidad);
        this.txtCapacidad = (EditText) findViewById(R.id.txtCapacidad);
        this.txtNumeroPasajeros = (EditText) findViewById(R.id.txtNumeroPasajeros);

        this.controladorCombo.cargarClaseVehiculo(this.cbClase);
        this.controladorCombo.cargarTipoVehiculo(this.cbTipo);
    }

    public void cancelar(View view){
        this.finish();
    }

    public void registrar(View view){
        String claseVehiculo,tipoVehiculo,placa,modelo,linea,marca,lugarMatricula,nacionalidad;
        int capacidad,numeroPasajeros;

        if(cbClase.getSelectedItemPosition() == 0 || cbTipo.getSelectedItemPosition() == 0
                || txtPlaca.getText().toString().isEmpty() || txtModelo.getText().toString().isEmpty()
                || txtLinea.getText().toString().isEmpty() || txtMarca.getText().toString().isEmpty()
                || txtLugarMatricula.getText().toString().isEmpty() || txtNacionalidad.getText().toString().isEmpty()
                || txtCapacidad.getText().toString().isEmpty() || txtNumeroPasajeros.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else{
            try {
                claseVehiculo = this.cbClase.getSelectedItem().toString();
                tipoVehiculo = this.cbTipo.getSelectedItem().toString();
                placa = this.txtPlaca.getText().toString();
                modelo = this.txtModelo.getText().toString();
                linea = this.txtLinea.getText().toString();
                marca = this.txtMarca.getText().toString();
                lugarMatricula = this.txtLugarMatricula.getText().toString();
                nacionalidad = this.txtNacionalidad.getText().toString();
                capacidad = Integer.parseInt(this.txtCapacidad.getText().toString());
                numeroPasajeros = Integer.parseInt(this.txtNumeroPasajeros.getText().toString());

                boolean bool = this.controladorVehiculo.registrar(claseVehiculo,tipoVehiculo,placa,modelo,linea,
                        marca,lugarMatricula,nacionalidad,capacidad,numeroPasajeros);

                if (bool){
                    this.finish();
                }else{
                    Toast.makeText(this,"Hubo un error guardando el vehiculo",Toast.LENGTH_LONG).show();
                }
            }catch (NumberFormatException e){
                Toast.makeText(this,"Debe ingresar numeros enteros en capacidad y numero de pasajeros",Toast.LENGTH_LONG).show();
            }
        }
    }
}
