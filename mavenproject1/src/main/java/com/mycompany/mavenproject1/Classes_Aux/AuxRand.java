package com.mycompany.mavenproject1.Classes_Aux;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;


public abstract class AuxRand {

    /**
     * Constructor for the class, private because there is no need to create an instance of this class
     */
    private AuxRand() {
        //private constructor
    }


    /**
     * Method to see if a new animal will be born or not, creates a random number and checks if the random number is
     * smaller or greater than the probability of a new animal being born, if smaller returns false and if its greater
     * returns True.
     *
     * @param probNascimento Probability each species has of a new animal being born
     *
     * @return a boolean that will determine if a new animal is to be born or not
     */
    public static boolean isAnimalBorn(double probNascimento) {
        double random = Math.random();
        return random < probNascimento;
    }


    /**
     * Method to see if a new animal will die or not, creates a random number and checks if the random number is
     * smaller or greater than the probability of a certain animal dying, if smaller returns false and if its greater
     * returns True.
     *
     * @param probMorte Probability each animal has of dying
     *
     * @return a boolean that will determine if the animal will die or not
     */
    public static boolean isAnimalDead(double probMorte) {
        double random = Math.random();
        return random < probMorte;
    }


    /**
     * Method is used to select random characteristics from a given list of them and returns the array of
     * characteristics it chose
     *
     * @return list of characteristics chosen at random
     */
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


    /**
     * Method to get a random price for an animal between 50 and 500
     *
     * @return Returns the price of the animal
     */
    public static double getRandomPreco() {
        return (double) (Math.random() * 450) + 50;
    }


    /**
     * Method to return a random animal that will be created
     *
     * @return An animal that was created
     * @throws IndexOutOfBoundsException Error if any of the random numbers is out of bounds
     */
    public static Animal randomAnimal() throws IndexOutOfBoundsException {
        return (new Animal(NomeArtistico.getNome(),
                getRandomInt(10), AuxRand.getRandomEspecie(),
                AuxRand.getRandomCaracIndividual()));
    }


    /**
     * Overload of the random Animal method to create a random animal but of a certain species that it receives as a
     * parameter
     * @param especie Species of the animal to be created
     * @return An animal that was created
     * @throws IndexOutOfBoundsException Error if any of the random numbers is out of bounds
     */
    public static Animal randomAnimal(Especie especie) throws IndexOutOfBoundsException {
        return (new Animal(NomeArtistico.getNome(), 0, especie, AuxRand.getRandomCaracIndividual()));
    }


    /**
     * Method to create a new installation(cage) for the Zoo
     *
     * @return A new installation
     */
    public static Instalacao randomInstalacao() {
        return (new Instalacao(getRandomCapacity(), getRandomCosts(), getRandomCosts()));
    }


    /**
     * Method that returns if an animal will escape its cage or not, creates a random number and compares it to the
     * probability of escaping
     *
     * @param probFuga Parameter that contains the probability of an animal escaping
     *
     * @return Boolean if the animal escapes or not
     */
    public static boolean AnimalFoge(double probFuga) {
        double random = Math.random();
        return random < probFuga;
    }


    /**
     * Method to return how many characteristics an animal will have, creates a random number and depending on the value
     * of it returns an integer that represents the number of characteristics that animal has
     *
     * @return Integer that representes the number of characteristics an animal has
     */
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


    /**
     * Method that returns a random species from the list of species
     *
     * @return An object representing a species from the list
     * @throws IndexOutOfBoundsException Error is the species it chooses is out of bounds
     */
    private static Especie getRandomEspecie() throws IndexOutOfBoundsException {
        int random = (int) (Math.random() * Especie.getEspecies().size());
        return Especie.getEspecies().get(random);
    }


    /**
     * Receives an integer and returns a number between 0 and that integer at random
     *
     * @param max Maximum limit of the number to be generated
     *
     * @return the random integer that was generated
     */
    private static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }


    /**
     * Method to get a random number between 50 and 100 for the costs
     *
     * @return random number between 50 and 100
     */
    private static double getRandomCosts() {
        return (Math.random() * 50) + 50;
    }


    /**
     * method to get a random number between 1 and 6 for the capacity of each installation(cage)
     *
     * @return a random integer between 1 and 6
     */
    private static int getRandomCapacity() {
        return (int) (Math.random() * 5) + 1;
    }
}
