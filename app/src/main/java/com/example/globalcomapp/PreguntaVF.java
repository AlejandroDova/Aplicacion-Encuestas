package com.example.globalcomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.globalcomapp.Componentes.Pregunta;

import org.json.JSONObject;


public class PreguntaVF extends AppCompatActivity {

    RequestQueue requestQueue;
    EditText preguntavf;
    Button button;

    ADDCuestionario addCuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_vf);

        preguntavf = findViewById(R.id.txtpreguntavf);
        button = findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cargarWebservice("http://192.168.0.4/ejemploDBremota/jsonregistropregunta.php?id=0&pregunta="+preguntavf.getText().toString()+"&preguntax=si");
                Intent intent = new Intent(getApplicationContext(),ADDCuestionario.class);
                intent.putExtra("titulo",preguntavf.getText().toString());
                startActivity(intent);
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
