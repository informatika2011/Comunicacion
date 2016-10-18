package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad02b extends AppCompatActivity {  //Recogemos datos de la actividad lanzadora

    private TextView lblValidarPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad02b);

        //Recogemos datos de la actividad lanzadora
        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");
        String password = extras.getString("password");

        lblValidarPassword = (TextView)findViewById(R.id.txtMensaje);

        if (!password.equals("1234")){
            lblValidarPassword.setText("USUARIO Y/O PASSWORD INCORRECTA");

        }
        else
            lblValidarPassword.setText("El USUARIO y la PASSWORD son CORRECTAS");
    }

    public void volver (View v){

        //Intent i2=new Intent(Actividad02b.this,Actividad02.class);
        //setResult(RESULT_OK, i2);
        finish();

    }

}
