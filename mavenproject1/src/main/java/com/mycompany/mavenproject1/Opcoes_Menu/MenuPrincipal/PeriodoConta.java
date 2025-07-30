package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Aux.ComplexMath;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import java.util.ArrayList;

public class PeriodoConta extends OpcaoMenu {

    private MenuPrincipal menu;

    /**
     * Constructor of class PeriodoConta
     *
     * @param menu Object that represents the previous menu that called this option
     */
    public PeriodoConta(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, executes the function regarding this option and goes back to the
     * previous menu after it is completed.
     */
    @Override
    public void executarOpcao() {
        double dinheiro;
        dinheiro = -calculcarCustos();
        dinheiro += calcularGanhos();
        dinheiro += menu.getZoo().getSaldoContabilistico();
        Historico.addSaldoContabilistico(dinheiro);
        atualizarProbFugir(dinheiro);
        morteAnimal();
        nasceAnimal();
        increaseAge();
        fogeAnimal();
        String mensagemSaldo = "Novo saldo é ";
        mensagemSaldo = mensagemSaldo + dinheiro;
        System.out.println(mensagemSaldo);
        System.out.println("Periodo contabilistico terminado.");
        menu.showMenu();
    }

    /**
     * Increases the age of all animals by 1
     */
    private void increaseAge() {
        for (Animal a : menu.getZoo().getTodosAnimais()) {
            a.aumentarIdade();
        }
    }

    /**
     * Calculates the costs of running the Zoo for 1 year, first the costs of the enclosures and then the costs of
     * feeding the animals that are not in the enclousres. In the end, decrease the zoo's current account by that value.
     * @return
     */
    private double calculcarCustos() {
        double custoTotal = 0;

        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            custoTotal += i.getCustoTrabalhadores() + i.getCustoLimpeza();
        }

        for (Animal a : menu.getZoo().getAnimaisSemInstacao()) {
            custoTotal += a.calculateCustoRacao();
        }

        menu.getZoo().decreaseZooMoney(custoTotal);
        return custoTotal;
    }

    /**
     * Calculates all the money the Zoo broth in a year based on the animals the Zoo has on the enclosures.
     * Note: Since the animal that are not in the enclosures are not displayed they don't generate any money for the Zoo
     * @return
     */
    private double calcularGanhos() {
        double ganhoTotal = 0;
        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            for (Animal a : i.getAnimais()) {
                ganhoTotal += a.calculatAtratividade() * 2;
            }
        }

        menu.getZoo().increaseZooMoney(ganhoTotal);
        return ganhoTotal;
    }

    /**
     * Updates the Zoo's probability of an animal escaping by increasing or decreasing it by 5% depending on the money
     * the Zoo gained/lost in the last year. If the Zoo made money the conditions of the Zoo will improve the animals
     * will be less likely to escape if the Zoo lost money the condition will worsen and the animals will be more
     * likely to escape.
     *
     * @param valor Represents the money the Zoo gained or lost
     */
    private void atualizarProbFugir(double valor) {
        if (valor < 0) {
            menu.getZoo().setProbFugir(menu.getZoo().getProbFugir() + 0.05);
            if (menu.getZoo().getProbFugir() > 1)
                menu.getZoo().setProbFugir(1);
        } else {
            menu.getZoo().setProbFugir(menu.getZoo().getProbFugir() - 0.05);
            if (menu.getZoo().getProbFugir() < 0)
                menu.getZoo().setProbFugir(0);
        }

    }

    /**
     * For all animals calculate if they will die or not based on their age and life expectancy of the species
     */
    private void morteAnimal() {
        ArrayList<Animal> animaisMortos = new ArrayList<>();

        for (Animal a : menu.getZoo().getTodosAnimais()) {
            if (AuxRand.isAnimalDead(ComplexMath.calculateProbabilityDeath(a.getIdade(), a.getEsperancaVida()))) {
                animaisMortos.add(a);
            }
        }

        for (Animal b : animaisMortos) {
            menu.getZoo().removeAnimal(b);
        }
    }

    /**
     * For all animals calculate if they will have a baby or not
     */
    private void nasceAnimal() {
        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            if (i.getAnimais().size() > 1) {
                if (AuxRand.isAnimalBorn(i.getAnimais(0).getProbNascimento())) {
                    Animal a = AuxRand.randomAnimal(i.getAnimais(0).getEspecie());
                    menu.getZoo().addAnimalZoo(a);
                    Historico.addAnimalNascido(a);
                }
            }
        }
    }

    /**
     * For all animals in enclosures calculate if they will escape their enclosure or not
     */
    private void fogeAnimal() {
        for (int i = 0; i < menu.getZoo().getInstalacoes().size(); i++) {
            for (int j = 0; j < menu.getZoo().getInstalacoes().get(i).getAnimais().size(); j++) {
                if (AuxRand.AnimalFoge(menu.getZoo().getProbFugir())) {
                    Historico.addAnimalFugido(menu.getZoo().getInstalacoes().get(i).getAnimais().get(j));
                    menu.getZoo().animalFugiu(menu.getZoo().getInstalacoes().get(i).getAnimais().get(j));

                }
            }
        }
    }
}
