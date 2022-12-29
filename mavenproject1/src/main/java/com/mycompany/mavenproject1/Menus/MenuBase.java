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

        if (input.hasNextInt()) {
            int option = input.nextInt();
            if (option < opcoesMenu.size() && option >= 0) {
                return option;
            } else {
                System.out.print("Opção não existe, corrija o número inserido: ");
                return getOption();
            }
        } else {
            System.out.print("Opção inválida, favor digite uma opção válida: ");
            return getOption();
        }
    }

    public void executeItem(int menuId) {
        opcoesMenu.get(menuId).executarOpcao();
    }

    public void addOpcaoMenu(OpcaoMenu opcaoMenu) {
        opcoesMenu.add(opcaoMenu);
    }

    public ArrayList<OpcaoMenu> getOpcoesMenu() {
        return opcoesMenu;
    }

}
