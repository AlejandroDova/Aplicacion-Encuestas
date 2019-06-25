package com.example.globalcomapp.Componentes;

public class Pregunta {

    private String titulo;
    private String Respuesta1,Respuesta2,Respuesta3,Respuesta4;

    public Pregunta(String titulo, String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
        this.titulo = titulo;
        Respuesta1 = respuesta1;
        Respuesta2 = respuesta2;
        Respuesta3 = respuesta3;
        Respuesta4 = respuesta4;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        Respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        Respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        Respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        Respuesta4 = respuesta4;
    }
}
