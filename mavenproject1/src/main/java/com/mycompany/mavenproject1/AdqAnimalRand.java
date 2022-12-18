package com.mycompany.mavenproject1;

//referente a opção de menu "Adquirir animal aleatório"
public class AdqAnimalRand extends OpcaoMenu {

    // constructor
    public AdqAnimalRand(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        getRandomAnimals();
        voltarMenu();
    }

    public void getRandomAnimals() {
        Animal a1;
        Animal a2;
        Animal a3;

        a1 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());
        a2 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());
        a3 = new Animal(NomeArtistico.getNome(), AuxRand.randomInt(10), AuxRand.randomEspecie(),
                AuxRand.selectCaracteristicas());

        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());

    }
}
