package com.example.globalcomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.globalcomapp.Componentes.Pregunta;
import java.util.ArrayList;


public class ADDCuestionario extends AppCompatActivity  {

    final ArrayList<Pregunta> listPregunta = new ArrayList<>();

    Boolean llavePregunta = false;
    RecyclerView recyclerPregunta;
    Button agregarVF,agregarPOM,guardar;
    EditText preguntaVF,idVF;



    @Override
    protected void onResume() {
        super.onResume();
        if(llavePregunta == true){
            crearPreguntaOM();
        }else{crearPreguntaVF();}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario);

        preguntaVF =findViewById(R.id.editTextCrearCuestionarioNombre);
        idVF = findViewById(R.id.editTextCrearCuestionarioSubtitulo);

        agregarPOM = findViewById(R.id.buttonPOM);
        agregarVF = findViewById(R.id.buttonPVF);
        guardar = findViewById(R.id.buttonGuardar);

        recyclerPregunta = findViewById(R.id.recyclerid);

        recyclerPregunta.setEnabled(true);

        recyclerPregunta.setLayoutManager(new LinearLayoutManager(this));
        String quepedo = "hola que hace?";
        listPregunta.add(
                  new Pregunta(
                        quepedo,
                        "nose",
                        "si se",
                        quepedo,
                        "nada")
        );

        MyAdapterPreguntas myAdapterPreguntas = new MyAdapterPreguntas(listPregunta);
        recyclerPregunta.setAdapter(myAdapterPreguntas);

        myAdapterPreguntas.notifyDataSetChanged();

        //oyentes buttons
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        agregarPOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llavePregunta = true;
                Intent i = new Intent(getApplicationContext(), preguntasOM.class);
                startActivity(i);

            }
        });


        agregarVF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llavePregunta = false;
                Intent i = new Intent(getApplicationContext(), PreguntaVF.class);
                startActivity(i);

//                final AlertDialog.Builder alertVF = new AlertDialog.Builder(ADDCuestionario.this);
//                View preguntaviewVF = getLayoutInflater().inflate(R.layout.dialog_preguntas_vf,null);
//                alertVF.setTitle("Preguntas V/F");
//                alertVF.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        cargarWebservice("http://192.168.0.4/ejemploDBremota/jsonregistropregunta.php?id="+idVF.getText().toString()+"&pregunta="+preguntaVF.getText().toString()+"&preguntax=si");
//                    }
//                });
//                alertVF.setView(preguntaviewVF);
//                AlertDialog alertDialog = alertVF.create();
//                alertDialog.show();
            }
        });
    }

    private void crearPreguntaVF(){
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            String titulo = parametros.getString("titulo");
            listPregunta.add(new Pregunta(titulo,"Verdadero","Falso","",""));
            llenarArray();
        }
    }

    private void crearPreguntaOM(){
        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null){
            String titulo = parametros.getString("titulo");
            String respuesta1 = parametros.getString("respuesta1");
            String respuesta2 = parametros.getString("respuesta2");
            String respuesta3 = parametros.getString("respuesta3");
            String respuesta4 = parametros.getString("respuesta4");
            listPregunta.add(new Pregunta(titulo,respuesta1,respuesta2,respuesta3,respuesta4));
            llenarArray();
        }
    }

    private void llenarArray(){
        MyAdapterPreguntas myAdapterPreguntas = new MyAdapterPreguntas(listPregunta);
        recyclerPregunta.setAdapter(myAdapterPreguntas);
    }


}
