package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal.Historico;

import java.util.Scanner;

public class carcAnimal extends OpcaoMenu {

    private final int precoCaracteristica;
    private MenuAdqAnimalCarc menu;

    /**
     * Constructor of class CarcAnimal, receives an object from the Menu it was called as a parameter and initializes
     * the price of a Characteristic as 500
     *
     * @param menu Object of the Menu that called this option
     */
    public carcAnimal(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
        this.precoCaracteristica = 500;
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
     * Executes the specifics of this option, checks if there is any Individual Characteristics, if there aren´t any it
     * returns to the menu that called this option. If the list is not empty, asks the user to choose the one he wants.
     * After that calls the function to create a random animal with the characteristic that was chosen and returns to
     * the menu that called this option.
     */
    private void showText() {
        Scanner input = new Scanner(System.in);

        if (CaractristicaIndividual.getCaracteristicasIndividuais().size() == 0) {
            System.out.println("Não existem caracteristicas individuais disponiveis!");
            menu.showMenu();
        } else {
            System.out.println("\n");
            System.out.println("Selecione a caracteristica que deseja adquirir:");
            for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size(); i++) {
                System.out.println(
                        "[" + i + "] - "
                                + CaractristicaIndividual.getCaracteristicasIndividuais().get(i).getCaracteristicas());
            }

            System.out.print("Opção: ");
            int opcao = input.nextInt();

            try {
                createRandomAnimal(opcao);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção inválida! Voltando ao menu anterior...");
                menu.showMenu();
            }
        }

    }

    /**
     * Function to create a random animal, creates a random animal and gives it a random acquisition price, if the
     * current account of the Zoo is not enough to buy the animal gives the user an error message and goes back to the
     * previous menu.
     * If the Zoo has enough money to acquire the animal, it checks if the random animal has the desired characteristic
     * and if it has not repeats the process. If the random animal does have the characteristic chosen inform the user
     * about the fact and print all the information regarding said animal, after that update the relevant information in
     * the Zoo.
     *
     * @param opcao a number that represents the index of a Characteristic chosen by the user on the Individual
     * Characteristics list.
     *
     * @throws IndexOutOfBoundsException
     */
    private void createRandomAnimal(int opcao) throws IndexOutOfBoundsException {
        //TODO: Put a maximum number of times the loop can perform or else it may become unusable
        Animal ani = AuxRand.randomAnimal();
        double precoAnimal = AuxRand.getRandomPreco() + precoCaracteristica;

        if (menu.getMenu().getZoo().getSaldoContabilistico() < precoAnimal) {
            System.out.println("Não tem dinheiro suficiente para adquirir este animal!");
            menu.showMenu();
        } else {
            if (ani.getCaracteristicasIndividuais()
                    .contains(CaractristicaIndividual.getCaracteristicasIndividuais().get(opcao))) {
                System.out.println("\n");
                System.out.println("Foi adquirido o seguinte animal: ");
                System.out.println(ani.basicInfo());

                menu.getMenu().getZoo().addAnimalZoo(ani);
                menu.getMenu().getZoo().decreaseZooMoney(precoAnimal);
                Historico.addAnimalAdquerido(ani);
            } else {
                createRandomAnimal(opcao);
            }
        }

    }
}
