package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Scanner;

public class carcAnimal extends OpcaoMenu {

    private MenuAdqAnimalCarc menu;
    private final int precoCaracteristica;

    // constructor
    public carcAnimal(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
        this.precoCaracteristica = 500;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Selecione a caracteristica que deseja adquirir:");
        for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size(); i++) {
            System.out.println(
                    "[" + i + "] - "
                            + CaractristicaIndividual.getCaracteristicasIndividuais().get(i).getCaracteristicas());
        }

        System.out.print("Opção: ");
        int opcao = input.nextInt();

        createRandomAnimal(opcao);
    }

    private void createRandomAnimal(int opcao) {
        Animal ani = AuxRand.randomAnimal();

        if (ani.getCaracteristicasIndividuais()
                .contains(CaractristicaIndividual.getCaracteristicasIndividuais().get(opcao))) {
            System.out.println("\n");
            System.out.println("Foi adquirido o seguinte animal: ");
            System.out.println(ani); // adicionar maneira de ver as caracteristicas da especie
            menu.getMenu().getZoo().addAnimal(ani);
            menu.getMenu().getZoo().decreaseZooMoney(AuxRand.getPrecoRand() + precoCaracteristica);
            menu.getMenu().showMenu();
        } else {
            // calls the funtion again until the animal has the desired characteristic
            createRandomAnimal(opcao);
        }

    }

    // function to go back
    @Override
    public void voltarMenu() {
        System.out.println("A voltar ao menu anterior...");
        menu.showMenu();
    }

}
