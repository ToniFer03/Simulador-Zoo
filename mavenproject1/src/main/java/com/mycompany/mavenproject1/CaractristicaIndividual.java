package com.mycompany.mavenproject1;

import java.util.ArrayList;

//característica individuais de um animal
public class CaractristicaIndividual {
    // attributes
    private String caracteristicas;
    private Double valores;
    private static ArrayList<CaractristicaIndividual> ci = new ArrayList<CaractristicaIndividual>();

    // add a new characteristic to the list
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
        return "CaractristicaIndividual{" +
                "caracteristicas='" + caracteristicas + '\'' +
                ", valores=" + valores +
                '}';
    }

}
