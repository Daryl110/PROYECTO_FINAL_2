package proyectofinal.proyecto_final.Activities.Comparendo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import proyectofinal.proyecto_final.Activities.Persona.RegistroPersonas;
import proyectofinal.proyecto_final.Activities.Vehiculo.RegistroVehiculo;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlComparendo;
import proyectofinal.proyecto_final.R;

public class RegistrarComparendo extends AppCompatActivity {

    private Spinner cbAvenidaPrincipal,cbAvenidaSecundaria,cbModalidad,cbRadioAccion,cbTipoInfractor,
            cbMunicipio,cbtipoInfraccion;
    public static Spinner cbInfractorComparendo,cbTestigoComparendo,cbVehiculo;
    private EditText txtFecha,txtLocalidad,txtViaPrincipal,txtViaSecundari,txtDescripcion;
    private CtlCombo controladorCombo;
    private CtlComparendo controladorComparendo;
    private String cedAgente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_comparendo);

        this.controladorCombo = new CtlCombo(this);
        this.controladorComparendo = new CtlComparendo(this);

        Bundle bundle = getIntent().getExtras();
        cedAgente = bundle.getString("cedulaAgente");

        cbAvenidaPrincipal =(Spinner) findViewById(R.id.cbAvenidaPrincipal);
        cbAvenidaSecundaria =(Spinner) findViewById(R.id.cbAvenidaSecundaria);
        cbModalidad =(Spinner) findViewById(R.id.cbModalidad);
        cbRadioAccion =(Spinner) findViewById(R.id.cbRadioAccion);
        cbTipoInfractor =(Spinner) findViewById(R.id.cbTipoInfractor);
        cbVehiculo =(Spinner) findViewById(R.id.cbVehiculo);
        cbMunicipio =(Spinner) findViewById(R.id.cbMunicipioComparendo);
        cbtipoInfraccion=(Spinner) findViewById(R.id.cbTipoinfraccion);
        cbInfractorComparendo=(Spinner) findViewById(R.id.cbInfractor);
        cbTestigoComparendo=(Spinner) findViewById(R.id.cbTestigo);

        txtFecha = (EditText) findViewById(R.id.txtfechaComparendo);
        txtLocalidad = (EditText) findViewById(R.id.txtLocalidad_Comuna);
        txtViaPrincipal = (EditText) findViewById(R.id.txtAvenidaPrincipal);
        txtViaSecundari = (EditText) findViewById(R.id.txtAvenidaSecundaria);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);

        this.controladorCombo.cargarViaPrincipal(cbAvenidaPrincipal);
        this.controladorCombo.cargarViaSecundaria(cbAvenidaSecundaria);
        this.controladorCombo.cargarModalidad(cbModalidad);
        this.controladorCombo.cargarRadio(cbRadioAccion);
        this.controladorCombo.cargarTipoInfractor(cbTipoInfractor);
        this.controladorCombo.cargar(cbMunicipio,"Municipio","nombre","Seleccione municipio");
        this.controladorCombo.cargar(cbVehiculo,"Vehiculo","placa","Seleccione el vehiculo según la placa");
        this.controladorCombo.cargar(cbInfractorComparendo,"Persona","nip","Seleccione por nip a el infractor");
        this.controladorCombo.cargar(cbTestigoComparendo,"Persona","nip","Seleccione por nip a el Testigo");
        this.controladorCombo.cargar(cbtipoInfraccion,"TipoInfraccion","codigo","Seleccione el codigo del tipo de infracción");
    }

    public void abrirAddPersona(View view){
        try{
            this.startActivity(new Intent(this, RegistroPersonas.class));
        }catch (Exception e){
            Log.d("[Error]",e.toString());
        }
    }

    public void abrirAddVehiculo(View view){
        try{
            this.startActivity(new Intent(this, RegistroVehiculo.class));
        }catch (Exception e){
            Log.d("[Error]",e.toString());
        }
    }

    public void cancelar(View view){
        this.finish();
    }

    public void registrar(View view){
        int id,municipio;
        Date fecha = null;
        String localidad,viaPrincipal,viaSecundaria,descripcion,modalidad,radio,tipoInfractor,
                placaVehiculo,nipTestigo = null,nipAgente,nipInfractor,tipoInfraccion;

        if((txtFecha.getText().toString().isEmpty() || txtDescripcion.getText().toString().isEmpty() || txtLocalidad.getText().toString().isEmpty() || txtViaPrincipal.getText().toString().isEmpty() || txtViaSecundari.getText().toString().isEmpty() ||
                cbTipoInfractor.getSelectedItemPosition()==0 || cbRadioAccion.getSelectedItemPosition()==0 || cbAvenidaSecundaria.getSelectedItemPosition()==0 || cbInfractorComparendo.getSelectedItemPosition()==0 ||
                cbMunicipio.getSelectedItemPosition()==0 || cbtipoInfraccion.getSelectedItemPosition()==0 || cbModalidad.getSelectedItemPosition()==0 || cbAvenidaPrincipal.getSelectedItemPosition()==0)
                || cbInfractorComparendo.getSelectedItemPosition()==0 || cbVehiculo.getSelectedItemPosition()==0 ){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else{
            if (cbInfractorComparendo.getSelectedItem().toString().equalsIgnoreCase(cbTestigoComparendo.getSelectedItem().toString())
                    || cedAgente.equalsIgnoreCase(cbTestigoComparendo.getSelectedItem().toString())
                    || cedAgente.equalsIgnoreCase(cbInfractorComparendo.getSelectedItem().toString())){
                Toast.makeText(this,"Las cedulas debe ser diferente",Toast.LENGTH_SHORT).show();
            }else{
                try {
                    municipio = cbMunicipio.getSelectedItemPosition();
                    fecha = (new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha.getText().toString()));
                    id = this.controladorComparendo.asignarId("Comparendo");
                    localidad = txtLocalidad.getText().toString();
                    viaPrincipal = cbAvenidaPrincipal.getSelectedItem().toString()+" - "+txtViaPrincipal.getText();
                    viaSecundaria = cbAvenidaSecundaria.getSelectedItem().toString()+" - "+txtViaSecundari.getText();
                    descripcion = txtDescripcion.getText().toString();
                    modalidad = cbModalidad.getSelectedItem().toString();
                    radio = cbRadioAccion.getSelectedItem().toString();
                    tipoInfractor = cbTipoInfractor.getSelectedItem().toString();
                    placaVehiculo = cbVehiculo.getSelectedItem().toString();
                    if (cbTestigoComparendo.getSelectedItemPosition() != 0){
                        nipTestigo = cbTestigoComparendo.getSelectedItem().toString();
                    }
                    nipInfractor = cbInfractorComparendo.getSelectedItem().toString();
                    tipoInfraccion = cbtipoInfraccion.getSelectedItem().toString();
                    nipAgente = cedAgente;

                    this.controladorComparendo.registrar(id,municipio,fecha,localidad,viaPrincipal,viaSecundaria,
                            descripcion,modalidad,radio,tipoInfractor,placaVehiculo,nipTestigo,nipAgente,nipInfractor,
                            tipoInfraccion);

                } catch (ParseException e) {
                    Toast.makeText(this,
                            "Hubo un error guardando la persona en fecha talvez no esta en el formato correcto(yyyy-MM-dd)",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
