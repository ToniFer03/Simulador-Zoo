package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.RetratoFamilia;

public class CaracteristicasEspecie {

    // attributes
    private String caracteristicas;
    private Double valores;

    // arraylist that stores all the characteristics instances
    private static ArrayList<CaracteristicasEspecie> ce = new ArrayList<CaracteristicasEspecie>();

    /**
     * Constructor of the class CaracteristicasEspecie, receives the name of the Characteristic and its value for a
     * certain species, also adds it to a list containing all the species characteristics ever created
     *
     * @param caracteristica Name of the characteristic
     * @param valor Value of the characteristic
     */
    public CaracteristicasEspecie(String caracteristica, Double valor) {
        this.caracteristicas = caracteristica;
        this.valores = valor;

        ce.add(this);
        for (int i = 0; i < ce.size() - 1; i++) {
            if (ce.get(i).equals(this)) {
                ce.remove(ce.size() - 1);
                return;
            }
        }
    }

    /**
     * Getter of the array containing characteristic of a species ever added
     *
     * @return List containing every characteristic of a species
     */
    public static ArrayList<CaracteristicasEspecie> getCaracteristicasEspecie() {
        return ce;
    }

    /**
     * @return Returns the name of this characteristic
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @return Returns the value of this characteristic
     */
    public Double getValor() {
        return valores;
    }

    /**
     * Method toString of the class CaracteristiasEspecie
     * @return String with every information of the CaracteristicasEspecie
     */
    @Override
    public String toString() {
        String info;
        info = "    " + caracteristicas + " - [" + valores + "]";

        return info;
    }

    /**
     * Method to compare if two CaracteristicasEspecie are equal or not
     *
     * @param obj CaracteristicaEspecie to compare
     *
     * @return Boolean if they are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CaracteristicasEspecie other = (CaracteristicasEspecie) obj;
        if ((this.caracteristicas == null) ? (other.caracteristicas != null)
                : !this.caracteristicas.equals(other.caracteristicas)) {
            return false;
        }
        return true;
    }

}
