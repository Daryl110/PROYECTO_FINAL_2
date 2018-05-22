package proyectofinal.proyecto_final.Activities.Vehiculo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import proyectofinal.proyecto_final.Activities.Persona.RegistrarLicencia;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlVehiculo;
import proyectofinal.proyecto_final.R;

public class RegistroVehiculo extends AppCompatActivity{

    private LinearLayout lytEmpresa;
    private Spinner cbClase,cbTipo;
    public static Spinner cbEmpresa;
    private EditText txtPlaca,txtModelo,txtLinea,txtMarca,txtTarjetaOperacion,txtLugarMatricula,
            txtNacionalidad,txtCapacidad,txtNumeroPasajeros,txtLicencia;
    private CtlCombo controladorCombo;
    private CtlVehiculo controladorVehiculo;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_vehiculo);

        this.activity = this;

        controladorCombo = new CtlCombo(this);
        this.controladorVehiculo = new CtlVehiculo(this);

        this.cbClase = (Spinner) findViewById(R.id.cbClaseVehiculo);
        this.cbTipo = (Spinner) findViewById(R.id.cbTipoVehiculo);
        cbEmpresa = (Spinner) findViewById(R.id.cbEmpresa_vehiculo);
        this.txtLicencia = (EditText) findViewById(R.id.txtLicenciaTransito_vehiculo);
        this.txtPlaca = (EditText) findViewById(R.id.txtPlaca);
        this.txtModelo = (EditText) findViewById(R.id.txtModelo);
        this.txtLinea = (EditText) findViewById(R.id.txtLinea);
        this.txtMarca = (EditText) findViewById(R.id.txtMarca);
        this.txtLugarMatricula = (EditText) findViewById(R.id.txtLugarMatricula);
        this.txtNacionalidad = (EditText) findViewById(R.id.txtNacionalidad);
        this.txtCapacidad = (EditText) findViewById(R.id.txtCapacidad);
        this.txtNumeroPasajeros = (EditText) findViewById(R.id.txtNumeroPasajeros);
        this.txtTarjetaOperacion = (EditText) findViewById(R.id.txtNTarjetaOperacion_vehiculo);
        this.lytEmpresa = (LinearLayout) findViewById(R.id.lytEmpresa);

        this.controladorCombo.cargarClaseVehiculo(this.cbClase);
        this.controladorCombo.cargarTipoVehiculo(this.cbTipo);
        this.controladorCombo.cargar(cbEmpresa,"Empresa","nit","Seleccione una empresa");

        this.cbClase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2){
                    Toast.makeText(activity,"Por favor seleccione la empresa a la que pertenece el vehiculo",Toast.LENGTH_LONG).show();
                    lytEmpresa.setVisibility(View.VISIBLE);
                }else{
                    lytEmpresa.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(activity,"Por favor seleccione la clase del vehiculo",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cancelar(View view){
        this.finish();
    }

    public void registrar(View view){
        String claseVehiculo,tipoVehiculo,placa,modelo,linea,marca,lugarMatricula,nacionalidad,numeroLicencia = null,nitEmpresa = null;
        int capacidad,numeroPasajeros,tarjetaOperacion = 0;

        if(cbClase.getSelectedItemPosition() == 0 || cbTipo.getSelectedItemPosition() == 0
                || txtPlaca.getText().toString().isEmpty() || txtModelo.getText().toString().isEmpty()
                || txtLinea.getText().toString().isEmpty() || txtMarca.getText().toString().isEmpty()
                || txtLugarMatricula.getText().toString().isEmpty() || txtNacionalidad.getText().toString().isEmpty()
                || txtCapacidad.getText().toString().isEmpty() || txtNumeroPasajeros.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else{
            try {
                claseVehiculo = this.cbClase.getSelectedItem().toString().trim();
                tipoVehiculo = this.cbTipo.getSelectedItem().toString().trim();
                placa = this.txtPlaca.getText().toString().trim();
                modelo = this.txtModelo.getText().toString().trim();
                linea = this.txtLinea.getText().toString().trim();
                marca = this.txtMarca.getText().toString().trim();
                lugarMatricula = this.txtLugarMatricula.getText().toString().trim();
                nacionalidad = this.txtNacionalidad.getText().toString().trim();
                capacidad = Integer.parseInt(this.txtCapacidad.getText().toString().trim());
                numeroPasajeros = Integer.parseInt(this.txtNumeroPasajeros.getText().toString().trim());
                numeroLicencia = txtLicencia.getText().toString().trim();
                if (cbClase.getSelectedItemPosition() == 2){
                    if (cbEmpresa.getSelectedItemPosition() == 0 || txtTarjetaOperacion.getText().toString().isEmpty()){
                        Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
                    }else{
                        nitEmpresa = cbEmpresa.getSelectedItem().toString().trim();
                        tarjetaOperacion = Integer.parseInt(txtTarjetaOperacion.getText().toString().trim());

                        this.controladorVehiculo.registrar(claseVehiculo,tipoVehiculo,placa,modelo,linea,marca,lugarMatricula,nacionalidad,capacidad,numeroPasajeros,
                                tarjetaOperacion,nitEmpresa,numeroLicencia);
                    }
                }else{
                    this.controladorVehiculo.registrar(claseVehiculo,tipoVehiculo,placa,modelo,linea,marca,lugarMatricula,nacionalidad,capacidad,numeroPasajeros,
                            tarjetaOperacion,nitEmpresa,numeroLicencia);
                }
            }catch (NumberFormatException e){
                Toast.makeText(this,"Debe ingresar numeros enteros en capacidad y numero de pasajeros",Toast.LENGTH_LONG).show();
            }
        }
    }
}
