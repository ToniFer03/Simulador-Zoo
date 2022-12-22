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
    private static ArrayList<Especie> especies = new ArrayList<Especie>();

    // constructor
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

    // getters
    public static ArrayList<Especie> getEspecies() {
        return especies;
    }

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

    public void bonusAnoChines() {
        atratividadeBase += 0.5 * atratividadeBase;
    }

    public void addCaracteristicaEspecie(CaracteristicasEspecie caracteristica) {
        CaracteristicasEspecie.add(caracteristica);
    }

    public ArrayList<CaracteristicasEspecie> getCaracteristicasEspecie() {
        return CaracteristicasEspecie;
    }

    // gets the sum of the values of the characteristics of the species
    public Double somaValoresCaracteristicas() {
        Double result = 0.0;
        for (CaracteristicasEspecie caracteristica : CaracteristicasEspecie) {
            result += caracteristica.getValor();
        }
        return result;
    }

    // methods
    public void nascimento(Zoo zoo) {
        if (AuxRand.animalBorn(probNascimento)) {
            ArrayList<CaractristicaIndividual> aux = new ArrayList<CaractristicaIndividual>();
            aux = AuxRand.selectCaracteristicas();
            // create an animal and add it to the zoo (zoo.addAnimal(animal))
            zoo.addAnimalZoo(new Animal("Teste", 1, this, aux));
        }
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
