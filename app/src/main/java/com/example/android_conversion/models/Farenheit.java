package com.example.android_conversion.models;

public class Farenheit extends Grado{

    public Farenheit(Double valor) {
        this.setValor(valor);
        this.setUnidad("F");
    }

    public Farenheit parse(Celcius C){
        Double valor = C.getValor()*9/5+32;
        return new Farenheit(valor);
    }
    public Farenheit parse(Kelvin K){
        Double valor = (K.getValor()-274.15)*9/5 +32;
        return new Farenheit(valor);
    }
}
