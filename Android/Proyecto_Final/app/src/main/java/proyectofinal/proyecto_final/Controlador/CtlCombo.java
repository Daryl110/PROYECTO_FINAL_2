package proyectofinal.proyecto_final.Controlador;

import android.app.Activity;
import android.widget.Spinner;

public class CtlCombo {

    private String url;
    private Activity activity;

    public CtlCombo(Activity activity) {
        this.url = "http://192.168.137.34:8080/API-Proyecto/Recursos/";
        this.activity = activity;
    }

    public void cargar(final Spinner spinner, String entidad, final String loqquierover){


    }
}
