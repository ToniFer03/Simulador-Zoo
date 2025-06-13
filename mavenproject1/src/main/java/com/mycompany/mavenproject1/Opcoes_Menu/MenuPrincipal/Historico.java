package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.ArrayList;

public class Historico extends OpcaoMenu {

    private static ArrayList<Animal> animaisAdqueridos = new ArrayList<Animal>();;
    private static ArrayList<Animal> animaisNascidos = new ArrayList<Animal>();;
    private static ArrayList<Animal> animaisFugidos = new ArrayList<Animal>();;
    private static ArrayList<Double> saldoContabilistico = new ArrayList<Double>();

    private MenuPrincipal menu;

    /**
     * Constructor of class Historico
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public Historico(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
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

    /**
     * Adds an animal to teh list of acquired animals in the Zoo
     *
     * @param a Animal that was acquired
     */
    public static void addAnimalAdquerido(Animal a) {
        animaisAdqueridos.add(a);
    }

    /**
     * Adds an animal to teh list of animals that were born in the Zoo
     *
     * @param a Animal that was born
     */
    public static void addAnimalNascido(Animal a) {
        animaisNascidos.add(a);
    }

    /**
     * Adds an animal to teh list of animals that escaped the Zoo
     *
     * @param a Animal that escaped
     */
    public static void addAnimalFugido(Animal a) {
        animaisFugidos.add(a);
    }

    /**
     * Adds a change the Zoo's current account to the list
     *
     * @param d Amount that the Zoo gained/spent
     */
    public static void addSaldoContabilistico(double d) {
        saldoContabilistico.add(d);
    }

    /**
     * Prints the list of all acquired animals in the Zoo
     */
    private void printAnimaisAdqueridos() {
        System.out.println("Animais adqueridos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisAdqueridos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Prints the list of all animals that were born in the Zoo
     */
    private void printAnimaisNascidos() {
        System.out.println("Animais nascidos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisNascidos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Print the list of all animals that escaped the Zoo
     */
    private void printAnimaisFugidos() {
        System.out.println("Animais fugidos:");
        System.out.println("----------------------------------------");
        for (Animal a : animaisFugidos) {
            System.out.println(a.toString());
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Prints all the changes to the Zoo's current account
     */
    private void printSaldoContabilistico() {
        System.out.println("Histórico de saldo contabilistico:");
        System.out.println("----------------------------------------");
        for (Double d : saldoContabilistico) {
            System.out.printf("Saldo: %.2f \n", d);
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Prints the list of all animals that died in the Zoo
     */
    private void printObituario() {
        System.out.println("Obituario:");
        System.out.println("----------------------------------------");
        for (Animal a : menu.getZoo().getObituario()) {
            System.out.println(a.basicInfo());
        }
        System.out.println("----------------------------------------");
    }
}
