package proyectofinal.proyecto_final.Activities.Persona;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import proyectofinal.proyecto_final.Activities.Persona.RegistrarPersonas;
import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.Controlador.CtlLicencia;
import proyectofinal.proyecto_final.R;

public class RegistrarLicencia extends AppCompatActivity {

    private CtlCombo controladorCombo;
    private CtlLicencia controladorLicencia;
    private Spinner cbCategoria;
    private EditText txtNLicencia,txtFechaExp,txtFechaVen,txtOficina;
    private String nipPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_licencia);

        this.txtNLicencia = (EditText) findViewById(R.id.txtNLicencia_licencia);
        this.txtFechaExp = (EditText) findViewById(R.id.txtFechaExpedicion_licencia);
        this.txtFechaVen = (EditText) findViewById(R.id.txtFechaVencimiento_licencia);
        this.txtOficina = (EditText) findViewById(R.id.txtOficina_licnecia);
        this.cbCategoria = (Spinner) findViewById(R.id.cbCategoria_licencia);

        this.nipPersona = (String) getIntent().getExtras().get("nipPersona");

        this.controladorCombo = new CtlCombo(this);
        this.controladorLicencia = new CtlLicencia(this);
        this.controladorCombo.cargarCategoriaLicencia(this.cbCategoria);
    }

    public void cancelar(View view){
        this.finish();
    }

    public void regitrar(View view){
        if (txtNLicencia.getText().toString().isEmpty() || txtFechaExp.getText().toString().isEmpty()
                || txtFechaVen.getText().toString().isEmpty() || txtOficina.getText().toString().isEmpty()
                || cbCategoria.getSelectedItemPosition() == 0 ){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }else{
            try {
                Date fechaExp = (new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaExp.getText().toString()));
                Date fechaVen = (new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaVen.getText().toString()));

                if (fechaExp.before(fechaVen)){
                    String numeroLicencia,oficina,categoria;

                    numeroLicencia = this.txtNLicencia.getText().toString().trim();
                    oficina = this.txtOficina.getText().toString().trim();
                    categoria = this.cbCategoria.getSelectedItem().toString().trim();

                    this.controladorLicencia.registrar(numeroLicencia,oficina,categoria,nipPersona,fechaExp,fechaVen);
                }else{
                    Toast.makeText(this,"La feche de vencimiento no puede ser menor que la fecha de expedicion",Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this,"Error al guardar la licencia",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        RegistrarPersonas.registroPersonas.finish();
    }
}
