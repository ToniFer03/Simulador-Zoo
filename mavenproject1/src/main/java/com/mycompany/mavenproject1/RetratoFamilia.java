package com.mycompany.mavenproject1;

//referente a opcao de menu "Construir instalação"
public class RetratoFamilia extends OpcaoMenu {

    // constructor
    public RetratoFamilia(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }

}