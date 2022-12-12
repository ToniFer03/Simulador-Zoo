package com.mycompany.mavenproject1;

//abstract class that serves as a model for all the options in the menu
public abstract class OpcaoMenu {
    // declare variables
    private Menu parentMenu; // menu a que pertence a opção

    // constructor
    public OpcaoMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    // functions that executes the action of this option
    public abstract void executarOpcao();

    // function to get back to the menu
    public void voltarMenu() {
        parentMenu.showMenu();
    }
}
