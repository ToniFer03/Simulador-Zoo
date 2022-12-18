package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Instalacao {
    private double custoTrabalhadores;
    private double custoLimpeza;
    private double custoSeguranca;
    private int lotacaoMaxima;
    private int idInstalacao;
    private ArrayList<Animal> animais;

    public Instalacao(int lotacaoMaxima,
            int idInstalacao) {
        this.custoTrabalhadores = 0;
        this.custoLimpeza = 0;
        this.custoSeguranca = 0;
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

    public double getCustoSeguranca() {
        return custoSeguranca;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public int getIdInstalacao() {
        return idInstalacao;
    }

    public void setId(int id) {
        this.idInstalacao = id;
    }

    public void addAnimal(Animal animal, int posicao) {
        if (animais.size() < lotacaoMaxima) {
            animais.add(animal);
        } else {
            // logica para substituir um animal
        }
    }

    public void removeAnimal(Animal animal) {
        animais.remove(animal);
    }

    // get all animals in the instalation
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

}
