package com.mycompany.mavenproject1;

public class sairMenu extends OpcaoMenu {

    // constructor
    public sairMenu(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        voltarMenu();
    }
}
