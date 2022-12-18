package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Mavenproject1 {

    public static void main(String[] args) {
        CaractristicaIndividual panthera = new CaractristicaIndividual("Panthera", 0.5);
        CaractristicaIndividual felis = new CaractristicaIndividual("Felis", 0.5);
        CaractristicaIndividual leo = new CaractristicaIndividual("Leo", 0.5);
        ArrayList<CaractristicaIndividual> caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
        caracteristicasIndividuais.add(panthera);
        caracteristicasIndividuais.add(felis);
        caracteristicasIndividuais.add(leo);

        Especie leao = new Especie("Leão", 10, 0.8, 0.5, 0.2, caracteristicasIndividuais);
        Animal outro = new Animal("Betinho", 1, leao);

        System.out.println(outro.calculatAtratividade());
        System.out.println(leao.somaValoresCaracteristicas());
    }

}
