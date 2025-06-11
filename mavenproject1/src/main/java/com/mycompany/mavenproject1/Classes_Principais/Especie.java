package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;

public class Especie {

    // attributes
    private String nomeEspecie;
    private int esperancaVida;
    private double atratividadeBase;
    private double custoRacaobase;
    private double probNascimento;
    private ArrayList<CaracteristicasEspecie> CaracteristicasEspecie;

    // static array with all the species
    private static ArrayList<Especie> especies = new ArrayList<Especie>();


    /**
     * Constructor for species without CaracteristicasEspecie, also adds the species to the array containing all the
     * species ever created if it isn´t in it
     *
     * @param nomeEspecie Name of the species
     * @param esperancaVida Life expectancy of the species
     * @param atratividadeBase Base attractiveness of the species
     * @param custoRacaobase Base food cost of the species
     * @param probNascimento Probability of having a baby of the species
     */
    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.CaracteristicasEspecie = new ArrayList<CaracteristicasEspecie>();
        // check if the species already exists else add it to the array
        if (!especies.contains(this)) {
            especies.add(this);
        }
    }

    /**
     * Constructor for teh species with CaracteristicasEspecie
     *
     * @param nomeEspecie Name of the species
     * @param esperancaVida Life expectancy of the species
     * @param atratividadeBase Base attractiveness of the species
     * @param custoRacaobase Base food cost of the species
     * @param probNascimento Probability of having a baby of the species
     * @param CaracteristicasEspecie List containing all the Characteristics of the species
     */
    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento, ArrayList<CaracteristicasEspecie> CaracteristicasEspecie) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.CaracteristicasEspecie = CaracteristicasEspecie;
        especies.add(this);
    }

    /**
     * Static method that returns the list of all species ever created
     * @return List of all species ever created
     */
    public static ArrayList<Especie> getEspecies() {
        return especies;
    }

    /**
     * @return Gets teh name of the species
     */
    public String getNomeEspecie() {
        return nomeEspecie;
    }

    /**
     * @return Gets the average life expectancy of the species
     */
    public int getEsperancaVida() {
        return esperancaVida;
    }

    /**
     * @return Gets the Base attractiveness of the species
     */
    public double getAtratividadeBase() {
        return atratividadeBase;
    }

    /**
     * @return Gets the base food cost of the species
     */
    public double custoRacaobase() {
        return custoRacaobase;
    }

    /**
     * @return Gets the probability of having a baby of the species
     */
    public double getProbNascimento() {
        return probNascimento;
    }

    /**
     * @return returns the object of class species
     */
    public Especie getEspecie() {
        return this;
    }

    /**
     * @return returns the list of all species characteristics for this object
     */
    public ArrayList<CaracteristicasEspecie> getCaracteristicasEspecie() {
        return CaracteristicasEspecie;
    }

    /**
     * Method to determine if a new animal of this species is to be born or not, if so it is added to teh Zoo
     *
     * @param zoo the zoo for the animal to be born into
     */
    public void nascimento(Zoo zoo) {
        if (AuxRand.isAnimalBorn(probNascimento)) {
            ArrayList<CaractristicaIndividual> ci;
            ci = AuxRand.getRandomCaracIndividual();
            // create an animal and add it to the zoo (zoo.addAnimal(animal))
            zoo.addAnimalZoo(new Animal("Teste", 1, this, ci));
        }
    }

    /**
     * Adds base attractiveness bonus to an animal if it´s born in the chinese year of its species
     * ie, a tiger that is born in the year of the tiger will receive a higher base attractiveness
     */
    public void bonusAnoChines() {
        atratividadeBase += 0.5 * atratividadeBase;
    }

    /**
     * Adds a characteristic to teh array of characteristics of the species
     *
     * @param caracteristica characteristic to be added
     */
    public void addCaracteristicaEspecie(CaracteristicasEspecie caracteristica) {
        CaracteristicasEspecie.add(caracteristica);
    }

    /**
     * @return Returns a string with every information of the Species
     */
    public String basicInfo() {
        String info;

        info = "Nome da Especie: " + nomeEspecie + "\n";
        info += "Esperanca de vida: " + esperancaVida + "\n";
        info += "Caracteristicas de especies:  \n";
        for (CaracteristicasEspecie caracteristica : CaracteristicasEspecie) {
            info += caracteristica.toString() + "\n";
        }
        return info;
    }

    /**
     * Method toString of the class Especie
     * @return String with every information of the Especie
     */
    @Override
    public String toString() {
        String info;

        info = "Nome da Especie: " + nomeEspecie + "\n";
        info += "Esperanca de vida: " + esperancaVida + "\n";
        info += "Atratividade base: " + atratividadeBase + "\n";
        info += "Custo racao base: " + custoRacaobase + "\n";
        info += "Probabilidade de nascimento: " + probNascimento + "\n";
        info += "Caracteristicas de especies:  \n";
        for (CaracteristicasEspecie caracteristica : CaracteristicasEspecie) {
            info += caracteristica.toString() + "\n";
        }

        return info;
    }

}
