package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;

//referente a opcao de menu "Construir instalação"
public class Jumanji extends OpcaoMenu {

    private final double propabilidadeFugir = 0.8;
    private MenuPrincipal menu;

    // constructor
    public Jumanji(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        executaJumanji();
        menu.showMenu();
    }

    public void executaJumanji() {
        for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
            for (int j = 0; j < menu.getZoo().getInstalacoes().get(i).getAnimais().size(); j++) {
                if (AuxRand.AnimalFoge(propabilidadeFugir)) {
                    // remove the animal from the installation and add it to the zoo
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
