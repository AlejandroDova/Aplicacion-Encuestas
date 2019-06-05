package com.example.globalcomapp.Componentes;

import java.util.ArrayList;

public class Pregunta {

    private Integer id;
    private String titulo;
    ArrayList<Respuesta> respuestas;

    public Pregunta(Integer id, String titulo, ArrayList<Respuesta> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.respuestas = respuestas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
