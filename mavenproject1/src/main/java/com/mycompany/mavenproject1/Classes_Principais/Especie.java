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

    // constructor for species without CaracteristicasEspecie
    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.CaracteristicasEspecie = new ArrayList<CaracteristicasEspecie>();
        especies.add(this);
    }

    // constructor for species with CaracteristicasEspecie
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

    // static methods
    public static ArrayList<Especie> getEspecies() {
        return especies;
    }

    // getters
    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public int getEsperancaVida() {
        return esperancaVida;
    }

    public double getAtratividadeBase() {
        return atratividadeBase;
    }

    public double custoRacaobase() {
        return custoRacaobase;
    }

    public double getProbNascimento() {
        return probNascimento;
    }

    public ArrayList<CaracteristicasEspecie> getCaracteristicasEspecie() {
        return CaracteristicasEspecie;
    }

    // methods
    // method that determines if the animal is born and adds it to the zoo
    public void nascimento(Zoo zoo) {
        if (AuxRand.isAnimalBorn(probNascimento)) {
            ArrayList<CaractristicaIndividual> ci;
            ci = AuxRand.getRandomCaracIndividual();
            // create an animal and add it to the zoo (zoo.addAnimal(animal))
            zoo.addAnimalZoo(new Animal("Teste", 1, this, ci));
        }
    }

    // method that adds the bonus the chinese year is the same as the species
    public void bonusAnoChines() {
        atratividadeBase += 0.5 * atratividadeBase;
    }

    // method that adds a CaracteristicasEspecie to the array
    public void addCaracteristicaEspecie(CaracteristicasEspecie caracteristica) {
        CaracteristicasEspecie.add(caracteristica);
    }

    // toString
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
