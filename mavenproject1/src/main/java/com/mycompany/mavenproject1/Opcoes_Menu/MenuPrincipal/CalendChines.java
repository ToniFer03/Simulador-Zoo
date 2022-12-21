package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

//referente a opção de menu "Calendário Chinês"
public class CalendChines extends OpcaoMenu {

    private MenuPrincipal menu;
    private final String[] nomesCalendario;

    // constructor
    public CalendChines(MenuPrincipal menu) {
        super();
        this.menu = menu;
        this.nomesCalendario = new String[] { "Macaco", "Galo", "Cão", "Porco", "Rato", "Boi", "Tigre", "Coelho",
                "Dragão", "Serpente", "Cavalo", "Carneiro" };
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showText();
        voltarMenu();
    }

    private void showText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Digite um ano: ");
        int ano = sc.nextInt();
        aplicarBonus(ano % 12);
    }

    private void aplicarBonus(int restoAno) {
        boolean achou = false;

        for (Especie especie : Especie.getEspecies()) {
            if (especie.getNomeEspecie().equals(nomesCalendario[restoAno])) {
                especie.bonusAnoChines();
                System.out
                        .println("A espécie " + especie.getNomeEspecie() + " ganhou um bônus de 50% de atrativiidade.");
                achou = true;
            }
        }

        if (!achou) {
            System.out.println("Nenhuma especie pertencente a esse ano se encontra registada.");
        }
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
