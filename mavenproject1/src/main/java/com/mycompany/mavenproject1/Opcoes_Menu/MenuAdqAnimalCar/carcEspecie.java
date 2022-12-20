package com.mycompany.mavenproject1.Opcoes_Menu.MenuAdqAnimalCar;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuAdqAnimalCarc;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Scanner;

public class carcEspecie extends OpcaoMenu {

    MenuAdqAnimalCarc menu;

    // constructor
    public carcEspecie(MenuAdqAnimalCarc menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione a caracteristica que deseja adquirir:");
        for (int i = 0; i < CaracteristicasEspecie.getCaracteristicasEspecie().size(); i++) {
            System.out.println(
                    "[" + i + "] - " + CaracteristicasEspecie.getCaracteristicasEspecie().get(i).getCaracteristicas());
        }

        System.out.print("Opção: ");
        int opcao = input.nextInt();
        createRandomAnimal(opcao);
    }

    private void createRandomAnimal(int opcao) {
        Animal ani = AuxRand.randomAnimal();
        System.out.print(ani.toString());
        Especie esp = AuxRand.randomEspecie();
        System.out.print(esp.toString());

        /*
         * if (ani.getCaracteristicasEspecie().contains(CaracteristicasEspecie.
         * getCaracteristicasEspecie().get(opcao))) {
         * System.out.println("Animal criado com sucesso!");
         * } else {
         * System.out.println("Animal não criado!");
         * }
         */
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
