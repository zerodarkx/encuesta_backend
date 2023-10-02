package com.jellies.encuesta.models;

public class ResultadoEncuesta {
    private int contador;
    private String estilo;

    public ResultadoEncuesta() {
    }

    public ResultadoEncuesta(int contador, String estilo) {
        this.contador = contador;
        this.estilo = estilo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
