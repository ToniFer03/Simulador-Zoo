package com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class DigitarDados extends OpcaoMenu {

    private Zoo zoo;
    private MenuDigitarDados menu;

    public DigitarDados(Zoo zoo) {
        super();
        this.zoo = zoo;
        menu = new MenuDigitarDados(zoo);
    }

    @Override
    public void executarOpcao() {
        menu.showMenu();
    }

}
