package com.example.globalcomapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button entrar;
    EditText correo,pass;
    TextView registrar;

    ConexionSQLiteHelper helper = new ConexionSQLiteHelper(this,"db1",null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        entrar = findViewById(R.id.button);
        correo = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        registrar = findViewById(R.id.textView2);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = helper.ConsultaUserPass(correo.getText().toString(),pass.getText().toString());

                if(cursor.getCount() > 0){
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña o usuario incorrecto",Toast.LENGTH_LONG).show();
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
            }
        });

    }
}
