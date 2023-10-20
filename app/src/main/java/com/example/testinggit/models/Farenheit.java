package com.example.testinggit.models;

public class Farenheit extends Grado{
    public Farenheit(Double valor, String unidad) {
        super(valor, unidad);
    }
    public Farenheit parse(Celsius c){return  new Farenheit((c.getValor()-32)*0.55,"C");}
    public Farenheit parse(Kelvin k){return new Farenheit((k.getValor()-32)*0.55+273.15,"K");}
}
