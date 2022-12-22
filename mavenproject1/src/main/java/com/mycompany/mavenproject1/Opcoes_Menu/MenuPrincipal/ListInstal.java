package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opcao de menu "Construir instalação"
public class ListInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ListInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showInstalacoes();
        voltarMenu();
    }

    private void showInstalacoes() {
        System.out.println("\n");
        System.out.println("As instalações que este zoo possui são: ");
        for (Instalacao inst : menu.getZoo().getInstalacoes()) {
            System.out.println("----------------------------------------");
            System.out.print(inst.toString());
            System.out.println("----------------------------------------\n");
        }
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
