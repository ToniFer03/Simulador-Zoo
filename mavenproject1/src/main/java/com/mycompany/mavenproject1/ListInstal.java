package com.mycompany.mavenproject1;

//referente a opcao de menu "Construir instalação"
public class ListInstal extends OpcaoMenu {

    // constructor
    public ListInstal(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }
}
