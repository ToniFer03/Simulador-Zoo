package com.mycompany.mavenproject1;

public class Zoo {
    // attributes
    private int saldoContabilistico;
    private double probFugir;
    private int numeroAnimais; // to keep track of what id to atribute
    private int numeroInstalacao;

    /*
     * Talvez seja necessario ter um array de instaçãoes aqui, e dentro de cada
     * instação ter um array de animais que estao la dentro. Aqui tambem podera
     * existir um array de animais para os que estao fora das instalacoes
     */

    // constructor
    public Zoo() {
        saldoContabilistico = 0;
        probFugir = 0.1;
        numeroAnimais = 0;
    }

    public Zoo(int saldoContabilistico, double probFugir) {
        this.saldoContabilistico = saldoContabilistico;
        this.probFugir = probFugir;
        numeroAnimais = 0;
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

    public int getNumeroInstalacao() {
        return numeroInstalacao;
    }

    // methods
    public void addIdToAnimal(Animal animal) { // receives an animal and adds an id to it
        animal.setId(numeroAnimais);
        numeroAnimais++;
    }

    public void addIdToInstalacao(Instalacoes instalacao) { // receives an instalacao and adds an id to it
        instalacao.setId(numeroInstalacao);
        numeroInstalacao++;
    }

    public void calcProbFugir() {
        // TODO - calculate the probability of an animal to escape based on money it has
    }

}
