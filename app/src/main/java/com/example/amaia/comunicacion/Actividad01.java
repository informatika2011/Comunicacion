package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad01 extends AppCompatActivity {

    private Button btnVerificar;
    private Button btnAcercaDe;
    private Button btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad01);

        btnVerificar = (Button) findViewById(R.id.btnVerificar);
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtNombre= (EditText)findViewById(R.id.txtNombre);
                EditText txtApellidos= (EditText)findViewById(R.id.txtApellidos);

                //Codigo para arrancar otra actividad
                Intent intent = new Intent(Actividad01.this, Actividad01b.class);
                intent.putExtra("usuario", txtNombre.getText().toString());
                intent.putExtra("apellidos", txtApellidos.getText().toString());
                //la actividad lanzadora recibirá datos de la actividad lanzada
                startActivityForResult(intent,1234);
                //La actividad lanzadora no espera datos la actividad lanzada
                //startActivity(intent);
            }
        });
       // btnAcercaDe =(Button) findViewById(R.id.btnAcercaDe);
       /*
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarAcercaDe(null);
            }
        });
*/
        btnVolver = (Button)findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //Para recibir los datos de la actividad lanzada
    protected void onActivityResult (int requestCode, int resultCode, Intent data){

        TextView lblResultado =(TextView)findViewById(R.id.lblResultado);
        String aaa= lblResultado.getText().toString();
        aaa=aaa.substring(0,aaa.indexOf(':')+1);
        if (requestCode==1234 && resultCode==RESULT_OK ) {
            String res = data.getExtras().getString("resultado");
            lblResultado.setText(aaa+" "+res);

        }
    }

    public void lanzarAcercaDe (View v){
        Intent intent = new Intent (this, AcercaDe.class);
        startActivity(intent);
    }
    public void volver (View v){
        finish();
    }
}
