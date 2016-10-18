package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Actividad04 extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellidos;
    private RadioButton rbSexoMasculino;
    private RadioButton rbSexoFemenino;
    private CheckBox chbMusica;
    private CheckBox chbLectura;
    private CheckBox chbDeportes;
    private CheckBox chbViajar;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad04);

        txtNombre = (EditText) findViewById(R.id.etNombreAct4);
        txtApellidos  = (EditText) findViewById(R.id.etApellidoAct4);
        rbSexoMasculino = (RadioButton)findViewById(R.id.radioMasculino);
        rbSexoFemenino = (RadioButton) findViewById(R.id.radioFemenino);
        chbMusica = (CheckBox)findViewById(R.id.cbMusica);
        chbLectura = (CheckBox)findViewById(R.id.cbLectura);
        chbDeportes = (CheckBox)findViewById(R.id.cbDeportes);
        chbViajar = (CheckBox)findViewById(R.id.cbViajar);
        btnEnviar =(Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre= txtNombre.getText().toString();
                String apellidos = txtApellidos.getText().toString();

                String sexo="";
                if (rbSexoFemenino.isChecked())
                    sexo=getString(R.string.sexoFemenino);
                else
                    sexo=getString(R.string.sexoMasculino);
                String aficiones="";
                if (chbMusica.isChecked())
                    aficiones=aficiones+getString(R.string.aficionMusica)+", ";
                if (chbLectura.isChecked())
                    aficiones+=getString(R.string.aficionLectura)+", ";
                if (chbDeportes.isChecked())
                    aficiones+=getString(R.string.aficionDeportes)+", ";
                if (chbViajar.isChecked())
                    aficiones+=getString(R.string.aficionViajar);

                //Eliminar la coma final


                if (nombre.equals("")|| apellidos.equals(""))
                    Toast.makeText(Actividad04.this, "Rellena todos los campos de texto", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                else { //todos los campos rellenos
                    //Creamos un intent
                    Intent intent = new Intent(Actividad04.this, Actividad04b.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("apellidos", apellidos);
                    intent.putExtra("sexo", sexo);
                    intent.putExtra("aficiones",aficiones);
                    startActivity(intent);
                }
            }
        });
    }
}
