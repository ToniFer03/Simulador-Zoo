package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuBase {
    private int menuId;

    private ArrayList<OpcaoMenu> opcoesMenu;

    public MenuBase() {
        menuId = 0;
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

    // getters and setters
    public int getMenuId() {
        return menuId;
    }

    public ArrayList<OpcaoMenu> getOpcoesMenu() {
        return opcoesMenu;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void addOpcaoMenu(OpcaoMenu opcaoMenu) {
        opcoesMenu.add(opcaoMenu);
    }
}
