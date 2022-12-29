package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DigitarEspecies extends OpcaoMenu {

    private MenuDigitarDados menu;

    public DigitarEspecies(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        createEspecie();
        menu.showMenu();
    }

    private ArrayList<CaracteristicasEspecie> createCaracteristicasEspecies() {
        System.out.print("Digite o número de características da espécie: ");
        int num = getInt();
        ArrayList<CaracteristicasEspecie> caracteristicas = new ArrayList<CaracteristicasEspecie>();
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o nome da característica: ");
            String nome = getString();

            System.out.print("Digite o valor da característica [0.0 - 10.0]: ");
            double valor = getDouble();
            if (valor > 10.0) {
                System.out.print("Erro! Valor deve ser menor ou igual a 10.0, digite novamente: ");
                valor = getDouble();
            }

            CaracteristicasEspecie caracteristica = new CaracteristicasEspecie(nome, valor);
            caracteristicas.add(caracteristica);
        }
        return caracteristicas;
    }

    private void createEspecie() {
        System.out.print("\n");
        System.out.print("Digite o nome da espécie: ");
        String nome = getString();

        System.out.print("Digite a esperança de vida da espécie: ");
        int idade = getInt();

        System.out.print("Digite a atratividade base da espécie [0.0 - 10.0]: ");
        double atratividade = getDouble();
        if (atratividade > 10.0) {
            System.out.print("Erro! Digite um número entre 0.0 e 10.0: ");
            atratividade = getDouble();
        }

        System.out.print("Digite o custo da ração base da espécie: ");
        double custo = getDouble();

        System.out.print("Digite a probabilidade de nascimento da espécie [0.00 - 1.00]: ");
        double prob = getDouble();
        if (prob > 1.0) {
            System.out.print("Erro! Digite um número entre 0.00 e 1.00: ");
            prob = getDouble();
        }

        Especie especie = new Especie(nome, idade, atratividade, custo, prob, createCaracteristicasEspecies());
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
        Scanner sd = new Scanner(System.in);
        sd.useLocale(Locale.ROOT);
        if (sd.hasNextDouble()) {
            double d = sd.nextDouble();
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

    private int getInt() {
        Scanner si = new Scanner(System.in);
        if (si.hasNextInt()) {
            int i = si.nextInt();
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
