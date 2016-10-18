package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad02 extends AppCompatActivity {

    private Button btnValidarUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad02);

        btnValidarUsuario = (Button)findViewById(R.id.btnValidarUsuario);
        btnValidarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtUsuario= (EditText)findViewById(R.id.input_usuario);
                EditText txtPassword= (EditText)findViewById(R.id.input_contrasena);

                Intent intent =new Intent(Actividad02.this, Actividad02b.class);
                intent.putExtra("usuario", txtUsuario.getText().toString());
                intent.putExtra("password", txtPassword.getText().toString());
                startActivity(intent);
                startActivityForResult(intent,1234);
            }
        });
    }
    /*protected void onActivityResult (int requestCode,int resultCode, Intent data) {
    }
        EditText txtUsuario= (EditText)findViewById(R.id.input_usuario);
        EditText txtPassword= (EditText)findViewById(R.id.input_contrasena);

    }*/
}
