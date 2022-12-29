package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.ArrayList;

//referente a opcao de menu "Construir instalação"
public class Historico extends OpcaoMenu {

    private static ArrayList<Animal> animaisAdqueridos = new ArrayList<Animal>();;
    private static ArrayList<Animal> animaisNascidos = new ArrayList<Animal>();;
    private static ArrayList<Animal> animaisFugidos = new ArrayList<Animal>();;
    private static ArrayList<Double> saldoContabilistico = new ArrayList<Double>();

    private MenuPrincipal menu;

    // constructor
    public Historico(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        System.out.println("\n");
        printAnimaisAdqueridos();
        printAnimaisNascidos();
        printAnimaisFugidos();
        printSaldoContabilistico();
        printObituario();
        menu.showMenu();
    }

    public static void addAnimalAdquerido(Animal a) {
        animaisAdqueridos.add(a);
    }

    public static void addAnimalNascido(Animal a) {
        animaisNascidos.add(a);
    }

    public static void addAnimalFugido(Animal a) {
        animaisFugidos.add(a);
    }

    public static void addSaldoContabilistico(double d) {
        saldoContabilistico.add(d);
    }

    private void printAnimaisAdqueridos() {
        System.out.println("Animais adqueridos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisAdqueridos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    private void printAnimaisNascidos() {
        System.out.println("Animais nascidos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisNascidos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    private void printAnimaisFugidos() {
        System.out.println("Animais fugidos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisFugidos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    private void printSaldoContabilistico() {
        System.out.println("Histórico de saldo contabilistico:");
        System.out.println("----------------------------------------");
        for (Double d : saldoContabilistico) {
            System.out.printf("Saldo: %.2f \n", d);
        }
        System.out.println("----------------------------------------");
    }

    private void printObituario() {
        System.out.println("Obituario:");
        System.out.println("----------------------------------------");
        for (Animal a : menu.getZoo().getObituario()) {
            System.out.println(a.basicInfo());
        }
        System.out.println("----------------------------------------");
    }
}
