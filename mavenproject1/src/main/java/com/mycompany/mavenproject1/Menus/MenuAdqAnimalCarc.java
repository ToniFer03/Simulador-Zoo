package com.mycompany.mavenproject1.Menus;

import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.carcAnimal;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.carcEspecie;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.voltarMenuPrin;

public class MenuAdqAnimalCarc extends MenuBase {

    //Main menu from which this menu was called
    private MenuPrincipal menu;

    /**
     * Constructor for the class menuAdqAnimalCarc, it is the menu to be displayed when selecting an animal to be
     * acquired
     *
     * @param menu Receives the previous menu
     */
    public MenuAdqAnimalCarc(MenuPrincipal menu) {
        super();
        this.menu = menu;
        addOpcaoMenu(new voltarMenuPrin(menu));
        addOpcaoMenu(new carcEspecie(this));
        addOpcaoMenu(new carcAnimal(this));
    }

    /**
     * Override of the abstract function show menu in MenuBase, displays the possible options in this menu
     */
    @Override
    public void showMenu() {
        System.out.println("\n \n \n");
        System.out.println("Escolha uma das seguintes opções: ");
        System.out.println("[1] - Adquirir animal com característica genética da especie");
        System.out.println("[2] - Adquirir animal com característica genética individual");
        System.out.println("[0] - Voltar ao menu anterior");
        System.out.print("Digite a sua opção: ");
        executeItem(getOption());
    }

    /**
     * @return Returns the main menu as an object
     */
    public MenuPrincipal getMenu() {
        return menu;
    }
}
