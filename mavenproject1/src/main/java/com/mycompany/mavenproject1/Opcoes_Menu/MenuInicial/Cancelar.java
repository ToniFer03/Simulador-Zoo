package com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial;

import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class Cancelar extends OpcaoMenu {

    public Cancelar() {
        super();
    }

    @Override
    public void executarOpcao() {
        System.out.println("Saindo...");
        System.exit(0);
    }

}
