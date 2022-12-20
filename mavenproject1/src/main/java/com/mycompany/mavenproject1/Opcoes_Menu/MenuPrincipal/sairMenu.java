package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class sairMenu extends OpcaoMenu {

    MenuPrincipal menu;

    // constructor
    public sairMenu(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("A sair da aplicação...");
        System.exit(0);
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
