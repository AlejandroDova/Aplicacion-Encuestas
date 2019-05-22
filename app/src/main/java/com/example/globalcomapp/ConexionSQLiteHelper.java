package com.example.globalcomapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.widget.Toast;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    final String CREAR_TABLA_CUESTIONARIO = "CREATE TABLE cuestionario(id INTEGER, titulo TEXT, subTitulo TEXT)";
    final String CREAR_TABLA_USER = "CREATE TABLE user(id INTEGER primary key autoincrement, nombre text, pass text, correo text)";

    public ConexionSQLiteHelper( Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();
    }


    public void insertarUsuario(String nom, String pass, String correo){
        ContentValues values = new ContentValues();
        values.put("nombre",nom);
        values.put("pass",pass);
        values.put("correo",correo);
        this.getWritableDatabase().insert("user",null,values);
    }

    public Cursor ConsultaUserPass(String user, String pass){
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("user",new String[]{"id","nombre","pass","correo"},
                "correo like '"+user+"' "+"and pass like "+pass+"'",null,null,
                null,null);

        return  null;
    }
}
