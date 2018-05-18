package proyectofinal.proyecto_final.Activities;

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
    private Spinner cbEps,cbTipoDocumento,cbMunicipio;
    private CtlCombo controladorCombo;
    private CtlPersona controladorPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__personas);

        this.controladorCombo = new CtlCombo(this);
        this.controladorPersona = new CtlPersona(this);

        this.txtNip = (EditText) findViewById(R.id.txtCedla_registro);
        this.txtNombreCompleto = (EditText) findViewById(R.id.txtNombreCompleto_registro);
        this.txtFecha = (EditText) findViewById(R.id.txtFechaNacimiento_registro);
        this.txtDireccion = (EditText) findViewById(R.id.txtDireccion_registro);
        this.txtTelefono = (EditText) findViewById(R.id.txtTelefono_registro);

        this.cbTipoDocumento = (Spinner) findViewById(R.id.cbTipoDocumento_registro);
        this.cbMunicipio = (Spinner) findViewById(R.id.cbMunicipio_registro);
        this.cbEps = (Spinner) findViewById(R.id.cbEps_registro);

        this.controladorCombo.cargar(this.cbTipoDocumento,"TipoDocumento","nombre","Seleccione un tipo documento");
        this.controladorCombo.cargar(this.cbMunicipio,"Municipio","nombre","Seleccione un municipio");
        this.controladorCombo.cargarEps(this.cbEps);
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

            boolean boo = this.controladorPersona.registrar(nip,nombreCompleto,direccion,telefono,eps,tipoDocumento,municipio,fechaN);

            if (boo){
                this.finish();
            }else{
                Toast.makeText(this,"Hubo un error guardando la persona",Toast.LENGTH_LONG).show();
            }
        }
    }
}
