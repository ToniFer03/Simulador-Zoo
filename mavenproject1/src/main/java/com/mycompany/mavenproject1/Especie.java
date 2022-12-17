package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Especie {
    // attributes
    private String nomeEspecie;
    private int esperancaVida;
    private double atratividadeBase;
    private double custoRacaobase;
    private double probNascimento;
    private ArrayList<CaractristicaIndividual> caracteristicasIndividuais; // problem here

    // constructor
    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    public Especie(String nomeEspecie, int esperancaVida, double atratividadeBase, double custoRacaobase,
            double probNascimento, ArrayList<CaractristicaIndividual> caracteristicasIndividuais) {
        this.nomeEspecie = nomeEspecie;
        this.esperancaVida = esperancaVida;
        this.atratividadeBase = atratividadeBase;
        this.custoRacaobase = custoRacaobase;
        this.probNascimento = probNascimento;
        this.caracteristicasIndividuais = caracteristicasIndividuais;
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

    // toString
    @Override
    public String toString() {
        return "Especie{" + "nomeEspecie=" + nomeEspecie + ", esperancaVida=" + esperancaVida + ", atratividadeBase="
                + atratividadeBase + '}';
    }

    // methods
    public void nascimento() {
        // TODO - create a new animal of this species
    }

    public void morte() {
        // TODO - kill an animal of this species
    }
}
