package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class CaractristicaIndividual {

    // attributes
    private String caracteristicas;
    private Double valores;

    // arraylist that stores all the characteristics instances
    private static ArrayList<CaractristicaIndividual> ci = new ArrayList<CaractristicaIndividual>();

    /**
     * Constructor of the class CaracteristicaIndividual, receives the name of the Characteristic and its value for a
     * certain animal, also adds it to a list containing all the Individual characteristics ever created
     *
     * @param caracteristica Name of the characteristic
     * @param valor Value of the characteristic
     */
    public CaractristicaIndividual(String caracteristica, Double valor) {
        this.caracteristicas = caracteristica;
        this.valores = valor;

        // check if the characteristic already exists else add it to the array
        if (!ci.contains(this)) {
            ci.add(this);
        }
    }

    /**
     * @return List containing every individual characteristic ever created
     */
    public static ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return ci;
    }

    /**
     * @return Name of this characteristic
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @return Value of this Characteristic
     */
    public Double getValor() {
        return valores;
    }

    /**
     * Method toString of the class CaracteristicaIndividual
     * @return String with every information of the CaracteristicaIndividual
     */
    @Override
    public String toString() {
        String info;
        info = "    " + caracteristicas + " - [" + valores + "]";

        return info;
    }

}
