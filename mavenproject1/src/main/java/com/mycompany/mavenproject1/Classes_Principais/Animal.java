package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Classes_Aux.ComplexMath;

//abstract class that is the base for all animals
public class Animal extends Especie {
    // attributes
    private Integer id; // so it can be null
    private String nomeArtistico;
    private int idade;
    private ArrayList<CaractristicaIndividual> caracteristicasIndividuais;

    // constructor without id and caracteristicasIndividuais and recieves the
    // species
    public Animal(String nomeArtistico, int idade, Especie especie) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    public Animal(String nomeArtistico, int idade, Especie especie,
            ArrayList<CaractristicaIndividual> caracteristicasIndividuais) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = caracteristicasIndividuais;
    }

    // receives number of animals and incrementes id by 1
    public void setId(int numeroAnimal) {
        this.id = numeroAnimal;
    }

    public void removeId() {
        this.id = null;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<CaracteristicasEspecie> getCaraEspecie() {
        return super.getCaracteristicasEspecie();
    }

    public ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return this.caracteristicasIndividuais;
    }

    public int getIdade() {
        return this.idade;
    }

    public void aumentarIdade() {
        this.idade++;
    }

    public double calculatAtratividade() {
        double atratividade;
        atratividade = this.getAtratividadeBase();
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            atratividade += caracteristica.getValor(); // gets the atratividade of all caracteristics
        }

        for (CaracteristicasEspecie caracteristica : super.getCaracteristicasEspecie()) {
            atratividade += caracteristica.getValor();
        }

        // get the atratividade from the species characterisitics
        atratividade += super.somaValoresCaracteristicas();

        atratividade = atratividade * ComplexMath.calculateAtracBasedAge(idade,
                super.getEsperancaVida());

        return atratividade;
    }

    public void morte(Zoo zoo) {
        zoo.removeAnimal(this);
        this.removeId();
        // check all instalations and remove the animal from them
        for (Instalacao instalacao : zoo.getInstalacoes()) {
            if (instalacao.getAnimais().contains(this)) {
                instalacao.removeAnimal(this);
            }
        }
    }

    // every time this function calculates the cost of the food, it has a 50% chance
    // of increasing or decreasing the cost by up to 25%
    public double calculateCustoRacao() {
        double result;
        if (Math.random() > 0.5) {
            result = super.custoRacaobase() - Math.random() * 0.25 * super.custoRacaobase();

        } else {
            result = super.custoRacaobase() + Math.random() * 0.25 * super.custoRacaobase();
        }

        return result;
    }

    // to string
    @Override
    public String toString() {
        String info;
        info = super.toString();
        info += "- - - - - - - - - - - - - - -\n";
        info += "ID: " + this.id + "\n";
        info += "Nome Artistico: " + this.nomeArtistico + "\n";
        info += "Idade: " + this.idade + "\n";
        info += "Caracteristicas Individuais: \n";
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            info += caracteristica.toString() + "\n";
        }

        return info;
    }
}
