package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class Instalacao {

    // atributs
    private double custoTrabalhadores;
    private double custoLimpeza;
    private double custoTrabalhadoresInicial;
    private double custoLimpezaInicial;
    private int lotacaoMaxima;
    private Integer idInstalacao;
    private ArrayList<Animal> animais;

    /**
     * Constructor of class Instalacao
     *
     * @param lotacaoMaxima Maximum animals supported in the same enclosure
     * @param custoTrabalhadores Cost of workers in this enclosure
     * @param custoLimpeza Cost of cleaning the enclosure
     */
    public Instalacao(int lotacaoMaxima, Double custoTrabalhadores, Double custoLimpeza) {
        this.custoTrabalhadores = custoTrabalhadores;
        this.custoLimpeza = custoLimpeza;
        this.lotacaoMaxima = lotacaoMaxima;
        this.custoTrabalhadoresInicial = custoTrabalhadores;
        this.custoLimpezaInicial = custoLimpeza;
        animais = new ArrayList<Animal>(lotacaoMaxima);
    }

    /**
     * @return Id of the enclosure
     */
    public int getIdInstalacao() {
        return idInstalacao;
    }

    /**
     * @param id Id to be given to teh enclosure
     */
    public void setId(int id) {
        this.idInstalacao = id;
    }

    /**
     * @return return the cost of workers in this enclosure
     */
    public double getCustoTrabalhadores() {
        return custoTrabalhadores;
    }

    /**
     * @return return the cost of cleaning in this enclosure
     */
    public double getCustoLimpeza() {
        return custoLimpeza;
    }

    /**
     * @return return the maximum occupation of this enclosure
     */
    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    /**
     * @return return the list of animals currently in this enclosure
     */
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    /**
     * Get a certain animal in this enclosure
     *
     * @param posicao index of the animal in the list of animal in the enclosure
     * @return Animal to be returned
     */
    public Animal getAnimais(int posicao) {
        return animais.get(posicao);
    }

    /**
     * Add an animal to an enclosure, if the enclosure is full return an error message if the enclosure is not full add
     * it and increase the cost of cleaning and the cost of workers for that enclosure
     *
     * @param animal animal to be added to the enclosure
     */
    public void addAnimal(Animal animal) {
        if (animais.size() < lotacaoMaxima) {
            animais.add(animal);
            aumentarCustoLimpeza();
            aumentarCustoTrabalhadores();
        } else {
            System.out.println("Lotacao maxima atingida");
        }
    }

    /**
     * Method to remove an animal from the enclosure, if the enclosure goes back to 0 animals the cost returns to the
     * initial cost of the enclosure
     *
     * @param animal Animal to be removed from the enclosure
     */
    public void removeAnimal(Animal animal) {
        animais.remove(animal);
        if (animais.size() == 0) {
            this.custoLimpeza = custoLimpezaInicial;
            this.custoTrabalhadores = custoTrabalhadoresInicial;
        }
    }

    // private methods

    /**
     * Method to increase the cleaning cost of an enclosure
     */
    private void aumentarCustoLimpeza() {
        this.custoLimpeza = custoLimpezaInicial + 10 + (Math.random() * 10);
    }

    /**
     * Method to increase the cost with workers of an enclosure
     */
    private void aumentarCustoTrabalhadores() {
        this.custoTrabalhadores = custoTrabalhadoresInicial + 10 + (Math.random() * 10);
    }

    /**
     * @return a string containing every information in the Instalacao object
     */
    public String basicInfo() {
        String info;
        info = "---------------------------------- \n";
        info += "ID Instalacao: " + idInstalacao + "\n";
        info += "Custo Trabalhadores: " + String.format("%.2f", custoTrabalhadores) + "\n";
        info += "Custo Limpeza: " + String.format("%.2f", custoLimpeza) + "\n";
        info += "Lotacao Maxima: " + lotacaoMaxima + "\n";
        if (animais.size() > 0) {
            info += "Animais: \n";
            for (Animal animal : animais) {
                info += "---------------------------------- \n";
                info += "Posição: " + animais.indexOf(animal) + "\n";
                info += animal.basicInfo();
            }
        } else {
            info += "Sem animais \n";
        }
        info += "---------------------------------- \n";
        return info;
    }

    /**
     * Method toString of the class Instalacao
     * @return String with every information of the Instalacao
     */
    @Override
    public String toString() {
        String info;
        info = "---------------------------------- \n";
        info += "ID Instalacao: " + idInstalacao + "\n";
        info += "Custo Trabalhadores: " + custoTrabalhadores + "\n";
        info += "Custo Limpeza: " + custoLimpeza + "\n";
        info += "Lotacao Maxima: " + lotacaoMaxima + "\n";
        info += "Animais: \n";
        for (Animal animal : animais) {
            info += "---------------------------------- \n";
            info += "Posição: " + animais.indexOf(animal) + "\n";
            info += animal.basicInfo();
            info += "---------------------------------- \n";
        }

        return info;
    }

}
