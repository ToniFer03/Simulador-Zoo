package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Especie {
    // attributes
    private String nomeEspecie;
    private int esperancaVida;
    private double atratividadeBase;
    private double custoRacaobase;
    private double probNascimento;
    private ArrayList<CaractristicaIndividual> caracteristicasIndividuais;
    private static ArrayList<Especie> especies = new ArrayList<Especie>();

    // constructor
    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
        especies.add(this);
    }

    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento, ArrayList<CaractristicaIndividual> caracteristicasIndividuais) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.caracteristicasIndividuais = caracteristicasIndividuais;
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

    public ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return caracteristicasIndividuais;
    }

    public Double somaValoresCaracteristicas() {
        Double result = 0.0;
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            result += caracteristica.getValor();
        }
        return result;
    }

    // toString
    @Override
    public String toString() {
        return "Especie{" + "nomeEspecie=" + nomeEspecie + ", esperancaVida=" + esperancaVida + ", atratividadeBase="
                + atratividadeBase + '}';
    }

    // methods
    public void nascimento(Zoo zoo) {
        if (AuxRand.animalBorn(probNascimento)) {
            ArrayList<CaractristicaIndividual> aux = new ArrayList<CaractristicaIndividual>();
            aux = AuxRand.selectCaracteristicas();
            // create an animal and add it to the zoo (zoo.addAnimal(animal))
            zoo.addAnimal(new Animal("Teste", 1, this));
        }
    }
}
