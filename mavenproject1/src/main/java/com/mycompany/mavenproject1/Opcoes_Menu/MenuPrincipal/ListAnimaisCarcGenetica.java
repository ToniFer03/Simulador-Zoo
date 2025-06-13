package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

public class ListAnimaisCarcGenetica extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ListAnimaisCarcGenetica
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ListAnimaisCarcGenetica(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        showText();
        menu.showMenu();
    }

    /**
     * Checks if there is any species specific characteristics and if there are, list them ot the user. Asks the user to
     * select one of the characteristics from the list and gives the option to another function.
     */
    private void showText() {
        if (CaracteristicasEspecie.getCaracteristicasEspecie().isEmpty()) {
            System.out.println("Não existem caracteristicas genéticas registadas.");
            menu.showMenu();
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Selecione a caracteristica que deseja adquirir:");
            for (int i = 0; i < CaracteristicasEspecie.getCaracteristicasEspecie().size(); i++) {
                System.out.println(
                        "[" + i + "] - "
                                + CaracteristicasEspecie.getCaracteristicasEspecie().get(i).getCaracteristicas());
            }

            System.out.print("Opção: ");
            int opcao = input.nextInt();
            displayAnimals(opcao);
        }
    }

    /**
     * Receives a number that represents and index in the species specif characteristics list, checks all animals and
     * displays to the user all that have that species specific characteristic
     *
     * @param opcao Number that represents the characteristic chosen by the user
     */
    private void displayAnimals(int opcao) {
        System.out.println("\n");
        System.out.println("Os seguintes animais possuem a caracteristica selecionada: ");
        for (Animal ani : menu.getZoo().getTodosAnimais()) {
            if (ani.getCaracteristicasEspecie()
                    .contains(CaracteristicasEspecie.getCaracteristicasEspecie().get(opcao))) {
                System.out.println("----------------------------------------");
                System.out.print(ani.basicInfo());
                System.out.println("----------------------------------------\n");
            }
        }
    }
}
