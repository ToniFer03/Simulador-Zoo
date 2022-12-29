package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opcao de menu "Construir instalação"
public class Obituario extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public Obituario(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        mostrarObituario();
        menu.showMenu();
    }

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
