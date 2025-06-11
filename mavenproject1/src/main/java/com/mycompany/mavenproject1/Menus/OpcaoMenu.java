package com.mycompany.mavenproject1.Menus;

//abstract class that serves as a model for all the options in the menu

/**
 * Abstract class that serves as a model from all teh options in a menu
 */
public abstract class OpcaoMenu {

    /**
     * Empty constructor of the abstract class OpcaoMenu
     */
    public OpcaoMenu() {
    }

    /**
     * Abstract function meant to be implemented in Menus, meant to be implemented in menus and execute whatever option
     * the user choose in that menu
     */
    public abstract void executarOpcao();

}
