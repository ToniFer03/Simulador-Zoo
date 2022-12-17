package com.mycompany.mavenproject1;

public class Instalacoes {
    private int custoTrabalhadores;
    private int custoLimpeza;
    private int custoSeguranca;
    private int idInstalacao;

    public Instalacoes(int custoTrabalhadores, int custoLimpeza, int custoSeguranca) {
        this.custoTrabalhadores = custoTrabalhadores;
        this.custoLimpeza = custoLimpeza;
        this.custoSeguranca = custoSeguranca;
    }

    // getters
    public int getCustoTrabalhadores() {
        return custoTrabalhadores;
    }

    public int getCustoLimpeza() {
        return custoLimpeza;
    }

    public int getCustoSeguranca() {
        return custoSeguranca;
    }

    public int getIdInstalacao() {
        return idInstalacao;
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
