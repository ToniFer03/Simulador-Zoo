package com.mycompany.mavenproject1.Menus;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarAnimais;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarCaraEspecie;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarCaraIndividual;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarEspecies;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarInstalacoes;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.DigitarZoo;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados.Voltar;

public class MenuDigitarDados extends MenuBase {

    private Zoo zoo;

    public MenuDigitarDados(Zoo zoo) {
        super();
        this.zoo = zoo;
        addOpcaoMenu(new Voltar());
        addOpcaoMenu(new DigitarAnimais(this));
        addOpcaoMenu(new DigitarEspecies(this));
        addOpcaoMenu(new DigitarInstalacoes(this));
        addOpcaoMenu(new DigitarCaraIndividual(this));
        addOpcaoMenu(new DigitarCaraEspecie(this));
        addOpcaoMenu(new DigitarZoo(this));
    }

    @Override
    public void showMenu() {
        System.out.println("Menu Digitar Dados");
        System.out.println("1 - Digitar Animais");
        System.out.println("2 - Digitar Especies");
        System.out.println("3 - Digitar Instalações");
        System.out.println("4 - Digitar Caracteristicas de Animais");
        System.out.println("5 - Digitar Caracteristicas de Especies");
        System.out.println("6 - Digitar informações do Zoologico");
        System.out.println("7 - Sair");
        System.out.print("Opção: ");
        executeItem(getOption());
    }

    public Zoo getZoo() {
        return this.zoo;
    }

}
