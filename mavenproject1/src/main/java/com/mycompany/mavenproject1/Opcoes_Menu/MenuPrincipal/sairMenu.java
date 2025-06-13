package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class sairMenu extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class sairMenu
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public sairMenu(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, exits the program and gives that information to the user
     */
    @Override
    public void executarOpcao() {
        System.out.println("A sair da aplicação...");
        System.exit(0);
    }
}
