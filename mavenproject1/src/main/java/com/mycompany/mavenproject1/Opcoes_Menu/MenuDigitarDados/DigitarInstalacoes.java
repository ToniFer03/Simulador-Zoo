package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Locale;
import java.util.Scanner;

public class DigitarInstalacoes extends OpcaoMenu {

    private MenuDigitarDados menu;

    /**
     * Constructor of class DigitarInstalacoes
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public DigitarInstalacoes(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        createInstalacao();
        menu.showMenu();
    }

    /**
     * Function that asks the user for the specifics of a new enclosure, first asks the capacity, the cost of workers
     * and the cost of cleaning, adds the enclosure to the zoo
     */
    private void createInstalacao() {
        System.out.print("Digite a lotação da instação: ");
        int lotacao = getInt();
        System.out.print("Digite o custo de trabalhadores da instação: ");
        double custoTrabalhadores = getDouble();
        System.out.print("Digite o custo de limpeza da instação: ");
        double custoLimpeza = getDouble();
        Instalacao instalacao = new Instalacao(lotacao, custoTrabalhadores, custoLimpeza);
        menu.getZoo().addInstalacaoZoo(instalacao);
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
