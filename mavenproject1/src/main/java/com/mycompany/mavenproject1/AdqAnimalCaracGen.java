package com.mycompany.mavenproject1;

//Referente a opção de menu "Adquirir animal com características genéticas"
public class AdqAnimalCaracGen extends OpcaoMenu {

    // constructor
    public AdqAnimalCaracGen(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }

}
