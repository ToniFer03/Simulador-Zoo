package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class carcAnimal extends OpcaoMenu {

    MenuAdqAnimalCarc menu;

    // constructor
    public carcAnimal(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("A carregar o menu de adquirir animal...");
    }

    // function to go back
    @Override
    public void voltarMenu() {
        System.out.println("A voltar ao menu anterior...");
        menu.showMenu();
    }

}
