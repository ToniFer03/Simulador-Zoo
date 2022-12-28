package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opcao de menu "Construir instalação"
public class RetratoFamilia extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public RetratoFamilia(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        printZoo();
        menu.showMenu();
    }

    private void printZoo() {
        System.out.println(menu.getZoo().toString());
        menu.executarOpcao(11);
        menu.executarOpcao(12);
    }

}
