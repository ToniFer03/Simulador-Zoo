package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class DigitarAnimais extends OpcaoMenu {

    private MenuDigitarDados menu;
    private final double MAXVAL = 10.0;
    private final double MAXPROB = 1.0;

    /**
     * Constructor of class DigitarAnimais
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public DigitarAnimais(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        Animal animal = createAnimal();
        menu.getZoo().addAnimalZoo(animal);
        menu.showMenu();
    }

    /**
     * Function that asks the user the number os species specific characteristics it wants to create, and the specifics
     * of those characteristics.
     *
     * @return Returns the array of species specific characteristics
     */
    private ArrayList<CaracteristicasEspecie> createCaracteristicasEspecies() {
        System.out.print("\n");
        System.out.print("Digite o número de características da espécie: ");
        int num = getInt();
        ArrayList<CaracteristicasEspecie> caracteristicas = new ArrayList<CaracteristicasEspecie>();
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o nome da característica: ");
            String nome = getString();

            System.out.print("Digite o valor da característica [0.0 - 10.0]: ");
            double valor = getDouble();
            if (valor > MAXVAL) {
                System.out.print("Erro! Digite um número entre 0.0 e 10.0: ");
                valor = getDouble();
            }

            CaracteristicasEspecie caracteristica = new CaracteristicasEspecie(nome, valor);
            caracteristicas.add(caracteristica);
        }
        return caracteristicas;
    }

    /**
     * Function that asks the user the number of individual characteristics it wants to create, and the specifics of
     * those characteristics.
     *
     * @return Returns the array of Individual characteristics
     */
    private ArrayList<CaractristicaIndividual> createCaracteristicasIndividuais() {
        System.out.print("\n");
        System.out.print("Digite o número de características individuais: ");
        int num = getInt();
        ArrayList<CaractristicaIndividual> caracteristicas = new ArrayList<CaractristicaIndividual>();
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o nome da característica: ");
            String nome = getString();

            System.out.print("Digite o valor da característica [0.0 - 10.0]: ");
            double valor = getDouble();
            if (valor > MAXVAL) {
                System.out.print("Erro! Digite um número entre 0.0 e 10.0: ");
                valor = getDouble();
            }

            CaractristicaIndividual caracteristica = new CaractristicaIndividual(nome, valor);
            caracteristicas.add(caracteristica);
        }
        return caracteristicas;
    }

    /**
     * Function that allows the user to create a species, asks the name of the species as well as the specific
     * characteristics it needs to have
     *
     * @return The new species that was created
     */
    private Especie createEspecie() {
        System.out.print("\n");
        System.out.print("Digite o nome da espécie: ");
        String nome = getString();

        System.out.print("Digite a esperança de vida da espécie: ");
        int idade = getInt();

        System.out.print("Digite a atratividade base da espécie [0.0 - 10.0]: ");
        double atratividade = getDouble();
        if (atratividade > MAXVAL) {
            System.out.print("Erro! Digite um número entre 0.0 e 10.0: ");
            atratividade = getDouble();
        }

        System.out.print("Digite o custo da ração base da espécie: ");
        double custo = getDouble();

        System.out.print("Digite a probabilidade de nascimento da espécie [0.00 - 1.00]: ");
        double prob = getDouble();
        if (prob > MAXPROB) {
            System.out.print("Erro! Digite um número entre 0.00 e 1.00: ");
            prob = getDouble();
        }

        Especie especie = new Especie(nome, idade, atratividade, custo, prob, createCaracteristicasEspecies());
        return especie;
    }

    /**
     * Function that allows the user to create an animal, asks the name of the animal as well as the specific
     * characteristics it needs to have
     *
     * @return The new animal that was created
     */
    private Animal createAnimal() {
        System.out.print("\n");
        System.out.print("Digite o nome do animal: ");
        String nome = getString();
        System.out.print("Digite a idade do animal: ");
        int idade = getInt();
        return new Animal(nome, idade, createEspecie(), createCaracteristicasIndividuais());
    }

    /**
     * Method to get a string from the console
     *
     * @return String that was typed in the console
     */
    private String getString() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() > 0) {
                return s;
            } else {
                System.out.print("Erro! Nome vazio, digite novamente: ");
                return getString();
            }
        } else {
            System.out.print("Erro! Digite novamente: ");
            return getString();
        }
    }

    /**
     * Method to get a number with decimals from the console
     *
     * @return the number that was typed in the console
     */
    private Double getDouble() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ROOT);
        if (sc.hasNextDouble()) {
            double d = sc.nextDouble();
            if (d > 0) {
                return d;
            } else {
                System.out.print("Erro! Digite um número positivo: ");
                return getDouble();
            }
        } else {
            System.out.print("Erro! Digite um número válido: ");
            return getDouble();
        }
    }

    /**
     * Method to get an integer from the console
     *
     * @return the number that was typed in the console
     */
    private int getInt() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int i = sc.nextInt();
            if (i > 0) {
                return i;
            } else {
                System.out.print("Erro! Digite um número inteiro positivo: ");
                return getInt();
            }
        } else {
            System.out.print("Erro! Digite um número inteiro: ");
            return getInt();
        }
    }

}
