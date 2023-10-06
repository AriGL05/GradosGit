package com.example.testinggit.models;

public class Farenheit extends Grado{
    public Farenheit(Double valor, String unidad) {
        super(valor, unidad);
    }
    public Farenheit parse(Celsius c){
        return  new Farenheit(c.getValor()*1.8+32,"F");
    }
    public Farenheit parse(Kelvin k){
        return new Farenheit((k.getValor()-273.15)*1.8+32,"F");
    }
}
