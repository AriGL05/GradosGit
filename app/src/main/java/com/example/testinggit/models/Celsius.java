package com.example.testinggit.models;

public class Celsius extends Grado{

    public Celsius(Double valor, String unidad) {
        super(valor, unidad);
    }
    public Celsius parse(Farenheit f){
        return  new Celsius(f.getValor()*1.8+32,"F");
    }
    public Celsius parse(Kelvin k){return new Celsius(k.getValor()+273.15,"K");}
}
