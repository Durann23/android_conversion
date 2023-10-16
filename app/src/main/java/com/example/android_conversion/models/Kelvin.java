package com.example.android_conversion.models;

public class Kelvin extends Grado{

    public Kelvin(Double valor) {
        this.setValor(valor);
        this.setUnidad("K");
    }

    public Kelvin parse(Farenheit F){
        Double valor = (F.getValor()-32)*5/9+274.15;
        return new Kelvin(valor);
    }

    public Kelvin parse(Celcius C){
        Double valor = C.getValor()+274.15;
        return new Kelvin(valor);
    }
}
