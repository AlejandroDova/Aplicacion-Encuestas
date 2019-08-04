package com.example.globalcomapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;




public class ADDCuestionario extends AppCompatActivity {

    Button siguiente;
    EditText tituloCuestionario, subTituloCuestionario;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario);

        tituloCuestionario = findViewById(R.id.editTextCrearCuestionarioNombre);
        subTituloCuestionario = findViewById(R.id.editTextCrearCuestionarioSubtitulo);


        siguiente = findViewById(R.id.buttonGuardar);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ADDcuestionario2.class);
                intent.putExtra("titulo",tituloCuestionario.getText().toString());
                intent.putExtra("subTitulo",subTituloCuestionario.getText().toString());
                startActivity(intent);
            }
        });
    }
}
