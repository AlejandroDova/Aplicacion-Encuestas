package com.example.globalcomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.globalcomapp.Componentes.Pregunta;
import org.json.JSONObject;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ADDcuestionario2 extends AppCompatActivity {

    ArrayList<Pregunta> listPregunta = new ArrayList<>();
    ListView listView;
    Button agregarPregunta,guardarCuestionario,vf;
    EditText r1,r2,r3,r4,titulo;
    String tituloC,subTituloC;


    // implement Gson librery (implament in build.gradle)
    Gson gson;

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
          tituloC = datos.getString("titulo");
          subTituloC = datos.getString("subTitulo");

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

                gson = new Gson();
                String json = gson.toJson(listPregunta);
                String fecha = "04/09/2019";
                String autor = "alejandro";
//                cargarWebservice("http://192.168.0.5/ejemploDBremota/jsonregistropregunta.php?id=3&pregunta=Tegusta&preguntax=si");
                cargarWebservice("http://192.168.0.4/ejemploDBremota/registrarCuestionario.php?idCuestionario="+0+"&titulo="+tituloC+"&subtitulo="+subTituloC+"&universidad="+1+"&fecha="+fecha+"&autor="+autor+"&preguntas="+json+"&tvr="+0);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"SE PICA",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void cargarWebservice(String url) {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Toast.makeText(getApplicationContext(),"Operacion exitosa",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error en la conexion",Toast.LENGTH_LONG).show();
                    }
                }
        );
// add it to the RequestQueue
        queue.add(getRequest);

    }
}
