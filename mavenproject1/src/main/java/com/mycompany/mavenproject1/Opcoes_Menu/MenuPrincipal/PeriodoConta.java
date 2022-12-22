package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Classes_Principais.Animal;

//referente a opcao de menu "Construir instalação"
public class PeriodoConta extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public PeriodoConta(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        calculcarCustos();
        calcularGanhos();
        voltarMenu();
    }

    private void calculcarCustos() {
        double custoTotal = 0;

        // calcular custo das instalacoes
        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            custoTotal += i.getCustoTrabalhadores() + i.getCustoLimpeza();
        }

        // calcular custo dos animais
        for (Animal a : menu.getZoo().getAnimaisSemInstacao()) {
            custoTotal += a.calculateCustoRacao();
            System.out.println(a.toString());
        }

        menu.getZoo().decreaseZooMoney(custoTotal);
    }

    private void calcularGanhos() {
        double ganhoTotal = 0;
        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            for (Animal a : i.getAnimais()) {
                ganhoTotal += a.calculatAtratividade() * 2;
            }
        }

        menu.getZoo().increaseZooMoney(ganhoTotal);
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }

}
