package proyectofinal.proyecto_final.Activities.Persona;

import android.app.Activity;
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

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlPersona;
import proyectofinal.proyecto_final.R;

public class RegistrarPersonas extends AppCompatActivity {

    private EditText txtNip,txtNombreCompleto,txtFecha,txtDireccion,txtTelefono;
    private Spinner cbEps,cbTipoDocumento,cbMunicipio,cbPersonas;
    private CtlCombo controladorCombo;
    private CtlPersona controladorPersona;
    public static Activity registroPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_personas);

        this.controladorCombo = new CtlCombo(this);
        this.controladorPersona = new CtlPersona(this);

        this.registroPersonas = this;

        this.txtNip = (EditText) findViewById(R.id.txtCedla_registro);
        this.txtNombreCompleto = (EditText) findViewById(R.id.txtNombreCompleto_registro);
        this.txtFecha = (EditText) findViewById(R.id.txtFechaNacimiento_registro);
        this.txtDireccion = (EditText) findViewById(R.id.txtDireccion_registro);
        this.txtTelefono = (EditText) findViewById(R.id.txtTelefono_registro);

        this.cbTipoDocumento = (Spinner) findViewById(R.id.cbTipoDocumento_registro);
        this.cbMunicipio = (Spinner) findViewById(R.id.cbMunicipio_registro);
        this.cbEps = (Spinner) findViewById(R.id.cbEps_registro);
        this.cbPersonas = (Spinner) findViewById(R.id.cbPersona_persona);

        this.controladorCombo.cargar(this.cbTipoDocumento,"TipoDocumento","nombre","Seleccione un tipo documento");
        this.controladorCombo.cargar(this.cbMunicipio,"Municipio","nombre","Seleccione un municipio");
        this.controladorCombo.cargar(this.cbPersonas,"Persona","nip","Seleccione una persona");
        this.controladorCombo.cargarEps(this.cbEps);
    }

    public void abrirVentanaAddLicencia(View view){
        if (cbPersonas.getSelectedItemPosition() != 0){
            Intent intent = new Intent(this,RegistrarLicencia.class);
            intent.putExtra("nipPersona",cbPersonas.getSelectedItem().toString().trim());
            this.startActivity(intent);
        }else{
            Toast.makeText(this,"Por favor seleccione numero de documento para" +
                    " poder asignar una licencia a la persona",Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View view){
        this.finish();
    }

    public void registrarPersona(View view){
        String nip,nombreCompleto,direccion,telefono,eps;
        int tipoDocumento,municipio;
        Date fechaN = null;

        if (txtNip.getText().toString().isEmpty() || txtNombreCompleto.getText().toString().isEmpty()
                || txtDireccion.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty()
                || cbEps.getSelectedItemPosition() == 0 || cbTipoDocumento.getSelectedItemPosition() == 0
                || cbMunicipio.getSelectedItemPosition() == 0 || txtFecha.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else{
            nip = txtNip.getText().toString();
            nombreCompleto = txtNombreCompleto.getText().toString();
            direccion = txtDireccion.getText().toString();
            telefono = txtTelefono.getText().toString();
            eps = cbEps.getSelectedItem().toString();
            tipoDocumento = cbTipoDocumento.getSelectedItemPosition();
            municipio = cbMunicipio.getSelectedItemPosition();
            Log.d("Fecha",txtFecha.getText().toString());
            try {
                fechaN = (new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha.getText().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.controladorPersona.registrar(nip,nombreCompleto,direccion,telefono,eps,tipoDocumento,municipio,fechaN);
            this.controladorCombo.cargar(this.cbPersonas,"Persona","nip","Seleccione una persona");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            //new CtlCombo(this).cargar(RegistrarLicencia.cbPersona, "Persona", "nip", "Seleccione una persona");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
