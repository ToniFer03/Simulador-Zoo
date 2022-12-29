package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

//referente a opção de menu "Calendário Chinês"
public class CalendChines extends OpcaoMenu {

    private final String[] nomesCalendario;
    private MenuPrincipal menu;

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
        menu.showMenu();
    }

    // function that shows the text of this option
    private void showText() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Digite um ano: ");
        int ano = sc.nextInt();

        verificarBonus(ano % 12);
    }

    private void verificarBonus(int restoAno) {
        boolean achou = false; // boleans that checks if there is a species that belongs to the year

        for (Especie especie : Especie.getEspecies()) {
            if (especie.getNomeEspecie().equals(nomesCalendario[restoAno])) {
                especie.bonusAnoChines();
                System.out
                        .println("A espécie " + especie.getNomeEspecie() + " ganhou um bônus de 50% de atrativiidade.");
                especie.bonusAnoChines();
                achou = true;
            }
        }

        if (!achou) {
            System.out.println(
                    "Nenhuma especie pertencente a esse ano se encontra registada. (" + nomesCalendario[restoAno]
                            + ")");
        }
    }

}
