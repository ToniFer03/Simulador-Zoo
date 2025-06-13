package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class AdqAnimalRand extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class AdqAnimalRand
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public AdqAnimalRand(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        getRandomAnimals();
        menu.showMenu();
    }

    /***
     * Receives three objects of the class animals, gives them random prices and shows the animals as well as the price
     * to the user for him to choose. As soon as an animal is chosen, adds it to the Zoo, decreases the money of the
     * current account of the Zoo and adds the information to the History of the Zoo.
     *
     * @param a1 Object of type animal number 1
     * @param a2 Object of type animal number 1
     * @param a3 Object of type animal number 1
     */
    private void showAnimals(Animal a1, Animal a2, Animal a3) {
        Scanner sc = new Scanner(System.in);
        double price1 = AuxRand.getRandomPreco();
        double price2 = AuxRand.getRandomPreco();
        double price3 = AuxRand.getRandomPreco();

        System.out.println("\n \n \n");
        System.out.println("Escolha um dos seguintes animais para adquirir!");
        System.out.println("----------------------------------------");
        System.out.println("Opção 1: ");
        System.out.println(a1.basicInfo());
        System.out.printf("Preço da primeira opção: %.2f \n", price1);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 2: ");
        System.out.println(a2.basicInfo());
        System.out.printf("Preço da segunda opção: %.2f \n", price2);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 3: ");
        System.out.println(a3.basicInfo());
        System.out.printf("Preço da terceira opção: %.2f \n", price3);
        System.out.println("----------------------------------------\n\n");
        System.out.println("Opção 4: Cancelar \n");
        System.out.print("Opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                if (menu.getZoo().getSaldoContabilistico() < price1) {
                    System.out.println("Dinheiro insuficiente para adquirir o animal!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addAnimalZoo(a1);
                    menu.getZoo().decreaseZooMoney(price1);
                    Historico.addAnimalAdquerido(a1);
                }
                break;
            case "2":
                if (menu.getZoo().getSaldoContabilistico() < price2) {
                    System.out.println("Dinheiro insuficiente para adquirir o animal!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addAnimalZoo(a2);
                    menu.getZoo().decreaseZooMoney(price2);
                    Historico.addAnimalAdquerido(a2);
                }
                break;
            case "3":
                if (menu.getZoo().getSaldoContabilistico() < price3) {
                    System.out.println("Dinheiro insuficiente para adquirir o animal!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addAnimalZoo(a3);
                    menu.getZoo().decreaseZooMoney(price3);
                    Historico.addAnimalAdquerido(a3);
                }
                break;
            case "4":
                System.out.println("Operação cancelada!");
                menu.showMenu();
                break;
            default:
                System.out.println("Opção inválida! Voltando ao menu principal...");
                break;
        }
    }

    /**
     * Generates 3 random objects of the class animal and calls a function to show them to the user
     */
    private void getRandomAnimals() {
        try {
            Animal a1 = AuxRand.randomAnimal();
            Animal a2 = AuxRand.randomAnimal();
            Animal a3 = AuxRand.randomAnimal();
            showAnimals(a1, a2, a3);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro, alguma das informações para criar o animal não foram encontradas!");
            menu.showMenu();
        }
    }
}
