package com.example.globalcomapp;

import android.app.Application;

import com.example.globalcomapp.Componentes.Respuestas;

import java.util.ArrayList;

public class MyGlobal extends Application {

    public ArrayList array = new ArrayList();


    public void agregarString(String string){
        array.add(string);
    }

    public ArrayList getArray() {
        return array;
    }

    public void setArray(ArrayList array) {
        this.array = array;
    }
}
