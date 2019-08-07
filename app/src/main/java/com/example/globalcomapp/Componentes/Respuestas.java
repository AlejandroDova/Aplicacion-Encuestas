package com.example.globalcomapp.Componentes;

public class Respuestas {

    private String tituloPregunta;
    private String Respuesta;
    private int ubicacion;

    public Respuestas(String tituloPregunta, String respuesta, int ubicacion) {
        this.tituloPregunta = tituloPregunta;
        this.Respuesta = respuesta;
        this.ubicacion = ubicacion;
    }

    public String getTituloPregunta() {
        return tituloPregunta;
    }

    public void setTituloPregunta(String tituloPregunta) {
        this.tituloPregunta = tituloPregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
}
