package com.example.amaia.comunicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad04b extends AppCompatActivity {

    private TextView lblDatosIntroducidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad04b);

        //Recogemos datos de la actividad lanzadora
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");
        String sexo =extras.getString("sexo");
        String aficiones =extras.getString("aficiones");

        lblDatosIntroducidos =(TextView) findViewById(R.id.lblDatosIntro);

        lblDatosIntroducidos.setText("NOMBRE: "+nombre+"\nAPELLIDOS: "+apellidos+"\nSEXO: "+sexo+
        "\nAFICIONES: "+aficiones);



    }
}
