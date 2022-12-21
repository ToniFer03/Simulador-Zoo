package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//Referente a opção de menu "Adquirir animal com características genéticas"
public class AdqAnimalCaracGen extends OpcaoMenu {

    private MenuPrincipal menu;
    private MenuAdqAnimalCarc menuAdqAnimalCarc;

    // constructor
    public AdqAnimalCaracGen(MenuPrincipal menu) {
        super();
        this.menu = menu;
        menuAdqAnimalCarc = new MenuAdqAnimalCarc(menu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        menuAdqAnimalCarc.showMenu();
        voltarMenu();
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }

}
