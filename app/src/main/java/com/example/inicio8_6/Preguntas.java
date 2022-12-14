package com.example.inicio8_6;

import java.io.Serializable;

public class Preguntas implements Serializable {
    public String pregunta;
    public boolean respuesta;

    public Preguntas(String p, boolean r){
        this.pregunta = p;
        this.respuesta = r;
    }

    public void setPregunta(String p){
        this.pregunta = p;
    }

    public void setRespuesta(boolean r){
        this.respuesta = r;
    }

    public String getPregunta(){
        return pregunta;
    }

    public boolean getRespuesta(){
        return respuesta;
    }
}
