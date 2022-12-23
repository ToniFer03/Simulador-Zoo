package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

//referente a opcao de menu "Construir instalação"
public class ListAnimaisMutacao extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ListAnimaisMutacao(MenuPrincipal menu) {
        super();
        this.menu = menu;

    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showText();
        voltarMenu();
    }

    private void showText() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Selecione a caracteristica que deseja adquirir:");
        for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size(); i++) {
            System.out.println(
                    "[" + i + "] - "
                            + CaractristicaIndividual.getCaracteristicasIndividuais().get(i).getCaracteristicas());
        }

        System.out.print("Opção: ");
        int opcao = input.nextInt();
        displayAnimals(opcao);
    }

    // falta verificar se existe algum animal com essa caracteristica e caso não
    // exista mostrar uma mensagem
    private void displayAnimals(int opcao) {
        System.out.println("\n");
        System.out.println("Os seguintes animais possuem a caracteristica selecionada: ");
        for (Animal ani : menu.getZoo().getTodosAnimais()) {
            if (ani.getCaracteristicasIndividuais()
                    .contains(
                            CaractristicaIndividual.getCaracteristicasIndividuais().get(opcao))) {
                System.out.println("----------------------------------------");
                System.out.print(ani.toString());
                System.out.println("----------------------------------------\n");
            }
        }
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
