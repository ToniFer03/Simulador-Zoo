package com.mycompany.mavenproject1.Menus;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuBase {
    private ArrayList<OpcaoMenu> opcoesMenu;

    public MenuBase() {
        opcoesMenu = new ArrayList<OpcaoMenu>();
    }

    public abstract void showMenu();

    public int getOption() {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        return option;
    }

    public void executeItem(int menuId) {
        opcoesMenu.get(menuId).executarOpcao();
    }

    public void addOpcaoMenu(OpcaoMenu opcaoMenu) {
        opcoesMenu.add(opcaoMenu);
    }
}
