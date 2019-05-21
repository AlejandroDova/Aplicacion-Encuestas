package com.example.globalcomapp.Componentes;

import java.util.ArrayList;

public class Cuestionario {

    ArrayList<Pregunta> preguntas;
    private Integer id;
    private String titulo;
    private String subTitulo;

    public Cuestionario(ArrayList<Pregunta> preguntas, Integer id, String titulo, String subTitulo) {
        this.preguntas = preguntas;
        this.id = id;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
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

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }
}

