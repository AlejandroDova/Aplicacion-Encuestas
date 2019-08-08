package com.example.globalcomapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.globalcomapp.Componentes.Pregunta;
import com.example.globalcomapp.Componentes.Respuestas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Encuesta extends AppCompatActivity {

    private Gson gson;
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    private ArrayList<Respuestas> respuestas = new ArrayList<>();
    private int posicion = 0;
    private Gson gsonrespuestas = new Gson();
    private String tituloC,subtituloC;

    ListView listView;
    Button buttonGuardar;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    TextView txtTitulo,txtPagina,txtTituloCuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        buttonGuardar = findViewById(R.id.guardarRespuestas);
        r1 = findViewById(R.id.radioButtonE1);
        r2 = findViewById(R.id.radioButtonE2);
        r3 = findViewById(R.id.radioButtonE3);
        r4 = findViewById(R.id.radioButtonE4);
        radioGroup = findViewById(R.id.RadioGroup1);
        txtTitulo = findViewById(R.id.TituloPreguntaEncuesta);
        txtPagina = findViewById(R.id.NumeroDePagina);
        txtTituloCuestionario = findViewById(R.id.TituloCuestionarioEncuesta);



        Bundle datos = this.getIntent().getExtras();
         tituloC = datos.getString("titulo");
         subtituloC = datos.getString("subtitulo");
        String json = datos.getString("json");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Pregunta>>(){}.getType();
        preguntas = gson.fromJson(json, type);


        txtTituloCuestionario.setText(tituloC);
        txtPagina.setText((posicion+1)+"/"+preguntas.size());

        txtTitulo.setText(preguntas.get(0).getTitulo());
        r1.setText(preguntas.get(0).getRespuesta1());
        r2.setText(preguntas.get(0).getRespuesta2());
        r3.setText(preguntas.get(0).getRespuesta3());
        r4.setText(preguntas.get(0).getRespuesta4());

        for (Pregunta contact : preguntas){
            Toast.makeText(getApplicationContext(),"Contact Details"+contact.getTitulo() + "-" + contact.getRespuesta1() + "-" + contact.getRespuesta2(),Toast.LENGTH_LONG).show();
        }

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(r1.isChecked() == true || r2.isChecked() == true || r3.isChecked() == true || r4.isChecked() == true){

                    if(posicion+1 <= preguntas.size()){
                        // Selecciona el id de la vista que este seleccionada en el RadioGroup
                        int id = radioGroup.getCheckedRadioButtonId();
                        switch (id) {
                            case R.id.radioButtonE1:
                                agregarRespuesta(r1);

                                break;
                            case R.id.radioButtonE2:
                                agregarRespuesta(r2);

                                break;
                            case R.id.radioButtonE3:
                                agregarRespuesta(r3);

                                break;
                            case R.id.radioButtonE4:
                                agregarRespuesta(r4);

                                break;
                        }

                        posicion += 1;
                        txtTitulo.setText(preguntas.get(posicion).getTitulo());
                        r1.setText(preguntas.get(posicion).getRespuesta1());
                        r2.setText(preguntas.get(posicion).getRespuesta2());
                        r3.setText(preguntas.get(posicion).getRespuesta3());
                        r4.setText(preguntas.get(posicion).getRespuesta4());

                        txtPagina.setText((posicion+1)+"/"+preguntas.size());

                        if(posicion+1 == preguntas.size()){
                            posicion+=1;
                            buttonGuardar.setText("Finalizar");
                        }
                    }else{
                        //guardar respuestas
                        String json = gsonrespuestas.toJson(respuestas);
                        cargarWebservice("http://192.168.0.8/ejemploDBremota/agregarRespuesta.php?id=0&titulo="+tituloC+"&subtitulo="+subtituloC+"&respuestas="+json);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Seleccione alguna respuesta",Toast.LENGTH_LONG).show();

                }
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

    public void agregarRespuesta(RadioButton radioButton){
        respuestas.add(new Respuestas(preguntas.get(posicion).getTitulo(),radioButton.getText().toString(),posicion));
    }
}