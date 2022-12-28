package com.mycompany.mavenproject1.Classes_Aux;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;

public abstract class AuxRand {

    // private constructor because this functions is not be instanciated
    private AuxRand() {
    }

    // method to see if a new animal will be born or not
    public static boolean isAnimalBorn(double probNascimento) {
        double random = Math.random();
        return random < probNascimento;
    }

    // method to see if an animal will die or not
    public static boolean isAnimalDead(double probMorte) {
        double random = Math.random();
        return random < probMorte;
    }

    // method that selects random characteristics from the list of characteristics
    public static ArrayList<CaractristicaIndividual> getRandomCaracIndividual() {
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

    // method to get a random number between 50 and 500 for the price of the animal
    public static double getRandomPreco() {
        return (double) (Math.random() * 450) + 50;
    }

    public static Animal randomAnimal() {
        return (new Animal(NomeArtistico.getNome(),
                getRandomInt(10), AuxRand.getRandomEspecie(),
                AuxRand.getRandomCaracIndividual()));
    }

    // overload of the randomAnimal method to create a new animal with the species
    // defined
    public static Animal randomAnimal(Especie especie) {
        return (new Animal(NomeArtistico.getNome(), 0, especie, AuxRand.getRandomCaracIndividual()));
    }

    // create a random instalation
    public static Instalacao randomInstalacao() {
        return (new Instalacao(getRandomCapacity(), getRandomCosts(), getRandomCosts()));
    }

    public static boolean AnimalFoge(double probFuga) {
        double random = Math.random();
        return random < probFuga;
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

    // method that returns a random species from the list of species
    private static Especie getRandomEspecie() {
        int random = (int) (Math.random() * Especie.getEspecies().size());
        return Especie.getEspecies().get(random);
    }

    // receives and int and gives a random int between 0 and the int received
    private static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }

    // methond to get a random number between 50 and 100 for the costs
    private static int getRandomCosts() {
        return (int) (Math.random() * 50) + 50;
    }

    // method to get a random number between 1 and 6 for the capacity of the cage
    private static int getRandomCapacity() {
        return (int) (Math.random() * 5) + 1;
    }
}
