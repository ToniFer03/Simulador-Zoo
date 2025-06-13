package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class AdqAnimalCaracGen extends OpcaoMenu {

    private MenuPrincipal menu;
    private MenuAdqAnimalCarc menuAdqAnimalCarc;

    /**
     * Constructor of class AdqAnimalCaracGen
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public AdqAnimalCaracGen(MenuPrincipal menu) {
        super();
        this.menu = menu;
        menuAdqAnimalCarc = new MenuAdqAnimalCarc(menu);
    }

    /**
     * Override of executarOpcao from OpcaoMenu, shows a new menu to the user
     */
    @Override
    public void executarOpcao() {
        menuAdqAnimalCarc.showMenu();
    }

}
