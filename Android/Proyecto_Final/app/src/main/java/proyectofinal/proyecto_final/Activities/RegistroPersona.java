package proyectofinal.proyecto_final.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import proyectofinal.proyecto_final.Controlador.CtlCombo;
import proyectofinal.proyecto_final.R;

public class RegistroPersona extends AppCompatActivity {

    private EditText txtNip,txtNombreCompleto,txtFecha,txtDireccion,txtTelefono;
    private Spinner cbEps,cbTipoDocumento,cbMunicipio;
    private CtlCombo controladorCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistrar__persona);

        this.controladorCombo = new CtlCombo(this);
        this.cbTipoDocumento = (Spinner) findViewById(R.id.cbTipoDocumento_registro);
    }

    public void cancelar(View view){
        this.finish();
    }

    public void registrarPersona(View view){
        this.controladorCombo.cargar(this.cbTipoDocumento,"TipoDocumento","nombre");
    }
}
