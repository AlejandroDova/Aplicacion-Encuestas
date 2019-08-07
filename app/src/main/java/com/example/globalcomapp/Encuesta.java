package com.example.globalcomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.globalcomapp.Componentes.Pregunta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Encuesta extends AppCompatActivity {

    Gson gson;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ListView listView;
    Button buttonGuardar;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        listView = findViewById(R.id.listEncuestas);
        buttonGuardar = findViewById(R.id.guardarRespuestas);
        radioButton = findViewById(R.id.radioButtonEncuesta);

        Bundle datos = this.getIntent().getExtras();
        String tituloC = datos.getString("titulo");
        String subTituloC = datos.getString("subtitulo");
        String json = datos.getString("json");

        Toast.makeText(getApplicationContext(),json,Toast.LENGTH_LONG).show();

//        Object logs = gson.fromJson(json, new TypeToken<List<Pregunta>>() {}.getType());

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Pregunta>>(){}.getType();
        preguntas = gson.fromJson(json, type);


        for (Pregunta contact : preguntas){

            Toast.makeText(getApplicationContext(),"Contact Details"+contact.getTitulo() + "-" + contact.getRespuesta1() + "-" + contact.getRespuesta2(),Toast.LENGTH_LONG).show();
        }
        final MyAdapterEncuesta myAdapterEncuesta = new MyAdapterEncuesta(this,preguntas);
        listView.setAdapter(myAdapterEncuesta);


        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int c = myAdapterEncuesta.getCount();


                for(int i = 0; i < c; i++){
//            ConvertVi
                }

                ArrayList s = ((MyGlobal)getApplication()).getArray();
                Toast.makeText(getApplicationContext(),"el array existe"+s, Toast.LENGTH_LONG).show();
            }
        });

    }
}