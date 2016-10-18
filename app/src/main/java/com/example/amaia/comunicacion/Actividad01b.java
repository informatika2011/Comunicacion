package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad01b extends AppCompatActivity {

    private TextView lblEquitaSaludo;
    //private Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad01b);

        //Recogemos datos de la actividad lanzadora
        Bundle extras = getIntent().getExtras();
        String nombreUsuario = extras.getString("usuario");
        String apellidosUsuario = extras.getString("apellidos");
        String nombreCompleto= nombreUsuario+" "+apellidosUsuario;

        lblEquitaSaludo = (TextView)findViewById(R.id.lblEtiqueta);
        lblEquitaSaludo.setText("Hola "+nombreCompleto.toUpperCase()+" ¿Aceptas las condiciones?");
        //lblEquitaSaludo.setText("@string/prueba", nombreCompleto);
    }

    public void aceptar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado", "ACEPTADO");
        setResult(RESULT_OK, intent);
        finish();


    }
    public void rechazar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado", "RECHADADO");
        setResult(RESULT_OK, intent);
        finish();
    }

}
