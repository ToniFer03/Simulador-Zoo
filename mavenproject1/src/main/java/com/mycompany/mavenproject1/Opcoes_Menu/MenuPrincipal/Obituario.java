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
        voltarMenu();
    }

    private void mostrarObituario() {
        for (Animal animal : menu.getZoo().getObituario()) {
            System.out.println(animal);
        }
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
