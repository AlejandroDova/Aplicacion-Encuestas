package com.example.globalcomapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.globalcomapp.Componentes.Pregunta;

import org.json.JSONObject;

import java.util.ArrayList;

public class ADDCuestionario extends AppCompatActivity  {

    ArrayList<Pregunta> listPregunta;
    RecyclerView recyclerPregunta;
    Button agregarVF,agregarPOM, aceptarpreguntaPOM,aceptarpreguntaVF;

    RequestQueue requestQueue;

    EditText preguntaVF,idVF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario);

        preguntaVF =findViewById(R.id.editTextCrearCuestionarioNombre);
        idVF = findViewById(R.id.editTextCrearCuestionarioSubtitulo);

        agregarPOM = findViewById(R.id.buttonPOM);
        agregarVF = findViewById(R.id.buttonPVF);

        listPregunta = new ArrayList<>();
        recyclerPregunta = findViewById(R.id.recyclerid);
        recyclerPregunta.setLayoutManager(new LinearLayoutManager(this));

        MyAdapterPreguntas myAdapterPreguntas = new MyAdapterPreguntas(listPregunta);
        recyclerPregunta.setAdapter(myAdapterPreguntas);

        requestQueue = Volley.newRequestQueue(getApplicationContext());


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
                final AlertDialog.Builder alertVF = new AlertDialog.Builder(ADDCuestionario.this);


                View preguntaviewVF = getLayoutInflater().inflate(R.layout.dialog_preguntas_vf,null);
                alertVF.setTitle("Preguntas V/F");
                alertVF.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        cargarWebservice("http://192.168.0.4/ejemploDBremota/jsonregistropregunta.php?id="+idVF.getText().toString()+"&pregunta="+preguntaVF.getText().toString()+"&preguntax=si");

                    }
                });
                alertVF.setView(preguntaviewVF);
                AlertDialog alertDialog = alertVF.create();
                alertDialog.show();

            }
        });

    }

    private void cargarWebservice(String url) {
// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(),"Se ha enviado con exito",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "error sin conexion", Toast.LENGTH_LONG).show();
                    }
                }
        );

        requestQueue.add(getRequest);
    }
}
