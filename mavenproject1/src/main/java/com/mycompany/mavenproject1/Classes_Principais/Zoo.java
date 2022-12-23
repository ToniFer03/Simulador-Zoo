package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class Zoo {
    // attributes
    private double saldoContabilistico;
    private double probFugir;
    private int numeroAnimais; // to keep track of what id to atribute
    private int numeroInstalacoes; // to keep track of what id to atribute
    private ArrayList<Animal> todosAnimais; // array of all animals on the zoo
    private ArrayList<Animal> animaisSemInstacao; // array of animals that are not in any instalacao
    private ArrayList<Instalacao> instalacoes;
    private ArrayList<Animal> Obituario;

    /*
     * Talvez seja necessario ter um array de instaçãoes aqui, e dentro de cada
     * instação ter um array de animais que estao la dentro. Aqui tambem podera
     * existir um array de animais para os que estao fora das instalacoes
     */

    // constructor
    public Zoo(Double saldoContabilistico, double probFugir) {
        this.saldoContabilistico = saldoContabilistico;
        this.probFugir = probFugir;
        numeroAnimais = 0;
        numeroInstalacoes = 0;
        todosAnimais = new ArrayList<Animal>(); // array of all animals
        instalacoes = new ArrayList<Instalacao>();
        animaisSemInstacao = new ArrayList<Animal>(); // array of animals that are not in any instalacao
        Obituario = new ArrayList<Animal>();
    }

    // getters
    public double getSaldoContabilistico() {
        return saldoContabilistico;
    }

    public double getProbFugir() {
        return probFugir;
    }

    public int getNumeroAnimais() {
        return numeroAnimais;
    }

    public ArrayList<Animal> getObituario() {
        return Obituario;
    }

    /*
     * Methods to get animals without instalation, the first one returns the entire
     * array, the second one is an overloading of the first one receiveng an int
     * that represents the id and returns only that animal with that id
     */
    public ArrayList<Animal> getAnimaisSemInstacao() {
        return animaisSemInstacao;
    }

    public Animal getAnimaisSemInstacao(int id) {
        for (Animal a : todosAnimais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null; // if there isnt an animal with that id
    }

    /*
     * Methods to get all animals in the zoo, the first one returns the entire
     * array, the second one is an overloading of the first one receiveng an int
     * that represents the id and returns only that animal with that id
     */
    public ArrayList<Animal> getTodosAnimais() {
        return todosAnimais;
    }

    public Animal getTodosAnimais(int id) {
        for (Animal a : todosAnimais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null; // if the animal is not in the zoo
    }

    /*
     * Methods to all instalations in the zoo, the first one returns the entire
     * array, the second one is an overloading of the first one receiveng an int
     * that represents the id and returns only that animal with that id
     */
    public ArrayList<Instalacao> getInstalacoes() {
        return instalacoes;
    }

    public Instalacao getInstalacoes(int id) {
        for (Instalacao i : instalacoes) {
            if (i.getIdInstalacao() == id) {
                return i;
            }
        }
        return null; // if there isnt an instalacao with that id
    }

    // add instalacao and animals to the zoo
    public void addInstalacaoZoo(Instalacao instalacao) { // receives an instalacao and adds it to the zoo
        addIdToInstalacao(instalacao);
        instalacoes.add(instalacao);
    }

    public void addAnimalZoo(Animal animal) { // receives an animal and adds it to the zoo
        if (!todosAnimais.contains(animal)) {
            todosAnimais.add(animal);
            addIdToAnimal(animal);
        }

        animaisSemInstacao.add(animal);
    }

    // remove animals from the zoo or instalacao
    public void removeAnimal(Animal animal) {
        todosAnimais.remove(animal);
        if (animaisSemInstacao.contains(animal)) {
            animaisSemInstacao.remove(animal);
        }
        Obituario.add(animal);
    }

    public void removerAnimalSemInstalacao(Animal animal) {
        animaisSemInstacao.remove(animal);
    }

    // add or remove money from the zoo
    public void decreaseZooMoney(Double money) {
        saldoContabilistico -= money;
    }

    public void increaseZooMoney(Double money) {
        saldoContabilistico += money;
    }

    // methods
    public void calcProbFugir() {
        // TODO - calculate the probability of an animal to escape based on money it has
    }

    // toString
    @Override
    public String toString() {
        String s = "Zoo: \n";
        s += "Saldo Contabilistico: " + saldoContabilistico + "\n";
        s += "Probabilidade de Fugir: " + probFugir + "\n";
        s += "Numero de Animais: " + numeroAnimais + "\n";
        s += "--------------------------------------------\n";
        s += "                   Animais                  \n";
        s += "--------------------------------------------\n";
        for (Animal animal : todosAnimais) {
            s += animal.toString();
            s += "--------------------------------------------\n";
        }
        s += "Animais sem instalacao: \n";
        s += "[ ";
        for (Animal animal : animaisSemInstacao) {
            s += animal.getId() + " ";
        }
        s += "]\n";
        s += "--------------------------------------------\n";
        s += "                 Instalacoes                \n";
        s += "--------------------------------------------\n";

        for (Instalacao instalacao : instalacoes) {
            s += instalacao.toString();
            s += "--------------------------------------------\n";
        }
        return s;
    }

    // ad ids
    private void addIdToAnimal(Animal animal) { // receives an animal and adds an id to it
        animal.setId(numeroAnimais);
        numeroAnimais++;
    }

    private void addIdToInstalacao(Instalacao instalacao) { // receives an instalacao and adds an id to it
        instalacao.setId(numeroInstalacoes);
        numeroInstalacoes++;
    }
}
