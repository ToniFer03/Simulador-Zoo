package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class RetratoFamilia extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class DigitarAnimais
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public RetratoFamilia(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        printZoo();
        menu.showMenu();
    }

    //TODO: Check what this function does
    private void printZoo() {
        System.out.println("\n");
        System.out.println(menu.getZoo().toString());
        menu.executarOpcao(11);
        menu.executarOpcao(12);
    }

}
