package com.mycompany.mavenproject1.Menus;

import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.carcAnimal;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.carcEspecie;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar.voltarMenuPrin;

public class MenuAdqAnimalCarc extends MenuBase {

    MenuPrincipal menu;

    public MenuAdqAnimalCarc(MenuPrincipal menu) {
        super();
        this.menu = menu;
        addOpcaoMenu(new voltarMenuPrin(menu));
        addOpcaoMenu(new carcEspecie(this));
        addOpcaoMenu(new carcAnimal(this));
    }

    // show MenuAdqAnimalCarc options
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
}
