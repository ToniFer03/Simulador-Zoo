package com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class DigitarDados extends OpcaoMenu {

    private Zoo zoo;
    private MenuDigitarDados menu;

    /**
     * Constructor of class DigitarDados
     *
     * @param zoo Zoo whose information this menu will affect
     */
    public DigitarDados(Zoo zoo) {
        super();
        this.zoo = zoo;
        menu = new MenuDigitarDados(zoo);
    }

    /**
     * Override of executarOpcao from OpcaoMenu, displays the Initial Menu of the program
     */
    @Override
    public void executarOpcao() {
        menu.showMenu();
    }

}
