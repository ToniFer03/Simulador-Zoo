package com.mycompany.mavenproject1;

import java.util.Scanner;

//referente a opção de menu "Adquirir animal aleatório"
public class AdqAnimalRand extends OpcaoMenu {

    // constructor
    public AdqAnimalRand(Menu parentMenu) {
        super(parentMenu);
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
                super.getZoo().addAnimal(a1);
                super.getZoo().decreaseZooMoney(price1);
                break;
            case "2":
                super.getZoo().addAnimal(a2);
                super.getZoo().decreaseZooMoney(price2);
                break;
            case "3":
                super.getZoo().addAnimal(a3);
                super.getZoo().decreaseZooMoney(price3);
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
        Animal a1 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());
        Animal a2 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());
        Animal a3 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());

        // show the animals and ask the user to choose one
        showAnimals(a1, a2, a3);

    }

}
