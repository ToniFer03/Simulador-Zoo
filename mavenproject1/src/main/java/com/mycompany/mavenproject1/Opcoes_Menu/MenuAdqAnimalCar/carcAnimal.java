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

    // constructor
    public carcAnimal(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
        this.precoCaracteristica = 500;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showText();
        menu.showMenu(); // return to the main menu
    }

    // function that shows the text of this option
    private void showText() {
        Scanner input = new Scanner(System.in);

        if (CaractristicaIndividual.getCaracteristicasIndividuais().size() == 0) {
            System.out.println("Não existem caracteristicas individuais disponiveis!");
            menu.showMenu();
        } else {
            // asks the user to select the desired characteristic
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

    private void createRandomAnimal(int opcao) throws IndexOutOfBoundsException {
        Animal ani = AuxRand.randomAnimal(); // creates a random animal

        // checks if the animal has the desired characteristic
        if (ani.getCaracteristicasIndividuais()
                .contains(CaractristicaIndividual.getCaracteristicasIndividuais().get(opcao))) {
            System.out.println("\n");
            System.out.println("Foi adquirido o seguinte animal: ");
            System.out.println(ani.basicInfo());

            // adds the animal to the zoo and decreases the zoo's money
            menu.getMenu().getZoo().addAnimalZoo(ani);
            menu.getMenu().getZoo().decreaseZooMoney(AuxRand.getRandomPreco() + precoCaracteristica);
            Historico.addAnimalAdquerido(ani);
        } else {
            // calls the funtion again until the animal has the desired characteristic
            createRandomAnimal(opcao);
        }

    }
}
