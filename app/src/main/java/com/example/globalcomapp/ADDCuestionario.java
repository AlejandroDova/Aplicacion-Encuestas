package com.example.globalcomapp;

import android.net.nsd.NsdManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.globalcomapp.Componentes.Pregunta;

import org.json.JSONObject;

import java.util.ArrayList;

public class ADDCuestionario extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    ArrayList<Pregunta> listPregunta;
    RecyclerView recyclerPregunta;
    Button agregarVF,agregarPOM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario);

        agregarPOM = findViewById(R.id.buttonPOM);
        agregarVF = findViewById(R.id.buttonPVF);

        listPregunta = new ArrayList<>();
        recyclerPregunta = findViewById(R.id.recyclerid);
        recyclerPregunta.setLayoutManager(new LinearLayoutManager(this));

        MyAdapterPreguntas myAdapterPreguntas = new MyAdapterPreguntas(listPregunta);
        recyclerPregunta.setAdapter(myAdapterPreguntas);



        agregarPOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alertPOM = new AlertDialog.Builder(ADDCuestionario.this);
                View preguntaview = getLayoutInflater().inflate(R.layout.dialog_preguntas,null);
                alertPOM.setTitle("Preguntas multiples");
                alertPOM.setView(preguntaview);

                AlertDialog alertDialog = alertPOM.create();
                alertDialog.show();

            }
        });

        agregarVF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alertPOM = new AlertDialog.Builder(ADDCuestionario.this);
                View preguntaview = getLayoutInflater().inflate(R.layout.dialog_preguntas,null);
                    alertPOM.setTitle("Preguntas V/F");
                alertPOM.setView(preguntaview);

                AlertDialog alertDialog = alertPOM.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
