package com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial;

import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class Cancelar extends OpcaoMenu {

    /**
     * Constructor of class Cancelar
     */
    public Cancelar() {
        super();
    }

    /**
     * Override of executarOpcao from OpcaoMenu, exits the program and prints that information to the user
     */
    @Override
    public void executarOpcao() {
        System.out.println("Saindo...");
        System.exit(0);
    }

}
