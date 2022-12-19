package com.mycompany.mavenproject1;

import java.util.ArrayList;

public abstract class AuxRand {

    private AuxRand() {
    }

    // method to see if a new animal will be born
    public static boolean animalBorn(double probNascimento) {
        double random = Math.random();
        return random < probNascimento;
    }

    // method that selects a certain number of random characteristics from the list
    // of characteristics and returns them
    public static ArrayList<CaractristicaIndividual> selectCaracteristicas() {
        ArrayList<CaractristicaIndividual> caracteristicasSelecionadas = new ArrayList<CaractristicaIndividual>();
        for (int i = 0; i < AuxRand.numCaracteristicas(); i++) {
            int random = (int) (Math.random() * CaractristicaIndividual.getCaracteristicasIndividuais().size());
            // check if the characteristic is already in the list and if not add it
            if (!caracteristicasSelecionadas
                    .contains(CaractristicaIndividual.getCaracteristicasIndividuais().get(random)))
                caracteristicasSelecionadas.add(CaractristicaIndividual.getCaracteristicasIndividuais().get(random));
        }
        return caracteristicasSelecionadas;
    }

    public static boolean animalDies(double probMorte) {
        double random = Math.random();
        return random < probMorte;
    }

    // receives and int and gives a random int between 0 and the int received
    public static int randomInt(int max) {
        return (int) (Math.random() * max);
    }

    // returns a random species
    public static Especie randomEspecie() {
        int random = (int) (Math.random() * Especie.getEspecies().size());
        return Especie.getEspecies().get(random);
    }

    // method to see how many caracteristics the new animal will have
    private static int numCaracteristicas() {
        double random = Math.random();
        if (random < 0.5) {
            return 1;
        } else if (random < 0.8) {
            return 2;
        } else if (random < 0.95) {
            return 3;
        } else {
            return 4;
        }
    }

    // method to get a raondom number between 50 and 500 for the price of the animal
    public static int getPrecoRand() {
        return (int) (Math.random() * 450) + 50;
    }

}
