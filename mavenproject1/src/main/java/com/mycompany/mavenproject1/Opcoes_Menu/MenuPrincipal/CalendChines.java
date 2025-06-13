package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

public class CalendChines extends OpcaoMenu {

    private final String[] nomesCalendario;
    private MenuPrincipal menu;

    /**
     * Constructor of class CalendChines, initiates an array of type String with the names of all the chinese animals
     * that are present in the chinese calendar.
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public CalendChines(MenuPrincipal menu) {
        super();
        this.menu = menu;
        this.nomesCalendario = new String[] { "Macaco", "Galo", "Cão", "Porco", "Rato", "Boi", "Tigre", "Coelho",
                "Dragão", "Serpente", "Cavalo", "Carneiro" };
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        showText();
        menu.showMenu();
    }

    /**
     * Asks the user to select a certain year, divides the year for 12 and gives the rest of the division to a function
     * to verify the bonuses
     */
    private void showText() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Digite um ano: ");
        int ano = sc.nextInt();

        //TODO: CHECK MATH
        verificarBonus(ano % 12);
    }

    /**
     * Receives a number that represents the index of the year we want in the chinese calendar, checks for all the
     * species on the Zoo and the ones whose names equal the chinese new year chosen receive a bonus.
     * If no species of that year is found, gives the user that information
     *
     * @param restoAno The number that represents the index of the year we want
     */
    private void verificarBonus(int restoAno) {
        boolean achou = false; // boleans that checks if there is a species that belongs to the year

        for (Especie especie : Especie.getEspecies()) {
            if (especie.getNomeEspecie().equals(nomesCalendario[restoAno])) {
                especie.bonusAnoChines();
                System.out
                        .println("A espécie " + especie.getNomeEspecie() + " ganhou um bônus de 50% de atratividade.");
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
