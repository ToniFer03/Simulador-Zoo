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

    // constructor for animal without caracteristicasIndividuais
    public Animal(String nomeArtistico, int idade, Especie especie) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    // constructor for animal with caracteristicasIndividuais
    public Animal(String nomeArtistico, int idade, Especie especie,
            ArrayList<CaractristicaIndividual> caracteristicasIndividuais) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = caracteristicasIndividuais;
    }

    // receives total number of animals and sets the id
    public int getId() {
        return this.id;
    }

    // sets the id of the animal based on the number received
    public void setId(int numeroAnimal) {
        this.id = numeroAnimal;
    }

    // removes the id of the animal
    public void removeId() {
        this.id = null;
    }

    // returns the age of the animal
    public int getIdade() {
        return this.idade;
    }

    // increases the age of the animal by 1
    public void aumentarIdade() {
        this.idade++;
    }

    public void addCaracteristicaIndividuais(CaractristicaIndividual caracteristica) {
        this.caracteristicasIndividuais.add(caracteristica);
    }

    // returns the array with the individual caracteristics of the animal
    public ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return this.caracteristicasIndividuais;
    }

    /*
     * This function gets the base atractiveness from the species, the value of all
     * the species caracteristics for the species and the animal, adds them up, and
     * executes a function to apply a modifier based on age in order to get the
     * total atractiveness
     */
    public double calculatAtratividade() {
        double atratividade;
        atratividade = this.getAtratividadeBase();
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            atratividade += caracteristica.getValor(); // gets the value of all caracteristics of the animal
        }

        for (CaracteristicasEspecie caracteristica : super.getCaracteristicasEspecie()) {
            atratividade += caracteristica.getValor(); // gets the value of all caracteristics of the species
        }

        atratividade = atratividade * ComplexMath.calculateAtracBasedAge(idade,
                super.getEsperancaVida()); // applies the modifier based on age

        return atratividade;
    }

    // function to remove the animal from the zoo
    public void morte(Zoo zoo) {
        // checks if the animal belongs to an instalation or not
        if (zoo.getAnimaisSemInstacao(this.getId()) != null) {
            zoo.removerAnimalSemInstalacao(this); // if it does remove it from the array
        } else {
            // else check all instalations and remove it from the one it belongs to
            for (Instalacao instalacao : zoo.getInstalacoes()) {
                if (instalacao.getAnimais().contains(this)) {
                    instalacao.removeAnimal(this);
                }
            }
        }

        // removes the animal from the array of animals in the zoo and removes the id
        zoo.removeAnimal(this);
        this.removeId();
    }

    /*
     * This function is used to calculate the cost of food for every animal, it has
     * a luck factor of 25% where the price can increase or decrease from its base
     * price
     */
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
