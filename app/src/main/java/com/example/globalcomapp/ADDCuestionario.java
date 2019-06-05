package com.example.globalcomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.globalcomapp.Componentes.Pregunta;

import java.util.ArrayList;

public class ADDCuestionario extends AppCompatActivity {

    ArrayList<Pregunta> listPregunta;
    RecyclerView recyclerPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario);

        listPregunta = new ArrayList<>();
        recyclerPregunta = findViewById(R.id.recyclerid);
        recyclerPregunta.setLayoutManager(new LinearLayoutManager(this));

        MyAdapterPreguntas myAdapterPreguntas = new MyAdapterPreguntas(listPregunta);
        recyclerPregunta.setAdapter(myAdapterPreguntas);
    }
}
