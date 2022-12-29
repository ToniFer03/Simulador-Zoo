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

    // constructor
    public Instalacao(int lotacaoMaxima, int custoTrabalhadores, int custoLimpeza) {
        this.custoTrabalhadores = custoTrabalhadores;
        this.custoLimpeza = custoLimpeza;
        this.lotacaoMaxima = lotacaoMaxima;
        this.custoTrabalhadoresInicial = custoTrabalhadores;
        this.custoLimpezaInicial = custoLimpeza;
        animais = new ArrayList<Animal>(lotacaoMaxima);
    }

    // ids
    public int getIdInstalacao() {
        return idInstalacao;
    }

    public void setId(int id) {
        this.idInstalacao = id;
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

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public Animal getAnimais(int posicao) {
        return animais.get(posicao);
    }

    // methods
    public void addAnimal(Animal animal, int posicao) {
        if (animais.size() < lotacaoMaxima) {
            animais.add(0, animal);
            aumentarCustoLimpeza();
            aumentarCustoTrabalhadores();
        } else {
            System.out.println("Lotacao maxima atingida");
        }
    }

    public void addAnimal(Animal animal) {
        if (animais.size() < lotacaoMaxima) {
            animais.add(animal);
            aumentarCustoLimpeza();
            aumentarCustoTrabalhadores();
        } else {
            System.out.println("Lotacao maxima atingida");
        }
    }

    public void removeAnimal(Animal animal) {
        animais.remove(animal);
        if (animais.size() == 0) {
            this.custoLimpeza = custoLimpezaInicial;
            this.custoTrabalhadores = custoTrabalhadoresInicial;
        }
    }

    // private methods
    private void aumentarCustoLimpeza() {
        this.custoLimpeza = custoLimpezaInicial + 10 + (Math.random() * 10);
    }

    private void aumentarCustoTrabalhadores() {
        this.custoTrabalhadores = custoTrabalhadoresInicial + 10 + (Math.random() * 10);
    }

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

    // toString
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
