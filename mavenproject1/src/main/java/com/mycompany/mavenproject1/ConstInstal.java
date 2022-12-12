package com.mycompany.mavenproject1;

//referente a opcao de menu "Construir instalação"
public class ConstInstal extends OpcaoMenu {

    // constructor
    public ConstInstal(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }
}
