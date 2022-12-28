package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class DigitarCaraIndividual extends OpcaoMenu {

    private MenuDigitarDados menu;

    public DigitarCaraIndividual(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        createCaraIndividual();
        menu.showMenu();
    }

    private void createCaraIndividual() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome da característica: ");
        String nome = sc.nextLine();
        System.out.print("Digite o valor da característica: ");
        double valor = sc.nextDouble();
        CaractristicaIndividual caracteristica = new CaractristicaIndividual(nome, valor);
    }

}
