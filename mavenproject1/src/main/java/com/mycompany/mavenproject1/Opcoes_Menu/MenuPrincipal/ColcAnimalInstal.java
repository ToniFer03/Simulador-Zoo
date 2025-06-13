package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

public class ColcAnimalInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ColcAnimalInstal
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ColcAnimalInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        mostrarAnimais();
        menu.showMenu();
    }

    /**
     * Function that shows all the enclosures that exist in the Zoo to the user as well as the information regarding
     * each one of them
     *
     * @return The id of the enclosure that was chosen by the user
     */
    private int mostrarInstalacoes() {
        if (menu.getZoo().getInstalacoes().size() == 0) {
            System.out.println("Não existem instalações no zoo.");
            return -1;
        } else {
            // text to show the user the installations
            System.out.println("\n");
            System.out.println("Instalações no zoo: ");
            System.out.println("--------------------------------------------");
            for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
                System.out.println(menu.getZoo().getInstalacoes(i).basicInfo());
            }
            System.out.print("Escolha uma instalação: ");
            Scanner sc = new Scanner(System.in);
            int idInstalacao = sc.nextInt();

            // check if the installation exists
            if (menu.getZoo().getInstalacoes(idInstalacao) == null) {
                System.out.println("Instalação não existe, por favor selecione uma instalação válida!");
                return mostrarInstalacoes(); // recursive call if the installation doesn't exist
            } else {
                return idInstalacao; // return the installation id
            }
        }
    }

    /**
     * Shows the user all the animals without an enclosure, if all the animals have an enclosure give that information
     * to the user and show the previous menu.
     * If there are animals without an enclosure, show them to the user and ask him to choose one of the animals, calls
     * a function to show all the enclosures in the Zoo and another one to choose an enclosure for the animal to stay in.
     */
    private void mostrarAnimais() {
        if (menu.getZoo().getAnimaisSemInstacao().size() == 0) {
            System.out.println("Não existem animais sem instalação.");
            menu.showMenu();
        } else {
            System.out.println("\n");
            System.out.println("Animais no zoo: ");
            System.out.println("--------------------------------------------");
            for (Animal a : menu.getZoo().getAnimaisSemInstacao()) {
                System.out.println(a.basicInfo());
            }
            System.out.print("Escolha um animal: ");
            Scanner sc = new Scanner(System.in);
            int idAnimal = sc.nextInt();

            if (menu.getZoo().getAnimaisSemInstacao(idAnimal) == null) {
                System.out.println("Animal não existe, por favor selecione um animal válido!");
                mostrarAnimais();
            } else {
                int idInstalacao = mostrarInstalacoes();
                if (idInstalacao == -1) {
                    menu.showMenu();
                } else {
                    colocarAnimal(idAnimal, idInstalacao);

                }

            }
        }
    }

    /**
     * Receives the id of the animal and the enclosure that was chosen and puts the animal inside that enclosure. In
     * case there is no more space in the enclosure that was chosen, give that information to the user
     *
     * @param idAnimal ID of the animal that was chosen by the user
     * @param idInstalacao ID of the enclousre that was choosen by the user
     */
    private void colocarAnimal(int idAnimal, int idInstalacao) {
        Animal ani = menu.getZoo().getTodosAnimais(idAnimal);
        Instalacao instal = menu.getZoo().getInstalacoes(idInstalacao);

        if (instal.getAnimais().size() <= instal.getLotacaoMaxima()) {
            System.out.println("Animal colocado com sucesso.");
            instal.addAnimal(ani);
            menu.getZoo().removerAnimalSemInstalacao(ani);
        } else {
            System.out.println("O animal não pode ser colocado nesta instalação.");
        }
    }
}
