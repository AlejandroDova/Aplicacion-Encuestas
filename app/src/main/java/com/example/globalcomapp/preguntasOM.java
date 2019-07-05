package com.example.globalcomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class preguntasOM extends AppCompatActivity {


    Button button;
    EditText titulo,respuesta1,respuesta2,respuesta3,respuesta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_om);
        button = findViewById(R.id.button3);

        titulo = findViewById(R.id.txtPreguntaOM);
        respuesta1 = findViewById(R.id.txtRespuestaPOM1);
        respuesta2 = findViewById(R.id.txtRespuestaPOM2);
        respuesta3 = findViewById(R.id.txtRespuestaPOM3);
        respuesta4 = findViewById(R.id.txtRespuestaPOM4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titulo.getText().toString().isEmpty() || respuesta1.getText().toString().isEmpty() || respuesta2.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Llena el campo titulo y la respuestas uno y dos como requisito",
                            Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(),ADDCuestionario.class);
                    intent.putExtra("titulo",titulo.getText().toString());
                    intent.putExtra("respuesta1",respuesta1.getText().toString());
                    intent.putExtra("respuesta2",respuesta2.getText().toString());
                    intent.putExtra("respuesta3",respuesta3.getText().toString());
                    intent.putExtra("respuesta4",respuesta4.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
