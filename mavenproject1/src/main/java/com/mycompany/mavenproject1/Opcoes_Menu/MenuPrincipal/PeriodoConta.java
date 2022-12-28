package com.mycompany.mavenproject1.Opcoes_Menu.MenuPrincipal;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.Classes_Aux.AuxRand;
import com.mycompany.mavenproject1.Classes_Aux.ComplexMath;
import com.mycompany.mavenproject1.Classes_Principais.Animal;
import java.util.ArrayList;

//referente a opcao de menu "Construir instalação"
public class PeriodoConta extends OpcaoMenu {

    private MenuPrincipal menu;

    // constructor
    public PeriodoConta(MenuPrincipal menu) {
        super();
        this.menu = menu;
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        double dinheiro;
        dinheiro = calculcarCustos();
        dinheiro += calcularGanhos();
        Historico.addSaldoContabilistico(dinheiro);
        atualizarProbFugir(dinheiro);
        morteAnimal();
        nasceAnimal();
        increaseAge();
        fogeAnimal();
        menu.showMenu();
    }

    private void increaseAge() {
        for (Animal a : menu.getZoo().getTodosAnimais()) {
            a.aumentarIdade();
        }
    }

    private double calculcarCustos() {
        double custoTotal = 0;

        // calcular custo das instalacoes
        for (Instalacao i : menu.getZoo().getInstalacoes()) {
            custoTotal += i.getCustoTrabalhadores() + i.getCustoLimpeza();
        }

        // calcular custo dos animais
        for (Animal a : menu.getZoo().getAnimaisSemInstacao()) {
            custoTotal += a.calculateCustoRacao();
        }

        menu.getZoo().decreaseZooMoney(custoTotal);
        return custoTotal;
    }

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

    private void atualizarProbFugir(double valor) {
        if (valor < 0) {
            if (menu.getZoo().getProbFugir() > 0.94)
                menu.getZoo().setProbFugir(menu.getZoo().getProbFugir() + 0.05);
        } else {
            if (menu.getZoo().getProbFugir() < 0.06)
                menu.getZoo().setProbFugir(menu.getZoo().getProbFugir() - 0.05);
        }

    }

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

    // function that checks if a new animal is born and adds it to the zoo
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
