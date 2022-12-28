package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import java.util.ArrayList;
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número de características da espécie: ");
        int num = sc.nextInt();
        ArrayList<CaracteristicasEspecie> caracteristicas = new ArrayList<CaracteristicasEspecie>();
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o nome da característica: ");
            String nome = sc.nextLine();
            System.out.print("Digite o valor da característica: ");
            double valor = sc.nextDouble();
            CaracteristicasEspecie caracteristica = new CaracteristicasEspecie(nome, valor);
            caracteristicas.add(caracteristica);
        }
        return caracteristicas;
    }

    private void createEspecie() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da espécie: ");
        String nome = sc.nextLine();
        System.out.print("Digite a esperança de vida da espécie: ");
        int idade = sc.nextInt();
        System.out.print("Digite a atratividade base da espécie: ");
        double atratividade = sc.nextDouble();
        System.out.print("Digite o custo da ração base da espécie: ");
        double custo = sc.nextDouble();
        System.out.print("Digite a probabilidade de nascimento da espécie: ");
        double prob = sc.nextDouble();
        Especie especie = new Especie(nome, idade, atratividade, custo, prob, createCaracteristicasEspecies());
    }
}
