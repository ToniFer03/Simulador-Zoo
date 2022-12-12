package com.mycompany.mavenproject1;

//referente a opcao de menu "Construir instalação"
public class Obituario extends OpcaoMenu {

    // constructor
    public Obituario(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }

}
