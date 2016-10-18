package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // private Button btnActividad01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  btnActividad01 =(Button)findViewById(R.id.btnActividad01);

    }
    public void actividad01(View v){
        Intent intent = new Intent(this, Actividad01.class);
        startActivity(intent);
    }
    public void actividad02(View v){
        Intent intent = new Intent(this, Actividad02.class);
        startActivity(intent);
    }
    public void actividad03(View v){
        Intent intent = new Intent(this, Actividad03.class);
        startActivity(intent);
    }
    public void actividad04(View v){
        Intent intent = new Intent(this, Actividad04.class);
        startActivity(intent);
    }

    public void salir(View v){
        finish();
    }
}
