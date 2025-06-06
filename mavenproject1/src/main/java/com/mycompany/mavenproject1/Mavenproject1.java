package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuInicial;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;

public class Mavenproject1 {
    /**
     * Entry point into the program
     * @param args Arguments to be passed when launching the program
     */
    public static void main(String[] args) {

        Zoo zoo = initializeZoo();
       

        MenuInicial menuInicial = new MenuInicial(zoo);
        menuInicial.showMenu();

        MenuPrincipal menu = new MenuPrincipal(zoo);
        menu.showMenu();
       

    }

    /**
     * Auxiliary function that creates a Zoo object
     * @return  Zoo Object
     */
    private static Zoo initializeZoo() {

        return new Zoo(1000.0, 0.0);
    }
}
