package com.example.globalcomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.globalcomapp.Componentes.Pregunta;

import org.json.JSONObject;

import java.util.ArrayList;

public class ADDcuestionario2 extends AppCompatActivity {

    ArrayList<Pregunta> listPregunta = new ArrayList<>();
    ListView listView;
    Button agregarPregunta,guardarCuestionario,vf;
    EditText r1,r2,r3,r4,titulo;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcuestionario2);

        listView = findViewById(R.id.listView);
        agregarPregunta = findViewById(R.id.agregarPregunta);
        vf = findViewById(R.id.VF);
        guardarCuestionario = findViewById(R.id.guardarCuestionario);

        titulo = findViewById(R.id.tituloPregunta);
        r1 = findViewById(R.id.txtrespuesta1);
        r2 = findViewById(R.id.txtrespuesta2);
        r3 = findViewById(R.id.txtrespuesta3);
        r4 = findViewById(R.id.txtrespuesta4);

        Bundle datos = this.getIntent().getExtras();
        final String tituloC = datos.getString("titulo");
        final String subTituloC = datos.getString("subTitulo");

        listPregunta.add(new Pregunta("Ejemplo", "ejemplo", "ejemplo", "ejemplo", "ejemplo"));

        adapterPreguntas adapterPreguntas = new adapterPreguntas(getApplicationContext(),listPregunta);
        listView.setAdapter(adapterPreguntas);

        agregarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titulo.getText().toString().isEmpty() || r1.getText().toString().isEmpty() || r2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Llena el campo titulo y la respuestas uno y dos como requisito",
                            Toast.LENGTH_LONG).show();
                }else{
                    listPregunta.add(new Pregunta(
                            titulo.getText().toString(),
                            r1.getText().toString(),
                            r2.getText().toString(),
                            r3.getText().toString(),
                            r4.getText().toString()
                    ));
                }
            }
        });

        guardarCuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cargarWebservice("http://localhost/ejemploDBremota/registrarCuestionario.php?" +
                        "idCuestionario=0" +
                        "&titulo="+tituloC+
                        "&subtitulo="+subTituloC+
                        "&universidad=1" +
                        "&fecha="+""+
                        "&autor=alejandro" +
                        "&preguntas=" +
                        "&tvr=0");

            }
        });

        vf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setText("Verdadero");
                r2.setText("Falso");
                r3.setText("");
                r4.setText("");
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
