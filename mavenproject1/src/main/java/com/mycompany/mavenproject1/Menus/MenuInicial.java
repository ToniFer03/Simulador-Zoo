package com.mycompany.mavenproject1.Menus;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial.Cancelar;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial.DadosFicheiro;
import com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial.DigitarDados;

public class MenuInicial extends MenuBase {

    private Zoo zoo;

    /**
     * Constructor of the class MenuInicial, receives an object of type Zoo
     *
     * @param zoo Object of type Zoo that the options on this menu will have an impact on
     */
    public MenuInicial(Zoo zoo) {
        super();
        this.zoo = zoo;
        addOpcaoMenu(new Cancelar());
        addOpcaoMenu(new DadosFicheiro(zoo));
        addOpcaoMenu(new DigitarDados(zoo));
    }

    /**
     * Override of the abstract function show menu in MenuBase, displays the possible options in this menu
     */
    @Override
    public void showMenu() {
        System.out.println("\n");
        System.out.println("Menu Inicial");
        System.out.println("[1] - Ler dados de ficheiro");
        System.out.println("[2] - Digitar dados");
        System.out.println("[0] - Sair");
        System.out.print("Opção: ");
        executeItem(getOption());
    }

    /**
     * @return Object of type Zoo that the actions on this menu Affect
     */
    public Zoo getZoo() {
        return this.zoo;
    }

}
