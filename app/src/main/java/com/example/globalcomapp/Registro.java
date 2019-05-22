package com.example.globalcomapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText nombre,pass,correo,passconfi;
    Button aceptar;

    ConexionSQLiteHelper helper = new ConexionSQLiteHelper(this,"db1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        aceptar = findViewById(R.id.button2);
        nombre = findViewById(R.id.editText3);
        correo = findViewById(R.id.editText4);
        pass = findViewById(R.id.editText5);
        passconfi = findViewById(R.id.editText6);

        final String pass_t = pass.getText().toString();
        final String passConfirm_t= passconfi.getText().toString();

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nombre.getText() != null && correo.getText() != null && pass.getText() != null && passconfi.getText() != null){

                    if(pass_t.equals(passConfirm_t) ){

                        helper.abrir();
                        helper.insertarUsuario(String.valueOf(nombre.getText()),String.valueOf(pass.getText()),String.valueOf(correo.getText()));
                        helper.cerrar();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(),"Contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Llena todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
