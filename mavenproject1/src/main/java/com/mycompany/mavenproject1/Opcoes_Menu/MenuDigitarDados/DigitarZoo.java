package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

import java.util.Locale;
import java.util.Scanner;

public class DigitarZoo extends OpcaoMenu {

    private MenuDigitarDados menu;

    public DigitarZoo(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        updateZoo();
        menu.showMenu();
    }

    private void updateZoo() {
        System.out.print("Digite a probabilidade de fugir dos animais [0.00 - 1.00]: ");
        Double probFugir = getDouble();
        if (probFugir > 1.0) {
            System.out.print("Erro! Probabilidade deve ser menor ou igual a 1.0, digite novamente: ");
            probFugir = getDouble();
        }

        System.out.print("Digite o saldo contabilistico do Zoo: ");
        Double saldoCont = getDouble();

        menu.getZoo().setProbFugir(probFugir);
        menu.getZoo().setSaldocoContabilistico(saldoCont);
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
