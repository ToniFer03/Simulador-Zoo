package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class Instalacao {
    // atributs
    private double custoTrabalhadores;
    private double custoLimpeza;
    private int lotacaoMaxima;
    private int idInstalacao;
    private ArrayList<Animal> animais;

    // constructor
    public Instalacao(int lotacaoMaxima,
            int idInstalacao) {
        this.custoTrabalhadores = 5;
        this.custoLimpeza = 5;
        this.lotacaoMaxima = lotacaoMaxima;
        this.idInstalacao = idInstalacao;
        animais = new ArrayList<Animal>(lotacaoMaxima);
    }

    // getters
    public double getCustoTrabalhadores() {
        return custoTrabalhadores;
    }

    public double getCustoLimpeza() {
        return custoLimpeza;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public int getIdInstalacao() {
        return idInstalacao;
    }

    // set id
    public void setId(int id) {
        this.idInstalacao = id;
    }

    // methods
    public void addAnimal(Animal animal, int posicao) {
        if (animais.size() < lotacaoMaxima) {
            animais.add(animal);
            aumentarCustoLimpeza();
            aumentarCustoTrabalhadores();
        } else {
            animais.set(posicao, animal);
            aumentarCustoLimpeza();
            aumentarCustoTrabalhadores();
        }
    }

    public void removeAnimal(Animal animal) {
        animais.remove(animal);
        if (animais.size() == 0) {
            this.custoLimpeza = 5;
            this.custoTrabalhadores = 5;
        }
    }

    // get all animals in the instalation
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    // increase cleaning cost by 10 +- random number
    private void aumentarCustoLimpeza() {
        this.custoLimpeza += 10 + (Math.random() * 10);
    }

    // increase workers cost by 10 +- random number
    private void aumentarCustoTrabalhadores() {
        this.custoTrabalhadores += 10 + (Math.random() * 10);
    }

    // toString
    @Override
    public String toString() {
        String info;
        info = "---------------------------------- \n";
        info += "ID Instalacao: " + idInstalacao + "\n";
        info += "Custo Trabalhadores: " + custoTrabalhadores + "\n";
        info += "Custo Limpeza: " + custoLimpeza + "\n";
        info += "Lotacao Maxima: " + lotacaoMaxima + "\n";
        for (Animal animal : animais) {
            info += animal.toString();
        }
        info += "---------------------------------- \n";

        return info;
    }

}
