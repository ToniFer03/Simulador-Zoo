package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;
import java.util.ArrayList;

public class DigitarAnimais extends OpcaoMenu {

    private MenuDigitarDados menu;

    public DigitarAnimais(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        Animal animal = createAnimal();
        menu.getZoo().addAnimalZoo(animal);
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

    private ArrayList<CaractristicaIndividual> createCaracteristicasIndividuais() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número de características individuais: ");
        int num = sc.nextInt();
        ArrayList<CaractristicaIndividual> caracteristicas = new ArrayList<CaractristicaIndividual>();
        for (int i = 0; i < num; i++) {
            System.out.print("Digite o nome da característica: ");
            String nome = sc.nextLine();
            System.out.print("Digite o valor da característica: ");
            double valor = sc.nextDouble();
            CaractristicaIndividual caracteristica = new CaractristicaIndividual(nome, valor);
            caracteristicas.add(caracteristica);
        }
        return caracteristicas;
    }

    private Especie createEspecie() {
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
        return especie;
    }

    private Animal createAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do animal: ");
        String nome = sc.nextLine();
        System.out.print("Digite a idade do animal: ");
        int idade = sc.nextInt();
        return new Animal(nome, idade, createEspecie(), createCaracteristicasIndividuais());
    }

}
