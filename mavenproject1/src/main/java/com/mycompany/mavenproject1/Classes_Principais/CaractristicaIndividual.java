package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

//característica individuais de um animal
public class CaractristicaIndividual {
    // attributes
    private String caracteristicas;
    private Double valores;
    private static ArrayList<CaractristicaIndividual> ci = new ArrayList<CaractristicaIndividual>();

    // constructor
    public CaractristicaIndividual(String caracteristica, Double valor) {
        this.caracteristicas = caracteristica;
        this.valores = valor;
        ci.add(this);
    }

    // getters
    public static ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return ci;
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
