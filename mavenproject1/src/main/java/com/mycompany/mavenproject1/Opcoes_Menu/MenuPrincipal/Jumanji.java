package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

public class Jumanji extends OpcaoMenu {

    private final double propabilidadeFugir = 0.8;
    private MenuPrincipal menu;

    /**
     * Constructor of class Jumanji
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public Jumanji(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        executaJumanji();
        menu.showMenu();
    }

    /**
     * For all the animals in the enclosures gives them a probability of escaping their facilities and if they escape
     * add them to the list of all animals without an enclosure
     */
    public void executaJumanji() {
        for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
            for (int j = 0; j < menu.getZoo().getInstalacoes().get(i).getAnimais().size(); j++) {
                if (AuxRand.AnimalFoge(propabilidadeFugir)) {
                    menu.getZoo().getAnimaisSemInstacao()
                            .add(menu.getZoo().getInstalacoes().get(i).getAnimais().get(j));
                    menu.getZoo().getInstalacoes().get(i).getAnimais().remove(j);
                } else {
                    Historico.addAnimalFugido(menu.getZoo().getInstalacoes().get(i).getAnimais().get(j));
                    menu.getZoo().animalFugiu(menu.getZoo().getInstalacoes().get(i).getAnimais().get(j));

                }
            }
        }
    }
}
