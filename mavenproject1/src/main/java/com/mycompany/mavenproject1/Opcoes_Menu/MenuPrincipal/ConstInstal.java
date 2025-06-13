package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Scanner;

public class ConstInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ConstInstal
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ConstInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        getRandomInstal();
        menu.showMenu();
    }

    /**
     * Receives 3 objects of class Instalacao, gives them a random price and shows the enclosures as long with the price
     * for the user to pick.
     * Having chosen 1 option, checks if there is enough money in the Zoo's current account to proceed with the
     * operation and if there is, adds the enclosure to the Zoo
     *
     * @param instal1 Random object of class Instacao number 1
     * @param instal2 Random object of class Instacao number 2
     * @param instal3 Random object of class Instacao number 3
     */
    private void showInstals(Instalacao instal1, Instalacao instal2, Instalacao instal3) {
        Scanner sc = new Scanner(System.in);
        double price1 = AuxRand.getRandomPreco();
        double price2 = AuxRand.getRandomPreco();
        double price3 = AuxRand.getRandomPreco();

        System.out.println("\n \n \n");
        System.out.println("Escolha um dos seguintes animais para adquirir!");
        System.out.println("----------------------------------------");
        System.out.println("Opção 1: ");
        System.out.println(instal1.basicInfo());
        System.out.printf("Preço da primeira opção: %.2f \n", price1);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 2: ");
        System.out.println(instal2.basicInfo());
        System.out.printf("Preço da segunda opção: %.2f \n", price2);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 3: ");
        System.out.println(instal3.basicInfo());
        System.out.printf("Preço da terceira opção: %.2f \n", price3);
        System.out.println("----------------------------------------\n\n");
        System.out.println("Opção 4: Cancelar \n");
        System.out.print("Opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                if (menu.getZoo().getSaldoContabilistico() < price1) {
                    System.out.println("Não tem dinheiro suficiente para comprar esta instalação!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addInstalacaoZoo(instal1);
                    menu.getZoo().decreaseZooMoney(price1);
                }
                break;
            case "2":
                if (menu.getZoo().getSaldoContabilistico() < price2) {
                    System.out.println("Não tem dinheiro suficiente para comprar esta instalação!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addInstalacaoZoo(instal2);
                    menu.getZoo().decreaseZooMoney(price2);
                }
                break;
            case "3":
                if (menu.getZoo().getSaldoContabilistico() < price3) {
                    System.out.println("Não tem dinheiro suficiente para comprar esta instalação!");
                    menu.showMenu();
                } else {
                    menu.getZoo().addInstalacaoZoo(instal3);
                    menu.getZoo().decreaseZooMoney(price3);
                }
            case "4":
                System.out.println("Operação cancelada!");
                menu.showMenu();
                break;
            default:
                break;
        }
    }

    /**
     * Generates 3 enclosures and passes them as argument to a function that will show them to the user
     */
    private void getRandomInstal() {
        Instalacao instal1 = AuxRand.randomInstalacao();
        Instalacao instal2 = AuxRand.randomInstalacao();
        Instalacao instal3 = AuxRand.randomInstalacao();

        showInstals(instal1, instal2, instal3);
    }
}
