package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuInicial;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;

public class Mavenproject1 {

    public static void main(String[] args) {

        Zoo zoo = initializeZoo();

        MenuInicial menuInicial = new MenuInicial(zoo);
        menuInicial.showMenu();

        MenuPrincipal menu = new MenuPrincipal(zoo);
        menu.showMenu();

    }

    private static Zoo initializeZoo() {
        Zoo zoo = new Zoo(1000.0, 0.0);

        return zoo;
    }
}
