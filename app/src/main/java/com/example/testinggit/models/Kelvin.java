package com.example.testinggit.models;

public class Kelvin extends Grado{
    public Kelvin(Double valor, String unidad) {
        super(valor, unidad);
    }
    public Kelvin parse(Farenheit f){return  new Kelvin((f.getValor()-273.15)*1.8+32,"F");}
    public Kelvin parse(Celsius c){
        return new Kelvin(c.getValor()-273.15,"C");
    }
}
