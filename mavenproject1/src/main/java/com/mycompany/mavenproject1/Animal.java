package com.mycompany.mavenproject1;

import java.util.ArrayList;

//abstract class that is the base for all animals
public class Animal extends Especie {
    // attributes
    private int id;
    private String nomeArtistico;
    private int idade;
    private double atratividade; // calculated based on the species and the
                                 // individual characteristics
    private ArrayList<CaractristicaIndividual> caracteristicasIndividuais;

    // constructor without id and caracteristicasIndividuais and recieves the
    // species
    public Animal(String nomeArtistico, int idade, double atratividade, Especie especie) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.atratividade = atratividade;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    // toString (incomplete)
    @Override
    public String toString() {
        return "Animal [id=" + id + ", nomeArtistico=" + nomeArtistico + ", idade=" + idade
                + ", atratividade=" + atratividade;
    }

    // receives number of animals and incrementes id by 1
    public void setId(int numeroAnimal) {
        this.id = numeroAnimal;
    }

    public void calculatAtratividade() {
        // TODO - calculate the attractiveness of the animal based on the
        // caracteristics, and the age
    }

    public void calculateCustoRacao() {
        // TODO
    }
}
