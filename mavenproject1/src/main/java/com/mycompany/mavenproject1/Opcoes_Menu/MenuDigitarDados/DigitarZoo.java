package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a probabilidade de fugir dos animais: ");
        Double probFugir = sc.nextDouble();
        System.out.print("Digite o saldo contabilistico do Zoo: ");
        Double saldoCont = sc.nextDouble();
        menu.getZoo().setProbFugir(probFugir);
        menu.getZoo().setSaldocoContabilistico(saldoCont);
    }
}
