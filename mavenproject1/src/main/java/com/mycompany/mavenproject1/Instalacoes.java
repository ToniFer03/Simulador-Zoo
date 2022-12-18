package com.mycompany.mavenproject1;

public class Instalacoes {
    private double custoTrabalhadores;
    private double custoLimpeza;
    private double custoSeguranca;
    private int lotacaoMaxima;
    private int idInstalacao;

    public Instalacoes(double custoTrabalhadores, double custoLimpeza, double custoSeguranca, int lotacaoMaxima,
            int idInstalacao) {
        this.custoTrabalhadores = custoTrabalhadores;
        this.custoLimpeza = custoLimpeza;
        this.custoSeguranca = custoSeguranca;
        this.lotacaoMaxima = lotacaoMaxima;
        this.idInstalacao = idInstalacao;
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

    // calculate cleaning costs
    public void custoLimpeza() {
        // to do
    }

    // calculate security costs
    public void custoSeguranca() {
        // to do
    }

    // calculate workers costs
    public void custoTrabalhadores() {
        // to do
    }

}
