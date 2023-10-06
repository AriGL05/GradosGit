package com.example.testinggit.models;

public class Grado {
    private Double valor;
    private String unidad;

    public Grado(Double valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
