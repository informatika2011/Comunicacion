package com.example.amaia.comunicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad03 extends AppCompatActivity  implements Button.OnClickListener{
    private TextView txtOperador1,txtOperador2;
    private Button btnComprobarResultado;
    private TextView lblPreguntasCorrectasValor, lblPreguntasIncorrectasValor;
    private EditText txtResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad03);
        txtOperador1=(TextView)findViewById(R.id.operando1);
        txtOperador2=(TextView)findViewById(R.id.operando2);

        int num=(int)Math.round(Math.random() * 100);
        //dato2=(int)Math.round(Math.random()*100);
        txtOperador1.setText(String.valueOf(num));
        num=(int)Math.round(Math.random() * 100);
        txtOperador2.setText(String.valueOf(num));

        btnComprobarResultado=(Button)findViewById(R.id.btnComprobar);
        btnComprobarResultado.setOnClickListener(this);

        lblPreguntasCorrectasValor=(TextView)findViewById(R.id.lblPreguntasCorrectasValor);
        lblPreguntasIncorrectasValor=(TextView)findViewById(R.id.lblPreguntasIncorrectasValor);
    }

    @Override
    public void onClick(View view) {
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        String resultadoStr=txtResultado.getText().toString();
        if (resultadoStr.equals(""))
            Toast.makeText(this,"Debe rellenar el campo resultado",Toast.LENGTH_SHORT).show();
        else {
            Intent i=new Intent(Actividad03.this,Actividad03b.class);
            i.putExtra("resultado", resultadoStr);
            i.putExtra("op1", txtOperador1.getText().toString());
            i.putExtra("op2", txtOperador2.getText().toString());
            startActivityForResult(i, 1234);
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode == RESULT_OK) {
            String resultado=data.getExtras().getString("accion");
            if(resultado.equals("correcto")){  //+1resultCorrecto
                String strRespuestasCorrectas=lblPreguntasCorrectasValor.getText().toString();
                if(strRespuestasCorrectas.equals("0"))
                    lblPreguntasCorrectasValor.setText("1");
                else {
                    int numRespuestasCorrectas=Integer.parseInt(strRespuestasCorrectas)+1;;
                    lblPreguntasCorrectasValor.setText(""+String.valueOf(numRespuestasCorrectas));
                }
            }else{
                String strRespuestasIncorrectas=lblPreguntasIncorrectasValor.getText().toString();
                if(strRespuestasIncorrectas.equals("0"))
                    lblPreguntasIncorrectasValor.setText("1");
                else {
                    int numRespuestasIncorrectas=Integer.parseInt(strRespuestasIncorrectas)+1;;
                    lblPreguntasIncorrectasValor.setText(""+String.valueOf(numRespuestasIncorrectas));
                }
            }
            //volver a poner los numeros en aletorio;
            int num=(int)Math.round(Math.random() * 100);
            //dato2=(int)Math.round(Math.random()*100);
            txtOperador1.setText(String.valueOf(num));
            num=(int)Math.round(Math.random() * 100);
            txtOperador2.setText(String.valueOf(num));
            txtResultado.setText("");
        }
    }
}

