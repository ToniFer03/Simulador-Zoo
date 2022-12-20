package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Scanner;

//Referente a opção de menu "Adquirir animal com características genéticas"
public class AdqAnimalCaracGen extends OpcaoMenu {

    MenuPrincipal menu;
    MenuAdqAnimalCarc menuAdqAnimalCarc;

    // constructor
    public AdqAnimalCaracGen(MenuPrincipal menu) {
        super();
        this.menu = menu;
        menuAdqAnimalCarc = new MenuAdqAnimalCarc(menu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        menuAdqAnimalCarc.showMenu();
        voltarMenu();
    }

    private void showText() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Selecione a característica genética que deseja adquirir:");
        for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size()
                + CaracteristicasEspecie.getCaracteristicasEspecie().size(); i++) {
            if (i < CaracteristicasEspecie.getCaracteristicasEspecie().size()) {
                System.out.println("[" + i + "] - "
                        + CaracteristicasEspecie.getCaracteristicasEspecie().get(i).getCaracteristicas());
            } else {
                System.out.println("[" + i + "] - "
                        + CaractristicaIndividual.getCaracteristicasIndividuais()
                                .get(i - CaracteristicasEspecie.getCaracteristicasEspecie().size())
                                .getCaracteristicas());
            }
        }
        System.out.print("Opção: ");
        int opcao = input.nextInt();
        addAnimal(opcao);
    }

    private void addAnimal(int opcao) {
        if (opcao < CaracteristicasEspecie.getCaracteristicasEspecie().size()) {
            Animal ani = AuxRand.randomAnimal();

            if (ani.getCaracteristicasEspecie()
                    .contains(CaracteristicasEspecie.getCaracteristicasEspecie().get(opcao))) {
                menu.getZoo().addAnimal(ani);
                System.out.println("si");
            } else {
                // addAnimal(opcao);
                System.out.println(CaracteristicasEspecie.getCaracteristicasEspecie().get(opcao));
            }

        } else {

        }
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }

}
