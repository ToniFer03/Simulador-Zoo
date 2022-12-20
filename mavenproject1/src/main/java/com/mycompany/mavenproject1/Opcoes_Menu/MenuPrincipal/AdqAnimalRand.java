package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opção de menu "Adquirir animal aleatório"
public class AdqAnimalRand extends OpcaoMenu {

    MenuPrincipal menu;

    // constructor
    public AdqAnimalRand(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        getRandomAnimals();
        voltarMenu();
    }

    private void showAnimals(Animal a1, Animal a2, Animal a3) {
        Scanner sc = new Scanner(System.in);
        int price1 = AuxRand.getPrecoRand();
        int price2 = AuxRand.getPrecoRand();
        int price3 = AuxRand.getPrecoRand();

        System.out.println("\n \n \n");
        System.out.println("Escolha um dos seguintes animais para adquirir!");
        System.out.println("----------------------------------------");
        System.out.println("Opção 1: ");
        System.out.println(a1.toString());
        System.out.println("Preço da primeira opção: " + price1);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 2: ");
        System.out.println(a2.toString());
        System.out.println("Preço da segunda opção: " + price2);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 3: ");
        System.out.println(a3.toString());
        System.out.println("Preço da terceira opção: " + price3);
        System.out.println("----------------------------------------\n\n");
        System.out.println("Opção 4: Cancelar \n");
        System.out.print("Opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                menu.getZoo().addAnimal(a1);
                menu.getZoo().decreaseZooMoney(price1);
                break;
            case "2":
                menu.getZoo().addAnimal(a2);
                menu.getZoo().decreaseZooMoney(price2);
                break;
            case "3":
                menu.getZoo().addAnimal(a3);
                menu.getZoo().decreaseZooMoney(price3);
                break;
            case "4":
                System.out.println("Operação cancelada!");
                voltarMenu();
                break;
            default:
                break;
        }
    }

    private void getRandomAnimals() {
        // create 3 random animals
        Animal a1 = AuxRand.randomAnimal();
        Animal a2 = AuxRand.randomAnimal();
        Animal a3 = AuxRand.randomAnimal();

        // show the animals and ask the user to choose one
        showAnimals(a1, a2, a3);
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }

}
