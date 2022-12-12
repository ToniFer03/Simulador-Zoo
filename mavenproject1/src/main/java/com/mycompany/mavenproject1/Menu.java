package com.mycompany.mavenproject1;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    // declare variables
    private int menuID;

    // list that contains all the objects from all options
    private ArrayList<OpcaoMenu> opcoesMenu;

    // constructor
    public Menu() {
        menuID = 0;
        opcoesMenu = new ArrayList<OpcaoMenu>();
        opcoesMenu.add(new AdqAnimalRand(this));
        opcoesMenu.add(new AdqAnimalCaracGen(this));
        opcoesMenu.add(new ConstInstal(this));
        opcoesMenu.add(new CalendChines(this));
        opcoesMenu.add(new ListAnimais(this));
        opcoesMenu.add(new ListAnimaisCarcGenetica(this));
        opcoesMenu.add(new ListAnimaisMutacao(this));
        opcoesMenu.add(new ListInstal(this));
        opcoesMenu.add(new RetratoFamilia(this));
        opcoesMenu.add(new Obituario(this));
        opcoesMenu.add(new Historico(this));
        opcoesMenu.add(new PeriodoConta(this));
        opcoesMenu.add(new Jumanji(this));
    }

    // show menu options
    public void showMenu() {
        System.out.println("Escolha uma das seguintes opções: ");
        System.out.println("[1] - Adquirir animal aleatório");
        System.out.println("[2] - Adquirir animal com característica genética");
        System.out.println("[3] - Construir instalação");
        System.out.println("[4] - Calendário chinês");
        System.out.println("[5] - Listar animais");
        System.out.println("[6] - Listar animais com dada característica genética");
        System.out.println("[7] - Listar animais com dada mutação");
        System.out.println("[8] - Listar instalações");
        System.out.println("[9] - Retrato de família animal");
        System.out.println("[10] - Obituário");
        System.out.println("[11] - Histórico");
        System.out.println("[12] - Período contabilístico");
        System.out.println("[13] - Jumanji");
        System.out.println("[14] - Sair da aplicação");
        System.out.print("Digite a sua opção: ");
        menuID = getOption();
        System.out.println(menuID);
        executeItem(menuID);
    }

    // function to get the option inputed by the user
    private int getOption() {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        return option;
    }

    // function to select the action to be taken based on the inputed option
    private void executeItem(int menuID) {
        switch (menuID) {
            case 1:
                opcoesMenu.get(0).executarOpcao();
                break;
            case 2:
                opcoesMenu.get(1).executarOpcao();
                break;
            case 3:
                opcoesMenu.get(2).executarOpcao();
                break;
            case 4:
                opcoesMenu.get(3).executarOpcao();
                break;
            case 5:
                opcoesMenu.get(4).executarOpcao();
                break;
            case 6:
                opcoesMenu.get(5).executarOpcao();
                break;
            case 7:
                opcoesMenu.get(6).executarOpcao();
                break;
            case 8:
                opcoesMenu.get(7).executarOpcao();
                break;
            case 9:
                opcoesMenu.get(8).executarOpcao();
                break;
            case 10:
                opcoesMenu.get(9).executarOpcao();
                break;
            case 11:
                opcoesMenu.get(10).executarOpcao();
                break;
            case 12:
                opcoesMenu.get(11).executarOpcao();
                break;
            case 13:
                opcoesMenu.get(12).executarOpcao();
                break;
            case 14:
                System.out.println("A sair da aplicação...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida");
                showMenu();
                break;
        }
    }
}
