package com.mycompany.mavenproject1;

//referente a opção de menu "Calendário Chinês"
public class CalendChines extends OpcaoMenu {

    // constructor
    public CalendChines(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }
}
