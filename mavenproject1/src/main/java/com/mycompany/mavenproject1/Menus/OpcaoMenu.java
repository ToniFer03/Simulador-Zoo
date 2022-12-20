package com.mycompany.mavenproject1.Menus;

//abstract class that serves as a model for all the options in the menu
public abstract class OpcaoMenu {

    // constructor
    public OpcaoMenu() {
    }

    // functions that executes the action of this option
    public abstract void executarOpcao();

    // function to go back
    public abstract void voltarMenu();

}
