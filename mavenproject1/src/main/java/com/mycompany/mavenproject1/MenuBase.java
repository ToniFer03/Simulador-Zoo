package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuBase {
    private int menuId;

    private ArrayList<OpcaoMenu> opcoesMenu;

    public MenuBase() {
        opcoesMenu = new ArrayList<OpcaoMenu>();
    }

    public abstract void showMenu();

    private int getOption() {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        return option;
    }

    private void executeItem(int menuId) {
        opcoesMenu.get(menuId).executarOpcao();
    }
}
