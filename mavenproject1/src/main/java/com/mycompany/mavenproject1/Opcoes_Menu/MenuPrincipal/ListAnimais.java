package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class ListAnimais extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ListAnimais
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ListAnimais(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        listarAnimais();
        menu.showMenu();
    }

    /**
     * Prints all the animals that the Zoo currently possesses
     */
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
