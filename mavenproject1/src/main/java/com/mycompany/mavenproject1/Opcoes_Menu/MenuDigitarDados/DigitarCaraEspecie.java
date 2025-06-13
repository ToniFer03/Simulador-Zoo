package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Locale;

public class DigitarCaraEspecie extends OpcaoMenu {

    private MenuDigitarDados menu;
    private final double MAXVAL = 10.0;

    /**
     * Constructor of class DigitarCaraEspecie
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public DigitarCaraEspecie(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        createCaraEspecie();
        menu.showMenu();
    }

    /**
     * Creates a new species specific characteristic, asks for its name and value and adds it to the list that contains
     * all species specific characteristics
     */
    private void createCaraEspecie() {

        System.out.print("Digite o nome da característica: ");
        String nome = getString();

        System.out.print("Digite o valor da característica [0.0 - 10.0]: ");
        double valor = getDouble();
        if (valor > MAXVAL) {
            System.out.print("Erro! Valor deve ser menor ou igual a 10.0, digite novamente: ");
            valor = getDouble();
        }

        CaracteristicasEspecie caracteristica = new CaracteristicasEspecie(nome, valor);
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

}
