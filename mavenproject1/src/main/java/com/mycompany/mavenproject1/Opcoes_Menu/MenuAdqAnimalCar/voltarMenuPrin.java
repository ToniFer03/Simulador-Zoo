package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class voltarMenuPrin extends OpcaoMenu {
    private MenuPrincipal menu;

    /**
     * Constructor of VoltarMenuPrin, receives an object from the Menu it was called as a parameter
     *
     * @param menu Object of the Menu that called this option
     */
    public voltarMenuPrin(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        System.out.println("A voltar ao menu principal...");
        menu.showMenu();
    }

}
