package com.mycompany.mavenproject1;

import java.util.ArrayList;

//abstract class that is the base for all animals
public class Animal extends Especie {
    // attributes
    private int id;
    private String nomeArtistico;
    private int idade;
    private ArrayList<CaractristicaIndividual> caracteristicasIndividuais;

    // constructor without id and caracteristicasIndividuais and recieves the
    // species
    public Animal(String nomeArtistico, int idade, Especie especie) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasIndividuais());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    // toString (incomplete)
    @Override
    public String toString() {
        return "Animal [id=" + id + ", nomeArtistico=" + nomeArtistico + ", idade=" + idade;
    }

    // receives number of animals and incrementes id by 1
    public void setId(int numeroAnimal) {
        this.id = numeroAnimal;
    }

    public double calculatAtratividade() {
        double atratividade;
        atratividade = this.getAtratividadeBase();
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            atratividade += caracteristica.getValor(); // gets the atratividade of all caracteristics
        }

        // get the atratividade from the species characterisitics
        atratividade += super.somaValoresCaracteristicas();

        atratividade = atratividade * ComplexMath.calculateAtracBasedAge(idade,
                super.getEsperancaVida());

        return atratividade;
    }

    public void aumentarIdade() {
        this.idade++;
    }

    public void calculateCustoRacao() {
        // TODO
    }
}
