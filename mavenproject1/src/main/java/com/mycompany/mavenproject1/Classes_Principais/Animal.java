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


    /**
     * Constructor for the class Animals, this constructor does not take individual characteristics as an argument
     *
     * @param nomeArtistico Name of the animal
     * @param idade Age of the animal
     * @param especie Species of the animal
     */
    public Animal(String nomeArtistico, int idade, Especie especie) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
    }

    /**
     * Constructor for the class Animals, this constructor takes individual characteristics as an argument
     *
     * @param nomeArtistico Name of the animal
     * @param idade Age of the animal
     * @param especie Species of the animal
     * @param caracteristicasIndividuais Array of the initial characteristics of the animal
     */
    public Animal(String nomeArtistico, int idade, Especie especie,
            ArrayList<CaractristicaIndividual> caracteristicasIndividuais) {
        super(especie.getNomeEspecie(), especie.getEsperancaVida(), especie.getAtratividadeBase(),
                especie.custoRacaobase(), especie.getProbNascimento(), especie.getCaracteristicasEspecie());
        this.nomeArtistico = nomeArtistico;
        this.idade = idade;
        this.caracteristicasIndividuais = caracteristicasIndividuais;
    }

    /**
     * Getter for the Id of the animal
     * @return Id of the animal
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter for the Id of the animal, receives the total number of animals (already including himself) and sets that
     * as the Id
     * @param numeroAnimal Total number of animals created
     */
    public void setId(int numeroAnimal) {
        this.id = numeroAnimal;
    }

    /**
     * Method to remove the Id of an animal
     */
    public void removeId() {
        this.id = null;
    }

    /**
     * Getter for the age of the animal
     * @return Age of the animal
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Method ot increase the age of the animal by 1
     */
    public void aumentarIdade() {
        this.idade++;
    }

    /**
     * Add an individual characteristic to the animals array of Individual Characteristics
     * @param caracteristica The characteristic to be added
     */
    public void addCaracteristicaIndividuais(CaractristicaIndividual caracteristica) {
        this.caracteristicasIndividuais.add(caracteristica);
    }

    /**
     * Getter for the array of individual characteristics of the animal
     * @return List of individual characteristics
     */
    public ArrayList<CaractristicaIndividual> getCaracteristicasIndividuais() {
        return this.caracteristicasIndividuais;
    }

    /**
     * Function to calculate the base attractiveness of the animal at the present moment, gets the base attractiveness
     * value from the species, adds the values of attractiveness from every characteristic the animal has and applies a
     * modifier based of the age of the animal to get the current attractiveness.
     *
     * @return The current attractiveness of the animal
     */
    public double calculatAtratividade() {
        double atratividade;
        atratividade = this.getAtratividadeBase();
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            atratividade += caracteristica.getValor();
        }

        for (CaracteristicasEspecie caracteristica : super.getCaracteristicasEspecie()) {
            atratividade += caracteristica.getValor();
        }

        atratividade = atratividade * ComplexMath.calculateAtracBasedAge(idade,
                super.getEsperancaVida());

        return atratividade;
    }

    /**
     * Function to remove the animal from the zoo upon his death, checks if the animal belong to an installation and if
     * not removes the animal from the list of animals with no installation, if it belongs to one removes teh animal
     * from that installation.
     *
     * @param zoo The zoo in which the animal lives
     */
    public void morte(Zoo zoo) {
        if (zoo.getAnimaisSemInstacao(this.getId()) != null) {
            zoo.removerAnimalSemInstalacao(this); // if it does remove it from the array
        } else {
            for (Instalacao instalacao : zoo.getInstalacoes()) {
                if (instalacao.getAnimais().contains(this)) {
                    instalacao.removeAnimal(this);
                }
            }
        }

        zoo.removeAnimal(this);
        this.removeId();
    }

    /**
     * Function to calculate the cost of food for every animal, it has a luck factor of 25% where the price can increase
     * or decrease 25% from its base price
     *
     * @return the price of ration for the animal
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

    /**
     * Returns a string with every information of the object animal it has
     *
     * @return String with every information of the object
     */
    public String basicInfo() {
        String info;
        info = "ID: " + this.id + "\n";
        info += "Nome Artistico: " + this.nomeArtistico + "\n";
        info += "Idade: " + this.idade + "\n";
        info += "Caracteristicas Individuais: \n";
        for (CaractristicaIndividual caracteristica : caracteristicasIndividuais) {
            info += caracteristica.toString() + "\n";
        }
        info += "- - - - - - - - - - - - - - -\n";
        info += super.basicInfo();

        return info;
    }

    /**
     * Method toString of the class Animal
     * @return String with every information of the animal
     */
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
