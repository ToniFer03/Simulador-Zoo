package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Locale;

public class DigitarCaraEspecie extends OpcaoMenu {

    private MenuDigitarDados menu;
    private final double MAXVAL = 10.0;

    public DigitarCaraEspecie(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        createCaraEspecie();
        menu.showMenu();
    }

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
