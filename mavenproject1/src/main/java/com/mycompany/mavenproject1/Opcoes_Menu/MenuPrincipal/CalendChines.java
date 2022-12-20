package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opção de menu "Calendário Chinês"
public class CalendChines extends OpcaoMenu {

    MenuPrincipal menu;

    // constructor
    public CalendChines(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("Teste bem sucedido!");
        voltarMenu();
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
