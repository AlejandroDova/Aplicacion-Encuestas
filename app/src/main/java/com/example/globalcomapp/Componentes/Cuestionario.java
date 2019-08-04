package com.example.globalcomapp.Componentes;

public class Cuestionario {

    private Integer id;
    private String titulo;
    private String subTitulo;
    private String escuela;
    private String jPreguntas;


    public Cuestionario(Integer id, String titulo, String subTitulo, String escuela, String jPreguntas) {
        this.id = id;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.escuela = escuela;
        this.jPreguntas = jPreguntas;
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

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getjPreguntas() {
        return jPreguntas;
    }

    public void setjPreguntas(String jPreguntas) {
        this.jPreguntas = jPreguntas;
    }
}

