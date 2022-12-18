package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Zoo {
    // attributes
    private int saldoContabilistico;
    private double probFugir;
    private int numeroAnimais; // to keep track of what id to atribute
    private ArrayList<Animal> animais;
    private ArrayList<Instalacao> instalacoes;

    /*
     * Talvez seja necessario ter um array de instaçãoes aqui, e dentro de cada
     * instação ter um array de animais que estao la dentro. Aqui tambem podera
     * existir um array de animais para os que estao fora das instalacoes
     */

    // constructor
    public Zoo(int saldoContabilistico, double probFugir) {
        this.saldoContabilistico = saldoContabilistico;
        this.probFugir = probFugir;
        numeroAnimais = 0;
        animais = new ArrayList<Animal>();
        instalacoes = new ArrayList<Instalacao>();
    }

    // getters
    public int getSaldoContabilistico() {
        return saldoContabilistico;
    }

    public void setSaldoContabilistico(int saldoContabilistico) {
        this.saldoContabilistico = saldoContabilistico;
    }

    public double getProbFugir() {
        return probFugir;
    }

    public int getNumeroAnimais() {
        return numeroAnimais;
    }

    public ArrayList<Instalacao> getInstalacoes() {
        return instalacoes;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    // methods
    public void addIdToAnimal(Animal animal) { // receives an animal and adds an id to it
        animal.setId(numeroAnimais);
        numeroAnimais++;
    }

    public void addAnimal(Animal animal) { // receives an animal and adds it to the zoo
        addIdToAnimal(animal);
        animais.add(animal);
    }

    public void calcProbFugir() {
        // TODO - calculate the probability of an animal to escape based on money it has
    }

    public void addInstalacao(int lotacaoMaxima) {
        instalacoes.add(new Instalacao(lotacaoMaxima, instalacoes.size()));
    }

    public void removeAnimal(Animal animal) {
        animais.remove(animal);
    }
}
