package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class CaracteristicasEspecie {

    // attributes
    private String caracteristicas;
    private Double valores;

    // arraylist that stores all the characteristics instances
    private static ArrayList<CaracteristicasEspecie> ce = new ArrayList<CaracteristicasEspecie>();

    // constructor
    public CaracteristicasEspecie(String caracteristica, Double valor) {
        this.caracteristicas = caracteristica;
        this.valores = valor;
        ce.add(this);
    }

    // getters
    public static ArrayList<CaracteristicasEspecie> getCaracteristicasEspecie() {
        return ce;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Double getValor() {
        return valores;
    }

    // to string
    @Override
    public String toString() {
        String info;
        info = "    " + caracteristicas + " - [" + valores + "]";

        return info;
    }

}
