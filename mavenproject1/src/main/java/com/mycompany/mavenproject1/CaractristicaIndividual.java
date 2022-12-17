package com.mycompany.mavenproject1;

//característica individuais de um animal
public class CaractristicaIndividual {
    // attributes
    private String caracteristicas;
    private Double valores;

    // add a new characteristic to the list
    public void addCaracteristica(String caracteristica, Double valor) {
        this.caracteristicas = caracteristica;
        this.valores = valor;
    }

    // getters
    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Double getValores() {
        return valores;
    }

}
