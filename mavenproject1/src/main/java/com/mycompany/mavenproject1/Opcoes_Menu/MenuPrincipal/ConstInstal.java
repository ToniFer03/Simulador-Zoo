package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Scanner;

//referente a opcao de menu "Construir instalação"
public class ConstInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ConstInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        getRandomInstal();
        menu.showMenu();
    }

    private void showInstals(Instalacao instal1, Instalacao instal2, Instalacao instal3) {
        Scanner sc = new Scanner(System.in);
        double price1 = AuxRand.getRandomPreco();
        double price2 = AuxRand.getRandomPreco();
        double price3 = AuxRand.getRandomPreco();

        System.out.println("\n \n \n");
        System.out.println("Escolha um dos seguintes animais para adquirir!");
        System.out.println("----------------------------------------");
        System.out.println("Opção 1: ");
        System.out.println(instal1.toString());
        System.out.printf("Preço da primeira opção: %.2f \n", price1);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 2: ");
        System.out.println(instal2.toString());
        System.out.printf("Preço da segunda opção: %.2f \n", price2);
        System.out.println("----------------------------------------\n\n");
        System.out.println("----------------------------------------");
        System.out.println("Opção 3: ");
        System.out.println(instal3.toString());
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

    private void getRandomInstal() {
        // create 3 random installations
        Instalacao instal1 = AuxRand.randomInstalacao();
        Instalacao instal2 = AuxRand.randomInstalacao();
        Instalacao instal3 = AuxRand.randomInstalacao();

        // show the installations
        showInstals(instal1, instal2, instal3);
    }
}
