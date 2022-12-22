package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Obituario;

public class Zoo {
    // attributes
    private double saldoContabilistico;
    private double probFugir;
    private int numeroAnimais; // to keep track of what id to atribute
    private int numeroInstalacoes; // to keep track of what id to atribute
    private ArrayList<Animal> animais;
    private ArrayList<Animal> animaisSemInstacao;
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
        animais = new ArrayList<Animal>(); // array of all animals
        instalacoes = new ArrayList<Instalacao>();
        animaisSemInstacao = new ArrayList<Animal>(); // array of animals that are not in any instalacao
        Obituario = new ArrayList<Animal>();
    }

    // getters
    public double getSaldoContabilistico() {
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

    public ArrayList<Animal> getAnimaisSemInstacao() {
        return animaisSemInstacao;
    }

    public Animal getAnimaisSemInstacao(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void removerAnimalSemInstalacao(Animal animal) {
        animaisSemInstacao.remove(animal);
    }

    public Instalacao getInstalacao(int id) {
        for (Instalacao i : instalacoes) {
            if (i.getIdInstalacao() == id) {
                return i;
            }
        }
        return null;
    }

    public Animal getAnimal(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    // methods
    public void addIdToAnimal(Animal animal) { // receives an animal and adds an id to it
        animal.setId(numeroAnimais);
        numeroAnimais++;
    }

    public void addAnimalZoo(Animal animal) { // receives an animal and adds it to the zoo
        if (!animais.contains(animal)) {
            animais.add(animal);
            addIdToAnimal(animal);
        }

        animaisSemInstacao.add(animal);
    }

    public void addIdToInstalacao(Instalacao instalacao) { // receives an instalacao and adds an id to it
        instalacao.setId(numeroInstalacoes);
        numeroInstalacoes++;
    }

    public void addInstalacao(Instalacao instalacao) { // receives an instalacao and adds it to the zoo
        addIdToInstalacao(instalacao);
        instalacoes.add(instalacao);
    }

    public void calcProbFugir() {
        // TODO - calculate the probability of an animal to escape based on money it has
    }

    public void removeAnimal(Animal animal) {
        animais.remove(animal);
        if (animaisSemInstacao.contains(animal)) {
            animaisSemInstacao.remove(animal);
        }
        Obituario.add(animal);
    }

    public void decreaseZooMoney(Double money) {
        saldoContabilistico -= money;
    }

    public void increaseZooMoney(Double money) {
        saldoContabilistico += money;
    }

    public ArrayList<Animal> getObituario() {
        return Obituario;
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
        for (Animal animal : animais) {
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
}
