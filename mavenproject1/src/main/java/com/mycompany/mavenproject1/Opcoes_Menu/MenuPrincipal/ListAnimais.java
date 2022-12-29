package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opcao de menu "Construir instalação"
public class ListAnimais extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ListAnimais(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        listarAnimais();
        menu.showMenu();
    }

    private void listarAnimais() {
        if (menu.getZoo().getTodosAnimais().isEmpty()) {
            System.out.println("Não existem animais registados.");
            menu.showMenu();
        } else {
            System.out.println("\n");
            System.out.println("Lista de animais:");
            System.out.println("_____________________________");
            for (int i = 0; i < menu.getZoo().getTodosAnimais().size(); i++) {
                System.out.println("-----------------------------");
                System.out.print(menu.getZoo().getTodosAnimais().get(i).basicInfo());
                System.out.println("-----------------------------\n");
            }
        }
    }
}
