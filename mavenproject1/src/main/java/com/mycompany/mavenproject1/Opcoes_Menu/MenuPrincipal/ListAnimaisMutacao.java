package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

public class ListAnimaisMutacao extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ListAnimaisMutacao
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ListAnimaisMutacao(MenuPrincipal menu) {
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
     * Checks if there are any individual characteristics in the list and if there are display all of them to the user
     * and ask him to choose one to be searched for. Pass the option chosen as an argument for another function.
     */
    private void showText() {
        if (CaractristicaIndividual.getCaracteristicasIndividuais().isEmpty()) {
            System.out.println("Não existem mutações registadas.");
            menu.showMenu();
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Selecione a caracteristica que deseja procurar:");
            for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size(); i++) {
                System.out.println(
                        "[" + i + "] - "
                                + CaractristicaIndividual.getCaracteristicasIndividuais().get(i).getCaracteristicas());
            }

            System.out.print("Opção: ");
            int opcao = input.nextInt();
            displayAnimals(opcao);
        }
    }

    /**
     * Receives a number that represents and index in the individual characteristics list, checks all animals and
     * displays to the user all that have that individual characteristic
     *
     * @param opcao Number that represents the characteristic chosen by the user
     */
    private void displayAnimals(int opcao) {
        System.out.println("\n");
        System.out.println("Os seguintes animais possuem a caracteristica selecionada: ");
        for (Animal ani : menu.getZoo().getTodosAnimais()) {
            if (ani.getCaracteristicasIndividuais()
                    .contains(
                            CaractristicaIndividual.getCaracteristicasIndividuais().get(opcao))) {
                System.out.println("----------------------------------------");
                System.out.print(ani.basicInfo());
                System.out.println("----------------------------------------\n");
            }
        }
    }
}
