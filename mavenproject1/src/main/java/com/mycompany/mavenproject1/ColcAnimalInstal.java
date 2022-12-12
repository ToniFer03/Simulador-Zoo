package com.mycompany.mavenproject1;

//referente a opcaao de menu "Colocar animal em instalação"
public class ColcAnimalInstal extends OpcaoMenu {

    // constructor
    public ColcAnimalInstal(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }
}
