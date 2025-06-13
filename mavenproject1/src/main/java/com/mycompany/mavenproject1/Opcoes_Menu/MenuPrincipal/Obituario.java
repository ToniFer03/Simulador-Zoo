package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class Obituario extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class Obituario
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public Obituario(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        mostrarObituario();
        menu.showMenu();
    }

    /**
     * Shows the obituary of the Zoo to the user
     */
    private void mostrarObituario() {
        if (menu.getZoo().getObituario().isEmpty()) {
            System.out.println("Não existem animais no obituario.");
            menu.showMenu();
        } else {
            System.out.println("\n");
            System.out.println("Os animais que estão no obituario são: ");
            for (Animal animal : menu.getZoo().getObituario()) {
                System.out.println("----------------------------------------");
                System.out.print(animal.basicInfo());
                System.out.println("----------------------------------------\n");
            }
        }
    }
}
