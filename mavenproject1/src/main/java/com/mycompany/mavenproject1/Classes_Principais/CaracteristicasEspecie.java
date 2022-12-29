package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.RetratoFamilia;

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
        for (int i = 0; i < ce.size() - 1; i++) {
            if (ce.get(i).equals(this)) {
                ce.remove(ce.size() - 1);
                return;
            }
        }
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

    // equals if the characteristics are the same
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
