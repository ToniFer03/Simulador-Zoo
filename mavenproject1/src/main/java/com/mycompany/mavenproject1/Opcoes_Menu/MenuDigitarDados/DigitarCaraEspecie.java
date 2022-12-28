package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class DigitarCaraEspecie extends OpcaoMenu {

    private MenuDigitarDados menu;

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
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome da característica: ");
        String nome = sc.nextLine();
        System.out.print("Digite o valor da característica: ");
        double valor = sc.nextDouble();
        CaracteristicasEspecie caracteristica = new CaracteristicasEspecie(nome, valor);
    }

}
