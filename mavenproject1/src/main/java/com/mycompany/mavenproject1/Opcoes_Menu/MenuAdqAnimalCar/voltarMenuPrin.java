package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class voltarMenuPrin extends OpcaoMenu {
    private MenuPrincipal menu;

    // constructor
    public voltarMenuPrin(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("A voltar ao menu principal...");
        menu.showMenu();
    }

}
