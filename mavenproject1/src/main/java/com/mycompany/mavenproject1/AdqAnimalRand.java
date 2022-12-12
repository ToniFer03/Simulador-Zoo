package com.mycompany.mavenproject1;

//referente a opção de menu "Adquirir animal aleatório"
public class AdqAnimalRand extends OpcaoMenu {

    // constructor
    public AdqAnimalRand(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }
}
