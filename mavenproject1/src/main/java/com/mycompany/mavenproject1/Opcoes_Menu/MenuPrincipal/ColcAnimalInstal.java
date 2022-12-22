package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

//referente a opcaao de menu "Colocar animal em instalação"
public class ColcAnimalInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public ColcAnimalInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        mostrarAnimais();
        voltarMenu();
    }

    private int mostrarInstalacoes() {
        System.out.println("Instalações no zoo: ");
        for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
            System.out.println(menu.getZoo().getInstalacao(i).toString());
        }
        System.out.print("Escolha uma instalação: ");
        Scanner sc = new Scanner(System.in);
        int idInstalacao = sc.nextInt();
        return idInstalacao;

    }

    private void mostrarAnimais() {
        System.out.println("Animais no zoo: ");
        for (int i = 0; i < menu.getZoo().getAnimaisSemInstacao().size(); i++) {
            System.out.println(menu.getZoo().getAnimaisSemInstacao(i).toString());
        }
        System.out.print("Escolha um animal: ");
        Scanner sc = new Scanner(System.in);
        int idAnimal = sc.nextInt();
        colocarAnimal(idAnimal, mostrarInstalacoes());

    }

    private void colocarAnimal(int idAnimal, int idInstalacao) {
        Animal ani = menu.getZoo().getAnimal(idAnimal);
        Instalacao instal = menu.getZoo().getInstalacao(idInstalacao);

        instal.addAnimal(ani, idInstalacao);
        menu.getZoo().removerAnimalSemInstalacao(ani);
        System.out.println(instal.toString());
    }

    // function to go back
    @Override
    public void voltarMenu() {
        menu.showMenu();
    }
}
