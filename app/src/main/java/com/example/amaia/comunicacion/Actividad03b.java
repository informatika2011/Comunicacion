package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad03b extends AppCompatActivity implements View.OnClickListener{
    private TextView lblResultado;
    private Button btnVolver;
    private int num1, num2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad03b);

        Bundle extras=getIntent().getExtras();
        lblResultado=(TextView)findViewById(R.id.lblMensajeResultado);
        num1=Integer.parseInt(extras.getString("op1"));
        num2=Integer.parseInt(extras.getString("op2"));
        result=Integer.parseInt(extras.getString("resultado"));

        btnVolver=(Button)findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);
        if((num1+num2)==result)
            lblResultado.setText("El resultado de la operación es CORRECTA");
        else
            lblResultado.setText("El resultado de la operacion es INCORRECTA");
    }


    public void volver (View v){
        finish();

    }

    @Override
    public void onClick(View view) {
        Intent i2=new Intent(Actividad03b.this,Actividad03.class);

        int result2=num1+num2;
        if(result==result2){
            i2.putExtra("accion","correcto");
        }else
            i2.putExtra("accion","error");

        setResult(RESULT_OK, i2);
        finish();
    }
}
