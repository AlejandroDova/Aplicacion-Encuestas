package com.example.globalcomapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.globalcomapp.Componentes.Cuestionario;
import com.example.globalcomapp.Componentes.Pregunta;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ArrayList<Cuestionario> listCuestionario = new ArrayList<>();

    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listCuestionario);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intetn = new Intent(getApplicationContext(),ADDCuestionario.class);
                startActivity(intetn);
                finish();
            }
        });

        preguntas.add(new Pregunta("prueba1","prueba1","pruieba1","prueba1","prueba1"));
        preguntas.add(new Pregunta("prueba2","prueba2","pruieba2","prueba2","prueba2"));
        preguntas.add(new Pregunta("prueba3","prueba3","pruieba3","prueba3","prueba3"));


        gson = new Gson();
        String json = gson.toJson(preguntas);

        listCuestionario.add(new Cuestionario(1,"titulo","subtitulo","escuela",json));
        listCuestionario.add(new Cuestionario(1,"titulo2","subtitulo2","escuela2",json));
        cargarWebservice("http://192.168.0.4/ejemploDBremota/consultaCuestionarios.php");

        MyAdapterCuestionario adapterCuestionario = new MyAdapterCuestionario(this,listCuestionario);
        listView.setAdapter(adapterCuestionario);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"SE PICA",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //intento de consulta de cuestionarios

    private void cargarWebservice(String url) {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        JSONArray jsonArray =response.optJSONArray("cuestionario");

                        try{
                            for (int i =0 ;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                listCuestionario.add( new Cuestionario(jsonObject.optInt("idCuestionario"),
                                        jsonObject.optString("titulo"),
                                        jsonObject.optString("subtitulo"),
                                        jsonObject.optString("universidad"),
                                        jsonObject.optString("preguntas")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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