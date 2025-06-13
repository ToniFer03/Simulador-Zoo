package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class ListInstal extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class ListInstal
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public ListInstal(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        showInstalacoes();
        menu.showMenu();
    }

    /**
     * Shows all the enclosures in the Zoo to the user
     */
    private void showInstalacoes() {
        if (menu.getZoo().getInstalacoes().isEmpty()) {
            System.out.println("Não existem instalações registadas.");
            menu.showMenu();
        } else {
            System.out.println("\n");
            System.out.println("As instalações que este zoo possui são: ");
            for (Instalacao inst : menu.getZoo().getInstalacoes()) {
                System.out.println("----------------------------------------");
                System.out.print(inst.basicInfo());
                System.out.println("----------------------------------------\n");
            }
        }
    }
}
