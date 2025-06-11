package com.mycompany.mavenproject1.Menus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class that will serve as a base for all the menus to implement, has a list of abstract OpcaoMenu objects
 * that will serve as all possible options in a menu, and functions to display, receive inputs and execute them
 */
public abstract class MenuBase {
    private ArrayList<OpcaoMenu> opcoesMenu;

    /**
     * Constructor of the abstract class MenuBase, creates a list of Abstract OpcaoMenu objects that will represent all
     * the possible options that a user can choose.
     */
    public MenuBase() {
        opcoesMenu = new ArrayList<OpcaoMenu>();
    }

    /**
     * Abstract function to be implemented by all the subclasses to show the Menu to the user
     */
    public abstract void showMenu();

    /**
     * Function to get option the user chose from the console, checks if the option is valid and if it is return the
     * number, if not display an error message to the user and ask him to type a valid answer
     *
     * @return The option chosen by the user
     */
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

    /**
     * Executes an option from the list of menu option the menu has
     *
     * @param menuId Number of the option to be executed
     */
    public void executeItem(int menuId) {
        opcoesMenu.get(menuId).executarOpcao();
    }

    /**
     * Function to be called on the constructor of every menu that extends this one, allows it to add all the options
     * of the menu to the list to be executed
     *
     * @param opcaoMenu Menu option that can be chosen and executed
     */
    public void addOpcaoMenu(OpcaoMenu opcaoMenu) {
        opcoesMenu.add(opcaoMenu);
    }

    /**
     * @return Returns the list containing all the options of a menu
     */
    public ArrayList<OpcaoMenu> getOpcoesMenu() {
        return opcoesMenu;
    }

}
